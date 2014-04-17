package GeneralLedger;

public abstract class StockholdersEquity extends Account
{
	public StockholdersEquity(double bal) // one-argument constructor
	{
		super(bal);
	} // constructor end
	
	public StockholdersEquity() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public StockholdersEquity(StockholdersEquity acc) // copy constructor
	{
		this(acc.getBalance());
	} // constructor end
}
