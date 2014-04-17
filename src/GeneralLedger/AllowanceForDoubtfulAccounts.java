package GeneralLedger;

public final class AllowanceForDoubtfulAccounts extends Asset
{
	// name
	static final String NAME = "Allowance for Doubtful Accounts";
	
	public AllowanceForDoubtfulAccounts(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public AllowanceForDoubtfulAccounts() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public AllowanceForDoubtfulAccounts(AllowanceForDoubtfulAccounts acc) // copy constructor
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
		return String.format("Allowance for Doubtful Accounts %s", super.toString());
	} // toString method end
	
	@Override // overrides Account.Asset.debit method because this is a contra-asset account
	public void debit(double amount)
	{
		setBalance(getBalance() - amount); // debiting Allowance for Doubtful Accounts account decreases balance
	} // debit method end
	
	@Override // overrides Account.Asset.credit method because this is a contra-asset account
	public void credit(double amount)
	{
		setBalance(getBalance() + amount); // crediting Allowance for Doubtful Accounts account increases balance
	}
	
	@Override // overrides Account.Asset.getStatus method because debiting does not increase
	public boolean getStatus()
	{
		return (!super.getStatus());
	} // getStatus method end
}
