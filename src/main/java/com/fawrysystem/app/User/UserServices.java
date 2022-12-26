package com.fawrysystem.app.User;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

import java.util.*;

import static com.fasterxml.jackson.core.io.NumberInput.parseLong;

@Service
public class UserServices {
    private ArrayList<UserModel> users = new ArrayList<UserModel>(
            List.of(
                    new UserModel(1,"gemy", "gemy@gmail.com", "123456"),
                    new UserModel(2,"omar", "omar@gmail.com", "123456"),
                    new UserModel(3,"adool", "adool@gmail.com", "123456"),
                    new UserModel(4,"zizo", "zizo@gmail.com", "123456")
            ));

    List<UserModel>getUsers(){
        return users;
    }
    UserModel getUserWithId(String Id){
        long id = parseLong(Id);
        for (UserModel user : users) {
            if (user.getId()==id) {
                return user;
            }
        }
        return null;

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
