package pak1;
import java.util.ArrayList;
import java.util.Random;
public class Bank {

	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	
	/*
	 * Create a new Bank object with empty list of users and accounts
	 * name of the bank
	 */
	public Bank(String name)
	{
		this.name=name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
	}

 /*
	 * Generate a new universally unique ID for a user
	 */
	public String getNewUserUUID()
	{
		// inits
		String uuid;
		
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;
		// continue looping until we get a unique ID
      do{
    	  // generate the number
    	  uuid = "";
    	  for(int c=0; c<len; c++)
    	  {
    		  uuid += ((Integer)rng.nextInt(10)).toString();
    	  }
    	  
    	  // check to make sure it's unique
    	  nonUnique = false;
    	  for(User u : this.users)
    	  {
    		  if(uuid.compareTo(u.getUUID()) == 0)
    		  {
    			  nonUnique = true;
    			  break;
    		  }
    	  }
    	  
      }  while(nonUnique);
      
      
		return uuid;
	}
/*
	 * generate a new universally unique id for an account
	 * return the uuid
	 */
	public String getNewAccountUUID()
	{
		// inits
				String uuid;
				
				Random rng = new Random();
				int len = 10;
				boolean nonUnique;
				// continue looping until we get a unique ID
		      do{
		    	  // generate the number
		    	  uuid = "";
		    	  for(int c=0; c<len; c++)
		    	  {
		    		  uuid += ((Integer)rng.nextInt(10)).toString();
		    	  }
		    	  
		    	  // check to make sure it's unique
		    	  nonUnique = false;
		    	  for(Account a : this.accounts)
		    	  {
		    		  if(uuid.compareTo(a.getUUID()) == 0)
		    		  {
		    			  nonUnique = true;
		    			  break;
		    		  }
		    	  }
		    	  
		      }  while(nonUnique);
		      
		      
				return uuid;
	}

/*
	 * create a new user of the bank
	 * firstName the user's 
	 * lastName the user's
	 * pin the user's 
	 * the new user object
	 */
	
	public User addUser(String FirstName,String LastName,String pin)
	{
		// create a new user object and add it to out list
		User newUser = new User(FirstName,LastName,pin,this);
		this.users.add(newUser);
		
		//create a savings account for the user and add to user and bank accounts lists
		Account newAccount = new Account("Savings",newUser,this);
		//add to holder and bank lists
		
		newUser.addAccount(newAccount);
	    this.accounts.add(newAccount);
	    
	    return newUser;
	}
}