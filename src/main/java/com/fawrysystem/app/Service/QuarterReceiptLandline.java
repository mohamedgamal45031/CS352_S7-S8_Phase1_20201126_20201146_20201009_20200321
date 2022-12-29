package com.fawrysystem.app.Service;

public class QuarterReceiptLandline implements IServiceStrategy{
    private String name = "QuarterReceiptLandline";
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

    public QuarterReceiptLandline() {
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
        System.out.println("QuarterReceiptLandline cost is "+getPrice());
    }
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
