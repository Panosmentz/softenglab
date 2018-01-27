import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class Copyrights {
	
	public JFrame frmCopyrights;

	/**
	 * Launch the application.
	 */
	
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {				
			
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();								
			Copyrights window = new Copyrights();
			window.frmCopyrights.setVisible(true);					
			
			String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
			connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM id");
			
			while (rs.next()){			
				//JLabel jlbl = new JLabel("New Label");
				String firstName = rs.getString("First Name");
				
				String lastName = rs.getString("Last Name");
				//jlbl.setText(""+firstName);
				//String text = new Settext(firstName);
				System.out.println("First Name: " + firstName
						+ ", Last Name: " + lastName);
				//jlbl.setText(rs.getString("First Name")); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try { if (rs != null) rs.close(); }catch (SQLException e) {
				e.printStackTrace(); }
			
			try { if (stmt != null) stmt.close(); } catch (SQLException e) {
				e.printStackTrace(); }
			
			try { if (conn != null) conn.close(); } catch (SQLException e) {
				e.printStackTrace(); }
		}
	}

	/**
	 * Create the application.
	 */
	public Copyrights() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCopyrights = new JFrame();
		frmCopyrights.setTitle("Copyrights");
		frmCopyrights.setBounds(100, 100, 450, 300);
		frmCopyrights.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmCopyrights.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(249, Short.MAX_VALUE)
					//.addComponent(jlbl)
					.addGap(139))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					//.addComponent(jlbl)
					.addContainerGap(229, Short.MAX_VALUE))
		);
		frmCopyrights.getContentPane().setLayout(groupLayout);
	}

}
