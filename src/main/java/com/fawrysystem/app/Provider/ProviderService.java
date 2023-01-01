package com.fawrysystem.app.Provider;

import java.util.List;
import java.util.Objects;

public class ProviderService {

    public final static char TEXT_FIELD_CODE = '0';
    public final static char DROPDOWN_CODE = '1';
    private static ProviderService instance = new ProviderService();
    private List<ProviderModel> providers = List.of(
            new ProviderModel("Vodafone Cash",
                    new Component( TEXT_FIELD_CODE, "Number"),
                    new Component(TEXT_FIELD_CODE, "Amount")),

            new ProviderModel("cc",
                    new Component( TEXT_FIELD_CODE, "Number"),
                    new Component(TEXT_FIELD_CODE, "Amount"))
    );

    public ProviderService(){}

    public ProviderModel getProviderByName(String name){
        for (ProviderModel p: providers) {
            if (Objects.equals(name, p.getProviderName())) return p;
        }
        return null;
    }

    public boolean isExists(ProviderModel provider) {
        for (ProviderModel p: providers) {
            if (Objects.equals(p, provider)) return true;
        }
        return false;
    }

    public boolean addProvider(ProviderModel provider){
        if (!isExists(provider)) {
            providers.add(provider);
            return true;
        }
        return false;
    }

    public boolean removeProvider(ProviderModel provider){
        return providers.remove(provider);
    }

    public boolean removeProvider(String providerName){
        return removeProvider(getProviderByName(providerName));
    }


    public static ProviderService getInstance(){
        return instance;
    }

    public List<ProviderModel> getProviders() {
        return providers;
    }
}
