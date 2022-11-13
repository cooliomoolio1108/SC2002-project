package uI;
import java.util.ArrayList;
import java.util.Scanner;

import manager.MovieMgr;
import model.Movie;
import model.MovieStates;
import utils.*;

/**
 * Allows access to functions for customers to view and book movies.
 * Can be accessed with username and password.
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public class MovieApp {
	
	/**
	 * Runs the main interface of this movie app.
	 * Displays menu options for the users.
	 * (1) View all movie listing.
	 * (2) View top 5 movie listings by sales.
	 * (3) View top 5 movie listings by ratings.
	 * (4) Search for a specific movie.
	 * (5) Book tickets for a movie
	 * (6) Give ratings and comments for a particular movie.
	 * (0) Exit this section.
	 * Users are required to enter one of the following choices.
	 */

	public static void AppMain(Scanner sc) {
		do {
			int num =-1;
			System.out.print("\n========================================\n");
			System.out.print("             Movie Listing              \n");
			System.out.print("========================================\n");
			System.out.print("1) View full movie listing\n");
			System.out.print("2) View top 5 movies by sales\n");
			System.out.print("3) View top 5 movies by overall rating\n");
			System.out.print("4) Search movie\n");
			System.out.print("5) Book tickets\n");
			System.out.print("6) Add movie review/rating\n");
			System.out.print("0) Go back\n");
			System.out.print("\nEnter your choice: ");
			num = sc.nextInt();
			switch(num) {
				case 0:
					return;
				case 1:
					Printer.displayAllMovie(0);
					break;
				case 2:
					Printer.displayMovie(1, 5);
					break;
				case 3:
					Printer.displayMovie(2, 5);
					break;
				case 4:
					Printer.SearchMovie(sc, "", 1);
					break;
				case 5:
					BookTicket(sc);
					break;
				case 6:
					CommentRate(sc);
					break;
				default:
					break;
			}
		}while(true);
	}
	
	/**
	 * Allows users to leave a review or rating for a movie they have watched.
	 * Guests are required to log in first before leaving a rating.
	 * Users can give a optional review or rating.
	 * Reviews are added into the database.
	 */
	
	public static void CommentRate(Scanner sc) {
		if(AppState.getUserID() ==-1) {
			System.out.print("You must login first before you can rate a movie\n");
			return;
		}
		int movieID = Printer.SearchMovie(sc, "For Review", 1);
		if(movieID == -1) {
			return;
		}
		AppState.setMovieID(movieID);
		CommentRateApp.AppMain(sc);
		AppState.setMovieID(-1);
		return;
	}
	
	/**
	 * Allows users to book a ticket for a movie they want to watch.
	 * Guests are required to log in first before leaving a rating.
	 *Booking records are added into the database.
	 */
	
	
	public static void BookTicket(Scanner sc) {
		if(AppState.getUserID() ==-1) {
			System.out.print("You must login first before you can book tickets\n");
			return;
		}
		int movieID = Printer.SearchMovie(sc, "For Booking", 0);
		if(movieID == -1) {
			return;
		}
		AppState.setMovieID(movieID);
		BookingApp.AppMain(sc);
		AppState.setMovieID(-1);
		return;
	}

}
