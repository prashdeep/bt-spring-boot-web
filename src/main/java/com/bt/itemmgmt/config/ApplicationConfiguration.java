package com.bt.itemmgmt.config;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

//@ConditionalOnProperty(prefix = "app", name = "createtestbean" , havingValue = "true", matchIfMissing = false)
//@ConditionalOnMissingClass(value = "com.dsfdsfdsf.MyDummyClass")
//@Configuration
@ConfigurationProperties(prefix = "app")
@Component
@Validated
public class ApplicationConfiguration {

//    @Bean
//    public Test testBean(){
///        return  new Test();
//    }

    @NotBlank(message = "company name cannot be blank")
    private String companyName;

    @Range(min = 15000, max = 20000, message = "Employees count should be between 15K to 20K")
    private int noOfEmployees;

    private List<String> locations;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }


}