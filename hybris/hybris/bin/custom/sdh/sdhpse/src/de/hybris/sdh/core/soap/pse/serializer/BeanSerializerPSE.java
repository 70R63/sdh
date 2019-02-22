package de.hybris.sdh.core.soap.pse.serializer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.namespace.QName;

import org.apache.axis.Constants;
import org.apache.axis.description.FieldDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.SerializationContext;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.apache.axis.message.MessageElement;
import org.apache.axis.utils.BeanPropertyDescriptor;
import org.apache.axis.utils.Messages;
import org.xml.sax.Attributes;

/**
 * General purpose serializer/deserializerFactory for an arbitrary java bean.
 *
 * @author Sam Ruby <rubys@us.ibm.com>
 * @author Rich Scheuerle <scheu@us.ibm.com>
 * @author Tom Jordahl <tomj@macromedia.com>
 */
public class BeanSerializerPSE extends BeanSerializer {

    // Construct BeanSerializer for the indicated class/qname
    public BeanSerializerPSE(Class javaType, QName xmlType) {
        super( javaType, xmlType );
    }

    // Construct BeanSerializer for the indicated class/qname
    public BeanSerializerPSE(Class javaType, QName xmlType, TypeDesc typeDesc) {
    	super( javaType, xmlType, typeDesc );
    }

    // Construct BeanSerializer for the indicated class/qname/propertyDesc
    public BeanSerializerPSE(Class javaType, QName xmlType, TypeDesc typeDesc,
                          BeanPropertyDescriptor[] propertyDescriptor) {
        super( javaType, xmlType, typeDesc, propertyDescriptor );
    }

    /**
     * Serialize a bean.  Done simply by serializing each bean property.
     * @param name is the element name
     * @param attributes are the attributes...serialize is free to add more.
     * @param value is the value
     * @param context is the SerializationContext
     */
    public void serialize(QName name, Attributes attributes,
                          Object value, SerializationContext context)
        throws IOException
    {
    	/*
    	String prefix = context.getPrefixForURI("ns=http://www.uc-council.org/smp/schemas/eanucc");
    	if( prefix.length()==0 )
    		context.registerPrefixForURI("eanucc","ns=http://www.uc-council.org/smp/schemas/eanucc");
		prefix = context.getPrefixForURI("ns=http://www.uc-council.org/smp/schemas/eanucc");
		*/
		//context.registerPrefixForURI("eanucc","http://www.uc-council.org/smp/schemas/eanucc");
		
        // Check for meta-data in the bean that will tell us if any of the
        // properties are actually attributes, add those to the element
        // attribute list
        Attributes beanAttrs = getObjectAttributes(value, attributes, context);

        // Get the encoding style
        String encodingStyle = context.getMessageContext().getEncodingStyle();
        boolean isEncoded = Constants.isSOAP_ENC(encodingStyle);

        // check whether we have and xsd:any namespace="##any" type
        boolean suppressElement = !context.getMessageContext().isEncoded() &&
                                  name.getNamespaceURI().equals("") &&
                                  name.getLocalPart().equals("any");

        if (!suppressElement)
            context.startElement(name, beanAttrs);

        try {
            // Serialize each property
            for (int i=0; i<propertyDescriptor.length; i++) {
                String propName = propertyDescriptor[i].getName();
                if (propName.equals("class"))
                    continue;
                QName qname = null;
                QName xmlType = null;
                boolean isOmittable = false;

                // If we have type metadata, check to see what we're doing
                // with this field.  If it's an attribute, skip it.  If it's
                // an element, use whatever qname is in there.  If we can't
                // find any of this info, use the default.

                if (typeDesc != null) {
                    FieldDesc field = typeDesc.getFieldByName(propName);
                    if (field != null) {
                        if (!field.isElement())
                            continue;

                        // If we're SOAP encoded, just use the local part,
                        // not the namespace.  Otherwise use the whole
                        // QName.
                        /*
                        if (isEncoded) {
                            qname = new QName(
                                          field.getXmlName().getLocalPart());
                        } else {
                            qname = field.getXmlName();
                        }
                        */
                        if( field.getXmlName().getNamespaceURI().equals("") )
                        {
							qname = new QName(name.getNamespaceURI(), field.getXmlName().getLocalPart());
                        }
                        else
                        {
							qname = field.getXmlName();
                        }
						//qname = new QName( qname.getNamespaceURI(), "eanucc:"+qname.getLocalPart() );
                        						
                        isOmittable = field.isMinOccursZero();
                        xmlType = field.getXmlType();
                    }
                } 

                if (qname == null) {
                    // Use the default...
                    // The default qname would inherit the namespace of a
                    // parent. Setting this namespace to "" causes interop
                    // issues when the "literal" style is used - 
                    // most of the elements will be serialised with xmlns=""
                    qname = new QName(name.getNamespaceURI(), propName);
                }

                if (xmlType == null) {
                    // look up the type QName using the class
                    xmlType = context.getQNameForClass(propertyDescriptor[i].getType());
                }

                // Read the value from the property
                if(propertyDescriptor[i].isReadable()) {
                    if (!propertyDescriptor[i].isIndexed()) {
                        // Normal case: serialize the value
                        Object propValue =
                            propertyDescriptor[i].get(value);
                        // if meta data says minOccurs=0, then we can skip
                        // it if its value is null and we aren't doing SOAP
                        // encoding.
                        if (propValue == null &&
                                isOmittable &&
                                !isEncoded)
                            continue;

                        context.serialize(qname,
                                          null,
                                          propValue,
                                          xmlType,
                                          true,
                                          null);
                    } else {
                        // Collection of properties: serialize each one
                        int j=0;
                        while(j >= 0) {
                            Object propValue = null;
                            try {
                                propValue =
                                    propertyDescriptor[i].get(value, j);
                                j++;
                            } catch (Exception e) {
                                j = -1;
                            }
                            if (j >= 0) {
                                context.serialize(qname, null,
                                                  propValue, xmlType,
                                                  true, null);
                            }
                        }
                    }
                }
            }

            BeanPropertyDescriptor anyDesc = typeDesc == null ? null :
                    typeDesc.getAnyDesc();
            if (anyDesc != null) {
                // If we have "extra" content here, it'll be an array
                // of MessageElements.  Serialize each one.
                Object anyVal = anyDesc.get(value);
                if (anyVal != null && anyVal instanceof MessageElement[]) {
                    MessageElement [] anyContent = (MessageElement[])anyVal;
                    for (int i = 0; i < anyContent.length; i++) {
                        MessageElement element = anyContent[i];
                        element.output(context);
                    }
                }
            }
        } catch (InvocationTargetException ite) {
            Throwable target = ite.getTargetException();
            log.error(Messages.getMessage("exception00"), target);
            throw new IOException(target.toString());
        } catch (Exception e) {
            log.error(Messages.getMessage("exception00"), e);
            throw new IOException(e.toString());
        }

        if (!suppressElement)
            context.endElement();
    }
}