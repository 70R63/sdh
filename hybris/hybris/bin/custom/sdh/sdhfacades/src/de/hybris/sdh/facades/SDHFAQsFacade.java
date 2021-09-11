package de.hybris.sdh.facades;

import de.hybris.sdh.facades.faqs.data.SDHFaqCategoryData;
import de.hybris.sdh.facades.faqs.data.SDHFaqData;

import java.util.List;

public interface SDHFAQsFacade {
    List<SDHFaqData> getAllFaqsByCategoryCode(String categoryCode);
    List<SDHFaqData> getAllFaqsByKeyWord(String keyWord);
    List<SDHFaqCategoryData> getAllCategories();

	 List<SDHFaqData> getAllFaqsByCode(String code);
}
