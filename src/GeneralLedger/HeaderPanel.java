package GeneralLedger;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class HeaderPanel extends JPanel
{
	// getting today's date
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	java.util.Date date = new java.util.Date();
	
	private JLabel dateLabel;
	private JTextField dateField;
	
	HeaderPanel() // default constructor
	{
		// creating panel objects
		dateLabel = new JLabel("Date of transaction: ");
		dateField = new JTextField(dateFormat.format(date), 10);
		
		// adding objects to panel
		add(dateLabel);
		add(dateField);
	} // constructor end
	
	// getDate returns the date in the JTextField
	public String getDate() // getDate method start
	{
		return dateField.getText();
	} // getDate method end
	
	// reset method resets the panel
	public void reset() // reset method start
	{
		dateField.setText(dateFormat.format(date));
	} // reset method end
}
