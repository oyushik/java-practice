package lab.bank.control;

import lab.bank.entity.Bank;
import lab.bank.entity.SavingsAccount;
import lab.bank.exception.AccountNotFoundfException;
import lab.bank.exception.InsufficientBankException;

public class BankDemo {
    public static void main(String[] args) throws InsufficientBankException, AccountNotFoundfException {
        Bank bank = new Bank();

        System.out.println("\n=== 계좌 생성 ===");
        bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        bank.createCheckingAccouont("김철수", 20000.0, 5000.0);
        bank.createSavingsAccount("이영희", 30000.0, 2.0);

        System.out.println("\n=== 입금/출금 테스트 ===");
        bank.deposit("AC1000", 5000.0);
        bank.withdraw("AC1001", 3000);

        System.out.println("\n=== 이자 적용 테스트 ===");
        ((SavingsAccount)bank.findAccount("AC1000")).applyInterest();

        System.out.println("\n=== 계좌 이체 테스트 ===");
        bank.transfer("AC1002", "AC1001", 5000);

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();

        System.out.println("\n====================");
        bank.withdraw("AC1000", 30000);
        bank.withdraw("AC1001", 6000);
        bank.withdraw("AC2000", 3000);
    }
}
