package com.company;

import com.company.Persons.Tenant;

public class TenancyInfo {
    private Tenant tenant;
    private int startTenancy;
    private int endTenancy;

    public Tenant getTenant() {return tenant;}
    public int getStartTenancy() {return startTenancy;}
    public int getEndTenancy() { return endTenancy; }

    public TenancyInfo(Tenant tenant,int startTenancy,int endTenancy){
        this.tenant = tenant;
        this.startTenancy = startTenancy;
        this.endTenancy = endTenancy;
    }
}
