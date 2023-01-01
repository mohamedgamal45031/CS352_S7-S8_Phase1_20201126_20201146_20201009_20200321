package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.ServiceProvider;
import com.fawrysystem.app.User.UserModel;

public class Discount implements IServiceStrategy{
    private double price;
    private double discount = 0.0;
    private IServiceStrategy discountedService;
    private String name;
    private boolean acceptCash = false;
    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    public Discount(double discount, IServiceStrategy discountedService) {
        this.discount=discount;
        this.discountedService=discountedService;
        this.price = discountedService.getPrice()-((discount/100)*discountedService.getPrice());
        this.name= discountedService.getName();
        this.acceptCash = discountedService.isAcceptCash();
    }
    public String getName(){
        return name;
    }

    public double getDiscount() {
        return discount;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public void ExecuteService(UserModel user, ServiceProvider provider) {
        user.setWalletBalance(user.getWalletBalance()-getPrice());

        System.out.println("the cost of the service after discount is : "+getPrice());
    }
    public void ExecuteService(ServiceProvider provider){
        System.out.println("the cost of the service after discount is : "+getPrice());
        provider.handler();

    }
    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "price=" + price +
                ", discount=" + discount +
                ", discountedservice=" + discountedService +
                ", name='" + name + '\'' +
                ", acceptCash=" + acceptCash +
                '}';
    }
}
