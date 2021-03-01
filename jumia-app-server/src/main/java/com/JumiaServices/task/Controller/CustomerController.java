package com.JumiaServices.task.Controller;

import com.JumiaServices.task.Entity.Customer;
import com.JumiaServices.task.Entity.CustomerInfo;
import com.JumiaServices.task.Repository.CustomerRepo;
import com.JumiaServices.task.Service.CustomerInfoService;
import com.JumiaServices.task.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "customers")
public class CustomerController {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerInfoService customerInfoService;

    @GetMapping("/getAll")
    public List<String> getAllNumbers(){
        return customerService.findAllNumbers();
    }

    @GetMapping("/getMap")
    public Map<Customer, Pair> getMap(){
        return customerService.mapCustomerToCountry();
    }

    @GetMapping("/getInfo")
    public List<CustomerInfo> getInfo(){
        return customerInfoService.getCustomerInfo();
    }
}
