package librairie;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AddLivre extends JFrame {

	private JPanel contentPane;
	private JTextField titreText;
	private JTextField editeurText;
	private JTextField auteurText;
	private JTextField anneeText;
	private JTextField prixText;
	private JTextField quantiteText;

	public AddLivre() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un livre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(293, 30, 431, 67);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 124, 754, 336);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel titreLabel = new JLabel("Titre");
		titreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(titreLabel);
		
		titreText = new JTextField();
		titreText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(titreText);
		titreText.setColumns(10);
		
		JLabel auteurLabel = new JLabel("Auteur");
		auteurLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		auteurLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(auteurLabel);
		
		auteurText = new JTextField();
		auteurText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(auteurText);
		auteurText.setColumns(10);
		
		JLabel editeurLabel = new JLabel("Editeur\r\n");
		editeurLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editeurLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(editeurLabel);
		
		editeurText = new JTextField();
		editeurText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(editeurText);
		editeurText.setColumns(10);
		
		JLabel anneeLabel = new JLabel("Annee de publication",SwingConstants.CENTER);
		anneeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(anneeLabel);
		
		anneeText = new JTextField();
		anneeText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))        	//only allow numbers in textfield
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		anneeText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(anneeText);
		anneeText.setColumns(10);
		
		JLabel prixLabel = new JLabel("Prix fournisseur");
		prixLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(prixLabel);
		
		prixText = new JTextField();
		prixText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_BACK_SPACE))		//only allow numbers and period "." in text field
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		prixText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(prixText);
		prixText.setColumns(10);
		
		JLabel quantiteLabel = new JLabel("Quantit\u00E9");
		quantiteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		quantiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(quantiteLabel);
		
		quantiteText = new JTextField();
		quantiteText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))						//only allow number in textfield
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		quantiteText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(quantiteText);
		quantiteText.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(178, 471, 379, 78);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 150, 0));
		
		JButton validerBouton = new JButton("Valider");
		validerBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(titreText.getText().length() == 0 || editeurText.getText().length()==0 || anneeText.getText().length()==0 || prixText.getText().length()==0 || quantiteText.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
				}
				else
				{
					String titre = titreText.getText();
					String auteur = auteurText.getText();
					String editeur = editeurText.getText();
					double prix_f = Double.parseDouble(prixText.getText());
					int annee = Integer.parseInt(anneeText.getText());
					int quantite = Integer.parseInt(quantiteText.getText());
					int removed = 0;
					
					GUI.dtm.setRowCount(0);
					
					for(int i=0; i<GUI.livreList.size(); i++)
					{	
						/*
						 * if livre already exists add new quantity to stock
						 */
						if(titre.equals(GUI.livreList.get(i).titre))
						{
							quantite += GUI.livreList.get(i).quantite;
							GUI.livreList.remove(i);
							GUI.livreList.add(i,new Livre(auteur, titre, editeur, annee, prix_f, quantite));
							removed = 1;
							break;
						}
					}
					/*
					 * if livre doesn't exist create new livre and add info to livreList
					 */
					if(removed == 0)
					{
						GUI.livreList.add(new Livre(auteur, titre, editeur, annee, prix_f, quantite));
					}
					
					GUI.dtm.setRowCount(0);
					GUI.populate();
			
					clearFields();
				}
				}
				
		});
		validerBouton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(validerBouton);
	}
	
	private void clearFields()
	{
		titreText.requestFocus();
		titreText.setText("");
		auteurText.setText("");
		editeurText.setText("");
		prixText.setText("");
		anneeText.setText("");
		quantiteText.setText("");
	}
}
