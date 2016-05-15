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

		this.addLanguage1Lbl = new JLabel("Bitte geben Sie die erste Sprache ein");
		this.addLanguage1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addLanguage1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addLanguage1Lbl.setBounds(10, 11, 550, 28);

		this.addLanguage1TF = new JTextField();
		this.addLanguage1TF.setBounds(122, 50, 325, 28);

		this.addPr�fix1Lbl = new JLabel("Bitte geben Sie eine Abk\u00FCrzung f\u00FCr die erste Sprache ein");
		this.addPr�fix1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addPr�fix1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addPr�fix1Lbl.setBounds(10, 89, 550, 28);

		this.addPr�fix1TF = new JTextField();
		this.addPr�fix1TF.setBounds(122, 128, 325, 28);

		this.addLanguage2Lbl = new JLabel("Bitte geben Sie die zweite Sprache ein");
		this.addLanguage2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addLanguage2Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addLanguage2Lbl.setBounds(10, 167, 550, 28);

		this.addLanguage2TF = new JTextField();
		this.addLanguage2TF.setBounds(122, 206, 325, 28);

		this.addPr�fix2Lbl = new JLabel("Bitte geben Sie eine Abk\u00FCrzung f\u00FCr die zweite Sprache ein");
		this.addPr�fix2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addPr�fix2Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addPr�fix2Lbl.setBounds(10, 245, 550, 28);

		this.addPr�fix2TF = new JTextField();
		this.addPr�fix2TF.setBounds(122, 284, 325, 28);

		this.inputs = new JComponent[] {
				this.addLanguage1Lbl, this.addLanguage1TF, this.addPr�fix1Lbl, this.addPr�fix1TF, this.addPr�fix1TF, this.addLanguage2Lbl, this.addLanguage2TF, this.addPr�fix2Lbl, this.addPr�fix2TF
		};
	}

	/**
	 * @return the addLanguage1TF
	 */
	public JTextField getAddLanguage1TF() {
		return this.addLanguage1TF;
	}

	/**
	 * @param addLanguage1TF
	 *            the addLanguage1TF to set
	 */
	public void setAddLanguage1TF(JTextField addLanguage1TF) {
		this.addLanguage1TF = addLanguage1TF;
	}

	/**
	 * @return the addPr�fix1TF
	 */
	public JTextField getAddPr�fix1TF() {
		return this.addPr�fix1TF;
	}

	/**
	 * @param addPr�fix1TF
	 *            the addPr�fix1TF to set
	 */
	public void setAddPr�fix1TF(JTextField addPr�fix1TF) {
		this.addPr�fix1TF = addPr�fix1TF;
	}

	/**
	 * @return the addLanguage2TF
	 */
	public JTextField getAddLanguage2TF() {
		return this.addLanguage2TF;
	}

	/**
	 * @param addLanguage2TF
	 *            the addLanguage2TF to set
	 */
	public void setAddLanguage2TF(JTextField addLanguage2TF) {
		this.addLanguage2TF = addLanguage2TF;
	}

	/**
	 * @return the addPr�fix2TF
	 */
	public JTextField getAddPr�fix2TF() {
		return this.addPr�fix2TF;
	}

	/**
	 * @param addPr�fix2TF
	 *            the addPr�fix2TF to set
	 */
	public void setAddPr�fix2TF(JTextField addPr�fix2TF) {
		this.addPr�fix2TF = addPr�fix2TF;
	}

	/**
	 * @return the addLanguage1Lbl
	 */
	public JLabel getAddLanguage1Lbl() {
		return this.addLanguage1Lbl;
	}

	/**
	 * @param addLanguage1Lbl
	 *            the addLanguage1Lbl to set
	 */
	public void setAddLanguage1Lbl(JLabel addLanguage1Lbl) {
		this.addLanguage1Lbl = addLanguage1Lbl;
	}

	/**
	 * @return the addPr�fix1Lbl
	 */
	public JLabel getAddPr�fix1Lbl() {
		return this.addPr�fix1Lbl;
	}

	/**
	 * @param addPr�fix1Lbl
	 *            the addPr�fix1Lbl to set
	 */
	public void setAddPr�fix1Lbl(JLabel addPr�fix1Lbl) {
		this.addPr�fix1Lbl = addPr�fix1Lbl;
	}

	/**
	 * @return the addLanguage2Lbl
	 */
	public JLabel getAddLanguage2Lbl() {
		return this.addLanguage2Lbl;
	}

	/**
	 * @param addLanguage2Lbl
	 *            the addLanguage2Lbl to set
	 */
	public void setAddLanguage2Lbl(JLabel addLanguage2Lbl) {
		this.addLanguage2Lbl = addLanguage2Lbl;
	}

	/**
	 * @return the addPr�fix2Lbl
	 */
	public JLabel getAddPr�fix2Lbl() {
		return this.addPr�fix2Lbl;
	}

	/**
	 * @param addPr�fix2Lbl
	 *            the addPr�fix2Lbl to set
	 */
	public void setAddPr�fix2Lbl(JLabel addPr�fix2Lbl) {
		this.addPr�fix2Lbl = addPr�fix2Lbl;
	}

	/**
	 * @return the inputs
	 */
	public JComponent[] getInputs() {
		return this.inputs;
	}

	/**
	 * @param inputs
	 *            the inputs to set
	 */
	public void setInputs(JComponent[] inputs) {
		this.inputs = inputs;
	}

}
