package ATM;

public class ATMTransaction {

    TransactionRequest request;

    ATMTransaction(TransactionRequest request)
    {
        this.request = request;
        startTransaction(request);
    }

    public void startTransaction(TransactionRequest request)
    {
       TransactionType type =  request.transactionType;

        ProcessTransaction transaction;

        switch (type)
        {
            case WITHDRAW:   transaction = new ProcessWithdraw();
                             break;
            case BALANCE:    transaction = new ProcessBalance();
                             break;
            case CHANGE_PIN: transaction = new ProcessPin();
                             break;

            default: throw new IllegalArgumentException("Incorrect transaction type");
        }

        transaction.execute(request);
    }










}
