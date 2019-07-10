package lab.servlet.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		// Initialize all the information regarding
		// Database Connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servle", "root", "root");
			return con;
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return null;
	}
}