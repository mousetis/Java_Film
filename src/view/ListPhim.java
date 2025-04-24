package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ListPhim extends JPanel{

	private JLabel lbTimMaPhim;
	private JTextField txtTimMaPhim;
	private JLabel lbTimTenPhim;
	private JTextField txtTimTenPhim;
	private JButton btnTimKiem;
	private JButton btnDangPhatHanh;
	private JButton btnDaDung;
	private DefaultTableModel tblmodel;
	private JTable table;
	private TableRowSorter<TableModel> sorter;
	private JLabel lbMaPhim;
	private JTextField txtMaPhim;
	private JLabel lbTenPhim;
	private JTextField txtTenPhim;
	private JLabel lbDoTuoi;
	private JRadioButton rdTreEm;
	private JRadioButton rdTren16;
	private JRadioButton rdTren18;
	private ButtonGroup rdTuoi;
	private JLabel lbGiaVe;
	private Component spinnerGiaVe;
	private JLabel lbThoiLuong;
	private JSpinner spinnerThoiLuong;
	private JLabel lbThoiGianTao;
	private JLabel lbThoiGian;
	private JButton btnSua;
	private JButton btnDungChieu;
	private JLabel lbTitle2;

	public ListPhim() {
		Font font = new Font ("Arial",Font.BOLD,16);
		Font font2 = new Font ("Arial",Font.BOLD,20);
		
		//Phần khung tổng chứa tất cả
		JPanel pnlCent = new JPanel(new GridLayout(1,2));
		
		//Phần khung bên trái
		JPanel pnlLeft = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Box boxLeft = new Box(BoxLayout.Y_AXIS);
		boxLeft.add(Box.createVerticalStrut(20));
		
		//Field nhập mã phim cần tìm nằm trên phần khung bên trái
		Box boxLeft1 = new Box(BoxLayout.X_AXIS);
		boxLeft1.add(lbTimMaPhim = new JLabel("Mã phim:"));
		lbTimMaPhim.setFont(font);
		boxLeft1.add(Box.createHorizontalStrut(18));
		boxLeft1.add(txtTimMaPhim = new JTextField(20));
		txtTimMaPhim.setPreferredSize(new Dimension(25, 30));
		boxLeft1.add(Box.createHorizontalStrut(110));
		boxLeft.add(boxLeft1);
		boxLeft.add(Box.createVerticalStrut(15));
		
		//Field nhập tên phim cần tìm nằm trên phần khung bên trái
		Box boxLeft2 = new Box(BoxLayout.X_AXIS);
		boxLeft2.add(lbTimTenPhim = new JLabel("Tên phim:"));
		lbTimTenPhim.setFont(font);
		boxLeft2.add(Box.createHorizontalStrut(15));
		boxLeft2.add(txtTimTenPhim = new JTextField(20));
		boxLeft2.add(Box.createHorizontalStrut(15));
		boxLeft2.add(btnTimKiem = new JButton("Tìm kiếm")); 
		btnTimKiem.setFont(font);
		btnTimKiem.setBackground(Color.ORANGE);
		txtTimTenPhim.setPreferredSize(new Dimension(25, 30));
		boxLeft.add(boxLeft2);
		boxLeft.add(Box.createVerticalStrut(15));
		
		//Field các nút thay đổi loại bảng đang phát hàng hoặc đã dừng chiếu nằm trên phần khung bên trái
		Box boxLeft3 = new Box(BoxLayout.X_AXIS);
		boxLeft3.add(btnDangPhatHanh = new JButton("Đang phát hành"));
		btnDangPhatHanh.setFont(font);
		btnDangPhatHanh.setBackground(Color.CYAN);
		boxLeft3.add(Box.createHorizontalStrut(25));
		boxLeft3.add(btnDaDung = new JButton("Đã dừng"));
		btnDaDung.setFont(font);
		btnDaDung.setBackground(Color.RED);
		boxLeft.add(boxLeft3);
		boxLeft.add(Box.createVerticalStrut(15));
		
		//Field table nằm trên phần khung bên trái
		Box boxTable = new Box(BoxLayout.Y_AXIS);
		String[] colNames = {"Mã phim", "Tên phim", "Độ tuổi", "Giá vé", "Thời lượng", "Trạng thái"};
		tblmodel = new DefaultTableModel(colNames, 0);
		table = new JTable(tblmodel);
		boxTable.add(new JScrollPane(table));
		sorter = new TableRowSorter<TableModel>(tblmodel);
		table.setFont(font);
		table.setRowSorter(sorter);
		table.setFont(font);
		boxLeft.add(boxTable);
		
		//Thêm boxLeft vào phần khung bên trái
		pnlLeft.add(boxLeft);
		
		//============================================================================
		//Phần khung bên phải chứa cách field nhập để cập nhật phim nào đó
		JPanel pnlRight = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Box boxRight = new Box(BoxLayout.Y_AXIS);
		boxRight.add(Box.createVerticalStrut(90));
		
		Box boxRight0 = new Box(BoxLayout.X_AXIS);
		boxRight0.add(lbTitle2 = new JLabel("THÔNG TIN PHIM"));
		lbTitle2.setFont(font2);
		lbTitle2.setForeground(Color.GREEN);
		boxRight.add(boxRight0);
		boxRight.add(Box.createVerticalStrut(25));
		
		//Field nhập mã phim nằm trên phần khung bên phải
		Box boxRight1 = new Box(BoxLayout.X_AXIS);
		boxRight1.add(lbMaPhim = new JLabel("Mã phim:"));
		lbMaPhim.setFont(font);
		boxRight1.add(Box.createHorizontalStrut(20));
		boxRight1.add(txtMaPhim = new JTextField(30));
		txtMaPhim.setPreferredSize(new Dimension(25, 30));
		boxRight.add(boxRight1);
		boxRight.add(Box.createVerticalStrut(20));
		
		//Field nhập tên phim nằm trên phần khung bên phải
		Box boxRight2 = new Box(BoxLayout.X_AXIS);
		boxRight2.add(lbTenPhim = new JLabel("Tên phim:"));
		lbTenPhim.setFont(font);
		boxRight2.add(Box.createHorizontalStrut(15));
		boxRight2.add(txtTenPhim = new JTextField(30));
		txtTenPhim.setPreferredSize(new Dimension(25, 30));
		boxRight.add(boxRight2);
		boxRight.add(Box.createVerticalStrut(20));
		
		//Field chọn độ tuổi nằm trên phần khung bên phải
		Box boxRight3 = new Box(BoxLayout.X_AXIS);
		boxRight3.add(lbDoTuoi = new JLabel("Độ tuổi:"));
		lbDoTuoi.setFont(font);
		boxRight3.add(Box.createHorizontalStrut(30));
		boxRight3.add(rdTreEm = new JRadioButton("Trẻ em"));
		rdTreEm.setFont(font);
		boxRight3.add(Box.createHorizontalStrut(15));
		boxRight3.add(rdTren16 = new JRadioButton("16+"));
		rdTren16.setFont(font);
		boxRight3.add(Box.createHorizontalStrut(15));
		boxRight3.add(rdTren18 = new JRadioButton("18+"));
		rdTren18.setFont(font);
		rdTuoi = new ButtonGroup();
		rdTuoi.add(rdTreEm);
		rdTuoi.add(rdTren16);
		rdTuoi.add(rdTren18);
		boxRight.add(boxRight3);
		boxRight3.add(Box.createHorizontalStrut(95));
		boxRight.add(Box.createVerticalStrut(20));
		
		//Field nhập giá vé nằm trên phần khung bên phải
		Box boxRight4 = new Box(BoxLayout.X_AXIS);
		boxRight4.add(lbGiaVe = new JLabel("Giá vé:"));
		lbGiaVe.setFont(font);
		boxRight4.add(Box.createHorizontalStrut(35));
		spinnerGiaVe = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 1000)); //Ô nhập giá trị bằng cách chọn một giá trị số bằng cách bấm nút tăng/giảm
		spinnerGiaVe.setPreferredSize(new Dimension(25, 30));
		boxRight4.add(spinnerGiaVe);
		boxRight.add(boxRight4);
		boxRight.add(Box.createVerticalStrut(20));
		
		//Field nhập thời lượng phim nằm trên phần khung bên phải
		Box boxRight5 = new Box(BoxLayout.X_AXIS);
		boxRight5.add(lbThoiLuong = new JLabel("Thời lượng (phút):"));
		lbThoiLuong.setFont(font);
		boxRight5.add(Box.createHorizontalStrut(15));
		spinnerThoiLuong = new JSpinner(new SpinnerNumberModel(0, 0, 500, 1)); //Ô nhập giá trị bằng cách chọn một giá trị số bằng cách bấm nút tăng/giảm
		spinnerThoiLuong.setPreferredSize(new Dimension(25, 30));
		boxRight5.add(spinnerThoiLuong);
		boxRight.add(boxRight5);
		boxRight.add(Box.createVerticalStrut(20));
		
		//Field hiển thị thời gian đã tạo phim hoặc cập nhật phim nằm trên phần khung bên phải
		JPanel pnlRight6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		Box boxRight6 = new Box(BoxLayout.X_AXIS);
		boxRight6.add(lbThoiGianTao= new JLabel("Thời gian tạo:"));  //lbThoiGianTao là label chỉ nhãn "Thời gian tạo:"
		lbThoiGianTao.setFont(font);
		boxRight6.add(Box.createHorizontalStrut(20));
		boxRight6.add(lbThoiGian = new JLabel(""));	// lbThoiGian là dùng để lấy giá trị thời gian "HH:mm:ss dd-MM-yyyy" tại thời điểm tạo hoặc lưu thay đổi
		lbThoiGian.setFont(font);
		pnlRight6.add(boxRight6);
		boxRight.add(pnlRight6);
		boxRight.add(Box.createVerticalStrut(20));
		
		//Field chức năng sửa hoặc xóa phim nằm trên phần khung bên phải
		Box boxRight7 = new Box(BoxLayout.X_AXIS);
		boxRight7.add(btnSua = new JButton("Sửa"));
		btnSua.setFont(font);
		btnSua.setBackground(Color.CYAN);
		boxRight7.add(Box.createHorizontalStrut(15));
		boxRight7.add(btnDungChieu = new JButton("Dừng chiếu"));
		btnDungChieu.setFont(font);
		btnDungChieu.setBackground(Color.RED);
		boxRight.add(boxRight7);
		boxRight.add(Box.createVerticalStrut(20));
		
		//Thêm boxRight phần khung bên phải
		pnlRight.add(boxRight);
		
		//Thêm khung bên trái và khung bên phải vào khung tổng
		pnlCent.add(pnlLeft);
		pnlCent.add(pnlRight);
		
		//Thêm khung tổng vào JFrame
		add(pnlCent);
		
//		setSize(1000, 600);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListPhim();
	}
}
