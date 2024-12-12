public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance;

    // קונסטרוקטור
    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;  // מתחילים את יתרת החשבון ב-0
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;  // הוספת סכום לחשבון
    }

    @Override
    public double Withdraw(double amount) {
        double allowedAmount = amount;  // סכום המשיכה הוא בדיוק הסכום המבוקש
        if (allowedAmount > this.balance) {
            allowedAmount = this.balance;  // אם הסכום המבוקש גדול מהיתרה, יש למשוך את כל היתרה
        }
        this.balance -= allowedAmount;  // עדכון יתרת החשבון
        return allowedAmount;  // מחזירים את הסכום שנמשך
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;  // מחזירים את יתרת החשבון
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;  // מחזירים את מספר החשבון
    }
}

