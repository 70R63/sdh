package de.hybris.sdh.facades.populators;

import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.sdh.core.model.SDHRolModel;
import de.hybris.sdh.facades.questions.data.SDHRolData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


public class SDHCustomerPopulator implements Populator<CustomerModel, CustomerData>
{
	@Resource(name = "countryConverter")
	private Converter<CountryModel, CountryData> countryConverter;

	@Override
	public void populate(final CustomerModel source, final CustomerData target) throws ConversionException
	{
		target.setDocumentNumber(source.getDocumentNumber());
		target.setMiddleName(source.getMiddleName());
		target.setSecondLastName(source.getSecondLastName());
		target.setDocumentExpeditionDate(source.getDocumentExpeditionDate());
		target.setSex(source.getSex());
		target.setNationality(source.getNationality());
		target.setBirthDate(source.getBirthDate());
		target.setBirthPlace(source.getBirthPlace());
		target.setUseEmailForNotifications(source.getUseEmailForNotifications());
		target.setUseInformationForInstitutionalPurposes(source.getUseInformationForInstitutionalPurposes());

		target.setNumBP(source.getNumBP());

		if (source.getOriginCountry() != null)
		{
			final CountryData countryData = countryConverter.convert(source.getOriginCountry());
			target.setOriginCountry(countryData);

		}

		final List<SDHRolModel> rolModels = source.getRolList();

		final List<SDHRolData> rolDatas = new ArrayList<SDHRolData>();

		if (null != rolModels && !rolModels.isEmpty())
		{
			for (final SDHRolModel eachRolModel : rolModels)
			{
				final SDHRolData eachRolData = new SDHRolData();

				eachRolData.setRol(eachRolModel.getRol());

				rolDatas.add(eachRolData);
			}
		}

		target.setRolList(rolDatas);

	}

}
