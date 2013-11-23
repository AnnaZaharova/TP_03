
package tests;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import universalaccount.*;
import Bank.*;

public class TestATM {
    static UniversalAccount account1; 
    static UniversalAccount account2;
    static UniversalAccount account3;
    

     @BeforeClass
     public static void setUp() throws Exception {
          account1 = new CheckingAccount("1234","1234",3,5);
          account1.addMoney(200.0);
          account1.setFunds(120.0);
          
          account2 = new SavingsAccount("2345","2345",20);
          account2.addMoney(100.0);
          
          account3 = new SavingsAccount("5478","1247",10.0);
          account3.addMoney(220.0);
          
          Bank.UA.add(account1);
          Bank.UA.add(account2);
          Bank.UA.add(account3);
     }
    
    @Test
    public void addMoney(){
        UniversalAccount ua = new CheckingAccount("23","55",3,5);
        assertTrue(ua.addMoney(26.0));
    }
    
    @Test
    public void checkAccount(){
        UniversalAccount ua = Bank.checkAccount("2345", "2345");
        assertEquals(account2, ua);
    }
    
    @Test
    public void setFunds(){
        assertFalse(account2.setFunds(400.0));
    }
    
    @Test
    public void getBalance(){
       assertTrue(account2.getBalance()== 100.0);
    }
    
    @Test
    public void takeFunds(){
        assertFalse(account1.takeFunds(150.0));
    }
    
    @Test
    public void checkCount(){
        assertTrue(((CheckingAccount)account1).getTotalOperation() == 2);
    }
    
    @Test
    public void addAccount(){
        int size = Bank.UA.size();
        Bank.UA.add(new SavingsAccount("5478","1247",10.0));
        assertTrue(Bank.UA.size() - size == 1 && Bank.UA.get(Bank.UA.size()-1)!=null);
    }

    
    
}