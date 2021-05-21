package librairie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class HistoryFrame extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTable historyTable;

	
	public HistoryFrame() {
		init();
		historyTable.setModel(GUI.dtmH);
	}
	
	public void init()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 655, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Journal d'achats");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 608, 64);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 86, 598, 376);
		contentPane.add(scrollPane);
		
		historyTable = new JTable();
		scrollPane.setViewportView(historyTable);
	}
}
