package NewGui;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class addLection {
	private JComponent[]	inputs;
	private JLabel			addLanguage1Lbl;
	private JTextField		addLanguage1TF;

	/**
	 * create a window to add a new lection
	 */
	public addLection() {

		this.addLanguage1Lbl = new JLabel("Bitte geben Sie den Namen der Lektion ein");
		this.addLanguage1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addLanguage1Lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addLanguage1Lbl.setBounds(10, 11, 550, 28);

		this.addLanguage1TF = new JTextField();
		this.addLanguage1TF.setBounds(122, 50, 325, 28);
		this.inputs = new JComponent[] {
				this.addLanguage1Lbl, this.addLanguage1TF
		};

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

}
