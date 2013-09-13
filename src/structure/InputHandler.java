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

	private static final boolean DEBUG = false;

	private boolean hasDate = false;
	private boolean hasSubject = false;
	private boolean hasPriority = false;

	private NewFrame frame;
	private int tempKeyCode;
	private AgEntry tempEntry;

	public InputHandler(NewFrame frame){
		this.frame = frame;
		tempKeyCode = 0;
	}
	public void handleInput(char inputChar){
		if(inputChar == KEY_DOLLAR){
			DollarInput(inputChar);
		}else if(inputChar == KEY_SINGLE_QUOTE){
			SingleQuoteInput(inputChar);
		}else if(inputChar == KEY_COLON){
			ColonInput(inputChar);
		}else if(inputChar == KEY_EXCLAMATION_POINT){
			ExclamationPointInput(inputChar);
		}else{
			if(tempKeyCode == KEY_DOLLAR){
				tempKeyCode = 0;
			}
		}
	}
	/**
	 * 
	 * @param inputChar
	 */
	private void ExclamationPointInput(char inputChar) {
		if(!hasPriority){
			if(tempKeyCode == KEY_EXCLAMATION_POINT){
				String[] tempS = frame.getInputField().getText().split("!");
				for(int i = 0; i < tempS.length; i++){
					if(tempS[i].length() < 3 && tempS[i].length() > 0){
						tempEntry.setPriority(Integer.parseInt(tempS[i]));
						hasPriority = true;
						frame.getInputField().setText(frame.getInputField().getText().replace("!" + tempEntry.getPriority() + "!", ""));
						break;
					}
				}
				if(DEBUG == true){
					frame.getPriorityLabel().setText(tempEntry.getPriority() + "");
				}
			}else{
				tempKeyCode = KEY_EXCLAMATION_POINT;
			}
		}

	}
	/**
	 * 
	 * @param inputChar
	 */
	private void ColonInput(char inputChar) {
		if(!hasDate){
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
			frame.getInputField().setText("");

			tempEntry.setDate(date);
			hasDate = true;
			/*
			 * DEBUG FRAME
			 */
			if(DEBUG == true){
				frame.getDateLabel().setText(tempEntry.getDate().getDay() + "/" + tempEntry.getDate().getIntMonth() + "/" + tempEntry.getDate().getYear());
				frame.getInputArea().setText(frame.getInputArea().getText() + "\n" + tempEntry.getDate().getDay() + "/" + tempEntry.getDate().getIntMonth() + "/" + tempEntry.getDate().getYear() + ": ");
			}

		}

	}
	/**
	 * 
	 * @param inputChar
	 */
	private void SingleQuoteInput(char inputChar) {
		if(!hasSubject){
			if(tempKeyCode == KEY_SINGLE_QUOTE){
				String subject = frame.getInputField().getText().replace("'", "");
				frame.getInputField().setText("");
				tempEntry.setSubject(subject);
				tempKeyCode = 0;
				hasSubject = true;
				/*
				 * DEBUG FRAME
				 */
				if(DEBUG == true){
					frame.getSubjectLabel().setText(subject);
					frame.getInputArea().setText(frame.getInputArea().getText() + tempEntry.getSubject() + ": ");
				}

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
			tempEntry.setContent((frame.getInputArea().getText() + frame.getInputField().getText()).replace("$", ""));
			/*
			 * Na laatste dollarteken is de entry compleet en worden de booleans terug op false gezet.
			 */
			
			frame.getInputArea().setText(tempEntry.toString());
			frame.getSourceAgenda().getCalendar().AddEntry(tempEntry);
			Reset();
			/*
			 * DEBUG FRAME
			 */
			if(DEBUG == true){
				frame.getInputArea().setText((frame.getInputArea().getText() + frame.getInputField().getText()).replace("$", ""));
			}


		}else{
			tempKeyCode = KEY_DOLLAR;
		}
	}
	private void Reset(){
		hasDate = false;
		hasSubject = false;
		hasPriority = false;
		tempEntry = new AgEntry();
		frame.getInputField().setText("");
	}


}
