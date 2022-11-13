package uI;

import java.util.Scanner;

import database.Data;
import database.DataInitializer;

/**
 * The main function for the entire application. 
 * Contains the preliminary overview of the entire flow of the application.
 * Determines access privileges of user.
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public class MolimbaApp {

	/**
	 * Intializing the main function.
	 * @param args No arguments were passed.
	 */
	
	public static void displayWelcome() {
		System.out.print("===================================================\n");
		System.out.print("              WELCOME TO MOLIMBA              \n");
		System.out.print("===================================================\n\n");
	}
	
	/**
	 * The main interface for this app at startup.
	 * Displays menu for app.
	 * (1) Allows users to log into their account. 
	 * (1) Allows new users to make a customer account.
	 * (2) Allows the cinema staff to login their account for special functions.
	 * (3) Allows guests that have not created account to view movies available.
	 * (0) Exits Main Menu and terminates the application.
	 */
	
	public static int PromptUserInput(Scanner sc) {
		int num =-1;
		System.out.print("\n========================================\n");
		System.out.print("                Main Menu               \n");
		System.out.print("========================================\n");
		System.out.print("1) User Login/sign up\n");
		System.out.print("2) Staff login\n");
		System.out.print("3) View movies\n");
		System.out.print("0) Exit\n");
		System.out.print("\nEnter your choice: ");
		num = sc.nextInt();
		return num;
	}
	
	/**
	 * Runs the main user interface for user app.
	 * Displays user functions available.
	 * (1) Allows users to log out of their account.
	 * (2) Allows user to view the movies that are available currently.
	 * (3) Allows users to view their booking history.
	 * (4) Exits Main Menu and goes back to the previous menu.
	 * Users are required to input their choices.
	 */
	
	public static int PromptLoginUserInput(Scanner sc) {
		int num =-1;
		System.out.print("\n========================================\n");
		System.out.print("                Main Menu               \n");
		System.out.print("========================================\n");
		System.out.print("1) Logout\n");
		System.out.print("2) View movies\n");
		System.out.print("3) View history\n");
		System.out.print("0) Exit\n");
		System.out.print("\nEnter your choice: ");
		num = sc.nextInt();
		return num;
	}
	
	/**
	 * Main app logic for the main interface
	 */
	
	public static void AppMain(Scanner sc) {
		displayWelcome();
		int a;
		do {
			if(AppState.getUserID() == -1) {
				a = PromptUserInput(sc);
				switch(a) {
				case 0:
					Data.saveAllFiles();
					return;
				case 1:
					UserAccountApp.AppMain(sc);
					break;
				case 2:
					CinemaStaffLogin.AppMain(sc);
					break;
				case 3:
					MovieApp.AppMain(sc);
					break;
				default:
					break;
				}
			}
			
			else {
				a = PromptLoginUserInput(sc);
				switch(a) {
				case 0:
					Data.saveAllFiles();
					return;
				case 1:
					AppState.setUserID(-1);
					break;
				case 2:
					MovieApp.AppMain(sc);
					break;
				case 3:
					ViewHistory.AppMain(sc);
					break;
				default:
					break;
				}
			}
		}while(true);
	}
	
}
