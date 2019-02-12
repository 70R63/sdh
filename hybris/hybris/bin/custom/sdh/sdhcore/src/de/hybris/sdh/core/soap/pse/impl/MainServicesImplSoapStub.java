/**
 *
 */
package de.hybris.sdh.core.soap.pse.impl;

import de.hybris.sdh.core.soap.pse.MainServicesImplSoap;
import de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2InformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2InformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationMultiCreditType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentMultiCreditResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationDetailedResponseBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationResponseBodyType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseFileTypeArrayHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetConciliationFileResponseReturnCodeListHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseFileTypeArrayHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetFilesACHResponseReturnCodeListHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseReturnCodeListHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseStatisticTypeArrayHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseReturnCodeListHolder;
import de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseTotalTypeArrayHolder;

import java.rmi.RemoteException;

import org.apache.axis.message.SOAPHeaderElement;

/**
 * @author Consultor
 *
 */
public class MainServicesImplSoapStub extends org.apache.axis.client.Stub implements MainServicesImplSoap
{

   private java.util.Vector cachedSerClasses = new java.util.Vector();
   private java.util.Vector cachedSerQNames = new java.util.Vector();
   private java.util.Vector cachedSerFactories = new java.util.Vector();
   private java.util.Vector cachedDeserFactories = new java.util.Vector();

   static org.apache.axis.description.OperationDesc [] _operations;

   static {
       _operations = new org.apache.axis.description.OperationDesc[16];
       _initOperationDesc1();
       _initOperationDesc2();
   }

