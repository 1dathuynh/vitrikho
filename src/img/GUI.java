package img;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.DatabaseOperations;
import database.KhoHang;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaKho;
	private JTextField txtTenKhuVuc;
	private JTextField txtTenSanPham;
	private JTextField txtSoLuongSanPham;
	private JTextField txtTimKiem;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		RoundedPanel jPanelMenu = new RoundedPanel(50, Color.WHITE);
		jPanelMenu.setLayout(new BorderLayout(0, 0));
		contentPane.add(jPanelMenu, BorderLayout.WEST);

		JLabel labelHouse = new JLabel("");
		labelHouse.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("House.png")).getImage();
		labelHouse.setIcon(new ImageIcon(img));
		jPanelMenu.add(labelHouse);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());

		JLabel labelDH = new JLabel("Don Hang");
		labelDH.setHorizontalAlignment(SwingConstants.CENTER);
		labelDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgDH = new ImageIcon(this.getClass().getResource("icon_DonHang.png")).getImage();
		Image sacledImgDH = imgDH.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelDH.setIcon(new ImageIcon(sacledImgDH));
		panel.add(labelDH);
		labelDH.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel labelTK = new JLabel("Ton Kho");
		labelTK.setHorizontalAlignment(SwingConstants.CENTER);
		labelTK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgTK = new ImageIcon(this.getClass().getResource("icon_TonKho.png")).getImage();
		Image sacledImgTK = imgTK.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelTK.setIcon(new ImageIcon(sacledImgTK));
		panel.add(labelTK);
		labelTK.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel labelNX = new JLabel("Nhap Xuat");
		labelNX.setHorizontalAlignment(SwingConstants.CENTER);
		labelNX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgNX = new ImageIcon(this.getClass().getResource("icon_NhapXuat.png")).getImage();
		Image sacledImgNX = imgNX.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelNX.setIcon(new ImageIcon(sacledImgNX));
		panel.add(labelNX);
		labelNX.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel labelVT = new JLabel("Vi Tri Kho");
		labelVT.setForeground(new Color(0, 0, 0));
		labelVT.setBackground(new Color(128, 128, 128));
		labelVT.setHorizontalAlignment(SwingConstants.CENTER);
		labelVT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgVT = new ImageIcon(this.getClass().getResource("icon_ViTri.png")).getImage();
		Image sacledImgVT = imgVT.getScaledInstance(40, 36, Image.SCALE_SMOOTH);
		labelVT.setIcon(new ImageIcon(sacledImgVT));
		panel.add(labelVT);
		labelVT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel labelQT = new JLabel("Quan Tri");
		labelQT.setHorizontalAlignment(SwingConstants.CENTER);
		labelQT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgQT = new ImageIcon(this.getClass().getResource("icon_QuanTri.png")).getImage();
		Image sacledImgQT = imgQT.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelQT.setIcon(new ImageIcon(sacledImgQT));
		panel.add(labelQT);
		labelQT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel labelTKe = new JLabel("Thong Ke");
		labelTKe.setHorizontalAlignment(SwingConstants.CENTER);
		labelTKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgTKe = new ImageIcon(this.getClass().getResource("icon_ThongKe.png")).getImage();
		Image sacledImgTKe = imgTKe.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelTKe.setIcon(new ImageIcon(sacledImgTKe));
		panel.add(labelTKe);
		labelTKe.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(Box.createVerticalStrut(10));
		panel.add(Box.createVerticalGlue());

		jPanelMenu.add(labelHouse, BorderLayout.NORTH);
		jPanelMenu.add(panel, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BorderLayout());
		// Tạo bảng dữ liệu
		String[] columnNames = { "Mã kho", "Tên khu vực", "Tên sản phẩm", "Số lượng" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		JScrollPane jscr = new JScrollPane(table);

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel_2, jscr);
		splitPane.setDividerLocation(200);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin nhập kho"));

		// Mã kho
		inputPanel.add(new JLabel("Mã kho:"));
		txtMaKho = new JTextField();
		inputPanel.add(txtMaKho);

		// Tên khu vực
		inputPanel.add(new JLabel("Tên khu vực:"));
		txtTenKhuVuc = new JTextField();
		inputPanel.add(txtTenKhuVuc);

		// Tên sản phẩm
		inputPanel.add(new JLabel("Tên sản phẩm:"));
		txtTenSanPham = new JTextField();
		inputPanel.add(txtTenSanPham);

		// Số lượng sản phẩm
		inputPanel.add(new JLabel("Số lượng sản phẩm:"));
		txtSoLuongSanPham = new JTextField();
		inputPanel.add(txtSoLuongSanPham);

		// Tìm kiếm
		inputPanel.add(new JLabel("Tìm kiếm:"));
		txtTimKiem = new JTextField();
		inputPanel.add(txtTimKiem);

		inputPanel.setLayout(new GridLayout(5, 2, 10, 10));
		panel_2.add(inputPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		JButton btnAdd = new JButton("Thêm");
		JButton btnDelete = new JButton("Xóa");
		JButton btnSearch = new JButton("Tìm kiếm");
		buttonPanel.add(btnAdd);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnSearch);
		buttonPanel.setLayout(new FlowLayout());
		panel_2.add(buttonPanel, BorderLayout.SOUTH);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maKho = txtMaKho.getText();
				String tenKhuVuc = txtTenKhuVuc.getText();
				String tenSanPham = txtTenSanPham.getText();
				int soLuong = Integer.parseInt(txtSoLuongSanPham.getText());

				KhoHang khoHang = new KhoHang(maKho, tenKhuVuc, tenSanPham, soLuong);
				DatabaseOperations.addKhoHang(khoHang);
				loadKhoHangData();

				txtMaKho.setText("");
				txtTenKhuVuc.setText("");
				txtTenSanPham.setText("");
				txtSoLuongSanPham.setText("");
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String maKho = (String) tableModel.getValueAt(selectedRow, 0);
					DatabaseOperations.deleteKhoHang(maKho);
					loadKhoHangData();
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = txtTimKiem.getText().trim().toLowerCase();
				table.clearSelection();
				for (int row = 0; row < table.getRowCount(); row++) {
					boolean match = false;
					for (int col = 0; col < table.getColumnCount(); col++) {
						Object cellValue = table.getValueAt(row, col);
						if (cellValue != null && cellValue.toString().toLowerCase().contains(keyword)) {
							match = true;
							break;
						}
					}
					if (match) {
						table.addRowSelectionInterval(row, row);
					}
				}
			}
		});

		loadKhoHangData();
	}

	private void loadKhoHangData() {
		tableModel.setRowCount(0);
		ArrayList<KhoHang> khoHangs = DatabaseOperations.getAllKhoHang();
		for (KhoHang khoHang : khoHangs) {
			tableModel.addRow(new Object[] { khoHang.getMaKho(), khoHang.getTenKhuVuc(), khoHang.getTenSanPham(),
					khoHang.getSoLuongSanPham() });
		}
	}
}
