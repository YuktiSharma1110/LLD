package ATM;

public class Card {
     long cardNum;
    int cvv;
     String expiry;
     int pin;
     BankAccount account;

    public Card(long cardNum, int cvv, String expiry, int initialPin, BankAccount account) {
        this.cardNum = cardNum;
        this.cvv = cvv;
        this.expiry = expiry;
        this.pin = initialPin;
        this.account = account;
    }

    public boolean authenticatePin(int enteredPin)
    {
        return this.pin == enteredPin;
    }
    public void changePin(int newPin)
    {
        this.pin = newPin;
    }
    public BankAccount getAccount()
    {
        return account;
    }
    public long getCardNum()
    {
        return cardNum;
    }


}
