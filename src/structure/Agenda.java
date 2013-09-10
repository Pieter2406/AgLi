package structure;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

/**
 * 
 * @author Pieter
 *
 * This class holds the main agenda and all the entries in the agenda.
 */
public class Agenda {
	/**
	 * Initializes an empty agenda.
	 */
	public Agenda(){
	
	}
	/**
	 * Initializes an agenda with a given collection of input entries.
	 * @param input The array where all the agenda entries are stored.
	 */
	public Agenda(Collection<AgEntry> input){
		this.entries.addAll(input);
	}
	
	/**
	 * Returns a collection of entries in this agenda.
	 */
	public Collection<AgEntry> getEntries(){
		ArrayList<AgEntry> tempEntries = new ArrayList<AgEntry>();
		tempEntries.addAll(entries);
		return tempEntries;
	}
	
	/**
	 * Displays a list of all entries.
	 */
	public void displayEntries(){/*TODO: Write displayEntries*/	}
	
	/**
	 * Displays a memo on the desktop with entries in preferred order.
	 */
	public void memoEntries(){/*TODO: Write memoEntries*/}
	
}
