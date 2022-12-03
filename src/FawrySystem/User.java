package FawrySystem;

import java.util.Map;
import java.util.Scanner;

public class User {

    private IServiceStrategy service;
    private String userName;
    private String email;
    private String password;
    private String creditCardNumber;
    private double walletBalance;
    private double overAllDicount;


    public User() {
        overAllDicount = 0;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void PayForService() {

        service.ExecuteService();

    }

    public void setService(String ss) {
        Search search = Search.getInstance();
        Map<Integer,IServiceStrategy> map = search.getService(ss);

        for (Map.Entry<Integer, IServiceStrategy> set :
                map.entrySet()) {
            System.out.print(set.getKey()+" - ");
            System.out.println(set.getValue().getName());
        }
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Num of Service to Select");
        int serviceNum = myObj.nextInt();
        service = map.get(serviceNum);
        ///////////////////////////


    }
    public IServiceStrategy getService(){
        return service;
    }
    public void setOverAllDicount(double overAllDicount) {
        this.overAllDicount = overAllDicount;

    }


}
