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
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class MainWindow {

	public JFrame frmMainWindow;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					MainWindow window = new MainWindow();
					window.frmMainWindow.setVisible(true);
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
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
		frmMainWindow.setBounds(100, 100, 450, 256);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 JLabel usrname = new JLabel("New label");
		 usrname.setBounds(303, 11, 121, 14);
		 usrname.setText("Signed in as: "+Main.usr);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(10, 11, 99, 23);
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn signin = new SignIn();
				signin.frmSignIn.setVisible(true);
				frmMainWindow.dispose();
			}
		});
		
		JButton btnBrowseAuctions = new JButton("Browse Auctions");
		btnBrowseAuctions.setBounds(10, 91, 414, 46);
		btnBrowseAuctions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				BrowsePage browse = new BrowsePage();
				browse.frmBrowseWindow.setVisible(true);
				frmMainWindow.dispose();
			}
		});
		btnBrowseAuctions.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JButton btnMyAuctions = new JButton("My Auctions");
		btnMyAuctions.setBounds(10, 143, 414, 46);
		btnMyAuctions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	
				MyAuctionsPage map = new MyAuctionsPage();
				map.frmMAP.setVisible(true);
				frmMainWindow.dispose();
				
			}
		});
		btnMyAuctions.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JButton btnCp = new JButton("Copyrights");
		btnCp.setBounds(10, 45, 99, 23);
		btnCp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CopyrightsPage copyrights = new CopyrightsPage();
				copyrights.frmCopyrightsPage.setVisible(true);
								
			}
			
		});
		frmMainWindow.getContentPane().setLayout(null);
		frmMainWindow.getContentPane().add(btnMyAuctions);
		frmMainWindow.getContentPane().add(btnBrowseAuctions);
		frmMainWindow.getContentPane().add(btnCp);
		frmMainWindow.getContentPane().add(btnSignIn);
		frmMainWindow.getContentPane().add(usrname);
	}
}
