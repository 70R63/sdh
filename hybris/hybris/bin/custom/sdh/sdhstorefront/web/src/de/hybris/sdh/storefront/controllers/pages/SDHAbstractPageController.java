package de.hybris.sdh.storefront.controllers.pages;

import com.google.gson.Gson;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.sdh.core.pojos.responses.CalcGasolina2Response;
import de.hybris.sdh.core.pojos.responses.FirmanteResponse;
import de.hybris.sdh.facades.questions.data.SDHAgentData;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SDHAbstractPageController extends AbstractSearchPageController {

    public void addAgentsToModel(Model model, CustomerData customerData)
    {
        if(CollectionUtils.isNotEmpty(customerData.getAgentList()))
        {
            Map<String, List<SDHAgentData>> agents = new HashMap<String,List<SDHAgentData>>();
            Map<String,String> agentFunctions = new HashMap<String,String>();
            for(SDHAgentData eachAgent : customerData.getAgentList())
            {
                if("-".equalsIgnoreCase(eachAgent.getAgent()))
                {
                    if(agents.containsKey(eachAgent.getInternalFunction().replace(" ","").replace(".","")))
                    {
                        agents.get(eachAgent.getInternalFunction().replace(" ","").replace(".","")).add(eachAgent);
                    }else{
                        List<SDHAgentData> initialList = new ArrayList<SDHAgentData>();
                        initialList.add(eachAgent);
                        agents.put(eachAgent.getInternalFunction().replace(" ","").replace(".",""),initialList);
                        agentFunctions.put(eachAgent.getInternalFunction().replace(" ","").replace(".",""),eachAgent.getInternalFunction());
                    }
                }
            }
            Gson gson = new Gson();
            String agentsString = gson.toJson(agents);
            model.addAttribute("agents", agentsString);
            String agentFunctionsString = gson.toJson(agentFunctions);
            model.addAttribute("agentFunctions", agentFunctionsString);
            model.addAttribute("agentFunctionsMap", agentFunctions);


        }
    }
    public void addAgentsToModel(Model model, CustomerData contribuyente,CustomerData agente)
    {
        if(agente == null){
            model.addAttribute("currentUser",contribuyente);
            model.addAttribute("contribuyente",contribuyente);
        }else{
            model.addAttribute("currentUser",agente);
            model.addAttribute("contribuyente",contribuyente);
        }
    }

    public void addFirmantes(Model model, CalcGasolina2Response calcGasolina2Response,CustomerData representanteData){

        model.addAttribute("showFirmantes",true);
        List<FirmanteResponse> firmantes = calcGasolina2Response.getFirmantes();

        boolean showNewFirmRow= true;
        boolean  showFirmAndAddButton = true;
        boolean  showFirmButton = true;

        if(CollectionUtils.isNotEmpty(firmantes) && firmantes.size()==3) {
            showNewFirmRow = false;
            showFirmAndAddButton=false;
        }
        for(FirmanteResponse eachFirmante : firmantes){
            if(eachFirmante.getNumIdent().equalsIgnoreCase(representanteData.getDocumentNumber())){
                showNewFirmRow=false;

            }
        }

        if(CollectionUtils.isNotEmpty(firmantes) && firmantes.size() == 2 && showNewFirmRow == true){
            showFirmAndAddButton = false;
        }

        model.addAttribute("showFirmButton",showFirmButton);
        model.addAttribute("showNewFirmRow",showNewFirmRow);
        model.addAttribute("showFirmAndAddButton",showFirmAndAddButton);
        model.addAttribute("firmantes",firmantes);


    }


}
