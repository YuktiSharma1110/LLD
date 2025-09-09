package ATM;

public class TransactionRequest {
    public final Card card;
    public final int enteredPin;
    public final TransactionType transactionType;
    public final Long amount;     // null unless WITHDRAW/DEPOSIT
    public final Integer newPin;  // null unless CHANGE_PIN

    public TransactionRequest(Card card, int enteredPin, TransactionType type, Long amount, Integer newPin) {
        this.card = card;
        this.enteredPin = enteredPin;
        this.transactionType = type;
        this.amount = amount;
        this.newPin = newPin;
    }
}
