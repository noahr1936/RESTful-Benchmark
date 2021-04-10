package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	public Connection getConnection() {

		Connection conn = null;

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";

		try {
			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failure");
		}
		return conn;
	}
}
