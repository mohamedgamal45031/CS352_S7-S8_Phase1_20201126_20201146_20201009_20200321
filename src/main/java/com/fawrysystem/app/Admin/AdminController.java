package com.fawrysystem.app.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Double.parseDouble;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    public AdminController() {

    }
    @PostMapping("set/discount")
    public void setDiscount(@RequestBody String discount){
        String[] arrOfStr = discount.split(",");
        AdminService.getInstance().setDiscount(parseDouble(arrOfStr[1]), arrOfStr[0]);
    }
    @PostMapping("set/discount/all")
    public void setDiscountForAllServices(@RequestBody String discount){
        AdminService.getInstance().setDiscountForAllServices(parseDouble(discount));

    }

    //for one user like if an user gets a discount for his first service
    /* public void setDiscountForOneUser(double discount,UserModel user){
            user.setOverAllDicount(discount);
    }*/


}
