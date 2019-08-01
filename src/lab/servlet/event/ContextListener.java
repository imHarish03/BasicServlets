package lab.servlet.event;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) { // Database Connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "root");

			ServletContext ctx = event.getServletContext();
			ctx.setAttribute("dbConnection", con);
		} catch (Exception e) {
			System.out.println("**************************ERROR IN DB CONNECTION****************");
		}
	}

}
