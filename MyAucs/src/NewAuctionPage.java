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

public class NewAuctionPage {

	JFrame frmNewAuction;
	private JTextField txtname;
	private JTextField txtbid;
	private JTextField txtbuyo;
	private boolean flag = false;

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
		frmNewAuction.setBounds(100, 100, 450, 300);
		frmNewAuction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSetType = new JLabel("Set Item Type:");
		
		JLabel lblSetItemName = new JLabel("Set Item Name:");
		
		txtname = new JTextField();
		txtname.setColumns(10);
		
		JLabel lblSetItemPrice = new JLabel("Set starting bid:");
		
		txtbid = new JTextField();
		txtbid.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dbConnection db = new dbConnection();				
				
				String name = txtname.getText();
				String bid = txtbid.getText();
				String buyo= txtbuyo.getText();
				String usr = Main.usr;
				String type = (String) comboBox.getSelectedItem();
				
				db.NewAuction(type, name, bid, buyo, usr);
				MyAuctionsPage map = new MyAuctionsPage();
				map.frmMAP.setVisible(true);
				frmNewAuction.dispose();				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyAuctionsPage map = new MyAuctionsPage();
				map.frmMAP.setVisible(true);
				frmNewAuction.dispose();
			}
		});
		
		JLabel lblSetBuyoutPrice = new JLabel("Set buyout price:");
		
		txtbuyo = new JTextField();
		txtbuyo.setColumns(10);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Weapons", "Armor", "Trinkets"}));
		GroupLayout groupLayout = new GroupLayout(frmNewAuction.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(321, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreate))
					.addGap(48))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSetBuyoutPrice, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtbuyo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblSetType, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblSetItemName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblSetItemPrice, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtbid, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
								.addComponent(txtname, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSetType)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSetItemName)
						.addComponent(txtname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSetItemPrice)
						.addComponent(txtbid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSetBuyoutPrice)
							.addGap(10)
							.addComponent(btnCreate)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBack))
						.addComponent(txtbuyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		frmNewAuction.getContentPane().setLayout(groupLayout);
	}
}
