package metier.liu.peojet2024;

public class Associer {

	private int  idAuteur;
	private int idBibliotheque;
	public Associer(int idAuteur, int idBibliotheque) {
		super();
		this.idAuteur = idAuteur;
		this.idBibliotheque = idBibliotheque;
	}
	public int getIdAuteur() {
		return idAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}
	public int getIdBibliotheque() {
		return idBibliotheque;
	}
	public void setIdBibliotheque(int idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}
	@Override
	public String toString() {
		return "Associer [idAuteur=" + idAuteur + ", idBibliotheque=" + idBibliotheque + "]";
	}
	
	
}
