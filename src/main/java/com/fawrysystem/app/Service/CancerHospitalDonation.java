package com.fawrysystem.app.Service;

public class CancerHospitalDonation implements IServiceStrategy{
    private double price;
    private boolean acceptCash = true;


    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    private String name = "CancerHospitalDonation";
    public String getName() {
        return name;
    }
    public CancerHospitalDonation() {
        this.price = 100.0;
    }

    @Override
    public void ExecuteService() {
        System.out.println("CancerHospitalDonation cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
