import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	GameFrame() {
		
		/* 
		 * GamePanel panel = new GamePanel();
		 * this.add(panel);
		 */
		
		// Instead of the large version we can use this shortcut
		this.add(new GamePanel());
		
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		// The "pack" method: Automatically sizes the frame to fit its contents.
        // The frame will be just big enough to accommodate the GamePanel.
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
