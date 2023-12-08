import java.util.Scanner;

class account
{
    private int balance;
    private String accountType;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
class customer extends account
{
    int todayWithdraw=0; // setting daily withdrawal limit to zero
    int dailyLimit;
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}

class bank extends customer
{
    public void daily_limit() // method to set daily limit according to account type
    {
        if(getAccountType().equals("savings"))
        {
            dailyLimit = 25000;
        }
        else
        {
            dailyLimit = 50000;
        }
    }

    Scanner sc = new Scanner(System.in);
    public void createAccount()  //method to create account
    {
        System.out.println("ENTER DETAILS: ");
        System.out.print("NAME: ");
        String name =sc.next();
        setName(name);
        System.out.print("AGE: ");
        int age =sc.nextInt();
        while(age<18) //checking if valid age entered i.e above 18
        {
            System.out.println("Minimum age should be 18 to create an account.");
            System.out.print("VALID AGE: ");
            age =sc.nextInt();
        }
        setAge(age);
        System.out.print("BALANCE: ");
        int balance =sc.nextInt();
        setBalance(balance);
        System.out.print("ACCOUNT TYPE: (savings/current) ");
        String accountType =sc.next();
        setAccountType(accountType);
        daily_limit(); //setting daily limit value
    }

    public void displayAccount()  //method to display account details
    {
        System.out.println("WELCOME " + getName() + " ,following are your account details");
        System.out.println("AGE: "+getAge());
        System.out.println("ACCOUNT TYPE: "+getAccountType());
        System.out.println("BALANCE: "+getBalance());
    }

    public void checkBalance()  //method to check balance
    {
        System.out.println("YOUR CURRENT BALANCE IS: "+ getBalance());
    }

    public void depositAmount() //method to deposit amount
    {
        System.out.print("ENTER AMOUNT TO BE DEPOSITED: ");
        int deposit = sc.nextInt();
        setBalance(getBalance() + deposit);  //updating balance after depositing amount
        System.out.println("AMOUNT DEPOSITED SUCCESSFULLY");
    }

    public void withdrawAmount()
    {
        System.out.print("ENTER AMOUNT TO BE WITHDRAWN: ");
        int withdraw = sc.nextInt();
        if(todayWithdraw>dailyLimit) //checking daily withdrawal amount
        {
            System.out.println("TODAY'S WITHDRAWAL LIMIT IS OVER");
        }
        else if(withdraw>getBalance()) //checking if sufficient balance is present
        {
            System.out.println("INSUFFICIENT BALANCE");
        }
        else // deducting amount from balance
        {
            setBalance(getBalance()-withdraw);
            todayWithdraw += withdraw;
        }
    }
}

public class assgn9 {
    public static void main(String[] args) {
        bank b = new bank();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
//            System.out.println("\nMENU");
            System.out.println("1. Create Account");
            System.out.println("2. Display Account Details");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Withdraw Amount");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> b.createAccount();
                case 2 -> b.displayAccount();
                case 3 -> b.depositAmount();
                case 4 -> b.withdrawAmount();
                case 5 -> b.checkBalance();
                case 6 -> System.out.println("Exiting the program. Goodbye!");
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
