
package pack2;


public class Main {
    public static void main(String [] args){
    
    Detials stu1=new Detials();
     Detials stu2=new Detials();
    
    stu1.setValues("sayedali", 9000, "febuary");
    stu2.setValues("Nazarali", 8000, "january");
    
    payment payment=new payment();
    
    payment.printDetials(true, stu1);
      System.out.println("-----------------------------------------------------");
     
    payment.printDetials(false, stu2);
    }
    
}
