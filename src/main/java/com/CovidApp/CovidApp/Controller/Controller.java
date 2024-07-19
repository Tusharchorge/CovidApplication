package com.CovidApp.CovidApp.Controller;

import com.CovidApp.CovidApp.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid-data")
public class Controller {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/CityWise/{city}")
    public String getCovidCases( @PathVariable String city){
       Integer CovidData= covidDataService.getCovidData(city);
        return "Covid Active Cases in "+city +" = "+CovidData;

    }
}
