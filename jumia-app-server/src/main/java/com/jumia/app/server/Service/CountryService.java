package com.jumia.app.server.Service;

import com.jumia.app.server.Entity.CountryProps;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {


    public String getCountryNameFromCountryCode(List<CountryProps> countryList, String countryCode){
        List<CountryProps> filteredCountryList = countryList.stream().filter(country -> country.getCode().equals(countryCode)).collect(Collectors.toList());
        if(filteredCountryList.isEmpty()){
            return "";
        }
        else {
            return filteredCountryList.get(0).getCountry();
        }
    }
    public boolean getIsPhoneNumberValid(List<CountryProps> countryList, String countryCode, String pNumber){
        List<CountryProps> filteredCountryList = countryList.stream().filter(country -> country.getCode().equals(countryCode)).collect(Collectors.toList());
        if(filteredCountryList.isEmpty()){
            return false;
        }

        else {
            String regex = filteredCountryList.get(0).getRegex();
            return pNumber.matches(regex);
        }
    }
}
