package lab.servlet.welcome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.servlet.Config.DatabaseConnection;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("** Validate Logg***");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int rows = 0;
		int roleId = 0;

		try {
			Connection con = DatabaseConnection.initializeDatabase();

			ServletContext ctx = request.getServletContext();
			con = (Connection) ctx.getAttribute("dbConnection");

			PreparedStatement pstmt = con.prepareStatement("select RoleID from users Where UserName=? And Password=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				roleId = rs.getInt("RoleID");
				rows++;
			}

			if (rows != 0) {
				HttpSession newSession = request.getSession(true);

				// setting session to expiry in 5 mins
				newSession.setMaxInactiveInterval(5 * 60);

				/// Add UserIDKey in the Login response
				String userIDKey = new String("userID");
				newSession.setAttribute(userIDKey, userName);
				newSession.setAttribute("roleId", roleId);

				/// Add Cookies
				Cookie message = new Cookie("JSESSIONID", newSession.getId());
				response.addCookie(message);

				request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
