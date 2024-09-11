public class CreditAccount  extends Account{

    CreditAccount(){ super();}

    private double creditLimit;

    //Constructor w/ a balance and a credit limit.
    public CreditAccount(double balance, double creditLimit){
        super(balance);
        this.creditLimit = creditLimit;
    }

    //Copy constructor
    public CreditAccount(CreditAccount act){
        super(act);
        this.creditLimit = act.creditLimit;
    }

    //Credit limit getter
    public double getCreditLimit(){
        return creditLimit;
    }

    //Credit limit setter
    public void setCreditLimit(double creditLimit){
        this.creditLimit = creditLimit;
    }

    //Override deposit method
    @Override
    public boolean deposit(double amount){
        if (amount > 0){
            setBalance(getBalance() + amount);

            if (getBalance() > 0){
                setBalance(0);
            }
            return true;
        }
        return false;
    }

    //Override withdraw method
    public boolean withdraw(double amount){
        if (amount > 0) {
            if ((getBalance() - amount) >= -creditLimit){
                setBalance(getBalance() - amount);
                return true;
            }
        }
        return false;
    }
}