   private static void _initOperationDesc1(){
       org.apache.axis.description.OperationDesc oper;
       org.apache.axis.description.ParameterDesc param;
       oper = new org.apache.axis.description.OperationDesc();
       oper.setName("getBankList");
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getBankListInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getbankListInformationType"), de.hybris.sdh.core.soap.pse.eanucc.GetbankListInformationType.class, false, false);
       param.setOmittable(true);
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
       param.setOmittable(true);
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
       param.setOmittable(true);
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
       param.setOmittable(true);
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
       param.setOmittable(true);
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
       param.setOmittable(true);
       oper.addParameter(param);
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "files"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getConciliationFileResponseFileType"), de.hybris.sdh.core.soap.pse.eanucc.GetConciliationFileResponseFileType[].class, false, false);
       param.setOmittable(true);
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
       param.setOmittable(true);
       oper.addParameter(param);
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "files"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getFilesACHResponseFileType"), de.hybris.sdh.core.soap.pse.eanucc.GetFilesACHResponseFileType[].class, false, false);
       param.setOmittable(true);
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
       param.setOmittable(true);
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
       param.setOmittable(true);
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
       param.setOmittable(true);
       oper.addParameter(param);
       oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeResponseInformationType"));
       oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentWithAuthorizationCodeResponseInformationType.class);
       oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "finalizeTransactionPaymentWithAuthorizationCodeResponseInformation"));
       oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
       oper.setUse(org.apache.axis.constants.Use.LITERAL);
       _operations[9] = oper;

   }

   private static void _initOperationDesc2(){
       org.apache.axis.description.OperationDesc oper;
       org.apache.axis.description.ParameterDesc param;
       oper = new org.apache.axis.description.OperationDesc();
       oper.setName("getTransactionTotals");
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotalsInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotalsInformationType"), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsInformationType.class, false, false);
       param.setOmittable(true);
       oper.addParameter(param);
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "totals"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotalsResponseTotalType"), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseTotalType[].class, false, false);
       param.setOmittable(true);
       oper.addParameter(param);
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotalsResponseReturnCodeList"), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseReturnCodeList.class, false, false);
       oper.addParameter(param);
       oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
       oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
       oper.setUse(org.apache.axis.constants.Use.LITERAL);
       _operations[10] = oper;

       oper = new org.apache.axis.description.OperationDesc();
       oper.setName("getTransactionStatistics");
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsInformationType"), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsInformationType.class, false, false);
       param.setOmittable(true);
       oper.addParameter(param);
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "statistics"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsResponseStatisticType"), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseStatisticType[].class, false, false);
       param.setOmittable(true);
       oper.addParameter(param);
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsResponseReturnCodeList"), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseReturnCodeList.class, false, false);
       oper.addParameter(param);
       oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
       oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
       oper.setUse(org.apache.axis.constants.Use.LITERAL);
       _operations[11] = oper;

       oper = new org.apache.axis.description.OperationDesc();
       oper.setName("authorizeTransactionPayment");
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPaymentInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPaymentInformationType"), de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentInformationType.class, false, false);
       param.setOmittable(true);
       oper.addParameter(param);
       oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPaymentResponseInformationType"));
       oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType.class);
       oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPaymentResponseInformation"));
       oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
       oper.setUse(org.apache.axis.constants.Use.LITERAL);
       _operations[12] = oper;

       oper = new org.apache.axis.description.OperationDesc();
       oper.setName("confirmTransactionPaymentFD");
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDInformationType"), de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDInformationType.class, false, false);
       param.setOmittable(true);
       oper.addParameter(param);
       oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDResponseInformationType"));
       oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType.class);
       oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDResponseInformation"));
       oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
       oper.setUse(org.apache.axis.constants.Use.LITERAL);
       _operations[13] = oper;

       oper = new org.apache.axis.description.OperationDesc();
       oper.setName("confirmTransactionPayment2");
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2Information"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2InformationType"), de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2InformationType.class, false, false);
       param.setOmittable(true);
       oper.addParameter(param);
       oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2ResponseInformationType"));
       oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType.class);
       oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2ResponseInformation"));
       oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
       oper.setUse(org.apache.axis.constants.Use.LITERAL);
       _operations[14] = oper;

       oper = new org.apache.axis.description.OperationDesc();
       oper.setName("confirmTransactionPaymentFD2");
       param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2Information"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2InformationType"), de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2InformationType.class, false, false);
       param.setOmittable(true);
       oper.addParameter(param);
       oper.setReturnType(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2ResponseInformationType"));
       oper.setReturnClass(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType.class);
       oper.setReturnQName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2ResponseInformation"));
       oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
       oper.setUse(org.apache.axis.constants.Use.LITERAL);
       _operations[15] = oper;

   }

   public MainServicesImplSoapStub() throws org.apache.axis.AxisFault {
        this(null);
   }

   public MainServicesImplSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
   }

   public MainServicesImplSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "AmountType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.AmountType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
           cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPaymentInformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentInformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPaymentResponseInformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPaymentResponseReturnCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseReturnCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2InformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2InformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2ResponseInformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2ResponseReturnCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseReturnCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2TransactionStateCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2TransactionStateCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2InformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2InformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2ResponseInformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2ResponseReturnCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseReturnCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2TransactionStateCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2TransactionStateCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDInformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDInformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDResponseInformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDResponseReturnCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseReturnCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFDTransactionStateCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDTransactionStateCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

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

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsInformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsInformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsResponseReturnCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseReturnCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatisticsResponseStatisticType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseStatisticType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotalsInformationType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsInformationType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotalsResponseReturnCodeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseReturnCodeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotalsResponseTotalType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseTotalType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "multiCreditType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.MultiCreditType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(beansf);
           cachedDeserFactories.add(beandf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "statisticsPeriodType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.StatisticsPeriodType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "statisticsType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.StatisticsType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "TotalTypeList");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.TotalTypeList.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

           qName = new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "userTypeListType");
           cachedSerQNames.add(qName);
           cls = de.hybris.sdh.core.soap.pse.eanucc.UserTypeListType.class;
           cachedSerClasses.add(cls);
           cachedSerFactories.add(enumsf);
           cachedDeserFactories.add(enumdf);

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

   @Override
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

       //// BEGIN ADDED
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
           //// BEGIN ADDED
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

   @Override
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

       //// BEGIN ADDED
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
           
           ////  BEGIN ADDED
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

   @Override
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

       //// BEGIN ADDED
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
           //// BEGIN ADDED
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

   @Override
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

       //// BEGIN ADDED
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
           
           //// BEGIN ADDED
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

   @Override
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
       
       //// BEGIN ADDED
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
           
           //// BEGIN ADDED
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

   @Override
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

       //// BEGIN ADDED
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
           
           //// BEGIN ADDED
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

   @Override
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

       //// BEGIN ADDED
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
           
           //// BEGIN ADDED
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

   @Override
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

       //// BEGIN ADDED
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
           
           //// BEGIN ADDED
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

   @Override
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

       //// BEGIN ADDED
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
           
           //// BEGIN ADDED
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

   @Override
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

       //// BEGIN ADDED
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
           
           //// BEGIN ADDED
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

   @Override
   public void getTransactionTotals(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsInformationType getTransactionTotalsInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseTotalTypeArrayHolder totals, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionTotalsResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException {
       if (super.cachedEndpoint == null) {
           throw new org.apache.axis.NoEndPointException();
       }
       org.apache.axis.client.Call _call = createCall();
       _call.setOperation(_operations[10]);
       _call.setUseSOAPAction(true);
       _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/getTransactionTotals");
       _call.setEncodingStyle(null);
       _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
       _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
       _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
       _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionTotals"));

       setRequestHeaders(_call);
       setAttachments(_call);
try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getTransactionTotalsInformation});

       if (_resp instanceof java.rmi.RemoteException) {
           throw (java.rmi.RemoteException)_resp;
       }
       else {
           extractAttachments(_call);
           java.util.Map _output;
           _output = _call.getOutputParams();
           try {
               totals.value = (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseTotalType[]) _output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "totals"));
           } catch (java.lang.Exception _exception) {
               totals.value = (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseTotalType[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "totals")), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseTotalType[].class);
           }
           try {
               returnCode.value = (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseReturnCodeList) _output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"));
           } catch (java.lang.Exception _exception) {
               returnCode.value = (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseReturnCodeList) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode")), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionTotalsResponseReturnCodeList.class);
           }
       }
 } catch (org.apache.axis.AxisFault axisFaultException) {
 throw axisFaultException;
}
   }

   @Override
   public void getTransactionStatistics(de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsInformationType getTransactionStatisticsInformation, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseStatisticTypeArrayHolder statistics, de.hybris.sdh.core.soap.pse.eanucc.holders.GetTransactionStatisticsResponseReturnCodeListHolder returnCode) throws java.rmi.RemoteException {
       if (super.cachedEndpoint == null) {
           throw new org.apache.axis.NoEndPointException();
       }
       org.apache.axis.client.Call _call = createCall();
       _call.setOperation(_operations[11]);
       _call.setUseSOAPAction(true);
       _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/getTransactionStatistics");
       _call.setEncodingStyle(null);
       _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
       _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
       _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
       _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "getTransactionStatistics"));

       setRequestHeaders(_call);
       setAttachments(_call);
