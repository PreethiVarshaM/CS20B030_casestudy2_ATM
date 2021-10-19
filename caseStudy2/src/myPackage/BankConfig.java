package myPackage;
import java.util.Scanner;

abstract class BankConfigStruct {
    double Total=1000000;
    double dailyamount=100000;
    double capacity=1000000;
    double wdlimit=40000;
    double interest=0.005;
}
public class BankConfig extends BankConfigStruct{
    Scanner scan=new Scanner(System.in);
    BankConfig(){

    }
    BankConfig(int x){
        System.out.println("Select the corresponding choices!");
        System.out.println("1. Change amount added each day");
        System.out.println("2. Set maximum capacity of the ATM");
        System.out.println("3. Set interest percentage");
        System.out.println("4. Set withdrawal limit");
        System.out.println("5. Proceed with default settings");
        System.out.println("6. Set all of the above fields");
        System.out.println("7. Exit Program");
        int n=scan.nextInt();scan.nextLine();
        switch(n){
            case (1):
                setamount();
                break;
            case (2):
                setcapacity();
                break;
            case (3):
                setinterest();
                break;
            case (4):
                setwdlimit();
                break;
            case (5):
                break;
            case (6):
                setamount();
                setcapacity();
                setinterest();
                setwdlimit();
                break;
            case (7):
                System.out.println("Program is terminating...");
                System.exit(0);
        }
        System.out.println("The respective configurations are made. Thank You!");
        
    }
    void setamount(){
        System.out.println("Enter the amount to be added each day into the ATM: ");
        dailyamount=scan.nextDouble();
    }
    void setcapacity(){
        System.out.println("Enter the maximum capacity of the ATM: ");
        capacity=scan.nextDouble();
    }
    void setinterest(){
        System.out.println("Enter the interest rate per month of the Bank: ");
        interest=scan.nextDouble();
    }
    void setwdlimit(){
        System.out.println("Enter the withdrawal limit of the ATM: ");
        wdlimit=scan.nextDouble();
    }
    void print(){
        System.out.println("ATM configuration details:");
        System.out.println();
    }
}
