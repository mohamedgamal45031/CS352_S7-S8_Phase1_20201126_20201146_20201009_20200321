package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.ServiceProvider;
import com.fawrysystem.app.User.UserModel;

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
    public void ExecuteService(UserModel user, ServiceProvider provider) {
        user.setWalletBalance(user.getWalletBalance()-getPrice());

        System.out.println("NGODonation cost is "+getPrice());

    }
    public void ExecuteService(ServiceProvider provider){
        System.out.println("NGODonation cost is "+getPrice());
        provider.handler();

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
    @Override
    public double getDiscount() {
        return 0;
    }
}
