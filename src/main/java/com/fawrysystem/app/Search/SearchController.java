package com.fawrysystem.app.Search;
import java.util.*;

import com.fawrysystem.app.Service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class SearchController {

    private SearchController(){
    }

    @GetMapping(path = "all/{searchString}")
    public Map<String, IServiceStrategy>  getService (@PathVariable("searchString") String s){
        return SearchService.getInstance().getService(s);
    }

    @GetMapping(path = "{searchString}")
    public IServiceStrategy getServiceByName(@PathVariable("searchString") String s){
       return SearchService.getInstance().getServiceByName(s);
    }

    /*
    public  void putService(String s, IServiceStrategy Service){  serviceHashMap.put(s,Service);}*/



}
