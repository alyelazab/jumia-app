package com.jumia.app.server.Service;

import com.jumia.app.server.Entity.CountryProps;
import com.jumia.app.server.Entity.Customer;
import com.jumia.app.server.Repository.CountryRepo;
import com.jumia.app.server.Repository.CustomerRepo;
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
    private CountryService countryService;

    public List<String> findAllNumbers(){
       return customerRepo.findAll().stream().map(Customer::getP_number).collect(Collectors.toList());
    }

    public Map<Customer, Pair> mapCustomerToCountry(){
        List<CountryProps> countryPropsList = countryRepo.findAll();
        List<Customer> customerList = customerRepo.findAll();
        Map<Customer, Pair> customerToCountryMap = new HashMap<>();

        for(Customer customer : customerList){
            String countryCodeFromPhoneNumber = customer.getP_number().substring(1,4);
            String country = countryService.getCountryNameFromCountryCode(countryPropsList, countryCodeFromPhoneNumber);
            boolean isValid = countryService.getIsPhoneNumberValid(countryPropsList, countryCodeFromPhoneNumber, customer.getP_number());
            Pair pair = Pair.of(country,isValid);
            customerToCountryMap.put(customer, pair);
        }
        return customerToCountryMap;
    }

}
