package GeneralLedger;

public final class Inventory extends Asset
{
	// name
	static final String NAME = "Inventory";
	
	public Inventory(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public Inventory() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Inventory(Inventory acc) // copy constructor
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
		return String.format("Inventory %s", super.toString());
	} // toString method end
}
