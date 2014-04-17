package GeneralLedger;

public final class GainOnDisposalOfPlantAssets extends Revenue
{
	// name
	static final String NAME = "Gain on Disposal of Plant Assets";
	
	public GainOnDisposalOfPlantAssets(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public GainOnDisposalOfPlantAssets() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public GainOnDisposalOfPlantAssets(GainOnDisposalOfPlantAssets acc) // copy constructor
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
		return String.format("Gain on Disposal of Plant Assets %s", super.toString());
	} // toString method end
}
