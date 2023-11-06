package com.amc.junit.util;

import com.amc.junit.base.Account;
import com.amc.junit.base.AccountManager;
import org.junit.jupiter.api.MethodOrderer;

import java.util.Random;

public class TestUtilities {

    public static Account getRandomAccount() {
        int accountId= new Random().nextInt(1000,9999);
        String accountName="Amitava"+accountId;
        double balance=new Random().nextDouble(1000,100000);
        String accountType=new Random().nextBoolean()?"SAVINGS":"CURRENT";
        double interestRate=0.0;

        Account account = new Account(accountId,accountName,balance,accountType,interestRate);
        account = new AccountManager().setInterestRate(account);
    return(account);
    }
}
