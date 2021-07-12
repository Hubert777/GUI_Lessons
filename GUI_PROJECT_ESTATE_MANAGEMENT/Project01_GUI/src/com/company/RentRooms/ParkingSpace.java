package com.company.RentRooms;

import com.company.Dimension;
import com.company.Exceptions.ProblematicTenantException;
import com.company.Helpers.Utility;
import com.company.Item;
import com.company.Persons.Tenant;
import com.company.TenancyInfo;
import com.company.Vehicles.Vehicle;

public class ParkingSpace extends BaseRoom {
    public ParkingSpace(float area){
        super(area);
    }

    public ParkingSpace(Dimension dimension){
        super(dimension);
    }

    @Override
    public boolean rent(TenancyInfo tenancyInfo) throws ProblematicTenantException {
        if(!super.rent(tenancyInfo))
            return false;

        for(var flat : tenancyInfo.getTenant().getRentedFlats()){
            if(Utility.getContainingArea(flat) == Utility.getContainingArea(this)){
                this.tenancyInfo = tenancyInfo;
                tenancyInfo.getTenant().getRentedParkingSpaces().add(this);
                System.out.println("Rented: "+toString()+" by: "+tenancyInfo.getTenant().toString());
                return true;
            }
        }

        System.out.println(tenancyInfo.getTenant() + " doesn't rent flat in this residential area!");
        return false;
    }

    @Override
    public void renewRent(TenancyInfo tenancyInfo) {
        super.renewRent(tenancyInfo);
    }

    @Override
    public void cancelRent(Tenant tenant) {
        tenant.getRentedParkingSpaces().remove(this);
        super.cancelRent(tenant);
    }

    @Override
    public void clearSpace() {
        Item itemToRemove=null;
        for(var item : items){
            if(item instanceof Vehicle){
                itemToRemove = item;
            }
        }

        if(itemToRemove!=null){
            items.remove(itemToRemove);
            renewRent(new TenancyInfo(tenancyInfo.getTenant(),tenancyInfo.getStartTenancy(),tenancyInfo.getEndTenancy()+61));
            System.out.println("Sold "+itemToRemove.toString()+ " and extended contract for 2 months!");
            return;
        }

        if(items.size()>0){
            System.out.println("Sold: ");
            items.forEach(x-> System.out.println(x.toString()));
            System.out.println(" and extended contract for 2 months!");
            items.clear();
            renewRent(new TenancyInfo(tenancyInfo.getTenant(),tenancyInfo.getStartTenancy(),tenancyInfo.getEndTenancy()+61));
            return;
        }
        else{
            super.clearSpace();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
