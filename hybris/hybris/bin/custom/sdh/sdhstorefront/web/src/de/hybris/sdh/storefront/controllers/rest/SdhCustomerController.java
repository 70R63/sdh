package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.dao.impl.DefaultSdhCustomerDao;
import de.hybris.sdh.storefront.controllers.rest.entity.BpResponse;
import de.hybris.sdh.storefront.controllers.rest.entity.Response;
import de.hybris.sdh.storefront.controllers.rest.entity.SdhCustomerUpdate;
import org.hsqldb.lib.StringUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/sdhCustomer")
public class SdhCustomerController {

    @Resource(name = "sdhCustomerDao")
    DefaultSdhCustomerDao sdhCustomerDao;

    @Resource(name = "modelService")
    private ModelService modelService;

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Response update(@RequestBody SdhCustomerUpdate customer){
        Optional<CustomerModel> customerModel = sdhCustomerDao.findByBp(customer.getBp());
        if(customerModel.isPresent()){
            if(Objects.nonNull(customer.getNewEmail()) && !StringUtil.isEmpty(customer.getNewEmail())){
                CustomerModel currentCustomerModel = customerModel.get();
                currentCustomerModel.setUid(customer.getNewEmail());
                modelService.save(currentCustomerModel);
                return new Response("Customer updated successfully");
            }else{
                return new Response("New Customer's password mustn't be empty");
            }
        }else{
            return new Response("Customer not found");
        }
    }

    @RequestMapping(value = "/findByBp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Response findByBp(@RequestBody SdhCustomerUpdate customer){
        Optional<CustomerModel> customerModel = sdhCustomerDao.findByBp(customer.getBp());
        if(customerModel.isPresent()){
            CustomerModel currentCustomerModel = customerModel.get();
            return new Response(currentCustomerModel.getUid());
        }else{
            return new Response("Customer not found");
        }
    }

    @RequestMapping(value = "/findBpByUid", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public BpResponse findBpByCustomerId(@RequestBody SdhCustomerUpdate customer){
        Optional<CustomerModel> customerModel = sdhCustomerDao.findByUid(customer.getUid());
        if(customerModel.isPresent()){
            CustomerModel currentCustomerModel = customerModel.get();
            return new BpResponse(currentCustomerModel.getNumBP());
        }else{
            return new BpResponse("Customer not found");
        }
    }
}
