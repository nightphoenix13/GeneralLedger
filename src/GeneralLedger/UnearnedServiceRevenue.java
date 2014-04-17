package GeneralLedger;

public final class UnearnedServiceRevenue extends Liability
{
	// name
		static final String NAME = "Unearned Service Revenue";
	
	public UnearnedServiceRevenue(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public UnearnedServiceRevenue() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public UnearnedServiceRevenue(UnearnedServiceRevenue acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Unearned Service Revenue %s", super.toString());
	} // toString method end
}
