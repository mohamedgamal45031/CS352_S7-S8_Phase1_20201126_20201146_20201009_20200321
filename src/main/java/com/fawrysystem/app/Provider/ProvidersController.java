package com.fawrysystem.app.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/providers")
public class ProvidersController {

    @Autowired
    public ProvidersController() {}

    @GetMapping("get/all")
    public List<ProviderModel> getProviders(){
        return ProviderService.getInstance().getProviders();
    }

    @GetMapping("get/{provider}")
    public ProviderModel getProviderByName(@PathVariable("provider") String provider){
        return ProviderService.getInstance().getProviderByName(provider);
    }

    @PostMapping("add/providers")
    public boolean addProvider(@RequestBody ProviderModel provider){
        return ProviderService.getInstance().addProvider(provider);
    }

    @PostMapping("remove/{provider}")
    public boolean removeProvider(@PathVariable String provider){
        return ProviderService.getInstance().removeProvider(provider);
    }
}
