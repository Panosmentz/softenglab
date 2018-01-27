import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;


public class AdminSignIn {
	public static String usr = null;
	JFrame frmAdminSignIn;
	private JTextField txtUname;
	public JPasswordField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSignIn window = new AdminSignIn();
					window.frmAdminSignIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminSignIn = new JFrame();
		frmAdminSignIn.setTitle("Sign In as Administrator");
		frmAdminSignIn.setBounds(100, 100, 541, 319);
		frmAdminSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username :");
		
		JLabel lblPassword = new JLabel("Password :");
		
		txtUname = new JTextField();
		txtUname.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AdminSignUp signup = new AdminSignUp();
				signup.frmAdminSignUp.setVisible(true);
				frmAdminSignIn.dispose();
				
				
			}
		});
		
		JButton btnSignIn = new JButton("Sign In");
		
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String EnteredUser = txtUname.getText();
				String EnteredPwd = String.valueOf(txtpwd.getPassword());
				
				dbConnection db = new dbConnection();
				boolean flag = db.AdminSignIn(EnteredUser, EnteredPwd);
				
				if(flag == true){
					Main.adminUsr = EnteredUser;
					Main.adminPsd = EnteredPwd;
					Main.adminLoged = true;
					
					AdminWindow window = new AdminWindow();
					window.frmAdminWindow.setVisible(true);									
					frmAdminSignIn.dispose();
					
					
				}//end if
				
			}
		});
		
		txtpwd = new JPasswordField();
		txtpwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent s) {
				
				if(s.getKeyCode() == KeyEvent.VK_ENTER) {
				      
					String EnteredUser = txtUname.getText();
					String EnteredPwd = String.valueOf(txtpwd.getPassword());
					
					dbConnection db = new dbConnection();
					boolean flag = db.AdminSignIn(EnteredUser, EnteredPwd);
					
					if(flag == true){
						Main.adminUsr = EnteredUser;
						Main.adminPsd = EnteredPwd;
						Main.adminLoged = true;
						
						AdminWindow window = new AdminWindow();
						window.frmAdminWindow.setVisible(true);									
						frmAdminSignIn.dispose();
																		
					}//end if
					
				   }
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frmAdminSignIn.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSignIn)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSignUp))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpwd, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(txtUname))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txtUname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtpwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignUp)
						.addComponent(btnSignIn))
					.addGap(45))
		);
		frmAdminSignIn.getContentPane().setLayout(groupLayout);
	}
}
