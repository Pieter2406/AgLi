package structure;

import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JOptionPane;

/**
 * This class handles the events on keypresses in the mainframe.
 * @author Pieter
 *
 */
public class InputHandler {

	private static final char KEY_DOLLAR = 36;
	private static final char KEY_COLON = 58;
	private static final char KEY_SINGLE_QUOTE = 39;
	private static final char KEY_EXCLAMATION_POINT = 33;

	private boolean hasDate = false;
	private boolean hasSubject = false;

	private NewFrame frame;
	private int tempKeyCode;
	private AgEntry tempEntry;

	public InputHandler(NewFrame frame){
		this.frame = frame;
		tempKeyCode = 0;
	}
	public void handleInput(char inputChar){
		/*
		 * Event on $$ signs 
		 */
		if(inputChar == KEY_DOLLAR){
			DollarInput(inputChar);
		}else if(inputChar == KEY_SINGLE_QUOTE){
			SingleQuoteInput(inputChar);
		}else if(inputChar == KEY_COLON){
			ColonInput(inputChar);
		}else if(inputChar == KEY_EXCLAMATION_POINT){
			ExclamationPointInput(inputChar);
		}
	}
	/**
	 * 
	 * @param inputChar
	 */
	private void ExclamationPointInput(char inputChar) {


	}
	/**
	 * 
	 * @param inputChar
	 */
	private void ColonInput(char inputChar) {
		if(hasDate == false){
			this.tempEntry = new AgEntry();
			NewDate date = new NewDate();
			String[] dayMonthYear = frame.getInputField().getText().replace(":", "").split("/");
			if(dayMonthYear.length == 1){
				date.setMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
			}else{
				date.setMonth(Integer.parseInt(dayMonthYear[1]));
			}
			if(dayMonthYear.length == 3){
				date.setYear(Integer.parseInt(dayMonthYear[2]));
			}else{
				date.setYear(Calendar.getInstance().get(Calendar.YEAR));
			}
			date.setDay(Integer.parseInt(dayMonthYear[0]));

			tempEntry.setDate(date);
			frame.getDateLabel().setText(tempEntry.getDate().getDay() + "/" + tempEntry.getDate().getIntMonth() + "/" + tempEntry.getDate().getYear());
			frame.getInputArea().setText(frame.getInputArea().getText() + "\n" + tempEntry.getDate().getDay() + "/" + tempEntry.getDate().getIntMonth() + "/" + tempEntry.getDate().getYear() + ": ");
			frame.getInputField().setText("");
			hasDate = true;
		}

	}
	/**
	 * 
	 * @param inputChar
	 */
	private void SingleQuoteInput(char inputChar) {
		if(hasSubject == false){
			if(tempKeyCode == KEY_SINGLE_QUOTE){
				String subject = frame.getInputField().getText().replace("'", "");
				frame.getSubjectLabel().setText(subject);
				frame.getInputField().setText("");
				frame.getInputArea().setText(frame.getInputArea().getText() + subject + ": ");
				tempKeyCode = 0;
				hasSubject = true;
			}else{
				tempKeyCode = KEY_SINGLE_QUOTE;
			}
		}
	}
	/**
	 * 
	 * @param inputChar
	 */
	private void DollarInput(char inputChar){
		if(tempKeyCode == KEY_DOLLAR){
			tempKeyCode = 0;
			frame.getInputArea().setText((frame.getInputArea().getText() + frame.getInputField().getText()).replace("$", ""));
			frame.getInputField().setText("");
			/*
			 * Na laatste dollarteken is de entry compleet en worden de booleans terug op false gezet.
			 */
			hasDate = false;
			hasSubject = false;
		}else{
			tempKeyCode = KEY_DOLLAR;
		}
	}


}
