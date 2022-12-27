package com.fawrysystem.app.User;

import com.fawrysystem.app.Search.Search;
import com.fawrysystem.app.Service.IServiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private Search search ;

    private UserServices userServices;
    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
        this.search = Search.getInstance();
    }
    @GetMapping("all")
    public List<UserModel>getAllUsers(){
        return userServices.getUsers();
    }

    @GetMapping(path = "check/{username}")
    public String checkIfExists(@PathVariable("username") String username){
        return userServices.getUserWithUsername(username) != null ? userServices.getUserWithUsername(username):null;
    }
    /*
    * {
    *   "name":"value"
    *   "say":"HI",
    *   "to":"Mom"
    * }
    *  */
    @GetMapping("refundable/{username}")
   // @GetMapping(path = "transaction/{id}")
    public List<Transaction> refundableRequest(@PathVariable("username") String name){
        return userServices.getRefundableRequests(name);
    }

//    public void PayForService() {
//        service.ExecuteService();
//    }

}



