/**
 * ConfirmTransactionPaymentInformationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class ConfirmTransactionPaymentInformationType  implements java.io.Serializable {
    private java.lang.String trazabilityCode;

    private java.lang.String financialInstitutionCode;

    private java.lang.String entityCode;

    private de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue;

    private de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue;

    private org.apache.axis.types.NonNegativeInteger ticketId;

    private java.util.Date soliciteDate;

    private java.util.Date bankProcessDate;

    private de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentTransactionStateCodeList transactionState;

    private java.lang.String authorizationId;

    public ConfirmTransactionPaymentInformationType() {
    }

    public ConfirmTransactionPaymentInformationType(
           java.lang.String trazabilityCode,
           java.lang.String financialInstitutionCode,
           java.lang.String entityCode,
           de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue,
           de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue,
           org.apache.axis.types.NonNegativeInteger ticketId,
           java.util.Date soliciteDate,
           java.util.Date bankProcessDate,
           de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentTransactionStateCodeList transactionState,
           java.lang.String authorizationId) {
           this.trazabilityCode = trazabilityCode;
           this.financialInstitutionCode = financialInstitutionCode;
           this.entityCode = entityCode;
           this.transactionValue = transactionValue;
           this.vatValue = vatValue;
           this.ticketId = ticketId;
           this.soliciteDate = soliciteDate;
           this.bankProcessDate = bankProcessDate;
           this.transactionState = transactionState;
           this.authorizationId = authorizationId;
    }


    /**
     * Gets the trazabilityCode value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return trazabilityCode
     */
    public java.lang.String getTrazabilityCode() {
        return trazabilityCode;
    }


    /**
     * Sets the trazabilityCode value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param trazabilityCode
     */
    public void setTrazabilityCode(java.lang.String trazabilityCode) {
        this.trazabilityCode = trazabilityCode;
    }


    /**
     * Gets the financialInstitutionCode value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return financialInstitutionCode
     */
    public java.lang.String getFinancialInstitutionCode() {
        return financialInstitutionCode;
    }


    /**
     * Sets the financialInstitutionCode value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param financialInstitutionCode
     */
    public void setFinancialInstitutionCode(java.lang.String financialInstitutionCode) {
        this.financialInstitutionCode = financialInstitutionCode;
    }


    /**
     * Gets the entityCode value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return entityCode
     */
    public java.lang.String getEntityCode() {
        return entityCode;
    }


    /**
     * Sets the entityCode value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param entityCode
     */
    public void setEntityCode(java.lang.String entityCode) {
        this.entityCode = entityCode;
    }


    /**
     * Gets the transactionValue value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return transactionValue
     */
    public de.hybris.sdh.core.soap.pse.eanucc.AmountType getTransactionValue() {
        return transactionValue;
    }


    /**
     * Sets the transactionValue value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param transactionValue
     */
    public void setTransactionValue(de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue) {
        this.transactionValue = transactionValue;
    }


    /**
     * Gets the vatValue value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return vatValue
     */
    public de.hybris.sdh.core.soap.pse.eanucc.AmountType getVatValue() {
        return vatValue;
    }


    /**
     * Sets the vatValue value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param vatValue
     */
    public void setVatValue(de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue) {
        this.vatValue = vatValue;
    }


    /**
     * Gets the ticketId value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return ticketId
     */
    public org.apache.axis.types.NonNegativeInteger getTicketId() {
        return ticketId;
    }


    /**
     * Sets the ticketId value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param ticketId
     */
    public void setTicketId(org.apache.axis.types.NonNegativeInteger ticketId) {
        this.ticketId = ticketId;
    }


    /**
     * Gets the soliciteDate value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return soliciteDate
     */
    public java.util.Date getSoliciteDate() {
        return soliciteDate;
    }


    /**
     * Sets the soliciteDate value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param soliciteDate
     */
    public void setSoliciteDate(java.util.Date soliciteDate) {
        this.soliciteDate = soliciteDate;
    }


    /**
     * Gets the bankProcessDate value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return bankProcessDate
     */
    public java.util.Date getBankProcessDate() {
        return bankProcessDate;
    }


    /**
     * Sets the bankProcessDate value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param bankProcessDate
     */
    public void setBankProcessDate(java.util.Date bankProcessDate) {
        this.bankProcessDate = bankProcessDate;
    }


    /**
     * Gets the transactionState value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return transactionState
     */
    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentTransactionStateCodeList getTransactionState() {
        return transactionState;
    }


    /**
     * Sets the transactionState value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param transactionState
     */
    public void setTransactionState(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentTransactionStateCodeList transactionState) {
        this.transactionState = transactionState;
    }


    /**
     * Gets the authorizationId value for this ConfirmTransactionPaymentInformationType.
     * 
     * @return authorizationId
     */
    public java.lang.String getAuthorizationId() {
        return authorizationId;
    }


    /**
     * Sets the authorizationId value for this ConfirmTransactionPaymentInformationType.
     * 
     * @param authorizationId
     */
    public void setAuthorizationId(java.lang.String authorizationId) {
        this.authorizationId = authorizationId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfirmTransactionPaymentInformationType)) return false;
        ConfirmTransactionPaymentInformationType other = (ConfirmTransactionPaymentInformationType) obj;
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
            ((this.financialInstitutionCode==null && other.getFinancialInstitutionCode()==null) || 
             (this.financialInstitutionCode!=null &&
              this.financialInstitutionCode.equals(other.getFinancialInstitutionCode()))) &&
            ((this.entityCode==null && other.getEntityCode()==null) || 
             (this.entityCode!=null &&
              this.entityCode.equals(other.getEntityCode()))) &&
            ((this.transactionValue==null && other.getTransactionValue()==null) || 
             (this.transactionValue!=null &&
              this.transactionValue.equals(other.getTransactionValue()))) &&
            ((this.vatValue==null && other.getVatValue()==null) || 
             (this.vatValue!=null &&
              this.vatValue.equals(other.getVatValue()))) &&
            ((this.ticketId==null && other.getTicketId()==null) || 
             (this.ticketId!=null &&
              this.ticketId.equals(other.getTicketId()))) &&
            ((this.soliciteDate==null && other.getSoliciteDate()==null) || 
             (this.soliciteDate!=null &&
              this.soliciteDate.equals(other.getSoliciteDate()))) &&
            ((this.bankProcessDate==null && other.getBankProcessDate()==null) || 
             (this.bankProcessDate!=null &&
              this.bankProcessDate.equals(other.getBankProcessDate()))) &&
            ((this.transactionState==null && other.getTransactionState()==null) || 
             (this.transactionState!=null &&
              this.transactionState.equals(other.getTransactionState()))) &&
            ((this.authorizationId==null && other.getAuthorizationId()==null) || 
             (this.authorizationId!=null &&
              this.authorizationId.equals(other.getAuthorizationId())));
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
        if (getFinancialInstitutionCode() != null) {
            _hashCode += getFinancialInstitutionCode().hashCode();
        }
        if (getEntityCode() != null) {
            _hashCode += getEntityCode().hashCode();
        }
        if (getTransactionValue() != null) {
            _hashCode += getTransactionValue().hashCode();
        }
        if (getVatValue() != null) {
            _hashCode += getVatValue().hashCode();
        }
        if (getTicketId() != null) {
            _hashCode += getTicketId().hashCode();
        }
        if (getSoliciteDate() != null) {
            _hashCode += getSoliciteDate().hashCode();
        }
        if (getBankProcessDate() != null) {
            _hashCode += getBankProcessDate().hashCode();
        }
        if (getTransactionState() != null) {
            _hashCode += getTransactionState().hashCode();
        }
        if (getAuthorizationId() != null) {
            _hashCode += getAuthorizationId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfirmTransactionPaymentInformationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentInformationType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trazabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "trazabilityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("financialInstitutionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "financialInstitutionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "entityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "transactionValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "AmountType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vatValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "vatValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "AmountType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "ticketId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("soliciteDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "soliciteDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankProcessDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "bankProcessDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "transactionState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentTransactionStateCodeList"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizationId"));
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

	@Override
	public String toString() {
		return "ConfirmTransactionPaymentInformationType [trazabilityCode=" + trazabilityCode
				+ ", financialInstitutionCode=" + financialInstitutionCode + ", entityCode=" + entityCode
				+ ", transactionValue=" + transactionValue + ", vatValue=" + vatValue + ", ticketId=" + ticketId
				+ ", soliciteDate=" + soliciteDate + ", bankProcessDate=" + bankProcessDate + ", transactionState="
				+ transactionState + ", authorizationId=" + authorizationId + ", __equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}
    
    

}
