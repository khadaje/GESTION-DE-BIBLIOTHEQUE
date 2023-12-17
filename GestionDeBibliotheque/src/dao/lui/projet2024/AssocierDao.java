package dao.lui.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.lui.projet2024.DbConnection;
import metier.liu.peojet2024.Associer;
import metier.liu.peojet2024.Telephone;

public class AssocierDao implements Dao<Associer>{
	  //variable de connection
		private Connection connection = null;
		
		    //conteneur de requette
		private Statement Statement = null;
		    //requete
		private String requete;
		    //modele
		private Associer associer = null;
		
		private List<Associer> list;
		
		private  String requette;
		
		
		public AssocierDao() {
			try {
				connection = DbConnection.getConnection();
				Statement = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


		@Override
		public Associer get(long id) {
			// TODO Auto-generated method stub
			return null;
		}
         
		public Associer get(int idBibliotheque, int idAuteur) {
			Associer associer = null;
		    requette = "SELECT * FROM Associer WHERE idbibliotheque = "+idBibliotheque+" AND idAuteur = "+idAuteur;
			System.out.println(requette);
			try {
				
				ResultSet rsultSet = Statement.executeQuery(requette);
				if (rsultSet.next()) {
					associer = new Associer(idBibliotheque, idAuteur);
					System.out.println(associer.toString());
					System.out.println();
				}
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... élément introuvable");
				e.printStackTrace();
			}
			return associer;
		}

		@Override
		public List<Associer> getAll() {
			Associer associer = null;
		    requette = "SELECT * FROM Associer";
			System.out.println(requette);
			ArrayList<Associer> arrayList = new ArrayList<>();
			try {
				
				ResultSet resultSet = Statement.executeQuery(requette);
				while (resultSet.next()) {
					associer = new Associer(resultSet.getInt("idBibliotheque"), resultSet.getInt("idAuteur"));
					arrayList.add(associer);
					System.out.println(associer.toString());
				}
			} catch (SQLException e) {
				System.out.println("Erreur SQL... élément introuvable");
				e.printStackTrace();
			}
			return arrayList;
		}


		@Override
		public void save(Associer k) {
			 //requette
			 requette = "INSERT INTO Associer(idBibliotheque, idAuteur) VALUES("+k.getIdBibliotheque()+", '"+k.getIdAuteur()+"')";
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
		public void delete(Associer k) {
		    requette = "DELETE FROM Associer WHERE idBibliotheque = " + k.getIdBibliotheque() + "AND idAuteur = " + k.getIdAuteur();
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


		@Override
		public void update(Associer k, String[] args) {
			// TODO Auto-generated method stub
			
		}


		public static void main(String[] args) {
			System.out.println("TEST DE LA METODE getId");
//			new AssocierDao().get(4);
			
			//save
	   // new AssocierDao().save(new Associer(123123,11 ));
			new AssocierDao().getAll();
			
		}
		
}
