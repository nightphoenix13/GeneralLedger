package GeneralLedger;

public final class PrepaidRent extends Asset
{
	// name
	static final String NAME = "Prepaid Rent";
	
	public PrepaidRent(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public PrepaidRent() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public PrepaidRent(PrepaidRent acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Prepaid Rent %s", super.toString());
	} // toString method end
}
