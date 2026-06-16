package com.metrowest.entity;

public enum Role
{
    ADMIN,
    MANAGER,
    TECHNICIAN,
    CUSTOMER,

    ;

    public String role_string()
    {
        return "ROLE_" + this.name();
    }
}
