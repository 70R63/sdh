package de.hybris.sdh.facades.impl;

import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.model.SdhFAQsModel;
import de.hybris.sdh.core.services.SDHFAQsService;
import de.hybris.sdh.facades.SDHFAQsFacade;
import de.hybris.sdh.facades.faqs.data.SDHFaqCategoryData;
import de.hybris.sdh.facades.faqs.data.SDHFaqData;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

public class DefaultSDHFAQsFacade implements SDHFAQsFacade {
    private SDHFAQsService sdhFAQsService;
    private ModelService modelService;

    @Override
    public List<SDHFaqData> getAllFaqsByCategoryCode(String categoryCode) {
        List<SDHFaqData> faqDataList = new ArrayList<>();
        getSdhFAQsService().getFAQsByCategory(getSdhFAQsService()
                .getCategoryByCode(categoryCode)).forEach( faqModel ->{
            faqDataList.add(buildFaqData(faqModel));
        });
        return faqDataList;
    }

    @Override
    public List<SDHFaqData> getAllFaqsByKeyWord(String keyWord) {
        List<SDHFaqData> faqDataList = new ArrayList<>();
        getSdhFAQsService().getFAQsByKeyWord(keyWord).forEach(faqModel ->{
            faqDataList.add(buildFaqData(faqModel));
        });
        return faqDataList;
    }

    private SDHFaqData buildFaqData(SdhFAQsModel sdhFAQsModel){
        SDHFaqData faqData = new SDHFaqData();
        faqData.setCode(sdhFAQsModel.getCode());
        faqData.setQuestion(sdhFAQsModel.getQuestion());
        faqData.setAnswer(sdhFAQsModel.getAnswer());

        sdhFAQsModel.setSearchCounter(sdhFAQsModel.getSearchCounter() + 1);
        getModelService().save(sdhFAQsModel);
        return faqData;
    }

    @Override
    public List<SDHFaqCategoryData> getAllCategories() {
        List<SDHFaqCategoryData> faqCategoriesDataList = new ArrayList<>();
        getSdhFAQsService().getAllCategories().forEach(categoryModel -> {
            SDHFaqCategoryData categoryData = new SDHFaqCategoryData();
            categoryData.setCode(categoryModel.getCode());
            categoryData.setDescription(categoryModel.getDescription());
            faqCategoriesDataList.add(categoryData);
        });
        return faqCategoriesDataList;
    }

    public SDHFAQsService getSdhFAQsService() {
        return sdhFAQsService;
    }

    @Required
    public void setSdhFAQsService(SDHFAQsService sdhFAQsService) {
        this.sdhFAQsService = sdhFAQsService;
    }

    public ModelService getModelService() { return modelService; }

    @Required
    public void setModelService(ModelService modelService) { this.modelService = modelService; }
}
