package GeneralLedger;

public final class InsuranceExpense extends Expense
{
	// name
	static final String NAME = "Insurance Expense";
	
	public InsuranceExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public InsuranceExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public InsuranceExpense(InsuranceExpense acc) // copy constructor
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
		return String.format("Insurance Expense %s", super.toString());
	} // toString method end
}
