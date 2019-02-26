/**
 * GetBankListResponseInformationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class GetBankListResponseInformationType  implements java.io.Serializable {
    private java.lang.String financialInstitutionCode;

    private java.lang.String financialInstitutionName;

    public GetBankListResponseInformationType() {
    }

    public GetBankListResponseInformationType(
           java.lang.String financialInstitutionCode,
           java.lang.String financialInstitutionName) {
           this.financialInstitutionCode = financialInstitutionCode;
           this.financialInstitutionName = financialInstitutionName;
    }


    /**
     * Gets the financialInstitutionCode value for this GetBankListResponseInformationType.
     * 
     * @return financialInstitutionCode
     */
    public java.lang.String getFinancialInstitutionCode() {
        return financialInstitutionCode;
    }


    /**
     * Sets the financialInstitutionCode value for this GetBankListResponseInformationType.
     * 
     * @param financialInstitutionCode
     */
    public void setFinancialInstitutionCode(java.lang.String financialInstitutionCode) {
        this.financialInstitutionCode = financialInstitutionCode;
    }


    /**
     * Gets the financialInstitutionName value for this GetBankListResponseInformationType.
     * 
     * @return financialInstitutionName
     */
    public java.lang.String getFinancialInstitutionName() {
        return financialInstitutionName;
    }


    /**
     * Sets the financialInstitutionName value for this GetBankListResponseInformationType.
     * 
     * @param financialInstitutionName
     */
    public void setFinancialInstitutionName(java.lang.String financialInstitutionName) {
        this.financialInstitutionName = financialInstitutionName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetBankListResponseInformationType)) return false;
        GetBankListResponseInformationType other = (GetBankListResponseInformationType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.financialInstitutionCode==null && other.getFinancialInstitutionCode()==null) || 
             (this.financialInstitutionCode!=null &&
              this.financialInstitutionCode.equals(other.getFinancialInstitutionCode()))) &&
            ((this.financialInstitutionName==null && other.getFinancialInstitutionName()==null) || 
             (this.financialInstitutionName!=null &&
              this.financialInstitutionName.equals(other.getFinancialInstitutionName())));
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
        if (getFinancialInstitutionCode() != null) {
            _hashCode += getFinancialInstitutionCode().hashCode();
        }
        if (getFinancialInstitutionName() != null) {
            _hashCode += getFinancialInstitutionName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetBankListResponseInformationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getBankListResponseInformationType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("financialInstitutionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "financialInstitutionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("financialInstitutionName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "financialInstitutionName"));
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
