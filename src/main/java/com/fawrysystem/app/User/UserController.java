package com.fawrysystem.app.User;

import com.fawrysystem.app.Search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static java.lang.Double.parseDouble;

@RestController
@RequestMapping("api/user")
public class UserController {
    private UserModel userModel;
    private  Search search ;

    private UserServices userServices;
    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
        this.search = Search.getInstance();
    }
    @GetMapping("all")
    public List<UserModel> getAllUsers(){
        return userServices.getUsers();
    }


    @GetMapping(path = "check/{id}")
    public UserModel checkIfExists(@PathVariable("id") String id){
//        this.userModel = userServices.getUserWithId(id);//current user
        return userServices.getUserWithId(id) != null ?
                userServices.getUserWithId(id) : null;
    }
    @GetMapping(path = "check/{userName}")
    public UserModel checkIfExistsWithUserName(@PathVariable("userName") String userName){
        return userServices.getUserWithUsername(userName) != null ?
                userServices.getUserWithUsername(userName) : null;
    }
    /*
    * {
    *   "name":"value"
    *   "say":"HI",
    *   "to":"Mom"
    * }
    *  */
    @PostMapping("{id}/service")
    public void setService(@PathVariable("id") String id,@RequestBody String s) {
        if(checkIfExists(id)!= null){
            checkIfExists(id).setService(search.getServiceByName(s));
        }
    }

    @GetMapping("{id}/refundable")
    public List<Transaction> getRefundableRequests(@PathVariable("id") String id){
        List<Transaction>list = new ArrayList<>();
        if(checkIfExists(id)!= null) {
            for (Transaction t :checkIfExists(id).getTransactions()){
                if(!t.isRefundRequested()){
                    list.add(t);
                }
            }
        }
        return list;
    }

    @GetMapping(path = "{id}/transaction/{id}")
    public Transaction getTransaction(@PathVariable("id") String id,@PathVariable("id")int ind) {
        if(checkIfExists(id)!= null){
            return checkIfExists(id).getTransaction(ind);
        }
        return null;
    }
    @GetMapping("{id}/transactions")

    public List<Transaction> getTransactions(@PathVariable("id") String id) {
        if(checkIfExists(id)!= null){
            return checkIfExists(id).getTransactions();
        }
        return null;
    }
    @PostMapping("{id}/transaction")
    public void addTransactions(@PathVariable("id") String id,@RequestBody Transaction tr) {
        if(checkIfExists(id)!= null){
            checkIfExists(id).addTransactions(tr);
        }
    }
    @PostMapping("{id}/overallDiscount")

    public void setOverallDiscount(@PathVariable("id") String id,@RequestBody String overallDiscount) {
        if(checkIfExists(id)!= null){
            checkIfExists(id).setOverallDiscount(parseDouble(overallDiscount));
        }

    }
    @PostMapping("{id}/walletBalance")

    public void setWalletBalance(@PathVariable("id") String id,@RequestBody String x) {
        if(checkIfExists(id)!= null){
            checkIfExists(id).setWalletBalance(parseDouble(x));
        }

    }
    @GetMapping("{id}/walletBalance")

    public double getWalletBalance(@PathVariable("id") String id) {
        if(checkIfExists(id)!= null){
            return checkIfExists(id).getWalletBalance();
        }
        return -1;
    }
    @GetMapping("{id}/email")

    public String getEmail(@PathVariable("id") String id) {
        if(checkIfExists(id)!= null){
            return checkIfExists(id).getEmail();
        }
        return "";
    }

    @GetMapping("{id}/password")
    public String getPassword(@PathVariable("id") String id) {
        if(checkIfExists(id)!= null){
            return checkIfExists(id).getPassword();
        }
        return "";
    }
    @GetMapping("{id}/username")

    public String getUserName(@PathVariable("id") String id) {
        if(checkIfExists(id)!= null){
            return checkIfExists(id).getUserName();
        }
        return "";
    }
    @GetMapping("{id}/service")

    public String getService(@PathVariable("id") String id){
        if(checkIfExists(id)!=null){
            this.userModel.getService().getName();
            return checkIfExists(id).getService().getName();
        }
        return "";
    }
//    public void PayForService() {
//        this.userModel.getService().ExecuteService();
//    }

}



