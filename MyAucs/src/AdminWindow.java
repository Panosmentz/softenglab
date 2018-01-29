import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

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
	public static JComboBox<String> wcmb = new JComboBox<String>();
	public static JComboBox<String> acmb = new JComboBox<String>();
	public static JComboBox<String> tcmb = new JComboBox<String>();
	
	public static void addarm (String name[]) {		
		acmb.addItem(Arrays.toString(name));
		}
		
		public static void addtrin (String name[]) {		
			tcmb.addItem(Arrays.toString(name));
			}
		public static void addwep (String name[]) {		
			wcmb.addItem(Arrays.toString(name));
		}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminWindow = new JFrame();
		frmAdminWindow.setTitle("Administrator Window");
		frmAdminWindow.setBounds(100, 100, 418, 426);
		frmAdminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminWindow.getContentPane().setLayout(null);
		dbConnection db = new dbConnection();
		db.AdminBrowse(Main.usr);
		JLabel label = new JLabel("Weapons");
		label.setBounds(10, 14, 112, 20);
		frmAdminWindow.getContentPane().add(label);
		
		JTextPane txtname = new JTextPane();
		JTextPane txtbid = new JTextPane();
		JTextPane txtbuyo = new JTextPane();
		JTextPane txtebid = new JTextPane();
		JTextPane txtus = new JTextPane();
		
		
		wcmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (wcmb.getSelectedItem() != null ) {
					String selectedwep = (String) wcmb.getSelectedItem();
					Main.selectedtype="Weapons";
					String name = selectedwep.split(",")[0];
					txtname.setText(name.substring(1));
					String bid = selectedwep.split(",")[1];
					txtbid.setText(bid.substring(1));
					String buyo = selectedwep.split(",")[2];				
					txtbuyo.setText(buyo.substring(1));
					String user = selectedwep.split(",")[3];				
					txtus.setText(user.substring(1));
					String ebid = selectedwep.split(",")[4];				
					txtebid.setText(ebid.substring(1,ebid.length() - 1));
					}
				
			}
		});
		wcmb.setBounds(109, 11, 270, 26);
		frmAdminWindow.getContentPane().add(wcmb);
		
		tcmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if (tcmb.getSelectedItem() != null ) {
					String selectedtrink = (String) tcmb.getSelectedItem();
					Main.selectedtype="Trinkets";
					String name = selectedtrink.split(",")[0];
					txtname.setText(name.substring(1));
					String bid = selectedtrink.split(",")[1];
					txtbid.setText(bid.substring(1));
					String buyo = selectedtrink.split(",")[2];				
					txtbuyo.setText(buyo.substring(1));
					String user = selectedtrink.split(",")[3];				
					txtus.setText(user.substring(1));
					String ebid = selectedtrink.split(",")[4];				
					txtebid.setText(ebid.substring(1,ebid.length() - 1));
					}
				
			}
		});
		JLabel armor = new JLabel("Armor");
		armor.setBounds(10, 70, 206, 20);
		frmAdminWindow.getContentPane().add(armor);
		
		
		acmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (acmb.getSelectedItem() != null ) {
					String selectedarm = (String) acmb.getSelectedItem();
					Main.selectedtype="Armor";
					String name = selectedarm.split(",")[0];
					txtname.setText(name.substring(1));
					String bid = selectedarm.split(",")[1];
					txtbid.setText(bid.substring(1));
					String buyo = selectedarm.split(",")[2];				
					txtbuyo.setText(buyo.substring(1));
					String user = selectedarm.split(",")[3];				
					txtus.setText(user.substring(1));
					String ebid = selectedarm.split(",")[4];				
					txtebid.setText(ebid.substring(1,ebid.length() - 1));
					}
				
			}
		});
		acmb.setBounds(109, 67, 270, 26);
		frmAdminWindow.getContentPane().add(acmb);
		
		JLabel label_2 = new JLabel("Trinkets");
		label_2.setBounds(10, 130, 124, 20);
		frmAdminWindow.getContentPane().add(label_2);
		
		
		tcmb.setBounds(109, 124, 270, 26);
		frmAdminWindow.getContentPane().add(tcmb);
		
		JLabel label_3 = new JLabel("SELECTED ITEM");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Verdana", Font.BOLD, 20));
		label_3.setBounds(69, 198, 194, 26);
		frmAdminWindow.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Item Name");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(52, 235, 75, 14);
		frmAdminWindow.getContentPane().add(label_4);
		
		
		txtname.setEditable(false);
		txtname.setBounds(19, 258, 151, 20);
		frmAdminWindow.getContentPane().add(txtname);
		
		JLabel label_5 = new JLabel("Current Bid");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(52, 289, 75, 14);
		frmAdminWindow.getContentPane().add(label_5);
		
		
		txtbid.setEditable(false);
		txtbid.setBounds(19, 309, 151, 20);
		frmAdminWindow.getContentPane().add(txtbid);
		
		JLabel label_6 = new JLabel("Buyout Price");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(52, 336, 75, 14);
		frmAdminWindow.getContentPane().add(label_6);
		
		
		txtbuyo.setEditable(false);
		txtbuyo.setBounds(19, 355, 151, 20);
		frmAdminWindow.getContentPane().add(txtbuyo);
		
		JButton btnDel = new JButton("Delete Selected Auction");
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (acmb.getSelectedItem() != null && wcmb.getSelectedItem() != null && tcmb.getSelectedItem() != null) {
					
					dbConnection db = new dbConnection();
					db.AdminDelete(txtus.getText(),txtname.getText());
										
				}
				
			}
		});
		btnDel.setBounds(191, 352, 188, 23);
		frmAdminWindow.getContentPane().add(btnDel);
		
		JLabel lblEndBid = new JLabel("End Bid");
		lblEndBid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndBid.setBounds(224, 235, 75, 14);
		frmAdminWindow.getContentPane().add(lblEndBid);
		
		
		txtebid.setEditable(false);
		txtebid.setBounds(191, 258, 151, 20);
		frmAdminWindow.getContentPane().add(txtebid);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(224, 289, 75, 14);
		frmAdminWindow.getContentPane().add(lblUser);
		
		
		txtus.setEditable(false);
		txtus.setBounds(191, 312, 151, 20);
		frmAdminWindow.getContentPane().add(txtus);
	}
}
