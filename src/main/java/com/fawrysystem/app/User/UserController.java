package com.fawrysystem.app.User;

import com.fawrysystem.app.Search.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private SearchService search ;
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
        this.search = SearchService.getInstance();
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



