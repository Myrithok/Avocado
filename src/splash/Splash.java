
package splash;

/**
 *
 * @author Erfan
 */
public class Splash {

	public static void main(String[] args) {

		new NewJFrame().setVisible(true);
		try {

			for (int i = 0; i < 100; i++) {
				Thread.sleep(40);
				NewJFrame.jProgressBar1.setValue(i);
				if (i == 99) {

					new Avocado().setVisible(true);

				}

			}

		} catch (Exception e) {

		}

	}

}
