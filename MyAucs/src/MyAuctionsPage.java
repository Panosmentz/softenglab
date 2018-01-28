import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;



import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;

public class MyAuctionsPage {

	JFrame frmMAP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAuctionsPage map = new MyAuctionsPage();
					map.frmMAP.setVisible(true);
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
	
	public static JComboBox<String> comboBox = new JComboBox<String>();
	public static void add (String name[]) {
		
		comboBox.addItem(Arrays.toString(name));
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmMAP = new JFrame();
		frmMAP.setTitle("My Auctions Page");
		frmMAP.setBounds(100, 100, 350, 332);
		frmMAP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dbConnection db = new dbConnection();
		db.MyAuctions(Main.usr);
		System.out.println(Main.iname);
		JLabel lblExistingAuctions = new JLabel("Existing Auctions");
		
		
		
		
		
		JButton btnCreateAuction = new JButton("Create Auction");
		btnCreateAuction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				NewAuctionPage window = new NewAuctionPage();
				window.frmNewAuction.setVisible(true);
				comboBox.removeAllItems();
				frmMAP.dispose();
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow mainwindow = new MainWindow();
				mainwindow.frmMainWindow.setVisible(true);
				comboBox.removeAllItems();
				frmMAP.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmMAP.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(lblExistingAuctions))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(201)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCreateAuction, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(294, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblExistingAuctions)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
					.addComponent(btnCreateAuction)
					.addGap(15)
					.addComponent(btnBack)
					.addContainerGap())
		);
		frmMAP.getContentPane().setLayout(groupLayout);
	}
}
