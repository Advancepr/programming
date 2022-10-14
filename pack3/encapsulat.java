
package pack3;



//Encapsulation is one of the fundamental of OOP(object-orinented programming).it refers to the bundling of data with the methods that operate
//that data.Encapsulation is used to hide the value or state of a structured data object inside a class.perventing unauthorized parties direct
//access to them.

// Encapsulation or Data hiding

class Banking{    // if I want to encapsulat this data I should used privae insted of public 
//public String name="sayedali";
//public int accno =4536;
private String name="sayedali";
private int accno =4536;

void setName(String name){

this.name=name;
}

void setaccno(int accno){
this.accno=accno;
}
String getname(){
return name;
}
int getaccno(){
return accno;
}

}




public class encapsulat {
    public static void main(String [] args){
    
    
        Banking obj=new Banking();
//        System.out.println(obj.name);
//        System.out.println(obj.accno);

          String name=obj.getname();
          int accno=obj.getaccno();
          
          
          
          System.out.println(name);
          System.out.println(accno);
        
    }
    
}
