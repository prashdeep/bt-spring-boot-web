package com.bt.itemmgmt.service;

import com.bt.itemmgmt.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

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
    }
}