package structure;

import java.util.Date;
/**
 * @deprecated	Date class.
 */
public class NewDate implements Comparable {
	
	private String day;
	private String month;
	private int year;
	private Date date;
	public NewDate(int date) {
		this.date = new Date(date);
		this.day = getDayOf(this.date.getDay());
		this.month = getMonthOf(this.date.getMonth());
		this.year = this.date.getYear();
	}

	/**
	 * @return the day
	 */
	public String getDay() {
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
	public void setDay(String day) {
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

	@Override
	public int compareTo(Object o) {
		return this.date.compareTo(((NewDate)o).getDate());
	}

}
