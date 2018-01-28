import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartupPage {

	private JFrame frmStartup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartupPage sup = new StartupPage();
					sup.frmStartup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartupPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartup = new JFrame();
		frmStartup.setTitle("Startup Page");
		frmStartup.setBounds(100, 100, 707, 372);
		frmStartup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblNewLabel = new JLabel("<html>Hello and Welcome to My Auctions app!<br><br>Select your account type to sign in and click OK to start using our app!</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 30));
		
		JRadioButton rdbtnAdmin = new JRadioButton("Administrator");
		rdbtnAdmin.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		JRadioButton rdbtnUser = new JRadioButton("User");
		rdbtnUser.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		JButton btnOk = new JButton("OK!");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (rdbtnAdmin.isSelected()) {
					AdminSignIn window = new AdminSignIn();
					window.frmAdminSignIn.setVisible(true);
					frmStartup.dispose();
				}
				if (rdbtnUser.isSelected()) {
					SignIn window = new SignIn();
					window.frmSignIn.setVisible(true);
					frmStartup.dispose();
				}
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmStartup.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(rdbtnAdmin)
							.addPreferredGap(ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnOk)
									.addGap(56))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(rdbtnUser, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
									.addGap(111)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnAdmin)
						.addComponent(rdbtnUser, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		frmStartup.getContentPane().setLayout(groupLayout);
	}
}
