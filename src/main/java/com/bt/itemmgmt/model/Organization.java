package com.bt.itemmgmt.model;

public class Organization {

    private  long organizationId;
    private  String name;
    private  String location;

    public Organization(){}

    public Organization(long organizationId, String name, String location) {
        this.organizationId = organizationId;
        this.name = name;
        this.location = location;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}