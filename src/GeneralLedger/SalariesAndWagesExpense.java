package GeneralLedger;

public final class SalariesAndWagesExpense extends Expense
{
	// name
	static final String NAME = "Salaries and Wages Expense";
	
	public SalariesAndWagesExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public SalariesAndWagesExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public SalariesAndWagesExpense(SalariesAndWagesExpense acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Salaries and Wages Expense %s", super.toString());
	} // toString method end
}
