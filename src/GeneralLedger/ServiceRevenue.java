package GeneralLedger;

public final class ServiceRevenue extends Revenue
{
	// name
	static final String NAME = "Service Revenue";
	
	public ServiceRevenue(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public ServiceRevenue() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public ServiceRevenue(ServiceRevenue acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Service Revenue %s", super.toString());
	} // toString method end
}
