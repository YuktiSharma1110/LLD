package ATM;

public class User {
    BankAccount bankAccountNum;
    Card card;

    public void setCard(Card card)
    {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }


}
