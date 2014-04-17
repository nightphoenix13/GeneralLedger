package GeneralLedger;

public final class IncomeTaxExpense extends Expense
{
	// name
	static final String NAME = "Income Tax Expense";
		
	public IncomeTaxExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public IncomeTaxExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public IncomeTaxExpense(IncomeTaxExpense acc) // copy constructor
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
		return String.format("Income Tax Expense %s", super.toString());
	} // toString method end
}
