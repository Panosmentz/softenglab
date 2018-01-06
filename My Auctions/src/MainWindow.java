import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainWindow {

	public JFrame frmMainWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					
					MainWindow window = new MainWindow();
					window.frmMainWindow.setVisible(true);
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl = "jdbc:mysql://localhost:3306/MyDB";
					String connectionUser = "root";
					String connectionPassword = "";
					conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM id");
					
					while (rs.next())
					{
					
					String firstName = rs.getString("First Name");
					String lastName = rs.getString("Last Name");
					System.out.println("First Name: " + firstName
					+ ", Last Name: " + lastName);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					
					
					try { if (rs != null) rs.close(); } catch (SQLException e) {
					e.printStackTrace(); }
					
		
					try { if (stmt != null) stmt.close(); } catch (SQLException e) {
					e.printStackTrace(); }
					
					
					try { if (conn != null) conn.close(); } catch (SQLException e) {
					e.printStackTrace(); }
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainWindow = new JFrame();
		frmMainWindow.setTitle("Main Window");
		frmMainWindow.setBounds(100, 100, 450, 300);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn signin = new SignIn();
				signin.frmSignIn.setVisible(true);
				frmMainWindow.dispose();
			}
		});
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SignUp signup = new SignUp();
				signup.frmSignUp.setVisible(true);
				frmMainWindow.dispose();
				
			}
		});
		
		JButton btnBrowseAuctions = new JButton("Browse Auctions");
		btnBrowseAuctions.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JButton btnMyAuctions = new JButton("My Auctions");
		btnMyAuctions.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JButton btnNewAuction = new JButton("New Auction");
		btnNewAuction.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JButton btnCp = new JButton("CP");
		btnCp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Copyrights copyrights = new Copyrights();
				copyrights.frmCopyrights.setVisible(true);
				frmMainWindow.dispose();				
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(frmMainWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnSignIn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSignUp, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
							.addComponent(btnCp))
						.addComponent(btnMyAuctions, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewAuction, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowseAuctions, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSignIn)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSignUp))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(btnCp)))
					.addGap(23)
					.addComponent(btnBrowseAuctions, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMyAuctions, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewAuction, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		frmMainWindow.getContentPane().setLayout(groupLayout);
	}

}
