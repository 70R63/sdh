/**
 * GetTransactionInformationResponseBodyType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.eanucc;

public class GetTransactionInformationResponseBodyType  implements java.io.Serializable {
    private org.apache.axis.types.NonNegativeInteger ticketId;

    private java.lang.String trazabilityCode;

    private java.lang.String entityCode;

    private de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue;

    private de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue;

    private java.util.Date soliciteDate;

    private java.util.Date bankProcessDate;

    private java.lang.String transactionCycle;

    private de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseTransactionStateCodeList transactionState;

    private de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseReturnCodeList returnCode;

    public GetTransactionInformationResponseBodyType() {
    }

    public GetTransactionInformationResponseBodyType(
           org.apache.axis.types.NonNegativeInteger ticketId,
           java.lang.String trazabilityCode,
           java.lang.String entityCode,
           de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue,
           de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue,
           java.util.Date soliciteDate,
           java.util.Date bankProcessDate,
           java.lang.String transactionCycle,
           de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseTransactionStateCodeList transactionState,
           de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseReturnCodeList returnCode) {
           this.ticketId = ticketId;
           this.trazabilityCode = trazabilityCode;
           this.entityCode = entityCode;
           this.transactionValue = transactionValue;
           this.vatValue = vatValue;
           this.soliciteDate = soliciteDate;
           this.bankProcessDate = bankProcessDate;
           this.transactionCycle = transactionCycle;
           this.transactionState = transactionState;
           this.returnCode = returnCode;
    }


    /**
     * Gets the ticketId value for this GetTransactionInformationResponseBodyType.
     * 
     * @return ticketId
     */
    public org.apache.axis.types.NonNegativeInteger getTicketId() {
        return ticketId;
    }


    /**
     * Sets the ticketId value for this GetTransactionInformationResponseBodyType.
     * 
     * @param ticketId
     */
    public void setTicketId(org.apache.axis.types.NonNegativeInteger ticketId) {
        this.ticketId = ticketId;
    }


    /**
     * Gets the trazabilityCode value for this GetTransactionInformationResponseBodyType.
     * 
     * @return trazabilityCode
     */
    public java.lang.String getTrazabilityCode() {
        return trazabilityCode;
    }


    /**
     * Sets the trazabilityCode value for this GetTransactionInformationResponseBodyType.
     * 
     * @param trazabilityCode
     */
    public void setTrazabilityCode(java.lang.String trazabilityCode) {
        this.trazabilityCode = trazabilityCode;
    }


    /**
     * Gets the entityCode value for this GetTransactionInformationResponseBodyType.
     * 
     * @return entityCode
     */
    public java.lang.String getEntityCode() {
        return entityCode;
    }


    /**
     * Sets the entityCode value for this GetTransactionInformationResponseBodyType.
     * 
     * @param entityCode
     */
    public void setEntityCode(java.lang.String entityCode) {
        this.entityCode = entityCode;
    }


    /**
     * Gets the transactionValue value for this GetTransactionInformationResponseBodyType.
     * 
     * @return transactionValue
     */
    public de.hybris.sdh.core.soap.pse.eanucc.AmountType getTransactionValue() {
        return transactionValue;
    }


    /**
     * Sets the transactionValue value for this GetTransactionInformationResponseBodyType.
     * 
     * @param transactionValue
     */
    public void setTransactionValue(de.hybris.sdh.core.soap.pse.eanucc.AmountType transactionValue) {
        this.transactionValue = transactionValue;
    }


    /**
     * Gets the vatValue value for this GetTransactionInformationResponseBodyType.
     * 
     * @return vatValue
     */
    public de.hybris.sdh.core.soap.pse.eanucc.AmountType getVatValue() {
        return vatValue;
    }


    /**
     * Sets the vatValue value for this GetTransactionInformationResponseBodyType.
     * 
     * @param vatValue
     */
    public void setVatValue(de.hybris.sdh.core.soap.pse.eanucc.AmountType vatValue) {
        this.vatValue = vatValue;
    }


    /**
     * Gets the soliciteDate value for this GetTransactionInformationResponseBodyType.
     * 
     * @return soliciteDate
     */
    public java.util.Date getSoliciteDate() {
        return soliciteDate;
    }


    /**
     * Sets the soliciteDate value for this GetTransactionInformationResponseBodyType.
     * 
     * @param soliciteDate
     */
    public void setSoliciteDate(java.util.Date soliciteDate) {
        this.soliciteDate = soliciteDate;
    }


    /**
     * Gets the bankProcessDate value for this GetTransactionInformationResponseBodyType.
     * 
     * @return bankProcessDate
     */
    public java.util.Date getBankProcessDate() {
        return bankProcessDate;
    }


    /**
     * Sets the bankProcessDate value for this GetTransactionInformationResponseBodyType.
     * 
     * @param bankProcessDate
     */
    public void setBankProcessDate(java.util.Date bankProcessDate) {
        this.bankProcessDate = bankProcessDate;
    }


    /**
     * Gets the transactionCycle value for this GetTransactionInformationResponseBodyType.
     * 
     * @return transactionCycle
     */
    public java.lang.String getTransactionCycle() {
        return transactionCycle;
    }


    /**
     * Sets the transactionCycle value for this GetTransactionInformationResponseBodyType.
     * 
     * @param transactionCycle
     */
    public void setTransactionCycle(java.lang.String transactionCycle) {
        this.transactionCycle = transactionCycle;
    }


    /**
     * Gets the transactionState value for this GetTransactionInformationResponseBodyType.
     * 
     * @return transactionState
     */
    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseTransactionStateCodeList getTransactionState() {
        return transactionState;
    }


    /**
     * Sets the transactionState value for this GetTransactionInformationResponseBodyType.
     * 
     * @param transactionState
     */
    public void setTransactionState(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseTransactionStateCodeList transactionState) {
        this.transactionState = transactionState;
    }


    /**
     * Gets the returnCode value for this GetTransactionInformationResponseBodyType.
     * 
     * @return returnCode
     */
    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseReturnCodeList getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this GetTransactionInformationResponseBodyType.
     * 
     * @param returnCode
     */
    public void setReturnCode(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseReturnCodeList returnCode) {
        this.returnCode = returnCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTransactionInformationResponseBodyType)) return false;
        GetTransactionInformationResponseBodyType other = (GetTransactionInformationResponseBodyType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ticketId==null && other.getTicketId()==null) || 
             (this.ticketId!=null &&
              this.ticketId.equals(other.getTicketId()))) &&
            ((this.trazabilityCode==null && other.getTrazabilityCode()==null) || 
             (this.trazabilityCode!=null &&
              this.trazabilityCode.equals(other.getTrazabilityCode()))) &&
            ((this.entityCode==null && other.getEntityCode()==null) || 
             (this.entityCode!=null &&
              this.entityCode.equals(other.getEntityCode()))) &&
            ((this.transactionValue==null && other.getTransactionValue()==null) || 
             (this.transactionValue!=null &&
              this.transactionValue.equals(other.getTransactionValue()))) &&
            ((this.vatValue==null && other.getVatValue()==null) || 
             (this.vatValue!=null &&
              this.vatValue.equals(other.getVatValue()))) &&
            ((this.soliciteDate==null && other.getSoliciteDate()==null) || 
             (this.soliciteDate!=null &&
              this.soliciteDate.equals(other.getSoliciteDate()))) &&
            ((this.bankProcessDate==null && other.getBankProcessDate()==null) || 
             (this.bankProcessDate!=null &&
              this.bankProcessDate.equals(other.getBankProcessDate()))) &&
            ((this.transactionCycle==null && other.getTransactionCycle()==null) || 
             (this.transactionCycle!=null &&
              this.transactionCycle.equals(other.getTransactionCycle()))) &&
            ((this.transactionState==null && other.getTransactionState()==null) || 
             (this.transactionState!=null &&
              this.transactionState.equals(other.getTransactionState()))) &&
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
        if (getTicketId() != null) {
            _hashCode += getTicketId().hashCode();
        }
        if (getTrazabilityCode() != null) {
            _hashCode += getTrazabilityCode().hashCode();
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
        if (getSoliciteDate() != null) {
            _hashCode += getSoliciteDate().hashCode();
        }
        if (getBankProcessDate() != null) {
            _hashCode += getBankProcessDate().hashCode();
        }
        if (getTransactionCycle() != null) {
            _hashCode += getTransactionCycle().hashCode();
        }
        if (getTransactionState() != null) {
            _hashCode += getTransactionState().hashCode();
        }
        if (getReturnCode() != null) {
            _hashCode += getReturnCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTransactionInformationResponseBodyType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationResponseBodyType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "ticketId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trazabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "trazabilityCode"));
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
        elemField.setFieldName("transactionCycle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "transactionCycle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "transactionState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationResponseTransactionStateCodeList"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationResponseReturnCodeList"));
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
