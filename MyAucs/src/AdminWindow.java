import java.awt.EventQueue;

import javax.swing.JFrame;

public class AdminWindow {

	public JFrame frmAdminWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow window = new AdminWindow();
					window.frmAdminWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminWindow = new JFrame();
		frmAdminWindow.setTitle("Administrator Window");
		frmAdminWindow.setBounds(100, 100, 450, 300);
		frmAdminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
