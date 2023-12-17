package bdd.lui.projet2024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bdd.lui.projet2024.DbConnection;
import dao.lui.projet2024.BibliothequeDao;

public class DbConnection {
	private static final  String URL = "jdbc:mysql://localhost:3306/gestiondebibliotheque";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USER,PASSWORD );
			System.out.println("Connection établie");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	

	
	public static void main(String[] args) throws SQLException {
		Connection con = DbConnection.getConnection();

}
}