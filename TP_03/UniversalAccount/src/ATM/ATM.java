
package ATM;
import universalaccount.*;
import Bank.Bank;
import java.util.Scanner;
public  class ATM {
    
    static public UniversalAccount enterAccountNumberAndPin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер аккаунта");
        String number = sc.nextLine();
        System.out.println("Введите пин");
        String pin = sc.nextLine();
        return Bank.checkAccount(number, pin);
    }
    
    static public void useATM(){
        String temp = "";
        Scanner sc = new Scanner(System.in);
        UniversalAccount UA = enterAccountNumberAndPin();
        if(UA!=null){
            while(true){
                System.out.println("Выберите операцию\n1.Показать текущий баланс\n2.Положить денег на счет\n3.Снять деньги\n"
                        + "4.Вложить фонды\n5.Получить фонды\n6.Выход");
                int num = sc.nextInt();
                switch(num){
                    case 1:     
                        System.out.println("Введите пин");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            System.out.println("Баланс = " + UA.getBalance());
                        }
                        else
                            System.out.println("Неверный пин!");
                        break;
                    case 2:
                        System.out.println("Количество : ");
                        double amount = sc.nextDouble();
                        System.out.println("Введите пин");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            if(UA.addMoney(amount))
                                System.out.println("Деньги зачислены");
                        }
                        else
                            System.out.println("Неверный пин!");
                        break;
                    case 3:
                        System.out.println("Количество : ");
                        double amount1 = sc.nextDouble();
                        System.out.println("Введите пин");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            if(UA.takeMoney(amount1)!=0.0)
                                System.out.println("Деньги сняты");
                            else
                                System.out.println("Недостаточно ресурсов");
                        }
                        break;
                    case 4:
                        System.out.println("Сумма денег :");
                        double setSum = sc.nextDouble();
                        System.out.println("Введите пин");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            if(UA.setFunds(setSum))
                                System.out.println("Операция прошла успешно");
                        }
                        else
                            System.out.println("Неверный пин!");
                        break;
                    case 5:
                        System.out.println("Сумма денег :");
                        double getSum = sc.nextDouble();
                        System.out.println("Введите пин");
                        temp = sc.next();
                        if(UA.pin.equals(temp)){
                            if(UA.takeFunds(getSum))
                                System.out.println("Операция прошла успешно");
                        }
                        else
                            System.out.println("Неверный пин!");
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
            System.out.println("1.Создать счет\n2.Использовать банкомат\n3.Выход");
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
