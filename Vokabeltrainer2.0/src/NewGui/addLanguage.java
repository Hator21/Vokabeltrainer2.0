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

		this.addLanguage1Lbl = new JLabel("Bitte geben Sie die erste Sprache ein");
		this.addLanguage1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addLanguage1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addLanguage1Lbl.setBounds(10, 11, 550, 28);

		this.addLanguage1TF = new JTextField();
		this.addLanguage1TF.setBounds(122, 50, 325, 28);

		this.addPräfix1Lbl = new JLabel("Bitte geben Sie eine Abk\u00FCrzung f\u00FCr die erste Sprache ein");
		this.addPräfix1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addPräfix1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addPräfix1Lbl.setBounds(10, 89, 550, 28);

		this.addPräfix1TF = new JTextField();
		this.addPräfix1TF.setBounds(122, 128, 325, 28);

		this.addLanguage2Lbl = new JLabel("Bitte geben Sie die zweite Sprache ein");
		this.addLanguage2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addLanguage2Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addLanguage2Lbl.setBounds(10, 167, 550, 28);

		this.addLanguage2TF = new JTextField();
		this.addLanguage2TF.setBounds(122, 206, 325, 28);

		this.addPräfix2Lbl = new JLabel("Bitte geben Sie eine Abk\u00FCrzung f\u00FCr die zweite Sprache ein");
		this.addPräfix2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addPräfix2Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addPräfix2Lbl.setBounds(10, 245, 550, 28);

		this.addPräfix2TF = new JTextField();
		this.addPräfix2TF.setBounds(122, 284, 325, 28);

		this.inputs = new JComponent[] {
				this.addLanguage1Lbl, this.addLanguage1TF, this.addPräfix1Lbl, this.addPräfix1TF, this.addPräfix1TF, this.addLanguage2Lbl, this.addLanguage2TF, this.addPräfix2Lbl, this.addPräfix2TF
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
	 * @return the addPräfix1TF
	 */
	public JTextField getAddPräfix1TF() {
		return this.addPräfix1TF;
	}

	/**
	 * @param addPräfix1TF
	 *            the addPräfix1TF to set
	 */
	public void setAddPräfix1TF(JTextField addPräfix1TF) {
		this.addPräfix1TF = addPräfix1TF;
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
	 * @return the addPräfix2TF
	 */
	public JTextField getAddPräfix2TF() {
		return this.addPräfix2TF;
	}

	/**
	 * @param addPräfix2TF
	 *            the addPräfix2TF to set
	 */
	public void setAddPräfix2TF(JTextField addPräfix2TF) {
		this.addPräfix2TF = addPräfix2TF;
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
	 * @return the addPräfix1Lbl
	 */
	public JLabel getAddPräfix1Lbl() {
		return this.addPräfix1Lbl;
	}

	/**
	 * @param addPräfix1Lbl
	 *            the addPräfix1Lbl to set
	 */
	public void setAddPräfix1Lbl(JLabel addPräfix1Lbl) {
		this.addPräfix1Lbl = addPräfix1Lbl;
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
	 * @return the addPräfix2Lbl
	 */
	public JLabel getAddPräfix2Lbl() {
		return this.addPräfix2Lbl;
	}

	/**
	 * @param addPräfix2Lbl
	 *            the addPräfix2Lbl to set
	 */
	public void setAddPräfix2Lbl(JLabel addPräfix2Lbl) {
		this.addPräfix2Lbl = addPräfix2Lbl;
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
