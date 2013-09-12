package structure;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class NewFrame extends JFrame {

	private JTextField inputField;
	private JTextArea inputArea;
	private InputHandler inpHandler;
	private JLabel dateLabel;
	private JLabel subjectLabel;
	private Agenda sourceAgenda;
	
	public NewFrame(int sizeX, Agenda source){
		super("AgLi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		KeyHandler kHandler = new KeyHandler();
		//EnterHandler handler = new EnterHandler();

		inputField = new JTextField(sizeX);
		add(inputField);
		inputField.addKeyListener(kHandler);

		inputArea = new JTextArea(sizeX, sizeX*2);
		add(inputArea);
		inputArea.setEditable(false);
		
		dateLabel = new JLabel();
		add(dateLabel);
		
		subjectLabel = new JLabel();
		add(subjectLabel);
		
		inpHandler = new InputHandler(this);
		this.sourceAgenda = source;
	}

	private class KeyHandler implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent kEvent) {

		}
		@Override
		public void keyReleased(KeyEvent kEvent) {
			inpHandler.handleInput(kEvent.getKeyChar());
		}


		@Override
		public void keyTyped(KeyEvent kEvent) {


		}
	}
	private class EnterHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String string = "";
			if(event.getSource()==inputField){
				string = String.format("test: %s", event.getActionCommand());
			}

		}
	}

	/**
	 * @return the sourceAgenda
	 */
	public Agenda getSourceAgenda() {
		return sourceAgenda;
	}
	/**
	 * @param sourceAgenda the sourceAgenda to set
	 */
	public void setSourceAgenda(Agenda sourceAgenda) {
		this.sourceAgenda = sourceAgenda;
	}
	
	/**
	 * @return the inputField
	 */
	public JTextField getInputField() {
		return inputField;
	}
	/**
	 * @param inputField the inputField to set
	 */
	public void setInputField(JTextField inputField) {
		this.inputField = inputField;
	}
	/**
	 * @return the inputArea
	 */
	public JTextArea getInputArea() {
		return inputArea;
	}
	/**
	 * @param inputArea the inputArea to set
	 */
	public void setInputArea(JTextArea inputArea) {
		this.inputArea = inputArea;
	}
	/**
	 * @return the dateLabel
	 */
	public JLabel getSubjectLabel() {
		return subjectLabel;
	}
	/**
	 * @param dateLabel the dateLabel to set
	 */
	public void setSubjectLabel(JLabel subjectLabel) {
		this.subjectLabel = subjectLabel;
	}
	
	/**
	 * @return the dateLabel
	 */
	public JLabel getDateLabel() {
		return dateLabel;
	}
	/**
	 * @param dateLabel the dateLabel to set
	 */
	public void setDateLabel(JLabel dateLabel) {
		this.dateLabel = dateLabel;
	}
}
