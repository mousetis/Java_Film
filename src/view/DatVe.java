package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import model.Movies;

public class DatVe extends JPanel implements ActionListener{
	private static Movies phimDangChon; 
	private JLabel lbTitlePhim;
	private JDateChooser findDateChooser;
	private JLabel lbNgayChieu;
	private JLabel lbTenPhim;
	private JTextField txtTenPhim;
	private JLabel lbGioBatDau;
	private SpinnerDateModel modelBD;
	private JSpinner spnGioBD;
	private DateEditor editorBD;
	private JLabel lbTitleKH;
	private JLabel lbTenKH;
	private JTextField txtTenKH;
	private JLabel lbEmail;
	private JTextField txtEmail;
	private JLabel lbTenGhe;
	private JLabel lbGia;
	private JLabel lbTitleCN;
	private JLabel lbTitleDV;
	private JLabel lbBongNgo;
	private JSpinner spnBongNgo;
	private JLabel lbTienBN;
	private JLabel lbNuocNgot;
	private JSpinner spnNuocNgot;
	private JButton btnThanhToan;
	private JButton btnLamMoi;
	private JLabel lbViTri;
	private JLabel lbGiaGhe;
	private Box boxGhe;
	private ImageIcon iconPhim;
	private Image imgPhim;
	private JLabel lbPhim;


