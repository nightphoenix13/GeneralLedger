package GeneralLedger;

public final class DividendsPayable extends Liability
{
	// name
	static final String NAME = "Dividends Payable";
		
	public DividendsPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public DividendsPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public DividendsPayable(DividendsPayable acc) // copy constructor
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
		return String.format("Dividends Payable %s", super.toString());
	} // toString method end
}
