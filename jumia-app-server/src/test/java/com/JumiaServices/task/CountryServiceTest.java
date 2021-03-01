package com.JumiaServices.task;

import com.JumiaServices.task.Entity.CountryProps;
import com.JumiaServices.task.Service.CountryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void test_getCountryNameFromCountryCode(){
        String code = "212";
        List<CountryProps> countryPropsList = new ArrayList<>();
        countryPropsList.add(new CountryProps(1,"212", "Morocco", "whatever"));
        countryPropsList.add(new CountryProps(2,"256","Uganda","whatever"));
        System.out.print("hellooooo" + countryService.getCountryNameFromCountryCode(countryPropsList, "212"));
       // Should return true
        Assert.assertEquals(countryService.getCountryNameFromCountryCode(countryPropsList,"212"),"Morocco");
        //Should return an empty string
        Assert.assertEquals(countryService.getCountryNameFromCountryCode(countryPropsList, "333"),"");

    }
}
