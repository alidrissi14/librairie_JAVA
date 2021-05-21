package librairie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComboBox;
@SuppressWarnings("serial")
public class ClientFrame extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private JTable clientTable;
	
	protected static ArrayList<Client> clientList;
	
	protected static DefaultTableModel dtmC;

	/**
	 * Create the frame.
	 */
	
	public ClientFrame() {
		
		initialize();
		//clientList = new ArrayList<>();
		clientTable.setModel(GUI.dtmC);					//set clientTable model
		
		
			
	
	}
	
	private void initialize()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 798, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 762, 47);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Clients");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 63, 375, 36);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Liste des clients");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 110, 365, 337);
		contentPane.add(scrollPane);
		
		clientTable = new JTable();													//table with clients info
		scrollPane.setViewportView(clientTable);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(447, 208, 311, 81);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton addClientButton = new JButton("Ajouter Un Client");
		addClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {							//open add client frame when clicked
				AddClient addclient = new AddClient();
				addclient.setVisible(true);
			}
		});
		addClientButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_2.add(addClientButton);
		
		frame.add(contentPane);
	}
}
