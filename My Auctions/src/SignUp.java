import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {

	JFrame frmSignUp;
	private JTextField txtusr;
	private JTextField txtpwd;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					SignUp window = new SignUp();
					window.frmSignUp.setVisible(true);	
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.setTitle("Sign Up");
		frmSignUp.setBounds(100, 100, 301, 185);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel ulbl = new JLabel("Username");
		
		JLabel plbl = new JLabel("Password");
		
		txtusr = new JTextField();
		txtusr.setColumns(10);
		
		txtpwd = new JTextField();
		txtpwd.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					
					
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl = "jdbc:mysql://localhost:3306/MyDB";
					String connectionUser = "root";
					String connectionPassword = "";
					conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
					stmt = conn.createStatement();
					String usr = txtusr.getText();	
					String pwd = txtpwd.getText();				
					String insert = "INSERT INTO Accounts (username,pass) VALUE ('"+usr+"','"+pwd+"');";
					stmt.executeUpdate(insert);
					frmSignUp.dispose();
					MainWindow window = new MainWindow();
					window.frmMainWindow.setVisible(true);
					
				} catch (Exception s) {
					s.printStackTrace();
				}finally{
					
					
					try { if (rs != null) rs.close(); } catch (SQLException s) {
					s.printStackTrace(); }
					
		
					try { if (stmt != null) stmt.close(); } catch (SQLException s) {
					s.printStackTrace(); }
					
					
					try { if (conn != null) conn.close(); } catch (SQLException s) {
					s.printStackTrace(); }
					
				}
			}
			
			
		});
		GroupLayout groupLayout = new GroupLayout(frmSignUp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(plbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ulbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(btnNewButton)
							.addGap(28))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtpwd, Alignment.LEADING)
								.addComponent(txtusr, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ulbl)
						.addComponent(txtusr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(plbl)
						.addComponent(txtpwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		frmSignUp.getContentPane().setLayout(groupLayout);
	}
}
