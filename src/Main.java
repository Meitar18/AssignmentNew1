public class Main {
    public static void main(String[] args) {
        // יצירת חשבונות שונים
        IAccount standard = new StandardAccount(1, -100);  // חשבון סטנדרטי עם מגבלת אשראי
        IAccount basic = new BasicAccount(2, 100);  // חשבון בסיסי עם מגבלת משיכה
        IAccount premium = new PremiumAccount(3);  // חשבון פרימיום בלי מגבלת אשראי
        IBank bank = new Bank();  // יצירת בנק חדש

        // פתיחת החשבונות בבנק
        bank.OpenAccount(standard);
        bank.OpenAccount(premium);
        bank.OpenAccount(basic);

        // הפקדה של 1000 לכל חשבון
        System.out.println("Depositing 1000 in each account...");
        premium.Deposit(1000);
        standard.Deposit(1000);
        basic.Deposit(1000);
        System.out.println("");

        // נסיון למשוך 3000 מכל חשבון
        System.out.println("Withdrawing 3000 from each account...");
        System.out.println("Withdrawn " + premium.Withdraw(3000) + " From Premium Account");
        System.out.println("Withdrawn " + basic.Withdraw(3000) + " From Basic Account");
        System.out.println("Withdrawn " + standard.Withdraw(3000) + " From Standard Account");
        System.out.println("");

        // בדיקת יתרות בכל החשבונות
        System.out.println("Current Balance in account number " + premium.GetAccountNumber() + "(Premium) is " + premium.GetCurrentBalance());
        System.out.println("Current Balance in account number " + basic.GetAccountNumber() + "(Basic) is " + basic.GetCurrentBalance());
        System.out.println("Current Balance in account number " + standard.GetAccountNumber() + "(Standard) is " + standard.GetCurrentBalance());
        System.out.println("");

        // הדפסת כל החשבונות שנמצאים בחוב
        for (IAccount account : bank.GetAllAccountsInDebt()) {
            System.out.println("Account " + account.GetAccountNumber() + " is in debt");
        }
        System.out.println("");

        // סגירת כל החשבונות בבנק
        System.out.println("Closing all accounts in the bank...");
        bank.CloseAccount(premium.GetAccountNumber());
        bank.CloseAccount(basic.GetAccountNumber());
        bank.CloseAccount(standard.GetAccountNumber());
        // בדיקת מספר החשבונות בבנק אחרי סגירתם
        System.out.println("There are " + bank.GetAllAccounts().size() + " accounts in the bank");
        System.out.println("");

        // הפקדת 2000 לכל החשבונות שנותרו
        System.out.println("Depositing 2000 in each account...");
        premium.Deposit(2000);
        standard.Deposit(2000);

        // הדפסת כל החשבונות עם יתרה גבוהה מ-1000
        for (IAccount account : bank.GetAllAccountsWithBalance(1000)) {
            System.out.println("Account " + account.GetAccountNumber() + " has more than 1000 in its balance");
        }
        System.out.println("");

        // בדיקת יתרות אחרי ההפקדה
        System.out.println("Current Balance in account number " + premium.GetAccountNumber() + "(Premium) is " + premium.GetCurrentBalance());
        System.out.println("Current Balance in account number " + standard.GetAccountNumber() + "(Standard) is " + standard.GetCurrentBalance());

        // סגירת כל החשבונות שנשארו
        System.out.println("");
        System.out.println("Closing all bank accounts...");
        bank.CloseAccount(premium.GetAccountNumber());
        bank.CloseAccount(standard.GetAccountNumber());
        // בדיקת מספר החשבונות בבנק אחרי סגירתם
        System.out.println("There are " + bank.GetAllAccounts().size() + " accounts in the bank");
    }
}
