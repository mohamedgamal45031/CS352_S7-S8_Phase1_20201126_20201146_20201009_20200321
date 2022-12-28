package com.fawrysystem.app;

import com.fawrysystem.app.User.UserController;
import com.fawrysystem.app.User.UserView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class FawrySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FawrySystemApplication.class, args);
		UserController userController = new UserController();
		UserView userView = new UserView(userController);
		userView.signIn();
	}

}
