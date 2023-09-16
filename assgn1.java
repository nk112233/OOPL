import java.util.Scanner;
class Complex{
    private float real,imaginary;

    public Complex(){

    }


    public Complex(float real,float imaginary){
        this.real=real;
        this.imaginary=imaginary;
    }



    Complex add(Complex C1,Complex C2){
        Complex C3=new Complex();
        C3.real=C1.real+C2.real;
        C3.imaginary= C2.imaginary+C1.imaginary;
        return C3;
    }

    Complex sub(Complex C1,Complex C2){
        Complex C3=new Complex();
        C3.real=C1.real-C2.real;
        C3.imaginary=C1.imaginary- C2.imaginary;
        return C3;


    }

    Complex multiply(Complex C1,Complex C2){
        Complex C3=new Complex();
        C3.real=C1.real*C2.real-C1.imaginary*C2.imaginary;
        C3.imaginary=C1.imaginary*C2.real+C1.real* C2.imaginary;
        return C3;
    }

    Complex divide(Complex C1,Complex C2){
        Complex C3=new Complex();
        C3.real=(C1.real*C2.real + C1.imaginary*C2.imaginary)/(C2.real*C2.real+C2.imaginary*C2.imaginary);
        C3.imaginary=(C1.imaginary*C2.real-C1.real*C2.imaginary)/(C2.real*C2.real+C2.imaginary*C2.imaginary);
        return C3;
    }




    public void printComplexNumber(){
        if(imaginary>0) {
            System.out.println(real + "+" + imaginary+"i");
        }
        else{
            System.out.println(real+""+imaginary+"i");
        }
    }

}
public class assgn1 {
    public static int menu(){
        int choice;
        System.out.println("Enter 1 for addition \n" + "Enter 2 for subtraction\n" + "Enter 3 for multiplication");
        System.out.println("Enter 4 for division");
        Scanner sc=new Scanner(System.in);
        choice = sc.nextInt();
        return choice;

    }
    public static void main(String[] args) {
        int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter real part of 1st complex number:");
        int real1=sc.nextInt();
        System.out.println("Enter the imaginary part of 1st complex number:");
        int imaginary1=sc.nextInt();
        System.out.println("Enter real part of 2nd complex number:");
        int real2=sc.nextInt();
        System.out.println("Enter the imaginary part of 2nd complex number:");
        int imaginary2=sc.nextInt();
        Complex C1=new Complex(real1,imaginary1);
        System.out.println("First complex number is:");
        C1.printComplexNumber();
        Complex C2=new Complex(real2,imaginary2);
        System.out.println("Second complex number is:");
        C2.printComplexNumber();
        do {
            choice = menu();
        }while(choice<1 || choice>4);
        Complex C3 = new Complex();
        switch (choice) {
            case 1:
                C3 = C3.add(C1, C2);
                System.out.println("Addition of complex numbers is:");
                C3.printComplexNumber();
                break;
            case 2:

                C3 = C3.sub(C1, C2);
                System.out.println("Subtraction of complex numbers is:");
                C3.printComplexNumber();
                break;
            case 3:

                C3 = C3.multiply(C1, C2);
                System.out.println("Multiplication of two complex numbers is:");
                C3.printComplexNumber();
                break;
            case 4:
                C3 = C3.divide(C1, C2);
                System.out.println("Division of two complex numbers is:");
                C3.printComplexNumber();
                break;
        }

    }
}