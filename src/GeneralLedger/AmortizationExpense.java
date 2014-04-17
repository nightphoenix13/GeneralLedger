package GeneralLedger;

public final class AmortizationExpense extends Expense
{
	// name
	static final String NAME = "Amortization Expense";
	
	public AmortizationExpense(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public AmortizationExpense() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public AmortizationExpense(AmortizationExpense acc) // copy constructor
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
		return String.format("Amortization Expense %s", super.toString());
	} // toString method end
}
