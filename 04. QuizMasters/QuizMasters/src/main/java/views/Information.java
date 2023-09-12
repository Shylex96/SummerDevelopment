package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Information extends JFrame {

	private static final long serialVersionUID = 1L;

	private Image imgInfo;

	public Information() {
		
		this.setTitle("QuizMasters - Info");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 900);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgInfo = toolkit.getImage("img/info.png");

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgInfo, 0, 0, this);
	}
}
