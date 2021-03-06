package GeneralLedger;

public final class SalariesAndWagesPayable extends Liability
{
	// name
	static final String NAME = "Salaries and Wages Payable";
	
	public SalariesAndWagesPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public SalariesAndWagesPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	public SalariesAndWagesPayable(SalariesAndWagesPayable acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Salaries and Wages Payable %s", super.toString());
	} // toString method end
}
