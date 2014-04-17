package GeneralLedger;

public final class InterestPayable extends Liability
{
	// name
	static final String NAME = "Interest Payable";
	
	public InterestPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public InterestPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public InterestPayable(InterestPayable acc) // copy constructor
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
		return String.format("Interest Payable %s", super.toString());
	} // toString method end
}
