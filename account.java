import java.util.ArrayList;
public class Account {

	/*
	 * the name of account
	 */
	private String Name;
	/*
	 * the account id number
	 */
	private String uuid;
	/*
	 * the user object that owns this account
	 */
	private User holder;
	/*
	 * the list of transaction for this account
	 */
	private ArrayList<Transaction> transactions;
	/*
	 * name the name of the account
	 * holder the user object that holders this account
	 * theBank the bank that issues the account
	 */
	
	public Account(String Name,User holder,Bank theBank)
	{
		//set the account name and holder
		this.Name=Name;
		this.holder=holder;
		
		//get new account UUID
		
		this.uuid=theBank.getNewAccountUUID();
		
		// init transactions
		this.transactions = new ArrayList<Transaction>();
		

	}

    /*
	 * get the account id
	 * return the uuid
	 */
	public String getUUID()
	{
		return this.uuid;
	}
	
	/*
	 * get summary line for the account the string summary
	 */
	public String getSummaryLine()
	{
		// get the account's balance 
		double balance = this.getBalance();
		
		// format the summary line , depending on the whether the balance is negative
		
		if(balance  >= 0)
		{
			return String.format("%s : $%.02f :%s " , this.uuid, balance,this.Name);
		}
		else
		{
			return String.format("%s : $(%.02f) :%s " , this.uuid, balance,this.Name);

		}
		
	}
}