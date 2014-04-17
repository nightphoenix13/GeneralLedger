package GeneralLedger;

public final class BadDebtsExpense extends Expense
{
	// name
	static final String NAME = "Bad Debts Expense";
		
	public BadDebtsExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public BadDebtsExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public BadDebtsExpense(BadDebtsExpense acc) // copy constructor
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
		return String.format("Bad Debts Expense %s", super.toString());
	} // toString method end
}
