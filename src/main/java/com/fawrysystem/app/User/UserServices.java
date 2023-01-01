package com.fawrysystem.app.User;

import com.fawrysystem.app.Provider.IServiceProvider;
import com.fawrysystem.app.data.TransactionModel;
import com.fawrysystem.app.data.TransactionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserServices {
    private static int orderNumber = 1000;
    private static UserServices instance = new UserServices();

    //data entity
    private ArrayList<UserModel> users = new ArrayList<UserModel>(
            List.of(
                    new UserModel("gemy", "gemy@gmail.com", "123456",new ArrayList<>(List.of(new Transaction("vodfa",40,true),new Transaction("gamy",50,false)))),
                    new UserModel("omar", "omar@gmail.com", "123456"),
                    new UserModel("adool", "adool@gmail.com", "123456"),
                    new UserModel("zezo", "zezo@gmail.com", "123456")
            ));

    private TransactionService service = TransactionService.getInstance();
    List<UserModel>getUsers(){
        return users;
    }
    UserModel getUser(String username){
        for (UserModel user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;

    }
    String getUserWithUsername(String username){
        for (UserModel user : users) {
            if (user.getUserName().equals(username)) {
                return user.toString();
            }
        }
        return null;

    }
    public List<Transaction> getRefundableRequests(String name){
        List<Transaction> list = new ArrayList<>();
        UserModel user =getUser(name);
        if(user!=null) {
            for (Transaction t : user.getTransactions()) {
                if (!t.isRefundRequested()) {
                    list.add(t);
                }
            }
        }
        return list;
    }
    UserModel getUserWithEmail(String email){
        for (UserModel user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean payService(UserModel user, IServiceProvider provider, double price){
        if (Objects.equals(provider.getProviderName(), "Wallet")){
            if (user.getWalletBalance() >= price){
                user.setWalletBalance(user.getWalletBalance() - price);
                service.addTransaction(new TransactionModel(
                        user, provider.getProviderName(), String.valueOf(orderNumber++), price
                ));
                return true;
            } return false;
        }else {
            // provider logic
            service.addTransaction(new TransactionModel(
                    user, provider.getProviderName(), String.valueOf(orderNumber++), price
            ));
        }
        return true;
    }

    void signUp(UserModel userModel ){
        users.add(userModel);
    }

    public static UserServices getInstance() {
        return instance;
    }
}
