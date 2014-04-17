package GeneralLedger;

public final class Supplies extends Asset
{
	// name
	static final String NAME = "Supplies";
	
	public Supplies(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Supplies() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public Supplies(Supplies acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Supplies %s", super.toString());
	} // toString method end
}
