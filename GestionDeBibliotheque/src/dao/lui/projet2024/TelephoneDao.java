package dao.lui.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.lui.projet2024.DbConnection;
import metier.liu.peojet2024.Auteur;
import metier.liu.peojet2024.Bibliotheque;
import metier.liu.peojet2024.Livre;
import metier.liu.peojet2024.Telephone;

public class TelephoneDao implements Dao<Telephone>{
	
	 //variable de connection
	private Connection connection = null;
	
	    //conteneur de requette
	private Statement Statement = null;
	    //requete
	private String requete;
	    //modele
	private Telephone telephone= null;
	
	private List<Telephone> list;
	
	private  String requette;
	
       //initialiser les variable
	
	public TelephoneDao() {
		
		try {
			connection = DbConnection.getConnection();
			Statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	@Override
	public Telephone get(long id) {
		
		requette = "SELECT * from telephone WHERE numero=" + (int) id +";";
		Telephone telephone = null;
		//2.recupere les resultat
		
				try {
					
					ResultSet resultSet = Statement.executeQuery(requette);
				
				
				//3.Stoker ce resultat dans l'objet employe
				resultSet.next();
				
				int numero = resultSet.getInt(1);
				String type= resultSet.getString(2);
				int idAuteur = resultSet.getInt(3);
				
				
				telephone = new Telephone(numero,type,idAuteur);
				
				//4.affichage de l'auteur
			    System.out.println(telephone.toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
					}
		return null;
	}

	@Override
	public List<Telephone> getAll() {
		try {
			//requette
		requette =	"SELECT * FROM telephone"; 
		System.out.println(requete);
		List<Telephone> list = new ArrayList<>();
		Telephone telephone = null;
		ResultSet resultSet;
		
			resultSet = Statement.executeQuery(requette);
			
			while(resultSet.next()) {
			
			int numero = resultSet.getInt(1);
			String type = resultSet.getString(2);
			int idAuteur = resultSet.getInt(3);
			
			
			telephone = new Telephone(numero, type, idAuteur);
			list.add(telephone);
			System.out.println(telephone.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public void save(Telephone k) {
		 requette = "INSERT INTO Telephone(numero, type, idAuteur) VALUES("+k.getNumero()+", '"+k.getType()+"', '"+k.getIdAuteur()+"')";
		System.out.println(requette);
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
	public void update(Telephone k, String[] args) {
		// 1 REquette
		requette = "update telephone set  numero= " + Integer.parseInt(args[0]) + ", type= '" +args[1] + "', idAuteur='"
				+ args[2] +  "' Where idauteur=" + k.getNumero() + " ;";
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
	public void delete(Telephone k) {
		// 1 REquette
		requette = "DELETE FROM telephone Where idAuteur=" + k.getNumero() + " ;";
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


public static void main(String[] args) {
		
		//Test main
		     //getID
			System.out.println("TEST DE LA METODE getId");
			new TelephoneDao().get(101010);
	
			///get all
			new TelephoneDao().getAll();
			
			//save
			new TelephoneDao().save(new Telephone(123123, "Mobile",11 ));
			
			//upade
			//System.out.println("TEST DE LA METODE update()");
			//String[] newTelephone = { "    ","    ", "    " };
			//new TelephoneDao().update(new TelephoneDao().get(11), newTelephone);
			
			//Test Delete
			//System.out.println("TEST DE LA METODE DLETE()");
			//new TelephoneDao().delete(new TelephoneDao().get(12));
			
			///get all
			//new AuteurDao().getAll();


}	
}
