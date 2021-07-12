package com.company.RentRooms;

import com.company.Dimension;
import com.company.Exceptions.ProblematicTenantException;
import com.company.Exceptions.TooManyThingsException;
import com.company.Interfaces.IRent;
import com.company.Interfaces.IStorage;
import com.company.Item;
import com.company.Persons.Tenant;
import com.company.TenancyInfo;
import com.company.Vehicles.Vehicle;

import java.util.ArrayList;

public class BaseRoom implements IRent, IStorage {
    private static int idCounter = 0;

    protected int id;
    protected float area;
    protected float freeAreaSpace;

    protected TenancyInfo tenancyInfo;
    protected Tenant tenant;

    protected ArrayList<Item> items = new ArrayList<Item>();

    public BaseRoom(float area){
        id = idCounter++;
        this.area = area;
        this.freeAreaSpace = area;

        System.out.println("Created: "+toString());
    }

    public BaseRoom(Dimension dimension){
        id = idCounter++;
        this.area = dimension.getArea();
        this.freeAreaSpace = area;

        System.out.println("Created: "+toString());
    }

    @Override
    public boolean rent(TenancyInfo tenancyInfo) throws ProblematicTenantException {
        if(tenant!=null){
            System.out.println("Room is already rented by: "+tenant.toString());
            return false;
        }

        if(!tenancyInfo.getTenant().canRent()){
            System.out.println(tenancyInfo.getTenant().toString() + " rented too much!");
            return false;
        }

        if(tenancyInfo.getTenant().getDebtLetters().size()>3)
            throw new ProblematicTenantException(tenancyInfo);

        return true;
    }

    @Override
    public void renewRent(TenancyInfo tenancyInfo) {
        this.tenancyInfo = tenancyInfo;
    }

    @Override
    public void cancelRent(Tenant tenant) {
        this.tenant = null;
        tenancyInfo = null;
        System.out.println("Cancelled rent for "+toString()+" by "+tenant.toString());
    }

    @Override
    public void clearSpace() {
        tenant = null;
    }

    @Override
    public void putItem(Item item) throws TooManyThingsException {
        if(item instanceof Vehicle && this instanceof Flat)
        {
            System.out.println("You can't add Vehicle to Flat!");
            return;
        }

        if(item.getArea()<=freeAreaSpace){
            items.add(item);
            freeAreaSpace-=item.getArea();
        }
        else
            throw new TooManyThingsException();
    }

    @Override
    public void removeItem(Item item) {
        if(item instanceof Vehicle && this instanceof Flat)
        {
            System.out.println("You can't remove Vehicle to Flat!");
            return;
        }

        if(items.contains(item))
        {
            items.remove(item);
            freeAreaSpace+=item.getArea();
        }
        else
            System.out.println(item.getName() +" not found in parking space!");
    }

    public TenancyInfo getTenancyInfo() {
        return tenancyInfo;
    }

    public void setTenancyInfo(TenancyInfo tenancyInfo) {
        this.tenancyInfo = tenancyInfo;
    }

    public int getId() {
        return id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "BaseRoom{" +
                "id=" + id +
                ", area=" + area +
                ", freeAreaSpace=" + freeAreaSpace +
                ", tenancyInfo=" + tenancyInfo +
                ", tenant=" + tenant +
                ", items=" + items +
                '}';
    }
}
