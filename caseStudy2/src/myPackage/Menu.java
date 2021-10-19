package myPackage;
import java.util.*;
abstract class MenuStruct {
    static ArrayList<Customer> customer = new ArrayList<>();
}
public class Menu extends MenuStruct{
    static Scanner scan=new Scanner(System.in);
    static void menu(){
        System.out.println("____________________________________________________________________________________________________________________");
        System.out.println("Welcome to **2020 ATM**  BranchID: CS20B030");
        display();
    }
    static void display(){ // display to choose existing customer or new customer
        System.out.println("Choose the corresponding options.");
        System.out.println("1. New Customer - Create Account ");
        System.out.println("2. Existing Customer");
        int n=scan.nextInt();
        switch(n){
            case (1):
                Customer c=new Customer();
                customer.add(c);
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
                
        }
    }
    static void display(Customer c){ // for existing customer
        System.out.println("Choose the corresponding options.");
        System.out.println("1. View Balance ");
        System.out.println("2. Deposit amount ");
        System.out.println("3. WithDraw ");
        System.out.println("4. Update or change Info - reset pin/ change username");
        int n=scan.nextInt();
        System.out.println("Enter your pin for authentication");
        if(verifyPin(c)){
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
            }
        }
        else {
            System.out.println("Your pin is incorrect.");
                System.out.println("Choose the task to be performed. ");
                System.out.println("1. Reset Pin");
                System.out.println("2. Return to main menu");
                System.out.println("3. Exit program");
                int no=scan.nextInt();
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
}
