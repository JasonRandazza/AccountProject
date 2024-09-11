//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Testing debit account
        System.out.println("Test DebitAccount:");
        DepitAccount dpt1 = new DepitAccount();
        DepitAccount dpt2 = new DepitAccount(25);

        dpt1.deposit(100);
        dpt1.withdraw(25);
        System.out.println(dpt1.toString());

        dpt2.deposit(100);
        dpt2.withdraw(25);
        System.out.println(dpt2.toString());

        // Testing CreditAccount
        System.out.println("\nTesting CreditAccount:");
        CreditAccount creditAccount = new CreditAccount(0, 500);
        creditAccount.withdraw(200);
        System.out.println("After withdrawing $200: " + creditAccount.toString());
        creditAccount.deposit(150);
        System.out.println("After depositing $150: " + creditAccount.toString());
        creditAccount.withdraw(400);
        System.out.println("After attempting to withdraw $400: " + creditAccount.toString());

        // Testing LoanAccount
        System.out.println("\nTesting LoanAccount:");
        LoanAccount loanAccount = new LoanAccount(-1000, 5);
        double interest = loanAccount.calculateInterest();
        System.out.println("Interest calculated on initial balance: " + interest);
        loanAccount.deposit(100);
        System.out.println("After depositing $100: " + loanAccount.toString());
        loanAccount.deposit(500);
        System.out.println("After depositing $500: " + loanAccount.toString());
        System.out.println("Total interest paid: " + loanAccount.getTotalInterestPaid());
        System.out.println("Total principal paid: " + loanAccount.getTotalPrincipalPaid());
    }
}