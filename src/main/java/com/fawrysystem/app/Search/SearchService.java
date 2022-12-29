package com.fawrysystem.app.Search;

import com.fawrysystem.app.Admin.AdminService;
import com.fawrysystem.app.Service.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;
@Service
public class SearchService {
    public static SearchService instance = new SearchService();
    public SearchService() {

    }

    public Map<String, IServiceStrategy>  getService (String s){
        Map<String, IServiceStrategy> ans = new HashMap<String, IServiceStrategy>();
        for (Map.Entry<String, IServiceStrategy> pair :
                AdminService.getInstance().getServiceHashMap().entrySet()) {
            if(pair.getKey().contains(s)) {
                ans.put(pair.getKey(),pair.getValue());
            }
        }
        return ans;
    }

    public IServiceStrategy getServiceByName(String s){
        for (Map.Entry<String, IServiceStrategy> pair :
                AdminService.getInstance().getServiceHashMap().entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue().toString());
        }
        return AdminService.getInstance().getServiceHashMap().get(s);
    }



    public static SearchService getInstance() {
        return instance;
    }

    public static void setInstance(SearchService instance) {
        SearchService.instance = instance;
    }
}
