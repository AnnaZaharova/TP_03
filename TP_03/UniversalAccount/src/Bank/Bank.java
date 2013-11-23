
package Bank;
import universalaccount.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Bank {
    public static ArrayList<UniversalAccount> UA = new ArrayList<UniversalAccount>();
    
    public Bank(){}
    
    public static  void addAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("��� �����\n1.�������������� ����\n2.������� ����\n3.����, ����������� ���������");
        int type = sc.nextInt();
        System.out.println("����� ����� : ");
        String accountNumber = sc.next();
        System.out.println("���-��� : ");
        String pin = sc.next();
        switch(type){
            case 1:
                System.out.println("���������� ������ : ");
                double interestRate = sc.nextDouble();
                UniversalAccount ua1 = new SavingsAccount(accountNumber,pin,interestRate);
                Bank.UA.add(ua1);
                break;
            case 2:
                System.out.println("���������� �������� : ");
                int count = sc.nextInt();
                System.out.println("����� ������ : ");
                double penalti = sc.nextInt();
                UniversalAccount ua2 = new CheckingAccount(accountNumber,pin,penalti,count);
                Bank.UA.add(ua2);
                break;
            case 3:
                System.out.println("���������� ������ :");
                double rate = sc.nextDouble();
                UniversalAccount ua3 = new OverdraftAccount(accountNumber, pin, rate);
                Bank.UA.add(ua3);
                break;
            default:
                break;
        }
    }
    
    public boolean deleteAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("����� ����� : ");
        String account = sc.next();
        for(UniversalAccount ua: Bank.UA){
            if(ua.accountNumber.equals(account))
                return Bank.UA.remove(ua);
        }
        return true;
    }
    
    public static UniversalAccount checkAccount(String number, String pin){
        for(UniversalAccount ua: Bank.UA){
            if(ua.accountNumber.equals(number) && ua.pin.equals(pin))
                return ua;
        }
        return null;
    }
    
}
