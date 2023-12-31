import java.util.Scanner;

class Employee {
    String empName;
    String address;
    String des;
    int empid;
    long mobNo;
    String empmail;
    public double basicPay = 0;
    double da, hra, pf, club, net, gross;

    void designation(Scanner inp) {
        do {
            System.out.println("Please enter For designation \n 1 for Programmer \n 2 for TeamLead \n 3 for AssistantProjectManager \n 4 for ProjectManager");
            int i = inp.nextInt();
            switch (i) {
                case 1:
                    Programmer p = new Programmer();
                    basicPay = p.salary();
                    des = "Programmer";
                    break;
                case 2:
                    Teamlead T = new Teamlead();
                    basicPay = T.salary();
                    des = "Teamlead";
                    break;
                case 3:
                    AssistantProjectManager APM = new AssistantProjectManager();
                    basicPay = APM.salary();
                    des = "AssProjectManager";
                    break;
                case 4:
                    ProjectManager PM = new ProjectManager();
                    basicPay = PM.salary();
                    des = "ProjectManager";
                    break;
                default:
                    System.out.println("Wrong input please retry");
            }
        } while (basicPay == 0);
    }

    // function to get the data of the employee
    void getData(Scanner inp) {


        System.out.println("Enter the empid : ");
        empid = inp.nextInt();
        System.out.println("Enter the name : ");
        empName = inp.next();
        System.out.println("Enter the emp mobile number : ");
        mobNo = inp.nextLong();
        inp.nextLine();
        System.out.println("Enter the address : ");
        address = inp.nextLine();
        System.out.println("Enter the mailid : ");
        empmail = inp.next();

    }

    // function to display the data of the employees
    void display() {
        System.out.println("----------Personal Info----------");
        System.out.println("Name            : " + this.empName);
        System.out.println("ID              : " + this.empid);
        System.out.println("Designation     : " + this.des);
        System.out.println("Mail            : " + this.empmail);
        System.out.println("Address         : " + this.address);
        System.out.println("Mobile No       : " + this.mobNo);
        System.out.print("\n");

        System.out.println("-----------Pay Slip-----------");
        System.out.println("Basic Pay       : " + this.basicPay);
        System.out.println("DA              : " + this.da);
        System.out.println("HRA             : " + this.hra);
        System.out.println("PF              : " + this.pf);
        System.out.println("Club Fees       : "+this.club);
        System.out.println("Gross Salary    : " + this.calcgross());
        System.out.println("Net Salary      : " + this.netsalary());
        System.out.print("\n\n");
    }

    double netsalary() {
        da = 0.97 * basicPay;
        hra = 0.1 * basicPay;
        pf = 0.12 * basicPay;
        club = 0.001 * basicPay;
        net = gross-pf-club;
        return net;

    }

    double calcgross() {
        da = 0.97 * basicPay;
        hra = 0.1 * basicPay;
        pf = 0.12 * basicPay;
        club = 0.001 * basicPay;
        gross = basicPay +da+hra;
        return gross;
    }
}

class Programmer extends Employee {
    //use of constructor to give a value to basicPay,which is a variable of class Employee(parent)
    double salary() {
        return 20000;
    }
}

class Teamlead extends Employee{
    //use of constructor to give a value to basicPay,which is a variable of class Employee(parent)
    double salary(){
        return 40000;
    }

}

class AssistantProjectManager extends Employee{
    //use of constructor to give a value to basicPay,which is a variable of class Employee(parent)
    double salary(){
        return 60000;
    }
}

class ProjectManager extends Employee{
    //use of constructor to give a value to basicPay,which is a variable of class Employee(parent)
    double salary(){
        return 1000000;
    }
}

public class assgn3 {
    public static void main(String[] args) {

        Employee[] e = new Employee[20];
        int[] arr = new int[10];
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the number of employees you want to enter : ");
        int j = inp.nextInt();
        for (int i = 0; i < j; i++) {
            e[i] = new Employee();
            e[i].getData( inp);
            e[i].designation(inp);
            e[i].calcgross();
        }

        System.out.println("Details of the employees are: ");
        for (int i = 0; i < j; i++) {
            e[i].display();
        }


    }
}

