package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class HomeQL extends JFrame implements ActionListener{
	private Container panelImage;
	private JMenuItem menuItemExit;
	private CardLayout cardLayout;
	private JPanel cardPanel;

	public HomeQL() {
		setTitle("Trang quản lý");
		Font font = new Font ("Arial",Font.BOLD,16);
		
		 // Panel chứa các menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);

        // Tạo các menu
        JMenu menuNhanVien = new JMenu("Nhân viên");
        menuNhanVien.setFont(font);
        JMenu menuPhim = new JMenu("Phim");
        menuPhim.setFont(font);
        JMenu menuLichChieu = new JMenu("Lịch chiếu");
        menuLichChieu.setFont(font);
        JMenu menuThongKe = new JMenu("Thống kê");
        menuThongKe.setFont(font);
        
        // Tạo các menu item (submenu)
        //menu item Nhân viên
        JMenuItem itemDSNV = new JMenuItem("Danh sách nhân viên");
        JMenuItem itemThemNV = new JMenuItem("Thêm nhân viên");

        //menu item Phim
        JMenuItem itemDSPhim = new JMenuItem("Danh sách phim");
        JMenuItem itemThemPhim = new JMenuItem("Thêm phim");
        
        //menu item Lịch chiếu
        JMenuItem itemDSlichChieu = new JMenuItem("Danh sách lịch chiếu");
        JMenuItem itemThemLichChieu = new JMenuItem("Thêm lịch chiếu");

        //menu item Phim
        JMenuItem itemDoanhThu = new JMenuItem("Danh thu");
        JMenuItem itemVeBan = new JMenuItem("Vé bán");
        JMenuItem itemPhimChieu = new JMenuItem("Phim chiếu");
        
        // Gắn menu item vào menu chính
        menuNhanVien.add(itemDSNV);
        menuNhanVien.add(itemThemNV);

        menuPhim.add(itemDSPhim);
        menuPhim.add(itemThemPhim);
        
        menuLichChieu.add(itemDSlichChieu);
        menuLichChieu.add(itemThemLichChieu);
        
        menuThongKe.add(itemDoanhThu);
        menuThongKe.add(itemVeBan);
        menuThongKe.add(itemPhimChieu);
        
        
        // Thêm menu vào thanh menu bar
        menuBar.add(menuNhanVien);
        menuBar.add(menuPhim);
        menuBar.add(menuLichChieu);
        menuBar.add(menuThongKe);
        
        setJMenuBar(menuBar);
        
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Load ảnh gốc
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/homeQL.jpg"));

        // Resize ảnh theo kích thước frame
        Image scaledImage = icon.getImage().getScaledInstance(1000, 600 - menuBar.getHeight(), java.awt.Image.SCALE_SMOOTH);

        // Gắn ảnh vào JLabel
        JLabel lblImage = new JLabel(new ImageIcon(scaledImage));
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setVerticalAlignment(JLabel.CENTER);
        
        // Thêm vào cardPanel
        cardPanel.add(lblImage, "HOME");

        // Thêm các màn hình con vào cardPanel
        cardPanel.add(new ListNV(), "NHAN_VIEN");
        cardPanel.add(new ThemNV(), "THEM_NHAN_VIEN");
        cardPanel.add(new ListPhim(), "PHIM");
        cardPanel.add(new ThemPhim(), "THEM_PHIM");
        cardPanel.add(new ListLichChieu(), "LICH_CHIEU");
        cardPanel.add(new ThemLichChieu(), "THEM_LICH_CHIEU");
        cardPanel.add(new ThongKeDT(), "DOANH_THU");
        cardPanel.add(new ThongKeVeBan(), "VE_BAN");
        cardPanel.add(new ThongKePhimChieu(), "PHIM_CHIEU");

        // Thêm cardPanel vào JFrame
        add(cardPanel, BorderLayout.CENTER);
        
        //Thêm sự kiện cho các item
        itemDSNV.addActionListener(this);
        itemThemNV.addActionListener(this);
        itemDSPhim.addActionListener(this);
        itemThemPhim.addActionListener(this);
        itemDSlichChieu.addActionListener(this);
        itemThemLichChieu.addActionListener(this);
        itemDoanhThu.addActionListener(this);
        itemVeBan.addActionListener(this);
        itemPhimChieu.addActionListener(this);

        
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new HomeQL();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

	    if (source instanceof JMenuItem) {
	        JMenuItem item = (JMenuItem) source;
	        String text = item.getText();

	        switch (text) {
	            case "Danh sách nhân viên":
	                cardLayout.show(cardPanel, "NHAN_VIEN");
	                break;
	            case "Thêm nhân viên":
	                cardLayout.show(cardPanel, "THEM_NHAN_VIEN");
	                break;
	            case "Danh sách phim":
	                cardLayout.show(cardPanel, "PHIM");
	                break;
	            case "Thêm phim":
	                cardLayout.show(cardPanel, "THEM_PHIM");
	                break;
	            case "Danh sách lịch chiếu":
	                cardLayout.show(cardPanel, "LICH_CHIEU");
	                break;
	            case "Thêm lịch chiếu":
	                cardLayout.show(cardPanel, "THEM_LICH_CHIEU");
	                break;
	            case "Danh thu":
	                cardLayout.show(cardPanel, "DOANH_THU");
	                break;
	            case "Vé bán":
	                cardLayout.show(cardPanel, "VE_BAN");
	                break;
	            case "Phim chiếu":
	                cardLayout.show(cardPanel, "PHIM_CHIEU");
	                break;
	        }
	    }
		
	}
	
}
