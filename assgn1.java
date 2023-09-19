import java.util.Scanner;
class Complex{
    //declaring real and imaginary part of number as data member of the class
    private float real,imaginary;
    public Complex(){
        this.real = 3;
        this.imaginary = 4;
    }
    public Complex(float real,float imaginary){
        //parametrized constructor to initialize real and imaginary part of complex number
        this.real=real;
        this.imaginary=imaginary;
    }
    Complex add(Complex C1,Complex C2){
        Complex C3=new Complex();
        //storing the result in complex number c3
        C3.real=C1.real+C2.real;
        C3.imaginary= C2.imaginary+C1.imaginary;
        return C3;
    }//method to add two complex numbers

    Complex sub(Complex C1,Complex C2){
        Complex C3=new Complex();
        //storing the result in complex number c3
        C3.real=C1.real-C2.real;
        C3.imaginary=C1.imaginary- C2.imaginary;
        return C3;
    }//method to subtract two complex numbers
    Complex multiply(Complex C1,Complex C2){
        Complex C3=new Complex();
        //storing the result in complex number c3
        C3.real=C1.real*C2.real-C1.imaginary*C2.imaginary;
        C3.imaginary=C1.imaginary*C2.real+C1.real* C2.imaginary;
        return C3;
    }//method to multiply two complex numbers
    Complex divide(Complex C1,Complex C2){
        Complex C3=new Complex();
        //storing the result in complex number c3
        C3.real=(C1.real*C2.real + C1.imaginary*C2.imaginary)/(C2.real*C2.real+C2.imaginary*C2.imaginary);
        C3.imaginary=(C1.imaginary*C2.real-C1.real*C2.imaginary)/(C2.real*C2.real+C2.imaginary*C2.imaginary);
        return C3;
    }//method to divide one complex number by other
    public void printComplexNumber(){
        //to display the complex number
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
        //Menu for performing different operations
        int choice;
        System.out.println("1.Addition \n" + "2.Subtraction\n" + "3.Multiplication\n"+"4.Division\n");
        Scanner sc=new Scanner(System.in);
        choice = sc.nextInt();
        return choice;
    }
    public static void main(String[] args) {
        //taking the real and imaginary part of complex number from the user
        int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the real part of 1st complex number:");
        int real1=sc.nextInt();
        System.out.println("Enter the imaginary part of 1st complex number:");
        int imaginary1=sc.nextInt();
        System.out.println("Enter the real part of 2nd complex number:");
        int real2=sc.nextInt();
        System.out.println("Enter the imaginary part of 2nd complex number:");
        int imaginary2=sc.nextInt();
        //Creating two Complex numbers c1 and c2
        Complex C1=new Complex(real1,imaginary1);
        Complex C2=new Complex(real2,imaginary2);
        System.out.println("First complex number is:");
        C1.printComplexNumber();
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
                System.out.println("Multiplication of complex numbers is:");
                C3.printComplexNumber();
                break;
            case 4:
                C3 = C3.divide(C1, C2);
                System.out.println("Division of complex numbers is:");
                C3.printComplexNumber();
                break;
        }

    }
}