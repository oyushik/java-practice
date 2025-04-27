package lab.bank.entity;

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

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("출금희망액이 잔액을 초과합니다. 현재 잔액: " + balance);
            return;
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
