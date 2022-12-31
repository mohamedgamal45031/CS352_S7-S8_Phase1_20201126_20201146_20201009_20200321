package com.fawrysystem.app.User;

import com.fawrysystem.app.Admin.AdminService;
import com.fawrysystem.app.Admin.Refund;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.TabExpander;
import java.rmi.server.ExportException;
import java.util.*;
@Service
public class UserServices {
    public static UserServices instance = new UserServices();
    private ArrayList<UserModel> users = new ArrayList<UserModel>(
            List.of(
                    new UserModel("gemy", "gemy@gmail.com", "123456", new ArrayList<>(
                            List.of(
                                    new Transaction("OrangeRechrage",40),
                                    new Transaction("gamy",50,true))
                    )),
                    new UserModel("omar", "omar@gmail.com", "123456"),
                    new UserModel("adool", "adool@gmail.com", "123456"),
                    new UserModel("zizo", "zizo@gmail.com", "123456")
            ));

    public List<UserModel>getUsers(){
        return users;
    }
//    for omar w74
    public String getUser(String username){
        for (UserModel user : users) {
            if (user.getUserName().equals(username)) {
                return user.toString();
            }
        }
        return null;
    }
    public UserModel getUserWithUsername(String username){
        for (UserModel user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public List<Transaction> getRefundableRequests(String userName){
        List<Transaction> list = new ArrayList<>();
        UserModel user = getUserWithUsername(userName);
        if(user!=null) {
            for (Transaction t : user.getTransactions()) {
                if (!t.isRefundRequested()) {
                    list.add(t);
                }
            }
        }
        return list;
    }
    public UserModel getUserWithEmail(String email){
        for (UserModel user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void signUp(UserModel userModel ){
        users.add(userModel);
    }
    public boolean signIn(UserModel user) {
        boolean signedUp = false;
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getEmail(), user.getEmail()) && Objects.equals(users.get(i).getPassword(),user.getPassword())) {
                signedUp = true;
                break;
            }
        }
        if (!signedUp) {
            System.out.println("Your Info Is Wrong\nIf You Didn't Sign Up Please Sign Up!!!");
        }
        return signedUp;
    }

    public static UserServices getInstance() {
        return instance;
    }
    public void transferMoneyToWallet(String user,double amount){
        Transaction t  = new Transaction("Add to Wallet",amount,false,"Add to Wallet Transaction");
        getUserWithUsername(user).addTransactions(t);
        getUserWithUsername(user).setWalletBalance(getUserWithUsername(user).getWalletBalance()+amount);
    }
    public boolean makeRefundRequest(String user,String transactionName){
        //gemy,OrangeRechrage
        if(user!= null){
            if(!Objects.equals(transactionName, "")){
                for (int i = getRefundableRequests(user).size()-1; i >=0 ; i--) {
                    Transaction t = getRefundableRequests(user).get(i);
                    if(t.getTransactionName().equals(transactionName)){
                        //add refund request to admin
                        Refund r = new Refund(t.getTransactionName(),t.getAmount(),getUserWithUsername(user));
                        if(!AdminService.getInstance().getAdmin().getRefunds().contains(r)){
                            AdminService.getInstance().getAdmin().getRefunds().add(r);
                            t.setTransactionType("Refund Transaction");
                            t.setRefundRequested(true);
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
    public double getWalletBalance(String userName){
        return getUserWithUsername(userName).getWalletBalance();
    }

    public void setUsers(ArrayList<UserModel> users) {
        this.users = users;
    }
}
