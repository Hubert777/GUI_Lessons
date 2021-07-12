package com.company.Exceptions;

import com.company.TenancyInfo;

public class ProblematicTenantException extends Exception{
    public ProblematicTenantException(TenancyInfo tenancyInfo){
        super("Person "+tenancyInfo.getTenant()+" already had a lease of premises: "+tenancyInfo.getTenant().getDebtLetters().toString());
    }
}
