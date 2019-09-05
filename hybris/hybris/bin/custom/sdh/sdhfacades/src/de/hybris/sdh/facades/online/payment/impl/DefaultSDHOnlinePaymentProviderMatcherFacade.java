package de.hybris.sdh.facades.online.payment.impl;


import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.sdh.core.dao.impl.*;
import de.hybris.sdh.core.enums.SdhOnlinePaymentProviderEnum;
import de.hybris.sdh.core.enums.SdhPaymentMethodTypeEnum;
import de.hybris.sdh.core.enums.SdhTaxTypesEnum;
import de.hybris.sdh.core.model.OlnPymntPvdMatcherModel;
import de.hybris.sdh.core.model.PseBankListCatalogModel;
import de.hybris.sdh.core.model.SDHPaymentMethodModel;
import de.hybris.sdh.core.model.SDHTaxTypeModel;
import de.hybris.sdh.core.services.impl.DefaultSDHOlinePaymentProviderMatcherService;
import de.hybris.sdh.core.services.impl.DefaultSDHPaymentMethodService;
import de.hybris.sdh.core.services.impl.DefaultSDHTaxTypeService;
import de.hybris.sdh.facades.online.payment.SDHOnlinePaymentProviderMatcherFacade;
import de.hybris.sdh.facades.online.payment.data.OnlinePaymentSelectInputBoxData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class DefaultSDHOnlinePaymentProviderMatcherFacade implements SDHOnlinePaymentProviderMatcherFacade {
    private static final Logger LOG = Logger.getLogger(DefaultSDHOnlinePaymentProviderMatcherFacade.class);

    @Resource(name = "sdhTaxTypeService")
    private DefaultSDHTaxTypeService sdhTaxTypeService;

    @Resource(name = "sdhPaymentMethodService")
    private DefaultSDHPaymentMethodService sdhPaymentMethodService;

    @Resource(name = "pseBankListCatalogDao")
    private DefaultPseBankListCatalogDao pseBankListCatalogDao;

    @Resource(name = "sdhOlinePaymentProviderMatcherService")
    private DefaultSDHOlinePaymentProviderMatcherService sdhOlinePaymentProviderMatcherService;

    private Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> onlinePaymentMatcherFullPaymentMethodConverter;
    private Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> onlinePaymentMatcherFullBankConverter;
    private Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> onlinePaymentMatcherFullProviderConverter;


    @Override
    public SdhTaxTypesEnum getTaxByCode(String taxCode) {
        SDHTaxTypeModel taxTypeModel = sdhTaxTypeService.findUniqueByTaxCode(taxCode);
        return taxTypeModel.getSdhTaxType();
    }

    @Override
    public List<OnlinePaymentSelectInputBoxData> getPaymentMethodList(SdhTaxTypesEnum taxType) {
        SDHTaxTypeModel taxTypeModel = sdhTaxTypeService.findUniqueByTaxByType(taxType);
        List<OlnPymntPvdMatcherModel> onlinePaymentProviderMatcherList = sdhOlinePaymentProviderMatcherService.findByTaxType(taxTypeModel);
        List<OnlinePaymentSelectInputBoxData> onlinePaymentProviderMatcherDataList = getOnlinePaymentMatcherFullPaymentMethodConverter().convertAll(onlinePaymentProviderMatcherList);
        return deleteDuplicatedDataFromList(onlinePaymentProviderMatcherDataList);
    }

    @Override
    public List<OnlinePaymentSelectInputBoxData> getBankList(String taxCode, String paymentMethodCode) {
        SDHTaxTypeModel taxTypeModel = sdhTaxTypeService.findUniqueByTaxCode(taxCode);
        SDHPaymentMethodModel paymentMethodModel = sdhPaymentMethodService.findUniqueByPaymentMethodCodeString(paymentMethodCode);
        List<OlnPymntPvdMatcherModel> onlinePaymentProviderMatcherList = sdhOlinePaymentProviderMatcherService.findByTaxTypeAndPaymentMethod(taxTypeModel,paymentMethodModel);
        List<OnlinePaymentSelectInputBoxData> onlinePaymentProviderMatcherDataList = getOnlinePaymentMatcherFullBankConverter().convertAll(onlinePaymentProviderMatcherList);
        return deleteDuplicatedDataFromList(onlinePaymentProviderMatcherDataList);
    }

    @Override
    public SdhOnlinePaymentProviderEnum getOnlinePaymentProvider(String taxCode, String paymentMethodCode, String bankCode) {
        SDHTaxTypeModel taxTypeModel = sdhTaxTypeService.findUniqueByTaxCode(taxCode);
        SDHPaymentMethodModel paymentMethodModel = sdhPaymentMethodService.findUniqueByPaymentMethodCodeString(paymentMethodCode);
        PseBankListCatalogModel bankModel = pseBankListCatalogDao.getBankByFinancialInstitutionCode(bankCode);

        List<OlnPymntPvdMatcherModel> onlinePaymentProviderMatcherList = sdhOlinePaymentProviderMatcherService.findByTaxTypeAndPaymentMethodAndBank(taxTypeModel,paymentMethodModel,bankModel);
        return onlinePaymentProviderMatcherList.stream().findFirst().get().getOnlinePaymentProviderType().getSdhPaymentProvType();
    }

    public Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> getOnlinePaymentMatcherFullPaymentMethodConverter() {
        return onlinePaymentMatcherFullPaymentMethodConverter;
    }

    @Required
    public void setOnlinePaymentMatcherFullPaymentMethodConverter(Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> onlinePaymentMatcherFullPaymentMethodConverter) {
        this.onlinePaymentMatcherFullPaymentMethodConverter = onlinePaymentMatcherFullPaymentMethodConverter;
    }

    public Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> getOnlinePaymentMatcherFullBankConverter() {
        return onlinePaymentMatcherFullBankConverter;
    }

    @Required
    public void setOnlinePaymentMatcherFullBankConverter(Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> onlinePaymentMatcherFullBankConverter) {
        this.onlinePaymentMatcherFullBankConverter = onlinePaymentMatcherFullBankConverter;
    }

    public Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> getOnlinePaymentMatcherFullProviderConverter() {
        return onlinePaymentMatcherFullProviderConverter;
    }

    @Required
    public void setOnlinePaymentMatcherFullProviderConverter(Converter<OlnPymntPvdMatcherModel, OnlinePaymentSelectInputBoxData> onlinePaymentMatcherFullProviderConverter) {
        this.onlinePaymentMatcherFullProviderConverter = onlinePaymentMatcherFullProviderConverter;
    }

    private List<OnlinePaymentSelectInputBoxData> deleteDuplicatedDataFromList(List<OnlinePaymentSelectInputBoxData> dataList){
        return dataList.stream()
                .reduce(new ArrayList<>(), (List<OnlinePaymentSelectInputBoxData> accumulator, OnlinePaymentSelectInputBoxData data) ->
                {
                    if (accumulator.stream().noneMatch(emp -> emp.getCode().equals(data.getCode())))
                    {
                        accumulator.add(data);
                    }
                    return accumulator;
                }, (acc1, acc2) ->
                {
                    acc1.addAll(acc2);
                    return acc1;
                });
    }
}
