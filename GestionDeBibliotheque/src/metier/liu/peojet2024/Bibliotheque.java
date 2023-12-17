package metier.liu.peojet2024;

public class Bibliotheque {
	private int idBibliotheque; 
	private String emplacement;
	
	//constructeur
	public Bibliotheque(int idBibliotheque, String emplacement) {
		super();
		this.idBibliotheque = idBibliotheque;
		this.emplacement = emplacement;
	}
        
	     //getter and setter
	public int getIdBibliotheque() {
		return idBibliotheque;
	}

	public void setIdBibliotheque(int idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
       //affichage
	@Override
	public String toString() {
		return "Bibliotheque [idBibliotheque=" + idBibliotheque + ", emplacement=" + emplacement + "]";
	}
	  
}
	  
	