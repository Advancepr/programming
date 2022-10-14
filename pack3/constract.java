
package pack3;


public class constract {
    
    int s=20;
    
    
    
     //user define constractor run automaticly
    //created constractor
    constract(){
    
    System.out.println("user define 0 argument constractor ");
    }
    
    public static void main(String [] args){
    
    constract obj=new constract();    //constract(); is constractor
   System.out.println(obj.s);
    
    }
    
}
