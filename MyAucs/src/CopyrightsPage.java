import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CopyrightsPage {

	public JFrame frmCopyrightsPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyrightsPage window = new CopyrightsPage();
					window.frmCopyrightsPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("/CPbackround.jpg")));
	
	public CopyrightsPage() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCopyrightsPage = new JFrame();
		frmCopyrightsPage.setTitle("Copyrights Page");
		frmCopyrightsPage.setBounds(100, 100, 450, 300);
		frmCopyrightsPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCopyrightsPage.getContentPane().setLayout(null);
		
		JLabel lblKwstantinosValsamakis = new JLabel("Panagiotis Mentzelopoulos 40740");
		lblKwstantinosValsamakis.setHorizontalAlignment(SwingConstants.CENTER);
		lblKwstantinosValsamakis.setForeground(Color.CYAN);
		lblKwstantinosValsamakis.setFont(new Font("Verdana", Font.BOLD, 23));
		lblKwstantinosValsamakis.setBounds(0, 186, 434, 36);
		frmCopyrightsPage.getContentPane().add(lblKwstantinosValsamakis);
		
		JLabel lblSteliosNikolidakis_1 = new JLabel("Kwstantinos Valsamakis 43091");
		lblSteliosNikolidakis_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSteliosNikolidakis_1.setForeground(Color.CYAN);
		lblSteliosNikolidakis_1.setFont(new Font("Verdana", Font.BOLD, 23));
		lblSteliosNikolidakis_1.setBounds(0, 105, 434, 36);
		frmCopyrightsPage.getContentPane().add(lblSteliosNikolidakis_1);
		
		JLabel lblSteliosNikolidakis = new JLabel("Stelios Nikolidakis 42071");
		lblSteliosNikolidakis.setHorizontalAlignment(SwingConstants.CENTER);
		lblSteliosNikolidakis.setFont(new Font("Verdana", Font.BOLD, 23));
		lblSteliosNikolidakis.setForeground(new Color(0, 255, 255));
		lblSteliosNikolidakis.setBounds(0, 30, 434, 36);
		frmCopyrightsPage.getContentPane().add(lblSteliosNikolidakis);
		
		lblNewLabel.setBounds(0, 0, 434, 260);
		frmCopyrightsPage.getContentPane().add(lblNewLabel);
		//ImageIcon() = new ImageIcon
		//lblNewLabel.setIcon(bud));
		
	}
}
