package de.hybris.sdh.facades.populators;

import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.sdh.core.model.SDHExteriorPublicityTaxModel;
import de.hybris.sdh.core.model.SDHGasTaxModel;
import de.hybris.sdh.core.model.SDHICATaxModel;
import de.hybris.sdh.core.model.SDHReteICATaxModel;
import de.hybris.sdh.core.model.SDHRolModel;
import de.hybris.sdh.core.model.SDHUrbanDelineationsTaxModel;
import de.hybris.sdh.facades.questions.data.SDHExteriorPublicityTaxData;
import de.hybris.sdh.facades.questions.data.SDHGasTaxData;
import de.hybris.sdh.facades.questions.data.SDHICATaxData;
import de.hybris.sdh.facades.questions.data.SDHReteICATaxData;
import de.hybris.sdh.facades.questions.data.SDHRolData;
import de.hybris.sdh.facades.questions.data.SDHUrbanDelineationsTaxData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;


public class SDHCustomerPopulator implements Populator<CustomerModel, CustomerData>
{
	@Resource(name = "countryConverter")
	private Converter<CountryModel, CountryData> countryConverter;

	@Override
	public void populate(final CustomerModel source, final CustomerData target) throws ConversionException
	{
		target.setDocumentNumber(source.getDocumentNumber());
		target.setDocumentType(source.getDocumentType());
		target.setFirstName(source.getFirstName());
		target.setMiddleName(source.getMiddleName());
		target.setLastName(source.getLastName());
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

		final StringBuilder nameBuilder = new StringBuilder();

		if ("nit".equalsIgnoreCase(source.getDocumentType()) || "nite".equalsIgnoreCase(source.getDocumentType()))
		{
			if (StringUtils.isNotBlank(source.getNameOrg1()))
			{
				nameBuilder.append(source.getNameOrg1() + " ");
			}
			if (StringUtils.isNotBlank(source.getNameOrg2()))
			{
				nameBuilder.append(source.getNameOrg2() + " ");
			}
			if (StringUtils.isNotBlank(source.getNameOrg3()))
			{
				nameBuilder.append(source.getNameOrg3() + " ");
			}
			if (StringUtils.isNotBlank(source.getNameOrg4()))
			{
				nameBuilder.append(source.getNameOrg4() + " ");
			}
		}
		else
		{

			if (StringUtils.isNotBlank(source.getFirstName()))
			{
				nameBuilder.append(source.getFirstName() + " ");
			}
			if (StringUtils.isNotBlank(source.getMiddleName()))
			{
				nameBuilder.append(source.getMiddleName() + " ");
			}
			if (StringUtils.isNotBlank(source.getLastName()))
			{
				nameBuilder.append(source.getLastName() + " ");
			}
			if (StringUtils.isNotBlank(source.getSecondLastName()))
			{
				nameBuilder.append(source.getSecondLastName() + " ");
			}

		}

		target.setCompleteName(nameBuilder.toString());


		final List<SDHExteriorPublicityTaxModel> peTaxModels = source.getExteriorPublicityTaxList();
		final List<SDHExteriorPublicityTaxData> peTaxDatas = new ArrayList<SDHExteriorPublicityTaxData>();
		if (null != peTaxModels && !peTaxModels.isEmpty())
		{

			for (final SDHExteriorPublicityTaxModel eachModel : peTaxModels)
			{
				final SDHExteriorPublicityTaxData eachData = new SDHExteriorPublicityTaxData();

				eachData.setFenceType(eachModel.getFenceType());
				eachData.setObjectNumber(eachModel.getObjectNumber());
				eachData.setResolutionNumber(eachModel.getResolutionNumber());

				peTaxDatas.add(eachData);
			}

		}
		target.setExteriorPublicityTaxList(peTaxDatas);

		final List<SDHGasTaxModel> gasTaxModels = source.getGasTaxList();
		final List<SDHGasTaxData> gasTaxDatas = new ArrayList<SDHGasTaxData>();
		if (null != gasTaxModels && !gasTaxModels.isEmpty())
		{

			for (final SDHGasTaxModel eachModel : gasTaxModels)
			{
				final SDHGasTaxData eachData = new SDHGasTaxData();

				eachData.setObjectNumber(eachModel.getObjectNumber());
				eachData.setDocumentNumber(eachModel.getDocumentNumber());
				eachData.setDocumentType(eachModel.getDocumentType());

				gasTaxDatas.add(eachData);
			}

		}
		target.setGasTaxList(gasTaxDatas);



		final List<SDHUrbanDelineationsTaxModel> UrbanDelineationsTaxModels = source.getUrbanDelineationsTaxList();
		final List<SDHUrbanDelineationsTaxData> UrbanDelineationsTaxDatas = new ArrayList<SDHUrbanDelineationsTaxData>();
		if (null != UrbanDelineationsTaxModels && !UrbanDelineationsTaxModels.isEmpty())
		{

			for (final SDHUrbanDelineationsTaxModel eachModel : UrbanDelineationsTaxModels)
			{
				final SDHUrbanDelineationsTaxData eachData = new SDHUrbanDelineationsTaxData();

				eachData.setObjectNumber(eachModel.getObjectNumber());
				eachData.setCdu(eachModel.getCdu());
				eachData.setLicenConst(eachModel.getLicenConst());
				eachData.setExpDate(eachModel.getExpDate());

				UrbanDelineationsTaxDatas.add(eachData);
			}

		}

		target.setUrbanDelineationsTaxList(UrbanDelineationsTaxDatas);



		final SDHICATaxModel icaTaxModel = source.getIcaTaxList();
		final SDHICATaxData icaTaxData = new SDHICATaxData();

		if (null != icaTaxModel)
		{

			icaTaxData.setObjectNumber(icaTaxModel.getObjectNumber());

		}

		target.setIcaTax(icaTaxData);


		final SDHReteICATaxModel reteIcaTaxModel = source.getReteIcaTax();
		final SDHReteICATaxData reteIcaTaxData = new SDHReteICATaxData();

		if (null != reteIcaTaxModel)
		{

			reteIcaTaxData.setObjectNumber(reteIcaTaxModel.getObjectNumber());
			reteIcaTaxData.setNumID(reteIcaTaxModel.getNumID());
			reteIcaTaxData.setConsecutive(reteIcaTaxModel.getConsecutive());

		}

		target.setReteIcaTax(reteIcaTaxData);



	}

}
