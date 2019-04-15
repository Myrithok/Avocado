
package splash;

/**
 *
 * @author Erfan
 */
public class Avocado extends javax.swing.JFrame {

	/**
	 * Creates new form Avocado
	 */
	public Avocado() {
		initComponents();
		setSize(806, 710);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jButton1.setText("Log In");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(320, 170, 140, 80);

		jButton2.setText("Create Account");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(320, 380, 140, 80);

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		this.setVisible(false);
		new Login().setVisible(true);

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		this.setVisible(false);
		new Create().setVisible(true);

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
			java.util.logging.Logger.getLogger(Avocado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Avocado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Avocado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Avocado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Avocado().setVisible(true);
			}
		});
	}

	// Variables declarations
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;

}
