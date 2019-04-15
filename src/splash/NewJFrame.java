
package splash;

/**
 *
 * @author Erfan
 */
public class NewJFrame extends javax.swing.JFrame {

	/**
	 * Creates new form NewJFrame
	 */
	public NewJFrame() {
		initComponents();
		setSize(806, 710);

	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jProgressBar1 = new javax.swing.JProgressBar();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(jProgressBar1);
		jProgressBar1.setBounds(0, 0, 790, 14);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/splash/avo.gif")));
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 800, 670);

		pack();
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
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// new NewJFrame().setVisible(true);

			}
		});
	}

	private javax.swing.JLabel jLabel1;
	public static javax.swing.JProgressBar jProgressBar1;

}
