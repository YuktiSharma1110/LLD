package ATM;

import java.util.Scanner;

public class ProcessPin implements ProcessTransaction {
    private static final Scanner IN = new Scanner(System.in);

    @Override
    public void execute(TransactionRequest request) {
        int pinAttempt = request.enteredPin;
        while (!request.card.authenticatePin(pinAttempt)) {
            System.out.print("Wrong PIN. Re-enter CURRENT PIN: ");
            while (!IN.hasNextInt()) { IN.next(); System.out.print("Please enter a numeric PIN: "); }
            pinAttempt = IN.nextInt();
        }

        System.out.print("Enter NEW PIN: ");
        int newPin = readPin();
        System.out.print("Re-enter NEW PIN: ");
        int confirm = readPin();
        if (newPin != confirm) {
            System.out.println("PIN mismatch. Aborting.");
            return;
        }

        request.card.changePin(newPin);
        System.out.println("PIN changed.");
    }

    private int readPin() {
        while (!IN.hasNextInt()) { IN.next(); System.out.print("Please enter a numeric PIN: "); }
        return IN.nextInt();
    }
}
