package librairie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddBD extends JFrame {

	private JPanel contentPane;
	private JTextField titreText;
	private JTextField editeurText;
	private JTextField scenaristeText;
	private JTextField dessinateurText;
	private JTextField anneeText;
	private JTextField prixText;
	private JTextField quantiteText;

	
	public AddBD() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 929, 624);
		setTitle("Ajouter une BD");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter une BD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 11, 504, 95);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 96, 840, 389);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel titreLabel = new JLabel("Titre");
		titreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(titreLabel);
		
		titreText = new JTextField();
		titreText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(titreText);
		titreText.setColumns(10);
		
		JLabel editeurLabel = new JLabel("Editeur");
		editeurLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editeurLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(editeurLabel);
		
		editeurText = new JTextField();
		editeurText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(editeurText);
		editeurText.setColumns(10);
		
		JLabel scenaristeLabel = new JLabel("Sc\u00E9nariste");
		scenaristeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scenaristeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(scenaristeLabel);
		
		scenaristeText = new JTextField();
		scenaristeText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(scenaristeText);
		scenaristeText.setColumns(10);
		
		JLabel dessinateurLabel = new JLabel("Dessinateur");
		dessinateurLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dessinateurLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(dessinateurLabel);
		
		dessinateurText = new JTextField();
		dessinateurText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(dessinateurText);
		dessinateurText.setColumns(10);
		
		JLabel anneeLabel = new JLabel("Ann\u00E9e de publication");
		anneeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		anneeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(anneeLabel);
		
		anneeText = new JTextField();
		anneeText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		anneeText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		panel.add(anneeText);
		anneeText.setColumns(10);
		
		JLabel prixLabel = new JLabel("Prix fournisseur");
		prixLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(prixLabel);
		
		prixText = new JTextField();
		prixText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prixText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_BACK_SPACE))
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		panel.add(prixText);
		prixText.setColumns(10);
		
		JLabel quantiteLabel = new JLabel("Quantit\u00E9");
		quantiteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		quantiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(quantiteLabel);
		
		quantiteText = new JTextField();
		quantiteText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		quantiteText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		panel.add(quantiteText);
		quantiteText.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(titreText.getText().length() == 0 || editeurText.getText().length()==0 || scenaristeText.getText().length()==0 || dessinateurText.getText().length()==0 || anneeText.getText().length()==0 || prixText.getText().length()==0 || quantiteText.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
				}
				else
				{
					String titre = titreText.getText();
					String editeur = editeurText.getText();
					String scenariste = scenaristeText.getText();
					String dessinateur = dessinateurText.getText();
					int annee = Integer.parseInt(anneeText.getText());
					double prix_f = Double.parseDouble(prixText.getText());
					int quantite = Integer.parseInt(quantiteText.getText());
					int removed = 0;
					
					GUI.dtm.setRowCount(0);
					for(int k=0; k<GUI.bdList.size(); k++)
					{
						/*
						 * if bd already exists add new quantity to stock
						 */
						if(titre.equals(GUI.bdList.get(k).titre))
						{
							quantite += GUI.bdList.get(k).quantite; 
							GUI.bdList.remove(k);
							GUI.bdList.add(k, new BD(scenariste, dessinateur, titre, editeur, annee, prix_f, quantite));
							removed = 1;
							break;
							
						}
					}
					/*
					 * if bd doesn't exist create new bd and add info to bdList
					 */
					if(removed == 0)
					{
						GUI.bdList.add(new BD(scenariste, dessinateur, titre, editeur, annee, prix_f, quantite));
					}
					
					GUI.dtm.setRowCount(0);
					GUI.populate();
					clearFields();
					}
				}
				
				
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(265, 496, 368, 82);
		contentPane.add(btnNewButton);
	}
	
	private void clearFields()
	{
		titreText.requestFocus();
		titreText.setText("");
		scenaristeText.setText("");
		dessinateurText.setText("");
		editeurText.setText("");
		prixText.setText("");
		anneeText.setText("");
		quantiteText.setText("");
	}

}
