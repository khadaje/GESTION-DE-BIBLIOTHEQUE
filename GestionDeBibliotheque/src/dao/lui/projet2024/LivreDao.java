package dao.lui.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bdd.lui.projet2024.DbConnection;
import metier.liu.peojet2024.*;



public class LivreDao implements Dao<Livre>{
	
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
		
	       //initialiser les variable
		public  LivreDao() {
			
			try {
				connection = DbConnection.getConnection();
				Statement = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public Livre get(long id) {
         
			//1.requet
			 requette = "SELECT * FROM Livre WHERE ISBN = " + (int) id;
          

			//2.recupere les resultat
				
				Livre livre = null;
				try {
					
					ResultSet resultSet = Statement.executeQuery(requette);
				
				
				//3.Stoker ce resultat dans l'objet employe
				resultSet.next();
				
				int iSBN = resultSet.getInt(1);
				String titre = resultSet.getString(2);
				int idAuteur = resultSet.getInt(3);



				livre = new Livre(iSBN, titre, idAuteur);
				
				//4.affichage de livre
			    System.out.println(livre.toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
					}
			return livre;
		}

		@Override
		public List<Livre> getAll() {

			requette =	"SELECT * FROM livre"; 
			System.out.println(requete);
			List<Livre> list = new ArrayList<>();
			Livre livre = null;
			
			ResultSet resultSet;
             
			try {
				resultSet = Statement.executeQuery(requette);
				
				while(resultSet.next()) {
				
				int iSBN = resultSet.getInt(1);
				String titre = resultSet.getString(2);
				int idAuteur  = resultSet.getInt(3);
				
				
				livre = new Livre(iSBN,titre,idAuteur);
				list.add(livre);
				System.out.println(livre.toString());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
				
				 return list;
      
		
		}

		@Override
		public void save(Livre k) {
			//requette
			requette = "INSERT INTO Livre(iSBN, titre, idAuteur) VALUES("+k.getISBN()+", '"+k.getTitre()+"', '"+k.getIdAuteur()+"')";
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
		public void update(Livre k, String[] params) {
          
			//requete
			 requette= "UPDATE Livre SET titre='"+params[0]+"', "
					+ "idAuteur='"+params[1]+"' "
					+ "WHERE ISBN = " + (int) k.getISBN();
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
		public void delete(Livre k) {
                 //1.requtte
	        requette = "DELETE FROM Livre WHERE ISBN = " + (int) k.getISBN();
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
			new LivreDao().get(456789);
			
			///get all
			new LivreDao().getAll();
			
			//save
			new LivreDao().save(new Livre(111222, "Voyages à travers le Savoir",11 ));
			
			//upade
			//System.out.println("TEST DE LA METODE update()");
			//String[] newLivre = { "  ","   ", "   " };
			//new  LivreDao().update(new  LivreDao().get(11), newLivre);
			
			//Test Delete
			//System.out.println("TEST DE LA METODE DLETE()");
			//new  LivreDao().delete(new  LivreDao().get(12));
			
			///get all
			//new AuteurDao().getAll();

		}
}
