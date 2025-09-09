package ATM;

import java.util.Scanner;

public class ATMRoom {
    private ATM atm;
    private User user;

    public static void main(String[] args) {
        ATMRoom room = new ATMRoom();
        room.init();
        room.runFlow();
    }

    public void init() {
        System.out.println("Entered ATM Room");
        atm  = new ATM(1000L, 90, 25, 10);
        user = new User();
        BankAccount account = new BankAccount(1001L, 10000L);
        Card card = new Card(4111111111111111L, 123, "12/29", 1234, account);
        user.card = card;
        System.out.println("ATM initialized. Card & account initialized.");
        System.out.println("Exit ATM Room init");
    }

    public void runFlow() {
        Scanner in = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect Operation:");
            System.out.println("1) Check Balance");
            System.out.println("2) Withdraw Cash");
            System.out.println("3) Change PIN");
            System.out.println("4) Exit");
            System.out.print("Choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter PIN: ");
                    int enteredPin = in.nextInt();
                    TransactionRequest req = buildRequest(TransactionType.BALANCE, 0L, enteredPin);
                    new ATMTransaction(req);
                    break;
                }
                case 2: {
                    System.out.print("Enter PIN: ");
                    int enteredPin = in.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    long amt = in.nextLong();
                    TransactionRequest req = buildRequest(TransactionType.WITHDRAW, amt, enteredPin);
                    new ATMTransaction(req);
                    break;
                }
                case 3: {
                    System.out.print("Enter CURRENT PIN: ");
                    int enteredPin = in.nextInt();
                    TransactionRequest req = buildRequest(TransactionType.CHANGE_PIN, 0L, enteredPin);
                    new ATMTransaction(req);
                    break;
                }
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        System.out.println("Card ejected. Goodbye!");
    }

    private TransactionRequest buildRequest(TransactionType type, long amount, int enteredPin) {
        Long amt = (type == TransactionType.WITHDRAW) ? Long.valueOf(amount) : null;
        Integer np = null; // new PIN will be collected inside ProcessPin after auth
        return new TransactionRequest(user.card, enteredPin, type, amt, np);
    }
}
