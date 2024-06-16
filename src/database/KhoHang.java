package database;

public class KhoHang {
	private String maKho;
	private String tenKhuVuc;
	private String tenSanPham;
	private int soLuongSanPham;

	public KhoHang(String maKho, String tenKhuVuc, String tenSanPham, int soLuongSanPham) {
		this.maKho = maKho;
		this.tenKhuVuc = tenKhuVuc;
		this.tenSanPham = tenSanPham;
		this.soLuongSanPham = soLuongSanPham;
	}

	public String getMaKho() {
		return maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

	public String getTenKhuVuc() {
		return tenKhuVuc;
	}

	public void setTenKhuVuc(String tenKhuVuc) {
		this.tenKhuVuc = tenKhuVuc;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}

	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
}
