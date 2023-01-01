package com.fawrysystem.app.Admin;

import com.fawrysystem.app.Provider.ProviderModel;
import com.fawrysystem.app.data.TransactionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Double.parseDouble;

@RestController
@RequestMapping("admin")
public class AdminController {
    private AdminService service = new AdminService();

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

    @PostMapping("add/provider")
    public void addServiceProvider(@RequestBody ProviderModel provider){
        AdminService.getInstance().addServiceProvider(provider);
    }

    @GetMapping("get/all/transactions")
    public List<TransactionModel> showHistory(){
        return service.getAllTransactions();
    }

    //for one user like if an user gets a discount for his first service
    /* public void setDiscountForOneUser(double discount,UserModel user){
            user.setOverAllDicount(discount);
    }*/


}
