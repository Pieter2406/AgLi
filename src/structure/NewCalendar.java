
package structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * A data structure that holds agenda entries in an ordered manner.
 * @author Pieter
 *
 */

public class NewCalendar {
	/**
	 * 
	 */
	public NewCalendar(){
		this.allEntries = new ArrayList<AgEntry>();
		this.calendar = new HashMap<Integer,HashMap<Integer,HashMap<Integer, ArrayList<AgEntry>>>>();
		this.deletedEntries = new ArrayList<AgEntry>();
	}
	
	/**
	 * An arraylist that holds all the agenda entries.
	 */
	private ArrayList<AgEntry> allEntries;
	private HashMap<Integer,HashMap<Integer,HashMap<Integer, ArrayList<AgEntry>>>> calendar;
	private Collection<AgEntry> deletedEntries;
	/**
	 * @param year The given year
	 * @return a HashMap with all the months of the given year and its entries.
	 */
	public HashMap<Integer,HashMap<Integer,ArrayList<AgEntry>>> getYearEntriesOf(int year){
		return calendar.get(year);
	}
	
	/**
	 * 
	 * @param year	The given year
	 * @param month	The given month
	 * @return	a HashMap with all the agenda entries of the given year and month.
	 */
	public HashMap<Integer,ArrayList<AgEntry>> GetMonthEntriesOf(int year, int month){
		return getYearEntriesOf(year).get(month);
	}
	
	/**
	 * @param year	The given year
	 * @param month	The given month
	 * @param day	The given day
	 * @return	an arraylist of agenda entries of the given year month and day.
	 */
	public ArrayList<AgEntry> GetAgEntriesOf(int year, int month, int day){
		return GetMonthEntriesOf(year,month).get(day);
	}
	/**
	 * 
	 * @param entry
	 */
	public void AddEntry(AgEntry entry){
		GetAgEntriesOf(entry.getDate().getYear(), entry.getDate().getIntMonth(), entry.getDate().getIntDay()).add(entry);
		this.allEntries.add(entry);
	}
	
	/**
	 * 
	 */
	public void DelEntry(AgEntry entry){
		GetAgEntriesOf(entry.getDate().getYear(), entry.getDate().getIntMonth(), entry.getDate().getIntDay()).remove(entry);
		this.deletedEntries.add(entry);
	}
	
}
