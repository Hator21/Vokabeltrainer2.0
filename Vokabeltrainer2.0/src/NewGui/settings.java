package NewGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class settings extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settings frame = new settings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public settings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setBounds(107, 192, 200, 26);
		panel.add(slider);
		
		JLabel lblNewLabel = new JLabel("Zeit");
		lblNewLabel.setBounds(191, 156, 69, 20);
		panel.add(lblNewLabel);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBounds(107, 114, 200, 26);
		panel.add(slider_1);
		
		JLabel lblAnzahlVokabel = new JLabel("Anzahl Vokabel");
		lblAnzahlVokabel.setBounds(150, 78, 120, 20);
		panel.add(lblAnzahlVokabel);
		
		JCheckBox chckbxDeutschenglisch = new JCheckBox("Deutsch-Englisch");
		chckbxDeutschenglisch.setBounds(46, 37, 153, 29);
		panel.add(chckbxDeutschenglisch);
		
		JCheckBox chckbxEnglischdeutsch = new JCheckBox("Englisch-Deutsch");
		chckbxEnglischdeutsch.setBounds(206, 37, 153, 29);
		panel.add(chckbxEnglischdeutsch);
	}
}
