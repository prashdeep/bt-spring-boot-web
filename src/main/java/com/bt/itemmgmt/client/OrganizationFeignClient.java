package com.bt.itemmgmt.client;

import com.bt.itemmgmt.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ORGANIZATIONSERVICE")
public interface OrganizationFeignClient {

    @RequestMapping(
            value = "/api/v1/organization/{id}",
            method = RequestMethod.GET,
            consumes = "application/json"
    )
    Organization getOrganizationById(@PathVariable("id") long organizationId);
}