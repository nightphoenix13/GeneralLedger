package GeneralLedger;

public final class Cash extends Asset
{
	// name
	static final String NAME = "Cash";
	
	public Cash(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Cash() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Cash(Cash acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Cash %s", super.toString());
	} // toString method end
}
