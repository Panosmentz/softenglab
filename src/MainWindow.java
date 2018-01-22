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

public class MainWindow {

	public JFrame frmMainWindow;
	
	

	/**
	 * Launch the application.
	 */
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
		 usrname.setText("hello "+Main.usr);
		
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
		btnMyAuctions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	
				MyAuctionsPage map = new MyAuctionsPage();
				map.frmMAP.setVisible(true);
				frmMainWindow.dispose();
				
			}
		});
		btnMyAuctions.setFont(new Font("Verdana", Font.BOLD, 30));
		
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
							.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCp, Alignment.TRAILING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(usrname)
									.addGap(136))))
						.addComponent(btnMyAuctions, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowseAuctions, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSignIn)
								.addComponent(usrname))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSignUp))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(btnCp)))
					.addGap(23)
					.addComponent(btnBrowseAuctions, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMyAuctions, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		frmMainWindow.getContentPane().setLayout(groupLayout);
	}
}
