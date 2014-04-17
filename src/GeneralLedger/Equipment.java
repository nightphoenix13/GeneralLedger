package GeneralLedger;

public final class Equipment extends Asset
{
	// name
	static final String NAME = "Equipment";
		
	public Equipment(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Equipment() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Equipment(Equipment acc) // copy constructor
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
		return String.format("Equipment %s", super.toString());
	} // toString method end
}
