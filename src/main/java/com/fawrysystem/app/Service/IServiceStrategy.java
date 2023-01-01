package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.IServiceProvider;
import com.fawrysystem.app.User.UserModel;

public interface IServiceStrategy {
    void ExecuteService(UserModel user, IServiceProvider provider);
    double getPrice();
    String getName();
    void setPrice(double x) ;
    void setAcceptCash(boolean acceptCash);
    boolean isAcceptCash() ;
}
