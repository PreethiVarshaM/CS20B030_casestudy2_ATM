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
        System.out.println("Enter your Pin: ");
        pin=scan.nextLine().trim();
        System.out.println("Re-Enter Pin for verification");
        System.out.println("Your Pin is set.");
    }
    String getpin(){
        return pin;
    }
    static void setAccNum(){
        System.out.println("Enter your account number: ");
        accNum=scan.nextLine();
        System.out.println("Your account number is set.");
    }  
    String getaccNum(){
        return accNum;
    }
    void deposit(){
        System.out.println("Enter the amount to be deposited: ");
        double d=scan.nextDouble();
        total+=d;
    }
    double getBalance(){
        return total;
    }
    void withdraw(){
        System.out.println("Enter the amount you want to with draw: ");
        System.out.println("Max amount that can be withdrawn = "+bank.wdlimit);
        double amt=scan.nextDouble();
        total=total-amt;
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
    }
    void reset(){
        System.out.println("Select the corresponding choices!");
        System.out.println("1. Change UserName");
        System.out.println("2. Change Pin");
        System.out.println("3. Set both username and pin");
        System.out.println("4. Proceed with existing details");
        System.out.println("5. Exit Program");
        int n=scan.nextInt();
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
        System.out.println("-------------------------------------------------------------------------------------------");
        Menu.menu();
    }

}
