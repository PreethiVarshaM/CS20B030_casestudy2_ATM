package myPackage;
import java.text.ParseException;
import java.util.*;

// abstraction is used to hide important implementation details menu
abstract class MenuStruct extends ATM{
    static Scanner scan=new Scanner(System.in);
    static String d1=Timer.Date_Time(),d2=d1;
    static long diff=0;
    //method to verify pin
    static boolean verifyPin(Customer c){
        boolean b=false;
        String pin =scan.nextLine().trim();
        if(pin.equals(c.getpin()))b=true;
        else {
            System.out.println("Your pin is incorrect. Please retry again!!!");
            pin=scan.nextLine().trim();
            if(pin.equals(c.getpin()))b=true;
        }
        return b;
    }
    //method to generate otp
    static int OTPgenrator(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return number;
    }
    //method to verify otp
    static boolean verifyOTP(){
        boolean b=false;
        int num=OTPgenrator();
        System.out.println("Your OTP for verification is "+num);
        System.out.println("Enter the OTP recieved on the screen: ");
        int otp=scan.nextInt();scan.nextLine();
        if(num==otp){
            System.out.println("OTP verification successfull...");
            b=true;
        }
        else {
            System.out.println("OTP verification unsuccessfull...");
            b=false;
            System.out.println("Your phone Number might be wrongly linked. Please visit our nearest branch to change your phonenumber. Thankyou!!");
            Menu.menu();
        }
        return b;
    }
    // method to add money in the ATM daily
    // here 2 minute == 1 day in real time
    static void addingMoney(){
        d1=d2;
        d2=Timer.Date_Time();
        try {
            diff+=Timer.tottime(d1, d2);
        } catch (ParseException e) {
            e.printStackTrace();
            diff=0;
        }
        //money is added only if the ATM has less capacity than its maximum limit
        if(bank.Total<(bank.capacity-bank.dailyamount))bank.DepositTotal(bank.dailyamount*(diff/60));
        diff=diff%60;
    }
}

public class Menu extends MenuStruct {
    static Scanner scan=new Scanner(System.in);
    //array list to store user list
    static ArrayList<Customer> customer = new ArrayList<>();

    static void menu(){
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to **2020 ATM**  BranchID: CS20B030");
        addingMoney();
        display();
    }
    // polymorphism is used in case of display() and display(Customer c)
    static void display(){ // display to choose existing customer or new customer
        System.out.println("Choose the corresponding options.");
        System.out.println("1. New Customer - Create Account ");
        System.out.println("2. Existing Customer");
        System.out.println("3. Exit program");
        int n=scan.nextInt();scan.nextLine();
        switch(n){
            case (1):
                Customer c=new Customer();
                customer.add(c);
                display(c);
            case(2):
                System.out.println("Enter your Username: ");
                String user=scan.nextLine().trim();
                int i;
                for (i = 0; i <customer.size(); i++) {
                if (user.equals(customer.get(i).getUserName())) {
                    display(customer.get(i));
                    break;
                }
                }
                if (i == customer.size()) {
                    System.out.println("User does not exist. Creating a new account:");
                    Customer cust = new Customer();
                    customer.add(cust);
                    display(cust);
                }  
            case(3):
                System.out.println("Terminating program...");
                System.exit(0);
        }
    }
    static void display(Customer c){ // for existing customer
        System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        System.out.println("Choose the corresponding options.");
        System.out.println("1. View Balance ");
        System.out.println("2. Deposit amount ");
        System.out.println("3. WithDraw ");
        System.out.println("4. Update or change Info - reset pin/ change username");
        int n=scan.nextInt();scan.nextLine();
        System.out.println("Enter your pin for authentication");
        if(verifyPin(c)&&verifyOTP()){
            if(n==1){
                System.out.println("Your Balance for account Number "+c.getaccNum()+" is Rs." + c.getBalance());
            }
            else if(n==2){
                c.deposit();
            }
            else if(n==3){
                c.withdraw();
            }
            else if(n==4){
                c.reset();
            }
            else if(n==5){
                System.out.println("Terminating program...");
                System.exit(0); 
            }
            else {
                System.out.println("Wrong choice! Displaying menu again.....");
                menu();
            }
            System.out.println("Your request has been processed. Thankyou for availaing our services.");
            System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
            System.out.println("1. Continue and Display Transaction options. 2. End Transaction of your account");
            int option=scan.nextInt();scan.nextLine();
            if(option==1){
                display(c);
            }
            else menu();
        }
        else {
            System.out.println("Your pin is incorrect.");
                System.out.println("Choose the task to be performed. ");
                System.out.println("1. Reset Pin");
                System.out.println("2. Return to main menu");
                System.out.println("3. Exit program");
                int no=scan.nextInt();scan.nextLine();
                if(no==1){
                    c.setpin();
                }
                else if(no==3){
                    System.out.println("Terminating program...");
                    System.exit(0);
                }
                else {
                    display();
                }
        }
    }
    
}
