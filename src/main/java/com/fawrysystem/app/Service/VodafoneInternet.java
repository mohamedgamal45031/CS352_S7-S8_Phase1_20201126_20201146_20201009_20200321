package com.fawrysystem.app.Service;

public class VodafoneInternet implements IServiceStrategy {
    private String name = "VodafoneInternet";

    private double price = 100.0;
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
    public VodafoneInternet() {

    }
    @Override
    public String toString() {
        return "WERechrage{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", acceptCash=" + acceptCash +
                '}';
    }
    @Override
    public void ExecuteService() {
        System.out.println("Vodafone Internet cost is " + getPrice());

    }

    @Override
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
