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


public class SignIn {
	public static String usr = null;
	JFrame frmSignIn;
	private JTextField txtUname;
	public JPasswordField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.frmSignIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignIn = new JFrame();
		frmSignIn.setTitle("Sign In");
		frmSignIn.setBounds(100, 100, 288, 213);
		frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username :");
		
		JLabel lblPassword = new JLabel("Password :");
		
		txtUname = new JTextField();
		txtUname.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SignUp signup = new SignUp();
				signup.frmSignUp.setVisible(true);
				frmSignIn.dispose();
				
				
			}
		});
		
		JButton btnSignIn = new JButton("Sign In");
		
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String EnteredUser = txtUname.getText();
				String EnteredPwd = String.valueOf(txtpwd.getPassword());
				
				dbConnection db = new dbConnection();
				boolean flag = db.SignIn(EnteredUser, EnteredPwd);
				
				if(flag == true){
					Main.usr = EnteredUser;
					Main.psd = EnteredPwd;
					Main.loged = true;
					MainWindow window = new MainWindow();
					window.frmMainWindow.setVisible(true);
					
					
					
					frmSignIn.dispose();
					//System.out.println("hello"+Main.usr+"!!!");
					
				}//end if
				
			}
		});
		
		txtpwd = new JPasswordField();
		txtpwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				      
					String EnteredUser = txtUname.getText();
					String EnteredPwd = String.valueOf(txtpwd.getPassword());
					
					dbConnection db = new dbConnection();
					boolean flag = db.SignIn(EnteredUser, EnteredPwd);
					
					if(flag == true){
						Main.usr = EnteredUser;
						Main.psd = EnteredPwd;
						Main.loged = true;
						MainWindow window = new MainWindow();
						window.frmMainWindow.setVisible(true);
						
						
						
						frmSignIn.dispose();
						//System.out.println("hello"+Main.usr+"!!!");
						
					}//end if
					
				   }
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frmSignIn.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsername)
							.addGap(18)
							.addComponent(txtUname))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtpwd, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSignIn)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnSignUp)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(59, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignUp)
						.addComponent(btnSignIn))
					.addGap(45))
		);
		frmSignIn.getContentPane().setLayout(groupLayout);
	}
}
