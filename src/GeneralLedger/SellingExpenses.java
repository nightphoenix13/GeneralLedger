package GeneralLedger;

public final class SellingExpenses extends Expense
{
	// name
	static final String NAME = "Selling Expenses";
	
	public SellingExpenses(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public SellingExpenses() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public SellingExpenses(SellingExpenses acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Selling Expenses %s", super.toString());
	} // toString method end
}
