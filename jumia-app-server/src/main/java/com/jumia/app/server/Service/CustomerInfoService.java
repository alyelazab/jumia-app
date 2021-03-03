package com.jumia.app.server.Service;

import com.jumia.app.server.Entity.Customer;
import com.jumia.app.server.Entity.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerInfoService {

    @Autowired
    CustomerService customerService;

    public List<CustomerInfo> getCustomerInfo(){
        Map<Customer, Pair> customerPairMap = customerService.mapCustomerToCountry();
        List<CustomerInfo> customerInfoList = new ArrayList<>();
        for(Map.Entry<Customer, Pair> entry: customerPairMap.entrySet()){
            Customer customer = entry.getKey();
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setId(customer.getId());
            customerInfo.setCountry(entry.getValue().getFirst().toString());
            String countryCodeFromPhoneNumber = customer.getP_number().substring(1,4);
            customerInfo.setCountryCode(countryCodeFromPhoneNumber);
            customerInfo.setName(customer.getName());
            customerInfo.setNumber(customer.getP_number());
            if(entry.getValue().getSecond().equals(false)){
                customerInfo.setState("Invalid");
            }else{
                customerInfo.setState("Valid");
            }
            customerInfoList.add(customerInfo);
        }
        Collections.sort(customerInfoList, Comparator.comparingInt(CustomerInfo::getId));
        return customerInfoList;
    }
}
