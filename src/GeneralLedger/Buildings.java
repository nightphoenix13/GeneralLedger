package GeneralLedger;

public final class Buildings extends Asset
{
	// name
	static final String NAME = "Buildings";
	
	public Buildings(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Buildings() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Buildings(Buildings acc) // copy constructor
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
		return String.format("Buildings %s", super.toString());
	} // toString method end
}
