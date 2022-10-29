public class User {

	/*
	 The first name of the user
	 */
	private String FirstName;
	
	/*
	 * the last name of the user
	 */
	private String LastName;
	/*
	 * the 10 number of the user
	 */
	private String uuid;
	/*
	 * the MD5 hash of the user's pin number
	 */
	private byte pinhash[];
        /*
	 * the list of accounts for this user
	 */
	private ArrayList<Account> accounts;
	/*
	 * @param firstName  the user's first name
	 * @param lastName   the user's last name
	 * @param pin        the user's account pin number
	 * @param theBank    the Bank object that the user is a customer 
	 */
	
	public User(String FirstName,String LastName,String pin,Bank thebank)
	{
		this.FirstName=FirstName;
		this.LastName=LastName;
		
		// store the pin's MD5 hash, rather than the original value,for security reasons
		try 
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinhash = md.digest(pin.getBytes());
		} 
		
		catch (NoSuchAlgorithmException e) {
			System.err.println("error , cought NoSuchAlgorithException");
			
			e.printStackTrace();
			System.exit(1);
		}
		
		// get a new, unique universal ID for the user
		this.uuid=thebank.getNewUserUUID();
		
		// create empty list of accounts
		
		this .accounts = new ArrayList<Account>();
		
		// print log message
		
		System.out.printf("New user %s,%s with ID %s created.\n",LastName,FirstName,this.uuid);
	}
     // get a new, unique universal ID for the user
		this.uuid=thebank.getNewUserUUID();
		
		// create empty list of accounts
		
		this .accounts = new ArrayList<Account>();
		
		// print log message
		
		System.out.printf("New user %s,%s with ID %s created.\n",LastName,FirstName,this.uuid);
	}
	/*
	 * add an account for the user
	 * anAcct  the account to add
	 */
	public void addAccount(Account anAcct)
	{
		this.accounts.add(anAcct);
	}
	/*
	 * return the user uuid
	 * return the uuid
	 */
	public String getUUID()
	{
		return this.uuid;
	}
/*
	 * check whether a given pin matches the true user pin apin the pin to check whether the pin is valid or not
	 */
	public boolean validatepin(String apin)
	{
		try{
		MessageDigest md =  MessageDigest.getInstance("MD5");
		return MessageDigest.isEqual(md.digest(apin.getBytes()),this.pinhash);
		}
		catch(NoSuchAlgorithmException e)
		{
			System.err.println("error, cought NoSuchAlgorithmException" );
			e.printStackTrace();
			System.exit(1);
		}
		return false;
		
	}

   public String  getFirstName()
   {
	  return this.FirstName;
   }
   
   /*
    * 
    */
   public void printAccountsSummary()
   {
	   System.out.printf("\n\n%s's accounts summary \n ",this.FirstName);
	   for(int a=0; a<this.accounts.size(); a++)
	   {
		   System.out.printf("%d) %s\n" , a+1,
				   this.accounts.get(a).getSummaryLine());
	   }
	   System.out.println();
   }
   
   public int numAccounts()
   {
	   return this.accounts.size();
   }

}

}