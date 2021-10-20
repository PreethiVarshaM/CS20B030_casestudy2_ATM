package myPackage;
import java.util.*;
abstract class CustomerDetails extends ATM{

    static Scanner scan=new Scanner(System.in);
    static String customerName="null", UserName="null",AadhaarNo="null",PhNum="null",pin="null", accNum="null";
    static double total=0.0f;
    static void setName(){
        System.out.println("Enter your full Name: ");
        customerName=scan.nextLine().trim();
        System.out.println("Your name is set.");
    }
    static void setUserName(){
        System.out.println("Enter your User Name: ");
        UserName=scan.nextLine().trim();
        System.out.println("Your Username is set.");
    }
    String getUserName(){
        return UserName;
    }
    static void setAadhaarNo(){
        System.out.println("Enter your Aadhaar Number: ");
        AadhaarNo=scan.nextLine().trim();
        System.out.println("Your Aadhaar Number is set.");
    }
    static void setPhNum(){
        System.out.println("Enter your phone number: ");
        PhNum=scan.nextLine().trim();
        System.out.println("Your Phone Number is set.");
    }
    void setpin(){
        System.out.println("Enter your Pin (less than 10 characters): ");
        pin=scan.nextLine().trim();
        System.out.println("Re-Enter Pin for confirmation: ");
        String p=scan.nextLine().trim();
        if(!(p.equals(pin))){
            System.out.println("Your pin doesn't match please try again");
            setpin();
        }
        else if(pin.length()>10){
            System.out.println("Your pin is longer than 10 characters. Please enter again");
            setpin();
        }
        else System.out.println("Your Pin is set.");
    }
    void setTotal(){
        System.out.println("Enter your account balance: Rs.");
        total=scan.nextDouble();scan.nextLine();
    }
    String getpin(){
        return pin;
    }
    static void setAccNum(){
        System.out.println("Enter your 5 digit account number: ");
        accNum=scan.nextLine().trim();
        if(accNum.length()!=5){
            System.out.println("Your account number should only be of 5 digits\n Enter again");
            setAccNum();
        }
        else System.out.println("Your account number is set.");
    }  
    String getaccNum(){
        return accNum;
    }
    void deposit(){
        System.out.println("Enter the amount to be deposited: ");
        double d=scan.nextDouble();
        double tot;
        int n2000,n500,n200,n100,n50,n20,n10;
        System.out.println("Enter your cash denominations (if not then enter '0') : ");
        System.out.println("1. Number of 2000 notes: ");
        n2000=scan.nextInt();scan.nextLine();
        System.out.println("1. Number of 500 notes: ");
        n500=scan.nextInt();scan.nextLine();
        System.out.println("1. Number of 200 notes: ");
        n200=scan.nextInt();scan.nextLine();
        System.out.println("1. Number of 100 notes: ");
        n100=scan.nextInt();scan.nextLine();
        System.out.println("1. Number of 50 notes: ");
        n50=scan.nextInt();scan.nextLine();
        System.out.println("1. Number of 20 notes: ");
        n20=scan.nextInt();scan.nextLine();
        System.out.println("1. Number of 10 notes: ");
        n10=scan.nextInt();scan.nextLine();
        tot=n2000*2000+n500*500+n200*200+n100*100+n50*50+n20*20+n10*10;
        if(tot!=d){
            System.out.println("Your denominations is not matching the deposit amount. Please Enter deposit amount again!");
            deposit();
        }
        else {
            total+=d;
            bank.DepositTotal(d);
        }    
    }
    double getBalance(){
        return total;
    }
    void withdraw(){
        System.out.println("Enter the amount you want to with draw: ");
        System.out.println("Max amount that can be withdrawn = "+bank.wdlimit);
        double amt=scan.nextDouble();
        if(amt>bank.wdlimit){
            System.out.println("Sorry! you are exceeding the with drawal limit. you could only withdraw cash worth Rs."+bank.wdlimit);
            amt=bank.wdlimit;
        }
        else if(bank.Total<amt){
            System.out.println("Sorry the ATM is low in cash. The Current cash in ATM is Rs."+bank.Total);
            System.out.println("Please Try with a lower amount. Thank you.");
            if(bank.Total==0){
                System.out.println("The bank is out of cash. Sorry for inconvinience. Please visit us later");
                Menu.menu();
            }
            else withdraw();
        }
        else if(total<amt){
            System.out.println("You are currently low on balance. Your balance : Rs."+total);
            System.out.println("Only Rs."+total+" can be withdrawn. Than you!");
            amt=total;
        }
        total=total-amt;
        bank.withdrawTotal(amt);
        System.out.println("Withdrawal of amount "+amt+" has been done.");
        System.out.println("Your balance: Rs."+total);
    }
}
public class Customer extends CustomerDetails{

    Customer(){
        setName();
        setUserName();
        setAadhaarNo();
        setPhNum();
        setpin();
        setAccNum();
        setTotal();
    }
    void reset(){
        System.out.println("Select the corresponding choices!");
        System.out.println("1. Change UserName");
        System.out.println("2. Change Pin");
        System.out.println("3. Set both username and pin");
        System.out.println("4. Proceed with existing details");
        System.out.println("5. Exit Program");
        int n=scan.nextInt();scan.nextLine();
        switch(n){
            case (1):
                setUserName();
                break;
            case (2):
                setpin();
                break;
            case (3):
                setUserName();
                setpin();
                break;
            case (4):
                break;
            case (5):
                System.out.println("Program is terminating...");
                System.exit(0);
        }
        System.out.println("The respective changes are made. Thank You!");
        Menu.menu();
    }
}
