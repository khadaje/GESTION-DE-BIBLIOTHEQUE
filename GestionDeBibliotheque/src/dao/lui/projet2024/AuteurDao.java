package dao.lui.projet2024;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.lui.projet2024.DbConnection;
import metier.liu.peojet2024.Auteur;

public class AuteurDao implements Dao<Auteur > {
	
	    //variable de connection
	private Connection connection = null;
	
	    //conteneur de requette
	private Statement Statement = null;
	    //requete
	private String requete;
	    //modele
	private Auteur auteur = null;
	
	private List<Auteur> list;
	
	private  String requette;
	
       //initialiser les variables
	public AuteurDao() {
		
		
		try {
			connection = DbConnection.getConnection();
			Statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	  @Override
	public Auteur get( long id) {
	
		//1. requette
		requette = "SELECT * from auteur WHERE idAuteur=" + (int) id +";";
	
		
		//2.recupere les resultat
		
		try {
			
			ResultSet resultSet = Statement.executeQuery(requette);
		
		
		//3.Stoker ce resultat dans l'objet employe
		resultSet.next();
		
		int idAuteur = resultSet.getInt(1);
		String nom = resultSet.getString(2);
		String adress = resultSet.getString(3);
		String region = resultSet.getString(4);
		
		auteur = new Auteur(idAuteur,nom,adress,region);
		
		//4.affichage de l'auteur
	    System.out.println(auteur.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			}
		return auteur;
	}

	@Override
	public List<Auteur> getAll() {
		
	requette =	"SELECT * FROM auteur"; 
	System.out.println(requete);
	List<Auteur> list = new ArrayList<>();
	Auteur auteur = null;
	
	ResultSet resultSet;
	try {
		resultSet = Statement.executeQuery(requette);
		
		while(resultSet.next()) {
		
		int idAuteur = resultSet.getInt(1);
		String nom = resultSet.getString(2);
		String adress = resultSet.getString(3);
		String region = resultSet.getString(4);
		
		auteur = new Auteur(idAuteur,nom,adress,region);
		list.add(auteur);
		System.out.println(auteur.toString());
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	
		
		 return list;
	}

	@Override
	public void save(Auteur k) {
		// REquette
		requette = "INSERT INTO auteur	VALUES ("+k.getIdAuteur()+",'"+k.getNom()+"','"+k.getAdress() +"','"+ k.getRegion() + "');";
		try {
			// Executer la requette
			int resultat = Statement.executeUpdate(requette);
			if (resultat != 0) {
				System.out.println("Insertion du auteur"); 

			} else {
				System.out.println("Ereur d'Insertion");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	@Override
	public void update(Auteur k,String[] args ) {
		// 1 REquette
				requette = "update auteur set  idauteur= " + Integer.parseInt(args[0]) + ", nom= '" +args[1] + "', adress='"
						+ args[2] + "', region='" + args[3] + "' Where idauteur=" + k.getIdAuteur() + " ;";
				System.out.println(requette);

				try {
					// 2. Recuperer le resulat
					int resulat = Statement.executeUpdate(requette);

					if (resulat != 0)
						System.out.println("Update effectué ");
					else {
						System.out.println("ERREUR d'UPDATE  ");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
	}

	@Override
	public void delete(Auteur k) {
    
		// 1 REquette
				requette = "DELETE FROM auteur Where idAuteur=" + k.getIdAuteur() + " ;";
				System.out.println(requette);

				try {
					// 2. Recuperer le resulat
					int resulat = Statement.executeUpdate(requette);

					if (resulat != 0)
						System.out.println("Delete effectué ");
					else {
						System.out.println("ERREUR de DELETE  ");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	
	//Test main
	public static void main(String[] args) {
		System.out.println("TEST DE LA METODE getId");
		new AuteurDao().get(3);

		///get all
		new AuteurDao().getAll();

		//save
		new AuteurDao().save(new Auteur(11, "Hassan Ould Med", " Rue des Livres ,Boghe", "Trarza" ));
		
		//upade
		System.out.println("TEST DE LA METODE update()");
		String[] newAuteur = { "12","Antony", "Rue des champs elys ", "France" };
		new AuteurDao().update(new AuteurDao().get(11), newAuteur);
		
		//Test Delete
		System.out.println("TEST DE LA METODE DLETE()");
		new AuteurDao().delete(new AuteurDao().get(12));

		///get all
		new AuteurDao().getAll();

		
	}
	
}
