package GeneralLedger;

public final class SalesReturnsAndAllowances extends Revenue
{
	// name
	static final String NAME = "Sales Returns and Allowances";
	
	public SalesReturnsAndAllowances(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public SalesReturnsAndAllowances() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public SalesReturnsAndAllowances(SalesReturnsAndAllowances acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Sales Returns and Allowances %s", super.toString());
	} // toString method end
	
	@Override // overrides Account.Revenue.debit method because this is a contra-revenue account
	public void debit(double amount)
	{
		setBalance(getBalance() + amount); // debiting Sales Returns and Allowances increases balance
	} // debit method end
	
	@Override // overrides Account.Revenue.credit method because this is a contra-revenue account
	public void credit(double amount)
	{
		setBalance(getBalance() - amount); // crediting Sales Returns and Allowances decreases balance
	} // credit method end
	
	@Override // overrides Account.Revenue.getStatus method to return the opposite
	public boolean getStatus()
	{
		return (!super.getStatus());
	} // getStatus method end
}
