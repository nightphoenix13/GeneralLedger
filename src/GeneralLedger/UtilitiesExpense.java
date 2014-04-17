package GeneralLedger;

public final class UtilitiesExpense extends Expense
{
	// name
	static final String NAME = "Utilities Expense";
	
	public UtilitiesExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public UtilitiesExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public UtilitiesExpense(UtilitiesExpense acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Utilities Expense %s", super.toString());
	} // toString method end
}
