/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.sdhbillsaddon.forms;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * BillPayment Form used in bill payment page
 */
public class BillPaymentForm
{
   private BigDecimal amount;
   private String billTo_city; // NOSONAR
   private String billTo_country; // NOSONAR
   private String billTo_customerID; // NOSONAR
   private String billTo_email; // NOSONAR
   private String billTo_firstName; // NOSONAR
   private String billTo_lastName; // NOSONAR
   private String billTo_phoneNumber; // NOSONAR
   private String billTo_postalCode; // NOSONAR
   private String billTo_titleCode; // NOSONAR
   private String billTo_state; // NOSONAR
   private String billTo_street1; // NOSONAR
   private String billTo_street2; // NOSONAR
   private String card_accountNumber; // NOSONAR
   private String card_cardType; // NOSONAR
   private String card_startMonth; // NOSONAR
   private String card_startYear; // NOSONAR
   private String card_issueNumber; // NOSONAR
   private String card_cvNumber; // NOSONAR
   private String card_expirationMonth; // NOSONAR
   private String card_expirationYear; // NOSONAR
   private String card_nameOnCard; // NOSONAR
   private String comments;
   private String currency;
   private String taxAmount;
   private boolean savePaymentInfo;
   private boolean usePrimaryAddress;
   private boolean usePaymentInfo;
   private String billCode;
   private String emailAddress;
   private String paymentId;

   private Map<String, String> parameters;


   public String getCard_nameOnCard() // NOSONAR
   {
      return card_nameOnCard;
   }

   public void setCard_nameOnCard(final String card_nameOnCard) // NOSONAR
   {
      this.card_nameOnCard = card_nameOnCard;
   }

   public BigDecimal getAmount()
   {
      return amount;
   }

   public void setAmount(final BigDecimal amount)
   {
      this.amount = amount;
   }

   public String getBillTo_city() // NOSONAR
   {
      return billTo_city;
   }

   public void setBillTo_city(final String billTo_city) // NOSONAR
   {
      this.billTo_city = billTo_city;
   }

   public String getBillTo_country() // NOSONAR
   {
      if (billTo_country != null)
      {
         return billTo_country.toUpperCase(Locale.US);
      }
      return billTo_country;
   }

   public void setBillTo_country(final String billTo_country) // NOSONAR
   {
      this.billTo_country = billTo_country;
   }

   public String getBillTo_customerID() // NOSONAR
   {
      return billTo_customerID;
   }

   public void setBillTo_customerID(final String billTo_customerID) // NOSONAR
   {
      this.billTo_customerID = billTo_customerID;
   }

   public String getBillTo_email() // NOSONAR
   {
      return billTo_email;
   }

   public void setBillTo_email(final String billTo_email) // NOSONAR
   {
      this.billTo_email = billTo_email;
   }

   public String getBillTo_firstName() // NOSONAR
   {
      return billTo_firstName;
   }

   public void setBillTo_firstName(final String billTo_firstName) // NOSONAR
   {
      this.billTo_firstName = billTo_firstName;
   }

   public String getBillTo_lastName() // NOSONAR
   {
      return billTo_lastName;
   }

   public void setBillTo_lastName(final String billTo_lastName) // NOSONAR
   {
      this.billTo_lastName = billTo_lastName;
   }

   public String getBillTo_phoneNumber() // NOSONAR
   {
      return billTo_phoneNumber;
   }

   public void setBillTo_phoneNumber(final String billTo_phoneNumber) // NOSONAR
   {
      this.billTo_phoneNumber = billTo_phoneNumber;
   }

   public String getBillTo_postalCode() // NOSONAR
   {
      return billTo_postalCode;
   }

   public void setBillTo_postalCode(final String billTo_postalCode) // NOSONAR
   {
      this.billTo_postalCode = billTo_postalCode;
   }

   public String getBillTo_titleCode() // NOSONAR
   {
      return billTo_titleCode;
   }

   public void setBillTo_titleCode(final String billTo_titleCode) // NOSONAR
   {
      this.billTo_titleCode = billTo_titleCode;
   }

   public String getBillTo_state() // NOSONAR
   {
      return billTo_state;
   }

   public void setBillTo_state(final String billTo_state) // NOSONAR
   {
      this.billTo_state = billTo_state;
   }

   public String getBillTo_street1() // NOSONAR
   {
      return billTo_street1;
   }

   public void setBillTo_street1(final String billTo_street1) // NOSONAR
   {
      this.billTo_street1 = billTo_street1;
   }

   public String getBillTo_street2() // NOSONAR
   {
      return billTo_street2;
   }

   public void setBillTo_street2(final String billTo_street2) // NOSONAR
   {
      this.billTo_street2 = billTo_street2;
   }

   public String getCard_accountNumber() // NOSONAR
   {
      return card_accountNumber;
   }

   public void setCard_accountNumber(final String card_accountNumber) // NOSONAR
   {
      this.card_accountNumber = card_accountNumber;
   }

   public String getCard_startMonth() // NOSONAR
   {
      return card_startMonth;
   }

   public void setCard_startMonth(final String card_startMonth) // NOSONAR
   {
      this.card_startMonth = card_startMonth;
   }

   public String getCard_startYear() // NOSONAR
   {
      return card_startYear;
   }

   public void setCard_startYear(final String card_startYear) // NOSONAR
   {
      this.card_startYear = card_startYear;
   }