try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getTransactionStatisticsInformation});

       if (_resp instanceof java.rmi.RemoteException) {
           throw (java.rmi.RemoteException)_resp;
       }
       else {
           extractAttachments(_call);
           java.util.Map _output;
           _output = _call.getOutputParams();
           try {
               statistics.value = (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseStatisticType[]) _output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "statistics"));
           } catch (java.lang.Exception _exception) {
               statistics.value = (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseStatisticType[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "statistics")), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseStatisticType[].class);
           }
           try {
               returnCode.value = (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseReturnCodeList) _output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode"));
           } catch (java.lang.Exception _exception) {
               returnCode.value = (de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseReturnCodeList) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "returnCode")), de.hybris.sdh.core.soap.pse.eanucc.GetTransactionStatisticsResponseReturnCodeList.class);
           }
       }
 } catch (org.apache.axis.AxisFault axisFaultException) {
 throw axisFaultException;
}
   }

   @Override
   public de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType authorizeTransactionPayment(de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentInformationType authorizeTransactionPaymentInformation) throws java.rmi.RemoteException {
       if (super.cachedEndpoint == null) {
           throw new org.apache.axis.NoEndPointException();
       }
       org.apache.axis.client.Call _call = createCall();
       _call.setOperation(_operations[12]);
       _call.setUseSOAPAction(true);
       _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/authorizeTransactionPayment");
       _call.setEncodingStyle(null);
       _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
       _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
       _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
       _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "authorizeTransactionPayment"));

       setRequestHeaders(_call);
       setAttachments(_call);
