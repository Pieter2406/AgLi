package structure;



/**
 * 
 * @author Pieter
 *
 * This class holds the main agenda and all the entries in the agenda.
 */
public class Agenda {
	private NewCalendar calendar;
	private Person agendaHolder;
	private NewFrame mainFrame;
	/**
	 * Initializes an empty agenda.
	 */
	public Agenda(){
		this("","",new NewDate());
	}
	
	/**
	 * Initializes an agenda
	 * @param surName
	 * @param lastName
	 * @param age
	 */
	public Agenda(String surName, String lastName, NewDate age){
		this.calendar = new NewCalendar();
		this.agendaHolder = new Person(surName, lastName, age);
		this.mainFrame = new NewFrame(20, this);
		this.mainFrame.setSize(300,100);
		this.mainFrame.setVisible(true);
	}
		
	/**
	 * Displays a list of all entries.
	 */
	public void displayEntries(){/*TODO: Write displayEntries*/	}
	
	/**
	 * Displays a memo on the desktop with entries in preferred order.
	 */
	public void memoEntries(){/*TODO: Write memoEntries*/}
	
	
	/**
	 * Test main method.
	 */
	public static void main(String[] args){
		Agenda agenda = new Agenda();
	}

	/**
	 * @return the calendar
	 */
	public NewCalendar getCalendar() {
		return calendar;
	}

	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(NewCalendar calendar) {
		this.calendar = calendar;
	}

	/**
	 * @return the agendaHolder
	 */
	public Person getAgendaHolder() {
		return agendaHolder;
	}

	/**
	 * @param agendaHolder the agendaHolder to set
	 */
	public void setAgendaHolder(Person agendaHolder) {
		this.agendaHolder = agendaHolder;
	}

	/**
	 * @return the mainFrame
	 */
	public NewFrame getMainFrame() {
		return mainFrame;
	}

	/**
	 * @param mainFrame the mainFrame to set
	 */
	public void setMainFrame(NewFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
}
