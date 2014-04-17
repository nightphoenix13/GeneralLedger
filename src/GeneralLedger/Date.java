// Class to hold a date reference
// Written by Zack Rosales

package GeneralLedger;

import java.io.*;

public class Date implements Serializable // class Date start
{
	// class attributes
	private int month, // 1-12
				day, // 1-31
				year; // 0-9999
	
	// three-argument constructor
	public Date(int m, int d, int y)
	{
		setDate(m, d, y); // call to class set method
	} // end constructor
	
	// no-argument constructor
	public Date()
	{
		this(1, 1, 0); // call to class set method
	} // end constructor
	
	// copy constructor
	public Date(Date d)
	{
		this(d.getMonth(), d.getDay(), d.getYear()); // call to class set method
	} // end constructor
	
	// class set method
	private void setDate(int m, int d, int y)
	{
		setYear(y);
		setMonth(m);
		setDay(d);
	} // end class set method
	
	// month set method
	public void setMonth(int m)
	{
		if (m < 1 || m > 12)
		{
			throw new IllegalArgumentException("must be between 1 and 12");
		} // end if
		else
		{
			month = m;
		}
	} // end month set method
	
	// day set method
	public void setDay(int d)
	{
		// local variable
		int max = 1;
		boolean leap;
		
		// checks for leap year
		if (year % 4 == 0)
			leap = true;
		else
			leap = false;
		
		// getting max days for month
		switch (month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: max = 31;
			break;
		case 2: if (leap)
					max = 29;
				else
					max = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11: max = 30;
			break;
		}
		
		if (d < 1 || d > max)
		{
			throw new IllegalArgumentException(String.format("must be between 1 and %d", max));
		} // end if
		day = d;
	}// end day set method
	
	// year set method
	public void setYear(int y)
	{
		if (y < 1970 || y > 2100)
		{
			throw new IllegalArgumentException("must be between 1970 and 2100");
		} // end if
		else
		{
			year = y;
		}
	} // end year set method
	
	// class get method
	public Date getDate()
	{
		return this;
	} // end class get method
	
	// month get method
	public int getMonth()
	{
		return month;
	} // end month get method
	
	// day get method
	public int getDay()
	{
		return day;
	} // end day get method
	
	// year get method
	public int getYear()
	{
		return year;
	} // end year get method
	
	// getStringDate method returns date as string in YYYYMMDD format
	public String getStringDate() // getStringDate method start
	{
		// local variable
		String date;
		
		// formatting date 
		date = String.format("%d", year);
		if (month / 10 == 0) // uses integer division to see if number is less than 10
		{
			date += "0";
		} // end if
		date += String.format("%d", month);
		if (day / 10 == 0) // uses integer division to see if number is less than 10
		{
			date += "0";
		} // end if
		date += String.format("%d", day);
		
		return date;
	} // getStringDate method end
	
	// method getMonthName returns the name of the month as a string
	public String getMonthName()
	{
		switch (month)
		{
		case 1: return "January";
		case 2: return "February";
		case 3: return "March";
		case 4: return "April";
		case 5: return "May";
		case 6: return "June";
		case 7: return "July";
		case 8: return "August";
		case 9: return "September";
		case 10: return "October";
		case 11: return "November";
		case 12: return "December";
		default: return "Invalid Month";
		} // end switch
	} // getMonthName method end
	
	@Override // overrides java.lang.Object.toString method
	public String toString()
	{
		return String.format("%d/%d/%d", month, day, year);
	}
} // class Date end
