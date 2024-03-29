package com.fawrysystem.app.Admin;

import com.fawrysystem.app.Provider.*;
import com.fawrysystem.app.Service.*;
import com.fawrysystem.app.User.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AdminService {
    private UserServices userServices;
    private AdminModel admin = new AdminModel("mohamedSamir@gmail.com","123456");
    @Autowired
    public AdminService(UserServices userServices) {
        admin.addRefund(new Refund("عمر",20.0,new UserModel("gemy", "gemy@gmail.com", "123456")));
        this.userServices = userServices;
    }
    public AdminService() {
        admin.addRefund(new Refund("عمر",20.0,new UserModel("gemy", "gemy@gmail.com", "123456")));
    }
    public static AdminService instance = new AdminService();
    //select *
    private Map<String, IServiceStrategy> serviceHashMap = new HashMap<String, IServiceStrategy>(){{
        put("NGODonation", new NGODonation());
        put("SchoolDonation", new SchoolDonation());
        put("CancerHospitalDonation", new CancerHospitalDonation());
        put("QuarterReceiptLandline", new QuarterReceiptLandline());
        put("MonthlyReceiptLandline", new MonthlyReceiptLandline());
        put("OrangeInternet", new OrangeInternet());
        put("WEInternet", new WEInternet());
        put("EtisalatInternet", new EtisalatInternet());
        put("VodafoneInternet", new VodafoneInternet());
        put("OrangeRecharge", new OrangeRechrage());
        put("WERecharge", new WERechrage());
        put("EtisalatRecharge", new EtisalatRechrage());
        put("VodafoneRecharge", new VodafoneRechrage());
    }};
    private Map<String, ServiceProvider> serviceProviderMap = new HashMap<String, ServiceProvider>(){{
        put("CreditCard", new CreditCardProvider());
        put("VodafoneCash", new VodafoneCashProvider());
    }};
    public void setDiscount(double amount, String name){
        serviceHashMap.replace(name,new Discount(amount,serviceHashMap.get(name)));
        System.out.println("discount set successfully!");
    }

    public void setDiscountForAllServices(double discount){
        for (Map.Entry<String, IServiceStrategy>
                set : serviceHashMap.entrySet()) {
            serviceHashMap.replace(set.getKey(),new Discount(discount,set.getValue()) );
        }
    }

    public Map<String, IServiceStrategy> getServiceHashMap() {
        return serviceHashMap;
    }

    public void setServiceHashMap(Map<String, IServiceStrategy> serviceHashMap) {
        this.serviceHashMap = serviceHashMap;
    }

    public static AdminService getInstance() {
        return instance;
    }
    public boolean signIn(AdminModel admin) {
        if (Objects.equals(admin.getEmail(), "mohamedSamir@gmail.com") && Objects.equals(admin.getPassword(), "123456")) {
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Refund> showRefundRequests(){
        ArrayList<Refund> refunds = new ArrayList<>();
        for (int i = 0; i < admin.getRefunds().size(); i++) {
            Refund refund = admin.getRefunds().get(i);
            if(!refund.isRefunded())refunds.add(refund);
        }
        return refunds;
    }

    public AdminModel getAdmin() {
        return this.admin;
    }

    public void setAdmin(AdminModel admin) {
        this.admin = admin;
    }




    public void responseRefund(int index,String response){
        if(Objects.equals(response, "accept")){
            if(admin.getRefunds().get(index)!=null){
                Refund r =admin.getRefunds().get(index);
                r.getUser().setWalletBalance(r.getUser().getWalletBalance()+r.getAmount());
                r.setAccepted(true);
            }
        }
        else{
            admin.getRefunds().get(index).setAccepted(false);
        }
    }

    public Map<String, ServiceProvider> getServiceProviderMap() {
        return serviceProviderMap;
    }

    public void setServiceProviderMap(Map<String, ServiceProvider> serviceProviderMap) {
        this.serviceProviderMap = serviceProviderMap;
    }

    public HashMap<String,ArrayList<Transaction>> showTransactions(){
        HashMap<String,ArrayList<Transaction>> map = new HashMap<String,ArrayList<Transaction>>();

        /* gemy []
         * omar []
         * */
        for (int i = 0; i < userServices.getUsers().size(); i++) {
            map.put(userServices.getUsers().get(i).getUserName(),
                    userServices.getUsers().get(i).getTransactions());
        }
        return map;
    }
}
