
package pack2;


public class payment {
    boolean paid=false;
    void printDetials(boolean p,Detials obj){
    paid=p;
      System.out.println("Student name ="+obj.sname);
      System.out.println("Student fees ="+obj.fees);
      System.out.println("payment of  ="+obj.month);
      if(paid==true){
           System.out.println("fees paid ");
      }
      else{
            System.out.println("fees Not paid");

      }
    }
    
}
