package NewGui;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class addLection {
	private JComponent[] inputs;	
	private JLabel addLanguage1Lbl;
	private JTextField addLanguage1TF;

	public addLection(){

		addLanguage1Lbl = new JLabel("Bitte geben Sie den Namen der Lektion ein");
		addLanguage1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLanguage1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addLanguage1Lbl.setBounds(10, 11, 550, 28);

		addLanguage1TF = new JTextField();
		addLanguage1TF.setBounds(122, 50, 325, 28);
		inputs = new JComponent[]{addLanguage1Lbl, addLanguage1TF};
		
	}
	public JComponent[] getInputs() {
		return inputs;
	}

	public JTextField getAddLanguage1TF() {
		return addLanguage1TF;
	}

	public void setAddLanguage1TF(JTextField addLanguage1TF) {
		this.addLanguage1TF = addLanguage1TF;
	}
	public JLabel getAddLanguage1Lbl() {
		return addLanguage1Lbl;
	}
	public void setAddLanguage1Lbl(JLabel addLanguage1Lbl) {
		this.addLanguage1Lbl = addLanguage1Lbl;
	}
	public void setInputs(JComponent[] inputs) {
		this.inputs = inputs;
	}
	

}
