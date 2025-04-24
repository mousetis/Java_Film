package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
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

public class HomeNV extends JFrame{
	public HomeNV() {
		Font font = new Font ("Arial",Font.BOLD,18);
		
		JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setPreferredSize(new Dimension(0, 50));

        // Logo bên trái
        ImageIcon iconLogo = new ImageIcon(getClass().getResource("/img/CGV_4d6c9e8f1f.png"));
        Image imgLogo = iconLogo.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH); // width, height
        JLabel logoLabel = new JLabel(new ImageIcon(imgLogo));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        headerPanel.add(logoLabel, BorderLayout.WEST);

        // Account bên phải
        ImageIcon iconAcc = new ImageIcon(getClass().getResource("/img/account-icon-33-removebg-preview.png"));
        Image imgAcc = iconAcc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JButton accountBtn = new JButton(new ImageIcon(imgAcc));
        accountBtn.setContentAreaFilled(false);
        accountBtn.setBorderPainted(false);
        accountBtn.setFocusPainted(false);

        // Đặt accountBtn vào panel phải để canh phải
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(100, 70));
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(accountBtn, BorderLayout.EAST);

        headerPanel.add(rightPanel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);
        
        //==========================================================================
        JPanel pnlCent = new JPanel();
        
        JPanel pnlKhuVucPhim = new JPanel(new GridLayout(0, 4, 20, 20));
        pnlKhuVucPhim.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JScrollPane cuon = new JScrollPane(pnlKhuVucPhim);
        cuon.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        
        
        
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
//	private JPanel taoThePhim(Phim phim) {
//		Font font = new Font ("Arial",Font.BOLD,18);
//		
//		JPanel pnlThePhim = new JPanel();
//        pnlThePhim.setLayout(new BoxLayout(pnlThePhim, BoxLayout.Y_AXIS));
//        pnlThePhim.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        pnlThePhim.setBackground(Color.WHITE);
//
//        
//        
//        
////      ImageIcon iconGoc = new ImageIcon(getClass().getResource(phim.duongDanAnh));
//        ImageIcon iconGoc = new ImageIcon(getClass().getResource("/img/account-icon-33-removebg-preview.png"));
//        Image anhThayDoi = iconGoc.getImage().getScaledInstance(180, 260, Image.SCALE_SMOOTH);
//        JLabel lbAnh = new JLabel(new ImageIcon(anhThayDoi));
//      
//      
////      JLabel tenPhim = new JLabel(phim.ten);
//        JLabel lbTenPhim = new JLabel("Conan");
//        lbTenPhim.setFont(font);
//      
////      JLabel theLoai = new JLabel("Thể loại: " + phim.theLoai);
////      JLabel thoiLuong = new JLabel("Thời lượng: " + phim.thoiLuong + " phút");
////      JLabel khoiChieu = new JLabel("Khởi chiếu: " + phim.ngayKhoiChieu);
//      
//        JLabel lbTheLoai = new JLabel("Thể loại: " + "Hoạt hình");
//        JLabel lbThoiLuong = new JLabel("Thời lượng: " + "120" + " phút");
//        JLabel lbKhoiChieu = new JLabel("Khởi chiếu: " + "11-11-2025");
//        
//        
//		pnlThePhim.add(lbAnh);
//		pnlThePhim.add(lbTenPhim);
//		pnlThePhim.add(lbTheLoai);
//		pnlThePhim.add(lbThoiLuong);
//		pnlThePhim.add(lbKhoiChieu);
//        
//        return pnlThePhim;
//    }
	
	public static void main(String[] args) {
		new HomeNV();
	}
}
