package com.fawrysystem.app.Service;

public class WERechrage implements IServiceStrategy {
    private String name = "WERechrage";

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
    public WERechrage() {
        this.price = 100.0;
    }




    @Override
    public void ExecuteService() {
        System.out.println("WERechrage cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
