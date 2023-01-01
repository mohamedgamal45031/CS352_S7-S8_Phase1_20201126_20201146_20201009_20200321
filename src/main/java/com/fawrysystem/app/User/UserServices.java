package com.fawrysystem.app.User;

import com.fawrysystem.app.Admin.*;
import com.fawrysystem.app.Provider.*;
import com.fawrysystem.app.Service.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public  class UserServices {
    public static UserServices instance = new UserServices();
    private ArrayList<UserModel> users = new ArrayList<UserModel>();

    public UserServices() {
        users.add(new UserModel("gemy", "gemy@gmail.com", "123456"));
        users.add(new UserModel("omar", "omar@gmail.com", "123456"));
        users.add(new UserModel("adool", "adool@gmail.com", "123456"));
        users.add(new UserModel("zizo", "zizo@gmail.com", "123456"));
    }

    public ArrayList<UserModel>getUsers(){
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

    public boolean payForService(String userName,String provider,String serviceName){
        UserModel user = getUserWithUsername(userName);
        IServiceStrategy service = AdminService.getInstance().getServiceHashMap().get(serviceName);
        ServiceProvider p = AdminService.getInstance().getServiceProviderMap().get(provider);
        Transaction t = new Transaction(service.getName(),service.getPrice(),false,"Payment Transaction");
        if(!Objects.equals(provider, "wallet")){
            service.ExecuteService(p);
            getUserWithUsername(userName).addTransactions(t);
            return true;
        }
        else{
            if(user.getWalletBalance()>=service.getPrice()){
                service.ExecuteService(user,p);
                getUserWithUsername(userName).addTransactions(t);
                System.out.println("Wallet Paying.....");
                return true;
            }
            System.out.println("Your Wallet is empty!");
            return false;
        }
    }
    public List<String> getDiscountedServices (){
        ArrayList<String> list =new ArrayList<>();
        for (Map.Entry<String, IServiceStrategy>
                set : AdminService.getInstance().getServiceHashMap().entrySet()) {
            if(set.getValue().getDiscount()!=0.0){
                list.add(set.getKey());
            }
        }
        return list;
    }
}
