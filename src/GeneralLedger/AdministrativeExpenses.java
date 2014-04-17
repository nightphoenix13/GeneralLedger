package GeneralLedger;

public final class AdministrativeExpenses extends Expense
{
	// name
	static final String NAME = "Administrative Expenses";
	
	public AdministrativeExpenses(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public AdministrativeExpenses() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public AdministrativeExpenses(AdministrativeExpenses acc) // copy constructor
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
		return String.format("Administrative Expenses %s", super.toString());
	} // toString method end
}
