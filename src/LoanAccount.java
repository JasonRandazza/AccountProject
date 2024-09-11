public class LoanAccount extends Account{
    private double interestRate;
    private double totalInterestPaid;
    private double totalPrincipalPaid;

    //Constructor
    public LoanAccount(double initialBalance, double interestRate){
        super(initialBalance);
        this.setInterestRate(interestRate);
        this.setTotalInterestPaid(0.0);
        this.setTotalPrincipalPaid(0.0);
    }

    //Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    //Setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    //Getter for total interest paid
    public double getTotalInterestPaid() {
        return totalInterestPaid;
    }

    //Setter for total interest paid
    public void setTotalInterestPaid(double totalInterestPaid) {
        this.totalInterestPaid = totalInterestPaid;
    }

    //Getter for total principal paid
    public double getTotalPrincipalPaid() {
        return totalPrincipalPaid;
    }

    //Setter for total principal paid
    public void setTotalPrincipalPaid(double totalPrincipalPaid) {
        this.totalPrincipalPaid = totalPrincipalPaid;
    }

    //Method to calculate interest on balance
    public double calculateInterest(){
        double monthlyInterestRate = interestRate / 12 / 100;
        return getBalance() * monthlyInterestRate;
    }

    //Override deposit
    @Override
    public boolean deposit(double payment){
        if (payment <= 0){
            return false;
        }

        double interestDue = calculateInterest();
        double principalPayment = 0.0;
        double interestPayment = Math.min(payment, interestDue);

        totalInterestPaid += interestPayment;
        setBalance(getBalance() + interestPayment);

        if (payment > interestPayment){
            principalPayment = payment - interestPayment;
            totalPrincipalPaid += principalPayment;
            setBalance(getBalance() - principalPayment);
        }
        return true;
    }

    //Override withdraw
    @Override
    public boolean withdraw(double amount){
        return false;
    }

    //Method to get total amount paid
    public double getTotalAmountPaid(){
        return totalInterestPaid + totalPrincipalPaid;
    }
}
