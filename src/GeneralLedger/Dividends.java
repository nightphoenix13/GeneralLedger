package GeneralLedger;

public final class Dividends extends StockholdersEquity
{
	// name
	static final String NAME = "Dividends";
		
	// flag
	final static boolean DEBIT_INCREASING = true;
	
	public Dividends(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Dividends() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Dividends(Dividends acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	// getStatus method returns true since Dividends increase when debited
	public boolean getStatus() // getStatus method start
	{
		return DEBIT_INCREASING;
	} // getStatus method end

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Dividends %s", super.toString());
	} // toString method end
	
	@Override // overrides Account.debit method
	public void debit(double amount)
	{
		setBalance(getBalance() + amount);
	} // debit method end
	
	@Override // overrides Account.credit method
	public void credit(double amount)
	{
		setBalance(getBalance() - amount);
	} // credit method end
}
