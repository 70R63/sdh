package de.hybris.sdh.storefront.controllers.pages;

import com.google.gson.Gson;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.commercefacades.user.data.CustomerData;
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


}
