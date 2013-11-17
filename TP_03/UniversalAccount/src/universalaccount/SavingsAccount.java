
package universalaccount;


public class SavingsAccount extends UniversalAccount{
    double interestRate;
    
        public SavingsAccount(String accountNumber,String pin, double interestRate){
        super(accountNumber, pin);
        this.interestRate = interestRate;
        this.overdraft = false;
    }
        boolean interestPayments(){
            this.balance+=(this.balance*this.interestRate/100);
            return true;
        }
    
}
