package snakeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameNickname_View extends JFrame {

	private static final long serialVersionUID = 1L;

	private Image imgNickname;
	public Rectangle btnBack, btnPlay;
	public JTextField txtNickname;
	

	public GameNickname_View() {
		this.setTitle("Snake Game - Nickname");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgNickname = toolkit.getImage("resources/imgNickname.png");

		// Build a JPanel to contain JTextField
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.setPreferredSize(new Dimension(600, 600));
		this.add(panel);

		// White space to push the panel in and center it
		JPanel topSpace = new JPanel();
		topSpace.setPreferredSize(new Dimension(600, 280));
		panel.add(topSpace, BorderLayout.NORTH);

		// JTextField Customized
		txtNickname = new JTextField();
		txtNickname.setPreferredSize(new Dimension(280, 50));
		txtNickname.setFont(new Font("Arial", Font.BOLD, 30));
		txtNickname.setForeground(new Color(0x005300));
		txtNickname.setBackground(Color.WHITE);
		txtNickname.setCaretColor(Color.BLACK);
		panel.add(txtNickname);

		btnBack = new Rectangle(30, 531, 95, 50);
		btnPlay = new Rectangle(475, 531, 95, 50);

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgNickname, 0, 20, this);

	}

	public void showErrorDialog() {
		
		JDialog dialog = new JDialog(this, "Nickname Error", true);
		dialog.setSize(430, 150);
		dialog.setPreferredSize(new Dimension(430, 150));
		dialog.setMinimumSize(new Dimension(430, 150));
		dialog.setMaximumSize(new Dimension(430, 150));
		dialog.setLayout(null);

		JLabel messageLabel = new JLabel("The nickname must have a minimum of 3 and a maximum of 15 letters.");
		messageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		messageLabel.setBounds(10, 10, 430, 40);
		dialog.add(messageLabel);

		JButton closeButton = new JButton("OK");
		closeButton.setBounds(175, 60, 80, 30);
		closeButton.addActionListener(e -> dialog.dispose());
		dialog.add(closeButton);

		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
	}
}