	public DatVe(Movies phim) {
		Font font = new Font ("Arial",Font.BOLD,16);
		Font font2 = new Font ("Arial",Font.BOLD,20);
		Font font3 = new Font ("Arial",Font.BOLD,18);
		
		this.phimDangChon = phim;
		
		Box boxCent = new Box(BoxLayout.X_AXIS);
		
		JPanel pnlLeft = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Box boxLeft = new Box(BoxLayout.Y_AXIS);
		boxLeft.add(Box.createHorizontalStrut(35));
		
		Box boxPhim = new Box(BoxLayout.Y_AXIS);
		boxPhim.add(Box.createHorizontalStrut(15));
		boxPhim.setBorder(BorderFactory.createTitledBorder(""));
		
		JPanel boxPhim1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		boxPhim1.add(lbTitlePhim = new JLabel("THÔNG TIN PHIM"));
		lbTitlePhim.setFont(font2);
		boxPhim.add(boxPhim1);
		boxPhim.add(Box.createVerticalStrut(15));
		
		Box boxPhimTrong = new Box(BoxLayout.X_AXIS);
		
		Box boxPhimLeft = new Box(BoxLayout.Y_AXIS);
		boxPhimLeft.setPreferredSize(new Dimension(270, 150));
		
		
		Box boxPhim2 = new Box(BoxLayout.X_AXIS);
		boxPhim2.add(Box.createHorizontalStrut(20));
		boxPhim2.add(lbTenPhim = new JLabel("Tên phim:"));
		lbTenPhim.setFont(font);
		boxPhim2.add(Box.createHorizontalStrut(10));
		boxPhim2.add(txtTenPhim = new JTextField());
		txtTenPhim.setPreferredSize(new Dimension(50, 30));
		txtTenPhim.setEnabled(false);
		boxPhim2.add(Box.createHorizontalStrut(10));
		boxPhimLeft.add(boxPhim2);
		boxPhimLeft.add(Box.createVerticalStrut(15));
		
		Box boxPhim3 = new Box(BoxLayout.X_AXIS);
		findDateChooser = new JDateChooser();
		findDateChooser.setDateFormatString("dd-MM-yyyy"); // format ngày
		findDateChooser.setPreferredSize(new Dimension(50, 30)); // chỉnh kích thước
		boxPhim3.add(Box.createHorizontalStrut(20));
		boxPhim3.add(lbNgayChieu = new JLabel("Ngày chiếu:"));
		lbNgayChieu.setFont(font);
		boxPhim3.add(Box.createHorizontalStrut(25));
		boxPhim3.add(findDateChooser);
		boxPhim3.add(Box.createHorizontalStrut(10));
		boxPhimLeft.add(boxPhim3);
		boxPhimLeft.add(Box.createVerticalStrut(15));
		
		//Field chọn giờ bắt dầu nằm trên phần bên phải
		Box boxPhim4 = new Box(BoxLayout.X_AXIS);
		boxPhim4.add(Box.createHorizontalStrut(20));
		boxPhim4.add(lbGioBatDau = new JLabel("Giờ bắt đầu:"));
		lbGioBatDau.setFont(font);
		boxPhim4.add(Box.createHorizontalStrut(20));
		 // Spinner model với thời gian
		modelBD = new SpinnerDateModel(); //model (mô hình dữ liệu) cho spinner kiểu ngày/giờ.Mặc định nó sẽ lấy thời gian hiện tại làm giá trị ban đầu.
		spnGioBD = new JSpinner(modelBD); //Tạo một JSpinner mới với kiểu dữ liệu là ngày giờ từ SpinnerDateModel.
		// Định dạng hiển thị giờ và phút
		editorBD = new JSpinner.DateEditor(spnGioBD, "HH:mm");  //Tạo một editor (bộ hiển thị/định dạng) cho spinner có định dạng kiểu "giờ:phút"
		spnGioBD.setEditor(editorBD);  //Gán bộ hiển thị editorBD vừa tạo vào spinner spnGioBD, để nó dùng định dạng giờ phút
		spnGioBD.setPreferredSize(new Dimension(230, 30));
		boxPhim4.add(spnGioBD);
		boxPhim4.add(Box.createHorizontalStrut(10));
		boxPhimLeft.add(boxPhim4);
		boxPhimLeft.add(Box.createVerticalStrut(15));
		
		boxPhimTrong.add(boxPhimLeft);
		boxPhimTrong.add(Box.createHorizontalStrut(10));
		
		Box boxPhimRight = new Box(BoxLayout.Y_AXIS);
		boxPhimRight.setBorder(BorderFactory.createTitledBorder(""));
		boxPhimRight.setPreferredSize(new Dimension(200, 150));
		
        lbPhim = new JLabel();
        
        boxPhimRight.add(lbPhim);
		
		boxPhimTrong.add(boxPhimRight);
		boxPhimTrong.add(Box.createHorizontalStrut(10));
		
		boxPhim.add(boxPhimTrong);
		boxPhim.add(Box.createHorizontalStrut(15));
		
		boxLeft.add(boxPhim);
		boxLeft.add(Box.createVerticalStrut(20));
		
		//===============================================================
		Box boxKhachHang = new Box(BoxLayout.Y_AXIS);
		
		Box boxKH1 = new Box(BoxLayout.X_AXIS);
		boxKH1.add(lbTitleKH = new JLabel("KHÁCH HÀNG"));
		lbTitleKH.setFont(font2);
		boxKhachHang.add(boxKH1);
		boxKhachHang.add(Box.createVerticalStrut(15));
		
		Box boxKH2 = new Box(BoxLayout.X_AXIS);
		boxKH2.add(Box.createHorizontalStrut(25));
		boxKH2.add(lbTenKH = new JLabel("Tên khách hàng:"));
		lbTenKH.setFont(font);
		boxKH2.add(Box.createHorizontalStrut(15));
		boxKH2.add(txtTenKH  = new JTextField());
		txtTenKH.setPreferredSize(new Dimension(50, 30));
		boxKH2.add(Box.createHorizontalStrut(120));
		boxKhachHang.add(boxKH2);
		boxKhachHang.add(Box.createVerticalStrut(15));
		
		Box boxKH3 = new Box(BoxLayout.X_AXIS);
		boxKH3.add(Box.createHorizontalStrut(25));
		boxKH3.add(lbEmail = new JLabel("Email:"));
		lbEmail.setFont(font);
		boxKH3.add(Box.createHorizontalStrut(95));
		boxKH3.add(txtEmail  = new JTextField());
		txtEmail.setPreferredSize(new Dimension(50, 30));
		boxKH3.add(Box.createHorizontalStrut(120));
		boxKhachHang.add(boxKH3);
		
		boxLeft.add(boxKhachHang);
		boxLeft.add(Box.createVerticalStrut(20));
		
		//================================================================
		Box boxChoNgoi = new Box(BoxLayout.Y_AXIS);
		
		Box boxCN1 = new Box(BoxLayout.X_AXIS);
		boxCN1.add(lbTitleCN = new JLabel("CHỖ NGỒI"));
		lbTitleCN.setFont(font2);
		boxChoNgoi.add(boxCN1);
		boxChoNgoi.add(Box.createVerticalStrut(15));
		
		JPanel boxCN2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		boxCN2.add(Box.createHorizontalStrut(15));
		boxCN2.add(lbViTri = new JLabel("Vị trí ghế:"));
		lbViTri.setFont(font);
		boxCN2.add(Box.createHorizontalStrut(5));
		boxCN2.add(lbTenGhe = new JLabel(""));
		boxCN2.add(Box.createHorizontalStrut(25));
		boxChoNgoi.add(boxCN2);
		boxChoNgoi.add(Box.createVerticalStrut(15));
		
		JPanel boxCN3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		boxCN3.add(Box.createHorizontalStrut(15));
		boxCN3.add(lbGiaGhe = new JLabel("Giá:"));
		lbGiaGhe.setFont(font);
		boxCN3.add(Box.createHorizontalStrut(5));
		boxCN3.add(lbGia  = new JLabel(""));
		boxCN3.add(Box.createHorizontalStrut(25));
		boxChoNgoi.add(boxCN3);
		
		boxLeft.add(boxChoNgoi);
		boxLeft.add(Box.createVerticalStrut(20));
		
		//=================================================================
		Box boxDichVu = new Box(BoxLayout.Y_AXIS);
		
		Box boxDV1 = new Box(BoxLayout.X_AXIS);
		boxDV1.add(lbTitleDV = new JLabel("DỊCH VỤ KHÁC"));
		lbTitleDV.setFont(font2);
		boxDichVu.add(boxDV1);
		boxDichVu.add(Box.createVerticalStrut(15));
		
		Box boxDV2 = new Box(BoxLayout.X_AXIS);
		boxDV2.add(Box.createHorizontalStrut(25));
		boxDV2.add(lbBongNgo = new JLabel("Bỏng ngô:"));
		lbBongNgo.setFont(font);
		SpinnerNumberModel monthModel = new SpinnerNumberModel(0, 0, 100, 1);  // giúp có thể chọn một giá trị số bằng cách bấm nút tăng/giảm. Giá trị ban đầu là 0, giá trị nhỏ nhất là 0, giá trị lớn nhất là 200, bước nhảy là 1 
	    spnBongNgo = new JSpinner(monthModel);
	    spnBongNgo.setPreferredSize(new Dimension(5, 30));
	    boxDV2.add(Box.createHorizontalStrut(25));
		boxDV2.add(spnBongNgo);
		boxDV2.add(Box.createHorizontalStrut(15));
		boxDV2.add(lbTienBN = new JLabel("0 VNĐ"));
		boxDV2.add(Box.createHorizontalStrut(150));
		boxDichVu.add(boxDV2);
		boxDichVu.add(Box.createVerticalStrut(15));
		
		Box boxDV3 = new Box(BoxLayout.X_AXIS);
		boxDV3.add(Box.createHorizontalStrut(25));
		boxDV3.add(lbNuocNgot = new JLabel("Nước ngọt:"));
		lbNuocNgot.setFont(font);
		SpinnerNumberModel monthModel1 = new SpinnerNumberModel(0, 0, 100, 1);  // giúp có thể chọn một giá trị số bằng cách bấm nút tăng/giảm. Giá trị ban đầu là 0, giá trị nhỏ nhất là 0, giá trị lớn nhất là 200, bước nhảy là 1
	    spnNuocNgot = new JSpinner(monthModel1);
	    spnNuocNgot.setPreferredSize(new Dimension(5, 30));
	    boxDV3.add(Box.createHorizontalStrut(15));
		boxDV3.add(spnNuocNgot);
		boxDV3.add(Box.createHorizontalStrut(15));
		boxDV3.add(lbTienBN = new JLabel("0 VNĐ"));
		boxDV3.add(Box.createHorizontalStrut(150));
		boxDichVu.add(boxDV3);
		boxDichVu.add(Box.createVerticalStrut(15));
		
		boxLeft.add(boxDichVu);
		boxLeft.add(Box.createVerticalStrut(20));
		
		//===============================================================
		Box boxThanhToan = new Box(BoxLayout.X_AXIS);
		boxThanhToan.add(btnThanhToan = new JButton("Thanh toán"));
		btnThanhToan.setPreferredSize(new Dimension(50, 30));
		btnThanhToan.setFont(font);
		btnThanhToan.setBackground(Color.CYAN);
		boxThanhToan.add(Box.createHorizontalStrut(30));
		boxThanhToan.add(btnLamMoi = new JButton("Làm mới"));
		btnLamMoi.setPreferredSize(new Dimension(50, 30));
		btnLamMoi.setFont(font);
		btnLamMoi.setBackground(Color.ORANGE);
		boxLeft.add(boxThanhToan);
		
		boxLeft.add(Box.createHorizontalStrut(15));
		pnlLeft.add(boxLeft);
		
		//================================================================
		//================================================================
		
		JPanel pnlRight = new JPanel(new BorderLayout(10, 10));
		pnlRight.setPreferredSize(new Dimension(650, 650));
		pnlRight.setBorder(BorderFactory.createTitledBorder(""));

		//---------------------------------------------------------------
		JLabel manHinh = new JLabel("Màn hình", SwingConstants.CENTER);
        manHinh.setOpaque(true);
        manHinh.setBackground(Color.DARK_GRAY);
        manHinh.setForeground(Color.WHITE);
        manHinh.setFont(new Font("Arial", Font.BOLD, 16));
        manHinh.setPreferredSize(new Dimension(100, 40));
        pnlRight.add(manHinh, BorderLayout.NORTH);
		
		//---------------------------------------------------------------
        JPanel pnlGhe = new JPanel(new GridLayout(8, 10, 5, 5));
        char rowChar = 'A';
        for (int i = 0; i < 8; i++) {

            for (int j = 1; j <= 10; j++) {
                String label = rowChar + String.valueOf(j);
                JButton btn = new JButton(label);
                btn.setBackground(Color.GREEN); // Ghế trống
                btn.setOpaque(true);
                btn.setForeground(Color.BLACK);
                btn.setFont(new Font("Arial", Font.BOLD, 12));
                btn.setPreferredSize(new Dimension(5, 2));
        		
                pnlGhe.add(btn);
            }
            rowChar++;
        }
        
        pnlRight.add(pnlGhe, BorderLayout.CENTER);
		
		//---------------------------------------------------------------
        JPanel pnlTrangThai = new JPanel();
        pnlTrangThai.setLayout(new FlowLayout());

        pnlTrangThai.add(taoMauGiaiThich("Đã mua", Color.RED));
        pnlTrangThai.add(taoMauGiaiThich("Đang chọn", Color.BLUE));
        pnlTrangThai.add(taoMauGiaiThich("Ghế trống", Color.GREEN));
        pnlRight.add(pnlTrangThai, BorderLayout.SOUTH);
        
        //---------------------------------------------------------------
        boxCent.add(Box.createHorizontalStrut(15));
        boxCent.add(pnlLeft);
		boxCent.add(Box.createHorizontalStrut(15));
		boxCent.add(pnlRight);
		boxCent.add(Box.createHorizontalStrut(15));
		
		add(boxCent);
		
		hienThiThongTinPhim();
		
		btnThanhToan.addActionListener(this);
		btnLamMoi.addActionListener(this);

	}
	
