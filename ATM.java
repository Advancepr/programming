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

}
}
