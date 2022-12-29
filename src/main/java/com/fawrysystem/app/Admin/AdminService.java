package com.fawrysystem.app.Admin;

import com.fawrysystem.app.Service.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {
    private AdminModel admin = new AdminModel("mohamedSamir@gmail.com","123456");
    public static AdminService instance = new AdminService();

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
        put("OrangeRechrage", new OrangeRechrage());
        put("WERechrage", new WERechrage());
        put("EtisalatRechrage", new EtisalatRechrage());
        put("VodafoneRechrage", new VodafoneRechrage());
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

    public Map<String, IServiceStrategy> getServiceHashMap() {
        return serviceHashMap;
    }

    public void setServiceHashMap(Map<String, IServiceStrategy> serviceHashMap) {
        this.serviceHashMap = serviceHashMap;
    }

    public static AdminService getInstance() {
        return instance;
    }
}
