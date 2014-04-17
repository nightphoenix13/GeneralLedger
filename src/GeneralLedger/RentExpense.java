package GeneralLedger;

public final class RentExpense extends Expense
{
	// name
	static final String NAME = "Rent Expense";
	
	public RentExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public RentExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public RentExpense(RentExpense acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Rent Expense %s", super.toString());
	} // toString method end
}
