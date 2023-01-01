package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.IServiceProvider;
import com.fawrysystem.app.User.UserModel;

public class WERechrage implements IServiceStrategy {
    private String name = "WERecharge";

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
    public void ExecuteService(UserModel user, IServiceProvider provider) {
//        System.out.println("WERecharge cost is "+getPrice());
        provider.handler(user, getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "WERecharge{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", acceptCash=" + acceptCash +
                '}';
    }
}
