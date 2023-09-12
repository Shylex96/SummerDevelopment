package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoadUser extends JFrame {

	private static final long serialVersionUID = 1L;

	private Image imgLogin;
	public JTextField txtNickname;
	public JTextField txtPassword; 

	public LoadUser() {

		this.setTitle("QuizMasters - Load profile");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 900);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgLogin = toolkit.getImage("img/login.png");

		// Build a Main JPanel to contain JTextFields - No layout (null)
		JPanel panel = new JPanel(null);
		panel.setPreferredSize(new Dimension(600, 600));
		this.add(panel);

		// JTextField Customized: txtNickname
		txtNickname = new JTextField();
		txtNickname.setBounds(427, 493, 350, 65);
		txtNickname.setFont(new Font("Arial", Font.BOLD, 30));
		txtNickname.setForeground(new Color(0x000000));
		txtNickname.setBackground(Color.WHITE);
		txtNickname.setCaretColor(Color.BLACK);
		panel.add(txtNickname);

		// JPasswordField Customized: txtPassword
		txtPassword = new JPasswordField();
		txtPassword.setBounds(427, 612, 350, 65);
		txtPassword.setFont(new Font("Arial", Font.BOLD, 30));
		txtPassword.setForeground(new Color(0x000000));
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setCaretColor(Color.BLACK);
		panel.add(txtPassword);

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgLogin, 0, 0, this);
	}

	public void showMessage(int messageValue) {

		if (messageValue == 1) {

			JOptionPane.showMessageDialog(null, "User not found. Check your credentials.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}



