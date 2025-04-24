package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.print.Book;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ListNV extends JPanel{
	private JLabel lbMaNV;
	private JTextField txtMaNV;
	private JLabel lbTenNV;
	private JTextField txtTenNV;
	private DefaultTableModel tblmodel;
	private JTable table;
	private TableRowSorter<TableModel> sorter;
	private JTextField txtMaNhanVien;
	private JLabel lbHoTen;
	private JTextField txtHoTen;
	private JLabel lbSDT;
	private JTextField txtSDT;
	private JLabel lbEmail;
	private JTextField txtEmail;
	private JLabel lbGioiTinh;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JLabel lbNghiViec;
	private JCheckBox cbNghiViec;
	private JLabel lbQuyen;
	private JButton btnLuu;
	private JButton btnCapMK;
	private JButton btnNghiViec;
	private JComboBox comboxQuyen;
	private ButtonGroup rdPhai;
	private JButton btnTim;
	private JLabel lbMaNV2;
	private JButton btnTimKiem;

	public ListNV() {
		Font font = new Font ("Times New Roman",Font.BOLD,16);
		
		//Phần nhập mã nhân viên và tên nhân viên cần tìm.
		JPanel pnlNor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnlNor.add(Box.createVerticalStrut(50));
		Box box1 = new Box(BoxLayout.X_AXIS);
		box1.add(Box.createHorizontalStrut(30));
		box1.add(lbMaNV = new JLabel("Mã nhân viên:"));
		lbMaNV.setFont(font);
		box1.add(Box.createHorizontalStrut(20));
		box1.add(txtMaNV = new JTextField(25));
		txtMaNV.setPreferredSize(new Dimension(25, 30));
		box1.add(Box.createHorizontalStrut(30));
		box1.add(lbTenNV = new JLabel("Tên nhân viên:"));
		lbTenNV.setFont(font);
		box1.add(Box.createHorizontalStrut(20));
		box1.add(txtTenNV = new JTextField(25));
		txtTenNV.setPreferredSize(new Dimension(25, 30));
		box1.add(Box.createHorizontalStrut(30));
		box1.add(btnTim = new JButton("Tìm kiếm"));
		btnTim.setFont(font);
		btnTim.setBackground(Color.ORANGE);
		box1.add(Box.createHorizontalStrut(35));
		pnlNor.add(Box.createVerticalStrut(50));
		pnlNor.add(box1);
		add(pnlNor, BorderLayout.NORTH);
		
		//Phần chứa danh sách nhân viên và sửa thông tin nhân viên
		Box box2 = new Box(BoxLayout.X_AXIS);
		
		//Phần bên trái chứa bảng danh sách nhân viên
		JPanel pnlLeft = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Box boxTable = new Box(BoxLayout.Y_AXIS);
		String[] colNames = {"Mã nhân viên", "Họ tên", "Email"};
		tblmodel = new DefaultTableModel(colNames, 0);
		table = new JTable(tblmodel);
		boxTable.add(new JScrollPane(table));
		sorter = new TableRowSorter<TableModel>(tblmodel);
		table.setFont(font);
		table.setRowSorter(sorter);
		pnlLeft.add(boxTable);
		box2.add(pnlLeft);
		
		
		//============================================================================
		//Phần bên phải chứa chức năng cập nhật thông tin và xóa nhân viên
		JPanel pnlRight = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Box box2Right = new Box(BoxLayout.Y_AXIS);
		box2Right.add(Box.createVerticalStrut(20));
		
		//Field nhập mã nhân viên 
		Box boxRight1 = new Box(BoxLayout.X_AXIS);
		boxRight1.add(Box.createHorizontalStrut(15));
		boxRight1.add(lbMaNV2 = new JLabel("Mã nhân viên:"));
		lbMaNV2.setFont(font);
		boxRight1.add(Box.createHorizontalStrut(15));
		boxRight1.add(txtMaNhanVien = new JTextField(30));
		txtMaNhanVien.setPreferredSize(new Dimension(25, 30));
		boxRight1.add(Box.createHorizontalStrut(15));
		box2Right.add(boxRight1);
		box2Right.add(Box.createVerticalStrut(20));
		
		//Field nhập tên nhân viên 
		Box boxRight2 = new Box(BoxLayout.X_AXIS);
		boxRight2.add(Box.createHorizontalStrut(15));
		boxRight2.add(lbHoTen = new JLabel("Họ tên:"));
		lbHoTen.setFont(font);
		boxRight2.add(Box.createHorizontalStrut(60));
		boxRight2.add(txtHoTen = new JTextField(20));
		txtHoTen.setPreferredSize(new Dimension(25, 30));
		boxRight2.add(Box.createHorizontalStrut(15));
		box2Right.add(boxRight2);
		box2Right.add(Box.createVerticalStrut(20));
		
		//Field nhập số điện thoại của nhân viên 
		Box boxRight3 = new Box(BoxLayout.X_AXIS);
		boxRight3.add(Box.createHorizontalStrut(15));
		boxRight3.add(lbSDT = new JLabel("SĐT:"));
		lbSDT.setFont(font);
		boxRight3.add(Box.createHorizontalStrut(75));
		boxRight3.add(txtSDT = new JTextField(30));
		txtSDT.setPreferredSize(new Dimension(25, 30));
		boxRight3.add(Box.createHorizontalStrut(15));
		box2Right.add(boxRight3);
		box2Right.add(Box.createVerticalStrut(20));
		
		//Field nhập Email nhân viên 
		Box boxRight4 = new Box(BoxLayout.X_AXIS);
		boxRight4.add(Box.createHorizontalStrut(15));
		boxRight4.add(lbEmail = new JLabel("Email:"));
		lbEmail.setFont(font);
		boxRight4.add(Box.createHorizontalStrut(67));
		boxRight4.add(txtEmail = new JTextField(30));
		txtEmail.setPreferredSize(new Dimension(25, 30));
		boxRight4.add(Box.createHorizontalStrut(15));
		box2Right.add(boxRight4);
		box2Right.add(Box.createVerticalStrut(20));
		
		//Field chọn giới tính của nhân viên 
		Box boxRight5 = new Box(BoxLayout.X_AXIS);
		boxRight5.add(lbGioiTinh = new JLabel("Giới tính:"));
		boxRight5.add(Box.createHorizontalStrut(45));
		lbGioiTinh.setFont(font);
		boxRight5.add(rdNam = new JRadioButton("Nam"));
		rdNam.setFont(font);
		boxRight5.add(Box.createHorizontalStrut(10));
		boxRight5.add(rdNu = new JRadioButton("Nữ"));
		rdNu.setFont(font);
		rdPhai = new ButtonGroup();
		rdPhai.add(rdNam);
		rdPhai.add(rdNu);
		boxRight5.add(Box.createHorizontalStrut(190));
		box2Right.add(boxRight5);
		box2Right.add(Box.createVerticalStrut(20));
		
		//Field chọn quyền cho nhân viên
		Box boxRight6 = new Box(BoxLayout.X_AXIS);
		boxRight6.add(Box.createHorizontalStrut(15));
		boxRight6.add(lbQuyen = new JLabel("Quyền:"));
		lbQuyen.setFont(font);
		boxRight6.add(Box.createHorizontalStrut(63));
		comboxQuyen = new JComboBox<>();
		comboxQuyen.addItem("Nhân viên");
		comboxQuyen.addItem("Quản lý");
		comboxQuyen.setFont(font);
		boxRight6.add(comboxQuyen);
		boxRight6.add(Box.createHorizontalStrut(15));
		box2Right.add(boxRight6);
		box2Right.add(Box.createVerticalStrut(40));
		
		//Các nút chức năng lưu, cấp mật khẩu và nghỉ việc
		Box boxRight7 = new Box(BoxLayout.X_AXIS);
		boxRight7.add(btnLuu = new JButton("Lưu"));
		btnLuu.setFont(font);
		btnLuu.setBackground(Color.CYAN);
		boxRight7.add(Box.createHorizontalStrut(20));
		boxRight7.add(btnCapMK = new JButton("Cấp mật khẩu"));
		btnCapMK.setFont(font);
		btnCapMK.setBackground(Color.YELLOW);
		boxRight7.add(Box.createHorizontalStrut(20));
		boxRight7.add(btnNghiViec = new JButton("Nghỉ việc"));
		btnNghiViec.setFont(font);
		btnNghiViec.setBackground(Color.red);
		box2Right.add(boxRight7);
		pnlRight.add(box2Right);
		box2.add(pnlRight);
		add(box2, BorderLayout.CENTER);
		
		
//		setSize(1000, 600);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
	}

	
	public static void main(String[] args) {
		new ListNV();
	}
}
