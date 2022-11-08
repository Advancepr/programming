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
	  // display this menu unless the user wan'ts to quit
	  
	  if(choice !=5 )
	  {
		 ATM.printUserMenu(theUser, sc);
	  }
  }
  public static void ShowTransHistory(User theUser, Scanner sc)
  {
	  int theAcct;
	  // get account whose transaction history to look at
	  do{
		  System.out.printf("Enter the number (1-%d) of the account whose transaction you wann to see :", theUser.numAccounts());
	 
		  theAcct = sc.nextInt()-1;
		  if(theAcct <0 || theAcct >= theUser.numAccounts())
		  {
			  System.out.println("invlid account. please try again");
		  }
	  }
	  while(theAcct < 0 || theAcct >= theUser.numAccounts());
	  
	  //print the transaction history
	  
	  theUser.printAcctTransHistory(theAcct);
  }
/**
 *   process transferring funds from one account to another
 * @param theUser    the logged-in user object
 * @param sc         the scanner object used for user input
 */
  public static void tronsferFounds(User theUser, Scanner sc)
  {
	  // inits
	  int fromAcct;
	  int toAcct;
	  double amount;
	  double acctBal;
	  
	  do{
		  System.out.printf("enter the number (1-%d) of the account\n" +
	   " to transfer from :",theUser.numAccounts());
		  fromAcct = sc.nextInt()-1;
		  if(fromAcct < 0 || fromAcct >= theUser.numAccounts())
		  {
			  System.out.println("Ivalid account. please try again.");
		  }
	  }
	  while(fromAcct < 0 || fromAcct >= theUser.numAccounts());
	  
	  acctBal = theUser.getAcctBalance(fromAcct);
	  
	  // get the account to transfer to
	  do{
		  System.out.printf("enter the number (1-%d) of the account\n" +
	   " to transfer to :",theUser.numAccounts());
		  toAcct = sc.nextInt()-1;
		  if(toAcct < 0 || toAcct >= theUser.numAccounts())
		  {
			  System.out.println("Ivalid account. please try again.");
		  }
	  }
	  while(toAcct < 0 || toAcct >= theUser.numAccounts());
	  
	  // get the amount to transfer
	  
	  do{
		  System.out.printf("Enter the amount to transfer (max $%.02f):",acctBal);
		  amount = sc.nextDouble();
		  if(amount<0)
		  {
			  System.out.printf("Amount must be greater than zero.");
		  }else if(amount>acctBal)
		  {
			  System.out.printf("Amount must not be greater than\n" +
		  "balance of $%.02f.\n",acctBal);
		  }
	  }
	  while(amount < 0 || amount > acctBal);
	  
	  // finally, do the transfer
	  
	  theUser.addAcctTransaction(fromAcct, -1*amount,String.format("Trasnfer to account%s", theUser.getAcctUUID(toAcct)));
	  theUser.addAcctTransaction(toAcct, amount,String.format("Trasnfer to account%s", theUser.getAcctUUID(fromAcct)));

  }
/**
 * process a fund withdraw from an account
 * @param theUser  the logged-in User Object
 * @param sc       the Scanner object user for user input
 */
  public static void withdrawFounds(User theUser , Scanner sc)
  {
	// inits
		  int fromAcct;
		  String memo;
		  double amount;
		  double acctBal;
		  
		  do{
			  System.out.printf("enter the number (1-%d) of the account\n" +
		   " to withdraw from :",theUser.numAccounts());
			  fromAcct = sc.nextInt()-1;
			  if(fromAcct < 0 || fromAcct >= theUser.numAccounts())
			  {
				  System.out.println("Ivalid account. please try again.");
			  }
		  }
		  while(fromAcct < 0 || fromAcct >= theUser.numAccounts());
		  
		  acctBal = theUser.getAcctBalance(fromAcct);
		  
		  // get the amount to transfer
		  
		  do{
			  System.out.printf("Enter the amount to withdraw (max $%.02f):",acctBal);
			  amount = sc.nextDouble();
			  if(amount<0)
			  {
				  System.out.printf("Amount must be greater than zero.");
			  }else if(amount>acctBal)
			  {
				  System.out.printf("Amount must not be greater than\n" +
			  "balance of $%.02f.\n",acctBal);
			  }
		  }
		  while(amount < 0 || amount > acctBal);
		
		  // gobble up rest of previous input
		  
		  sc.nextLine();
		  
		  // get a memo
		  
		  System.out.print("enter a memo:");
		  memo = sc.nextLine();
		  
		  // do the withdraw
		  theUser.addAcctTransaction(fromAcct, -1*amount, memo);
		  
  }

/**
 * process a fund deposit to an account
 * @param theUser   the logged-in User the object
 * @param sc        the scanner object used for user input
 */

public static void depositFounds(User theUser , Scanner sc)
{

	// inits
	  int toAcct;
	  String memo;
	  double amount;
	  double acctBal;
	  
	  do{
		  System.out.printf("enter the number (1-%d) of the account\n" +
	   " to deposit in:", theUser.numAccounts());
		  toAcct = sc.nextInt()-1;
		  if(toAcct < 0 || toAcct >= theUser.numAccounts())
		  {
			  System.out.println("Ivalid account. please try again.");
		  }
	  }
	  while(toAcct < 0 || toAcct >= theUser.numAccounts());
	  
	  acctBal = theUser.getAcctBalance(toAcct);
	  
	  // get the amount to transfer
	  
	  do{
		  System.out.printf("Enter the amount to transfer (max $%.02f):",acctBal);
		  amount = sc.nextDouble();
		  if(amount<0)
		  {
			  System.out.printf("Amount must be greater than zero.");
		  }
	  }
	  while(amount < 0);
	
	  // gobble up rest of previous input
	  
	  sc.nextLine();
	  
	  // get a memo
	  
	  System.out.print("enter a memo:");
	  memo = sc.nextLine();
	  
	  // do the withdraw
	  theUser.addAcctTransaction(toAcct, amount, memo);
}



}
}
