package structure;

import java.awt.event.KeyEvent;

/**
 * This class handles the events on keypresses in the mainframe.
 * @author Pieter
 *
 */
public class InputHandler {
	private NewFrame frame;
	private int tempKeyCode;
	private static final char KEY_DOLLAR = 36;
	public InputHandler(NewFrame frame){
		this.frame = frame;
		tempKeyCode = 0;
	}
	public void handleInput(char inputChar){
		/*
		 * Event on $$ signs 
		 */
		if(inputChar == KEY_DOLLAR){
			if(tempKeyCode == KEY_DOLLAR){
				tempKeyCode = 0;
				frame.getInputArea().setText((frame.getInputArea().getText() + "\n" + frame.getInputField().getText()).replace("$", ""));
				frame.getInputField().setText("");
			}else{
				tempKeyCode = KEY_DOLLAR;
			}
		}else{
			if(tempKeyCode == KEY_DOLLAR){
				tempKeyCode = 0;
			}
		}
	}
	
}
