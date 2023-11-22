import java.io.*;
import java.io.IOException;
import java.util.Scanner;

class Student implements Serializable{
    private String std_id;
    private int std_rollno;
    private String std_classname;
    private int std_marks;
    private String std_address;
        public void addrecord()throws IOException{
            Scanner sc = new Scanner(System.in);
            Student temp = new Student();
            System.out.println("Enter Student ID : ");
            temp.std_id = sc.nextLine();
            System.out.println("Enter the Class :");
            temp.std_classname = sc.nextLine();
            System.out.println("Enter Marks : ");
            temp.std_marks = sc.nextInt();
            System.out.println("Enter Roll Number : ");
            temp.std_rollno = sc.nextInt();
            System.out.println("Enter Address : ");
            temp.std_address = sc.nextLine();
            ObjectOutputStream fw = new ObjectOutputStream(new FileOutputStream("std.txt",true));
            fw.writeObject(temp);
        }
        public void displayrecords() throws IOException, ClassNotFoundException{
            ObjectInputStream fr = new ObjectInputStream(new FileInputStream("std.txt"));
            Student rc = new Student();
             rc = (Student)fr.readObject();
            System.out.println("Student ID : "+rc.std_id);
            System.out.println("Student Class : "+rc.std_classname);
            System.out.println("Student Marks : "+rc.std_marks);
            System.out.println("Student Roll No. : "+rc.std_rollno);
            System.out.println("Student Address : "+rc.std_address);
        }


}
public class Main {
    public static void main(String[] args)  throws IOException,ClassNotFoundException {
        Student student =new Student();
        student.addrecord();
        student.addrecord();
        student.displayrecords();
    }


}
