package librairie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class SellFrame extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTable panierTable;
	private JTextField quantiteText;
	private static JLabel panierLabel;
	private JButton ajouterButton;
	
	private static JComboBox<String> titreCombo;
	private static JComboBox<String> clientCombo;
	private static JComboBox<String> typeCombo;
	private DefaultComboBoxModel dcmType;
	private DefaultComboBoxModel dcmTitre;
	private DefaultComboBoxModel dcmClient;
	
	
	protected static ArrayList<Livre> panierLivre;
	protected static ArrayList<BD> panierBd;
	

	 
	public SellFrame() {

		dcmTitre = new DefaultComboBoxModel();
		dcmClient = new DefaultComboBoxModel(); 
		
		panierLivre = new ArrayList<>();
		panierBd = new ArrayList<>();
		
		
		init();
		
		populateLivreCombo();
		populateClientCombo();

		panierTable.setModel(GUI.dtmP);
		
		
	}
	
	private void init() {
		frame = new JFrame();
		frame.setTitle("Vendre un ouvrage");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 736, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 700, 55);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Vendre des ouvrages");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Panier");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(393, 66, 327, 39);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(391, 359, 329, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Montant Total :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		panierLabel = new JLabel("New label");
		panierLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panierLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(panierLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(393, 116, 327, 232);
		contentPane.add(scrollPane_1);
		
		panierTable = new JTable();
		panierTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(panierTable);
		GUI.dtmP.setRowCount(0);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 114, 369, 234);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(4, 2, 0, 30));
		
		JLabel lblNewLabel_7 = new JLabel("Type");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_7);
		
		String[] type = {"Livre", "BD"};
		typeCombo = new JComboBox(type);
		typeCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				/*
				 * options in titreCombo depend on typeCombo selection
				 */
				if(typeCombo.getSelectedIndex()==0)
					populateLivreCombo();
				else if(typeCombo.getSelectedIndex()==1)
					populateBDCombo();
			}
		});
		
		typeCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(typeCombo);
		
		JLabel lblNewLabel_1 = new JLabel("Titre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		
		titreCombo = new JComboBox<>();
		titreCombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titreCombo.setModel(dcmTitre);
		panel_3.add(titreCombo);
		
		JLabel lblNewLabel_5 = new JLabel("Quantit\u00E9");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);
		
		quantiteText = new JTextField();
		quantiteText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				/*
				 * only allow numbers and back space buttons
				 */
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))
				{
					getToolkit().beep();
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(quantiteText.getText().length() > 0)
					/*
					 * enable ajouterButton only when quantiteText is not empty
					 */
					ajouterButton.setEnabled(true);
				else
					ajouterButton.setEnabled(false);
			}
		});
		quantiteText.setHorizontalAlignment(SwingConstants.CENTER);
		quantiteText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(quantiteText);
		quantiteText.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Client");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_6);
		
		clientCombo = new JComboBox<>();
		clientCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clientCombo.setModel(dcmClient);
		panel_3.add(clientCombo);
		
		ajouterButton = new JButton("Ajouter");
		ajouterButton.setEnabled(false);
		ajouterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * show item in panierTable
				 */
				if(typeCombo.getSelectedIndex()== 0)
					populateLivrePanier();
				else if(typeCombo.getSelectedIndex()== 1)
					populateBDPanier();
				sommePanier();              // calculate sum panier
			}
		});
		ajouterButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ajouterButton.setBounds(20, 359, 134, 62);
		contentPane.add(ajouterButton);
		
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.populate();										//update stock in main frame table
				addpoints();										//add points to client 
				frame.dispose();									//close frame
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(220, 359, 161, 62);
		contentPane.add(btnNewButton_1);
		
		
		frame.add(contentPane);
	}
	
	public void addpoints()
	{	/*
		*	Multiply quantity requested by number of points for each livre/bd bought	
		*/
		int total = 0;
		/*
		 * Calculate number of points to add
		 */
		for(int i=0; i<panierTable.getRowCount();i++)
		{
			if(panierTable.getValueAt(i,1).toString().equals("Livre"))
			{
				int point = Integer.parseInt(panierTable.getValueAt(i, 4).toString()) * 30;
				total += point;
			}
			else
			{
				int point = Integer.parseInt(panierTable.getValueAt(i, 4).toString()) * 50;
				total += point;
			}
		}
		for(int j=0; j<GUI.clientList.size(); j++)
		{
			if(Integer.parseInt(clientCombo.getSelectedItem().toString()) == GUI.clientList.get(j).num_compte)
			{
				GUI.clientList.get(j).points += total;					//update client points 
			}
		}
		GUI.populateClients();									//update client table
	}
	
	public void sommePanier()
	{
		/*
		 * Calculate sum panier and showing it in panierLabel
		 */
		double total = 0;
		for(int i=0; i<panierTable.getRowCount(); i++)
		{
			double amount = (Double.parseDouble((panierTable.getValueAt(i, 3).toString()))) * Integer.parseInt(panierTable.getValueAt(i,4).toString());
			total += amount;
		}
		panierLabel.setText(String.valueOf(total)+ " €");
	}
	public void populateLivrePanier()
	{
		/*
		 * add requested livre and quantity to panierTable and updating quantity in livreList to avoid selling more than available stock
		 */
		String titre = titreCombo.getSelectedItem().toString();
		int quantite = Integer.parseInt(quantiteText.getText());
		quantiteText.setText("");
		
		for(int i=0;i<GUI.livreList.size(); i++)
		{
			if(titre.equals(GUI.livreList.get(i).titre))
			{
				if(quantite > GUI.livreList.get(i).quantite)
				{
					JOptionPane.showMessageDialog(null,"Quantité demandée supérieure à celle disponible");
					break;
				}
				else if(quantite < GUI.livreList.get(i).quantite)
				{
					GUI.livreList.get(i).quantite -= quantite;
					Object[] objs = {GUI.livreList.get(i).titre, "Livre",GUI.livreList.get(i).prix_fournisseur,GUI.livreList.get(i).prix(),quantite};
					GUI.dtmP.addRow(objs);
				}
				else
				{
					GUI.livreList.remove(i);
					Object[] objs = {GUI.livreList.get(i).titre, "Livre",GUI.livreList.get(i).prix_fournisseur,GUI.livreList.get(i).prix(),quantite};
					GUI.dtmP.addRow(objs);
				}
				
			}
		}
	}
	
	private void populateBDPanier()
	{
		/*
		 * add requested bd and quantity to panierTable and updating quantity in bdList to avoid selling more than available stock
		 */
		String titre = titreCombo.getSelectedItem().toString();
		int quantite = Integer.parseInt(quantiteText.getText());
		quantiteText.setText("");
		
			for(int i=0;i<GUI.bdList.size(); i++)
			{
				if(titre.equals(GUI.bdList.get(i).titre))
				{
					if(quantite < GUI.bdList.get(i).quantite)
					{
						GUI.bdList.get(i).quantite -= quantite;
						Object[] objs = {GUI.bdList.get(i).titre, "BD",GUI.bdList.get(i).prix_fournisseur,GUI.bdList.get(i).prix(),quantite};
						GUI.dtmP.addRow(objs);
					}
					else if(quantite == GUI.bdList.get(i).quantite)
					{
						GUI.bdList.remove(i);
						Object[] objs = {GUI.bdList.get(i).titre, "BD",GUI.bdList.get(i).prix_fournisseur,GUI.bdList.get(i).prix(),quantite};
						GUI.dtmP.addRow(objs);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Quantité demandée supérieure à celle disponible");
						break;
					}
				}
			}
	}
	private void populateLivreCombo()
	{
		/*
		 * show titles of books from livreList in titreCombo
		 */
		dcmTitre.removeAllElements();
		for(int i=0; i<GUI.livreList.size(); i++)
			dcmTitre.addElement(GUI.livreList.get(i).titre);		
	}
	
	private void populateBDCombo()
	{
		/*
		 * show titles of bd from bdList in titreCombo
		 */
		dcmTitre.removeAllElements();
		for(int j=0; j<GUI.bdList.size(); j++)
			dcmTitre.addElement(GUI.bdList.get(j).titre);		
	}
	private void populateClientCombo()
	{
		/*
		 * show num_compte of clients from clientList in clientCombo
		 */
		dcmClient.removeAllElements();
		for(int i=0; i<GUI.clientList.size(); i++)
			dcmClient.addElement(GUI.clientList.get(i).num_compte);
	}
}

