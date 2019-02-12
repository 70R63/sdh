/**
 * GetTransactionInformationDetailedResponseBodyType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class GetTransactionInformationDetailedResponseBodyType  implements java.io.Serializable {
    private de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseFieldType[] field;

    private de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseReturnCodeList returnCode;

    public GetTransactionInformationDetailedResponseBodyType() {
    }

    public GetTransactionInformationDetailedResponseBodyType(
           de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseFieldType[] field,
           de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseReturnCodeList returnCode) {
           this.field = field;
           this.returnCode = returnCode;
    }


    /**
     * Gets the field value for this GetTransactionInformationDetailedResponseBodyType.
     * 
     * @return field
     */
    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseFieldType[] getField() {
        return field;
    }


    /**
     * Sets the field value for this GetTransactionInformationDetailedResponseBodyType.
     * 
     * @param field
     */
    public void setField(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseFieldType[] field) {
        this.field = field;
    }

    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseFieldType getField(int i) {
        return this.field[i];
    }

    public void setField(int i, de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseFieldType _value) {
        this.field[i] = _value;
    }


    /**
     * Gets the returnCode value for this GetTransactionInformationDetailedResponseBodyType.
     * 
     * @return returnCode
     */
    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseReturnCodeList getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this GetTransactionInformationDetailedResponseBodyType.
     * 
     * @param returnCode
     */
    public void setReturnCode(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseReturnCodeList returnCode) {
        this.returnCode = returnCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTransactionInformationDetailedResponseBodyType)) return false;
        GetTransactionInformationDetailedResponseBodyType other = (GetTransactionInformationDetailedResponseBodyType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.field==null && other.getField()==null) || 
             (this.field!=null &&
              java.util.Arrays.equals(this.field, other.getField()))) &&
            ((this.returnCode==null && other.getReturnCode()==null) || 
             (this.returnCode!=null &&
              this.returnCode.equals(other.getReturnCode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getField() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getField());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getField(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReturnCode() != null) {
            _hashCode += getReturnCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTransactionInformationDetailedResponseBodyType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseBodyType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("field");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseFieldType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseReturnCodeList"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
