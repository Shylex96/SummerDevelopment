package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import models.UserDatabaseManager;
import views.GameMenu;
import views.Information;
import views.LoadUser;
import views.MainMenu;
import views.NewUser;

public class MainController implements WindowListener, MouseListener, MouseMotionListener, ActionListener {

	private UserDatabaseManager userManager;
	private MainMenu mainMenu;
	private Information info;
	private NewUser newUser;
	private LoadUser login;
	private GameMenu gameMenu;

	private boolean button1Activated = false;
	private boolean button2Activated = false;
	private boolean button3Activated = false;

	public int messageValue = 0;

	public MainController(UserDatabaseManager createUser, MainMenu mainMenu) {

		this.userManager = createUser;
		this.mainMenu = mainMenu;

		mainMenu.addMouseListener(this);
		mainMenu.addWindowListener(this);
		mainMenu.addMouseMotionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		int mouseX = e.getX();
		int mouseY = e.getY();

		// Check if the mouse is within the desired coordinates
		boolean insideButton1 = (mouseX >= 310 && mouseX <= 890 && mouseY >= 410 && mouseY <= 530);
		boolean insideButton2 = (mouseX >= 310 && mouseX <= 890 && mouseY >= 545 && mouseY <= 660);
		boolean insideButton3 = (mouseX >= 310 && mouseX <= 890 && mouseY >= 675 && mouseY <= 792);

		// Check if the mouse has left all areas of interest
		// -- Main Menu:
		if (mainMenu.isActive() && insideButton1 && !button1Activated) {

			mainMenu.swapToImage1();
			button1Activated = true;

		} else if (!insideButton1 && button1Activated) {

			mainMenu.restoreImage();
			button1Activated = false;
		}

		if (mainMenu.isActive() && insideButton2 && !button2Activated) {

			mainMenu.swapToImage2();
			button2Activated = true;

		} else if (!insideButton2 && button2Activated) {

			mainMenu.restoreImage();
			button2Activated = false;
		}

		if (mainMenu.isActive() && insideButton3 && !button3Activated) {

			mainMenu.swapToImage3();
			button3Activated = true;

		} else if (!insideButton3 && button3Activated) {

			mainMenu.restoreImage();
			button3Activated = false;
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		int mouseX = e.getX();
		int mouseY = e.getY();

		System.out.println("X: " +mouseX+ " Y: " +mouseY);

		// # MAIN MENU ACTIVE #
		if (mainMenu != null && mainMenu.isActive()) {

			// -- Go to New User:
			if (mouseX >= 310 && mouseX <= 890 && mouseY >= 410 && mouseY <= 530) {

				mainMenu.setVisible(false);
				newUser = new NewUser();
				newUser.addMouseListener(this);

			} // -- Go to Login Menu: 
			else if (mouseX >= 310 && mouseX <= 890 && mouseY >= 545 && mouseY <= 660) {

				mainMenu.setVisible(false);
				login = new LoadUser();
				login.addMouseListener(this);

			} // -- Go to Info Menu: 
			else if (mouseX >= 310 && mouseX <= 890 && mouseY >= 675 && mouseY <= 792) {

				mainMenu.setVisible(false);
				info = new Information();
				info.addMouseListener(this);
			}

		} // # NEW USER ACTIVE #
		else if (newUser != null && newUser.isActive()) {

			// -- Go back to Main Menu from New User
			if (mouseX >= 45 && mouseX <= 165 && mouseY >= 810 && mouseY <= 865) {

				newUser.dispose();
				mainMenu.setVisible(true);

			} // -- Create New User and Go to Login
			else if (mouseX >= 495 && mouseX <= 725 && mouseY >= 750 && mouseY <= 810) {

				String nickname = newUser.txtNickname.getText();
				String password = newUser.txtPassword.getText();

				// Checking nickname & password security and authentication
				if (nickname.length() < 5 || nickname.length() > 15) {

					messageValue = 1;
					newUser.showMessage(messageValue);

				} else if (password.length() < 5 || password.length() > 15) {

					messageValue = 2;
					newUser.showMessage(messageValue);

				} else if (!containsDigit(password) || !containsUpperCase(password) || !containsLowerCase(password)) {

					messageValue = 3;
					newUser.showMessage(messageValue);

				} else {

					// Trying to create a New User 
					userManager = new UserDatabaseManager();
					userManager.insertData(nickname, password);

					// User already exist - Nickname duped.
					if (userManager.exist == true) {

						messageValue = 6;
						newUser.showMessage(messageValue);
						newUser.txtNickname.setText("");

						userManager.closeConnection();
						return;
					}

					// Something went wrong.
					if (userManager.insert == false) {

						messageValue = 5;
						newUser.showMessage(messageValue);

					} else {

						// Successfully Authentication and Insert
						// Redirecting to the login screen
						messageValue = 4;
						newUser.showMessage(messageValue);

						newUser.dispose();
						login = new LoadUser();
						login.addMouseListener(this);
						
					}

					userManager.closeConnection();
				}
			}
		} // # LOGIN ACTIVE #
		else if (login != null && login.isActive()) {

			// Go back to Main Menu from Login 
			if (mouseX >= 47 && mouseX <= 165 && mouseY >= 810 && mouseY <= 865) {

				login.dispose();
				mainMenu.setVisible(true);

			} // User is trying to login
			else if (mouseX >= 495 && mouseX <= 725 && mouseY >= 750 && mouseY <= 810) {

				String nickname = login.txtNickname.getText();
				String password = login.txtPassword.getText();

				userManager = new UserDatabaseManager();
				boolean userExists = userManager.obtainUserData(nickname, password);

				if (userExists) {

					// Game Menu
					mainMenu.dispose();
					login.dispose();
					gameMenu = new GameMenu();
					gameMenu.addMouseListener(this);

					System.out.println("Usuario encontrado");

				} else {

					messageValue = 1;
					login.showMessage(messageValue);

					System.out.println("Usuario no encontrado");
				}
				userManager.closeConnection();
			}
		}
		// # INFO ACTIVE #
		else if (info != null && info.isActive()) {

			if (mouseX >= 495 && mouseX <= 705 && mouseY >= 810 && mouseY <= 875) {

				info.dispose();
				mainMenu.setVisible(true);
			}

		} // # GAME MENU #
		else if (gameMenu != null && gameMenu.isActive()) {

			// -- Go to Help Menu
			if (mouseX >= 485 && mouseX <= 710 && mouseY >= 635 && mouseY <= 748) {

				System.out.println("Help Menu");

			} // -- Go to Achievement Menu
			else if (mouseX >= 412 && mouseX <= 802 && mouseY >= 452 && mouseY <= 578) {

				System.out.println("Achievement Menu");

			} // -- Go to Play Menu
			else if (mouseX >= 388 && mouseX <= 817 && mouseY >= 275 && mouseY <= 390) {

				System.out.println("Play Menu");

			} // -- Logout
			else if (mouseX >= 42 && mouseX <= 211 && mouseY >= 50 && mouseY <= 128) {

				gameMenu.dispose();
				mainMenu = new MainMenu();
				mainMenu.addMouseListener(this);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	// Methods to check security and authentication register

	private boolean containsDigit(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	private boolean containsUpperCase(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	private boolean containsLowerCase(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isLowerCase(c)) {
				return true;
			}
		}
		return false;
	}
}
