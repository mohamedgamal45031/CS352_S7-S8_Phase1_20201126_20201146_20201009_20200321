package com.fawrysystem.app.Service;

public class NGODonation implements IServiceStrategy{
    private String name = "NGODonation";

    private double price= 100.0;;
    private boolean acceptCash = true;
    public void setPrice(double price) {
        this.price = price;
    }

    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }

    public NGODonation() {
    }
    public String getName() {
        return name;
    }
    @Override
    public void ExecuteService() {
        System.out.println("NGODonation cost is "+getPrice());

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
    public double getPrice() {
        return price;
    }
}
