package com.JumiaServices.task.Service;

import com.JumiaServices.task.Entity.CountryProps;
import com.JumiaServices.task.Entity.Customer;
import com.JumiaServices.task.Repository.CountryRepo;
import com.JumiaServices.task.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CountryService service;

    public List<String> findAllNumbers(){
       return customerRepo.findAll().stream().map(Customer::getP_number).collect(Collectors.toList());
    }

    public Map<Customer, Pair> mapCustomerToCountry(){
        List<CountryProps> countryPropsList = countryRepo.findAll();
        List<Customer> customerList = customerRepo.findAll();
        Map<Customer, Pair> customerToCountryMap = new HashMap<>();

        for(Customer customer : customerList){
            String countryCodeFromPhoneNumber = customer.getP_number().substring(1,4);
            String country = service.getCountryNameFromCountryCode(countryPropsList, countryCodeFromPhoneNumber);
            boolean isValid = service.getIsPhoneNumberValid(countryPropsList, countryCodeFromPhoneNumber, customer.getP_number());
            Pair pair = Pair.of(country,isValid);
            customerToCountryMap.put(customer, pair);
        }
        return customerToCountryMap;
    }

}
