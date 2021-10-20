package myPackage;
import java.util.Scanner;

abstract class BankConfigStruct { 
    // abstract class hides all config details ... so user can only set inital values and can't mess with default values
    double Total=1000000;
    double dailyamount=100000; //amount added to the ATM daily
    double capacity=1000000;
    double wdlimit=40000; // withdrawal limit

    Scanner scan=new Scanner(System.in);

    //various methods to set ATM configurations

    void setamount(){
        System.out.println("Enter the amount to be added each day into the ATM: ");
        dailyamount=scan.nextDouble();
    }
    void setcapacity(){
        System.out.println("Enter the maximum capacity of the ATM: ");
        capacity=scan.nextDouble();
    }
    void setwdlimit(){
        System.out.println("Enter the withdrawal limit of the ATM: ");
        wdlimit=scan.nextDouble();
    }
    void print(){
        System.out.println("ATM configuration details:");
        System.out.println("Total amount currently in the ATM: Rs."+Total);
        System.out.println("Total max amount added daily into the ATM: Rs."+dailyamount);
        System.out.println("Total capacity of the ATM: Rs."+capacity);
        System.out.println("Withdrawal limit of the ATM: Rs."+wdlimit);
    }
    void withdrawTotal(double d){
        Total=Total-d; // decreasing total amount in the bank when there is a withdrawal
    }
    void DepositTotal(double d){
        Total+=d; // incrementing the total in the ATM when there is a user deposit or daily deposit
    }
}
public class BankConfig extends BankConfigStruct{
    Scanner scan=new Scanner(System.in);
    BankConfig(){
        print();
    }
    BankConfig(int x){
        System.out.println("Select the corresponding choices!");
        System.out.println("1. Change amount added each day");
        System.out.println("2. Set maximum capacity of the ATM");
        System.out.println("3. Set withdrawal limit");
        System.out.println("4. Proceed with default settings");
        System.out.println("5. Set all of the above fields");
        System.out.println("6. Exit Program");
        int n=scan.nextInt();scan.nextLine();
        switch(n){
            case (1):
                setamount();
                break;
            case (2):
                setcapacity();
                break;
            case (3):
                setwdlimit();
                break;
            case (4):
                break;
            case (5):
                setamount();
                setcapacity();
                setwdlimit();
                break;
            case (6):
                System.out.println("Program is terminating...");
                System.exit(0);
        }
        System.out.println("The respective configurations are made. Thank You!");
        
    }
    
}
