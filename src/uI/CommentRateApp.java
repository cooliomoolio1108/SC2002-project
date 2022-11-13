package uI;
import java.util.Scanner;

import manager.MovieMgr;
import manager.ReviewMgr;
import model.Movie;

/**
 * The driver app for the rating system of the MOBLIMA app. 
 * Contains the main functions for users to comment or update their comments on the movie.
 * Contains the main functions for users to give a rating for the movie they have watched.
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

/**
 * User can input comments on movies and give a rating for a movie listing provided they are logged in.
 * Users that have already made an existing rating or comment will be prompted to update instead.
 * Once review/rating is successful, it will be added in the database.
 */

public class CommentRateApp {
	private static void AddComments(Scanner sc) {
		String str;
		System.out.print("Your review: ");
		sc.nextLine();
		str = sc.nextLine();
		int rating;
		do {
			System.out.print("Your rating from 1-5:  ");
			rating = sc.nextInt();
			if(rating>5 || rating <1) {
				System.out.println("Please rate from 1-5 only");
			}
			else {
				break;
			}
		}while(true);
		boolean a = ReviewMgr.createMovieReview(AppState.getUserID(), AppState.getMovieID(),rating, str);
		if(!a) {
			System.out.println("It seems that u have rated this movie before. Do u wish to update your rating instead?\n");
			return;
		}
		System.out.println("Review successfully created.");
	}
	
	/**
	 * For existing reviews/ratings of particular user already in the database.
	 * Users will be required to update their comments/ratings if they want to update.
	 * If update is successful, update the database and inform the user.
	 */
	
	private static void UpdateComment(Scanner sc) {
		String str;
		System.out.print("Your review: ");
		sc.nextLine();
		str = sc.nextLine();
		ReviewMgr.updateReviewComment(AppState.getUserID(), AppState.getMovieID(), str);
		int rating;
		do {
			System.out.print("Your rating from 1-5:  ");
			rating = sc.nextInt();
			if(rating>5 || rating <1) {
				System.out.println("Please rate from 1-5 only.");
			}
			else {
				break;
			}
		}while(rating>=1 && rating <=5);
		ReviewMgr.updateReviewRating(AppState.getUserID(), AppState.getMovieID(), rating);
		System.out.println("Review successfully updated");

	}
	
	
	
	public static void AppMain(Scanner sc) {
		
		do {
			int choice =-1;
			System.out.print("\n========================================\n");
			System.out.print("           Reviews And Rating s            \n");
			System.out.print("========================================\n");
			Movie movie = MovieMgr.getMovieByID(AppState.getMovieID());
			System.out.println("Movie Title: "+movie.getTitle()+"\n");
			System.out.print("1) Add review and rating\n");
			System.out.print("2) Update review and rating\n");
			System.out.println("0) Back to movie listing\n");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 0:
					return;
				case 1:
					AddComments(sc);
					break;
				case 2:
					UpdateComment(sc);
					break;
				default:
					break;
					
			}
		}while(true);
	}
}
