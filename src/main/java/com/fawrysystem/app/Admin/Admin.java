package com.fawrysystem.app.Admin;

import java.util.ArrayList;
import java.util.List;
import com.fawrysystem.app.*;
import com.fawrysystem.app.Search.Search;
import com.fawrysystem.app.Service.Discount;
import com.fawrysystem.app.User.Transaction;

public class Admin {

    /*-
- email: string
- password: string
*/
    private String email;
    private String password;

    private List<Refund> refunds = new ArrayList<Refund>();

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
        search.putService(s,new Discount(discount,search.getServiceByName(s)));
    }
    public void setDiscountForAllServices(double discount){
        Search search=Search.getInstance();
        search.setDiscountOverAllServices(discount);
    }

    //for one user like if an user gets a discount for his first service
//    public void setDiscountForOneUser(double discount,UserModel user){
//        user.setOverAllDicount(discount);
//    }


}
