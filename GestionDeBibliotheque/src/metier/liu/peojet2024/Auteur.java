package metier.liu.peojet2024;

public class Auteur {
	  
	private int idAuteur; 
	private String nom; 
	private String adress; 
	private String region;
	  //constructeur
	public Auteur(int idAuteur, String nom, String adress, String region) {
		super();
		this.idAuteur = idAuteur;
		this.nom = nom;
		this.adress = adress;
		this.region = region;
	}
	   //Geteer and setter
	public int getIdAuteur() {
		return idAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	  //Affichage
	@Override
	public String toString() {
		return "Auteur [idAuteur=" + idAuteur + ", nom=" + nom + ", adress=" + adress + ", region=" + region + "]";
	}
	
	
}
	 