package GeneralLedger;

public final class PremiumOnBondsPayable extends Liability
{
	// name
	static final String NAME = "Premium on Bonds Payable";
	
	public PremiumOnBondsPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public PremiumOnBondsPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public PremiumOnBondsPayable(PremiumOnBondsPayable acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Premium on Bonds Payable %s", super.toString());
	} // toString method end
	
	@Override // overrides Account.Liability.debit method because this is a contra-revenue account
	public void debit(double amount)
	{
		setBalance(getBalance() + amount); // debiting Premium on Bonds Payable increases balance
	} // debit method end
	
	@Override // overrides Account.Liability.credit method because this is a contra-revenue account
	public void credit(double amount)
	{
		setBalance(getBalance() - amount); // crediting Premium on Bonds Payable decreases balance
	} // credit method end
	
	@Override // overrides Account.Liability.getStatus method to return the opposite
	public boolean getStatus()
	{
		return (!super.getStatus());
	} // getStatus method end
}
