package main;

import controllers.MainController;
import models.UserDatabaseManager;
import views.MainMenu;

public class QuizMasters {

	public static void main(String[] args) {
		UserDatabaseManager createUser = new UserDatabaseManager();
		MainMenu mainMenu = new MainMenu();
		new MainController(createUser, mainMenu);
	}
}
