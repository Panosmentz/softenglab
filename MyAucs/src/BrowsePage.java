import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrowsePage {

	JFrame frmBrowseWindow;
	private JTextField bidp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowsePage window = new BrowsePage();
					window.frmBrowseWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrowsePage() {
		
		initialize();
	}
	
	public static JComboBox<String> cmbwep = new JComboBox<String>();
	public static JComboBox<String> cmbarm = new JComboBox<String>();
	public static JComboBox<String> cmbtrin = new JComboBox<String>();
	
	
	public static void addarm (String name[]) {		
	cmbarm.addItem(Arrays.toString(name));
	}
	
	public static void addtrin (String name[]) {		
		cmbtrin.addItem(Arrays.toString(name));
		}
	public static void addwep (String name[]) {		
		cmbwep.addItem(Arrays.toString(name));
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	JTextPane txtbuyo = new JTextPane();
	JTextPane txtbid = new JTextPane();
	JTextPane txtname = new JTextPane();
	JTextPane txtWal = new JTextPane();	
	
	private void initialize() {
		frmBrowseWindow = new JFrame();
		frmBrowseWindow.setTitle("Browse Page");
		frmBrowseWindow.setBounds(100, 100, 629, 467);
		frmBrowseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dbConnection db = new dbConnection();
		db.Browse(Main.usr);
		txtWal.setText(Float.toString(Main.wal));
		
		JButton btnbuy = new JButton("Buyout");
		btnbuy.setBounds(410, 323, 81, 29);
		btnbuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Float.parseFloat(txtbuyo.getText()) <= Main.wal) {	
				dbConnection db = new dbConnection();
				db.Buyout(Main.selectedtype,txtbuyo.getText(),txtname.getText());
				}else {
					JOptionPane.showMessageDialog(frmBrowseWindow,"Not enough Bitcoin!!!");
				}
			}
		});
		
		
		
		bidp = new JTextField();
		bidp.setBounds(506, 278, 62, 26);
		bidp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Weapons");
		lblNewLabel.setBounds(49, 29, 112, 20);
		
		JLabel lblArmor = new JLabel("Armor");
		lblArmor.setBounds(49, 85, 206, 20);
		
		JLabel lblTrinkets = new JLabel("Trinkets");
		lblTrinkets.setBounds(49, 145, 124, 20);
		
		JLabel label = new JLabel("BTC");
		label.setBounds(574, 281, 29, 20);
		
		
		frmBrowseWindow.getContentPane().setLayout(null);
		frmBrowseWindow.getContentPane().add(lblArmor);
		frmBrowseWindow.getContentPane().add(lblTrinkets);
		frmBrowseWindow.getContentPane().add(lblNewLabel);
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(410, 370, 81, 29);
		btnBack.addMouseListener(new MouseAdapter() {			
			@Override			
			public void mouseClicked(MouseEvent e) {
				
				MainWindow window = new MainWindow();
				window.frmMainWindow.setVisible(true);	
				cmbwep.removeAllItems();
				cmbarm.removeAllItems();				
				cmbtrin.removeAllItems();
				frmBrowseWindow.dispose();							
			}
		});
		
		cmbwep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbwep.getSelectedItem() != null ) {
				String selectedwep = (String) cmbwep.getSelectedItem();
				Main.selectedtype="Weapons";
				String name = selectedwep.split(",")[0];
				txtname.setText(name.substring(1));
				String bid = selectedwep.split(",")[1];
				txtbid.setText(bid.substring(1));
				String buyo = selectedwep.split(",")[2];				
				txtbuyo.setText(buyo.substring(1,buyo.length() - 1));
				}
			}
		});
		cmbwep.setBounds(148, 26, 425, 26);
		frmBrowseWindow.getContentPane().add(cmbwep);
		cmbtrin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbtrin.getSelectedItem() != null ) {
				String selectedtrink = (String) cmbtrin.getSelectedItem();
				Main.selectedtype="Trinkets";
				String name = selectedtrink.split(",")[0];
				txtname.setText(name.substring(1));
				String bid = selectedtrink.split(",")[1];
				txtbid.setText(bid.substring(1));
				String buyo = selectedtrink.split(",")[2];				
				txtbuyo.setText(buyo.substring(1,buyo.length() - 1));
				}
			}
		});
		cmbtrin.setBounds(148, 139, 425, 26);
		frmBrowseWindow.getContentPane().add(cmbtrin);
		cmbarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbarm.getSelectedItem() != null ) {
				String selectedarm = (String) cmbarm.getSelectedItem();
				Main.selectedtype="Armor";
				String name = selectedarm.split(",")[0];
				txtname.setText(name.substring(1));
				String bid = selectedarm.split(",")[1];
				txtbid.setText(bid.substring(1));
				String buyo = selectedarm.split(",")[2];				
				txtbuyo.setText(buyo.substring(1,buyo.length() - 1));
				}
			}
		});
		
		JButton btnbid = new JButton("Bid");
		btnbid.setBounds(410, 278, 81, 29);
		btnbid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(cmbwep.getSelectedItem() != null || cmbarm.getSelectedItem() != null || cmbtrin.getSelectedItem() != null ) {
					if (Float.parseFloat(bidp.getText()) <= Main.wal) {					
						dbConnection db = new dbConnection();
						db.Bid(Main.selectedtype,bidp.getText(),txtname.getText());
					}else {
						JOptionPane.showMessageDialog(frmBrowseWindow,"Not enough Bitcoin!!!");
					}
				
				}
			}
		});
		
		cmbarm.setBounds(148, 82, 425, 26);
		frmBrowseWindow.getContentPane().add(cmbarm);
		frmBrowseWindow.getContentPane().add(btnBack);
		frmBrowseWindow.getContentPane().add(btnbid);
		frmBrowseWindow.getContentPane().add(btnbuy);
		frmBrowseWindow.getContentPane().add(bidp);
		frmBrowseWindow.getContentPane().add(label);
		
		JLabel lblSelectedItem = new JLabel("SELECTED ITEM");
		lblSelectedItem.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectedItem.setFont(new Font("Verdana", Font.BOLD, 20));
		lblSelectedItem.setBounds(108, 213, 194, 26);
		frmBrowseWindow.getContentPane().add(lblSelectedItem);
		
		JLabel lblCurrentBid = new JLabel("Buyout Price");
		lblCurrentBid.setBounds(259, 330, 75, 14);
		frmBrowseWindow.getContentPane().add(lblCurrentBid);
		
		
		txtbuyo.setEditable(false);
		txtbuyo.setBounds(219, 351, 151, 20);
		frmBrowseWindow.getContentPane().add(txtbuyo);
		
		JLabel label_1 = new JLabel("Current Bid");
		label_1.setBounds(259, 250, 75, 14);
		frmBrowseWindow.getContentPane().add(label_1);
		
		
		txtbid.setEditable(false);
		txtbid.setBounds(219, 278, 151, 20);
		frmBrowseWindow.getContentPane().add(txtbid);
		
		JLabel label_2 = new JLabel("Item Name");
		label_2.setBounds(86, 285, 75, 14);
		frmBrowseWindow.getContentPane().add(label_2);
		
		
		txtname.setEditable(false);
		txtname.setBounds(49, 308, 151, 20);
		frmBrowseWindow.getContentPane().add(txtname);
		
		JLabel lblNewLabel_1 = new JLabel("WALLET :");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(410, 218, 75, 20);
		frmBrowseWindow.getContentPane().add(lblNewLabel_1);
		
		JLabel lblBtc = new JLabel("BTC");
		lblBtc.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblBtc.setBounds(566, 218, 37, 20);
		frmBrowseWindow.getContentPane().add(lblBtc);
		
		
		
		
		
		txtWal.setEditable(false);
		txtWal.setBounds(482, 219, 81, 20);
		frmBrowseWindow.getContentPane().add(txtWal);
		
	}
}
