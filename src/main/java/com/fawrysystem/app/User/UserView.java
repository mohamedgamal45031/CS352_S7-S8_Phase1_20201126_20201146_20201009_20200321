package com.fawrysystem.app.User;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Objects;
import java.util.Scanner;

public class UserView {
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);

    private final WebClient localApiClient = WebClient.create("http://localhost:8080/api/user");;
    private UserController userController;
    public UserView( UserController  userController) {
        this.userController = userController;
    }
    public void signUp(){

    }


    public void signIn(){
        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Enter Email");
        String email = stringScanner.nextLine();
        System.out.println("Enter Password");
        String pass = stringScanner.nextLine();
        //call api
        UserModel user = new UserModel(email,pass);
        String url = "http://localhost:8080/api/user/signUp";
//        System.out.println(localApiClient
//                .post()
//                .uri("/signUp/")
//                .body(user,UserModel.class).retrieve());
//        if(signedUpUser!=null){
//            System.out.println("Signed Up Successfully!");
//        }
//        else{
//            System.out.println("Your account is already exists!");
//
//        }
    }

}
