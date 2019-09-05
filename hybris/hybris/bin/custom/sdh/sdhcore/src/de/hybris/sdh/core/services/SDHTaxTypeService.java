/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.enums.SdhTaxTypesEnum;
import de.hybris.sdh.core.model.SDHTaxTypeModel;

/**
 * @author hybris
 *
 */
public interface SDHTaxTypeService
{
    SDHTaxTypeModel findUniqueByTaxCode(String taxCode);
    SDHTaxTypeModel findUniqueByTaxByType(SdhTaxTypesEnum taxType);
}
