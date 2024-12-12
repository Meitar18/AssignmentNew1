public interface IAccount {
    void Deposit(double amount);  // הפקדה לחשבון
    double Withdraw(double amount);  // משיכה מחשבון
    double GetCurrentBalance();  // קבלת יתרה נוכחית
    int GetAccountNumber();  // קבלת מספר חשבון
}
