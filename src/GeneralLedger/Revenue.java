package GeneralLedger;

public abstract class Revenue extends Account
{
	// flag
	final static boolean DEBIT_INCREASING = false;
	
	public Revenue(double bal) // one-argument constructor
	{
		super(bal);
	} // constructor end
	
	public Revenue() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Revenue(Revenue acc) // copy constructor
	{
		this(acc.getBalance());
	} // constructor end
	
	// getStatus method returns false since Revenues decrease when debited
	public boolean getStatus() // getStatus method start
	{
		return DEBIT_INCREASING;
	} // getStatus method end
	
	@Override // overrides Account.debit method
	public void debit(double amount)
	{
		setBalance(getBalance() - amount); // debiting an Asset decreases balance
	}
	
	@Override // overrides Account.credit method
	public void credit(double amount)
	{
		setBalance(getBalance() + amount); // crediting an Asset increases balance
	}
}
