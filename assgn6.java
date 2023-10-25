import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a , b, c;
        int[] arr = new int[2];
        boolean  eo;
        eo = false;

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a : ");
                a = sc.nextInt();
                System.out.println("Enter b : ");
                b = sc.nextInt();
                c = a / b;
                System.out.println("Adding a into array");
                arr[0]  = a;
                System.out.println("Success !");
                System.out.println("Adding b into array");
                arr[1] = b;
                System.out.println("Success !");
                System.out.println("Adding c into array");
                arr[2] = c;
                System.out.println("Success !");
                eo = false;
            } catch (ArithmeticException e) {
                System.out.println("Division Error");
                eo = true;

            }
            catch (InputMismatchException e) {
                System.out.println("Enter valid integer input to a and b ! ");
                eo = true;

            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array Index Out of Bound");
                eo = false;
            }
        }while (eo);

    }
}
