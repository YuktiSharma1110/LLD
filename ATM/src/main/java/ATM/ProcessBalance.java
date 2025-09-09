package ATM;

import java.util.Scanner;

public class ProcessBalance implements ProcessTransaction {
    private static final Scanner IN = new Scanner(System.in);

    @Override
    public void execute(TransactionRequest request) {
        int pinAttempt = request.enteredPin;
        while (!request.card.authenticatePin(pinAttempt)) {
            System.out.print("Wrong PIN. Re-enter PIN: ");
            while (!IN.hasNextInt()) { IN.next(); System.out.print("Please enter a numeric PIN: "); }
            pinAttempt = IN.nextInt();
        }
        long bal = request.card.getAccount().getBalance();
        System.out.println("Balance: " + bal);
    }
}
