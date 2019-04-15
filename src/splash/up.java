
package splash;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erfan
 */
public class up extends javax.swing.JFrame {

	/**
	 * Creates new form up
	 */
	public up() {
		initComponents();
		setSize(806, 710);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jCheckBox1 = new javax.swing.JCheckBox();
		jLabel4 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Update Information");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(210, 51, 280, 90);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel2.setText("Old Debt: ");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(80, 210, 90, 40);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel3.setText("New Dept:");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(80, 340, 90, 40);
		//getContentPane().add(jTextField1);
		//jTextField1.setBounds(240, 210, 170, 30);
		getContentPane().add(jTextField2);
		jTextField2.setBounds(240, 340, 170, 30);
		getContentPane().add(jCheckBox1);
		jCheckBox1.setBounds(280, 480, 21, 21);

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel4.setText("Opt. in Leaderboard");
		getContentPane().add(jLabel4);
		jLabel4.setBounds(80, 470, 170, 30);

		jButton2.setText("Save");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(610, 520, 110, 40);

		jButton1.setText("Back");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(0, 520, 90, 40);

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		if ( jTextField2.getText().equals("")) {  //-- (jTextField1.getText().equals("") ||
			JOptionPane.showMessageDialog(null, "Do not leave any of the fields empty.");
		} else {

			int i = 0;
			String id;
			String pas;

			String user;
			String pass;
			String filepath = "/splash/up.txt";
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
			}
			try {

				if (appen == false) {
					//fw.write(jTextField1.getText().toString());
					//fw.write(",");
					fw.write(jTextField2.getText().toString());
					fw.write(",");
					if (jCheckBox1.isSelected()) {
						fw.write("true");
					} else {
						// Not checked;
						fw.write("false");
					}

					fw.write("\n");
					JOptionPane.showMessageDialog(null, "Added");
					this.setVisible(false);
					new AccountPro().setVisible(true);

				} else {
					//fw.append(jTextField1.getText().toString());
					//fw.append(",");
					fw.append(jTextField1.getText().toString());
					fw.append(",");

					if (jCheckBox1.isSelected()) {
						fw.write("true");
					} else {
						// Not checked;
						fw.write("false");
					}

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

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		new AccountPro().setVisible(true);

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
			java.util.logging.Logger.getLogger(up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new up().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;

}
