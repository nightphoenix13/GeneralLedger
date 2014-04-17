package GeneralLedger;

public final class PrepaidInsurance extends Asset
{
	// name
	static final String NAME = "Prepaid Insurance";
	
	public PrepaidInsurance(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public PrepaidInsurance() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public PrepaidInsurance(PrepaidInsurance acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Prepaid Insurance %s", super.toString());
	} // toString method end
}
