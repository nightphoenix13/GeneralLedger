package GeneralLedger;

public final class InterestExpense extends Expense
{
	// name
	static final String NAME = "Interest Expense";
	
	public InterestExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public InterestExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public InterestExpense(InterestExpense acc) // copy constructor
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
		return String.format("Interest Expense %s", super.toString());
	} // toString method end
}
