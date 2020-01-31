package com.bt.itemmgmt.client;

import com.bt.itemmgmt.model.Organization;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class OrganizationFeignClientImpl{
    public Organization getOrganizationById(long organizationId) {
        return new Organization(23, "Default", "India");
    }
}