package GeneralLedger;

public final class AccountsPayable extends Liability
{
	// name
	static final String NAME = "Accounts Payable";
	
	public AccountsPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public AccountsPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public AccountsPayable(AccountsPayable acc) // copy constructor
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
		return String.format("Accounts Payable %s", super.toString());
	} // toString method end
}
