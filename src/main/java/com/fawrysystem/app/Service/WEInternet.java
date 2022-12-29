package com.fawrysystem.app.Service;

public class WEInternet implements IServiceStrategy {
    private String name = "WEInternet";

    private double price;
    private boolean acceptCash = false;

    public void setPrice(double price) {
        this.price = price;
    }
    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    public WEInternet() {
        this.price = 100.0;
    }




    @Override
    public void ExecuteService() {
        System.out.println("WEInternet cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
