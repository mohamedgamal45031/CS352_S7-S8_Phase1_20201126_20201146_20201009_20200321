package com.fawrysystem.app.Admin;

import java.util.Map;

import com.fawrysystem.app.Search.Search;
import com.fawrysystem.app.Service.Discount;
import com.fawrysystem.app.Service.IServiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("set/discount")
    public void setDiscount(@RequestBody Discount discount){
        adminService.setDiscount(discount.getDiscount(), discount.getName());
    }
    @PostMapping("set/discount/all")

    public void setDiscountForAllServices(@RequestBody double discount){
        adminService.setDiscountForAllServices(discount);
    }

    //for one user like if an user gets a discount for his first service
   /* public void setDiscountForOneUser(double discount,UserModel user){
        user.setOverAllDicount(discount);
    }*/


}
