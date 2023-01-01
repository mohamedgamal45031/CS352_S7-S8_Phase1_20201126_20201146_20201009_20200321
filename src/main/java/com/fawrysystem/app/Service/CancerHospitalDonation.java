package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.ServiceProvider;
import com.fawrysystem.app.User.UserModel;

public class CancerHospitalDonation implements IServiceStrategy{
    private double price;
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
    private String name = "CancerHospitalDonation";
    public String getName() {
        return name;
    }
    public CancerHospitalDonation() {
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
    public void ExecuteService(UserModel user, ServiceProvider provider){
        user.setWalletBalance(user.getWalletBalance()-getPrice());
        System.out.println("CancerHospitalDonation cost is "+getPrice());
    }
    public void ExecuteService(ServiceProvider provider){
        System.out.println("CancerHospitalDonation cost is "+getPrice());
        provider.handler();

    }


    @Override
    public double getPrice() {
        return price;
    }
}
