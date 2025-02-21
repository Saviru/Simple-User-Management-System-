package com.example;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
			String jdbcUser = "root";
			String jdbcPassword = "Saviru@2015";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
				if (connection != null) {
					out.println("<h2>Connected successful</h2>");
					connection.close();
			} 
			
			else {
				out.println("<h2>Connection failed</h2>");
			}
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			out.println("<h2>Connection failed: " + e.getMessage() + "</h2>");
		} finally {
			out.close();
		}
	}
}