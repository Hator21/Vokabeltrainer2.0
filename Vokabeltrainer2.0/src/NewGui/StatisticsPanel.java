package NewGui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class StatisticsPanel extends JPanel {
	private MainFrame			frame;
	private BufferedImage		image;
	private JTable				table;
	private CustomTableModel	tableModel;
	private JScrollPane			scrollPane;
	private String[]			columnNames	= {
			"Datum", "Sprache", "Richtig", "Falsch", "Note"
	};
	private JPanel				tablePanel;

	public StatisticsPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiﬂ.png"));
		} catch (IOException ex) {}

		this.tablePanel = new JPanel();
		this.tablePanel.setLayout(new GridLayout(1, 0));
		this.tablePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.tablePanel.setBounds(1, 1, 1026, 642);
		this.add(this.tablePanel);

		this.tableModel = new CustomTableModel(this.columnNames, 0);
		this.table = new JTable(this.tableModel);
		this.table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		this.table.setFillsViewportHeight(true);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(300);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(117);
		this.scrollPane = new JScrollPane(this.table);
		this.tablePanel.add(this.scrollPane);
	}

	public static class CustomTableModel extends DefaultTableModel {

		public CustomTableModel(String[] a, int b) {
			super(a, b);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * @return the tableModel
	 */
	public CustomTableModel getTableModel() {
		return tableModel;
	}

	/**
	 * @param tableModel
	 *            the tableModel to set
	 */
	public void setTableModel(CustomTableModel tableModel) {
		this.tableModel = tableModel;
	}

}
