package com.company;

import com.company.Interfaces.ITime;
import com.company.RentRooms.BaseRoom;

import java.io.File;

public class DebtLetter extends File implements ITime {
    private TenancyInfo tenancyInfo;
    private BaseRoom baseRoom;
    private int day = 0;
    private boolean cleared = false;

    public DebtLetter(String path,TenancyInfo tenancyInfo,BaseRoom baseRoom){
        super(path);

        this.tenancyInfo = tenancyInfo;
        this.baseRoom = baseRoom;

        System.out.println("Created "+baseRoom.toString()+" debt for: "+tenancyInfo.getTenant());
    }

    @Override
    public void nextDay() {
        day+=1;

        if(!cleared && day>=30){
            baseRoom.clearSpace();
            cleared = true;
        }
        System.out.println(tenancyInfo.getTenant()+" is not paying rent for "+baseRoom.toString()+" for "+day+" days!");
    }

    @Override
    public String toString() {
        return "DebtLetter{" +
                "Tenant=" + tenancyInfo.getTenant() +
                ", Start Tenancy=" + tenancyInfo.getStartTenancy() +
                ", End Tenancy=" + tenancyInfo.getEndTenancy() +
                '}';
    }
}
