package com.fawrysystem.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "transactions")
public class TransactionController {
    private final static TransactionService service = TransactionService.getInstance();

    @Autowired
    public TransactionController() {}

    @GetMapping("get/all")
    public List<TransactionModel> getAllTransactions(){
        return service.getAllTransactions();
    }

    @PostMapping("/add")
    public void addTransaction(@RequestBody TransactionModel transaction) {
        System.out.println("api called");
        service.addTransaction(transaction);
    }
}
