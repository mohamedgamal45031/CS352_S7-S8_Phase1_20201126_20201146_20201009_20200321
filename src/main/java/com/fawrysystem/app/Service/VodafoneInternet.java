package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.IServiceProvider;
import com.fawrysystem.app.User.UserModel;

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
    public void ExecuteService(UserModel user, IServiceProvider provider) {
//        System.out.println("Vodafone Internet cost is " + getPrice());
        provider.handler(user, getPrice());

    }

    @Override
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
