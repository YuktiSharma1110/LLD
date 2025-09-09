//package ATM;
//
//public class BankAccount {
//
//    long accountNum;
//    long accountBalance;
//    AccountType accountType;
//
//    public void updateBalance()
//    {
//
//    }
//
//    public void checkBalance()
//    {
//
//    }
//}

package ATM;

public class BankAccount {
    long accountNum;
   long balance;
   // private final AccountType accountType;

    public BankAccount(long accountNum, long openingBalance)
    {
        this.accountNum = accountNum;
        this.balance = openingBalance;
        //this.accountType = accountType;
    }

    public long getAccountNum()
    {
        return accountNum;
    }
    public long getBalance()
    {
        return balance;
    }
//    public AccountType getAccountType()
//    {
//        return accountType;
//    }

    public long credit(long amount)
    {
        if (amount <= 0) throw new IllegalArgumentException("amount <= 0");
        balance += amount;
        return balance;
    }

    public long debit(long amount)
    {
        if (amount <= 0) throw new IllegalArgumentException("amount <= 0");
        if (balance < amount) throw new IllegalStateException("insufficient funds");
        balance -= amount;
        return balance;
    }
}

