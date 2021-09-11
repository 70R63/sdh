/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.sdh.core.pojos.requests.UpdateEmailRitRequest;
import de.hybris.sdh.core.pojos.responses.ImpGasolinaSimpliResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;


/**
 * @author hybris
 *
 */
public interface SDHCustomerAccountService
{
	void activateAccount(final String token) throws TokenInvalidatedException;
	boolean isUserRegistered(String documentNumber, String documentType);
	boolean isUserRegisteredByNumBP(String numBP);
	String generateCustomerSessionToken(String bp);
	boolean validateToken(String token, String uidUser);

	String updateEmailRit(UpdateEmailRitRequest request);

	String updateAutorizacionesRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateRedesSocialesRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateTelefonoRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateAddressRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateNameRit(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateRols(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	String updateBasicData(SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse);

	void updateMiRitInfo();

	CustomerModel updateMiRitInfo(CustomerModel customerModel);

	public CustomerModel updateMiRitInfo_simplificado(final CustomerModel customerModel, final String indicador);

	CustomerModel updateImpuestoVehicular_simplificado(final CustomerModel customerModel, List<ImpuestoVehiculos> vehiculos);

	void setAutorityOnSession(String role);

	void cleanSessionAutorities();

	void updateCustomerTaxRestrictions();

	//mapea infoContrib, adicionales, redes sociales del CustomerModel a SDHValidaMailRolResponse
	SDHValidaMailRolResponse getBPDataFromCustomer(final CustomerModel customerModel);

	//mapea usando getBPDataFromCustomer y despues lee de SAP los impuestos
	SDHValidaMailRolResponse getBPAndTaxDataFromCustomer(final CustomerModel customerModel, String taxCode);

	//mapea usando getBPDataFromCustomer y despues lee de SAP los impuestos 
	SDHValidaMailRolResponse getBPAndTaxDataFromCustomer(final String numBP, String taxCode);

	//leer customer desde SAP con validaContrib
	public SDHValidaMailRolResponse consultaContribuyenteBP_simplificado(String numBP, String indicador);

	//leer Representado de Agente Autorizado al seleccionar ingresar
	SDHValidaMailRolResponse getRepresentadoFromSAP_ingresar(final String numBP);

	//mapea de customer model a SDHValidaMailRolResponse
	SDHValidaMailRolResponse mapearInfo(CustomerModel customerModel);

	//mapea de SDHValidaMailRolResponse a CustomerData
	CustomerData mapearInfo_CustomerData(SDHValidaMailRolResponse sdhValidaMailRolResponse);

	//mapea de SDHValidaMailRolResponse a customerModel
	CustomerModel mapearInfo(SDHValidaMailRolResponse sdhValidaMailRolResponse);

	void updateImpuestoGasolina_simplificado(CustomerModel customerModel, ImpGasolinaSimpliResponse gasolinaSimpliResponse);

}
