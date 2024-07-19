package com.CovidApp.CovidApp.Service;

import com.CovidApp.CovidApp.Controller.Util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CovidDataService {
    @Autowired
    RestTemplate restTemplate;

    public Integer getCovidData(String cityName){


        HashMap<String,Object> StateCityMap=new HashMap<>();
        StateCityMap.put("Agra","Uttar Pradesh");
        StateCityMap.put("Rampur","Uttar Pradesh");
        StateCityMap.put("Noida","Uttar Pradesh");
        StateCityMap.put("Hapur","Uttar Pradesh");
        StateCityMap.put("Amritsar","Punjab");
        StateCityMap.put("Barnala","Punjab");
        StateCityMap.put("Bathinda","Punjab");
        StateCityMap.put("Surat","Gujarat");
        StateCityMap.put("Ahmedabad","Gujarat");
        StateCityMap.put("Pune","Maharashtra");
        StateCityMap.put("Mumbai","Maharashtra");




        Map<String,Object> map=restTemplate.getForObject(Utility.COVID_DATA_API,Map.class);
        Map<String,Object> cityObjectMap=(Map <String,Object>)map.get(StateCityMap.get(cityName));
        Map<String,Object> districtData=(Map <String,Object>)cityObjectMap.get("districtData");
        Map<String,Object> city=(Map <String,Object>)districtData.get(cityName);
        Integer active=(Integer)city.get("active");
        return active;

    }
}
