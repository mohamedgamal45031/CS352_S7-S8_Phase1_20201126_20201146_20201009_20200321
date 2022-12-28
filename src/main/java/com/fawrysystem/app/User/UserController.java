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
    private UserView userView;

    private UserServices userServices;

    public UserController() {
        this.userServices = UserServices.getInstance();
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
    @GetMapping(path = "check/{email}")
    public UserModel checkIfExistsWithEmail(@PathVariable("email") String email){
        return userServices.getUserWithEmail(email) != null ? userServices.getUserWithEmail(email) : null;
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
    @PostMapping("signUp")
    public boolean signUp(@RequestBody UserModel userModel){
        //user not found so can be sign up
        if(checkIfExistsWithEmail(userModel.getEmail())==null){
            userServices.signUp(userModel);
            return true;
        }
        else{
            return false;
        }
    }
//    public void PayForService() {
//        service.ExecuteService();
//    }

}



