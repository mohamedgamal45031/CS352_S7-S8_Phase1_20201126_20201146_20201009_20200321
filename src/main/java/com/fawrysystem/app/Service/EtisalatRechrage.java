package com.fawrysystem.app.Service;

public class EtisalatRechrage implements IServiceStrategy{

    private double price;
    private boolean acceptCash = false;


    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    private String name = "EtisalatRechrage";

    public String getName() {
        return name;
    }
    public EtisalatRechrage() {
        this.price = 100.0;
    }

    @Override
    public void ExecuteService() {
        System.out.println("EtisalatRechrage cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
