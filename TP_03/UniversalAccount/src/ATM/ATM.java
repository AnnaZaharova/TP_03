
package ATM;
import universalaccount.*;
import Bank.Bank;
import java.util.Scanner;
public  class ATM {
    
    static public UniversalAccount enterAccountNumberAndPin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("������� ����� ��������");
        String number = sc.nextLine();
        System.out.println("������� ���");
        String pin = sc.nextLine();
        return Bank.checkAccount(number, pin);
    }
    
    static public void useATM(){
        String temp = "";
        Scanner sc = new Scanner(System.in);
        UniversalAccount UA = enterAccountNumberAndPin();
        if(UA!=null){
            while(true){
                System.out.println("�������� ��������\n1.�������� ������� ������\n2.�������� ����� �� ����\n3.����� ������\n"
                        + "4.������� �����\n5.�������� �����\n6.�����");
                int num = sc.nextInt();
                switch(num){
                    case 1:     
                        System.out.println("������� ���");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            System.out.println("������ = " + UA.getBalance());
                        }
                        else
                            System.out.println("�������� ���!");
                        break;
                    case 2:
                        System.out.println("���������� : ");
                        double amount = sc.nextDouble();
                        System.out.println("������� ���");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            if(UA.addMoney(amount))
                                System.out.println("������ ���������");
                        }
                        else
                            System.out.println("�������� ���!");
                        break;
                    case 3:
                        System.out.println("���������� : ");
                        double amount1 = sc.nextDouble();
                        System.out.println("������� ���");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            if(UA.takeMoney(amount1)!=0.0)
                                System.out.println("������ �����");
                            else
                                System.out.println("������������ ��������");
                        }
                        break;
                    case 4:
                        System.out.println("����� ����� :");
                        double setSum = sc.nextDouble();
                        System.out.println("������� ���");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            if(UA.setFunds(setSum))
                                System.out.println("�������� ������ �������");
                        }
                        else
                            System.out.println("�������� ���!");
                        break;
                    case 5:
                        System.out.println("����� ����� :");
                        double getSum = sc.nextDouble();
                        System.out.println("������� ���");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            if(UA.takeFunds(getSum))
                                System.out.println("�������� ������ �������");
                        }
                        else
                            System.out.println("�������� ���!");
                        break;
                    case 6:
                        return ;

                }
            }
        }
    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int num =  0;
        while(true){
            System.out.println("1.������� ����\n2.������������ ��������\n3.�����");
            num = sc.nextInt();
            switch(num){
                case 1: 
                    Bank.addAccount();
                    break;
                case 2:
                    useATM();
                    break;
                case 3:
                    return;
            }
        }
    }
    
}
