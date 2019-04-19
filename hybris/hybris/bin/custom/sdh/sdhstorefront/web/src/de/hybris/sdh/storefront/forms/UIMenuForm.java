/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.responses.NombreRolResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.facades.questions.data.SDHRolData;
import de.hybris.sdh.storefront.controllers.pages.MiRitCertificacionPageController;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author Consultor
 *
 */
public class UIMenuForm
{

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	//log
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private String bPredial;
	private String bVehicular;
	private String bIca;
	private String bPublicidadExt;
	private String bSobreGasolina;
	private String bDelineacionUrbana;
	private List<NombreRolResponse> roles;




	public void fillForm(final SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse)
	{
		try
		{

			if (sdhConsultaContribuyenteBPResponse.getRoles() != null && !sdhConsultaContribuyenteBPResponse.getRoles().isEmpty())
			{
				this.setRoles(sdhConsultaContribuyenteBPResponse.getRoles());
			}

			//private String bPredial;
			//private String bVehicular;
			//private String bIca;
			if (sdhConsultaContribuyenteBPResponse.getGasolina() != null
					&& !sdhConsultaContribuyenteBPResponse.getGasolina().isEmpty())
			{
				this.setbSobreGasolina("X");
			}
			else
			{
				this.setbSobreGasolina("");
			}

			if (sdhConsultaContribuyenteBPResponse.getPublicidadExt() != null
					&& !sdhConsultaContribuyenteBPResponse.getPublicidadExt().isEmpty())
			{
				this.setbPublicidadExt("X");
			}
			else
			{
				this.setbPublicidadExt("");
			}

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
		}
	}

	public void fillForm(final CustomerData customerData)
	{
		try
		{

			if (customerData.getRolList() != null && !customerData.getRolList().isEmpty())
			{
				final List<NombreRolResponse> roles = new ArrayList<NombreRolResponse>();

				for (final SDHRolData eachRol : customerData.getRolList())
				{
					final NombreRolResponse rol = new NombreRolResponse();
					rol.setNombreRol(eachRol.getRol());
					roles.add(rol);
				}

				this.setRoles(roles);
			}

			//private String bPredial;
			//private String bVehicular;
			//private String bIca;
			if (customerData.getGasTaxList() != null && !customerData.getGasTaxList().isEmpty())
			{
				this.setbSobreGasolina("X");
			}
			else
			{
				this.setbSobreGasolina("");
			}

			if (customerData.getExteriorPublicityTaxList() != null && !customerData.getExteriorPublicityTaxList().isEmpty())
			{
				this.setbPublicidadExt("X");
			}
			else
			{
				this.setbPublicidadExt("");
			}

			if (customerData.getUrbanDelineationsTaxList() != null && !customerData.getUrbanDelineationsTaxList().isEmpty())
			{
				this.setbDelineacionUrbana("X");
			}
			else
			{
				this.setbDelineacionUrbana("");
			}

		}
		catch (final Exception e)
		{
			LOG.error("error getting customer info from SAP for Mi RIT Certificado page: " + e.getMessage());
		}
	}

	/**
	 * @return the roles
	 */
	public List<NombreRolResponse> getRoles()
	{
		return roles;
	}

	/**
	 * @param roles
	 *           the roles to set
	 */
	public void setRoles(final List<NombreRolResponse> roles)
	{
		this.roles = roles;
	}

	/**
	 * @return the bPredial
	 */
	public String getbPredial()
	{
		return bPredial;
	}

	/**
	 * @param bPredial
	 *           the bPredial to set
	 */
	public void setbPredial(final String bPredial)
	{
		this.bPredial = bPredial;
	}

	/**
	 * @return the bVehicular
	 */
	public String getbVehicular()
	{
		return bVehicular;
	}

	/**
	 * @param bVehicular
	 *           the bVehicular to set
	 */
	public void setbVehicular(final String bVehicular)
	{
		this.bVehicular = bVehicular;
	}

	/**
	 * @return the bIca
	 */
	public String getbIca()
	{
		return bIca;
	}

	/**
	 * @param bIca
	 *           the bIca to set
	 */
	public void setbIca(final String bIca)
	{
		this.bIca = bIca;
	}

	/**
	 * @return the bPublicidadExt
	 */
	public String getbPublicidadExt()
	{
		return bPublicidadExt;
	}

	/**
	 * @param bPublicidadExt
	 *           the bPublicidadExt to set
	 */
	public void setbPublicidadExt(final String bPublicidadExt)
	{
		this.bPublicidadExt = bPublicidadExt;
	}

	/**
	 * @return the bSobreGasolina
	 */
	public String getbSobreGasolina()
	{
		return bSobreGasolina;
	}

	/**
	 * @param bSobreGasolina
	 *           the bSobreGasolina to set
	 */
	public void setbSobreGasolina(final String bSobreGasolina)
	{
		this.bSobreGasolina = bSobreGasolina;
	}

	/**
	 * @return the bDelineacionUrbana
	 */
	public String getbDelineacionUrbana()
	{
		return bDelineacionUrbana;
	}

	/**
	 * @param bDelineacionUrbana
	 *           the bDelineacionUrbana to set
	 */
	public void setbDelineacionUrbana(final String bDelineacionUrbana)
	{
		this.bDelineacionUrbana = bDelineacionUrbana;
	}

}
