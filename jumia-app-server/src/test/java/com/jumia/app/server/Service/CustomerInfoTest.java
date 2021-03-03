package com.jumia.app.server.Service;

import com.jumia.app.server.Entity.Customer;
import com.jumia.app.server.Entity.CustomerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.util.Pair;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerInfoTest {
    @Mock
    CustomerService customerService;
    @InjectMocks
    private CustomerInfoService customerInfoService;

    @Test
    public void test_getCustomerInfo(){
        Customer customer1 = new Customer(1,"test1","0111_pNumber");
        Customer customer2 = new Customer(2,"test2","(251) 911203317");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        Map<Customer, Pair> result = new HashMap<>();
        Pair pair1 = Pair.of("countryTest1",false);
        Pair pair2 = Pair.of("Ethiopia",true);
        result.put(customer1,pair1);
        result.put(customer2,pair2);

        Mockito.when(customerService.mapCustomerToCountry()).thenReturn(result);
        CustomerInfo customerInfo1 = new CustomerInfo(1,"test1","0111_pNumber","111","countryTest1","Invalid");
        CustomerInfo customerInfo2 = new CustomerInfo(2,"test2","(251) 911203317","251","Ethiopia","Valid");
        List<CustomerInfo> customerInfoList = new ArrayList<>();
        customerInfoList.add(customerInfo1);
        customerInfoList.add(customerInfo2);
        Collections.sort(customerInfoList, Comparator.comparingInt(CustomerInfo::getId));
        Assert.assertEquals(customerInfoList,customerInfoService.getCustomerInfo());
    }
}
