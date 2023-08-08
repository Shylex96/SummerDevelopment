package snakeGame;

import java.awt.*;
import javax.swing.JFrame;

public class GameMenu_View extends JFrame {

	private static final long serialVersionUID = 1L;

	private Image imgMenu;
	public Rectangle btnPlay, btnControls, btnRanking;

	public GameMenu_View() {
		this.setTitle("Snake Game - Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("resources/imgMenu.png");

		btnPlay = new Rectangle(212, 405, 175, 95);
		btnControls = new Rectangle(418, 430, 160, 67);
		btnRanking = new Rectangle(23, 430, 160, 67);

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgMenu, -7, 0, this);
	}
}
