package GeneralLedger;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class TransactionLog
{
	// global constants
	final int ACCOUNTS_PAYABLE = 0,
			  ACCOUNTS_RECEIVABLE = 1,
			  ACCUMULATED_DEPRECIATION_BUILDINGS = 2,
			  ACCUMULATED_DEPRECIATION_EQUIPMENT = 3,
			  ADMINISTRATIVE_EXPENSES = 4,
			  ALLOWANCE_FOR_DOUBTFUL_ACCOUNTS = 5,
			  AMORTIZATION_EXPENSE = 6,
			  BAD_DEBTS_EXPENSE = 7,
			  BONDS_PAYABLE = 8,
			  BUILDINGS = 9,
			  CASH = 10,
			  COMMON_STOCK = 11,
			  COPYRIGHT = 12,
			  COST_OF_GOODS_SOLD = 13,
			  DEPRECIATION_EXPENSE = 14,
			  DISCOUNT_ON_BONDS_PAYABLE = 15,
			  DIVIDENDS = 16,
			  DIVIDENDS_PAYABLE = 17,
			  EQUIPMENT = 18,
			  FREIGHT_OUT = 19,
			  GAIN_ON_DISPOSAL_OF_PLANT_ASSET = 20,
			  GOODWILL = 21,
			  INCOME_TAXES_PAYABLE = 22,
			  INCOME_TAX_EXPENSE = 23,
			  INSURANCE_EXPENSE = 24,
			  INTEREST_EXPENSE = 25,
			  INTEREST_PAYABLE = 26,
			  INTEREST_RECEIVABLE = 27,
			  INTEREST_REVENUE = 28,
			  INVENTORY = 29,
			  LAND = 30,
			  LOSS_ON_DISPOSAL_OF_PLANT_ASSET = 31,
			  MAINTENANCE_AND_REPAIRS_EXPENSE = 32,
			  MORTGAGE_PAYABLE = 33,
			  NOTES_PAYABLE = 34,
			  PAID_IN_CAPITAL_COMMON_STOCK = 35,
			  PAID_IN_CAPITAL_PREFERRED_STOCK = 36,
			  PATENT = 37,
			  PREFERRED_STOCK = 38,
			  PREMIUM_ON_BONDS_PAYABLE = 39,
			  PREPAID_INSURANCE = 40,
			  PREPAID_RENT = 41,
			  RENT_EXPENSE = 42,
			  RETAINED_EARNINGS = 43,
			  SALARIES_AND_WAGES_EXPENSE = 44,
			  SALARIES_AND_WAGES_PAYABLE = 45,
			  SALES_DISCOUNTS = 46,
			  SALES_RETURNS_AND_ALLOWANCES = 47,
			  SALES_REVENUE = 48,
			  SELLING_EXPENSES = 49,
			  SERVICE_REVENUE = 50,
			  SUPPLIES = 51,
			  SUPPLIES_EXPENSE = 52,
			  TREASURY_STOCK_COMMON = 53,
			  UNEARNED_SERVICE_REVENUE = 54,
			  UTILITIES_EXPENSE = 55;
	
	// class attributes
	final static int SIZE = 56;
	private Map<String, Transaction> transactionMap = new TreeMap<String, Transaction>();
	private Account[] accounts = new Account[SIZE];
	private ObjectOutputStream logOutput,
							   accountOutput;
	private ObjectInputStream logInput,
							  accountInput;
	
	
	public TransactionLog() // default constructor
	{
		initializeAccounts();
		openFile();		
	} // end constructor
	
	// initializeAccounts method creates new accounts for the array to hold
	private void initializeAccounts() // initializeAccounts method start
	{
		accounts[ACCOUNTS_PAYABLE] = new AccountsPayable();
		accounts[ACCOUNTS_RECEIVABLE] = new AccountsReceivable();
		accounts[ACCUMULATED_DEPRECIATION_BUILDINGS] = new AccumulatedDepreciationBuildings();
		accounts[ACCUMULATED_DEPRECIATION_EQUIPMENT] = new AccumulatedDepreciationEquipment();
		accounts[ADMINISTRATIVE_EXPENSES] = new AdministrativeExpenses();
		accounts[ALLOWANCE_FOR_DOUBTFUL_ACCOUNTS] = new AllowanceForDoubtfulAccounts();
		accounts[AMORTIZATION_EXPENSE] = new AmortizationExpense();
		accounts[BAD_DEBTS_EXPENSE] = new BadDebtsExpense();
		accounts[BONDS_PAYABLE] = new BondsPayable();
		accounts[BUILDINGS] = new Buildings();
		accounts[CASH] = new Cash();
		accounts[COMMON_STOCK] = new CommonStock();
		accounts[COPYRIGHT] = new Copyright();
		accounts[COST_OF_GOODS_SOLD] = new CostOfGoodsSold();
		accounts[DEPRECIATION_EXPENSE] = new DepreciationExpense();
		accounts[DISCOUNT_ON_BONDS_PAYABLE] = new DiscountOnBondsPayable();
		accounts[DIVIDENDS] = new Dividends();
		accounts[DIVIDENDS_PAYABLE] = new DividendsPayable();
		accounts[EQUIPMENT] = new Equipment();
		accounts[FREIGHT_OUT] = new FreightOut();
		accounts[GAIN_ON_DISPOSAL_OF_PLANT_ASSET] = new GainOnDisposalOfPlantAssets();
		accounts[GOODWILL] = new Goodwill();
		accounts[INCOME_TAXES_PAYABLE] = new IncomeTaxesPayable();
		accounts[INCOME_TAX_EXPENSE] = new IncomeTaxExpense();
		accounts[INSURANCE_EXPENSE] = new InsuranceExpense();
		accounts[INTEREST_EXPENSE] = new InterestExpense();
		accounts[INTEREST_PAYABLE] = new InterestPayable();
		accounts[INTEREST_RECEIVABLE] = new InterestReceivable();
		accounts[INTEREST_REVENUE] = new InterestRevenue();
		accounts[INVENTORY] = new Inventory();
		accounts[LAND] = new Land();
		accounts[LOSS_ON_DISPOSAL_OF_PLANT_ASSET] = new LossOnDisposalOfPlantAssets();
		accounts[MAINTENANCE_AND_REPAIRS_EXPENSE] = new MaintenanceAndRepairsExpense();
		accounts[MORTGAGE_PAYABLE] = new MortgagePayable();
		accounts[NOTES_PAYABLE] = new NotesPayable();
		accounts[PAID_IN_CAPITAL_COMMON_STOCK] = new PaidInCapitalCommonStock();
		accounts[PAID_IN_CAPITAL_PREFERRED_STOCK] = new PaidInCapitalPreferredStock();
		accounts[PATENT] = new Patent();
		accounts[PREFERRED_STOCK] = new PreferredStock();
		accounts[PREMIUM_ON_BONDS_PAYABLE] = new PremiumOnBondsPayable();
		accounts[PREPAID_INSURANCE] = new PrepaidInsurance();
		accounts[PREPAID_RENT] = new PrepaidRent();
		accounts[RENT_EXPENSE] = new RentExpense();
		accounts[RETAINED_EARNINGS] = new RetainedEarnings();
		accounts[SALARIES_AND_WAGES_EXPENSE] = new SalariesAndWagesExpense();
		accounts[SALARIES_AND_WAGES_PAYABLE] = new SalariesAndWagesPayable();
		accounts[SALES_DISCOUNTS] = new SalesDiscounts();
		accounts[SALES_RETURNS_AND_ALLOWANCES] = new SalesReturnsAndAllowances();
		accounts[SALES_REVENUE] = new SalesRevenue();
		accounts[SELLING_EXPENSES] = new SellingExpenses();
		accounts[SERVICE_REVENUE] = new ServiceRevenue();
		accounts[SUPPLIES] = new Supplies();
		accounts[SUPPLIES_EXPENSE] = new SuppliesExpense();
		accounts[TREASURY_STOCK_COMMON] = new TreasuryStockCommon();
		accounts[UNEARNED_SERVICE_REVENUE] = new UnearnedServiceRevenue();
		accounts[UTILITIES_EXPENSE] = new UtilitiesExpense();
	} // initializeAccounts method end
	
	// recordTransaction method creates a transaction ID and stores the transaction in the log
	public void recordTransaction(Transaction t) // recordTransaction method start
	{
		// local variable
		String id = createTransactionID(t.getDate());
		
		// one-debit/one-credit transaction
		if (t.getCreditAccount2() == null && t.getDebitAccount2() == null)
		{
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getDebitAccount1().getClass() == accounts[x].getClass())
				{
					accounts[x].debit(t.getDebitAmount1());
				} // end if
			} // end for
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getCreditAccount1().getClass() == accounts[x].getClass())
				{
					accounts[x].credit(t.getCreditAmount1());
				} // end if
			} // end for
		} // end if
		
		// two-debit/one-credit transaction
		else if (t.getCreditAccount2() == null)
		{
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getDebitAccount1().getClass() == accounts[x].getClass())
				{
					accounts[x].debit(t.getDebitAmount1());
				} // end if
			} // end for
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getDebitAccount2().getClass() == accounts[x].getClass())
				{
					accounts[x].debit(t.getDebitAmount2());
				} // end if
			} // end for
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getCreditAccount1().getClass() == accounts[x].getClass())
				{
					accounts[x].credit(t.getCreditAmount1());
				} // end if
			} // end for
		} // end else if
		
		// one-debit/two-credit transaction
		else if (t.getDebitAccount2() == null)
		{
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getDebitAccount1().getClass() == accounts[x].getClass())
				{
					accounts[x].debit(t.getDebitAmount1());
				} // end if
			} // end for
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getCreditAccount1().getClass() == accounts[x].getClass())
				{
					accounts[x].credit(t.getCreditAmount1());
				} // end if
			} // end for
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getCreditAccount2().getClass() == accounts[x].getClass())
				{
					accounts[x].credit(t.getCreditAmount2());
				} // end if
			} // end for
		} // end else if
		
		// two-debit/two-credit transaction
		else
		{
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getDebitAccount1().getClass() == accounts[x].getClass())
				{
					accounts[x].debit(t.getDebitAmount1());
				} // end if
			} // end for
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getDebitAccount2().getClass() == accounts[x].getClass())
				{
					accounts[x].debit(t.getDebitAmount2());
				} // end if
			} // end for
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getCreditAccount1().getClass() == accounts[x].getClass())
				{
					accounts[x].credit(t.getCreditAmount1());
				} // end if
			} // end for
			for (int x = 0; x < SIZE; x++)
			{
				if (t.getCreditAccount2().getClass() == accounts[x].getClass())
				{
					accounts[x].credit(t.getCreditAmount2());
				} // end if
			} // end for
		} // end else if
		
		transactionMap.put(id, t);
		saveData();
	} // recordTransaction method end
	
	// createTransactionID method uses the date of the transaction as the basis for the id
	private String createTransactionID(Date d) // createTransactionID method start
	{
		// local variable
		String idDate,
			   fullID = "";
		boolean unique = false;
		int thousands = 0,
			hundreds = 0,
			tens = 0,
			ones = 0;
		
		idDate = d.getStringDate();
		
		while (!unique)
		{
			fullID = idDate + thousands + hundreds + tens + ones;
			if (!transactionMap.containsKey(fullID))
			{
				unique = true;
			} // end if
			else
			{
				ones++;
				if (ones == 10)
				{
					ones = 0;
					tens++;
					if (tens == 10)
					{
						tens = 0;
						hundreds++;
						if (hundreds == 10)
						{
							hundreds = 0;
							thousands++;
						} // end if
					} // end if
				}// end if
				fullID = "";
			} // end else
		} // end while
		
		return fullID;
	} // createTransactionID method end
	
	// balanceReport provides a list of accounts and their balances
	public String balanceReport() // balanceReport method start
	{
		// local variable
		String output = String.format("%-60s%15s\n\n", "Account Name", "Balance");
		
		for (int x = 0; x < SIZE; x++)
		{
			output += String.format("%-60s$%14.2f\n", accounts[x].getName(), accounts[x].getBalance());
		} // end for
		
		return output;
	} // balanceReport method end
	
	// logReport method returns the transaction log
	public String logReport() // logReport method start
	{
		// local variable
		String output = "",
			   key = null;
		Transaction t;
		
		if (((TreeMap<String, Transaction>) transactionMap).isEmpty())
		{
			output = "The Transaction Log is Currently Empty";
		}
		else
		{		
			key = ((TreeMap<String, Transaction>) transactionMap).firstKey();
			t = transactionMap.get(key);
			output = "Transaction ID: ";
			
			while (key != null)
			{
				// one-debit/one-credit transaction
				if (t.getDebitAccount2() == null && t.getCreditAccount2() == null)
				{
					output += String.format("%-15s\nAccount Debited: %-60s\nDebit Amount: $%15.2f\nAccount Credited: %-60s\nCredit Amount: $%15.2f\n\n", key,
							t.getDebitAccount1().getName(), t.getDebitAmount1(),
							t.getCreditAccount1().getName(), t.getCreditAmount1());
				} // end if
				
				// two-debit/one-credit transaction
				else if (t.getCreditAccount2() == null)
				{
					output += String.format("%-15s\nAccount Debited: %-60s\nDebit Amount: $%15.2f\nAccount Debited: %-60s\nDebit Amount: $%15.2f\nAccount Credited: %-60s\nCredit Amount: $%15.2f\n\n",
							key, t.getDebitAccount1().getName(), t.getDebitAmount1(),
							t.getDebitAccount2().getName(), t.getDebitAmount2(),
							t.getCreditAccount1().getName(), t.getCreditAmount1());
				} // end else if
				
				// one-debit/two-credit transaction
				else if (t.getDebitAccount2() == null)
				{
					output += String.format("%-15s\nAccount Debited: %-60s\nDebit Amount: $%15.2f\nAccount Credited: %-60s\nCredit Amount: $%15.2f\nAccount Credited: %-60s\nCredit Amount: $%15.2f\n\n",
							key, t.getDebitAccount1().getName(), t.getDebitAmount1(),
							t.getCreditAccount1().getName(), t.getCreditAmount1(),
							t.getCreditAccount2().getName(), t.getCreditAmount2()); 
				} // end else if
				
				// two-debit/two-credit transaction
				else
				{
					output += String.format("%-15s\nAccount Debited: %-60s\nDebit Amount: $%15.2f\nAccount Debited: %-60s\nDebit Amount: $%15.2f\nAccount Credited: %-60s\nCredit Amount: $%15.2f\nAccount Credited: %-60s\nCredit Amount: $%15.2f\n\n",
							key, t.getDebitAccount1().getName(), t.getDebitAmount1(),
							t.getDebitAccount2().getName(), t.getDebitAmount2(),
							t.getCreditAccount1().getName(), t.getCreditAmount1(),
							t.getCreditAccount2().getName(), t.getCreditAmount2());
				} // end else
				
				key = ((TreeMap<String, Transaction>) transactionMap).higherKey(key);
				if (key != null)
				{
					t = transactionMap.get(key);
					output += "Transaction ID: ";
				}
			}
		}
		
		return output;
	} // logReport method end
	
	// adjustedTrialBalance method returns an adjusted trial balance for the accounts
	public String adjustedTrialBalance() // adjustedTrialBalance method start
	{
		
		// local variables
		double otherAssets,
			   otherLiabilities,
			   otherEquities,
			   otherRevenues,
			   otherExpenses,
			   debitTotal = 0.0,
			   creditTotal = 0.0;
		String output = String.format("%-60s %15s  %15s\n%60s %15s  %15s\n\n",
				"Adjusted Trial Balance", "      Dr.      ", "      Cr.      ",
				"", "------------- ", "------------- ");
		
		// formatting output
		output += String.format("%-60s$%15.2f\n", accounts[CASH].getName(),
				accounts[CASH].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[ACCOUNTS_RECEIVABLE].getName(),
				accounts[ACCOUNTS_RECEIVABLE].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[SUPPLIES].getName(),
				accounts[SUPPLIES].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[PREPAID_INSURANCE].getName(),
				accounts[PREPAID_INSURANCE].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[EQUIPMENT].getName(),
				accounts[EQUIPMENT].getBalance());
		otherAssets = accounts[INTEREST_RECEIVABLE].getBalance() - 
				accounts[ALLOWANCE_FOR_DOUBTFUL_ACCOUNTS].getBalance() + accounts[INVENTORY].getBalance() +
				accounts[PREPAID_RENT].getBalance() + accounts[LAND].getBalance() +
				accounts[BUILDINGS].getBalance() + accounts[COPYRIGHT].getBalance() +
				accounts[GOODWILL].getBalance() + accounts[PATENT].getBalance();
		output += String.format("%-60s$%15.2f\n", "Other Assets", otherAssets);
		output += String.format("%-60s %15s $%15.2f\n", accounts[ACCUMULATED_DEPRECIATION_BUILDINGS].getName(),
				"", accounts[ACCUMULATED_DEPRECIATION_BUILDINGS].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[ACCUMULATED_DEPRECIATION_EQUIPMENT].getName(),
				"", accounts[ACCUMULATED_DEPRECIATION_EQUIPMENT].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[NOTES_PAYABLE].getName(),
				"", accounts[NOTES_PAYABLE].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[ACCOUNTS_PAYABLE].getName(),
				"", accounts[ACCOUNTS_PAYABLE].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[INTEREST_PAYABLE].getName(),
				"", accounts[INTEREST_PAYABLE].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[UNEARNED_SERVICE_REVENUE].getName(),
				"", accounts[UNEARNED_SERVICE_REVENUE].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[SALARIES_AND_WAGES_PAYABLE].getName(),
				"", accounts[SALARIES_AND_WAGES_PAYABLE].getBalance());
		otherLiabilities = accounts[DIVIDENDS_PAYABLE].getBalance() +
				accounts[INCOME_TAXES_PAYABLE].getBalance() + accounts[BONDS_PAYABLE].getBalance() -
				accounts[PREMIUM_ON_BONDS_PAYABLE].getBalance() + accounts[MORTGAGE_PAYABLE].getBalance();
		output += String.format("%-60s %15s $%15.2f\n", "Other Liabilities",
				"", otherLiabilities);
		output += String.format("%-60s$%15.2f\n", accounts[DISCOUNT_ON_BONDS_PAYABLE].getName(),
				accounts[DISCOUNT_ON_BONDS_PAYABLE].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[COMMON_STOCK].getName(),
				"", accounts[COMMON_STOCK].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[PREFERRED_STOCK].getName(),
				"", accounts[PREFERRED_STOCK].getBalance());
		output += String.format("%-60s %15s $%15.2f\n", accounts[RETAINED_EARNINGS].getName(),
				"", accounts[RETAINED_EARNINGS].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[DIVIDENDS].getName(),
				accounts[DIVIDENDS].getBalance());
		otherEquities = accounts[PAID_IN_CAPITAL_COMMON_STOCK].getBalance() +
				accounts[PAID_IN_CAPITAL_PREFERRED_STOCK].getBalance() +
				accounts[TREASURY_STOCK_COMMON].getBalance();
		output += String.format("%-60s %15s $%15.2f\n", "Other Equities",
				"", otherEquities);
		output += String.format("%-60s$%15.2f\n", accounts[SALES_DISCOUNTS].getName(),
				accounts[SALES_DISCOUNTS].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[SALES_RETURNS_AND_ALLOWANCES].getName(),
				accounts[SALES_RETURNS_AND_ALLOWANCES].getBalance());
		otherRevenues = accounts[SERVICE_REVENUE].getBalance() +
				accounts[SALES_REVENUE].getBalance() + accounts[INTEREST_REVENUE].getBalance() +
				accounts[GAIN_ON_DISPOSAL_OF_PLANT_ASSET].getBalance();
		output += String.format("%-60s %15s $%15.2f\n", "Other Revenues",
				"", otherRevenues);
		output += String.format("%-60s$%15.2f\n", accounts[SALARIES_AND_WAGES_EXPENSE].getName(),
				accounts[SALARIES_AND_WAGES_EXPENSE].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[SUPPLIES_EXPENSE].getName(),
				accounts[SUPPLIES_EXPENSE].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[RENT_EXPENSE].getName(),
				accounts[RENT_EXPENSE].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[INSURANCE_EXPENSE].getName(),
				accounts[INSURANCE_EXPENSE].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[INTEREST_EXPENSE].getName(),
				accounts[INTEREST_EXPENSE].getBalance());
		output += String.format("%-60s$%15.2f\n", accounts[DEPRECIATION_EXPENSE].getName(),
				accounts[DEPRECIATION_EXPENSE].getBalance());
		otherExpenses = accounts[ADMINISTRATIVE_EXPENSES].getBalance() +
				accounts[AMORTIZATION_EXPENSE].getBalance() + accounts[BAD_DEBTS_EXPENSE].getBalance() +
				accounts[COST_OF_GOODS_SOLD].getBalance() + accounts[FREIGHT_OUT].getBalance() +
				accounts[INCOME_TAX_EXPENSE].getBalance() + accounts[LOSS_ON_DISPOSAL_OF_PLANT_ASSET].getBalance() +
				accounts[MAINTENANCE_AND_REPAIRS_EXPENSE].getBalance() + accounts[SELLING_EXPENSES].getBalance() +
				accounts[UTILITIES_EXPENSE].getBalance();
		output += String.format("%-60s$%15.2f\n", "Other Expenses", otherExpenses);
		output += String.format("%60s %15s  %15s\n", "", "------------- ", "------------- ");
		
		// getting totals
		for (int x = 0; x < SIZE; x++)
		{
			if (accounts[x].getStatus())
			{
				debitTotal += accounts[x].getBalance();
			} // end if
			else
			{
				creditTotal += accounts[x].getBalance();
			}
		} // end for
		
		output += String.format("%60s$%15.2f $%15.2f", "", debitTotal, creditTotal);
		
		return output;
	} // adjustedTrialBalance method end
	
	// incomeStatement method returns an income statement
	public String incomeStatement() // incomeStatement method start
	{
		double totalExpenses,
			   totalRevenues,
			   otherRevenues = 0.0,
			   otherExpenses = 0.0;
		String output = String.format("%-60s\n\n%-60s\n",
				"Income Statement", "Revenues");
		
		// formatting output
		output += String.format("  %-58s$%15.2f\n", accounts[SALES_DISCOUNTS].getName(),
				accounts[SALES_DISCOUNTS].getBalance());
		output += String.format("  %-58s$%15.2f\n", accounts[SALES_RETURNS_AND_ALLOWANCES].getName(),
				accounts[SALES_RETURNS_AND_ALLOWANCES].getBalance());
		otherRevenues = accounts[SERVICE_REVENUE].getBalance() +
				accounts[SALES_REVENUE].getBalance() + accounts[INTEREST_REVENUE].getBalance() +
				accounts[GAIN_ON_DISPOSAL_OF_PLANT_ASSET].getBalance();
		output += String.format("  %-58s %15s $%15.2f\n", "Other Revenues",
				"", otherRevenues);
		totalRevenues = accounts[SERVICE_REVENUE].getBalance() +
				accounts[SALES_REVENUE].getBalance() + accounts[INTEREST_REVENUE].getBalance() +
				accounts[GAIN_ON_DISPOSAL_OF_PLANT_ASSET].getBalance() - accounts[SALES_DISCOUNTS].getBalance() -
				accounts[SALES_RETURNS_AND_ALLOWANCES].getBalance();
		output += String.format("    %-56s %15s $%15.2f\n\n", "Total Revenues", "",
				totalRevenues);
		output += String.format("%-60s\n", "Expenses");
		output += String.format("  %-58s$%15.2f\n", accounts[SALARIES_AND_WAGES_EXPENSE].getName(),
				accounts[SALARIES_AND_WAGES_EXPENSE].getBalance());
		output += String.format("  %-58s$%15.2f\n", accounts[SUPPLIES_EXPENSE].getName(),
				accounts[SUPPLIES_EXPENSE].getBalance());
		output += String.format("  %-58s$%15.2f\n", accounts[RENT_EXPENSE].getName(),
				accounts[RENT_EXPENSE].getBalance());
		output += String.format("  %-58s$%15.2f\n", accounts[INSURANCE_EXPENSE].getName(),
				accounts[INSURANCE_EXPENSE].getBalance());
		output += String.format("  %-58s$%15.2f\n", accounts[INTEREST_EXPENSE].getName(),
				accounts[INTEREST_EXPENSE].getBalance());
		output += String.format("  %-58s$%15.2f\n", accounts[DEPRECIATION_EXPENSE].getName(),
				accounts[DEPRECIATION_EXPENSE].getBalance());
		otherExpenses = accounts[ADMINISTRATIVE_EXPENSES].getBalance() +
				accounts[AMORTIZATION_EXPENSE].getBalance() + accounts[BAD_DEBTS_EXPENSE].getBalance() +
				accounts[COST_OF_GOODS_SOLD].getBalance() + accounts[FREIGHT_OUT].getBalance() +
				accounts[INCOME_TAX_EXPENSE].getBalance() + accounts[LOSS_ON_DISPOSAL_OF_PLANT_ASSET].getBalance() +
				accounts[MAINTENANCE_AND_REPAIRS_EXPENSE].getBalance() + accounts[SELLING_EXPENSES].getBalance() +
				accounts[UTILITIES_EXPENSE].getBalance();
		output += String.format("  %-58s$%15.2f\n", "Other Expenses", otherExpenses);
		output += String.format("%60s %15s\n\n", "", "------------- ");
		totalExpenses = accounts[SALARIES_AND_WAGES_EXPENSE].getBalance() +
				accounts[SUPPLIES_EXPENSE].getBalance() + accounts[RENT_EXPENSE].getBalance() +
				accounts[INSURANCE_EXPENSE].getBalance() + accounts[INTEREST_EXPENSE].getBalance() +
				accounts[DEPRECIATION_EXPENSE].getBalance() + accounts[ADMINISTRATIVE_EXPENSES].getBalance() +
				accounts[AMORTIZATION_EXPENSE].getBalance() + accounts[BAD_DEBTS_EXPENSE].getBalance() +
				accounts[COST_OF_GOODS_SOLD].getBalance() + accounts[FREIGHT_OUT].getBalance() +
				accounts[INCOME_TAX_EXPENSE].getBalance() + accounts[LOSS_ON_DISPOSAL_OF_PLANT_ASSET].getBalance() +
				accounts[MAINTENANCE_AND_REPAIRS_EXPENSE].getBalance() + accounts[SELLING_EXPENSES].getBalance() +
				accounts[UTILITIES_EXPENSE].getBalance();
		output += String.format("    %-56s %15s $%15.2f\n", "Total Expenses", "",
				totalExpenses);
		output += String.format("%60s %15s  %15s\n", "", "", "------------- ");
		output += String.format("%-60s %15s $%15.2f\n", "Net Income", "", calculateNetIncome());
		output += String.format("%60s %15s  %15s", "", "", "============= ");
		
		return output;
	} // incomeStatement method end
	
	// retainedEarningsStatement method returns a retained earnings statement
	public String retainedEarningsStatement() // retainedEarningsStatement method start
	{
		// local variable
		String output = String.format("%s\n\n", "Retained Earnings Statement");
		
		// formatting output
		output += String.format("%-60s$%15.2f\n", "Original Retained Earnings",
				accounts[RETAINED_EARNINGS].getBalance());
		output += String.format("%-60s %15.2f\n", "Add: Net Income", calculateNetIncome());
		output += String.format("%60s %15s\n", "", "------------- ");
		output += String.format("%-60s %15.2f\n", "", calculateNetIncome() +
				accounts[RETAINED_EARNINGS].getBalance());
		output += String.format("%-60s %15.2f\n", "Less: Dividends", accounts[DIVIDENDS].getBalance());
		output += String.format("%60s %15s\n", "", "------------- ");
		output += String.format("%-60s$%15.2f\n", "New Retained Earnings", calculateEndRetainedEarnings());
		output += String.format("%60s %15s", "", "============= ");
		
		return output;
	} // retainedEarningsStatement method end
	
	// balanceSheet method returns balance sheet
	public String balanceSheet() // balanceSheet method start
	{
		// local variable
		String output = String.format("%-60s\n\n%-60s\n\n", "Balance Sheet", "ASSETS");
		double total,
			   subtotal;
		
		// formatting output
		output += String.format("%-60s\n", "Current assets");
		output += String.format("  %-58s$%15.2f\n", accounts[CASH].getName(),
				accounts[CASH].getBalance());
		total = accounts[CASH].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[ACCOUNTS_RECEIVABLE].getName(),
				accounts[ACCOUNTS_RECEIVABLE].getBalance());
		total += accounts[ACCOUNTS_RECEIVABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[INTEREST_RECEIVABLE].getName(),
				accounts[INTEREST_RECEIVABLE].getBalance());
		total += accounts[INTEREST_RECEIVABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[INVENTORY].getName(),
				accounts[INVENTORY].getBalance());
		total += accounts[INVENTORY].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[SUPPLIES].getName(),
				accounts[SUPPLIES].getBalance());
		total += accounts[SUPPLIES].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[PREPAID_INSURANCE].getName(),
				accounts[PREPAID_INSURANCE].getBalance());
		total += accounts[PREPAID_INSURANCE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[PREPAID_RENT].getName(),
				accounts[PREPAID_RENT].getBalance());
		total += accounts[PREPAID_RENT].getBalance();
		total -= accounts[ALLOWANCE_FOR_DOUBTFUL_ACCOUNTS].getBalance();
		output += String.format("  Less: %-52s$%15s\n",
				accounts[ALLOWANCE_FOR_DOUBTFUL_ACCOUNTS].getName(), 
				String.format("( %.2f )", accounts[ALLOWANCE_FOR_DOUBTFUL_ACCOUNTS].getBalance()));
		output += String.format("%60s %15s\n", "", "------------- ");
		output += String.format("    %-56s %15s $%15.2f\n", "Total current assets", "", total);
		output += String.format("%-60s\n", "Property, plant, and equipment");
		subtotal = accounts[BUILDINGS].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[BUILDINGS].getName(),
				accounts[BUILDINGS].getBalance());
		subtotal += accounts[EQUIPMENT].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[EQUIPMENT].getName(),
				accounts[EQUIPMENT].getBalance());
		subtotal += accounts[LAND].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[LAND].getName(),
				accounts[LAND].getBalance());
		subtotal -= accounts[ACCUMULATED_DEPRECIATION_BUILDINGS].getBalance();
		output += String.format("  Less: %-52s$%15s\n",
				accounts[ACCUMULATED_DEPRECIATION_BUILDINGS].getName(), 
				String.format("( %.2f )", accounts[ACCUMULATED_DEPRECIATION_BUILDINGS].getBalance()));
		subtotal -= accounts[ACCUMULATED_DEPRECIATION_EQUIPMENT].getBalance();
		output += String.format("  Less: %-52s$%15s $%15.2f\n",
				accounts[ACCUMULATED_DEPRECIATION_EQUIPMENT].getName(), 
				String.format("( %.2f )", accounts[ACCUMULATED_DEPRECIATION_EQUIPMENT].getBalance()),
				subtotal);
		output += String.format("%60s %15s\n", "", "------------- ");
		total += subtotal;
		output += String.format("%-60s\n", "Intangible assets");
		subtotal = accounts[COPYRIGHT].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[COPYRIGHT].getName(),
				accounts[COPYRIGHT].getBalance());
		subtotal += accounts[EQUIPMENT].getBalance();
		output += String.format("  %-58s$%15.2f $%15.2f\n", accounts[EQUIPMENT].getName(),
				accounts[EQUIPMENT].getBalance(), subtotal);
		output += String.format("%60s %15s  %15s\n", "", "------------- ", "------------- ");
		total += subtotal;
		output += String.format("%-60s %15s $%15.2f\n", "Total assets", "", total);
		output += String.format("%60s %15s  %15s\n", "", "", "============= ");
		output += String.format("%-60s\n\n", "LIABILITIES AND STOCKHOLDER'S EQUITY");
		output += String.format("%-60s\n", "Current liabilities");
		total = accounts[NOTES_PAYABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[NOTES_PAYABLE].getName(),
				accounts[NOTES_PAYABLE].getBalance());
		total += accounts[ACCOUNTS_PAYABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[ACCOUNTS_PAYABLE].getName(),
				accounts[ACCOUNTS_PAYABLE].getBalance());
		total += accounts[SALARIES_AND_WAGES_PAYABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[SALARIES_AND_WAGES_PAYABLE].getName(),
				accounts[SALARIES_AND_WAGES_PAYABLE].getBalance());
		total += accounts[UNEARNED_SERVICE_REVENUE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[UNEARNED_SERVICE_REVENUE].getName(),
				accounts[UNEARNED_SERVICE_REVENUE].getBalance());
		total += accounts[INTEREST_PAYABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[INTEREST_PAYABLE].getName(),
				accounts[INTEREST_PAYABLE].getBalance());
		total += accounts[DIVIDENDS_PAYABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[DIVIDENDS_PAYABLE].getName(),
				accounts[DIVIDENDS_PAYABLE].getBalance());
		total += accounts[INCOME_TAXES_PAYABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[INCOME_TAXES_PAYABLE].getName(),
				accounts[INCOME_TAXES_PAYABLE].getBalance());
		output += String.format("%60s %15s\n", "", "------------- ");
		output += String.format("    %-56s %15s $%15.2f\n", "Total current liabilities", "", total);
		output += String.format("%-60s\n", "Long-term liabilities");
		subtotal = accounts[MORTGAGE_PAYABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[MORTGAGE_PAYABLE].getName(),
				accounts[MORTGAGE_PAYABLE].getBalance());
		subtotal += accounts[BONDS_PAYABLE].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[BONDS_PAYABLE].getName(),
				accounts[BONDS_PAYABLE].getBalance());
		subtotal -= accounts[DISCOUNT_ON_BONDS_PAYABLE].getBalance();
		output += String.format("  Less: %-52s$%15s\n",
				accounts[DISCOUNT_ON_BONDS_PAYABLE].getName(), 
				String.format("( %.2f )", accounts[DISCOUNT_ON_BONDS_PAYABLE].getBalance()));
		subtotal -= accounts[PREMIUM_ON_BONDS_PAYABLE].getBalance();
		output += String.format("  Less: %-52s$%15s $%15.2f\n",
				accounts[PREMIUM_ON_BONDS_PAYABLE].getName(), 
				String.format("( %.2f )", accounts[PREMIUM_ON_BONDS_PAYABLE].getBalance()),
				subtotal);
		output += String.format("%60s %15s\n", "", "------------- ");
		output += String.format("    %-56s %15s $%15.2f\n", "Total long-term liabilities", "",
				subtotal);
		output += String.format("%60s %15s  %15s\n", "", "", "------------- ");
		total += subtotal;
		output += String.format("      %-54s %15s $%15.2f\n", "Total liabilities", "",
				subtotal);
		output += String.format("%-60s\n", "Stockholder's Equity");
		subtotal = accounts[COMMON_STOCK].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[COMMON_STOCK].getName(),
				accounts[COMMON_STOCK].getBalance());
		subtotal += accounts[PREFERRED_STOCK].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[PREFERRED_STOCK].getName(),
				accounts[PREFERRED_STOCK].getBalance());
		subtotal += accounts[RETAINED_EARNINGS].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[RETAINED_EARNINGS].getName(),
				accounts[RETAINED_EARNINGS].getBalance());
		subtotal += accounts[TREASURY_STOCK_COMMON].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[TREASURY_STOCK_COMMON].getName(),
				accounts[TREASURY_STOCK_COMMON].getBalance());
		subtotal += accounts[PAID_IN_CAPITAL_COMMON_STOCK].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[PAID_IN_CAPITAL_COMMON_STOCK].getName(),
				accounts[PAID_IN_CAPITAL_COMMON_STOCK].getBalance());
		subtotal += accounts[PAID_IN_CAPITAL_PREFERRED_STOCK].getBalance();
		output += String.format("  %-58s$%15.2f\n", accounts[PAID_IN_CAPITAL_PREFERRED_STOCK].getName(),
				accounts[PAID_IN_CAPITAL_PREFERRED_STOCK].getBalance());
		output += String.format("%60s %15s\n", "", "------------- ");
		output += String.format("    %-56s %15s $%15.2f\n", "Total stockholder's equity", "",
				subtotal);
		total += subtotal;
		output += String.format("%-60s %15s $%15.2f\n", "Total liabilities and stockholder's equity", "", total);
		output += String.format("%60s %15s  %15s", "", "", "============= ");
		
		return output;
	} // balanceSheet method end
	
	// calculateNetIncome method returns the net income
	private double calculateNetIncome() // calculateNetIncome method start
	{
		return (accounts[SERVICE_REVENUE].getBalance() +
				accounts[SALES_REVENUE].getBalance() + accounts[INTEREST_REVENUE].getBalance() +
				accounts[GAIN_ON_DISPOSAL_OF_PLANT_ASSET].getBalance() - accounts[SALES_DISCOUNTS].getBalance() -
				accounts[SALES_RETURNS_AND_ALLOWANCES].getBalance()) - (accounts[SALARIES_AND_WAGES_EXPENSE].getBalance() +
				accounts[SUPPLIES_EXPENSE].getBalance() + accounts[RENT_EXPENSE].getBalance() +
				accounts[INSURANCE_EXPENSE].getBalance() + accounts[INTEREST_EXPENSE].getBalance() +
				accounts[DEPRECIATION_EXPENSE].getBalance() + accounts[ADMINISTRATIVE_EXPENSES].getBalance() +
				accounts[AMORTIZATION_EXPENSE].getBalance() + accounts[BAD_DEBTS_EXPENSE].getBalance() +
				accounts[COST_OF_GOODS_SOLD].getBalance() + accounts[FREIGHT_OUT].getBalance() +
				accounts[INCOME_TAX_EXPENSE].getBalance() + accounts[LOSS_ON_DISPOSAL_OF_PLANT_ASSET].getBalance() +
				accounts[MAINTENANCE_AND_REPAIRS_EXPENSE].getBalance() + accounts[SELLING_EXPENSES].getBalance() +
				accounts[UTILITIES_EXPENSE].getBalance());
	} // calculateNetIncome method end
	
	// calculateEndRetainedEarnings method returns new retained earnings for retained
	// earnings statement and balance sheet
	private double calculateEndRetainedEarnings() // calculateEndRetainedEarnings method start
	{
		return (accounts[RETAINED_EARNINGS].getBalance() + calculateNetIncome()) -
				accounts[DIVIDENDS].getBalance();
	} // calculateEndRetainedEarnings method end
	
	// getAccounts method returns the array of accounts
	public Account[] getAccounts() // getAccounts method start
	{
		return accounts;
	} // getAccounts method end
	
	// openFile method attempts to open a Ledger.dat, if it exists
	private void openFile() // openFile method start
	{
		try
		{
			logInput = new ObjectInputStream(new FileInputStream("TransactionLog.dat"));
			accountInput = new ObjectInputStream(new FileInputStream("Accounts.dat"));
			transactionMap = (Map<String, Transaction>) logInput.readObject();
			accounts = (Account[])accountInput.readObject();
			logInput.close();
			accountInput.close();
		} // end try
		catch (IOException|ClassNotFoundException exception)
		{
			JOptionPane.showMessageDialog(null, "This is either the first time you have run this\nprogram or there was an error opening file data",
					"File Load Error", JOptionPane.ERROR_MESSAGE);
		} // end catch
	} // openFile method end
	
	// saveData method saves data to file before program is closed
	private void saveData() // saveData method start
	{
		try
		{
			logOutput = new ObjectOutputStream(new FileOutputStream("TransactionLog.dat"));
			accountOutput = new ObjectOutputStream(new FileOutputStream("Accounts.dat"));
			logOutput.writeObject(transactionMap);
			accountOutput.writeObject(accounts);
			logOutput.close();
			accountOutput.close();
			JOptionPane.showMessageDialog(null, "Data saved to file.", "Data Saved", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (IOException exception)
		{
			JOptionPane.showMessageDialog(null, "Error saving to file!", "Save Error", JOptionPane.ERROR_MESSAGE);
		} // end catch
	} // saveData method end
	
	// removeTransaction method deletes a transaction and updates the associated account balances
	public void removeTransaction(String tID) // removeTransaction method start
	{
		if (transactionMap.containsKey(tID))
		{
			Transaction t = transactionMap.get(tID);
			
			// one-debit/one-credit transaction
			if (t.getCreditAccount2() == null && t.getDebitAccount2() == null)
			{
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getDebitAccount1().getClass() == accounts[x].getClass())
					{
						accounts[x].credit(t.getDebitAmount1());
					} // end if
				} // end for
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getCreditAccount1().getClass() == accounts[x].getClass())
					{
						accounts[x].debit(t.getCreditAmount1());
					} // end if
				} // end for
			} // end if
			
			// two-debit/one-credit transaction
			else if (t.getCreditAccount2() == null)
			{
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getDebitAccount1().getClass() == accounts[x].getClass())
					{
						accounts[x].credit(t.getDebitAmount1());
					} // end if
				} // end for
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getDebitAccount2().getClass() == accounts[x].getClass())
					{
						accounts[x].credit(t.getDebitAmount2());
					} // end if
				} // end for
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getCreditAccount1().getClass() == accounts[x].getClass())
					{
						accounts[x].debit(t.getCreditAmount1());
					} // end if
				} // end for
			} // end else if
			
			// one-debit/two-credit transaction
			else if (t.getDebitAccount2() == null)
			{
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getDebitAccount1().getClass() == accounts[x].getClass())
					{
						accounts[x].credit(t.getDebitAmount1());
					} // end if
				} // end for
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getCreditAccount1().getClass() == accounts[x].getClass())
					{
						accounts[x].debit(t.getCreditAmount1());
					} // end if
				} // end for
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getCreditAccount2().getClass() == accounts[x].getClass())
					{
						accounts[x].debit(t.getCreditAmount2());
					} // end if
				} // end for
			} // end else if
			
			// two-debit/two-credit transaction
			else
			{
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getDebitAccount1().getClass() == accounts[x].getClass())
					{
						accounts[x].credit(t.getDebitAmount1());
					} // end if
				} // end for
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getDebitAccount2().getClass() == accounts[x].getClass())
					{
						accounts[x].credit(t.getDebitAmount2());
					} // end if
				} // end for
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getCreditAccount1().getClass() == accounts[x].getClass())
					{
						accounts[x].debit(t.getCreditAmount1());
					} // end if
				} // end for
				for (int x = 0; x < SIZE; x++)
				{
					if (t.getCreditAccount2().getClass() == accounts[x].getClass())
					{
						accounts[x].debit(t.getCreditAmount2());
					} // end if
				} // end for
			} // end else if
			
			transactionMap.remove(tID);
			JOptionPane.showMessageDialog(null, String.format("Transaction ID %s removed.", tID), "Successfully Removed", JOptionPane.INFORMATION_MESSAGE);
		} // end if
		else
		{
			JOptionPane.showMessageDialog(null, "You did not enter a valid transaction ID!", "Invalid Transaction ID", JOptionPane.ERROR_MESSAGE);
		} // end else
	} // removeTransaction method end
}
