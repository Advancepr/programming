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

 public static void printUserMenu(User theUser, Scanner sc)
  {
	  // print the summary of account
	  theUser.printAccountsSummary();
	  
	  // init
	  int choice;
	  // user menu
	  do{
		  System.out.printf("welcome  %s, what would you like to do ? \n" , 
				  theUser.getFirstName());
		  System.out.println("   1) show account transaction histroy");
		  System.out.println("   2)  withdraw ");
		  System.out.println("   3) deposit");
		  System.out.println("   4) Transfer");
		  System.out.println("   5) Quit");
		  System.out.println();
		  System.out.printf("Enter choice :  ");
          choice = sc.nextInt();
          
          if(choice < 1 || choice >5)
          {
        	 System.out.println(" invalid choice. please choose 1-5");
          }
	  }
	  while(choice <1 || choice >5);
	  
	  switch(choice)
	  {
	  case 1:
		  ATM.ShowTransHistory(theUser , sc);
		  break;
	  case 2:
		  ATM.withdrawFounds(theUser , sc);
		  break;
	  case 3:
		  ATM.depositFounds(theUser , sc);
		  break;
	  case 4:
		  ATM.tronsferFounds(theUser , sc);
		  break;
	  case 5:
		  // gobble up rest of previous input
		  sc.nextLine();
		  break;
	  }
	  

}
}
