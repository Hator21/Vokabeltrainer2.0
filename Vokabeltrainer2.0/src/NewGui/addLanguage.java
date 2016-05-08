package NewGui;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class addLanguage {
	private JTextField		addLanguage1TF;
	private JTextField		addPräfix1TF;
	private JTextField		addLanguage2TF;
	private JTextField		addPräfix2TF;
	JLabel					addLanguage1Lbl, addPräfix1Lbl, addLanguage2Lbl, addPräfix2Lbl;
	private JComponent[]	inputs;

	/**
	 * Create the frame.
	 */
	public addLanguage() {

		addLanguage1Lbl = new JLabel("Bitte geben Sie die erste Sprache ein");
		addLanguage1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLanguage1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addLanguage1Lbl.setBounds(10, 11, 550, 28);

		addLanguage1TF = new JTextField();
		addLanguage1TF.setBounds(122, 50, 325, 28);

		addPräfix1Lbl = new JLabel("Bitte geben Sie eine Abk\u00FCrzung f\u00FCr die erste Sprache ein");
		addPräfix1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addPräfix1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addPräfix1Lbl.setBounds(10, 89, 550, 28);

		addPräfix1TF = new JTextField();
		addPräfix1TF.setBounds(122, 128, 325, 28);

		addLanguage2Lbl = new JLabel("Bitte geben Sie die zweite Sprache ein");
		addLanguage2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLanguage2Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addLanguage2Lbl.setBounds(10, 167, 550, 28);

		addLanguage2TF = new JTextField();
		addLanguage2TF.setBounds(122, 206, 325, 28);

		addPräfix2Lbl = new JLabel("Bitte geben Sie eine Abk\u00FCrzung f\u00FCr die zweite Sprache ein");
		addPräfix2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addPräfix2Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addPräfix2Lbl.setBounds(10, 245, 550, 28);

		addPräfix2TF = new JTextField();
		addPräfix2TF.setBounds(122, 284, 325, 28);

		inputs = new JComponent[] {
				addLanguage1Lbl, addLanguage1TF, addPräfix1Lbl, addPräfix1TF, addPräfix1TF, addLanguage2Lbl, addLanguage2TF, addPräfix2Lbl, addPräfix2TF
		};
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

	public JTextField getAddPräfix1TF() {
		return addPräfix1TF;
	}

	public void setAddPräfix1TF(JTextField addPräfix1TF) {
		this.addPräfix1TF = addPräfix1TF;
	}

	public JTextField getAddLanguage2TF() {
		return addLanguage2TF;
	}

	public void setAddLanguage2TF(JTextField addLanguage2TF) {
		this.addLanguage2TF = addLanguage2TF;
	}

	public JTextField getAddPräfix2TF() {
		return addPräfix2TF;
	}

	public void setAddPräfix2TF(JTextField addPräfix2TF) {
		this.addPräfix2TF = addPräfix2TF;
	}

	public JLabel getAddLanguage1Lbl() {
		return addLanguage1Lbl;
	}

	public void setAddLanguage1Lbl(JLabel addLanguage1Lbl) {
		this.addLanguage1Lbl = addLanguage1Lbl;
	}

	public JLabel getAddPräfix1Lbl() {
		return addPräfix1Lbl;
	}

	public void setAddPräfix1Lbl(JLabel addPräfix1Lbl) {
		this.addPräfix1Lbl = addPräfix1Lbl;
	}

	public JLabel getAddLanguage2Lbl() {
		return addLanguage2Lbl;
	}

	public void setAddLanguage2Lbl(JLabel addLanguage2Lbl) {
		this.addLanguage2Lbl = addLanguage2Lbl;
	}

	public JLabel getAddPräfix2Lbl() {
		return addPräfix2Lbl;
	}

	public void setAddPräfix2Lbl(JLabel addPräfix2Lbl) {
		this.addPräfix2Lbl = addPräfix2Lbl;
	}

	public void setInputs(JComponent[] inputs) {
		this.inputs = inputs;
	}

}
