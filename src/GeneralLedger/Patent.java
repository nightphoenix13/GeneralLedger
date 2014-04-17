package GeneralLedger;

public final class Patent extends Asset
{
	// name
	static final String NAME = "Patent";
	
	public Patent(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Patent() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Patent(Patent acc) // copy constructor
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
		return String.format("Patent %s", super.toString());
	} // toString method end
}
