/**
 * This class tests the methods in BankAccount and Bank classes.
 *
 * @author upiol
 * @version 1.0
 */

public class BankingTest {

    /**
     * Main method to execute and check the methods from other classes.
     *
     * @param args not used
     *
     */

    public static void main(String[] args) {

        BankAccount firstAccount = new BankAccount(123, 123);
        BankAccount secondAccount = new BankAccount(321, 321);
        firstAccount.getAccountNumber();
        secondAccount.getAccountNumber();
        firstAccount.getBankCode();
        secondAccount.getBankCode();
        firstAccount.getBalance();
        secondAccount.getBalance();
        firstAccount.deposit(100);
        secondAccount.deposit(200);
        firstAccount.withdraw(130);
        secondAccount.withdraw(155);
        firstAccount.transfer(secondAccount, 100);
        secondAccount.transfer(firstAccount, 400);
        Bank firstBank = new Bank(3131);
        Bank secondBank = new Bank(1414);
        firstBank.getBankCode();
        secondBank.getBankCode();
        firstBank.getAccounts();
        secondBank.getAccounts();
        firstBank.createAccount();
        firstBank.createAccount();
        firstBank.createAccount();
        firstBank.createAccount();
        secondBank.createAccount();
        secondBank.createAccount();
        secondBank.createAccount();
        secondBank.createAccount();
        secondBank.createAccount();
        secondBank.createAccount();
        secondBank.createAccount();
        secondBank.createAccount();
        secondBank.createAccount();
        firstBank.removeAccount(3);
        secondBank.removeAccount(6);
        secondBank.removeAccount(11);
        firstBank.containsAccount(3);
        secondBank.containsAccount(2);
        firstBank.getAccount(2).deposit(300);
        firstBank.internalTransfer(2, 0, 250);
        secondBank.internalTransfer(2, 3, 100);
        int firstBankLength = firstBank.length(); // should be 8
        int secondBankLength = secondBank.length(); // should be 16
        int firstBankSize = firstBank.size(); // should be 3
        int secondBankSize = secondBank.size(); // 8
        System.out.println(firstBankLength);
        System.out.println(secondBankLength);
        System.out.println(firstBankSize);
        System.out.println(secondBankSize);
        System.out.println(firstBank.getAccount(2).getBalance()); // should be 50

    }

}