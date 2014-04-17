package GeneralLedger;

public final class Copyright extends Asset
{
	// name
	static final String NAME = "Copyright";
	
	public Copyright(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Copyright() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Copyright(Copyright acc) // copy constructor
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
		return String.format("Copyright %s", super.toString());
	} // toString method end
}
