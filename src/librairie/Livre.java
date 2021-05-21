package librairie;

public class Livre extends Ouvrage{
	 private String auteur;
	
	
	public Livre()
	{
		this.titre = "";
		this.auteur = "";
		this.editeur = "";
		this.annee = 0;
		this.prix_fournisseur = 0;
		this.quantite = 0;
	}
	
	public Livre(String auteu, String titr, String editeu, int anne, double prix_f, int quantity)
	{
		this.auteur = auteu;
		this.titre = titr;
		this.editeur = editeu;
		this.annee = anne;
		this.prix_fournisseur = prix_f;
		this.quantite = quantity;
	}
	
	public double prix()
	{
		return (this.prix_fournisseur + this.prix_fournisseur*20/100);
	}

}
