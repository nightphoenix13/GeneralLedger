package GeneralLedger;

public final class SalesDiscounts extends Revenue
{
	// name
	static final String NAME = "Sales Discounts";
	
	public SalesDiscounts(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public SalesDiscounts() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public SalesDiscounts(SalesDiscounts acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Sales Discounts %s", super.toString());
	} // toString method end
	
	@Override // overrides Account.Revenue.debit method because this is a contra-revenue account
	public void debit(double amount)
	{
		setBalance(getBalance() + amount); // debiting Sales Discounts increases balance
	} // debit method end
	
	@Override // overrides Account.Revenue.credit method because this is a contra-revenue account
	public void credit(double amount)
	{
		setBalance(getBalance() - amount); // crediting Sales Discounts decreases balance
	} // credit method end
	
	@Override // overrides Account.Revenue.getStatus method to return the opposite
	public boolean getStatus()
	{
		return (!super.getStatus());
	} // getStatus method end
}
