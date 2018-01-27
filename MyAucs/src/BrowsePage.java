import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
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
	private JTextField buyop;
	
	
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
	private void initialize() {
		frmBrowseWindow = new JFrame();
		frmBrowseWindow.setBounds(100, 100, 894, 467);
		frmBrowseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnbuy = new JButton("Buyout");
		btnbuy.setBounds(664, 243, 81, 29);
		btnbuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
				
			}
		});
		
		JButton btnbid = new JButton("Bid");
		btnbid.setBounds(664, 198, 81, 29);
		btnbid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
			}
		});
		dbConnection db = new dbConnection();
		db.Browse(Main.usr);
		bidp = new JTextField();
		bidp.setBounds(760, 198, 62, 26);
		bidp.setColumns(10);
		
		JLabel lblbtc = new JLabel("BTC");
		lblbtc.setBounds(828, 249, 29, 20);
		
		JLabel lblNewLabel = new JLabel("Weapons");
		lblNewLabel.setBounds(49, 29, 112, 20);
		
		JLabel lblArmor = new JLabel("Armor");
		lblArmor.setBounds(49, 85, 206, 20);
		
		JLabel lblTrinkets = new JLabel("Trinkets");
		lblTrinkets.setBounds(49, 145, 124, 20);
		
		JLabel label = new JLabel("BTC");
		label.setBounds(828, 201, 29, 20);
		
		buyop = new JTextField();
		buyop.setBounds(760, 246, 62, 26);
		buyop.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(664, 290, 81, 29);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MainWindow window = new MainWindow();
				window.frmMainWindow.setVisible(true);
				frmBrowseWindow.dispose();
				
			}
		});
		frmBrowseWindow.getContentPane().setLayout(null);
		frmBrowseWindow.getContentPane().add(lblArmor);
		frmBrowseWindow.getContentPane().add(lblTrinkets);
		frmBrowseWindow.getContentPane().add(lblNewLabel);
		cmbwep.setBounds(148, 26, 516, 26);
		frmBrowseWindow.getContentPane().add(cmbwep);
		cmbtrin.setBounds(148, 139, 516, 26);
		frmBrowseWindow.getContentPane().add(cmbtrin);
		cmbarm.setBounds(148, 82, 516, 26);
		frmBrowseWindow.getContentPane().add(cmbarm);
		frmBrowseWindow.getContentPane().add(btnBack);
		frmBrowseWindow.getContentPane().add(btnbid);
		frmBrowseWindow.getContentPane().add(btnbuy);
		frmBrowseWindow.getContentPane().add(bidp);
		frmBrowseWindow.getContentPane().add(label);
		frmBrowseWindow.getContentPane().add(buyop);
		frmBrowseWindow.getContentPane().add(lblbtc);
		
		JPanel panel = new JPanel();
		panel.setBounds(49, 198, 600, 197);
		frmBrowseWindow.getContentPane().add(panel);
		
		JLabel lblSelectedItem = new JLabel("Selected Item");
		lblSelectedItem.setFont(new Font("Verdana", Font.PLAIN, 20));
		panel.add(lblSelectedItem);
	}
}
