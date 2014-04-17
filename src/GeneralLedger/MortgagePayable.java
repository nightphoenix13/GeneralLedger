package GeneralLedger;

public final class MortgagePayable extends Liability
{
	// name
	static final String NAME = "Mortgage Payable";
	
	public MortgagePayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public MortgagePayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public MortgagePayable(MortgagePayable acc) // copy constructor
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
		return String.format("Mortgage Payable %s", super.toString());
	} // toString method end
}
