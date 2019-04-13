
package splash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import static splash.Login.jTextField1;
import static splash.leader.jTable1;

/**
 *
 * @author Erfan
 */
public class Friends extends javax.swing.JFrame {

	/**
	 * Creates new Friends form
	 */
	public Friends() {
		initComponents();
		setSize(806, 710);

		File file = new File("/splash/MyFriendCode.txt");
		String st;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));

			while ((st = br.readLine()) != null) {
				jComboBox1.addItem(st);

			}
		} catch (IOException ex) {

		}

		fun();
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jComboBox1 = new javax.swing.JComboBox<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Friends");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(340, 30, 280, 130);

		jButton1.setText("Back");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(0, 500, 130, 50);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Name", "Score" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTable1);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(10, 250, 320, 120);

		jTable2.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "My Position", "Score" }) {
			boolean[] canEdit = new boolean[] { false, true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(jTable2);

		getContentPane().add(jScrollPane2);
		jScrollPane2.setBounds(360, 250, 330, 120);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel2.setText("MY FRIENDS");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(80, 400, 200, 40);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel3.setText("FRIEND SUGGESTIONS");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(400, 420, 270, 22);

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel4.setText("My Friend Code:");
		getContentPane().add(jLabel4);
		jLabel4.setBounds(260, 20, 160, 30);
		getContentPane().add(jTextField1);
		jTextField1.setBounds(210, 160, 130, 30);

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel5.setText("Add Friend: ");
		getContentPane().add(jLabel5);
		jLabel5.setBounds(40, 160, 160, 30);

		jButton2.setText("Add");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(390, 160, 90, 30);

		getContentPane().add(jComboBox1);
		jComboBox1.setBounds(430, 30, 110, 20);

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		new AccountPro().setVisible(true);

	}

	public void fun3() {
		File file;
		String st;
		BufferedReader br = null;
		try {

			String filepath = "/splash/MyFriends.csv";
			File f = new File(filepath);
			FileWriter fw = null;
			boolean appen = false;
			String as = jComboBox1.getSelectedItem().toString();
			try {
				if (f.exists()) {
					fw = new FileWriter(filepath, true);
					appen = true;
				} else {
					fw = new FileWriter(filepath);

				}

			} catch (Exception ex) {
				Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				if (appen == false) {
					fw.write(as);
					fw.write("\n");
					JOptionPane.showMessageDialog(null, "Done");
					this.setVisible(false);
					new AccountPro().setVisible(true);

				} else {
					fw.append(as);
					fw.append("\n");
					fw.close();

					JOptionPane.showMessageDialog(null, "Done");
					this.setVisible(false);
					new AccountPro().setVisible(true);
				}
			} catch (IOException ex) {
				Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
			}

		} catch (Exception ex) {

		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		String filepath = "/splash/MyFriendCode.txt";
		File f = new File(filepath);
		FileWriter fw = null;
		boolean appen = false;
		try {
			if (f.exists()) {
				fw = new FileWriter(filepath, true);
				appen = true;
			} else {
				fw = new FileWriter(filepath);

			}

		} catch (Exception ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			if (appen == false) {
				fw.write(jTextField1.getText().toString());
				fw.write("\n");
				JOptionPane.showMessageDialog(null, "Added ");
				this.setVisible(false);
				new AccountPro().setVisible(true);

			} else {
				fw.append(jTextField1.getText().toString());
				fw.append("\n");
				fw.close();

				JOptionPane.showMessageDialog(null, "Added");
				this.setVisible(false);
				new AccountPro().setVisible(true);
			}
		} catch (IOException ex) {
			Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Friends().setVisible(true);
			}
		});
	}

	public void fun() {

		File file = new File("/splash/MyFriends.csv");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			// get the first line
			// get the columns name from the first line
			// set columns name to the iterable model
			DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

			// get lines from text file
			Object[] tableLines = br.lines().toArray();

			// extract data from lines
			// set data to iterable model
			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split(",");

				model.addRow(dataRow);
			}

		} catch (Exception ex) {
		}

		try {
			file = new File("/splash/Friend Suggestions.csv");
			BufferedReader br = new BufferedReader(new FileReader(file));
			// get the first line
			// get the columns name from the first line
			// set columns name to the iterable model
			DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

			// get lines from text file
			Object[] tableLines = br.lines().toArray();

			// extract data from lines
			// set data to iterable model
			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split(",");
				{
					System.out.print("EQ");
					int k = i + 1;
				}

				model.addRow(dataRow);
			}

		} catch (Exception ex) {
		}

	}

	// Variables declarations
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	public static javax.swing.JTable jTable1;
	private static javax.swing.JTable jTable2;
	private javax.swing.JTextField jTextField1;

}
