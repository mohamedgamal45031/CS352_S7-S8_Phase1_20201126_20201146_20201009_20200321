package com.fawrysystem.app.Search;
import java.util.*;
import com.fawrysystem.app.Service.*;
import com.fawrysystem.app.User.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class Search {
    private Map<String, IServiceStrategy> serviceHashMap;
    public static Search instance = new Search();
    private Search(){
        serviceHashMap= new HashMap<String, IServiceStrategy>();
        serviceHashMap.put("NGODonation", new NGODonation());
        serviceHashMap.put("SchoolDonation", new SchoolDonation());
        serviceHashMap.put("CancerHospitalDonation", new CancerHospitalDonation());
        serviceHashMap.put("QuarterReceiptLandline", new QuarterReceiptLandline());
        serviceHashMap.put("MonthlyReceiptLandline", new MonthlyReceiptLandline());
        serviceHashMap.put("OrangeInternet", new OrangeInternet());
        serviceHashMap.put("WEInternet", new WEInternet());
        serviceHashMap.put("EtisalatInternet", new EtisalatInternet());
        serviceHashMap.put("VodafoneInternet", new VodafoneInternet());
        serviceHashMap.put("OrangeRechrage", new OrangeRechrage());
        serviceHashMap.put("WERechrage", new WERechrage());
        serviceHashMap.put("EtisalatRechrage", new EtisalatRechrage());
        serviceHashMap.put("VodafoneRechrage", new VodafoneRechrage());
    }
    @GetMapping(path = "all/{searchString}")
    public Map<String, IServiceStrategy>  getService (@PathVariable("searchString") String s){
        Map<String, IServiceStrategy> ans = new HashMap<String, IServiceStrategy>();
        for (Map.Entry<String, IServiceStrategy> pair :
                serviceHashMap.entrySet()) {
                if(pair.getKey().contains(s)) {
                    ans.put(pair.getKey(),pair.getValue());
                }
        }
        return ans;
    }

    @GetMapping(path = "{searchString}")
    public IServiceStrategy getServiceByName(@PathVariable("searchString") String s){
       return serviceHashMap.get(s);
    }

    public Map<String, IServiceStrategy> getServiceHashMap() {
        return serviceHashMap;
    }

    public  void putService(String s, IServiceStrategy Service){  serviceHashMap.put(s,Service);}
    public static Search getInstance(){
        return instance;
    }


}
