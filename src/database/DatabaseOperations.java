package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseOperations {

	public static ArrayList<KhoHang> getAllKhoHang() {
		ArrayList<KhoHang> list = new ArrayList<>();
		String sql = "SELECT * FROM QuanLyKho";

		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				String maKho = resultSet.getString("MaKho");
				String tenKhuVuc = resultSet.getString("TenKhuVuc");
				String tenSanPham = resultSet.getString("TenSanPham");
				int soLuongSanPham = resultSet.getInt("SoLuongSanPham");
				list.add(new KhoHang(maKho, tenKhuVuc, tenSanPham, soLuongSanPham));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void addKhoHang(KhoHang khoHang) {
		String sql = "INSERT INTO QuanLyKho (MaKho, TenKhuVuc, TenSanPham, SoLuongSanPham) VALUES (?, ?, ?, ?)";

		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, khoHang.getMaKho());
			statement.setString(2, khoHang.getTenKhuVuc());
			statement.setString(3, khoHang.getTenSanPham());
			statement.setInt(4, khoHang.getSoLuongSanPham());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateKhoHang(KhoHang khoHang) {
		String sql = "UPDATE QuanLyKho SET TenKhuVuc = ?, TenSanPham = ?, SoLuongSanPham = ? WHERE MaKho = ?";

		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, khoHang.getTenKhuVuc());
			statement.setString(2, khoHang.getTenSanPham());
			statement.setInt(3, khoHang.getSoLuongSanPham());
			statement.setString(4, khoHang.getMaKho());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteKhoHang(String maKho) {
		String sql = "DELETE FROM QuanLyKho WHERE MaKho = ?";

		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, maKho);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
