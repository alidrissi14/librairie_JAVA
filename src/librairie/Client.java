package librairie;

public class Client {
	protected int num_compte;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String email;
	protected long telephone;
	protected int points;
	
	public Client()
	{
		this.num_compte = 0;
		this.nom = "";
		this.prenom = "";
		this.adresse = "";
		this.email = "";
		this.telephone = 0;
		this.points = 0;
	}
	
	public Client(int num_compte, String nom, String prenom, String adresse, String email, long telephone)
	{
		this.num_compte = num_compte;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.points = 0;
	}
}
