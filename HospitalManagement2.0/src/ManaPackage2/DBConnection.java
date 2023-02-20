package ManaPackage2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	// Global declaration of variable
	static Connection con;

	public static Connection createConnection() {

		try {
			// used to get instance of the class with specified class name
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Username of mysql
			String user = "root";
			// Password of mysql
			String pass = "Neeraj@1757";
			// URL For identifying and connecting to the database
			String url = "jdbc:mysql://localhost:3306/hospitalmanagement?autoReconnect=true&useSSL=false";
			// Driver manager class establishes a connection to the database
			con = DriverManager.getConnection(url, user, pass);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
}