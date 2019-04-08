
package splash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erfan
 */
public class Create extends javax.swing.JFrame {

	/**
	 * Creates new form Create
	 */
	public Create() {
		initComponents();
		setSize(806, 710);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jTextField1 = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jButton1.setText("Create");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(280, 420, 180, 80);

		jButton2.setText("Back");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(0, 510, 120, 60);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel2.setText("User Name");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(101, 111, 160, 60);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel1.setText("Password");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(100, 240, 160, 60);
		getContentPane().add(jTextField2);
		jTextField2.setBounds(260, 250, 210, 30);
		getContentPane().add(jTextField1);
		jTextField1.setBounds(260, 120, 210, 30);

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		if (jTextField1.getText().equals("") || jTextField2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Do not leave any of the fields empty.");
		} else {

			int i = 0;
			String id;
			String pas;

			String user;
			String pass;
			String filepath = "CreateAndLogin.txt";
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
					fw.write(jTextField2.getText().toString());
					fw.write("\n");
					JOptionPane.showMessageDialog(null, "Create Account");
					this.setVisible(false);
					new AccountPro().setVisible(true);

				} else {
					fw.append(jTextField1.getText().toString());
					fw.append("\n");
					fw.append(jTextField2.getText().toString());
					fw.append("\n");
					fw.close();

					JOptionPane.showMessageDialog(null, "Account Created.");
					this.setVisible(false);
					new AccountPro().setVisible(true);
				}
			} catch (IOException ex) {
				Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
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
			java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Create().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;

}
