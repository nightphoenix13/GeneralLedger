package GeneralLedger;

public final class InterestRevenue extends Revenue
{
	// name
	static final String NAME = "Interest Revenue";
	
	public InterestRevenue(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public InterestRevenue() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public InterestRevenue(InterestRevenue acc) // copy constructor
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
		return String.format("Interest Revenue %s", super.toString());
	} // toString method end
}
