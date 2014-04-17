package GeneralLedger;

public final class BondsPayable extends Liability
{
	// name
	static final String NAME = "Bonds Payable";
	
	public BondsPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public BondsPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public BondsPayable(BondsPayable acc) // copy constructor
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
		return String.format("Bonds Payable %s", super.toString());
	} // toString method end
}
