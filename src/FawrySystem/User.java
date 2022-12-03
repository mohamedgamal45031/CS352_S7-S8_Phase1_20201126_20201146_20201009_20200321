package FawrySystem;

import java.util.Map;
import java.util.Scanner;

public class User {

    private IServiceStrategy s;
    private String email;
    private String password;
    private String creditCardNumber;
    private double walletBalance;
    private double overAllDicount;


    public User() {
        overAllDicount = 0;
    }

    public void PayForService() {

        s.ExecuteService();

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
        int service = myObj.nextInt();
        s = map.get(service);
        System.out.println(s.getName()+" Selected ");
        s.ExecuteService();
    }

    public void setOverAllDicount(double overAllDicount) {
        this.overAllDicount = overAllDicount;

    }


}
