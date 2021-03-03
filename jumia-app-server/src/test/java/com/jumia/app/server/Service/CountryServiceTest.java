package com.jumia.app.server.Service;

import com.jumia.app.server.Entity.CountryProps;
import com.jumia.app.server.Service.CountryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class CountryServiceTest {
    @InjectMocks
    CountryService countryService;

    @Test
    public void test_getCountryNameFromCountryCode(){

        List<CountryProps> countryPropsList = new ArrayList<>();
        countryPropsList.add(new CountryProps(1,"212", "Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$"));
        countryPropsList.add(new CountryProps(2,"256","Uganda","\\(256\\)\\ ?\\d{9}$"));

        // Should return true
        Assert.assertEquals("Uganda",countryService.getCountryNameFromCountryCode(countryPropsList,"256"));
        //Should return an empty string
        Assert.assertEquals("",countryService.getCountryNameFromCountryCode(countryPropsList, "333"));


    }

    @Test
    public void test_getIsPhoneNumberValid(){
        List<CountryProps> countryPropsList = new ArrayList<>();
        countryPropsList.add(new CountryProps(1,"212", "Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$"));
        countryPropsList.add(new CountryProps(2,"256","Uganda","\\(256\\)\\ ?\\d{9}$"));

        //Should be false, extra 9
        Assert.assertFalse(countryService.getIsPhoneNumberValid(countryPropsList,"212","(212) 6919336269"));
        //Should be true
        Assert.assertTrue(countryService.getIsPhoneNumberValid(countryPropsList,"212","(212) 691933626"));
    }
}
