package com.fawrysystem.app.Provider;

import com.fawrysystem.app.User.UserModel;

public interface IServiceProvider {

    void handler(UserModel user, double price);
    void showPaymentForm(double price);
    String getProviderName();

}
