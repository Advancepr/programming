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

}