/**
 * CreateTransactionPaymentInformationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

import java.util.Arrays;

public class CreateTransactionPaymentInformationType  implements java.io.Serializable {
    private java.lang.String financialInstitutionCode;

    private java.lang.String entityCode;

    private java.lang.String serviceCode;

    private de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue;

    private de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue;

    private org.apache.axis.types.NonNegativeInteger ticketId;

    private java.lang.String entityurl;

    private java.lang.String userType;

    private java.lang.String[] referenceNumber;

    private java.util.Date soliciteDate;

    private java.lang.String paymentDescription;

    public CreateTransactionPaymentInformationType() {
    }

    public CreateTransactionPaymentInformationType(
           java.lang.String financialInstitutionCode,
           java.lang.String entityCode,
           java.lang.String serviceCode,
           de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue,
           de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue,
           org.apache.axis.types.NonNegativeInteger ticketId,
           java.lang.String entityurl,
           java.lang.String userType,
           java.lang.String[] referenceNumber,
           java.util.Date soliciteDate,
           java.lang.String paymentDescription) {
           this.financialInstitutionCode = financialInstitutionCode;
           this.entityCode = entityCode;
           this.serviceCode = serviceCode;
           this.transactionValue = transactionValue;
           this.vatValue = vatValue;
           this.ticketId = ticketId;
           this.entityurl = entityurl;
           this.userType = userType;
           this.referenceNumber = referenceNumber;
           this.soliciteDate = soliciteDate;
           this.paymentDescription = paymentDescription;
    }


    /**
     * Gets the financialInstitutionCode value for this CreateTransactionPaymentInformationType.
     * 
     * @return financialInstitutionCode
     */
    public java.lang.String getFinancialInstitutionCode() {
        return financialInstitutionCode;
    }


    /**
     * Sets the financialInstitutionCode value for this CreateTransactionPaymentInformationType.
     * 
     * @param financialInstitutionCode
     */
    public void setFinancialInstitutionCode(java.lang.String financialInstitutionCode) {
        this.financialInstitutionCode = financialInstitutionCode;
    }


    /**
     * Gets the entityCode value for this CreateTransactionPaymentInformationType.
     * 
     * @return entityCode
     */
    public java.lang.String getEntityCode() {
        return entityCode;
    }


    /**
     * Sets the entityCode value for this CreateTransactionPaymentInformationType.
     * 
     * @param entityCode
     */
    public void setEntityCode(java.lang.String entityCode) {
        this.entityCode = entityCode;
    }


    /**
     * Gets the serviceCode value for this CreateTransactionPaymentInformationType.
     * 
     * @return serviceCode
     */
    public java.lang.String getServiceCode() {
        return serviceCode;
    }


    /**
     * Sets the serviceCode value for this CreateTransactionPaymentInformationType.
     * 
     * @param serviceCode
     */
    public void setServiceCode(java.lang.String serviceCode) {
        this.serviceCode = serviceCode;
    }


    /**
     * Gets the transactionValue value for this CreateTransactionPaymentInformationType.
     * 
     * @return transactionValue
     */
    public de.hybris.sdh.core.soap.pse.eanucc.AmountType getTransactionValue() {
        return transactionValue;
    }


    /**
     * Sets the transactionValue value for this CreateTransactionPaymentInformationType.
     * 
     * @param transactionValue
     */
    public void setTransactionValue(de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue) {
        this.transactionValue = transactionValue;
    }


    /**
     * Gets the vatValue value for this CreateTransactionPaymentInformationType.
     * 
     * @return vatValue
     */
    public de.hybris.sdh.core.soap.pse.eanucc.AmountType getVatValue() {
        return vatValue;
    }


    /**
     * Sets the vatValue value for this CreateTransactionPaymentInformationType.
     * 
     * @param vatValue
     */
    public void setVatValue(de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue) {
        this.vatValue = vatValue;
    }


    /**
     * Gets the ticketId value for this CreateTransactionPaymentInformationType.
     * 
     * @return ticketId
     */
    public org.apache.axis.types.NonNegativeInteger getTicketId() {
        return ticketId;
    }


    /**
     * Sets the ticketId value for this CreateTransactionPaymentInformationType.
     * 
     * @param ticketId
     */
    public void setTicketId(org.apache.axis.types.NonNegativeInteger ticketId) {
        this.ticketId = ticketId;
    }


    /**
     * Gets the entityurl value for this CreateTransactionPaymentInformationType.
     * 
     * @return entityurl
     */
    public java.lang.String getEntityurl() {
        return entityurl;
    }


    /**
     * Sets the entityurl value for this CreateTransactionPaymentInformationType.
     * 
     * @param entityurl
     */
    public void setEntityurl(java.lang.String entityurl) {
        this.entityurl = entityurl;
    }


    /**
     * Gets the userType value for this CreateTransactionPaymentInformationType.
     * 
     * @return userType
     */
    public java.lang.String getUserType() {
        return userType;
    }


    /**
     * Sets the userType value for this CreateTransactionPaymentInformationType.
     * 
     * @param userType
     */
    public void setUserType(java.lang.String userType) {
        this.userType = userType;
    }


    /**
     * Gets the referenceNumber value for this CreateTransactionPaymentInformationType.
     * 
     * @return referenceNumber
     */
    public java.lang.String[] getReferenceNumber() {
        return referenceNumber;
    }


    /**
     * Sets the referenceNumber value for this CreateTransactionPaymentInformationType.
     * 
     * @param referenceNumber
     */
    public void setReferenceNumber(java.lang.String[] referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public java.lang.String getReferenceNumber(int i) {
        return this.referenceNumber[i];
    }

    public void setReferenceNumber(int i, java.lang.String _value) {
        this.referenceNumber[i] = _value;
    }


    /**
     * Gets the soliciteDate value for this CreateTransactionPaymentInformationType.
     * 
     * @return soliciteDate
     */
    public java.util.Date getSoliciteDate() {
        return soliciteDate;
    }


    /**
     * Sets the soliciteDate value for this CreateTransactionPaymentInformationType.
     * 
     * @param soliciteDate
     */
    public void setSoliciteDate(java.util.Date soliciteDate) {
        this.soliciteDate = soliciteDate;
    }


    /**
     * Gets the paymentDescription value for this CreateTransactionPaymentInformationType.
     * 
     * @return paymentDescription
     */
    public java.lang.String getPaymentDescription() {
        return paymentDescription;
    }


    /**
     * Sets the paymentDescription value for this CreateTransactionPaymentInformationType.
     * 
     * @param paymentDescription
     */
    public void setPaymentDescription(java.lang.String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateTransactionPaymentInformationType)) return false;
        CreateTransactionPaymentInformationType other = (CreateTransactionPaymentInformationType) obj;
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
            ((this.entityCode==null && other.getEntityCode()==null) || 
             (this.entityCode!=null &&
              this.entityCode.equals(other.getEntityCode()))) &&
            ((this.serviceCode==null && other.getServiceCode()==null) || 
             (this.serviceCode!=null &&
              this.serviceCode.equals(other.getServiceCode()))) &&
            ((this.transactionValue==null && other.getTransactionValue()==null) || 
             (this.transactionValue!=null &&
              this.transactionValue.equals(other.getTransactionValue()))) &&
            ((this.vatValue==null && other.getVatValue()==null) || 
             (this.vatValue!=null &&
              this.vatValue.equals(other.getVatValue()))) &&
            ((this.ticketId==null && other.getTicketId()==null) || 
             (this.ticketId!=null &&
              this.ticketId.equals(other.getTicketId()))) &&
            ((this.entityurl==null && other.getEntityurl()==null) || 
             (this.entityurl!=null &&
              this.entityurl.equals(other.getEntityurl()))) &&
            ((this.userType==null && other.getUserType()==null) || 
             (this.userType!=null &&
              this.userType.equals(other.getUserType()))) &&
            ((this.referenceNumber==null && other.getReferenceNumber()==null) || 
             (this.referenceNumber!=null &&
              java.util.Arrays.equals(this.referenceNumber, other.getReferenceNumber()))) &&
            ((this.soliciteDate==null && other.getSoliciteDate()==null) || 
             (this.soliciteDate!=null &&
              this.soliciteDate.equals(other.getSoliciteDate()))) &&
            ((this.paymentDescription==null && other.getPaymentDescription()==null) || 
             (this.paymentDescription!=null &&
              this.paymentDescription.equals(other.getPaymentDescription())));
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
        if (getEntityCode() != null) {
            _hashCode += getEntityCode().hashCode();
        }
        if (getServiceCode() != null) {
            _hashCode += getServiceCode().hashCode();
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
        if (getEntityurl() != null) {
            _hashCode += getEntityurl().hashCode();
        }
        if (getUserType() != null) {
            _hashCode += getUserType().hashCode();
        }
        if (getReferenceNumber() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReferenceNumber());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReferenceNumber(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSoliciteDate() != null) {
            _hashCode += getSoliciteDate().hashCode();
        }
        if (getPaymentDescription() != null) {
            _hashCode += getPaymentDescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateTransactionPaymentInformationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentInformationType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("serviceCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "serviceCode"));
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
        elemField.setFieldName("entityurl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "entityurl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "userType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "String1to80Type"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "referenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "String1to80Type"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("soliciteDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "soliciteDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "paymentDescription"));
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
		return "CreateTransactionPaymentInformationType [financialInstitutionCode=" + financialInstitutionCode
				+ ", entityCode=" + entityCode + ", serviceCode=" + serviceCode + ", transactionValue="
				+ transactionValue + ", vatValue=" + vatValue + ", ticketId=" + ticketId + ", entityurl=" + entityurl
				+ ", userType=" + userType + ", referenceNumber=" + Arrays.toString(referenceNumber) + ", soliciteDate="
				+ soliciteDate + ", paymentDescription=" + paymentDescription + ", __equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}

    
    
}
