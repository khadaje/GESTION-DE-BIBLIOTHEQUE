package dao.lui.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.lui.projet2024.DbConnection;
import metier.liu.peojet2024.*;

public class BibliothequeDao implements Dao<Bibliotheque> {

	// variable de connection
	private Connection connection = null;

	// conteneur de requette
	private Statement statement = null;

	// requette
	private String requete = null;

	// model
	private Bibliotheque bibliotheque = null;

	private List<Bibliotheque> list;

	private String requette;

	// initialiser les variable
	public BibliothequeDao() {
		try {
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Bibliotheque get(long id) {

		// 1. requette
		Bibliotheque bibliotheque = null;
		requette = "SELECT * FROM Bibliotheque WHERE idBibliotheque = " + (int) id;
		System.out.println(requette);

		// 2.recupere les resultat

		try {

			ResultSet resultSet = statement.executeQuery(requette);

			// 3.Stoker ce resultat dans l'objet employe
			resultSet.next();

			int idBibliotheque = resultSet.getInt(1);
			String emplacement = resultSet.getString(2);

			bibliotheque = new Bibliotheque(idBibliotheque, emplacement);

			// 4.affichage de l'auteur
			System.out.println(bibliotheque.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return bibliotheque;
	}

	@Override
	public List<Bibliotheque> getAll() {
		try {
			// requette
			requete = "SELECT * FROM Bibliotheque";
			System.out.println(requete);
			List<Bibliotheque> list = new ArrayList<>();
			Bibliotheque bibliotheque = null;

			// recuperer les donne

			ResultSet resultSet = statement.executeQuery(requete);

			// stoler ce resultat dans l'objet Bibliotheque
			resultSet.next();
			while (resultSet.next()) {

				int idBibliotheque = resultSet.getInt(1);
				String emplacement = resultSet.getString(2);

				bibliotheque = new Bibliotheque(idBibliotheque, emplacement);
				list.add(bibliotheque);
				System.out.println(bibliotheque.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void save(Bibliotheque k) {
		// TODO Auto-generated method stub

		// 1 REquette

		requette = "INSERT INTO Bibliotheque(idBibliotheque, emplacement) VALUES(" + k.getIdBibliotheque() + ", '"
				+ k.getEmplacement() + "')";
		System.out.println(requette);

		try {
			// 2. Recuperer le resulat
			int resulat = statement.executeUpdate(requette);

			if (resulat != 0)
				System.out.println("insertion effectué ");
			else {
				System.out.println("ERREUR d'insertion  ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Bibliotheque k, String[] params) {

		// 1 REquette
		requette = "update bibliotheque set emplacement= '" + params[1] + "' where idBibliotheque =   "
				+ k.getIdBibliotheque();
		System.out.println(requette);
		
		
		try {
			// 2. Recuperer le resulat
			int resulat = statement.executeUpdate(requette);

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
	public void delete(Bibliotheque k) {

		// 1 REquette
		requette = "DELETE FROM  bibliotheque Where idBibliotheque=" + (int) k.getIdBibliotheque() + " ;";
		System.out.println(requette);

		try {
			// 2. Recuperer le resulat
			int resulat = statement.executeUpdate(requette);

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

		// Test main

		System.out.println("TEST DE LA METODE getId");
		new BibliothequeDao().get(10);

		System.out.println("TEST DE LA METODE getAll");
		new BibliothequeDao().getAll();

		System.out.println("TEST DE LA METODE save = insertion");
		new BibliothequeDao().save(new Bibliotheque(12, "Bibliotheque Akjoujt"));

		System.out.println("TEST DE LA METODE getAll");
		new BibliothequeDao().getAll();

		// upade
		System.out.println("TEST DE LA METODE update()");
		String[] newBibliotheque = { "12", "Bibliotheque akjoujt-atar" };
		new BibliothequeDao().update(new BibliothequeDao().get(12), newBibliotheque);

		System.out.println("TEST DE LA METODE getAll");
		new BibliothequeDao().getAll();

		System.out.println("TEST DE LA METODE DLETE()");
		new BibliothequeDao().delete(new BibliothequeDao().get(12));

	}

}
