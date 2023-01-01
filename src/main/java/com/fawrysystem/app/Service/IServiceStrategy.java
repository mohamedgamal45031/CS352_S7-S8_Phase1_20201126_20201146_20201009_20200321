package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.ServiceProvider;
import com.fawrysystem.app.User.UserModel;

public interface IServiceStrategy {
    public void ExecuteService(UserModel user, ServiceProvider provider);
    public void ExecuteService(ServiceProvider provider);
    public  double getPrice();
    public String getName();
    public void setPrice(double x) ;

    public void setAcceptCash(boolean acceptCash);

    public boolean isAcceptCash() ;
    public double getDiscount() ;

}
