package myPackage;
import java.util.*;
abstract class CustomerDetails {

    static Scanner scan=new Scanner(System.in);
    static String customerName="null", UserName="null",AadhaarNo="null",PhNum="null",pin="null", accNum="null";
    
    static void setName(){
        System.out.println("Enter your full Name: ");
        customerName=scan.nextLine();
        System.out.println("Your name is set.");
    }
    static void setUserName(){
        System.out.println("Enter your User Name: ");
        UserName=scan.nextLine();
        System.out.println("Your Username is set.");
    }
    static void setAadhaarNo(){
        System.out.println("Enter your Aadhaar Number: ");
        AadhaarNo=scan.nextLine();
        System.out.println("Your Aadhaar Number is set.");
    }
    static void setPhNum(){
        System.out.println("Enter your phone number: ");
        PhNum=scan.nextLine();
        System.out.println("Your Phone Number is set.");
    }
    static void setpin(){
        System.out.println("Enter your Pin: ");
        pin=scan.nextLine();
        System.out.println("Re-Enter Pin for verification");
        System.out.println("Your Pin is set.");
    }
    static void setAccNum(){
        System.out.println("Enter your account number: ");
        accNum=scan.nextLine();
        System.out.println("Your account number is set.");
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
        
    }

}
