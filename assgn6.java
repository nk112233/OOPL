import java.util.InputMismatchException;
import java.util.Scanner;

public class assgn6 {
    public static void main(String[] args) {
        //initializing 3 integer variable
        int a , b, c;
        // Initializing array of size 2
        int[] arr = new int[2];
        // Boolean variable to see whether exception occurred or not
        boolean  eo;
        eo = false;

        do {
            // try block
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a : ");
                a = sc.nextInt();
                System.out.println("Enter b : ");
                b = sc.nextInt();
                //Division for Arithmetic Exception
                c = a / b;
                System.out.println("Adding a into array");
                arr[0]  = a;
                System.out.println("Success !");
                System.out.println("Adding b into array");
                arr[1] = b;
                System.out.println("Success !");
                // Adding elements more than size for Array Exception
                System.out.println("Adding c into array");
                arr[2] = c;
                System.out.println("Success !");
                eo = false;
            }
            // catch block to catch ArithmeticException
            catch (ArithmeticException e) {
                System.out.println("Division Error");
                eo = true;

            }
            // catch block to catch InputMismatchException
            catch (InputMismatchException e) {
                System.out.println("Enter valid integer input to a and b ! ");
                eo = true;

            }
            // catch block to catch ArrayIndexOutOfBoundsException
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array Index Out of Bound");
                eo = false;
            }
        }while (eo);

    }
}
