package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.pojos.responses.FirmanteResponse;
import de.hybris.sdh.facades.questions.data.SDHAgentData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;

import com.google.gson.Gson;


public class SDHAbstractPageController extends AbstractSearchPageController
{

	public void addAgentsToModel(final Model model, final CustomerData customerData)
	{
		if (CollectionUtils.isNotEmpty(customerData.getAgentList()))
		{
			final Map<String, List<SDHAgentData>> agents = new HashMap<String, List<SDHAgentData>>();
			final Map<String, String> agentFunctions = new HashMap<String, String>();
			for (final SDHAgentData eachAgent : customerData.getAgentList())
			{
				if ("-".equalsIgnoreCase(eachAgent.getAgent()))
				{
					if (agents.containsKey(eachAgent.getInternalFunction().replace(" ", "").replace(".", "")))
					{
						agents.get(eachAgent.getInternalFunction().replace(" ", "").replace(".", "")).add(eachAgent);
					}
					else
					{
						final List<SDHAgentData> initialList = new ArrayList<SDHAgentData>();
						initialList.add(eachAgent);
						agents.put(eachAgent.getInternalFunction().replace(" ", "").replace(".", ""), initialList);
						agentFunctions.put(eachAgent.getInternalFunction().replace(" ", "").replace(".", ""),
								eachAgent.getInternalFunction());
					}
				}
			}
			final Gson gson = new Gson();
			final String agentsString = gson.toJson(agents);
			model.addAttribute("agents", agentsString);
			final String agentFunctionsString = gson.toJson(agentFunctions);
			model.addAttribute("agentFunctions", agentFunctionsString);
			model.addAttribute("agentFunctionsMap", agentFunctions);


		}
	}

	public void addAgentsToModel(final Model model, final CustomerData contribuyente, final CustomerData agente)
	{
		if (agente == null)
		{
			model.addAttribute("currentUser", contribuyente);
			model.addAttribute("contribuyente", contribuyente);
		}
		else
		{
			model.addAttribute("currentUser", agente);
			model.addAttribute("contribuyente", contribuyente);
		}
	}

	public void addFirmantes(final Model model, final CalcGasolina2Response calcGasolina2Response,
			final CustomerData representanteData)
	{

		model.addAttribute("showFirmantes", true);
		final List<FirmanteResponse> firmantes = calcGasolina2Response.getFirmantes();

		boolean showNewFirmRow = true;
		boolean showFirmAndAddButton = true;
		final boolean showFirmButton = true;

		if (CollectionUtils.isNotEmpty(firmantes) && firmantes.size() == 3)
		{
			showNewFirmRow = false;
			showFirmAndAddButton = false;
		}
		for (final FirmanteResponse eachFirmante : firmantes)
		{
			if (eachFirmante.getNumIdent().equalsIgnoreCase(representanteData.getDocumentNumber()))
			{
				showNewFirmRow = false;

			}
		}

		if (CollectionUtils.isNotEmpty(firmantes) && firmantes.size() == 2 && showNewFirmRow == true)
		{
			showFirmAndAddButton = false;
		}

		model.addAttribute("showFirmButton", showFirmButton);
		model.addAttribute("showNewFirmRow", showNewFirmRow);
		model.addAttribute("showFirmAndAddButton", showFirmAndAddButton);
		model.addAttribute("firmantes", firmantes);


	}

	public void addFirmantes_impuesto(final Model model, List<FirmanteResponse> firmantes,
			final CustomerData representanteData)
	{

		model.addAttribute("showFirmantes", true);
		final List<FirmanteResponse> firmantes_tmp = new ArrayList<FirmanteResponse>();
		//       List<FirmanteResponse> firmantes = calcGasolina2Response.getFirmantes();

		boolean showNewFirmRow = true;
		boolean showFirmAndAddButton = true;
		final boolean showFirmButton = true;

		//Elimina los firmantes vacios (que no tengan tipo de documento se consideran vacios)
		if (firmantes != null)
		{
			for (final FirmanteResponse eachFirmante : firmantes)
			{
				if (eachFirmante.getTipoIdent() != null && !StringUtils.isAllBlank(eachFirmante.getTipoIdent()))
				{
					firmantes_tmp.add(eachFirmante);
				}
			}
		}
		firmantes = firmantes_tmp;

		if (CollectionUtils.isNotEmpty(firmantes) && firmantes.size() == 3)
		{
			showNewFirmRow = false;
			showFirmAndAddButton = false;
		}
		for (final FirmanteResponse eachFirmante : firmantes)
		{
			if (eachFirmante.getNumIdent() != null)
			{
				if (eachFirmante.getNumIdent().equalsIgnoreCase(representanteData.getDocumentNumber()))
				{
					showNewFirmRow = false;
				}
			}
		}

		if (CollectionUtils.isNotEmpty(firmantes) && firmantes.size() == 2 && showNewFirmRow == true)
		{
			showFirmAndAddButton = false;
		}

		model.addAttribute("showFirmButton", showFirmButton);
		model.addAttribute("showNewFirmRow", showNewFirmRow);
		model.addAttribute("showFirmAndAddButton", showFirmAndAddButton);
		model.addAttribute("firmantes", firmantes);


	}


}
