
package splash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erfan
 */
public class Login extends javax.swing.JFrame {

	/**
	 * Creates new form Login
	 */
	public Login() {
		initComponents();
		setSize(806, 710);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel1.setText("Password");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(100, 240, 160, 60);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel2.setText("User Name");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(101, 111, 160, 60);
		getContentPane().add(jTextField1);
		jTextField1.setBounds(260, 120, 210, 30);
		getContentPane().add(jTextField2);
		jTextField2.setBounds(260, 250, 210, 30);

		jButton1.setText("Log In");
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
		jButton2.setBounds(0, 430, 120, 60);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel3.setText("AVOCADO");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(300, 10, 290, 70);

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
			File file = new File("CreateAndLogin.txt");
			String st;
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));

				while ((st = br.readLine()) != null) {
					System.out.println(st);

					{
						id = st;

						pas = br.readLine();
						user = jTextField1.getText();
						pass = jTextField2.getText();
						if (user.equals(id) && pass.equals(pas)) {
							JOptionPane.showMessageDialog(null, "You are logged in!");
							this.setVisible(false);
							new AccountPro().setVisible(true);
						}

					}
				}
			} catch (IOException ex) {
				Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	public static javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;

}
