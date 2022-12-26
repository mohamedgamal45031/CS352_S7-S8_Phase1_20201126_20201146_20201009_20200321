package com.fawrysystem.app.Service;

public class NGODonation implements IServiceStrategy{
    private String name = "NGODonation";

    private double price;
    private boolean acceptCash = true;


    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }

    public NGODonation() {
        this.price = 100.0;
    }
    public String getName() {
        return name;
    }
    @Override
    public void ExecuteService() {
        System.out.println("NGODonation cost is "+getPrice());

    }

    @Override
    public double getPrice() {
        return price;
    }
}
