package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import DAO.SachDAO;
import MODEL.TaiKhoanModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtuser;
	private JPasswordField pass;
	private JTextField txtname;
	private JTextField txtemail;
	private JPasswordField txtpass;
	private JPasswordField rspass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Đăng Nhập", null, panel, null);
		
		JLabel lblNewLabel = new JLabel("Người dùng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtuser = new JTextField();
		txtuser.setColumns(10);
		
		pass = new JPasswordField();
		
		JButton btnNewButton = new JButton("Đăng Nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtuser.getText().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton,"vui long dien tai khoan");
				}
				if(pass.getText().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton,"vui long dien mat khau");
				}
				try {
					String url = "jdbc:mysql://localhost:3306/thuviensach";
					String user ="root";
					String password ="quanghieuvp123";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,user,password);
					String sql = "select * from nhanvien "+"Where Name = ? And Password = ?";
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1,txtuser.getText());
					statement.setString(2, pass.getText());
					ResultSet rs = statement.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnNewButton, "chúc bạn đăng nhập thành công");
						Detail sv = new Detail();
						sv.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton, "Đăng nhập thất bại");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtuser)
								.addComponent(pass, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(259)
							.addComponent(btnNewButton)))
					.addContainerGap(224, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(101)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtuser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pass, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(37)
					.addComponent(btnNewButton)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Đăng Ký", null, panel_1, null);
		
		JLabel lblNewLabel_2 = new JLabel("Người dùng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Lặp lại");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtname = new JTextField();
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		
		txtpass = new JPasswordField();
		
		rspass = new JPasswordField();
		
		JButton btnNewButton_1 = new JButton("Đăng Ký");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtpass.getText().equals(rspass.getText())) {
					TaiKhoanModel taikhoan = new TaiKhoanModel();
					taikhoan.setName(txtname.getText());
					taikhoan.setPassword(txtpass.getText());
					boolean checkExitUser = SachDAO.insertTaikhoan(taikhoan);
					if(checkExitUser== true) {
						JOptionPane.showMessageDialog(new JFrame(), "Dang ky khong thanh cong");
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Dang ky  thanh cong");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Mat khau lap lai khong dung");
				}
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(rspass, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(txtpass)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtemail, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
								.addComponent(txtname, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))))
					.addContainerGap(204, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(267)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(269, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtname, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpass, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(rspass, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(btnNewButton_1)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Giới Thiệu", null, panel_2, null);
		frame.getContentPane().setLayout(groupLayout);
	}
}
