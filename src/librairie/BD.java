package librairie;

public class BD extends Ouvrage{
	private String scenariste;
	private String dessinateur;
	
	public BD()
	{
		this.titre = "";
		this.editeur = "";
		this.scenariste = "";
		this.dessinateur = "";
		this.annee = 0;
		this.prix_fournisseur = 0;
		this.quantite = 0;
	}
	
	public BD(String scena, String dessina, String titr, String editeu, int anne, double prix_f, int quantity)
	{
		this.scenariste = scena;
		this.editeur = editeu;
		this.dessinateur = dessina;
		this.titre = titr;
		this.annee = anne;
		this.prix_fournisseur = prix_f;
		this.quantite = quantity;
	}

	public double prix()
	{
		return (this.prix_fournisseur + this.prix_fournisseur*40/100);
	}


}