package GeneralLedger;

public final class SuppliesExpense extends Expense
{
	// name
	static final String NAME = "Supplies Expense";
	
	public SuppliesExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public SuppliesExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public SuppliesExpense(SuppliesExpense acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Supplies Expense %s", super.toString());
	} // toString method end
}
