package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	private JLabel lbtitle;
	private JLabel lbEmail;
	private JTextField txtEmail;
	private JLabel lbPassword;
	private JTextField txtPassword;
	private JButton btnNV;
	private JButton btnQL;

	public Login() {
		setTitle("Đăng nhập");
		
		JPanel pnlNor = new JPanel();
		pnlNor.add(lbtitle = new JLabel("Đăng nhập hệ thống"));
		Font font = new Font ("Times New Roman",Font.BOLD,25);
		lbtitle.setFont(font);
		add(pnlNor, BorderLayout.NORTH);
		lbtitle.setForeground(Color.BLUE);
		
		JPanel pnlCent = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Font font2 = new Font ("Times New Roman",Font.BOLD,15);
		Box boxCent = new Box(BoxLayout.Y_AXIS);
		Box box1 = new Box(BoxLayout.X_AXIS);
		boxCent.add(Box.createVerticalStrut(10));
		box1.add(lbEmail = new JLabel("Email:"));
		lbEmail.setFont(font2);
		box1.add(Box.createHorizontalStrut(35));
		box1.add(txtEmail = new JTextField(25));
		txtEmail.setPreferredSize(new Dimension(25, 30));
		txtEmail.requestFocus();
		boxCent.add(Box.createVerticalStrut(30));
		boxCent.add(box1);
		
		Box box2 = new Box(BoxLayout.X_AXIS);
		box2.add(lbPassword = new JLabel("Mật khẩu:"));
		lbPassword.setFont(font2);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(txtPassword = new JTextField(25));
		txtPassword.setPreferredSize(new Dimension(25, 30));
		boxCent.add(Box.createVerticalStrut(30));
		boxCent.add(box2);
		
		Box box3 = new Box(BoxLayout.X_AXIS);
		box3.add(Box.createHorizontalStrut(75));
		box3.add(btnNV = new JButton("Đăng nhập với nhân viên"));
		btnNV.setPreferredSize(new Dimension(300, 30));
		btnNV.setMaximumSize(new Dimension(300, 30));
		btnNV.setMinimumSize(new Dimension(300, 30));
		boxCent.add(Box.createVerticalStrut(30));
		boxCent.add(box3);
		
		Box box4 = new Box(BoxLayout.X_AXIS);
		box4.add(Box.createHorizontalStrut(75));
		box4.add(btnQL = new JButton("Đăng nhập với quản lý"));
		btnQL.setPreferredSize(new Dimension(300, 30));
		btnQL.setMaximumSize(new Dimension(300, 30));
		btnQL.setMinimumSize(new Dimension(300, 30));
		boxCent.add(Box.createVerticalStrut(30));
		boxCent.add(box4);
		
		pnlCent.add(boxCent);
		add(pnlCent, BorderLayout.CENTER);
		
		btnQL.addActionListener(this);
		btnNV.addActionListener(this);
		
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		 String email = txtEmail.getText().trim();
	     String password = txtPassword.getText().trim();

	     if (email.isEmpty()) {
	         JOptionPane.showMessageDialog(this, "Vui lòng nhập Email.", "Thông báo", JOptionPane.WARNING_MESSAGE);
	         txtEmail.requestFocus();
	         return;
	     }
	     
	     if(password.isEmpty()) {
	    	 JOptionPane.showMessageDialog(this, "Vui lòng nhập Mật khẩu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
	    	 txtPassword.requestFocus();
	         return;
	     }

	     if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
	         JOptionPane.showMessageDialog(this, "Email không hợp lệ. Vui lòng nhập đúng định dạng email!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	         return;
	     }
	     
	     // Ví dụ: kiểm tra tài khoản quản lý
	     if (email.equals("admin@gmail.com") && password.equals("admin123")) {
	    	 if(o.equals(btnNV)) {
	    		 new HomeNV();
	    	 }
	    	 else
	    	 {
	    		 new HomeQL();
	    	 }
	         dispose();
	     } else {
	         JOptionPane.showMessageDialog(this, "Email hoặc mật khẩu không đúng!", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
	     }
	}
}
