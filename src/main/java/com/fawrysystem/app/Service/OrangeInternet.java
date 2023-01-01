package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.ServiceProvider;
import com.fawrysystem.app.User.UserModel;

public class OrangeInternet implements IServiceStrategy{
    private String name = "OrangeInternet";

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
    public OrangeInternet() {
        this.price = 100.0;
    }
    public String getName() {
        return name;
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
    public void ExecuteService(UserModel user, ServiceProvider provider) {
        user.setWalletBalance(user.getWalletBalance()-getPrice());

        System.out.println("OrangeInternet cost is "+getPrice());
    }
    public void ExecuteService(ServiceProvider provider){
        System.out.println("OrangeInternet cost is "+getPrice());
        provider.handler();

    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public double getDiscount() {
        return 0;
    }
}
