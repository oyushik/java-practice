package lab.bank.entity;

import lab.bank.exception.InsufficientBankException;
import lab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawlLimit;

    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawlLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawlLimit = withdrawlLimit;
    }

    public double getWithdrawlLimit() {
        return withdrawlLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBankException {
        if (amount > withdrawlLimit) {
            String message = String.format("예외 발생: 출금 한도를 초과했습니다. 출금 한도: %.1f)", withdrawlLimit);
            throw new WithdrawalLimitExceededException(message);
        }
        super.withdraw(amount);
    }
}