try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {authorizeTransactionPaymentInformation});

       if (_resp instanceof java.rmi.RemoteException) {
           throw (java.rmi.RemoteException)_resp;
       }
       else {
           extractAttachments(_call);
           try {
               return (de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType) _resp;
           } catch (java.lang.Exception _exception) {
               return (de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.AuthorizeTransactionPaymentResponseInformationType.class);
           }
       }
 } catch (org.apache.axis.AxisFault axisFaultException) {
 throw axisFaultException;
}
   }

   @Override
   public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType confirmTransactionPaymentFD(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDInformationType confirmTransactionPaymentFDInformation) throws java.rmi.RemoteException {
       if (super.cachedEndpoint == null) {
           throw new org.apache.axis.NoEndPointException();
       }
       org.apache.axis.client.Call _call = createCall();
       _call.setOperation(_operations[13]);
       _call.setUseSOAPAction(true);
       _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/confirmTransactionPaymentFD");
       _call.setEncodingStyle(null);
       _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
       _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
       _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
       _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD"));

       setRequestHeaders(_call);
       setAttachments(_call);
try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {confirmTransactionPaymentFDInformation});

       if (_resp instanceof java.rmi.RemoteException) {
           throw (java.rmi.RemoteException)_resp;
       }
       else {
           extractAttachments(_call);
           try {
               return (de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType) _resp;
           } catch (java.lang.Exception _exception) {
               return (de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFDResponseInformationType.class);
           }
       }
 } catch (org.apache.axis.AxisFault axisFaultException) {
 throw axisFaultException;
}
   }

   @Override
   public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType confirmTransactionPayment2(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2InformationType confirmTransactionPayment2Information) throws java.rmi.RemoteException {
       if (super.cachedEndpoint == null) {
           throw new org.apache.axis.NoEndPointException();
       }
       org.apache.axis.client.Call _call = createCall();
       _call.setOperation(_operations[14]);
       _call.setUseSOAPAction(true);
       _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/confirmTransactionPayment2");
       _call.setEncodingStyle(null);
       _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
       _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
       _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
       _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPayment2"));

       setRequestHeaders(_call);
       setAttachments(_call);
try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {confirmTransactionPayment2Information});

       if (_resp instanceof java.rmi.RemoteException) {
           throw (java.rmi.RemoteException)_resp;
       }
       else {
           extractAttachments(_call);
           try {
               return (de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType) _resp;
           } catch (java.lang.Exception _exception) {
               return (de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPayment2ResponseInformationType.class);
           }
       }
 } catch (org.apache.axis.AxisFault axisFaultException) {
 throw axisFaultException;
}
   }

   @Override
   public de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType confirmTransactionPaymentFD2(de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2InformationType confirmTransactionPaymentFD2Information) throws java.rmi.RemoteException {
       if (super.cachedEndpoint == null) {
           throw new org.apache.axis.NoEndPointException();
       }
       org.apache.axis.client.Call _call = createCall();
       _call.setOperation(_operations[15]);
       _call.setUseSOAPAction(true);
       _call.setSOAPActionURI("http://vesta.com.br/pse/MainServices/confirmTransactionPaymentFD2");
       _call.setEncodingStyle(null);
       _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
       _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
       _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
       _call.setOperationName(new javax.xml.namespace.QName("http://www.uc-council.org/smp/schemas/eanucc", "confirmTransactionPaymentFD2"));

       setRequestHeaders(_call);
       setAttachments(_call);
try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {confirmTransactionPaymentFD2Information});

       if (_resp instanceof java.rmi.RemoteException) {
           throw (java.rmi.RemoteException)_resp;
       }
       else {
           extractAttachments(_call);
           try {
               return (de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType) _resp;
           } catch (java.lang.Exception _exception) {
               return (de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType) org.apache.axis.utils.JavaUtils.convert(_resp, de.hybris.sdh.core.soap.pse.eanucc.ConfirmTransactionPaymentFD2ResponseInformationType.class);
           }
       }
 } catch (org.apache.axis.AxisFault axisFaultException) {
 throw axisFaultException;
}
   }
   
   ////BEGIN ADDED
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
