package GeneralLedger;

public final class MaintenanceAndRepairsExpense extends Expense
{
	// name
	static final String NAME = "Maintenance and Repairs Expense";
	
	public MaintenanceAndRepairsExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public MaintenanceAndRepairsExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public MaintenanceAndRepairsExpense(MaintenanceAndRepairsExpense acc) // copy constructor
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
		return String.format("Maintenance and Repairs Expense %s", super.toString());
	} // toString method end
}
