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
    private UserModel userModel;
    private Search search ;
    private IServiceStrategy service;
    private List<Transaction> transactions = new ArrayList<Transaction>();
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
    public UserModel checkIfExists(@PathVariable("username") String username){
        return userServices.getUserWithUsername(username) != null ? userServices.getUserWithUsername(username):null;
    }
    /*
    * {
    *   "name":"value"
    *   "say":"HI",
    *   "to":"Mom"
    * }
    *  */
    @PostMapping
    public void setService(@RequestBody String s) {
        service = search.getServiceByName(s);
    }

    @GetMapping("refundable")
    public List<Transaction> getRefundableRequests(){
        List<Transaction>list = new ArrayList<>();
        for (Transaction t :transactions){
            if(!t.isRefundRequested()){
                list.add(t);
            }
        }
        return list;
    }

    @GetMapping(path = "transaction/{id}")
    public Transaction getTransaction(@PathVariable("id")int ind) {
        return transactions.get(ind);
    }
    @GetMapping("transactions")

    public List<Transaction> getTransactions() {
        return transactions;
    }
    @PostMapping()
    public void addTransactions(@RequestBody Transaction tr) {
        this.transactions.add(tr);
    }
    public IServiceStrategy getService(){
        return service;
    }
    public void PayForService() {
        service.ExecuteService();
    }

}



