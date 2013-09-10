package structure;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Pieter
 *
 * This class holds an entry of an agenda item.
 */
public class AgEntry {
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
	 * Initializes an agenda entry with a given date, subject and the content of the agenda entry
	 * @param date	A given day with or without a given month and with or without a given year.
	 * @param subject	The subject of the agenda entry.
	 * @param content	The content of the agenda entry.
	 */
	public AgEntry(NewDate date, String subject, String content) {
		this.date = date;
		this.subject = subject;
		this.content = content;
	}
	
	/**
	 * Initializes an agenda entry with a given date, an empty subject and the content of the agenda entry.
	 * @param date		A given day with or without a given month and with or without a given year.
	 * @param content	The content of the agenda entry.
	 */
	
	public AgEntry(NewDate date, String content){
		this(date,"",content);
	}
	
	/**
	 * Initializes an agenda entry with a given content. The date is set to the current date of making.
	 * @param content	The content of the agenda entry.
	 */
	public AgEntry(String content){
		this.content = content;
		this.date = new NewDate(Calendar.DATE);
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
	
	

}
