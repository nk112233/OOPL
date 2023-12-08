import java.io.*;
import java.util.Scanner;
import java.io.File;

class fileHandle {

    private int n ;

    File file = new File("file.txt");
    Scanner sc = new Scanner(System.in);

    public void create_database()
    {
        System.out.print("Enter no of students: ");
        n = sc.nextInt();

        try {
            FileWriter F = new FileWriter(file);
            for(int i=0;i<n;i++)
            {
                String name;

                int roll_no,marks;
                System.out.println("Student "+(i+1));
                System.out.print("Name: ");
                name=sc.next();
                System.out.print("Roll NO: ");
                roll_no=sc.nextInt();
                System.out.print("Marks: ");
                marks = sc.nextInt();

                F.write(name+" "+roll_no+" "+marks+"\n");


            }
            F.close();

        }
        catch (IOException e)
        {
            System.out.println("error occurred");
        }
    }

    public void display_database() throws IOException
    {
        int i=1;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine())!=null)
        {
            System.out.println(i+". "+line);
            i++;
        }
        reader.close();


    }

    public void search_database() throws IOException
    {
        String roll_no;
        System.out.print("Entered roll no to be searched: ");
        roll_no = sc.next();
        BufferedReader search = new BufferedReader(new FileReader(file));
        String line;
        while((line=search.readLine())!=null)
        {
            String[] data = line.split("\\s+");

            if(data.length>=3)
            {
                String roll = data[1];
                String name = data[0];
                String marks = data[2];

                if(roll.equals(roll_no))
                {
                    System.out.println("Student found");
                    System.out.println("Roll No: "+roll);
                    System.out.println("Name: "+name);
                    System.out.println("Marks: "+marks);

                    return;
                }
            }
        }
        System.out.println("STUDENT DATA NOT FOUND");
        search.close();


    }

    public void modify_database() throws IOException
    {
        display_database();
        System.out.print("Enter the Number of Data to be modified: ");
        int ch = sc.nextInt();
        File temp = new File("temp.txt");

        BufferedReader mod = new BufferedReader(new FileReader(file));
        FileWriter f = new FileWriter(temp);
        String line;
        int i=0;
        while((line = mod.readLine())!=null)
        {
            if(i==(ch-1))
            {
                System.out.println("Enter the new details");
                System.out.print("Name: ");
                String name=sc.next();
                System.out.print("Roll NO: ");
                int roll_no=sc.nextInt();
                System.out.print("Marks: ");
                int marks = sc.nextInt();

                f.write(name+" "+roll_no+" "+marks+"\n");

            }
            else
            {
                f.write(line+"\n");
            }
            i++;
        }
        f.close();
        mod.close();

        BufferedReader old = new BufferedReader(new FileReader(temp));
        FileWriter w = new FileWriter(file);

        while((line=old.readLine())!=null)
        {
            w.write(line+"\n");
        }
        old.close();
        w.close();
        temp.delete();

        display_database();
    }

    public void delete_database() throws IOException
    {
        display_database();
        System.out.print("Enter the Number of Data to be deleted ");
        int ch = sc.nextInt();
        File temp = new File("temp.txt");

        BufferedReader mod = new BufferedReader(new FileReader(file));
        FileWriter f = new FileWriter(temp);
        String line;
        int i=0;
        while((line = mod.readLine())!=null)
        {
            if(i!=(ch-1))
            {
                f.write(line+"\n");
            }
            i++;
        }
        f.close();
        mod.close();

        BufferedReader old = new BufferedReader(new FileReader(temp));
        FileWriter w = new FileWriter(file);

        while((line=old.readLine())!=null)
        {
            w.write(line+"\n");
        }
        old.close();
        w.close();
        temp.delete();
        n--;

        System.out.println("RECORD DELETED SUCCESSFULLY");

        display_database();
    }

    public void delete_complete_database() throws IOException
    {
        FileWriter del  = new FileWriter(file);
        del.write("");
        System.out.println("DATABASE DELETED SUCCESSFULLY");
        del.close();
    }
}

public class assgn8 {
    public static void main(String[] args) {
        fileHandle f = new fileHandle();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
//            System.out.println("\nMENU");
            System.out.println("1. Create Database");
            System.out.println("2. Display Database");
            System.out.println("3. Search Database");
            System.out.println("4. Modify Database");
            System.out.println("5. Delete Record");
            System.out.println("6. Delete Database");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            choice = scanner.nextInt();

            try
            {
                switch (choice) {
                    case 1 -> f.create_database();
                    case 2 -> f.display_database();
                    case 3 -> f.search_database();
                    case 4 -> f.modify_database();
                    case 5 -> f.delete_database();
                    case 6 -> f.delete_complete_database();
                    case 7 -> System.out.println("Exiting the program. Goodbye!");
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            }
            catch (IOException e)
            {
                System.out.println("ERROR!");
            }

        } while (choice != 7);

        scanner.close();
    }
}
