package librairie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddClient extends JFrame {

	private JFrame frame;
	
	private JPanel contentPane;
	private JTextField prenomText;
	private JTextField adresseText;
	private JTextField emailText;
	private JTextField numText;
	private JTextField nomText;
	private JTextField telephoneText;
	
	
	private JButton validerButton;

	public AddClient() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Ajouter un client");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 763, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 11, 597, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un client");
		lblNewLabel.setBounds(0, 0, 597, 101);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 131, 727, 313);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Num\u00E9ro Client");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		numText = new JTextField();
		numText.addKeyListener(new KeyAdapter() {
			@Override																		//only allow numbers in textfield
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		numText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(numText);
		numText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nom");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);
		
		nomText = new JTextField();
		nomText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(nomText);
		nomText.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pr\u00E9nom");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		
		prenomText = new JTextField();
		prenomText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(prenomText);
		prenomText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Adresse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		adresseText = new JTextField();
		adresseText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(adresseText);
		adresseText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(emailText);
		emailText.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("T\u00E9l\u00E9phone");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);
		
		telephoneText = new JTextField();
		telephoneText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))       //only allow numbers in textfield
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		telephoneText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(telephoneText);
		telephoneText.setColumns(10);
		
		validerButton = new JButton("Valider");
		validerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * force user to enter all info
				 */
				if(numText.getText().length()== 0 || nomText.getText().length() == 0 || prenomText.getText().length()==0 || adresseText.getText().length() == 0 || emailText.getText().length()==0 || telephoneText.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !!");
				}
				else
				{
					int num = Integer.parseInt(numText.getText());
					String nom = nomText.getText();
					String prenom = prenomText.getText();
					String adresse = adresseText.getText();
					String email = emailText.getText();
					long telephone = Long.parseLong(telephoneText.getText());
					int exists = 0;
					
					GUI.dtmC.setRowCount(0);
					for(int i = 0; i<GUI.clientList.size(); i++)
					{
						if(num == GUI.clientList.get(i).num_compte)
						{
							JOptionPane.showMessageDialog(null, "Ce client existe déjà");				//show message when client already exists
							exists = 1;
							break;
						}
					}
					if(exists == 0)
						GUI.clientList.add(new Client(num, nom, prenom, adresse, email, telephone));	//create new client and add his info to clientList
					GUI.dtmC.setRowCount(0);
					GUI.populateClients();																//show info in clientTable
					clearFields();
				}
			}
		});
		validerButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		validerButton.setBounds(171, 455, 399, 59);
		contentPane.add(validerButton);
		frame.add(contentPane);
	}
	
	private void clearFields()
	{
		numText.requestFocus();
		numText.setText("");
		nomText.setText("");
		prenomText.setText("");
		adresseText.setText("");
		emailText.setText("");
		telephoneText.setText("");
	}
}
