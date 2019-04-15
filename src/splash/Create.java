
package splash;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		setSize(400, 800);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {
		jLabelUsername = new javax.swing.JLabel();
		jLabelPassword = new javax.swing.JLabel();
		jTextFieldPassword = new javax.swing.JTextField();
		jTextFieldUsername = new javax.swing.JTextField();
		
		jLabelGradDebt = new javax.swing.JLabel();
		jLabelDebt = new javax.swing.JLabel();
		jLabelInterest = new javax.swing.JLabel();
		jLabelGrad = new javax.swing.JLabel();
		jLabelBirth = new javax.swing.JLabel();
		jLabelProvince = new javax.swing.JLabel();
		jLabelEducation = new javax.swing.JLabel();
		jLabelField = new javax.swing.JLabel();
		jLabelSex = new javax.swing.JLabel();
		jTextFieldGradDebt = new javax.swing.JTextField();
		jTextFieldDebt = new javax.swing.JTextField();
		jTextFieldInterest = new javax.swing.JTextField();
		jTextFieldGrad = new javax.swing.JTextField();
		jTextFieldBirth = new javax.swing.JTextField();
		jComboBoxEducation = new javax.swing.JComboBox();
		jComboBoxProvince = new javax.swing.JComboBox();
		jComboBoxField = new javax.swing.JComboBox();
		jComboBoxSex = new javax.swing.JComboBox();
		jButtonCreate = new javax.swing.JButton();
		//jButtonCreate = new javax.swing.JButton();
		jButtonBack = new javax.swing.JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//getContentPane.setMaximumSize( panel.getPreferredSize() )
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		jButtonCreate.setText("Create");
		jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jLabelUsername.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabelUsername.setText("User Name");
		getContentPane().add(jLabelUsername,BorderLayout.CENTER);
		//jLabelUsername.setBounds(101, 111, 160, 60);
		getContentPane().add(jTextFieldUsername,BorderLayout.CENTER);
		jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabelPassword.setText("Password");
		jLabelGradDebt.setText("Debt At Graduation: ");
		jLabelDebt.setText("Current Debt: ");
		jLabelInterest.setText("Interest: ");
		jLabelGrad.setText("Graduation Date (YYYY-MM-DD): ");
		jLabelBirth.setText("Birthdate(YYYY-MM-DD): ");
		jLabelProvince.setText("Province: ");
		jLabelEducation.setText("Level of Education: ");
		jLabelField.setText("Field of Study: ");
		jLabelSex.setText("Sex: ");
		getContentPane().add(jLabelPassword,BorderLayout.CENTER);

		getContentPane().add(jTextFieldPassword,BorderLayout.CENTER);
		
		getContentPane().add(jLabelGradDebt,BorderLayout.CENTER);
		getContentPane().add(jTextFieldGradDebt,BorderLayout.CENTER);
		getContentPane().add(jLabelDebt,BorderLayout.CENTER);
		getContentPane().add(jTextFieldDebt,BorderLayout.CENTER);
		getContentPane().add(jLabelInterest,BorderLayout.CENTER);
		getContentPane().add(jTextFieldInterest,BorderLayout.CENTER);
		getContentPane().add(jLabelGrad,BorderLayout.CENTER);
		getContentPane().add(jTextFieldGrad,BorderLayout.CENTER);
		getContentPane().add(jLabelBirth,BorderLayout.CENTER);
		getContentPane().add(jTextFieldBirth,BorderLayout.CENTER);
		getContentPane().add(jLabelProvince,BorderLayout.CENTER);
		getContentPane().add(jComboBoxProvince,BorderLayout.CENTER);
		getContentPane().add(jLabelEducation,BorderLayout.CENTER);
		getContentPane().add(jComboBoxEducation,BorderLayout.CENTER);
		getContentPane().add(jLabelField,BorderLayout.CENTER);
		getContentPane().add(jComboBoxField,BorderLayout.CENTER);
		getContentPane().add(jLabelSex,BorderLayout.CENTER);
		getContentPane().add(jComboBoxSex,BorderLayout.CENTER);
		//jTextFieldUsername.setBounds(260, 120, 210, 30);
		jButtonCreate.setPreferredSize(new Dimension(180,80));
		jButtonCreate.setAlignmentX(LEFT_ALIGNMENT);
		getContentPane().add(jButtonCreate,BorderLayout.CENTER);
		//jButtonCreate.setBounds(280, 620, 180, 80);
		getContentPane().setVisible(true);
		jButtonBack.setText("Back");
		jButtonBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButtonBack,BorderLayout.CENTER);
		//jButtonBack.setBounds(0, 510, 120, 60);

		
		
		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		if (jTextFieldUsername.getText().equals("") || jTextFieldPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Do not leave any of the fields empty.");
		} else {

			int i = 0;
			String id;
			String pas;

			String user = jTextFieldUsername.getText();
			String pass = jTextFieldUsername.getText();;
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
					fw.write(jTextFieldUsername.getText().toString());
					fw.write("\n");
					fw.write(jTextFieldPassword.getText().toString());
					fw.write("\n");
					JOptionPane.showMessageDialog(null, "Create Account");
					this.setVisible(false);
					new AccountPro().setVisible(true);

				} else {
					fw.append(jTextFieldUsername.getText().toString());
					fw.append("\n");
					fw.append(jTextFieldPassword.getText().toString());
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

	private javax.swing.JButton jButtonCreate;
	private javax.swing.JButton jButtonBack;
	private javax.swing.JLabel jLabelPassword;
	private javax.swing.JLabel jLabelUsername;
	private javax.swing.JTextField jTextFieldUsername;
	private javax.swing.JTextField jTextFieldPassword;
	private javax.swing.JLabel jLabelGradDebt;
	private javax.swing.JLabel jLabelDebt;
	private javax.swing.JTextField jTextFieldGradDebt;
	private javax.swing.JTextField jTextFieldDebt;
	private javax.swing.JLabel jLabelInterest;
	private javax.swing.JLabel jLabelGrad;
	private javax.swing.JTextField jTextFieldInterest;
	private javax.swing.JTextField jTextFieldGrad;
	private javax.swing.JLabel jLabelBirth;
	private javax.swing.JLabel jLabelProvince;
	private javax.swing.JTextField jTextFieldBirth;
	private javax.swing.JComboBox jComboBoxProvince;
	private javax.swing.JLabel jLabelEducation;
	private javax.swing.JLabel jLabelSex;
	private javax.swing.JComboBox jComboBoxEducation;
	private javax.swing.JComboBox jComboBoxSex;
	private javax.swing.JLabel jLabelField;
	private javax.swing.JComboBox jComboBoxField;

}
