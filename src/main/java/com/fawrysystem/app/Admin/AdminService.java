package com.fawrysystem.app.Admin;

import com.fawrysystem.app.Search.Search;
import com.fawrysystem.app.Service.Discount;
import com.fawrysystem.app.Service.IServiceStrategy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Service
public class AdminService {
    private AdminModel admin = new AdminModel("mohamedSamir@gmail.com","123456");

    public void setDiscount(double amount, String name){
        Search search=Search.getInstance();
        search.putService(name,new Discount(amount,search.getServiceByName(name)));
        System.out.println("discount set successfully!");
    }

    public void setDiscountForAllServices(double discount){
        Search search=Search.getInstance();
        Map<String, IServiceStrategy> serviceHashMap = search.getServiceHashMap();
        for (Map.Entry<String, IServiceStrategy>
                set : serviceHashMap.entrySet()) {
            set.setValue(new Discount(discount,set.getValue()));
        }
    }


}
