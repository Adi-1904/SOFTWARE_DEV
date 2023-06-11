package com.example.software_dev.dataitem;

import java.util.ArrayList;

public class SeatBooked {

    public ArrayList<String> kuchbhi;

    public ArrayList<String> getKuchbhi() {
        return kuchbhi;
    }

    public void setKuchbhi(ArrayList<String> kuchbhi) {
        this.kuchbhi = kuchbhi;
    }

    public SeatBooked(ArrayList<String> list){
        kuchbhi = list;
    }
}
