public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    // קונסטרוקטור
    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        // אם המגבלה חיובית, נכוון אותה לאפס (לא ניתן מגבלת אשראי חיובית)
        this.creditLimit = creditLimit < 0 ? creditLimit : 0;
        this.balance = 0; // התחל את יתרת החשבון ב-0
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        // לחשב את הסכום שניתן למשוך - לא יותר מהיתרה + מגבלת האשראי
        double availableAmount = this.balance - this.creditLimit;

        // אם הסכום המבוקש יותר ממה שניתן למשוך, מחזירים רק את הסכום המותר
        double allowedAmount = (amount > availableAmount) ? availableAmount : amount;

        this.balance -= allowedAmount;  // עדכון יתרת החשבון
        return allowedAmount;  // מחזירים את הסכום שנמשך
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
