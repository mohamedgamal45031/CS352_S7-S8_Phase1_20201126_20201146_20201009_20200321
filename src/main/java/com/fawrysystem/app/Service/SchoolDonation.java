package com.fawrysystem.app.Service;

public class SchoolDonation implements IServiceStrategy{
    private String name = "SchoolDonation";

    private double price=100.0;
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

    public SchoolDonation() {
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
        System.out.println("SchoolDonation cost is "+getPrice());
    }
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
