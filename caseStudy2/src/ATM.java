import java.util.*;
public class ATM {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        System.out.println("Welcome to **2020 ATM**  BranchID: CS20B030");
        System.out.println("Choose the number corresponding to the desired option");
        System.out.println("1. Configure Bank specifications");
        System.out.println("2. Proceed with default settings");
        System.out.println("3. Exit Program");
        int i=scan.nextInt();
        if(i==1)
        scan.close();
    }
}
