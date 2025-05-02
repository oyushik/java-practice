package mylab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBankException {
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}
