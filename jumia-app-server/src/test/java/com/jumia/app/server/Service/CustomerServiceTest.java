package com.jumia.app.server.Service;

import com.jumia.app.server.Entity.CountryProps;
import com.jumia.app.server.Entity.Customer;
import com.jumia.app.server.Repository.CountryRepo;
import com.jumia.app.server.Repository.CustomerRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepo customerRepoMock;
    @Mock
    CountryRepo countryRepoMock;
    @Mock
    CountryService countryServiceMock;
    @InjectMocks
    private CustomerService customerService;


    @Test
    public void test_findAllNumber(){
        Customer customer1 = new Customer(1,"test1","0111_pNumber");
        Customer customer2 = new Customer(2,"test2","(251) 911203317");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        Mockito.when(customerRepoMock.findAll()).thenReturn(customerList);
        List<String> numbersList = new ArrayList<>();
        numbersList.add("0111_pNumber");
        numbersList.add("(251) 911203317");
        Assert.assertEquals(numbersList,customerService.findAllNumbers());
    }

    @Test
    public void test_mapCustomerToCountry(){
        Customer customer1 = new Customer(1,"test1","0111_pNumber");
        Customer customer2 = new Customer(2,"test2","(251) 911203317");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        CountryProps countryProps1 = new CountryProps(1,"111","countryTest1","whatever1");
        CountryProps countryProps2 = new CountryProps(2,"251","Ethiopia","\\(251\\)\\ ?[1-59]\\d{8}$");
        List<CountryProps> countryPropsList = new ArrayList<>();
        countryPropsList.add(countryProps1);
        countryPropsList.add(countryProps2);

        Map<Customer, Pair> result = new HashMap<>();
        Pair pair1 = Pair.of("countryTest1",false);
        Pair pair2 = Pair.of("Ethiopia",true);
        result.put(customer1,pair1);
        result.put(customer2,pair2);

        Mockito.when(customerRepoMock.findAll()).thenReturn(customerList);
        Mockito.when(countryRepoMock.findAll()).thenReturn(countryPropsList);
        Mockito.when(countryServiceMock.getCountryNameFromCountryCode(Mockito.anyList(), Mockito.eq("111")))
                .thenReturn("countryTest1");
        Mockito.when(countryServiceMock.getCountryNameFromCountryCode(Mockito.anyList(), Mockito.eq("251")))
                .thenReturn("Ethiopia");
        Mockito.when(countryServiceMock.getIsPhoneNumberValid(Mockito.eq(countryPropsList),Mockito.eq("111"),Mockito.eq("0111_pNumber")))
                .thenReturn(false);
        Mockito.when(countryServiceMock.getIsPhoneNumberValid(Mockito.eq(countryPropsList),Mockito.eq("251"),Mockito.eq("(251) 911203317")))
                .thenReturn(true);


        Assert.assertEquals(result,customerService.mapCustomerToCountry());
    }
}
