package com.bt.itemmgmt.service;

import com.bt.itemmgmt.client.OrganizationFeignClient;
import com.bt.itemmgmt.model.Organization;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired(required = false)
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

   /*
     Naive implementation using RestTemplate
    @Override
    public Organization getOrgById(int id) {
        String organizationservice = this.discoveryClient
                .getInstances("ORGANIZATIONSERVICE")
                .get(0)
                .getUri()
                .toString();

        System.out.println("Service Uri "+ organizationservice);

        Organization organization = this.restTemplate
                .getForObject(  organizationservice + "/api/v1/organization/"+id, Organization.class);

        return organization;
    }*/

    // With Ribbon
    /*@Override
    public Organization getOrgById(int id) {
        Organization organization = this.restTemplate
                .getForObject(    "http://ORGANIZATIONSERVICE/api/v1/organization/"+id, Organization.class);

        return organization;
    }*/
    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public Organization getOrgById(int id) {
        latency();
        Organization organization = this.organizationFeignClient.getOrganizationById(id);
        return organization;
    }

    private void latency(){
        Random random = new Random();
        int value = random.nextInt(3) + 1;
        if (value == 3){
            System.out.println("*************");
            System.out.println("Came inside ");
            System.out.println("*************");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public Organization fallback(int id) {
        return new Organization(44,"Default", "India");
    }
}