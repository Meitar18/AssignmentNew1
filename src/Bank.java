import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;  // רשימה של כל החשבונות בבנק

    // קונסטרוקטור
    public Bank() {
        accounts = new ArrayList<>();  // אתחול הרשימה
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);  // מוסיף חשבון חדש לרשימה
    }

    @Override
    public void CloseAccount(int accountNumber) {
        IAccount accountToClose = null;
        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                accountToClose = account;
                break;
            }
        }
        // אם החשבון נמצא ויתרתו חיובית, נסגור אותו
        if (accountToClose != null && accountToClose.GetCurrentBalance() >= 0) {
            accounts.remove(accountToClose);
        } else {
            System.out.println("Account " + accountNumber + " cannot be closed due to negative balance.");
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return accounts;  // מחזיר את כל החשבונות
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> inDebt = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                inDebt.add(account);  // מוסיף חשבונות עם יתרה שלילית לרשימה
            }
        }
        return inDebt;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double amount) {
        List<IAccount> withBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > amount) {
                withBalance.add(account);  // מוסיף חשבונות עם יתרה גבוהה מהסכום שניתן
            }
        }
        return withBalance;
    }
}
