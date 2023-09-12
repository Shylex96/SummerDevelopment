package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	private Image imgMenu;

	public MainMenu() {
		this.setTitle("QuizMasters - Main Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 900);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("img/mainMenu0.png");

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgMenu, 0, 0, this);
	}

	public void swapToImage1() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("img/mainMenu1.png");
		repaint();
	}

	public void swapToImage2() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("img/mainMenu2.png");
		repaint();
	}

	public void swapToImage3() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("img/mainMenu3.png");
		repaint();
	}

	public void restoreImage() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgMenu = toolkit.getImage("img/mainMenu0.png");
		repaint();
	}
}
