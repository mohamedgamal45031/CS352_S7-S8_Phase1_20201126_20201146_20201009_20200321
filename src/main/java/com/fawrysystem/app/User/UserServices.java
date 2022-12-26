package com.fawrysystem.app.User;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

import java.util.*;
@Service
public class UserServices {
    private ArrayList<UserModel> users = new ArrayList<UserModel>(
            List.of(
                    new UserModel("gemy", "gemy@gmail.com", "123456"),
                    new UserModel("omar", "omar@gmail.com", "123456"),
                    new UserModel("adool", "adool@gmail.com", "123456"),
                    new UserModel("zizo", "zizo@gmail.com", "123456")
            ));

    List<UserModel>getUsers(){
        return users;
    }
    UserModel getUserWithUsername(String username){
        for (UserModel user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;

    }
    UserModel getUserWithEmail(String email){
        for (UserModel user : users) {
            if (user.getUserName().equals(email)) {
                return user;
            }
        }
        return null;
    }


}
