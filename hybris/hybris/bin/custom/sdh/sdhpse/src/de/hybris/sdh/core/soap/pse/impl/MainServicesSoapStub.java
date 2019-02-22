/**
 * MainServicesSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.hybris.sdh.core.soap.pse.impl;

import org.apache.axis.message.SOAPHeaderElement;

public class MainServicesSoapStub extends org.apache.axis.client.Stub implements de.hybris.sdh.core.soap.pse.MainServicesSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[10];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getBankList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getBankListInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getbankListInformationType"), de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getBankListResponseInformationType"));
        oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getBankListResponseInformation"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createTransactionPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentInformationType"), de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentResponseInformationType"));
        oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentResponseInformation"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("confirmTransactionPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentInformationType"), de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentResponseInformationType"));
        oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentResponseInformation"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTransactionInformation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationBody"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationBodyType"), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationResponseBodyType"));
        oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationResponseBody"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("finalizeTransactionPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentInformationType"), de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentResponseInformationType"));
        oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentResponseInformation"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getConciliationFile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileInformationType"), de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileInformationType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "files"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileResponseFileType"), de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseFileType[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileResponseReturnCodeList"), de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseReturnCodeList.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFilesACH");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACHInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACHInformationType"), de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHInformationType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "files"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACHResponseFileType"), de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseFileType[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACHResponseReturnCodeList"), de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseReturnCodeList.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createTransactionPaymentMultiCredit");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentInformationMultiCredit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentInformationMultiCreditType"), de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationMultiCreditType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentMultiCreditResponseInformationType"));
        oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentMultiCreditResponseInformation"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTransactionInformationDetailed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedBody"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedBodyType"), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseBodyType"));
        oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseBody"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("finalizeTransactionPaymentWithAuthorizationCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeInformationType"), de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeInformationType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeResponseInformationType"));
        oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeResponseInformation"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    public MainServicesSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public MainServicesSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public MainServicesSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "AlternatePartyIdentificationListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "AlternatePartyIdentificationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.AlternatePartyIdentificationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "AmountType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.AmountType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentResponseInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentTransactionStateCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentTransactionStateCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentInformationMultiCreditType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationMultiCreditType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentMultiCreditResponseInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentMultiCreditResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentResponseInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "CurrencyISOCodeType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentResponseInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeResponseInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "Float1to18Type");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getbankListInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getBankListResponseInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileResponseFileType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseFileType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACHInformationType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACHResponseFileType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseFileType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACHResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationBodyType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedBodyType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseBodyType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseFieldType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseFieldType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailedResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationResponseBodyType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationResponseReturnCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseReturnCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationResponseTransactionStateCodeList");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseTransactionStateCodeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "Integer1to35Type");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.NonNegativeInteger.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "multiCreditType");
            cachedSerQNames.add(qName);
            cls = de.hybris.sdh.core.soap.pse.eanucc.MultiCreditType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "String1to20Type");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "String1to35Type");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "String1to500Type");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "String1to80Type");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "String3Type");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "userTypeListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType[] getBankList(de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType getBankListInformation) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
         org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/getBankList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getBankList"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getBankListInformation});


        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED
            try {
                return (de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType[]) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType createTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType createTransactionPaymentInformation) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/createTransactionPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPayment"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {createTransactionPaymentInformation});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            
////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED

            try {
                return (de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType) _resp;
            } catch (java.lang.Exception _exception) {
                return (de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType confirmTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType confirmTransactionPaymentInformation) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/confirmTransactionPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {confirmTransactionPaymentInformation});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);

////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED

			try {
                return (de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType) _resp;
            } catch (java.lang.Exception _exception) {
                return (de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType getTransactionInformation(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType getTransactionInformationBody) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/getTransactionInformation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformation"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getTransactionInformationBody});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);

////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED

            try {
                return (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType) _resp;
            } catch (java.lang.Exception _exception) {
                return (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType finalizeTransactionPaymentInformation) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/finalizeTransactionPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPayment"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {finalizeTransactionPaymentInformation});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);

////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED

            try {
                return (de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType) _resp;
            } catch (java.lang.Exception _exception) {
                return (de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getConciliationFile(de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileInformationType getConciliationFileInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseFileTypeArrayHolder files, de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/getConciliationFile");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFile"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getConciliationFileInformation});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);

////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED

			java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                files.value = (de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseFileType[]) _output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "files"));
            } catch (java.lang.Exception _exception) {
                files.value = (de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseFileType[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "files")), de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseFileType[].class);
            }
            try {
                returnCode.value = (de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseReturnCodeList) _output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"));
            } catch (java.lang.Exception _exception) {
                returnCode.value = (de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseReturnCodeList) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode")), de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseReturnCodeList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getFilesACH(de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHInformationType getFilesACHInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseFileTypeArrayHolder files, de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/getFilesACH");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACH"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getFilesACHInformation});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);

 ////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED

            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                files.value = (de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseFileType[]) _output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "files"));
            } catch (java.lang.Exception _exception) {
                files.value = (de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseFileType[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "files")), de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseFileType[].class);
            }
            try {
                returnCode.value = (de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseReturnCodeList) _output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"));
            } catch (java.lang.Exception _exception) {
                returnCode.value = (de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseReturnCodeList) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode")), de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseReturnCodeList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType createTransactionPaymentMultiCredit(de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationMultiCreditType createTransactionPaymentInformationMultiCredit) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/createTransactionPaymentMultiCredit");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "createTransactionPaymentMultiCredit"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {createTransactionPaymentInformationMultiCredit});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);

////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED

			try {
                return (de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType) _resp;
            } catch (java.lang.Exception _exception) {
                return (de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType getTransactionInformationDetailed(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType getTransactionInformationDetailedBody) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/getTransactionInformationDetailed");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionInformationDetailed"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getTransactionInformationDetailedBody});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);

////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED

			try {
                return (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType) _resp;
            } catch (java.lang.Exception _exception) {
                return (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType finalizeTransactionPaymentWithAuthorizationCode(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeInformationType finalizeTransactionPaymentWithAuthorizationCodeInformation) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/finalizeTransactionPaymentWithAuthorizationCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCode"));

////    BEGIN ADDED
		SOAPHeaderElement header = _messageHeader.toSOAPHeaderElement();
		if( header!=null)
			_call.addHeader( header );
		//// END ADDED

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {finalizeTransactionPaymentWithAuthorizationCodeInformation});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);

////        BEGIN ADDED
			header = getHeader("http://www.uc-council.org/smp/schemas/eanucc", "messageHeader");
			if(header!=null) 
				_messageHeader.fromSOAPHeaderElement(header); 
			//// END ADDED
			
			try {
                return (de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType) _resp;
            } catch (java.lang.Exception _exception) {
                return (de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    //// BEGIN ADDED

    private static MessageHeader _messageHeader;

    public void setMessageHeader( MessageHeader messageHeader )
    {
	_messageHeader = messageHeader;
    }
	
    public MessageHeader getMessageHeader()
    {
	return _messageHeader;
    }

    //// END ADDED

}
