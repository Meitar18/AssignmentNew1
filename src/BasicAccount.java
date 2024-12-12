public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    // קונסטרוקטור
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit;
        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double allowedAmount = Math.min(amount, withdrawalLimit);
        if (allowedAmount > this.balance) {
            allowedAmount = this.balance;  // אם לא מספיק יתרה, משוך את כל היתרה
        }
        this.balance -= allowedAmount;
        return allowedAmount;
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }
}

