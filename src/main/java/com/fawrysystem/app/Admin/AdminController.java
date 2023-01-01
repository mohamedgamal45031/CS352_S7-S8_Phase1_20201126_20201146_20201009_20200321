package com.fawrysystem.app.Admin;

import com.fawrysystem.app.Search.SearchService;
import com.fawrysystem.app.User.Transaction;
import com.fawrysystem.app.User.UserModel;
import com.fawrysystem.app.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    //specific
    @PostMapping("set/discount")
    public void setDiscount(@RequestBody String discount){
        String[] arrOfStr = discount.split(",");
        AdminService.getInstance().setDiscount(parseDouble(arrOfStr[1]), arrOfStr[0]);
    }
    //overall
    @PostMapping("set/discount/all")
    public void setDiscountForAllServices(@RequestBody String discount){
        AdminService.getInstance().setDiscountForAllServices(parseDouble(discount));
    }
    @PostMapping("signIn")
    public boolean signIn(@RequestBody AdminModel admin){
        return AdminService.getInstance().signIn(admin);
    }
    @GetMapping("show/refunds")
    public List<Refund> showRefundRequests(){
        return AdminService.getInstance().showRefundRequests();
    }

    @PostMapping("response")
    public void responseRefund(@RequestBody String response){
        //2,accept
        String[] arrOfStr = response.split(",");
        AdminService.getInstance().responseRefund(parseInt(arrOfStr[0]),arrOfStr[1]);
    }
    @GetMapping("show/transactions")
    public HashMap<String, ArrayList<Transaction>> showTransactions(){
        return adminService.showTransactions();
    }
}