   public String getCard_issueNumber() // NOSONAR
   {
      return card_issueNumber;
   }

   public void setCard_issueNumber(final String card_issueNumber) // NOSONAR
   {
      this.card_issueNumber = card_issueNumber;
   }

   public String getCard_cardType() // NOSONAR
   {
      return card_cardType;
   }

   public void setCard_cardType(final String card_cardType) // NOSONAR
   {
      this.card_cardType = card_cardType;
   }

   public String getCard_cvNumber() // NOSONAR
   {
      return card_cvNumber;
   }

   public void setCard_cvNumber(final String card_cvNumber) // NOSONAR
   {
      this.card_cvNumber = card_cvNumber;
   }

   public String getCard_expirationMonth() // NOSONAR
   {
      return card_expirationMonth;
   }

   public void setCard_expirationMonth(final String card_expirationMonth) // NOSONAR
   {
      this.card_expirationMonth = card_expirationMonth;
   }

   public String getCard_expirationYear() // NOSONAR
   {
      return card_expirationYear;
   }

   public void setCard_expirationYear(final String card_expirationYear) // NOSONAR
   {
      this.card_expirationYear = card_expirationYear;
   }

   public String getComments()
   {
      return comments;
   }

   public void setComments(final String comments)
   {
      this.comments = comments;
   }

   public String getCurrency()
   {
      return currency;
   }

   public void setCurrency(final String currency)
   {
      this.currency = currency;
   }

   public String getTaxAmount()
   {
      return taxAmount;
   }

   public void setTaxAmount(final String taxAmount)
   {
      this.taxAmount = taxAmount;
   }

   public boolean isSavePaymentInfo()
   {
      return savePaymentInfo;
   }

   public void setSavePaymentInfo(final boolean savePaymentInfo)
   {
      this.savePaymentInfo = savePaymentInfo;
   }

   public boolean isUsePrimaryAddress()
   {
      return usePrimaryAddress;
   }

   public void setUsePrimaryAddress(final boolean usePrimaryAddress)
   {
      this.usePrimaryAddress = usePrimaryAddress;
   }

   public Map<String, String> getParameters()
   {
      return parameters;
   }

   public void setParameters(final Map<String, String> parameters)
   {
      this.parameters = parameters;
   }

   public Map<String, String> getSubscriptionSignatureParams()
   {
      if (parameters != null)
      {
         final Map<String, String> subscriptionSignatureParams = new HashMap<>();
         subscriptionSignatureParams.put("recurringSubscriptionInfo_amount", parameters.get("recurringSubscriptionInfo_amount"));
         subscriptionSignatureParams.put("recurringSubscriptionInfo_numberOfPayments",
               parameters.get("recurringSubscriptionInfo_numberOfPayments"));
         subscriptionSignatureParams.put("recurringSubscriptionInfo_frequency",
               parameters.get("recurringSubscriptionInfo_frequency"));
         subscriptionSignatureParams.put("recurringSubscriptionInfo_automaticRenew",
               parameters.get("recurringSubscriptionInfo_automaticRenew"));
         subscriptionSignatureParams.put("recurringSubscriptionInfo_startDate",
               parameters.get("recurringSubscriptionInfo_startDate"));
         subscriptionSignatureParams.put("recurringSubscriptionInfo_signaturePublic",
               parameters.get("recurringSubscriptionInfo_signaturePublic"));
         return subscriptionSignatureParams;
      }
      return null;
   }

   public Map<String, String> getSignatureParams()
   {
      if (parameters != null)
      {
         final Map<String, String> signatureParams = new HashMap<>();
         signatureParams.put("orderPage_signaturePublic", parameters.get("orderPage_signaturePublic"));
         signatureParams.put("merchantID", parameters.get("merchantID"));
         signatureParams.put("amount", parameters.get("amount"));
         signatureParams.put("currency", parameters.get("currency"));
         signatureParams.put("orderPage_timestamp", parameters.get("orderPage_timestamp"));
         signatureParams.put("orderPage_transactionType", parameters.get("orderPage_transactionType"));
         signatureParams.put("orderPage_version", parameters.get("orderPage_version"));
         signatureParams.put("orderPage_serialNumber", parameters.get("orderPage_serialNumber"));
         return signatureParams;
      }
      return null;
   }

   /**
    * @return the usePaymentInfo
    */
   public boolean isUsePaymentInfo()
   {
      return usePaymentInfo;
   }

   /**
    * @param usePaymentInfo
    *           the usePaymentInfo to set
    */
   public void setUsePaymentInfo(final boolean usePaymentInfo)
   {
      this.usePaymentInfo = usePaymentInfo;
   }

   /**
    * @return the billCode
    */
   public String getBillCode()
   {
      return billCode;
   }

   /**
    * @param billCode
    *           the billCode to set
    */
   public void setBillCode(final String billCode)
   {
      this.billCode = billCode;
   }

   /**
    * @return the emailAddress
    */
   public String getEmailAddress()
   {
      return emailAddress;
   }

   /**
    * @param emailAddress
    *           the emailAddress to set
    */
   public void setEmailAddress(final String emailAddress)
   {
      this.emailAddress = emailAddress;
   }

   /**
    * @return the paymentId
    */
   public String getPaymentId()
   {
      return paymentId;
   }

   /**
    * @param paymentId
    *           the paymentId to set
    */
   public void setPaymentId(final String paymentId)
   {
      this.paymentId = paymentId;
   }

}
