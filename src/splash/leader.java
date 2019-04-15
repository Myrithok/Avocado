
package splash;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Erfan
 */
public class leader extends javax.swing.JFrame {

	/**
	 * Creates new form leader
	 */
	public leader() {
		initComponents();
		setSize(791, 631);
		fun();

		DefaultTableModel ts = (DefaultTableModel) jTable2.getModel();
		int number_of_rows = ts.getRowCount();

		String t;
		int a[] = new int[number_of_rows];

		for (int j = 0; j < number_of_rows; j++) {
			if (j == 0) {

			} else {
				t = jTable2.getModel().getValueAt(j, 1).toString();
				int result = Integer.parseInt(t);
				a[j - 1] = result;
			}
		}
		int temp = 0;
		for (int i = 0; i < number_of_rows; i++) {
			for (int j = i + 1; j < number_of_rows; j++) {
				if (a[i] < a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		for (int j = 0; j < number_of_rows; j++) {
			for (int k = 0; k < number_of_rows; k++) {
				if (k == 0) {

				} else {
					t = jTable1.getModel().getValueAt(k, 1).toString();
					int result = Integer.parseInt(t);
					String as = AccountPro.jLabel2.getText().toString();
					int no = Integer.parseInt(as);
					if (a[j] == result && no == a[j]) {
						j++;
						jLabel2.setText("Position is " + j);
						break;
					}
				}
			}
		}

	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("LeaderBoard");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(281, 11, 260, 140);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Name", "Score" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTable1);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(200, 120, 350, 120);

		jTable2.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "My Position", "Score" }) {
			boolean[] canEdit = new boolean[] { false, true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(jTable2);

		getContentPane().add(jScrollPane2);
		jScrollPane2.setBounds(200, 310, 350, 120);

		jLabel2.setText("jLabel2");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(30, 390, 140, 30);

		jButton4.setText("Back");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton4);
		jButton4.setBounds(290, 500, 140, 60);

		pack();
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

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
			java.util.logging.Logger.getLogger(leader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(leader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(leader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(leader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new leader().setVisible(true);

			}
		});
	}

	public void fun() {

		File file = new File("/splash/top5sample.csv");
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

		file = new File("/splash/MyPosition.csv");
		try {

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

	// Variables declaration 
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	public static javax.swing.JTable jTable1;
	private static javax.swing.JTable jTable2;

}
/*
 * if(Login.jTextField1.getText().equals(dataRow[0]))
 * 
 */