	 private void hienThiThongTinPhim() {
	        if (phimDangChon != null) {
	            txtTenPhim.setText(phimDangChon.getTitle());
	            try {
	                ImageIcon icon = new ImageIcon(getClass().getResource(phimDangChon.getImg()));
	                Image img = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
	                iconPhim.setImage(img);
	                lbPhim.setIcon(new ImageIcon(img)); // Thêm JLabel lbPhim vào class
	            } catch (Exception e) {
	                System.err.println("Không thể load hình ảnh: " + phimDangChon.getImg());
	            }
	        }
	    }
	
	 public void capNhatThongTinPhim(Movies phim) {
		    this.phimDangChon = phim;
		    hienThiThongTinPhim();
		}
	
	private JPanel taoMauGiaiThich(String text, Color color) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton b = new JButton();
        b.setEnabled(false);
        b.setBackground(color);
        b.setPreferredSize(new Dimension(30, 20));
        p.add(b);
        p.add(new JLabel(text));
        return p;
    }
	
	public void xoaTrang() {
		findDateChooser.setDate(new Date());
		Date now = new Date();
	    spnGioBD.setValue(now);
	    txtTenKH.setText("");
	    txtEmail.setText("");
	    lbTenGhe.setText("");
	    lbGia.setText("");
	    spnBongNgo.setValue(0);
	    spnNuocNgot.setValue(0);
	}

	
	public static void main(String[] args) {
		new DatVe(phimDangChon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThanhToan)) {
			try {
				new ThanhToan();
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		else {
			xoaTrang();
		}
		
	}
}
