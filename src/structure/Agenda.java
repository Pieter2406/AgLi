package structure;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.swing.JFrame;

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
	public Agenda(String surName, String lastName, NewDate age){
		this.calendar = new NewCalendar();
		this.agendaHolder = new Person(surName, lastName, age);
		this.mainFrame = new NewFrame(20);
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
	
	public static void main(String[] args){
		Agenda agenda = new Agenda();
	}
}
