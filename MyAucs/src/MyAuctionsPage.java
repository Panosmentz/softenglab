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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

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
		frmMAP.setBounds(100, 100, 422, 332);
		frmMAP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dbConnection db = new dbConnection();
		db.MyAuctions(Main.usr);
		//System.out.println(Main.iname);
		JLabel lblExistingAuctions = new JLabel("Existing Auctions");
		lblExistingAuctions.setBounds(109, 24, 118, 14);
		
		
		
		
		
		JButton btnCreateAuction = new JButton("Create Auction");
		btnCreateAuction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateAuction.setBounds(202, 166, 122, 23);
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
		btnBack.setBounds(202, 234, 122, 23);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow mainwindow = new MainWindow();
				mainwindow.frmMainWindow.setVisible(true);
				comboBox.removeAllItems();
				frmMAP.dispose();
			}
		});
		
		JLabel label = new JLabel("SELECTED ITEM");
		JTextPane txtName = new JTextPane();
		JTextPane txtBid = new JTextPane();
		JTextPane txtBuyo = new JTextPane();
		JTextPane txtEBid = new JTextPane();
		label.setBounds(62, 75, 194, 26);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		comboBox.setBounds(84, 44, 143, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedItem() != null ) {
					
					String selectedwep = (String) comboBox.getSelectedItem();
					
					String name = selectedwep.split(",")[0];
					txtName.setText(name.substring(1));
					String bid = selectedwep.split(",")[1];
					txtBid.setText(bid.substring(1));
					String buyo = selectedwep.split(",")[2];				
					txtBuyo.setText(buyo.substring(1));
					String ebid = selectedwep.split(",")[3];				
					txtEBid.setText(ebid.substring(1,ebid.length() - 1));
				
				}
				
			}
		});
		frmMAP.getContentPane().setLayout(null);
		frmMAP.getContentPane().add(label);
		frmMAP.getContentPane().add(lblExistingAuctions);
		frmMAP.getContentPane().add(comboBox);
		frmMAP.getContentPane().add(btnBack);
		frmMAP.getContentPane().add(btnCreateAuction);
		
		JLabel label_1 = new JLabel("Item Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(51, 112, 75, 14);
		frmMAP.getContentPane().add(label_1);
		
		
		txtName.setEditable(false);
		txtName.setBounds(19, 135, 143, 20);
		frmMAP.getContentPane().add(txtName);
		
		JLabel label_2 = new JLabel("Current Bid");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(51, 166, 75, 14);
		frmMAP.getContentPane().add(label_2);
		
		
		txtBid.setEditable(false);
		txtBid.setBounds(19, 189, 143, 20);
		frmMAP.getContentPane().add(txtBid);
		
		JLabel label_3 = new JLabel("Buyout Price");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(51, 220, 75, 14);
		frmMAP.getContentPane().add(label_3);
		
		
		txtBuyo.setEditable(false);
		txtBuyo.setBounds(19, 245, 143, 20);
		frmMAP.getContentPane().add(txtBuyo);
		
		JLabel lblEndBid = new JLabel("End Bid");
		lblEndBid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndBid.setBounds(220, 112, 75, 14);
		frmMAP.getContentPane().add(lblEndBid);
		
		
		txtEBid.setEditable(false);
		txtEBid.setBounds(181, 135, 143, 20);
		frmMAP.getContentPane().add(txtEBid);
		
		JButton btnCancelAuction = new JButton("Cancel Auction");
		btnCancelAuction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (comboBox.getSelectedItem() != null ) {
					
					dbConnection db = new dbConnection();
					db.DeleteAuction(txtName.getText());
					frmMAP.dispose();
					MyAuctionsPage map = new MyAuctionsPage();					
					map.frmMAP.setVisible(true);					
				}
				
			}
		});
		btnCancelAuction.setBounds(202, 200, 122, 23);
		frmMAP.getContentPane().add(btnCancelAuction);
	}
}
