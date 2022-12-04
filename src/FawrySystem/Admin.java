package FawrySystem;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    /*-
- email: string
- password: string
*/
    private String email;
    private String password;

    private List<Refund> refunds = new ArrayList<>();

    public List<Refund> getRefunds() {
        return refunds;
    }

    public void addRefund(Refund r) {
        refunds.add(r);
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setDiscount(String s, double discount){
        Search search=Search.getInstance();
//        search.putService(s,new Discount(discount,search.getService(s)));
    }
    public void setDiscountForAllServices(double discount){
        Search search=Search.getInstance();
        search.setDiscountOverAllServices(discount);
    }

    //for one user like if an user gets a discount for his first service
    public void setDiscountForOneUser(double discount,User user){
user.setOverAllDicount(discount);
    }


}
