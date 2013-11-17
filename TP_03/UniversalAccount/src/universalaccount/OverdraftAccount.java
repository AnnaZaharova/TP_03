
package universalaccount;


public class OverdraftAccount extends UniversalAccount {
    double interestRate;
    
    public OverdraftAccount(String accountNumber,String pin, double interestRate){
        super(accountNumber, pin);
        this.interestRate = interestRate;
        this.overdraft = true;
    }
    
    boolean interestPayments(){
        if(this.balance < 0){
            this.balance+=this.balance*this.interestRate/100;
            return true;
        }
        return false;
    }   
    
    @Override
    public boolean setFunds(double funds){
            balance-=funds;
            fund+=funds;
            return true;
    }
}
