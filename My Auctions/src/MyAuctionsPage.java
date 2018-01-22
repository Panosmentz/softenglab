import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MyAuctionsPage {

	private JFrame frmMyAuctions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAuctionsPage window = new MyAuctionsPage();
					window.frmMyAuctions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyAuctionsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyAuctions = new JFrame();
		frmMyAuctions.setTitle("My Auctions");
		frmMyAuctions.setBounds(100, 100, 450, 300);
		frmMyAuctions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(frmMyAuctions.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 262, Short.MAX_VALUE)
		);
		frmMyAuctions.getContentPane().setLayout(groupLayout);
	}

}
