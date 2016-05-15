package NewGui;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class addVocabel {

	private JLabel			addVocabelOLLbl;
	private JTextField		addVocabelOLTF;
	private JLabel			addVocabelDLLbl;
	private JTextField		addVocabelDLTF;
	private JComponent[]	inputs;

	/**
	 * create a window to add a new speach
	 * 
	 * @param sprache1
	 * @param sprache2
	 */
	public addVocabel(String sprache1, String sprache2) {
		this.addVocabelOLLbl = new JLabel("Bitte geben Sie die Vokabel für Sprache " + sprache1 + " ein");
		this.addVocabelOLLbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addVocabelOLLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addVocabelOLLbl.setBounds(10, 11, 550, 28);

		this.addVocabelOLTF = new JTextField();
		this.addVocabelOLTF.setBounds(122, 50, 325, 28);

		this.addVocabelDLLbl = new JLabel("Bitte geben Sie die Vokabel für Sprache " + sprache2 + " ein");
		this.addVocabelDLLbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.addVocabelDLLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.addVocabelDLLbl.setBounds(10, 89, 550, 28);

		this.addVocabelDLTF = new JTextField();
		this.addVocabelDLTF.setBounds(122, 128, 325, 28);

		this.setInputs(new JComponent[] {
				this.addVocabelOLLbl, this.addVocabelOLTF, this.addVocabelDLLbl, this.addVocabelDLTF
		});
	}

	/**
	 * @return the addVocabelOLLbl
	 */
	public JLabel getAddVocabelOLLbl() {
		return this.addVocabelOLLbl;
	}

	/**
	 * @param addVocabelOLLbl
	 *            the addVocabelOLLbl to set
	 */
	public void setAddVocabelOLLbl(JLabel addVocabelOLLbl) {
		this.addVocabelOLLbl = addVocabelOLLbl;
	}

	/**
	 * @return the addVocabelOLTF
	 */
	public JTextField getAddVocabelOLTF() {
		return this.addVocabelOLTF;
	}

	/**
	 * @param addVocabelOLTF
	 *            the addVocabelOLTF to set
	 */
	public void setAddVocabelOLTF(JTextField addVocabelOLTF) {
		this.addVocabelOLTF = addVocabelOLTF;
	}

	/**
	 * @return the addVocabelDLLbl
	 */
	public JLabel getAddVocabelDLLbl() {
		return this.addVocabelDLLbl;
	}

	/**
	 * @param addVocabelDLLbl
	 *            the addVocabelDLLbl to set
	 */
	public void setAddVocabelDLLbl(JLabel addVocabelDLLbl) {
		this.addVocabelDLLbl = addVocabelDLLbl;
	}

	/**
	 * @return the addVocabelDLTF
	 */
	public JTextField getAddVocabelDLTF() {
		return this.addVocabelDLTF;
	}

	/**
	 * @param addVocabelDLTF
	 *            the addVocabelDLTF to set
	 */
	public void setAddVocabelDLTF(JTextField addVocabelDLTF) {
		this.addVocabelDLTF = addVocabelDLTF;
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
