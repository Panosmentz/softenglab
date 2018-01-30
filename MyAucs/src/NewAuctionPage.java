import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewAuctionPage {

	JFrame frmNewAuction;
	private JTextField txtname;
	private JTextField txtbid;
	private JTextField txtbuyo;
	private boolean flag = false;
	private JTextField txtebid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAuctionPage nap = new NewAuctionPage();
					nap.frmNewAuction.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewAuctionPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewAuction = new JFrame();
		frmNewAuction.setTitle("New Auction");
		frmNewAuction.setBounds(100, 100, 343, 300);
		frmNewAuction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSetType = new JLabel("Set Item Type:");
		lblSetType.setBounds(40, 47, 109, 14);
		
		JLabel lblSetItemName = new JLabel("Set Item Name:");
		lblSetItemName.setBounds(40, 72, 109, 14);
		
		txtname = new JTextField();
		txtname.setBounds(159, 69, 158, 20);
		txtname.setColumns(10);
		
		JLabel lblSetItemPrice = new JLabel("Set starting bid:");
		lblSetItemPrice.setBounds(40, 97, 115, 14);
		
		txtbid = new JTextField();
		txtbid.setBounds(159, 94, 158, 20);
		txtbid.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 44, 158, 20);
		
		
		JButton btnCreate = new JButton("Create");
		
		btnCreate.setBounds(141, 226, 83, 23);
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dbConnection db = new dbConnection();				
				
				String name = txtname.getText();
				String bid = txtbid.getText();
				String buyo= txtbuyo.getText();
				String ebid= txtebid.getText();
				String usr = Main.usr;
				String type = (String) comboBox.getSelectedItem();
				
				db.NewAuction(type, name, bid, buyo, usr,ebid);
				MyAuctionsPage map = new MyAuctionsPage();
				map.frmMAP.setVisible(true);
				comboBox.removeAllItems();
				frmNewAuction.dispose();				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(234, 226, 83, 23);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyAuctionsPage map = new MyAuctionsPage();
				map.frmMAP.setVisible(true);
				comboBox.removeAllItems();
				frmNewAuction.dispose();
			}
		});
		
		JLabel lblSetBuyoutPrice = new JLabel("Set buyout price:");
		lblSetBuyoutPrice.setBounds(40, 147, 115, 14);
		
		txtbuyo = new JTextField();
		txtbuyo.setBounds(159, 144, 158, 20);
		txtbuyo.setColumns(10);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Weapons", "Armor", "Trinkets"}));
		frmNewAuction.getContentPane().setLayout(null);
		frmNewAuction.getContentPane().add(btnBack);
		frmNewAuction.getContentPane().add(btnCreate);
		frmNewAuction.getContentPane().add(lblSetBuyoutPrice);
		frmNewAuction.getContentPane().add(txtbuyo);
		frmNewAuction.getContentPane().add(lblSetType);
		frmNewAuction.getContentPane().add(lblSetItemName);
		frmNewAuction.getContentPane().add(lblSetItemPrice);
		frmNewAuction.getContentPane().add(comboBox);
		frmNewAuction.getContentPane().add(txtbid);
		frmNewAuction.getContentPane().add(txtname);
		
		JLabel lblSetEndBid = new JLabel("Set end bid:");
		lblSetEndBid.setBounds(40, 122, 115, 14);
		frmNewAuction.getContentPane().add(lblSetEndBid);
		
		txtebid = new JTextField();
		txtebid.setColumns(10);
		txtebid.setBounds(159, 119, 158, 20);
		frmNewAuction.getContentPane().add(txtebid);
	}
}
