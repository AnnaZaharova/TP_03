
package universalaccount;


public class CheckingAccount extends UniversalAccount{
    private static int operationCount;
    int totaloperation;
    private double penalti;
    
    public CheckingAccount(String accountNumber,String pin,double penalti,int operationCount){
        super(accountNumber, pin);
        this.overdraft = false;
        this.penalti = penalti;
        CheckingAccount.operationCount = operationCount;
    }
    
    @Override
    public  boolean setFunds(double funds){
        if(super.setFunds(funds)){
            totaloperation++;
            if(totaloperation >= CheckingAccount.operationCount)
                    balance-=penalti;
            return true;
        }
        else
            return false;
    } 
    
    @Override
    public boolean takeFunds(double funds){
        if(super.takeFunds(funds)){
            totaloperation++;
            if(totaloperation >= CheckingAccount.operationCount)
                    balance-=penalti;
            return true;
        }
        else
            return false;
    }
    
    @Override
    public double getBalance(){
        totaloperation++;
        return balance;
    }
    
        @Override
    public boolean addMoney(double money){
            totaloperation++;
            return super.addMoney(money);
    }
    
    public int getTotalOperation(){
        return this.totaloperation;
    }
    
}
    
    

