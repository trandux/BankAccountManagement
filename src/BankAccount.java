/**
 * Represents a bank account.
 *
 * @author upiol
 * @version 1.0
 */

public class BankAccount {

    private int accountNumber;

    private int bankCode;

    private int balance;

    /**
     * Constructs a BankAccount object with the specified account number and bank code and with a balanco of 0.
     * @param accountNumber account number for the bank account
     * @param bankCode bank code for the bank account
     */

    public BankAccount(int accountNumber, int bankCode) {

        this.accountNumber = accountNumber;

        this.bankCode = bankCode;

        this.balance = 0;

    }

    /**
     * Returns the account number of the bank account.
     * @return the account number.
     */

    public int getAccountNumber() {

        return accountNumber;
    }

    /**
     * Returns the bank number of the bank account.
     * @return the bank number.
     */

    public int getBankCode() {

        return bankCode;
    }

    /**
     * Returns the balance of the bank account
     * @return the balance
     */

    public int getBalance() {

        return balance;
    }

    private void setBalance(int balance) {

        this.balance = balance;
    }

    /**
     * Withdraws the specified amount from the bank account.
     * @param amount the amount to withdraw from the bank account
     * @return true if the withdrawal is successful, false otherwise.
     */

    public boolean withdraw(int amount) {

        boolean returnValue = false;

        if (getBalance() >= amount) {

            int newBalance = getBalance() - amount;

            setBalance(newBalance);

            returnValue = true;

        }

        return returnValue;

    }

    /**
     * Deposits the specified amount into the bank account.
     * @param amount the amount to deposit into the bank account.
     */


    public void deposit(int amount) {

        int newBalance = getBalance() + amount;

        setBalance(newBalance);

    }

    /**
     * Transfers the specified amount from this bank account to the target account.
     * @param account the target bank account to transfer to.
     * @param amount the amount to transfer,
     * @return true if the transfer is successful, false otherwise.
     */

    public boolean transfer(BankAccount account, int amount) {

        boolean moneyCheck = this.withdraw(amount);

        if (moneyCheck) {

            account.deposit(amount);

        }

        return moneyCheck;

    }
}
