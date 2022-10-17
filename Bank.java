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
}