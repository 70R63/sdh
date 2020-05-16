package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.services.SDHFAQsService;
import de.hybris.sdh.facades.SDHFAQsFacade;
import de.hybris.sdh.facades.faqs.data.SDHFaqCategoryData;
import de.hybris.sdh.facades.faqs.data.SDHFaqData;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

public class DefaultSDHFAQsFacade implements SDHFAQsFacade {
    private SDHFAQsService sdhFAQsService;

    @Override
    public List<SDHFaqData> getAllFaqsByCategoryCode(String categoryCode) {
        List<SDHFaqData> faqDataList = new ArrayList<>();
        getSdhFAQsService().getFAQsByCategory(getSdhFAQsService().getCategoryByCode(categoryCode)).
                forEach(faq ->{
                    SDHFaqData faqData = new SDHFaqData();
                    faqData.setCode(faq.getCode());
                    faqData.setQuestion(faq.getQuestion());
                    faqData.setAnswer(faq.getAnswer());
                    faqDataList.add(faqData);
                });
        return faqDataList;
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
}
