package GeneralLedger;

public final class SalesRevenue extends Revenue
{
	// name
	static final String NAME = "Sales Revenue";
	
	public SalesRevenue(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public SalesRevenue() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public SalesRevenue(SalesRevenue acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Sales Revenue %s", super.toString());
	} // toString method end
}
