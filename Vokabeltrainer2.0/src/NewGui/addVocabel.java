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

	public addVocabel(String sprache1, String sprache2) {
		addVocabelOLLbl = new JLabel("Bitte geben Sie die Vokabel für Sprache " + sprache1 + " ein");
		addVocabelOLLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addVocabelOLLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addVocabelOLLbl.setBounds(10, 11, 550, 28);

		addVocabelOLTF = new JTextField();
		addVocabelOLTF.setBounds(122, 50, 325, 28);

		addVocabelDLLbl = new JLabel("Bitte geben Sie die Vokabel für Sprache " + sprache2 + " ein");
		addVocabelDLLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addVocabelDLLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addVocabelDLLbl.setBounds(10, 89, 550, 28);

		addVocabelDLTF = new JTextField();
		addVocabelDLTF.setBounds(122, 128, 325, 28);

		setInputs(new JComponent[] {
				addVocabelOLLbl, addVocabelOLTF, addVocabelDLLbl, addVocabelDLTF
		});
	}

	public JComponent[] getInputs() {
		return inputs;
	}

	public void setInputs(JComponent[] inputs) {
		this.inputs = inputs;
	}

	public JTextField getAddVocabelOLTF() {
		return addVocabelOLTF;
	}

	public void setAddVocabelOLTF(JTextField addVocabelOLTF) {
		this.addVocabelOLTF = addVocabelOLTF;
	}

	public JTextField getAddVocabelDLTF() {
		return addVocabelDLTF;
	}

	public void setAddVocabelDLTF(JTextField addVocabelDLTF) {
		this.addVocabelDLTF = addVocabelDLTF;
	}

}
