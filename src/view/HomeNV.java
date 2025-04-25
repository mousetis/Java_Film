package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import model.Movies;

public class HomeNV extends JFrame implements ActionListener{



	private JButton btnDatVe;
	private JScrollPane cuon;
	private JButton accountBtn;
	private JPanel headerPanel;
	private JLabel lbTimTenPhim;
	private JTextField txtTimTenPhim;
	private JLabel lbTimTheLoai;
	private JTextField txtTimTheLoai;
	private JButton btnTimKiem;
	private Box pnlCent;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JButton btnXoaTrang;
	private JPanel pnlKhuVucPhim;
	private ArrayList<Movies> danhSachPhim;
	private DatVe datVePanel;

	public HomeNV() {
		Font font = new Font ("Arial",Font.BOLD,18);
		
		headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setPreferredSize(new Dimension(0, 50));

        // Logo bên trái
        ImageIcon iconLogo = new ImageIcon(getClass().getResource("/img/CGV_4d6c9e8f1f.png"));
        Image imgLogo = iconLogo.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH); // width, height
        JLabel logoLabel = new JLabel(new ImageIcon(imgLogo));
        
        logoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        logoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Đổi con trỏ chuột

        // Xử lý khi nhấn vào logo để quay lại danh sách phim
        logoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {         	
            	cardLayout.show(cardPanel, "HOME");
            }
        });
        
        
        
        headerPanel.add(logoLabel, BorderLayout.WEST);

        // Account bên phải
        ImageIcon iconAcc = new ImageIcon(getClass().getResource("/img/account-icon-33-removebg-preview.png"));
        Image imgAcc = iconAcc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel lbAcc = new JLabel(new ImageIcon(imgAcc));
        
        lbAcc.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lbAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Đổi con trỏ chuột

        
        // Xử lý khi nhấn vào logo account sẽ chuyển đến panel thông tin nhân viên
        lbAcc.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
				cardLayout.show(cardPanel, "THONG_TIN_NV");
            }
        });
        
        headerPanel.add(lbAcc, BorderLayout.EAST);
        

        add(headerPanel, BorderLayout.NORTH);
        
        //==========================================================================
   
        
        pnlCent = new Box(BoxLayout.Y_AXIS);
        pnlCent.add(Box.createVerticalStrut(15));
        
        JPanel pnlTK = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Box boxTimKiem = new Box(BoxLayout.X_AXIS);
        boxTimKiem.add(lbTimTenPhim = new JLabel("Tên phim:"));
        lbTimTenPhim.setFont(font);
        boxTimKiem.add(Box.createHorizontalStrut(20));
        boxTimKiem.add(txtTimTenPhim = new JTextField(25));
        boxTimKiem.add(Box.createHorizontalStrut(20));
        boxTimKiem.add(lbTimTheLoai = new JLabel("Thể loại:"));
        lbTimTheLoai.setFont(font);
        boxTimKiem.add(Box.createHorizontalStrut(20));
        boxTimKiem.add(txtTimTheLoai = new JTextField(25));
        boxTimKiem.add(Box.createHorizontalStrut(20));
        boxTimKiem.add(btnTimKiem = new JButton("Tìm kiếm"));
        btnTimKiem.setFont(font);
        btnTimKiem.setBackground(Color.CYAN);
        boxTimKiem.add(Box.createHorizontalStrut(20));
        boxTimKiem.add(btnXoaTrang = new JButton("Xóa trắng"));
        btnXoaTrang.setFont(font);
        btnXoaTrang.setBackground(Color.GREEN);
        pnlTK.add(boxTimKiem);
        
        pnlCent.add(pnlTK);
        pnlCent.add(Box.createVerticalStrut(15));
        
        pnlKhuVucPhim = new JPanel(new GridLayout(0, 4, 20, 20));
        pnlKhuVucPhim.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        cuon = new JScrollPane(pnlKhuVucPhim);
        cuon.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        // Tạo danh sách phim mẫu
        danhSachPhim = new ArrayList<>();
        danhSachPhim.add(new Movies("/img/phim1.jpg", "TÌM XÁC: MA KHÔNG ĐẦU", 119, "Hài, Kinh Dị", 18 , LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim2.png", "MẸ QUỶ CON MA", 97,"Kinh Dị", 18, LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim3.png", "ĐẦU XUÔI ĐUÔI ĐÚT LÓT", 106, "Hài, Tâm Lý", 16, LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim4.png", "DUNE: HÀNH TINH CÁT", 166,"Hành Động, Phiêu Lưu, Tâm Lý", 18, LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim1.jpg", "TÌM XÁC: MA KHÔNG ĐẦU", 119, "Hài, Kinh Dị", 18 , LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim2.png", "MẸ QUỶ CON MA", 97,"Kinh Dị", 18, LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim3.png", "ĐẦU XUÔI ĐUÔI ĐÚT LÓT", 106, "Hài, Tâm Lý", 16, LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim4.png", "DUNE: HÀNH TINH CÁT", 166,"Hành Động, Phiêu Lưu, Tâm Lý", 18, LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim1.jpg", "TÌM XÁC: MA KHÔNG ĐẦU", 119, "Hài, Kinh Dị", 18 , LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim2.png", "MẸ QUỶ CON MA", 97,"Kinh Dị", 18, LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim3.png", "ĐẦU XUÔI ĐUÔI ĐÚT LÓT", 106, "Hài, Tâm Lý", 16, LocalDate.of(2025, 4, 18)));
        danhSachPhim.add(new Movies("/img/phim4.png", "DUNE: HÀNH TINH CÁT", 166,"Hành Động, Phiêu Lưu, Tâm Lý", 18, LocalDate.of(2025, 4, 18)));

        // Thêm từng thẻ phim vào panel
        for (Movies phim : danhSachPhim) {
            pnlKhuVucPhim.add(taoThePhim(phim));
        }
        
        pnlCent.add(cuon);
        
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        
        datVePanel = new DatVe(null);
        cardPanel.add(pnlCent, "HOME");
        cardPanel.add(datVePanel, "DAT_VE");
        cardPanel.add(new ThongTinNNV(this), "THONG_TIN_NV");
        
        // Thêm cardPanel vào JFrame
        add(cardPanel, BorderLayout.CENTER);
        
        
        
        
