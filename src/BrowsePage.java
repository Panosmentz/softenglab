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

public class BrowsePage {

	JFrame frmBrowseWindow;
	private JTextField textField;

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
	private void initialize() {
		frmBrowseWindow = new JFrame();
		frmBrowseWindow.setBounds(100, 100, 596, 467);
		frmBrowseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnbuy = new JButton("Buyout");
		
		JButton btnbid = new JButton("Bid");
		dbConnection db = new dbConnection();
		db.Browse(Main.usr);
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblbtc = new JLabel("BTC");
		
		JLabel lblNewLabel = new JLabel("Weapons");
		
		JLabel lblArmor = new JLabel("Armor");
		
		JLabel lblTrinkets = new JLabel("Trinkets");
		
		
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MainWindow mainwindow = new MainWindow();
				mainwindow.frmMainWindow.setVisible(true);
				frmBrowseWindow.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmBrowseWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(cmbwep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(84)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnbuy)
									.addGap(36)
									.addComponent(btnbid))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblArmor)
										.addComponent(cmbarm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblTrinkets)
										.addComponent(cmbtrin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblbtc)
							.addGap(97)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblTrinkets))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbwep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbtrin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblArmor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbarm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnbuy)
						.addComponent(btnbid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblbtc))
					.addGap(43)
					.addComponent(btnNewButton)
					.addGap(32))
		);
		frmBrowseWindow.getContentPane().setLayout(groupLayout);
	}
}
