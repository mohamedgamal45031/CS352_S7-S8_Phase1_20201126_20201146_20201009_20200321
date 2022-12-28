package com.fawrysystem.app.User;

import com.fawrysystem.app.Search.Search;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

import java.util.*;
@Service
public class UserServices {
    public static UserServices instance = new UserServices();
    private ArrayList<UserModel> users = new ArrayList<UserModel>(
            List.of(
                    new UserModel("gemy", "gemy@gmail.com", "123456",new ArrayList<>(List.of(new Transaction("vodfa",40,true),new Transaction("gamy",50,false)))),
                    new UserModel("omar", "omar@gmail.com", "123456"),
                    new UserModel("adool", "adool@gmail.com", "123456"),
                    new UserModel("zizo", "zizo@gmail.com", "123456")
            ));

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

    void signUp(UserModel userModel ){
        users.add(userModel);
    }

    public static UserServices getInstance(){
        return instance;
    }


}
