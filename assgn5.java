import java.util.Scanner;
//creation of interface for vehicle
interface Vehicle{
    int startspeed  = 0;
    int initialgear = 0;
    // declaring abstract methods for Vehicle Interface
    void speedup();
    void gearchange();
    void applybreaks();
}
//creation of Bicycle class inheriting Vehicle
class Bicycle implements Vehicle{
    // initializing speed and gear
    int speed = startspeed;
    int gear = 0;
    // constructor to show the current Vehicle 
    public Bicycle(){
        System.out.println("Bicycle State : ");

    }
    // implementation of all the methods declared in Vehicle
    public void gearchange(){
        gear = gear + 1;
        System.out.println("Gear: "+gear);


    }
    public void speedup(){
        speed  = speed + 2;
        System.out.println("Speed: "+speed);
    }


    public void applybreaks() {
        System.out.println("Bicycle Brakes applied");
        speed = 0;
        gear = 0;
        System.out.println("Gear: "+gear);
        System.out.println("Speed: "+speed);
    }
}
//creation of Bike class inheriting Vehicle
class Bike implements Vehicle{
    // initializing speed and gear
    int speed = startspeed;
    int gear = 0;
    // constructor to show the current Vehicle 
    public Bike(){
        System.out.println("Bike State : ");

    }
    // implementation of all the methods declared in Vehicle
    public void gearchange(){
        gear = gear + 1;
        System.out.println("Gear: "+gear);


    }
    public void speedup(){
        speed  = speed + 10;
        System.out.println("Speed: "+speed);
    }


    public void applybreaks() {
        System.out.println("Bike Brakes applied");
        speed = 0;
        gear = 0;
        System.out.println("Gear: "+gear);
        System.out.println("Speed: "+speed);
    }
}
//creation of Car class inheriting Vehicle
class Car implements Vehicle{
    // initializing speed and gear 
    int speed = startspeed;
    int gear = 0;
    // constructor to show the current Vehicle 
    public Car(){
        System.out.println("Car State : ");

    }
    // implementation of all the methods declared in Vehicle
    public void gearchange(){
        gear = gear + 1;
        System.out.println("Gear: "+gear);


    }
    public void speedup(){
        speed  = speed + 20;
        System.out.println("Speed: "+speed);
    }


    public void applybreaks() {
        System.out.println("Car Brakes applied");
        speed = 0;
        gear = 0;
        System.out.println("Gear: "+gear);
        System.out.println("Speed: "+speed);

    }
}
public class assgn5 {
    public static void main(String[] args) {
        int choice,cn;
        System.out.println("1.Bicycle\n2.Bike\n3.Car");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                Bicycle bi = new Bicycle();
                System.out.println("1.Speed up\n2.Gear Change\n3.Apply Brakes");
                do {

                choice = sc.nextInt();

                switch (choice){
                    case 1:
                        bi.speedup();
                        break;
                    case 2:
                        bi.gearchange();
                        break;
                    case 3:
                        bi.applybreaks();
                        break;
                }
                    System.out.println("Do you want to continue ?(press 1 or 0)");
                    cn = sc.nextInt();
                }while (cn != 0);
                break;
            case 2:
                Bike b = new Bike();
                do {
                System.out.println("1.Speed up\n2.Gear Change\n3.Apply Brakes");
                choice = sc.nextInt();
                switch (choice){
                    case 1:
                        b.speedup();
                        break;
                    case 2:
                        b.gearchange();
                        break;
                    case 3:
                        b.applybreaks();
                        break;
                }
                    System.out.println("Do you want to continue ?(press 1 or 0)");
                    cn = sc.nextInt();
                }while (cn != 0);
                break;
            case 3:
                Car c = new Car();
                do {
                    System.out.println("1.Speed up\n2.Gear Change\n3.Apply Brakes");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            c.speedup();
                            break;
                        case 2:
                            c.gearchange();
                            break;
                        case 3:
                            c.applybreaks();
                            break;
                        default:
                            System.out.println("Enter Valid Choice!");
                    }
                    System.out.println("Do you want to continue ?(press 1 or 0)");
                    cn = sc.nextInt();
                }while (cn != 0);
                break;
            default:
                System.out.println("Enter Valid Choice!");
        }


    }
}
