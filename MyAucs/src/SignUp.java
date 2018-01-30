import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUp {

	JFrame frmSignUp;
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
		frmSignUp.setBounds(100, 100, 313, 226);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel ulbl = new JLabel("Username");
		ulbl.setBounds(10, 33, 67, 14);
		
		JLabel plbl = new JLabel("Password");
		plbl.setBounds(10, 83, 67, 14);
		
		txtusr = new JTextField();
		txtusr.setBounds(81, 30, 145, 20);
		txtusr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				String user = txtusr.getText();	
				String pass = String.valueOf(txtpwd.getPassword());
				dbConnection db = new dbConnection();
				int flag = db.SignUp(user, pass);
				if (flag==1) {
					JOptionPane.showMessageDialog(frmSignUp,"Account already exists!!");
				}else if (flag==0) {
					Main.usr=user;
					MainWindow mainwindow = new MainWindow();
					mainwindow.frmMainWindow.setVisible(true);
					frmSignUp.dispose();
				}
				}
			}
		});
		txtusr.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBounds(91, 111, 129, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String user = txtusr.getText();	
				String pass = String.valueOf(txtpwd.getPassword());
				dbConnection db = new dbConnection();
				int flag = db.SignUp(user, pass);
				if (flag==1) {
					JOptionPane.showMessageDialog(frmSignUp,"Account already exists!!");
				}else if (flag==0) {
					Main.usr=user;
					MainWindow mainwindow = new MainWindow();
					mainwindow.frmMainWindow.setVisible(true);
					frmSignUp.dispose();
				}
				
			}			
		});
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(91, 145, 129, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SignIn window = new SignIn();
				window.frmSignIn.setVisible(true);
				frmSignUp.dispose();
				
			}
		});
		
		txtpwd = new JPasswordField();
		txtpwd.setBounds(81, 80, 145, 20);
		txtpwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					String user = txtusr.getText();	
					String pass = String.valueOf(txtpwd.getPassword());
					dbConnection db = new dbConnection();
					int flag = db.SignUp(user, pass);
					if (flag==1) {
						JOptionPane.showMessageDialog(frmSignUp,"Account already exists!!");
					}else if (flag==0) {
						Main.usr=user;
						MainWindow mainwindow = new MainWindow();
						mainwindow.frmMainWindow.setVisible(true);
						frmSignUp.dispose();
					}
				}
				}
		});
		frmSignUp.getContentPane().setLayout(null);
		frmSignUp.getContentPane().add(plbl);
		frmSignUp.getContentPane().add(ulbl);
		frmSignUp.getContentPane().add(txtpwd);
		frmSignUp.getContentPane().add(txtusr);
		frmSignUp.getContentPane().add(btnNewButton);
		frmSignUp.getContentPane().add(btnNewButton_1);
	}
}
