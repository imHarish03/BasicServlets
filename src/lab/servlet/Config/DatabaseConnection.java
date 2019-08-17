package lab.servlet.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		// Initialize all the information regarding
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "root");
			return con;
		} catch (SQLException e) {
			throw new SQLException("Error in the Database Connectivity");
		}
	}
}
