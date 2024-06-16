package test;

import java.sql.Connection;
import java.sql.SQLException;
import database.JDBCUtil;

public class testJDBC {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Lấy kết nối từ JDBCUtil
			connection = JDBCUtil.getConnection();
			if (connection != null) {
				System.out.println("Kết nối thành công đến cơ sở dữ liệu MySQL!");
			} else {
				System.out.println("Kết nối thất bại.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Có lỗi xảy ra trong quá trình kết nối: " + e.getMessage());
		} finally {
			// Đóng kết nối
			JDBCUtil.closeConnection(connection);
		}
	}
}
