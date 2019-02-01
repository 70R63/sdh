/**
 * ConfirmTransactionPaymentFDResponseInformationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class ConfirmTransactionPaymentFDResponseInformationType  implements java.io.Serializable {
    private java.lang.String trazabilityCode;

    private de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseReturnCodeList returnCode;

    private de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDTransactionStateCodeList transactionState;

    public ConfirmTransactionPaymentFDResponseInformationType() {
    }

    public ConfirmTransactionPaymentFDResponseInformationType(
           java.lang.String trazabilityCode,
           de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseReturnCodeList returnCode,
           de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDTransactionStateCodeList transactionState) {
           this.trazabilityCode = trazabilityCode;
           this.returnCode = returnCode;
           this.transactionState = transactionState;
    }


    /**
     * Gets the trazabilityCode value for this ConfirmTransactionPaymentFDResponseInformationType.
     * 
     * @return trazabilityCode
     */
    public java.lang.String getTrazabilityCode() {
        return trazabilityCode;
    }


    /**
     * Sets the trazabilityCode value for this ConfirmTransactionPaymentFDResponseInformationType.
     * 
     * @param trazabilityCode
     */
    public void setTrazabilityCode(java.lang.String trazabilityCode) {
        this.trazabilityCode = trazabilityCode;
    }


    /**
     * Gets the returnCode value for this ConfirmTransactionPaymentFDResponseInformationType.
     * 
     * @return returnCode
     */
    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseReturnCodeList getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this ConfirmTransactionPaymentFDResponseInformationType.
     * 
     * @param returnCode
     */
    public void setReturnCode(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseReturnCodeList returnCode) {
        this.returnCode = returnCode;
    }


    /**
     * Gets the transactionState value for this ConfirmTransactionPaymentFDResponseInformationType.
     * 
     * @return transactionState
     */
    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDTransactionStateCodeList getTransactionState() {
        return transactionState;
    }


    /**
     * Sets the transactionState value for this ConfirmTransactionPaymentFDResponseInformationType.
     * 
     * @param transactionState
     */
    public void setTransactionState(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDTransactionStateCodeList transactionState) {
        this.transactionState = transactionState;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfirmTransactionPaymentFDResponseInformationType)) return false;
        ConfirmTransactionPaymentFDResponseInformationType other = (ConfirmTransactionPaymentFDResponseInformationType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.trazabilityCode==null && other.getTrazabilityCode()==null) || 
             (this.trazabilityCode!=null &&
              this.trazabilityCode.equals(other.getTrazabilityCode()))) &&
            ((this.returnCode==null && other.getReturnCode()==null) || 
             (this.returnCode!=null &&
              this.returnCode.equals(other.getReturnCode()))) &&
            ((this.transactionState==null && other.getTransactionState()==null) || 
             (this.transactionState!=null &&
              this.transactionState.equals(other.getTransactionState())));
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
        if (getTrazabilityCode() != null) {
            _hashCode += getTrazabilityCode().hashCode();
        }
        if (getReturnCode() != null) {
            _hashCode += getReturnCode().hashCode();
        }
        if (getTransactionState() != null) {
            _hashCode += getTransactionState().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfirmTransactionPaymentFDResponseInformationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDResponseInformationType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trazabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "trazabilityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDResponseReturnCodeList"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "transactionState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDTransactionStateCodeList"));
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
