package com.nseit.Atm.controller;

import com.nseit.Atm.modal.Amount;
import com.nseit.Atm.service.AccountService;
import com.nseit.Atm.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amount")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/withdraw")
    public void withdrawlAmount(@RequestBody Amount amount){
        int bal= Util.balance;
        Util util =new Util();
        Util.valid();
        int fbal = bal - amount.getAmount();
        Util.balance = fbal;

        if(amount.getAmount()<=bal){
            System.out.println(fbal);
        }else {
            System.out.println("In sufficient amount");
        }
        Amount amount1=new Amount();
        amount1.setAmount(fbal);
        accountService.withdrawlAmount(amount1);
    }
    @PostMapping("/deposit")
    public void depositAmount(@RequestBody Amount amount) {
        int bal= Util.balance;
        Util util =new Util();
        Util.valid();
        int fbal = bal + amount.getAmount();
        Util.balance = fbal;
        System.out.println(fbal);
        Amount amount1=new Amount();
        amount1.setAmount(fbal);
        accountService.depositAmount(amount1);
    }
    @GetMapping("/all")
     List<Amount> viewBalance(){
        Util util =new Util();
        util.valid();
        int bal= Util.balance;
        System.out.println(bal);
        return accountService.viewBalance();
    }
}
