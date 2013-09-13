package structure;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Pieter
 *
 * This class holds an entry of an agenda item.
 */
public class AgEntry implements Comparable {
	/**
	 * The date of this agenda entry specified as a NewDate object.
	 */
	private NewDate date;
	/**
	 * The subject of this agenda entry. Holds a short description of the entry.
	 */
	private String subject;
	/**
	 * The content of the entry.
	 */
	private String content;
	
	/**
	 * The priority of this entry as a number from 1 to 10 where 10 is the highest
	 * priority and 1 the lowest.
	 */
	private int priority;
	
	/**
	 * Initializes an agenda entry with a given date, subject,the content of the agenda entry and 
	 * a given priority.
	 * @param date	A given day with or without a given month and with or without a given year.
	 * @param subject	The subject of the agenda entry.
	 * @param content	The content of the agenda entry.
	 * @param priority	The priority of the agenda entry from a scale of 1 to 10.
	 */
	public AgEntry(NewDate date, String subject, String content, int priority) {
		this.date = date;
		this.subject = subject;
		this.content = content;
		this.priority = priority;
	}
	
	/**
	 * Initializes an agenda entry with a given date, an empty subject, the content of the agenda entry and a priority of 1.
	 * @param date		A given day with or without a given month and with or without a given year.
	 * @param content	The content of the agenda entry.
	 */
	
	public AgEntry(NewDate date, String content){
		this(date,"",content,1);
	}
	
	/**
	 * Initializes an AgEntry with an input stream.
	 * @param inputStream
	 */
	public AgEntry(String inputStream){
		//TODO: write AgEntry inputStream constructor
	}
	/**
	 * 
	 */
	public AgEntry(){
		this(null,"","",1);
	}
	/**
	 * @return the date
	 */
	public NewDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set.
	 */
	public void setDate(NewDate date) {
		this.date = date;
	}

	/**
	 * @return the subject.
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the content.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String toString(){
		String wholeEntry = new String();
		wholeEntry = this.date.toString() + "<" + subject + "> (" + priority + ") [" + content + "]";
		return wholeEntry;
		
	}

	@Override
	public int compareTo(Object other) {
		if(this.getDate().compareTo(((AgEntry)other).getDate()) == 1){
			return 1;
		}else if(this.getDate().compareTo(((AgEntry)other).getDate()) == -1){
			return -1;
		}else{
			if(this.getPriority() < ((AgEntry)other).priority){
				return -1;
			}else if(this.getPriority() > ((AgEntry)other).priority){
				return 1;
			}else{
				return 0;
			}
		}
	}
	

}
