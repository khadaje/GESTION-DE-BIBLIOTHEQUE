package metier.liu.peojet2024;

public class Livre {
	private int ISBN;
	private String titre;
	private int idAuteur;
	  //constructeur
	public Livre(int iSBN, String titre, int idAuteur) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.idAuteur = idAuteur;
	}
	    //getter and setter
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getIdAuteur() {
		return idAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}
	   //affichage
	@Override
	public String toString() {
		return "Livre [ISBN=" + ISBN + ", titre=" + titre + ", idAuteur=" + idAuteur + "]";
	} 
	
	  
}