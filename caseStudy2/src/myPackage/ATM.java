package myPackage; // package to convienently use different classes
import java.util.*;
public class ATM{

    public static BankConfig bank; 
    //bank object -> this makes the design universal, 
    // each bank can customize their atm settings

    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        // allows to configure the ATM settings at the start of the program
        // or can proceed with the default settings of ATM

        // display of welocme message, configure options and then menu for customers
        System.out.println("Welcome to **2020 ATM**  BranchID: CS20B030");
        System.out.println("Choose the number corresponding to the desired option");
        System.out.println("1. Configure Bank specifications");
        System.out.println("2. Proceed with default settings");
        System.out.println("3. Exit Program - ~Terminate~ ");
        int i=scan.nextInt();scan.nextLine();
        if(i==1){
            bank=new BankConfig(1);
            Menu.menu();
        }
        else if(i==2){
            bank=new BankConfig();
            Menu.menu();
        }
        else {
            System.out.println("Thanks for availing our services!!!\nThe Program is terminating...");
            System.exit(0);
        }
        scan.close();
    }
}
