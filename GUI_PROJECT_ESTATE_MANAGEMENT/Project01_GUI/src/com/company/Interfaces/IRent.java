package com.company.Interfaces;

import com.company.Exceptions.ProblematicTenantException;
import com.company.Persons.Tenant;
import com.company.TenancyInfo;

public interface IRent {
    boolean rent(TenancyInfo tenancyInfo) throws ProblematicTenantException;
    void renewRent(TenancyInfo tenant);
    void cancelRent(Tenant tenant);
    void clearSpace();
}
