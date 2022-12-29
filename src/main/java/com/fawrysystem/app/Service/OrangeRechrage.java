package com.fawrysystem.app.Service;

public class OrangeRechrage implements IServiceStrategy{

    private String name = "OrangeRechrage";
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
    private double price;

    public OrangeRechrage() {
        this.price = 100.0;
    }


    @Override
    public void ExecuteService() {
        System.out.println("OrangeRechrage cost is "+getPrice());
    }
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
