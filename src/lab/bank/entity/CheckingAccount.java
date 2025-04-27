package lab.bank.entity;

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
    public void withdraw(double amount) {
        if (amount > withdrawlLimit) {
            System.out.println("출금희망액이 출금 한도를 초과합니다.");
            // 예외 처리로 빼야 함
            return;
        }
        super.withdraw(amount);
    }
}
