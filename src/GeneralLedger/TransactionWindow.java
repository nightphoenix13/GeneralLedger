package GeneralLedger;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class TransactionWindow extends JFrame
{
	// JComponents
	private HeaderPanel header;
	private DebitPanel debit;
	private CreditPanel credit;
	private JPanel buttonPanel,
				   transactionPane,
				   accountBalancePane,
				   transactionLogPane,
				   adjustedTrialBalancePane,
				   incomeStatementPane,
				   retainedEarningsStatementPane,
				   balanceSheetPane,
				   removeTransactionPane,
				   removePanel;
	private JButton submit,
					reset,
					remove;
	private JTabbedPane tabbedPane;
	private JTextArea balanceOutput,
					  logOutput,
					  ATBOutput,
					  ISOutput,
					  RESOutput,
					  BSOutput;
	private JLabel removeLabel;
	private JTextField removeField;
	private Font font;
	private TransactionLog log;
	private Account[] accounts;
	
	public TransactionWindow() // constructor
	{
		super("General Ledger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		
		log = new TransactionLog();
		accounts = log.getAccounts();
		
		tabbedPane = new JTabbedPane();
		transactionPane = new JPanel();
		accountBalancePane = new JPanel();
		transactionLogPane = new JPanel();
		adjustedTrialBalancePane = new JPanel();
		incomeStatementPane = new JPanel();
		retainedEarningsStatementPane = new JPanel();
		balanceSheetPane = new JPanel();
		removeTransactionPane = new JPanel();
		removePanel = new JPanel();
		font = new Font("Courier", Font.PLAIN, 12);
		buildTransactionPane();
		buildAccountBalancePane();
		buildTransactionLogPane();
		buildAdjustedTrialBalancePane();
		buildIncomeStatementPane();
		buildRetainedEarningsStatementPane();
		buildBalanceSheetPane();
		buildRemoveTransactionPane();
		
		tabbedPane.addTab("Enter Transaction", transactionPane);
		tabbedPane.addTab("Account Balances", accountBalancePane);
		tabbedPane.addTab("Transaction Log", transactionLogPane);
		tabbedPane.addTab("Adjusted Trial Balance", adjustedTrialBalancePane);
		tabbedPane.addTab("Income Statement", incomeStatementPane);
		tabbedPane.addTab("Retained Earnings Statement", retainedEarningsStatementPane);
		tabbedPane.addTab("Balance Sheet", balanceSheetPane);
		tabbedPane.addTab("Remove Transaction", removeTransactionPane);
		
		// adding tabbedPane to frame
		add(tabbedPane);
		
		pack();
		setVisible(true);
		
	} // end constructor
	
	public static void main(String[] args)
	{
		TransactionWindow tw = new TransactionWindow();
	}
	
	// buildTransactionPane builds the transaction panel
	private void buildTransactionPane() // buildTransactionPane method start
	{
		transactionPane.setLayout(new BorderLayout());
		
		// creating panel components
		header = new HeaderPanel();
		debit = new DebitPanel();
		credit = new CreditPanel();
		buttonPanel = new JPanel();
		buildButtonPanel();
		
		// adding components to panel
		transactionPane.add(header, BorderLayout.NORTH);
		transactionPane.add(debit, BorderLayout.WEST);
		transactionPane.add(credit, BorderLayout.EAST);
		transactionPane.add(buttonPanel, BorderLayout.SOUTH);
	} // buildTransactionPane method end
	
	// buildAccountBalancePane method builds the account balance panel
	private void buildAccountBalancePane() // buildAccountBalancePane method start
	{
		// creating object
		balanceOutput = new JTextArea();
		
		// object settings
		balanceOutput.setText(log.balanceReport());
		balanceOutput.setEditable(false);
		balanceOutput.setFont(font);
		balanceOutput.setRows(20);
		
		// adding object and scroll bar to panel
		accountBalancePane.add(balanceOutput);
		accountBalancePane.add(new JScrollPane(balanceOutput));
	} // buildAccountBalancePane method end
	
	// buildTransactionLogPane method builds the transaction log panel
	private void buildTransactionLogPane() // buildTransactionLogPane method start
	{
		// creating object
		logOutput = new JTextArea();
		
		// object settings
		logOutput.setText(log.logReport());
		logOutput.setEditable(false);
		logOutput.setFont(font);
		logOutput.setRows(20);
		
		// adding object and scroll bar to panel
		transactionLogPane.add(logOutput);
		transactionLogPane.add(new JScrollPane(logOutput));
	} // buildTransactionLogPane method end
	
	// buildAdjustedTrialBalancePane method builds the adjusted trial balance panel
	private void buildAdjustedTrialBalancePane() // buildAdjustedTrialBalancePane method start
	{
		// creating object
		ATBOutput = new JTextArea();
		
		// object settings
		ATBOutput.setText(log.adjustedTrialBalance());
		ATBOutput.setEditable(false);
		ATBOutput.setFont(font);
		ATBOutput.setRows(20);
		
		// adding object and scroll bar to panel
		adjustedTrialBalancePane.add(ATBOutput);
		adjustedTrialBalancePane.add(new JScrollPane(ATBOutput));
	} // buildAdjustedTrialBalancePane method end
	
	// buildIncomeStatementPane method builds the income statement panel
	private void buildIncomeStatementPane() // buildIncomeStatementPane method start
	{
		// creating object
		ISOutput = new JTextArea();
		
		// object settings
		ISOutput.setText(log.incomeStatement());
		ISOutput.setEditable(false);
		ISOutput.setFont(font);
		ISOutput.setRows(20);
		
		// adding object and scroll bar to panel
		incomeStatementPane.add(ISOutput);
		incomeStatementPane.add(new JScrollPane(ISOutput));
	} // buildIncomeStatementPane method end
	
	// buildRetainedEarningsStatementPane method builds the retained earnings statement panel
	private void buildRetainedEarningsStatementPane() // buildRetainedEarningsStatementPane method start
	{
		// creating object
		RESOutput = new JTextArea();
		
		// object settings
		RESOutput.setText(log.retainedEarningsStatement());
		RESOutput.setEditable(false);
		RESOutput.setFont(font);
		RESOutput.setRows(20);
		
		// adding object and scroll bar to panel
		retainedEarningsStatementPane.add(RESOutput);
		retainedEarningsStatementPane.add(new JScrollPane(RESOutput));
	} // buildRetainedEarningsStatementPane method end
	
	// buildBalanceSheetPane method builds the balance sheet panel
	private void buildBalanceSheetPane() // buildBalanceSheetPane method start
	{
		// creating object
		BSOutput = new JTextArea();
		
		// object settings
		BSOutput.setText(log.balanceSheet());
		BSOutput.setEditable(false);
		BSOutput.setFont(font);
		BSOutput.setRows(20);
		
		// adding object and scroll bar to panel
		balanceSheetPane.add(BSOutput);
		balanceSheetPane.add(new JScrollPane(BSOutput));
	} // buildBalanceSheetPane method end
	
	// buildRemoveTransactionPane method builds the remove transaction panel
	private void buildRemoveTransactionPane() // buildRemoveTransactionPane method start
	{
		setLayout(new GridLayout(1,2));
		removeLabel = new JLabel("Transaction ID to remove: ");
		removeField = new JTextField(15);
		remove = new JButton("Remove");
		
		removePanel.add(removeLabel);
		removePanel.add(removeField);
		
		removeTransactionPane.add(removePanel);
		removeTransactionPane.add(remove);
		
		remove.addActionListener(new RemoveHandler());
	} // buildRemoveTransactionPane method end
	
	// buildButtonPanel method builds the button panel for the SOUTH pane
	private void buildButtonPanel() // buildButtonPanel method start
	{
		submit = new JButton("Submit");
		reset = new JButton("Reset");
		
		buttonPanel.add(reset);
		buttonPanel.add(submit);
		
		submit.addActionListener(new SubmitHandler());
		reset.addActionListener(new ResetHandler());
	} // buildButtonPanel method end
	
	// resetAll method resets all panels
	private void resetAll() // resetAll method start
	{
		header.reset();
		debit.reset();
		credit.reset();
	} // resetAll method end
	
	// updatePanels method updates the output on the tabbed panels
	private void updatePanels() // updatePanels method start
	{
		balanceOutput.setText(log.balanceReport());
		logOutput.setText(log.logReport());
		ATBOutput.setText(log.adjustedTrialBalance());
		ISOutput.setText(log.incomeStatement());
		RESOutput.setText(log.retainedEarningsStatement());
		BSOutput.setText(log.balanceSheet());
	} // updatePanels method end
	
	class SubmitHandler implements ActionListener // SubmitHandler class start
	{
		public void actionPerformed(ActionEvent e) // actionPerformed method start
		{
			// declaring transaction
			String dateString = header.getDate();
			String[] dateTokens = dateString.split("/");
			Transaction t;
			Date date = null;
			
			try
			{
				date = new Date(Integer.parseInt(dateTokens[0]), Integer.parseInt(dateTokens[1]),
						Integer.parseInt(dateTokens[2]));
			} // end try
			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(transactionPane, "You must enter a valid date! (mm/dd/yyyy)", "Invalid Date", JOptionPane.ERROR_MESSAGE);
			} // end catch
			
			try
			{
				if (debit.getAmount1() + debit.getAmount2() == credit.getAmount1() + credit.getAmount2())
				{
					// one-debit/one-credit transaction
					if (debit.getAccount2() == 0 && credit.getAccount2() == 0)
					{
						t = new Transaction(accounts[debit.getAccount1() - 1], debit.getAmount1(),
								date, accounts[credit.getAccount1() - 1], credit.getAmount1());
					} // end if
			
					// two-debit/one-credit transaction
					else if (credit.getAccount2() == 0)
					{
						t = new Transaction(accounts[debit.getAccount1() - 1], debit.getAmount1(),
								accounts[debit.getAccount2() - 1], debit.getAmount2(), date,
								accounts[credit.getAccount1() - 1], credit.getAmount1());
					} // end else if
			
					// one-debit/two-credit transaction
					else if (debit.getAccount2() == 0)
					{
						t = new Transaction(accounts[debit.getAccount1() - 1], debit.getAmount1(),
								date, accounts[credit.getAccount1() - 1], credit.getAmount1(),
								accounts[credit.getAccount2() - 1], credit.getAmount2());
					} // end else if
			
					// two-debit/two-credit transaction
					else
					{
						t = new Transaction(accounts[debit.getAccount1() - 1], debit.getAmount1(),
								accounts[debit.getAccount2() - 1], debit.getAmount2(), date,
								accounts[credit.getAccount1() - 1], credit.getAmount1(),
								accounts[credit.getAccount2() - 1], credit.getAmount2());
					} // end else
				
					log.recordTransaction(t);
					updatePanels();
					resetAll();
				} // end if
				else
				{
					JOptionPane.showMessageDialog(transactionPane, "The total debit amounts and credit amounts must be equal!", "Unequal Amounts", JOptionPane.ERROR_MESSAGE);
				} // end else
			} // end try
			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(transactionPane, "You must enter a valid number value!", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
			} // end catch
			catch (ArrayIndexOutOfBoundsException exception)
			{
				JOptionPane.showMessageDialog(transactionPane, "You must select an valid account!", "Account Not Selected", JOptionPane.ERROR_MESSAGE);
			} // end catch
		} // actionPerformed method end
	} // SubmitHandler class end
	
	private class ResetHandler implements ActionListener // ResetHandler class start
	{
		public void actionPerformed(ActionEvent e) // actionPerformed method start
		{
			resetAll();
		} // actionPerformed method end
	} // ResetHandler class end
	
	private class RemoveHandler implements ActionListener // RemoveHandler class start
	{
		public void actionPerformed(ActionEvent e) // actionPerformed method start
		{
			log.removeTransaction(removeField.getText());
			updatePanels();
		} // actionPerformed method end
	} // RemoveHandler class end
	
	private class DebitPanel extends JPanel
	{
		private String[] names,
		 				 debitDecreaseNames,
		 				 debitIncreaseNames;
		
		private JLabel debitLabel,
					   amountLabel1,
					   amountLabel2;
		private JComboBox debitBox1,
						  debitBox2;
		private JTextField amountField1,
						   amountField2;
		private JCheckBox checkBox;
		private JPanel amountPanel1,
					   amountPanel2;
		private int SIZE = 57,
					DDSIZE = 23,
					DISIZE = 35;
		
		public DebitPanel() // default constructor
		{
			// ComboBox array
			names = new String[SIZE];
			debitDecreaseNames = new String[DDSIZE];
			debitIncreaseNames = new String[DISIZE];
			debitIncreaseNames[0] = debitDecreaseNames[0] = names[0] = "Select an account";
			fillNamesArray();
			
			// creating panel objects
			setLayout(new GridLayout(6, 1));
			debitLabel = new JLabel("Account to debit:");
			checkBox = new JCheckBox("Debit second account");
			//checkBox.setEnabled(false);
			amountPanel1 = new JPanel();
			amountPanel2 = new JPanel();
			buildAmountPanel1();
			buildAmountPanel2();
			debitBox1 = new JComboBox(names);
			debitBox2 = new JComboBox(names);
			debitBox1.setEditable(false);
			debitBox2.setEditable(false);
			debitBox2.setEnabled(false);
			
			// adding objects to panel
			add(debitLabel);
			add(debitBox1);
			add(amountPanel1);
			add(checkBox);
			add(debitBox2);
			add(amountPanel2);
			
			// registering handlers
			checkBox.addItemListener(new CBHandler());
			debitBox1.addItemListener(new DB1Handler());
			debitBox2.addItemListener(new DB2Handler());
		} // constructor end
		
		// fillNamesArray fills array with names of accounts
		private void fillNamesArray() // fillNamesArray method start
		{
			for (int x = 0; x < SIZE - 1; x++)
			{
				names[x + 1] = accounts[x].getName();
			} // end for
			
			for (int x = 0, y = 1; x < SIZE - 1; x++)
			{
				if (!accounts[x].getStatus())
				{
					debitDecreaseNames[y] = accounts[x].getName();
					y++;
				} // end if
			} // end for
			
			for (int x = 0, y = 1; x < SIZE - 1; x++)
			{
				if (accounts[x].getStatus())
				{
					debitIncreaseNames[y] = accounts[x].getName();
					y++;
				} // end if
			} // end for 

		} // fillNamesArray method end
		
		// buildAmountPanel1 method creates the first sub-panel
		private void buildAmountPanel1() // buildAmountPanel1 method start
		{
			// creating panel objects
			amountLabel1 = new JLabel("Amount: $");
			amountField1 = new JTextField("0.00", 10);
			amountField1.setEditable(false);

			// adding objects to panel
			amountPanel1.add(amountLabel1);
			amountPanel1.add(amountField1);
		} // buildAmountPanel1 method end
		
		// buildAmountPanel2 method creates the first sub-panel
		private void buildAmountPanel2() // buildAmountPanel2 method start
		{
			// creating panel objects
			amountLabel2 = new JLabel("Amount: $");
			amountField2 = new JTextField("0.00", 10);
			amountField2.setEditable(false);

			// adding objects to panel
			amountPanel2.add(amountLabel2);
			amountPanel2.add(amountField2);
		} // buildAmountPanel1 method end
		
		// getAccount1 method returns the selected item from the first ComboBox
		public int getAccount1() // getAccount1 method start
		{
			return debitBox1.getSelectedIndex();
		} // getAccount1 method end
		
		// getAccount2 method returns the selected item from the first ComboBox
		public int getAccount2() // getAccount2 method start
		{
			if (accounts[debitBox1.getSelectedIndex() - 1].getStatus())
			{
				return convertIncreasingName(debitBox2.getSelectedIndex());
			} // end if
			else
			{
				return convertDecreasingName(debitBox2.getSelectedIndex());
			} // end else
			
		} // getAccount2 method end
		
		// getAmount1 method returns the amount in the first TextField
		public double getAmount1() // getAmount1 method start
		{
			return Double.parseDouble(amountField1.getText());
		} // getAmount1 method end
		
		// getAmount2 method returns the amount in the first TextField
		public double getAmount2() // getAmount2 method start
		{
			return Double.parseDouble(amountField2.getText());
		} // getAmount2 method end
		
		// reset method resets the panel
		public void reset() // reset method start
		{
			debitBox1.setSelectedIndex(0);
			debitBox2.setSelectedIndex(0);
			amountField1.setText("0.00");
			amountField2.setText("0.00");
			checkBox.setSelected(false);
		} // reset method end
		
		// convertDecreasingName method converts the output from combo box 2 to the actual index
		// of the selected account
		private int convertDecreasingName(int cbindex) // convertDecreasingName method start
		{
			switch(cbindex)
			{
			case 0: return 0;
			case 1: return 1;
			case 2: return 3;
			case 3: return 4;
			case 4: return 6;
			case 5: return 9;
			case 6: return 12;
			case 7: return 18;
			case 8: return 21;
			case 9: return 23;
			case 10: return 27;
			case 11: return 29;
			case 12: return 34;
			case 13: return 35;
			case 14: return 36;
			case 15: return 37;
			case 16: return 39;
			case 17: return 44;
			case 18: return 46;
			case 19: return 49;
			case 20: return 51;
			case 21: return 54;
			case 22: return 55;
			default: return 0;
			} // end switch
		} // convertDecreasingName method end
		
		// convertIncreasingName method converts the output from combo box 2 to the actual index
		// of the selected account
		private int convertIncreasingName(int cbindex) // convertIncreasingName method start
		{
			switch(cbindex)
			{
			case 0: return 0;
			case 1: return 2;
			case 2: return 5;
			case 3: return 7;
			case 4: return 8;
			case 5: return 10;
			case 6: return 11;
			case 7: return 13;
			case 8: return 14;
			case 9: return 15;
			case 10: return 16;
			case 11: return 17;
			case 12: return 19;
			case 13: return 20;
			case 14: return 22;
			case 15: return 24;
			case 16: return 25;
			case 17: return 26;
			case 18: return 28;
			case 19: return 30;
			case 20: return 31;
			case 21: return 32;
			case 22: return 33;
			case 23: return 38;
			case 24: return 40;
			case 25: return 41;
			case 26: return 42;
			case 27: return 43;
			case 28: return 45;
			case 29: return 47;
			case 30: return 48;
			case 31: return 50;
			case 32: return 52;
			case 33: return 53;
			case 34: return 56;
			default: return 0;
			} // end switch
		} // convertIncreasingName method end
			
		private class CBHandler implements ItemListener // CBHandler class start
		{
			@Override // overrides itemStateChanged method
			public void itemStateChanged(ItemEvent e)
			{
				if (checkBox.isSelected())
				{
					debitBox2.setEnabled(true);
				} // end if
				else
				{
					debitBox2.setEnabled(false);
				}
			} // itemStateChanged method end
		} // CBHandler class end
		
		private class DB1Handler implements ItemListener // DB1Handler class start
		{
			@Override // overrides itemStateChanged method
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					if (debitBox1.getSelectedIndex() != 0)
					{
						if (accounts[debitBox1.getSelectedIndex() - 1].getStatus())
						{
							debitBox2.setModel(new DefaultComboBoxModel((String[]) debitIncreaseNames));
							credit.enabledIncreasing(!accounts[debitBox1.getSelectedIndex() - 1].getStatus());
							amountField1.setEditable(true);
						} // end if
						else
						{
							debitBox2.setModel(new DefaultComboBoxModel((String[]) debitDecreaseNames));
							credit.enabledIncreasing(!accounts[debitBox1.getSelectedIndex() - 1].getStatus());
							amountField1.setEditable(true);
						}
						checkBox.setEnabled(true);
					} // end if
					else
					{
						checkBox.setSelected(false);
						checkBox.setEnabled(false);
						amountField1.setEditable(false);
					} // end else
				} // end if
			} // itemStateChanged method end
		} // DB1Handler class end
		
		private class DB2Handler implements ItemListener // DB2Handler class start
		{
			@Override // overrides itemStateChanged method
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					if (debitBox2.getSelectedIndex() != 0)
					{
						amountField2.setEditable(true);
					} // end if
					else
					{
						amountField2.setEditable(false);
					} // end else
				} // end if
			} // itemStateChanged method end
		} // DB2Handler class end
	} // DebitPanel class end
	
	private class CreditPanel extends JPanel
	{
		private String[] names,
						 debitDecreaseNames,
						 debitIncreaseNames;
		
		private JLabel creditLabel,
					   amountLabel1,
					   amountLabel2;
		private JComboBox creditBox1,
						  creditBox2;
		private JTextField amountField1,
						   amountField2;
		private JCheckBox checkBox;
		private JPanel amountPanel1,
					   amountPanel2;
		private int SIZE = 57,
					DDSIZE = 23,
					DISIZE = 35;
		private boolean increasing;
		
		public CreditPanel() // default constructor
		{
			// ComboBox array
			names = new String[SIZE];
			debitDecreaseNames = new String[DDSIZE];
			debitIncreaseNames = new String[DISIZE];
			debitIncreaseNames[0] = debitDecreaseNames[0] = names[0] = "Select an account";
			debitIncreaseNames[0] += "                                                                      ";
			fillNamesArray();
			
			// creating panel objects
			setLayout(new GridLayout(6, 1));
			creditLabel = new JLabel("Account to credit:");
			checkBox = new JCheckBox("Credit second account");
			checkBox.setEnabled(false);
			amountPanel1 = new JPanel();
			amountPanel2 = new JPanel();
			buildAmountPanel1();
			buildAmountPanel2();
			creditBox1 = new JComboBox(names);
			creditBox2 = new JComboBox(names);
			creditBox1.setEditable(false);
			creditBox2.setEditable(false);
			creditBox1.setEnabled(false);
			creditBox2.setEnabled(false);
			
			// adding objects to panel
			add(creditLabel);
			add(creditBox1);
			add(amountPanel1);
			add(checkBox);
			add(creditBox2);
			add(amountPanel2);
			
			// registering handlers
			checkBox.addItemListener(new CBHandler());
			creditBox1.addItemListener(new CB1Handler());
			creditBox2.addItemListener(new CB2Handler());
		} // constructor end
		
		// fillNamesArray fills array with names of accounts
		private void fillNamesArray() // fillNamesArray method start
		{
			for (int x = 0; x < SIZE - 1; x++)
			{
				names[x + 1] = accounts[x].getName();
			} // end for
			
			for (int x = 0, y = 1; x < SIZE - 1; x++)
			{
				if (!accounts[x].getStatus())
				{
					debitDecreaseNames[y] = accounts[x].getName();
					y++;
				} // end if
			} // end for
			
			for (int x = 0, y = 1; x < SIZE - 1; x++)
			{
				if (accounts[x].getStatus())
				{
					debitIncreaseNames[y] = accounts[x].getName();
					y++;
				} // end if
			} // end for 
		} // fillNamesArray method end
		
		// buildAmountPanel1 method creates the first sub-panel
		private void buildAmountPanel1() // buildAmountPanel1 method start
		{
			// creating panel objects
			amountLabel1 = new JLabel("Amount: $");
			amountField1 = new JTextField("0.00", 10);
			amountField1.setEditable(false);
			
			// adding objects to panel
			amountPanel1.add(amountLabel1);
			amountPanel1.add(amountField1);
		} // buildAmountPanel1 method end
		
		// buildAmountPanel2 method creates the first sub-panel
		private void buildAmountPanel2() // buildAmountPanel2 method start
		{
			// creating panel objects
			amountLabel2 = new JLabel("Amount: $");
			amountField2 = new JTextField("0.00", 10);
			amountField2.setEditable(false);

			// adding objects to panel
			amountPanel2.add(amountLabel2);
			amountPanel2.add(amountField2);
		} // buildAmountPanel1 method end
		
		// getAccount1 method returns the selected item from the first ComboBox
		public int getAccount1() // getAccount1 method start
		{
			if (increasing)
			{
				return convertIncreasingName(creditBox1.getSelectedIndex());
			} // end if
			else
			{
				return convertDecreasingName(creditBox1.getSelectedIndex());
			} // end else
		} // getAccount1 method end
			
		// getAccount2 method returns the selected item from the first ComboBox
		public int getAccount2() // getAccount2 method start
		{
			if (increasing)
			{
				return convertIncreasingName(creditBox2.getSelectedIndex());
			} // end if
			else
			{
				return convertDecreasingName(creditBox2.getSelectedIndex());
			} // end else
		} // getAccount2 method end
			
		// getAmount1 method returns the amount in the first TextField
		public double getAmount1() // getAmount1 method start
		{
			return Double.parseDouble(amountField1.getText());
		} // getAmount1 method end
			
		// getAmount2 method returns the amount in the first TextField
		public double getAmount2() // getAmount2 method start
		{
			return Double.parseDouble(amountField2.getText());
		} // getAmount2 method end
		
		// reset method resets the panel
		public void reset() // reset method start
		{
			creditBox1.setSelectedIndex(0);
			creditBox1.setEnabled(false);
			creditBox2.setSelectedIndex(0);
			amountField1.setText("0.00");
			amountField2.setText("0.00");
			checkBox.setSelected(false);
		} // reset method end
		
		// enabledIncreasing method makes credit panel editable after a debit account is chosen
		public void enabledIncreasing(boolean value) // enabledIncreasing method start
		{
			if (value)
			{
				creditBox1.setModel(new DefaultComboBoxModel((String[]) debitIncreaseNames));
				creditBox2.setModel(new DefaultComboBoxModel((String[]) debitIncreaseNames));
				creditBox1.setEnabled(true);
				increasing = true;
			} // end if
			else
			{
				creditBox1.setModel(new DefaultComboBoxModel((String[]) debitDecreaseNames));
				creditBox2.setModel(new DefaultComboBoxModel((String[]) debitDecreaseNames));
				creditBox1.setEnabled(true);
				increasing = false;
			} // end else
		} // enabledIncreasing method end
		
		// convertDecreasingName method converts the output from combo box 2 to the actual index
				// of the selected account
				private int convertDecreasingName(int cbindex) // convertDecreasingName method start
				{
					switch(cbindex)
					{
					case 0: return 0;
					case 1: return 1;
					case 2: return 3;
					case 3: return 4;
					case 4: return 6;
					case 5: return 9;
					case 6: return 12;
					case 7: return 18;
					case 8: return 21;
					case 9: return 23;
					case 10: return 27;
					case 11: return 29;
					case 12: return 34;
					case 13: return 35;
					case 14: return 36;
					case 15: return 37;
					case 16: return 39;
					case 17: return 44;
					case 18: return 46;
					case 19: return 49;
					case 20: return 51;
					case 21: return 54;
					case 22: return 55;
					default: return 0;
					} // end switch
				} // convertDecreasingName method end
				
				// convertIncreasingName method converts the output from combo box 2 to the actual index
				// of the selected account
				private int convertIncreasingName(int cbindex) // convertIncreasingName method start
				{
					switch(cbindex)
					{
					case 0: return 0;
					case 1: return 2;
					case 2: return 5;
					case 3: return 7;
					case 4: return 8;
					case 5: return 10;
					case 6: return 11;
					case 7: return 13;
					case 8: return 14;
					case 9: return 15;
					case 10: return 16;
					case 11: return 17;
					case 12: return 19;
					case 13: return 20;
					case 14: return 22;
					case 15: return 24;
					case 16: return 25;
					case 17: return 26;
					case 18: return 28;
					case 19: return 30;
					case 20: return 31;
					case 21: return 32;
					case 22: return 33;
					case 23: return 38;
					case 24: return 40;
					case 25: return 41;
					case 26: return 42;
					case 27: return 43;
					case 28: return 45;
					case 29: return 47;
					case 30: return 48;
					case 31: return 50;
					case 32: return 52;
					case 33: return 53;
					case 34: return 56;
					default: return 0;
					} // end switch
				} // convertIncreasingName method end
		
		private class CBHandler implements ItemListener // CBHandler class start
		{
			@Override // overrides itemStateChanged method
			public void itemStateChanged(ItemEvent e)
			{
				if (checkBox.isSelected())
				{
					creditBox2.setEnabled(true);
					amountField2.setEditable(true);
				} // end if
				else
				{
					creditBox2.setEnabled(false);
					amountField2.setEditable(false);
				}
			} // itemStateChanged method end
		} // CBHandler class end
		
		private class CB1Handler implements ItemListener // CB1Handler class start
		{
			@Override // overrides itemStateChanged method
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					if (creditBox1.getSelectedIndex() != 0)
					{
						amountField1.setEditable(true);
						checkBox.setEnabled(true);
					} // end if
					else
					{
						amountField1.setEditable(false);
						checkBox.setEnabled(false);
					} // end else
				} // end if
			} // itemStateChanged method end
		} // CB1Handler class end
		
		private class CB2Handler implements ItemListener // CB2Handler class start
		{
			@Override // overrides itemStateChanged method
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					if (creditBox2.getSelectedIndex() != 0)
					{
						amountField2.setEditable(true);
					} // end if
					else
					{
						amountField2.setEditable(false);
					} // end else
				} // end if
			} // itemStateChanged method end
		} // CB2Handler class end
	} // CreditPanel class end
}
