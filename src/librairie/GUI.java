package librairie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI {

	protected JFrame frame;
	protected JTable listeTable;
	
	protected static ArrayList<Livre> livreList;
	protected static ArrayList<BD> bdList;
	protected static ArrayList<Client> clientList;
	protected static ArrayList<Livre> historyLivre;
	protected static ArrayList<BD> historyBD;
	
	protected static String header[] = new String[] {"Titre", "Type", "Prix fournisseur", "Prix", "Quantite disponible"};
	protected static String headerC[] = new String[] {"Numéro Compte", "Nom", "Prénom", "Points"};
	
	protected static DefaultTableModel dtm;
	protected static DefaultTableModel dtmC;
	protected static DefaultTableModel dtmP;
	protected static DefaultTableModel dtmH;
	int row,col;

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();   												// init main frame
		livreList = new ArrayList<>();									// init la liste où les infos des livres sont stockés
		bdList = new ArrayList<>();										// idem pour les bds
		clientList = new ArrayList<>();
		historyLivre = new ArrayList<>();
		historyBD = new ArrayList<>();
		dtm = new DefaultTableModel(header,0) {						
			@Override
			public boolean isCellEditable(int row,int column) {			//init main table model
				return false;
			}
		};
		
		dtmC = new DefaultTableModel(headerC, 0) {						//init client table model
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		
		
		dtmP = new DefaultTableModel(GUI.header,0) {					// init panier table model
			@Override
			public boolean isCellEditable(int row,int column)
			{
				return false;
			}
		};
	
		dtmH = new DefaultTableModel(GUI.header,0) {					// init journal d'achats table model
			@Override
			public boolean isCellEditable(int row,int column)
			{
				return false;
			}
		};
		
		listeTable.setModel(dtm);
													
		init_ouvrage();		// init livre et bd pour faciliter le test
		init_client();		//init clients pour tester
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(107, 142, 35));
		frame.setBounds(100, 100, 877, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Libraire by Ali Drissi");
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(107, 142, 35));
		titlePanel.setBounds(10, 11, 841, 71);
		frame.getContentPane().add(titlePanel);
		
		JLabel titleLabel = new JLabel("Gestionnaire de librairie");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		titlePanel.add(titleLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(107, 142, 35));
		panel.setBounds(10, 93, 522, 41);
		frame.getContentPane().add(panel);
		
		JLabel listeLabel = new JLabel("Liste des ouvrages");
		listeLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(listeLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 522, 346);
		frame.getContentPane().add(scrollPane);
		
		listeTable = new JTable();
		listeTable.setRowHeight(20);
		listeTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(listeTable);
		listeTable.setCellSelectionEnabled(true);
		
		JPanel boutonsPanel = new JPanel();
		boutonsPanel.setBackground(new Color(107, 142, 35));
		boutonsPanel.setBounds(577, 93, 274, 407);
		frame.getContentPane().add(boutonsPanel);
		boutonsPanel.setLayout(new GridLayout(6, 0, 0, 10));
		
		JButton addLivreButton = new JButton("Ajouter un livre");
		addLivreButton.addActionListener(new ActionListener() {					//open add livre frame when clicked
			public void actionPerformed(ActionEvent e) {
				AddLivre addlivre = new AddLivre();
				addlivre.setVisible(true);
			}
		});
		addLivreButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boutonsPanel.add(addLivreButton);
		
		JButton addBDButton = new JButton("Ajouter une BD");
		addBDButton.addActionListener(new ActionListener() {					//open add bd frame when clicked
			public void actionPerformed(ActionEvent e) {
				AddBD addbd = new AddBD();
				addbd.setVisible(true);
			}
		});
		addBDButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boutonsPanel.add(addBDButton);
		
		JButton sellButton = new JButton("Vendre un ouvrage");					//open sell frame when clicked
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellFrame sellfrm = new SellFrame();
				sellfrm.setVisible(true);
			}
			
		});
		sellButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boutonsPanel.add(sellButton);
		
		JButton historyButton = new JButton("Journal d'achats");
		historyButton.addActionListener(new ActionListener() {					//open journal d'achats frame when clicked
			public void actionPerformed(ActionEvent arg0) {
				HistoryFrame historyfrm = new HistoryFrame();
				historyfrm.setVisible(true);
			}
		});
		historyButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boutonsPanel.add(historyButton);
		
		JButton quitButton = new JButton("Quitter");							//quit when clicked
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton clientButton = new JButton("Consulter Clients");				//open client frame when clicked
		clientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientFrame clientfrm = new ClientFrame();
				clientfrm.setVisible(true);
			}
		});
		clientButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boutonsPanel.add(clientButton);
		quitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boutonsPanel.add(quitButton);
	}
	
	private void init_ouvrage()
	{
		/* Ajouter livre a livreList pour l'afficher dans la table avec populate()
		 * 
		 */
		livreList.add(new Livre("victor hugo", "les miserables", "editeur", 1862, 30, 15));
		livreList.add(new Livre("victor hugo", "ruy blas", "editeur", 1838, 34, 20));
		bdList.add(new BD("scenariste", "dessinateur", "titre", "editeur", 2015, 20, 12));
		bdList.add(new BD("scena", "dessina", "titree", "editeuur", 2014, 25, 30));
		populate();					
	}
	
	private void init_client()
	{
		clientList.add(new Client(1234, "ali", "drissi", "5, Rue Paul Dautier", "ali.drissi@ens.uvsq.fr", 0766524163));
		clientList.add(new Client(1233, "toto", "titi", "4, Rue Paul Dautier", "toto.titi@gmail.com", 0745126532));
		populateClients();
		
	}
	
	protected static void populate()
	{ 
		/*
		 * Afficher contenu de livreList et bdList dans table
		 */
		dtm.setRowCount(0);
		for(int i=0; i<GUI.livreList.size(); i++)
		{
			Object[] objs = {livreList.get(i).titre, "Livre", livreList.get(i).prix_fournisseur, livreList.get(i).prix(), livreList.get(i).quantite};
			dtm.addRow(objs);
		}
		
		for(int j=0; j<GUI.bdList.size(); j++)
		{
			Object[] objs1 = {bdList.get(j).titre, "BD", bdList.get(j).prix_fournisseur, bdList.get(j).prix(), bdList.get(j).quantite};
			dtm.addRow(objs1);
		}
	}
	
	
	protected static void populateClients()
	{	
		/*
		 * Afficher contenu de clientList dans client table
		 */
		dtmC.setRowCount(0);
		for(int i=0; i<clientList.size(); i++)
		{
			Object[] objs = {clientList.get(i).num_compte, clientList.get(i).nom, clientList.get(i).prenom, clientList.get(i).points};
			dtmC.addRow(objs);	
		}
	}
}
