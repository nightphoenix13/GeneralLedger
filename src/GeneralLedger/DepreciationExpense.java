package GeneralLedger;

public final class DepreciationExpense extends Expense
{
	// name
	static final String NAME = "Depreciation Expense";
		
	public DepreciationExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public DepreciationExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public DepreciationExpense(DepreciationExpense acc) // copy constructor
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
		return String.format("Depreciation Expense %s", super.toString());
	} // toString method end
}
