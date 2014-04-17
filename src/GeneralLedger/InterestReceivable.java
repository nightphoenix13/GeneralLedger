package GeneralLedger;

public final class InterestReceivable extends Asset
{
	// name
	static final String NAME = "Interest Receivable";
	
	public InterestReceivable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public InterestReceivable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public InterestReceivable(InterestReceivable acc) // copy constructor
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
		return String.format("Interest Receivable %s", super.toString());
	} // toString method end
}
