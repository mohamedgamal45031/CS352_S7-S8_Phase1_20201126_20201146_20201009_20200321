package FawrySystem;

import java.util.HashMap;
import java.util.Map;

public class Search {

    private Map<String, IServiceStrategy> serviceHashMap;
    private static Search instance = new Search();


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
    public  IServiceStrategy getService(String s){
        return serviceHashMap.get(s);
    }
    public  void putService(String s,IServiceStrategy Service){  serviceHashMap.put(s,Service);}
    public static Search getInstance(){
        return instance;
    }


}
