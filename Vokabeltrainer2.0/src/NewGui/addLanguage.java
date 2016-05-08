package NewGui;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class addLanguage {
	private JTextField		addLanguage1TF;
	private JTextField		addPr�fix1TF;
	private JTextField		addLanguage2TF;
	private JTextField		addPr�fix2TF;
	JLabel					addLanguage1Lbl, addPr�fix1Lbl, addLanguage2Lbl, addPr�fix2Lbl;
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

		addPr�fix1Lbl = new JLabel("Bitte geben Sie eine Abk\u00FCrzung f\u00FCr die erste Sprache ein");
		addPr�fix1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addPr�fix1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addPr�fix1Lbl.setBounds(10, 89, 550, 28);

		addPr�fix1TF = new JTextField();
		addPr�fix1TF.setBounds(122, 128, 325, 28);

		addLanguage2Lbl = new JLabel("Bitte geben Sie die zweite Sprache ein");
		addLanguage2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLanguage2Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addLanguage2Lbl.setBounds(10, 167, 550, 28);

		addLanguage2TF = new JTextField();
		addLanguage2TF.setBounds(122, 206, 325, 28);

		addPr�fix2Lbl = new JLabel("Bitte geben Sie eine Abk\u00FCrzung f\u00FCr die zweite Sprache ein");
		addPr�fix2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addPr�fix2Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addPr�fix2Lbl.setBounds(10, 245, 550, 28);

		addPr�fix2TF = new JTextField();
		addPr�fix2TF.setBounds(122, 284, 325, 28);

		inputs = new JComponent[] {
				addLanguage1Lbl, addLanguage1TF, addPr�fix1Lbl, addPr�fix1TF, addPr�fix1TF, addLanguage2Lbl, addLanguage2TF, addPr�fix2Lbl, addPr�fix2TF
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

	public JTextField getAddPr�fix1TF() {
		return addPr�fix1TF;
	}

	public void setAddPr�fix1TF(JTextField addPr�fix1TF) {
		this.addPr�fix1TF = addPr�fix1TF;
	}

	public JTextField getAddLanguage2TF() {
		return addLanguage2TF;
	}

	public void setAddLanguage2TF(JTextField addLanguage2TF) {
		this.addLanguage2TF = addLanguage2TF;
	}

	public JTextField getAddPr�fix2TF() {
		return addPr�fix2TF;
	}

	public void setAddPr�fix2TF(JTextField addPr�fix2TF) {
		this.addPr�fix2TF = addPr�fix2TF;
	}

	public JLabel getAddLanguage1Lbl() {
		return addLanguage1Lbl;
	}

	public void setAddLanguage1Lbl(JLabel addLanguage1Lbl) {
		this.addLanguage1Lbl = addLanguage1Lbl;
	}

	public JLabel getAddPr�fix1Lbl() {
		return addPr�fix1Lbl;
	}

	public void setAddPr�fix1Lbl(JLabel addPr�fix1Lbl) {
		this.addPr�fix1Lbl = addPr�fix1Lbl;
	}

	public JLabel getAddLanguage2Lbl() {
		return addLanguage2Lbl;
	}

	public void setAddLanguage2Lbl(JLabel addLanguage2Lbl) {
		this.addLanguage2Lbl = addLanguage2Lbl;
	}

	public JLabel getAddPr�fix2Lbl() {
		return addPr�fix2Lbl;
	}

	public void setAddPr�fix2Lbl(JLabel addPr�fix2Lbl) {
		this.addPr�fix2Lbl = addPr�fix2Lbl;
	}

	public void setInputs(JComponent[] inputs) {
		this.inputs = inputs;
	}

}
