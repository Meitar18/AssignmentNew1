import java.util.List;

public interface IBank {
    void OpenAccount(IAccount account);  // פתיחת חשבון בבנק
    void CloseAccount(int accountNumber);  // סגירת חשבון
    List<IAccount> GetAllAccounts();  // קבלת כל החשבונות
    List<IAccount> GetAllAccountsInDebt();  // קבלת כל החשבונות עם יתרה שלילית
    List<IAccount> GetAllAccountsWithBalance(double amount);  // קבלת כל החשבונות עם יתרה מעל סכום מסוים
}
