package GeneralLedger;

public final class Goodwill extends Asset
{
	// name
	static final String NAME = "Goodwill";
		
	public Goodwill(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Goodwill() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Goodwill(Goodwill acc) // copy constructor
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
		return String.format("Goodwill %s", super.toString());
	} // toString method end
}
