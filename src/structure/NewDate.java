package structure;

import java.util.Date;
/**
 * @deprecated	Date class.
 */
public class NewDate implements Comparable {
	
	private int day;
	private String month;
	private int year;
	private Date date;
	public NewDate(int date) {
		this.date = new Date(date);
		this.day = this.date.getDay();
		this.month = getMonthOf(this.date.getMonth());
		this.year = this.date.getYear();
	}
	
	public NewDate(){
		this(0);
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 
	 */
	public int getIntDay() {
		return this.date.getDay();
	}
	/**
	 * @param day the day to set
	 */

	public void setDay(int day){
		this.date.setDate(day);
		this.day = day;
	}
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 
	 */
	public int getIntMonth() {
		return this.date.getMonth();
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
		this.date.setMonth(getIntMonthOf(month));
	}
	public void setMonth(int month){
		this.month = getMonthOf(month);
		this.date.setMonth(month);
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	private static String getMonthOf(int inputMonth) {
		switch (inputMonth) {
		case 1:  return "January";
		case 2:  return "February";
		case 3:  return "March";
		case 4:  return "April";
		case 5:  return "May";
		case 6:  return "June";
		case 7:  return "July";
		case 8:  return "August";
		case 9:  return "September";
		case 10: return "October";
		case 11: return "November";
		case 12: return "December";
		default: return "Invalid month";
		}
	}

	private static String getDayOf(int inputDayNr){
		switch(inputDayNr){
		case 0: return "Sunday";
		case 1: return "Monday";
		case 2: return "Tuesday";
		case 3: return "Wednesday";
		case 4: return "Thursday"; 
		case 5: return "Friday";
		case 6: return "Saturday";
		default: return "Invalid day";
		}

	}
	
	private int getIntDayOf(String inputDayName) {
		switch(inputDayName){
		case "Sunday": return 0;
		case "Monday": return 1;
		case "Tuesday": return 2;
		case "Wednesday": return 3;
		case "Thursday": return 4;
		case "Friday": return 5;
		case "Saturday": return 6;
		default: return -1;
		}
	}

	private int getIntMonthOf(String inputMonthName) {
		switch (inputMonthName) {
		case "January": return 1;
		case "February": return 2;
		case "March": return 3;
		case "April": return 4;
		case "May": return 5;
		case "June": return 6;
		case "July": return 7;
		case "August": return 8;
		case "September": return 9;
		case "October": return 10;
		case "November": return 11;
		case "December": return 12;
		default: return -1;
		}
	}
	@Override
	public int compareTo(Object o) {
		return this.date.compareTo(((NewDate)o).getDate());
	}

	public String toString(){
		return this.day + "/" + getIntMonthOf(this.getMonth()) + ":";
	}
}
