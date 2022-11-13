package uI;

import java.util.Scanner;

/**
 * The main interface for cinema staff after staff login. 
 * Allows access to functions for cinema staff.
 * Accessed via a admin username and password.
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public class CinemaStaffLogin {
	
	public static void AppMain(Scanner sc) {
		boolean a = Login(sc);
		if(!a) {
			return;
		}
		else {
			StaffConfiguration(sc);
			return;
		}
	}
	
	/**
	 * Displays menu options for cinema staff.
	 * (1) Update a movie in the database.
	 * (2) Update a showtime in the database.
	 * (3) Admin controls for cinema staff such as changes in price, holiday dates, etc.
	 * (0) Log out of the staff app.
	 * Requires staff to input a choice.
	 */
	
	public static void StaffConfiguration(Scanner sc) {
		while(true) {
			int num =-1;
			System.out.print("\n========================================\n");
			System.out.print("             Staff Main Menu              \n");
			System.out.print("========================================\n");
			System.out.print("1) Edit movie listing\n");
			System.out.print("2) Edit showtime list \n");
			System.out.print("3) Edit system setting\n");
			System.out.println("0) Logout\n");
			System.out.print("Enter Your Choice: ");
			num = sc.nextInt();
			switch(num) {
			case 0:
				return;
				case 1: 
					MovieConfig.AppMain(sc);
					break;
				case 2:
					ShowTimeConfig.AppMain(sc);
					break;
				case 3:
					SystemConfig.AppMain(sc);
					break;
				default:
					break;
			}
		}
	}
	
	/**
	 * Login credentials for staff
	 * When a user inputs the wrong login info, there will be unsuccessful login
	 */
	
	public static boolean ValidateLogin(String text1, String text2) {
		String username = "Test2";
		String password = "1234";
		if(!text1.equals(username) || !text2.equals(password)) {
			System.out.print("Wrong Credentials\n");
			return false;
		}
		return true;
	}
	
	/**
	 * Requests for username and password for staff login
	 * Checks for username and password validation
	 */
	
	public static boolean Login(Scanner sc) {
		String str1,str2;
		System.out.print("\nEnter Username: ");
		sc.nextLine();
		str1 = sc.nextLine();
		System.out.print("Enter Password: ");
		str2= sc.nextLine();
		
		if(ValidateLogin(str1,str2)) {
			return true;
		}
		return false;
	}
	
}
