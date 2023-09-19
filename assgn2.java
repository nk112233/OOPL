import java.util.Scanner;

class Publication {
// Title of the publication.
private String title;
// Price of the publication.
protected double price;
// copies of the publication.
private int copies;
public String getTitle() {
    return this.title;
        }
public void setTitle(String title) {
    this.title = title;
        }
public void setPrice(double price) {
        if (price > 0) {
        this.price = price;
        } else {
        System.out.println("Invalid price");
        }
        }
public double getPrice()
{
        return this.price;
        }
        public int getcopies() {

    return this.copies;
        }
public void setcopies(int copies) {

    this.copies = copies;
        }
public void sellcopy(int qty) {
    if(copies<qty){
        System.out.println("Enter Valid number of copies to sell");
    }
    else {
    System.out.println("Total Publication sell: $" + (qty * price));
        }
}
        }
 class Book extends Publication {
    // Author of the book.
    private String author;
    public String getAuthor()
    {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void ordercopies(int pcopies){

        setcopies(getcopies() + pcopies);
    }
    public void sellcopy(int qty) {
        if(getcopies()<qty){
            System.out.println("Enter Valid number of copies to sell");
        }
        else {
        System.out.println("Total Book sell: $" + (qty * price));
    }
    }
}
class Magazine extends Publication {
    private int orderQty;
    private String currIssue;
    public String getcurrIssue() {

        return this.currIssue;
    }
    public void setcurrIssue(String issue) {

        this.currIssue = issue;
    }
    public int getorderQty() {

        return this.orderQty;
    }
    public void setorderQty(int copies) {
        this.orderQty = copies;
        this.setcopies(copies);
    }
    public void sellcopy(int qty) {
        if(this.getcopies()<qty){
            System.out.println("Enter Valid number of copies to sell");
        }
        else {
        System.out.println("Total Magazine sell: $" + (qty * price));
    }
    }
    public void recvNewIssue(String pNewIssue){
        setcopies(orderQty);
        currIssue=pNewIssue;
    }
}
   public class assgn2 {
       public static void main(String[] args) {
           Scanner inp = new Scanner(System.in);
//accept all details of book to be order such as title, author, price & copies;
           System.out.println("1.Add Book\n2.Add Magazine");
           int ch = inp.nextInt();
           int ttlqty = 0;
           switch(ch){
               case 1:
                   Book obj1 = new Book();
                   System.out.println("Enter Title : ");
                   String ttl = inp.next();
                   obj1.setTitle(ttl);
                   System.out.println("Enter Author : ");
                   String aut = inp.next();
                   obj1.setAuthor(aut);
                   System.out.println("Enter Price : ");
                   double pr = inp.nextInt();
                   obj1.setPrice(pr);
                   System.out.println("Enter Copies : ");
                   int cp = inp.nextInt();
                   obj1.ordercopies(cp);
                   System.out.println("How many quantity do you want to sell ?");
                   int qt = inp.nextInt();
                   Publication obj2 = new Book();
                   obj2.setcopies(cp);
                   obj2.setPrice(pr);
                   obj2.sellcopy(qt); //Overriden method is invoke
                   Publication obj3 = new Publication();
                   obj3.setTitle(ttl);
                   obj3.setcopies(cp);
                   obj3.setPrice(pr);
                   obj3.sellcopy(qt);

                   break;
               case 2:
                   Magazine objm = new Magazine();
                   System.out.println("Enter Title : ");
                   String ttl2 = inp.next();
                   objm.setTitle(ttl2);
                   System.out.println("Enter Price : ");
                   double pr2 = inp.nextInt();
                   objm.setPrice(pr2);
                   System.out.println("Enter New Issue of Magazine : ");
                   String iss = inp.next();
                   objm.recvNewIssue(iss);
                   System.out.println("Enter The Order Quantity of the new Issued Magazine");
                   int qty = inp.nextInt();
                   objm.setorderQty(qty);
                   System.out.println("How many quantity do you want to sell ?");
                   int qt2 = inp.nextInt();
                   Publication objm2 = new Magazine();
                   objm2.setcopies(qty);
                   objm2.setPrice(pr2);
                   objm2.sellcopy(qt2); //Overriden method is invoke
                   Publication objm3 = new Publication();
                   objm3.setTitle(ttl2);
                   objm3.setcopies(qty);
                   objm3.setPrice(pr2);
                   objm3.sellcopy(qt2);
                   break;
               default:
                   System.out.println("Enter Valid choice");

           }


       }
   }