import java.util.Scanner;
//creation of abstract class to declare members and methods.
abstract class shape {
    double l,b;
    // declaration of method to calculate area
    abstract public void compute_area();
}
class rectangle extends shape {
    // declaring a private variable to store area
    private double area;
    // method to calculate area of rectangle
    public void compute_area() {
        Scanner inp  = new Scanner(System.in);
        System.out.println("Enter Length : ");
        l = inp.nextDouble();
        System.out.println("Enter Breadth : ");
        b = inp.nextDouble();
        area = l*b;
        System.out.println("Area of Rectangle of length "+ l + " and breath " +b+" is "+ area);
    }
}
class triangle extends shape {
    // declaring a private variable to store area
    private double area;
    // method to calculate area of triangle
    public void compute_area() {
        Scanner inp  = new Scanner(System.in);
        System.out.println("Enter Height : ");
        l = inp.nextDouble();
        System.out.println("Enter Breadth : ");
        b = inp.nextDouble();
        area = 0.5*l*b;
        System.out.println("Area of Triangle of height "+ l + " and breath "+b+" is "+ area);
    }
}


public class assgn4{
    public static void main(String[] args) {
        // menu to enter choice of area calculation
        int ch;
        Scanner inp = new Scanner(System.in);
        System.out.println("--------------Area of Shapes-------------------");
        System.out.println("1.Rectangle\n2.Triangle");
        ch = inp.nextInt();
        switch (ch) {
            case 1:
                rectangle r = new rectangle();
                r.compute_area();

            case 2:
                triangle t = new triangle();
                t.compute_area();
            default:
                System.out.println("Enter Valid Choice !");
        }


    }
}
