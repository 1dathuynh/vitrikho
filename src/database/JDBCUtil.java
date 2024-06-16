package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quanlykho";
	private static final String JDBC_USER = "root"; // Thay đổi tên người dùng của bạn
	private static final String JDBC_PASSWORD = "0935542587"; // Thay đổi mật khẩu của bạn

	static {
		try {
			// Đăng ký MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load MySQL driver", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
