/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.enums.SdhTaxTypesEnum;
import de.hybris.sdh.core.model.SDHTaxTypeModel;
import de.hybris.sdh.core.pojos.requests.FileConsultaRequest;
import de.hybris.sdh.core.pojos.responses.FileConsultaResponse;

/**
 * @author hybris
 *
 */
public interface SDHFileConsultaService
{
    FileConsultaResponse consultar(FileConsultaRequest fileConsultaRequest);
}
