
package universalaccount;

import java.util.Date;


public class TimedRepaidAccount extends SavingsAccount {
    Date  payDate;
    double penalty;
    
    TimedRepaidAccount(String accountNumber,String pin, double interestRate,Date date, double penalty){
        super(accountNumber, pin, interestRate);
        this.penalty = penalty;
        this.payDate = date;
    }
    
    @Override
   public double takeMoney(double money){
    if(new Date().getTime() < payDate.getTime()){
        return super.takeMoney(money);
    }
    else{
        this.balance-=money;
        return (money-(money*(penalty/100)));
    }
}
}