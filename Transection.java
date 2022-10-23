package pak1;
import java.util.Date;
public class Transaction {
	/*
	 * the amount of this account
	 */
	private double amount;
	/*
	 * the time and date of the transaction
	 */
	private Date timestomp;
	/*
	 * a memo for this account  //landess
	 */
	private String memo;
	/*
	 * the account in which the transaction was performed
	 */
	private Account inAccount;
	/*
	 * create a new transaction
	 * amout the transacted
	 * inAccount the transaction belongs to
	 */
	public Transaction(double amount, Account inAccount)
	{
		this.amount=amount;
		this.inAccount=inAccount;
		this.timestomp = new Date();
		this.memo = "";
	}

 /*
	 * create a trasaction
	 * the amount transected
	 * the account the transection belongs to
	 */
	public Transaction(double amount, String memo,Account inAccount)
	{
		// call the two-arg constructor first
		this(amount,inAccount);
		
		// set the memo
		
		this.memo=memo;
		
	}
   	/*
	 * get the amount of the transaction
	 * the account
	 */
	public double getAccount()
	{
		return this.amount;
	}

	/*
	 * get a string summarizing the transaction 
	 * the summary string
	 */
   public String getSummaryLine()
   {
	   if(this.amount >= 0)
	   {
		   return String.format("%s : $%.02f  : %s" ,this.timestomp.toString(),this.amount, this.memo);
	   }
	   else
	   {
		   return String.format("%s : $(%.02f)  : %s" ,this.timestomp.toString(),-this.amount, this.memo);

	   }

}