//        add(pnlCent, BorderLayout.CENTER);
        pnlKhuVucPhim.setBackground(Color.WHITE);
        cuon.getViewport().setBackground(Color.WHITE);
        
        btnXoaTrang.addActionListener(this);
        btnTimKiem.addActionListener(this);
        
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private JPanel taoThePhim(Movies phim) {
	    Font font = new Font ("Arial",Font.BOLD,18);
	    JPanel pnlThePhim = new JPanel();
	    pnlThePhim.setLayout(new BoxLayout(pnlThePhim, BoxLayout.Y_AXIS));
	    pnlThePhim.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    pnlThePhim.setBackground(Color.WHITE);

	    ImageIcon iconGoc = new ImageIcon(getClass().getResource(phim.getImg()));
	    Image anhThayDoi = iconGoc.getImage().getScaledInstance(180, 260, Image.SCALE_SMOOTH);
	    JLabel lbAnh = new JLabel(new ImageIcon(anhThayDoi));
	  
	    JLabel lbTenPhim = new JLabel(phim.getTitle());
	    lbTenPhim.setFont(font);
	  
	    JLabel lbTheLoai = new JLabel("Thể loại: " + phim.getDescription());
	    JLabel lbDoTuoi = new JLabel("Độ tuổi: " + phim.getAgeRating() + "+");
	    JLabel lbThoiLuong = new JLabel("Thời lượng: " + phim.getDuration() + " phút");
	    JLabel lbKhoiChieu = new JLabel("Khởi chiếu: " + phim.getReleaseDate());
	    
	    pnlThePhim.add(Box.createHorizontalStrut(10));
	    pnlThePhim.add(Box.createVerticalStrut(10));
	    pnlThePhim.add(lbAnh);
	    pnlThePhim.add(Box.createVerticalStrut(5));
	    pnlThePhim.add(lbTenPhim);
	    pnlThePhim.add(Box.createVerticalStrut(5));
	    pnlThePhim.add(lbTheLoai);
	    pnlThePhim.add(Box.createVerticalStrut(5));
	    pnlThePhim.add(lbDoTuoi);
	    pnlThePhim.add(Box.createVerticalStrut(5));
	    pnlThePhim.add(lbThoiLuong);
	    pnlThePhim.add(Box.createVerticalStrut(5));
	    pnlThePhim.add(lbKhoiChieu);
	    pnlThePhim.add(Box.createVerticalStrut(5));
	    pnlThePhim.add(btnDatVe = new JButton("Đặt vé"));
	    btnDatVe.setBackground(Color.CYAN);
	    pnlThePhim.add(Box.createVerticalStrut(10));
	    
	    btnDatVe.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	datVePanel.capNhatThongTinPhim(phim);
	        	cardLayout.show(cardPanel, "DAT_VE");
	        }
	    });
	    
	    return pnlThePhim;
	}
	
	private void timKiemPhim() {
	    String tenPhim = txtTimTenPhim.getText().trim().toLowerCase();
	    String theLoai = txtTimTheLoai.getText().trim().toLowerCase();

	    pnlKhuVucPhim.removeAll();

	    for (Movies phim : danhSachPhim) {
	        if (phim.getTitle().toLowerCase().contains(tenPhim)
	         && phim.getDescription().toLowerCase().contains(theLoai)) {
	            pnlKhuVucPhim.add(taoThePhim(phim));
	        }
	    }

	    pnlKhuVucPhim.revalidate();
	    pnlKhuVucPhim.repaint();
	}
	
	public void closeWindow() {
        this.dispose();
    }
	
	public void xoaTrang() {
		txtTimTenPhim.setText("");
		txtTimTheLoai.setText("");
		txtTimTenPhim.requestFocus();
	}
	
	public static void main(String[] args) {
		new HomeNV();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if(o.equals(btnTimKiem)) {
			timKiemPhim();
		}
	}
}
