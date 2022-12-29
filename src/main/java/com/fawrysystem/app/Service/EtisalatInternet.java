package com.fawrysystem.app.Service;

public class EtisalatInternet implements IServiceStrategy{

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
    private String name = "EtisalatInternet";
    public String getName() {
        return name;
    }
    public EtisalatInternet() {
        this.price = 100.0;
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
        System.out.println("EtisalatInternet cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
