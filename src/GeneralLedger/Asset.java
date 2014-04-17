package GeneralLedger;

public abstract class Asset extends Account 
{
	// flag
	final static boolean DEBIT_INCREASING = true;
	
	public Asset(double bal) // one-argument constructor
	{
		super(bal);
	} // constructor end
	
	public Asset() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Asset(Asset acc) // copy constructor
	{
		this(acc.getBalance());
	} // constructor end
	
	// getStatus method returns true since Assets increase when debited
	public boolean getStatus() // getStatus method start
	{
		return DEBIT_INCREASING;
	} // getStatus method end
	
	@Override // overrides Account.debit method
	public void debit(double amount)
	{
		setBalance(getBalance() + amount); // debiting an Asset increases balance
	}
	
	@Override // overrides Account.credit method
	public void credit(double amount)
	{
		setBalance(getBalance() - amount); // crediting an Asset decreases balance
	}
}
