package GeneralLedger;

public final class DiscountOnBondsPayable extends Liability
{
	// name
	static final String NAME = "Discount on Bonds Payable";
		
	public DiscountOnBondsPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public DiscountOnBondsPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public DiscountOnBondsPayable(DiscountOnBondsPayable acc) // copy constructor
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
		return String.format("Discount on Bonds Payable %s", super.toString());
	} // toString method end
	
	@Override // overrides Account.Liability.debit method because this is a contra-liability account
	public void debit(double amount)
	{
		setBalance(getBalance() + amount); // debiting Discount on Bonds Payable increases balance
	} // debit method end
	
	@Override // overrides Account.Liability.credit method because this is a contra-liability account
	public void credit(double amount)
	{
		setBalance(getBalance() - amount); // crediting Discount on Bonds Payable decreases balance
	} // credit method end 
	
	@Override // overrides Account.Liability.getStatus method to return the opposite value
	public boolean getStatus()
	{
		return (!super.getStatus());
	} // getStatus method end
}
