package com.fawrysystem.app.User;

import com.fawrysystem.app.Search.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import static java.lang.Double.parseDouble;

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
    public UserModel checkIfExists(@PathVariable("username") String username){
        return userServices.getUserWithUsername(username) != null ? userServices.getUserWithUsername(username):null;
    }
    @GetMapping(path = "check/email/{email}")
    public UserModel checkIfExistsWithEmail(@PathVariable("email") String email){
        return userServices.getUserWithEmail(email) != null ? userServices.getUserWithEmail(email) : null;
    }
    @GetMapping("refundable/{username}")
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
    @PostMapping("signIn")
    public boolean signIn(@RequestBody UserModel userModel){
        //user not found so can be sign up
        return userServices.signIn(userModel);
    }
    @PostMapping("transfer")
    public void transferMoneyToWallet(@RequestBody String userAmount){
        //gemy,200.0
        String[] arrOfStr = userAmount.split(",");
        userServices.transferMoneyToWallet(arrOfStr[0],parseDouble(arrOfStr[1]));
    }
    @PostMapping("refund/make")
    public boolean makeRefundRequest(@RequestBody String userTransactionName){
        //gemy,OrangeRechrage
        String[] arrOfStr = userTransactionName.split(",");
        return userServices.makeRefundRequest(arrOfStr[0],arrOfStr[1]);
    }
    @GetMapping(path ="wallet/{userName}")
    public double getWalletBalance(@PathVariable String userName){
        return userServices.getWalletBalance(userName);
    }

    @PostMapping("payService")
    public boolean PayForService(@RequestBody String payment) {
        //gemy,VodafoneCash,EtisalatRecharge
        String[] arrOfStr = payment.split(",");
        return userServices.payForService(arrOfStr[0],arrOfStr[1],arrOfStr[2]);
    }


}



