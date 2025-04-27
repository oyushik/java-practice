package lab.bank.entity;

import lab.bank.exception.InsufficientBankException;

public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account() {
    }

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBankException {
        if (amount > balance) {
            String message = String.format("예외 발생: 잔액이 부족합니다. 잔액: %.1f", balance);
            throw new InsufficientBankException(message);
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
