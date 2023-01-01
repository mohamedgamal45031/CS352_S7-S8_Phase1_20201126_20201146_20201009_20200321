package com.fawrysystem.app.Admin;

import com.fawrysystem.app.Provider.ProviderModel;
import com.fawrysystem.app.Provider.ProviderService;
import com.fawrysystem.app.Service.*;
import com.fawrysystem.app.data.TransactionDatabase;
import com.fawrysystem.app.data.TransactionModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    private AdminModel admin = new AdminModel("mohamedSamir@gmail.com","123456");
    public static AdminService instance = new AdminService();

    private Map<String, IServiceStrategy> serviceHashMap = new HashMap<>(){{
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
    public void setDiscount(double amount, String name){
        serviceHashMap.replace(name,new Discount(amount,serviceHashMap.get(name)));
        System.out.println("discount set successfully!");
    }

    public void setDiscountForAllServices(double discount){
        for (Map.Entry<String, IServiceStrategy>
                set : serviceHashMap.entrySet()) {
            serviceHashMap.replace(set.getKey(),new Discount(discount,set.getValue()) );
        }
        for (Map.Entry<String, IServiceStrategy>
                set : serviceHashMap.entrySet()) {
            System.out.println(set.getKey()+set.getValue());
        }
    }

    public List<TransactionModel> getAllTransactions(){
        return TransactionDatabase.getInstance().getAllTransactions();
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

    public void addServiceProvider(ProviderModel provider) {
        ProviderService.getInstance().addProvider(provider);
    }
}
