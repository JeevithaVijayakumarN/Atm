package com.nseit.Atm.service;

import com.nseit.Atm.modal.Amount;
import com.nseit.Atm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public void withdrawlAmount(Amount amount){

        accountRepository.save(amount);
    }
    public void depositAmount( Amount amount){

        accountRepository.save(amount);
    }
    public List<Amount> viewBalance() {

        return accountRepository.findAll();
    }
}
