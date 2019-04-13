
package splash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erfan
 */
public class AccountPro extends javax.swing.JFrame {

	/**
	 * Creates new form AccountPro
	 */
	public AccountPro() {
		initComponents();

		setSize(806, 710);

		File file = new File("/splash/test1.csv");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			// get the first line
			// get the columns name from the first line
			// set columns name to the iterable model

			// get lines from text file
			Object[] tableLines = br.lines().toArray();

			// extract data from lines
			// set data to iterable model
			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split(",");
				if (Login.jTextField1.getText().equals(dataRow[0])) {
					jLabel2.setText(dataRow[1]);
				}

			}

		} catch (Exception ex) {
		}

	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel1.setText("Your Score: ");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(60, 110, 210, 100);

		jButton1.setText("Friend");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(150, 460, 150, 50);

		jButton2.setText("Leaderboard");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(350, 460, 160, 50);

		jButton3.setText("Update dept");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton3);
		jButton3.setBounds(570, 460, 160, 50);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
		getContentPane().add(jLabel2);
		jLabel2.setBounds(290, 110, 210, 100);

		jButton4.setText("Back");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton4);
		jButton4.setBounds(10, 460, 140, 50);

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		this.setVisible(false);
		new leader().setVisible(true);
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

		this.setVisible(false);
		new up().setVisible(true);

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		new Friends().setVisible(true);

	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		new Avocado().setVisible(true);
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
			java.util.logging.Logger.getLogger(AccountPro.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AccountPro.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AccountPro.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AccountPro.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AccountPro().setVisible(true);
			}
		});
	}

	// Variables declarations
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	public static javax.swing.JLabel jLabel2;

}
