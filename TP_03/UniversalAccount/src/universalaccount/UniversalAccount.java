
package universalaccount;


public abstract class UniversalAccount {

    double fund;
    double balance;
    boolean overdraft;
    public String accountNumber;
    public String pin;
    
    UniversalAccount(String accountNumber,String pin){
        super();
        this.accountNumber = accountNumber;
        this.pin = pin;
    }
    
    public boolean setFunds(double funds){
        if(funds <= balance){
            balance-=funds;
            fund+=funds;
            return true;
        }
        else 
            return false;
    }
    
    public  boolean takeFunds(double funds){
        if(funds >= this.fund){
            this.fund-=funds;
            this.balance+=funds;
            return true;
        }
        else
            return false;
    }
    public double getBalance(){
        return balance;
}
    public boolean addMoney(double money){
        this.balance+=money;
        return true;
    }
            
            
}
