package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GameMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	private Image imgMenu;

	public GameMenu() {

		this.setTitle("QuizMasters - Game Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 900);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("img/gameMenu.png");

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgMenu, 0, 0, this);
	}
}

