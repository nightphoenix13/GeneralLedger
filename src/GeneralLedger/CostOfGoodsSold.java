package GeneralLedger;

public final class CostOfGoodsSold extends Expense
{
	// name
	static final String NAME = "Cost of Goods Sold";
		
	public CostOfGoodsSold(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public CostOfGoodsSold() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public CostOfGoodsSold(CostOfGoodsSold acc) // copy constructor
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
		return String.format("Cost of Goods Sold %s", super.toString());
	} // toString method end
}
