package com.company.RentRooms;

import com.company.Dimension;
import com.company.Exceptions.ProblematicTenantException;
import com.company.Persons.Person;
import com.company.Persons.Tenant;
import com.company.TenancyInfo;

import java.util.ArrayList;

public class Flat extends BaseRoom{
    private ArrayList<Person> residents;

    public Flat(float area){
        super(area);
    }

    public Flat(Dimension dimension){
        super(dimension);
    }

    @Override
    public boolean rent(TenancyInfo tenancyInfo) throws ProblematicTenantException{
        if(!super.rent(tenancyInfo))
            return false;

        this.tenancyInfo = tenancyInfo;
        tenancyInfo.getTenant().getRentedFlats().add(this);
        System.out.println("Rented: "+toString()+" by: "+tenancyInfo.getTenant().toString());
        return true;
    }

    @Override
    public void renewRent(TenancyInfo tenancyInfo) {
        super.renewRent(tenancyInfo);
    }

    @Override
    public void cancelRent(Tenant tenant) {
        tenancyInfo.getTenant().getRentedFlats().remove(this);
        super.cancelRent(tenant);
    }

    @Override
    public void clearSpace() {
        residents.clear();
        tenancyInfo.getTenant().getRentedFlats().remove(this);
        super.clearSpace();
    }

    public void Register(Person person){
        residents.add(person);
    }

    public void Unregister(Person person){
        if(residents.contains(person))
            residents.remove(person);
        else
            System.out.println(person.toString()+" doesn't live in "+ toString());
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", area=" + area +
                ", freeAreaSpace=" + freeAreaSpace +
                ", tenancyInfo=" + tenancyInfo +
                ", tenant=" + tenant +
                ", items=" + items +
                ", residents=" + residents +
                '}';
    }
}
