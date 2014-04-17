package GeneralLedger;

public final class FreightOut extends Expense
{
	// name
	static final String NAME = "Freight-out";
		
	public FreightOut(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public FreightOut() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public FreightOut(FreightOut acc) // copy constructor
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
		return String.format("Freight-out %s", super.toString());
	} // toString method end
}
