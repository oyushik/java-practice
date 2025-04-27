package lab.bank.exception;

public class InsufficientBankException extends Exception {
    public InsufficientBankException(String message) {
        super(message);
    }
}
