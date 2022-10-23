package pak1;

import java.util.Scanner;
public class ATM {
public static void main(String[] args) {
		

// init Scanner
		Scanner sc = new Scanner(System.in);
		
		Bank theBank = new Bank("Bank of Azizi");
		
		// add a user , which also creates a savings account
		
		User aUser = theBank.addUser("shafiq", "Tareen", "1234");		
		// add a checking account for out user
		
      Account newAccount = new Account("Checking" , aUser , theBank);
      aUser.addAccount(newAccount);
      theBank.addAccount(newAccount);
	
      User curUser;
      while(true)
      {
    	  // stay in the login prompt until successful login
    	  curUser = ATM.mainMenuPrompt(theBank,sc);
    	  // stay in main menu until user quits
    	 ATM.printUserMenu(curUser, sc);
      }
      
	}
       * the bank
	 * sc 
	 * return
	 * 
	 */
   public static User mainMenuPrompt(Bank theBank, Scanner sc)

   
   
   
   {
	   // inits
	   String userID;
	   String pin;
	   User outhUser;
	   
	   // prompt the user for user ID/pin combo until a correct one is reached
	   do{
		   System.out.printf("\n\n welcome to %s\n\n", theBank.getName());
		   System.out.print("enter user ID:  ");
		   userID = sc.nextLine();
		   System.out.print("enter pin : ");
		   pin = sc.nextLine();
		   
		   // try to get the user object corresponding to the ID and pin combo
		   
		   outhUser = theBank.userlogin(userID, pin);
		   if(outhUser == null)
		   {
			   System.out.print("Incorrect user ID/pin combination. " + "please try Again");
		   }
	   }
	   while(outhUser == null); // continue looping until successful login
	   {
		   
	   }
	   
	   return outhUser;  //outhinthication
   }


}
}
