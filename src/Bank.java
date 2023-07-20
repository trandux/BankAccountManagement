/**
 * Represents a bank.
 *
 * @author upiol
 * @version 1.0
 */

public class Bank {

    private int bankCode;

    private BankAccount[] accounts;

    /**
     * Constructs a Bank object with the specified bank code and 8 accounts.
     * @param bankCode the bank code for the bank.
     */

    public Bank(int bankCode) {

        this.bankCode = bankCode;

        this.accounts = new BankAccount[8];

    }

    /**
     * Returns the bank code of the bank.
     * @return the bank code.
     */

    public int getBankCode() {

        return bankCode;

    }

    /**
     * Returns the array of bank accounts in the bank.
     * @return the bank accounts array.
     */

    public BankAccount[] getAccounts() {

        return accounts;

    }

    private void setAccounts(BankAccount[] accounts) {

        this.accounts = accounts;

    }

    /**
     * Creates a new bank account and adds it to the bank.
     * @return The account number of the newly created bank account.
     */

    public int createAccount() {

        boolean thereIsEmptySpot = false;

        int index = 0;

        int accountNumber;

        BankAccount[] accountArray = getAccounts();

        for (BankAccount account: accountArray) {

            if (account == null) {

                thereIsEmptySpot = true;

                break;

            }

            index++;

        }

        if (thereIsEmptySpot) {

            if (index == 0) {

                accountNumber = 0;
            }

            else {

                accountNumber = accountArray[index - 1].getAccountNumber() + 1;

            }

            BankAccount bankAccountToAdd = new BankAccount(accountNumber, getBankCode());

            BankAccount[] returnAccountArray = accountArray;

            returnAccountArray[index] = bankAccountToAdd;

            setAccounts(returnAccountArray);

            return accountNumber;

        }

        else {

            int currentLength = length();

            accountNumber = accountArray[currentLength - 1].getAccountNumber() + 1;

            BankAccount bankAccountToAdd = new BankAccount(accountNumber, getBankCode());

            BankAccount[] returnAccountArray = new BankAccount[currentLength * 2];

            System.arraycopy(accountArray, 0, returnAccountArray, 0, currentLength);

            returnAccountArray[currentLength] = bankAccountToAdd;

            setAccounts(returnAccountArray);

            return accountNumber;

        }

    }

    /**
     * Removes the bank account with the specified account number from the bank.
     * @param accountNumber the account number of the bank account to remove.
     * @return true if the removal is successful, false otherwise.
     */

    public boolean removeAccount(int accountNumber) {

        final int minimumLength = 8;

        boolean doesAccountExist = containsAccount(accountNumber);

        if (doesAccountExist) {

            int index = 0;

            BankAccount[] accountArray = getAccounts();

            int currentLength = length();

            BankAccount[] returnAccountArray = new BankAccount[currentLength];

            boolean cutInHalf = size() < (currentLength / 4);

            boolean isLengthMinimum = (currentLength == minimumLength);

            if (cutInHalf && !isLengthMinimum) {

                int halfOfLength = currentLength / 2;

                returnAccountArray = new BankAccount[halfOfLength];

                System.arraycopy(accountArray, 0, returnAccountArray, 0, halfOfLength);

            }

            else {

                System.arraycopy(accountArray, 0, returnAccountArray, 0, currentLength);

            }

            for (BankAccount account: returnAccountArray) {

                if (account.getAccountNumber() == accountNumber) {

                    break;
                }

                index++;

            }

            for (int i = index; i < returnAccountArray.length - 1; i++) {

                returnAccountArray[i] = returnAccountArray[i + 1];

            }

            returnAccountArray[returnAccountArray.length - 1] = null;

            setAccounts(returnAccountArray);

        }

        return doesAccountExist;


    }

    /**
     * Checks if the bank contains a bank account with the specified account number.
     * @param accountNumber the account number to check.
     * @return true if the bank contains the account, false otherwise.
     */

    public boolean containsAccount(int accountNumber) {

        boolean returnValue = false;

        BankAccount[] accountArray = getAccounts();

        for (BankAccount account: accountArray) {

            if (account != null && account.getAccountNumber() == accountNumber) {

                returnValue = true;

            }
        }

        return returnValue;

    }

    /**
     * Transfers the specified amount from one bank account to another within the bank.
     *
     * @param fromAccountNumber the account number of the source bank account.
     * @param toAccountNumber  the account number of the target bank account.
     * @param amount the amount to transfer.
     * @return true if the transfer is successful, false otherwise.
     */

    public boolean internalTransfer(int fromAccountNumber , int toAccountNumber , int amount ) {

        BankAccount[] accountArray = getAccounts();

        boolean doesSourceAccountExist = containsAccount(fromAccountNumber);

        boolean doesTargetAccountExist = containsAccount(toAccountNumber);

        boolean returnValue = false;

        if (doesSourceAccountExist && doesTargetAccountExist) {

            int index = 0;

            for (BankAccount account: accountArray) {

                if (account.getAccountNumber() == fromAccountNumber) {

                    break;
                }

                index++;

            }

            int sourceAccountIndex = index;

            index = 0;

            for (BankAccount account: accountArray) {

                if (account.getAccountNumber() == toAccountNumber) {

                    break;
                }

                index++;

            }

            int targetAccountIndex = index;

            returnValue = accountArray[sourceAccountIndex].transfer(accountArray[targetAccountIndex], amount);

            setAccounts(accountArray);

        }

        return returnValue;

    }

    /**
     * Returns the length of the bank's accounts array.
     *
     * @return the length of the accounts array.
     */

    public int length() {

        int returnValue = getAccounts().length;

        return returnValue;
    }

    /**
     * Returns the number of occupied array fields of the bank's accounts array.
     * @return the number of occupied array fields.
     */

    public int size() {

        int index = 0;

        BankAccount[] accountArray = getAccounts();

        for (BankAccount account: accountArray) {

            if (account != null) {

                index++;

            }

        }

        return index;

    }

    /**
     * Returns the bank account at the specified index in the accounts array.
     * @param index the index of the bank account.
     * @return the bank account at the specified index, or null if the index is out of bounds.
     */

    public BankAccount getAccount(int index) {

        BankAccount[] accountArray = getAccounts();

        if (index >= length()) {

            return null;
        }

        return accountArray[index];

    }

}
