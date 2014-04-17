package GeneralLedger;

public final class Land extends Asset
{
	// name
	static final String NAME = "Land";
	
	public Land(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Land() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Land(Land acc) // copy constructor
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
		return String.format("Land %s", super.toString());
	} // toString method end
}
