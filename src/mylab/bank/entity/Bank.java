package mylab.bank.entity;

import mylab.bank.exception.AccountNotFoundfException;
import mylab.bank.exception.InsufficientBankException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts;
    int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<Account>();
        nextAccountNumber = 1000;
    }

    public String createSavingsAccount(String ownerName, double initialBalance, double initialRate) {
        String accountNumber = "AC" + nextAccountNumber;
        nextAccountNumber++;
        Account account = new SavingsAccount(accountNumber, ownerName, initialBalance, initialRate);
        accounts.add(account);

        System.out.printf("저축 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f, 이자율: %.1f",
                account.getAccountNumber(), account.getOwnerName(), account.getBalance(),
                ((SavingsAccount) account).getInterestRate()
        ).println();
        return ownerName;
    }

    public String createCheckingAccouont(String ownerName, double initialBalance, double withdrawlLimit) {
        String accountNumber = "AC" + nextAccountNumber;
        nextAccountNumber++;
        Account account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawlLimit);
        accounts.add(account);

        System.out.printf("체킹 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f, 출금 한도: %.1f",
                account.getAccountNumber(), account.getOwnerName(), account.getBalance(),
                ((CheckingAccount) account).getWithdrawlLimit()
        ).println();
        return ownerName;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundfException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        String message = String.format("예외 발생: 계좌번호 %s에 해당하는 계좌를 찾을 수 없습니다.", accountNumber);
        throw new AccountNotFoundfException(message);
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundfException {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) throws InsufficientBankException, AccountNotFoundfException {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientBankException, AccountNotFoundfException {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.", amount, fromAccountNumber, toAccountNumber).println();
        }
    }

    public void printAllAccounts() {
        for (Account account : accounts) {
            if (account.getClass() == SavingsAccount.class) {
                System.out.printf("계좌번호: %s, 소유자: %s, 잔액: %.1f, 이자율: %.1f",
                        account.getAccountNumber(), account.getOwnerName(), account.getBalance(),
                        ((SavingsAccount) account).getInterestRate()
                ).println();
            } else if (account.getClass() == CheckingAccount.class) {
                System.out.printf("계좌번호: %s, 소유자: %s, 잔액: %.1f, 출금 한도: %.1f",
                        account.getAccountNumber(), account.getOwnerName(), account.getBalance(),
                        ((CheckingAccount) account).getWithdrawlLimit()
                ).println();
            } else {
                System.out.printf("계좌번호: %s, 소유자: %s, 잔액: %.1f",
                        account.getAccountNumber(), account.getOwnerName(), account.getBalance()
                ).println();
            }
        }
    }
}
