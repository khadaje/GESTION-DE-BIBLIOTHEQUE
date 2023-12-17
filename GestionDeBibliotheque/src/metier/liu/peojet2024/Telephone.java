package metier.liu.peojet2024;

public class Telephone {

	private int numero; 
	private String type;
	private int idAuteur;



       //Constructeur
public Telephone(int numero, String type, int idAuteur) {
		super();
		this.numero = numero;
		this.type = type;
		this.idAuteur = idAuteur;
	}


	public int getNumero() {
		return numero;
	}



        //Getter and Setter
   public void setNumero(int numero) {
		this.numero = numero;
	}

   public String getType() {
		return type;
	}

   public void setType(String type) {
		this.type = type;
	}

    public int getIdAuteur() {
		return idAuteur;
	}
    public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}


          //Affichage
	@Override
	public String toString() {
		return "Telephone [numero=" + numero + ", type=" + type + ", idAuteur=" + idAuteur + "]";
	}







}
