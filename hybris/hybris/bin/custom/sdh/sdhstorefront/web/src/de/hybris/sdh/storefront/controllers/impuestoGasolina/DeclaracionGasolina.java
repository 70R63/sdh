
/**
 *
 */

package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;


/**
 * @author fede
 *
 */

@Controller
//@RequestMapping("/sobretasa-gasolina")
public class DeclaracionGasolina extends AbstractSearchPageController
{
	private static final Logger LOG = Logger.getLogger(DeclaracionGasolina.class);

	//Example Controller
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "text.account.profile";

	// CMS Pages
	private static final String DECLARACIONES_GASOLINA_CMS_PAGE = "declaracion-gasolina";

	private static final String REDIRECT_TO_DECLARACIONES_GASOLINA_PAGE = REDIRECT_PREFIX
			+ "/contribuyentes/sobretasa-gasolina/declaracion-gasolina";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhDetalleGasolina")
	SDHDetalleGasolina sdhDetalleGasolinaWS;

	//	@Resource(name = "sdhCalculaGasolina")
	//	SDHDetalleGasolina sdhCalculaGasolinaWS;




}

