package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

public class NewUser extends JFrame {

    private static final long serialVersionUID = 1L;

    private Image imgRegister;
    public JTextField txtNickname;
    public JTextField txtPassword; 

    public NewUser() {

        this.setTitle("QuizMasters - New profile");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        imgRegister = toolkit.getImage("img/register.png");

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
        g.drawImage(imgRegister, 0, 0, this);
    }

	public void showMessage(int messageValue) {
		
		if (messageValue == 1) {
			
			JOptionPane.showMessageDialog(null, "Nickname must be between 5 and 15 characters.", "Error", JOptionPane.ERROR_MESSAGE);
			
		} else if (messageValue == 2) {
			
			JOptionPane.showMessageDialog(null, "The password must be between 5 and 15 characters.", "Error", JOptionPane.ERROR_MESSAGE);
			
		} else if (messageValue == 3) {
			
			JOptionPane.showMessageDialog(null, "The password must contain uppercase, lowercase characters and at least one number. ", "Error", JOptionPane.ERROR_MESSAGE);
			
		} else if (messageValue == 4) {
			
			JOptionPane.showMessageDialog(null, "Successfully Authentication. You have created an account.", "Success", JOptionPane.PLAIN_MESSAGE);
			
		} else if (messageValue == 5) {
			
			JOptionPane.showMessageDialog(null, "Something went wrong during the process. Please try again later or contact support.", "Error", JOptionPane.ERROR_MESSAGE);
		
		} else if (messageValue == 6) {
			
			JOptionPane.showMessageDialog(null, "Nickname already in use. Please, choose another one.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
