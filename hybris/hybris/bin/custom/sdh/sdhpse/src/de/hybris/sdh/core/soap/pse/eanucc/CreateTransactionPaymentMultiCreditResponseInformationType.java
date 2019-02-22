/**
 * CreateTransactionPaymentMultiCreditResponseInformationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class CreateTransactionPaymentMultiCreditResponseInformationType  implements java.io.Serializable {
    private java.lang.String trazabilityCode;

    private de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseReturnCodeList returnCode;

    private java.lang.String returnCodeDetails;

    private java.lang.String bankurl;

    private java.lang.String transactionCycle;

    public CreateTransactionPaymentMultiCreditResponseInformationType() {
    }

    public CreateTransactionPaymentMultiCreditResponseInformationType(
           java.lang.String trazabilityCode,
           de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseReturnCodeList returnCode,
           java.lang.String returnCodeDetails,
           java.lang.String bankurl,
           java.lang.String transactionCycle) {
           this.trazabilityCode = trazabilityCode;
           this.returnCode = returnCode;
           this.returnCodeDetails = returnCodeDetails;
           this.bankurl = bankurl;
           this.transactionCycle = transactionCycle;
    }


    /**
     * Gets the trazabilityCode value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @return trazabilityCode
     */
    public java.lang.String getTrazabilityCode() {
        return trazabilityCode;
    }


    /**
     * Sets the trazabilityCode value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @param trazabilityCode
     */
    public void setTrazabilityCode(java.lang.String trazabilityCode) {
        this.trazabilityCode = trazabilityCode;
    }


    /**
     * Gets the returnCode value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @return returnCode
     */
    public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseReturnCodeList getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @param returnCode
     */
    public void setReturnCode(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseReturnCodeList returnCode) {
        this.returnCode = returnCode;
    }


    /**
     * Gets the returnCodeDetails value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @return returnCodeDetails
     */
    public java.lang.String getReturnCodeDetails() {
        return returnCodeDetails;
    }


    /**
     * Sets the returnCodeDetails value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @param returnCodeDetails
     */
    public void setReturnCodeDetails(java.lang.String returnCodeDetails) {
        this.returnCodeDetails = returnCodeDetails;
    }


    /**
     * Gets the bankurl value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @return bankurl
     */
    public java.lang.String getBankurl() {
        return bankurl;
    }


    /**
     * Sets the bankurl value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @param bankurl
     */
    public void setBankurl(java.lang.String bankurl) {
        this.bankurl = bankurl;
    }


    /**
     * Gets the transactionCycle value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @return transactionCycle
     */
    public java.lang.String getTransactionCycle() {
        return transactionCycle;
    }


    /**
     * Sets the transactionCycle value for this CreateTransactionPaymentMultiCreditResponseInformationType.
     * 
     * @param transactionCycle
     */
    public void setTransactionCycle(java.lang.String transactionCycle) {
        this.transactionCycle = transactionCycle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateTransactionPaymentMultiCreditResponseInformationType)) return false;
        CreateTransactionPaymentMultiCreditResponseInformationType other = (CreateTransactionPaymentMultiCreditResponseInformationType) obj;
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
            ((this.returnCodeDetails==null && other.getReturnCodeDetails()==null) || 
             (this.returnCodeDetails!=null &&
              this.returnCodeDetails.equals(other.getReturnCodeDetails()))) &&
            ((this.bankurl==null && other.getBankurl()==null) || 
             (this.bankurl!=null &&
              this.bankurl.equals(other.getBankurl()))) &&
            ((this.transactionCycle==null && other.getTransactionCycle()==null) || 
             (this.transactionCycle!=null &&
              this.transactionCycle.equals(other.getTransactionCycle())));
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
        if (getReturnCodeDetails() != null) {
            _hashCode += getReturnCodeDetails().hashCode();
        }
        if (getBankurl() != null) {
            _hashCode += getBankurl().hashCode();
        }
        if (getTransactionCycle() != null) {
            _hashCode += getTransactionCycle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateTransactionPaymentMultiCreditResponseInformationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentMultiCreditResponseInformationType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trazabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "trazabilityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentMultiCreditResponseReturnCodeList"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnCodeDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCodeDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankurl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "bankurl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionCycle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "transactionCycle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
