import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminSignUp {

	public JFrame frmAdminSignUp;
	private JTextField txtusr;
	private JButton btnNewButton_1;
	private JPasswordField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSignUp window = new AdminSignUp();
					window.frmAdminSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminSignUp = new JFrame();
		frmAdminSignUp.setTitle("Administrator Sign Up");
		frmAdminSignUp.setBounds(100, 100, 450, 273);
		frmAdminSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel ulbl = new JLabel("Username");
		
		JLabel plbl = new JLabel("Password");
		
		txtusr = new JTextField();
		txtusr.setColumns(10);
		
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
					String pwd = String.valueOf(txtpwd.getPassword());				
					String insert = "INSERT INTO adminaccounts (adName,adPass) VALUE ('"+usr+"','"+pwd+"');";
					stmt.executeUpdate(insert);
					frmAdminSignUp.dispose();
					AdminWindow window = new AdminWindow();
					window.frmAdminWindow.setVisible(true);
					
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
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAdminSignUp.dispose();
				AdminSignIn window = new AdminSignIn();
				window.frmAdminSignIn.setVisible(true);
				
			}
		});
		
		txtpwd = new JPasswordField();
		txtpwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
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
						String pwd = String.valueOf(txtpwd.getPassword());				
						String insert = "INSERT INTO adminaccounts (adName,adPass) VALUE ('"+usr+"','"+pwd+"');";
						stmt.executeUpdate(insert);
						frmAdminSignUp.dispose();
						AdminWindow window = new AdminWindow();
						window.frmAdminWindow.setVisible(true);
						
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
				}
		});
		
		GroupLayout groupLayout = new GroupLayout(frmAdminSignUp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(plbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ulbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpwd, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
						.addComponent(txtusr, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.TRAILING))
					.addGap(139))
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
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmAdminSignUp.getContentPane().setLayout(groupLayout);
	}

}
