package FawrySystem;

public class Admin {

    /*-
- email: string
- password: string
*/
    private String email;
    private String password;


    public void setDiscount(String s,double discount){
        Search search=Search.getInstance();
        search.putService(s,new Discount(discount,search.getService(s)));
    }
    public void setDiscountForAllServices(double discount){
        Search search=Search.getInstance();
        search.setDiscountOverAllServices(discount);
    }
    public void setDiscountForOneUser(double discount,User user){
user.setOverAllDicount(discount);
    }


}
