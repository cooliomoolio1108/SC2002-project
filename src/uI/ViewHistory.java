package uI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import database.Data;
import manager.BookingMgr;
import manager.CinemaMgr;
import manager.CineplexMgr;
import manager.MovieMgr;
import manager.ReviewMgr;
import manager.ShowStatusMgr;
import manager.UserAccountMgr;
import model.*;
import utils.DateUtils;
import utils.SearchUtils;
import utils.TimeUtils;

/**
 * App to view booking/review history. 
 * Allows users of the app to check whether bookings and reviews provided that they are logged in
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public class ViewHistory {
	
	public static void AppMain(Scanner sc) {
		int a;
		do {
			System.out.print("\n========================================\n");
			System.out.print("              View History              \n");
			System.out.print("========================================\n");
			System.out.print("1) View Booking history\n");
			System.out.print("2) View Review history\n");
			System.out.print("0) Go back\n");
			System.out.print("\nEnter your choice: ");
			a = sc.nextInt();
			switch(a) {
				case 1:
					displayBookingHistory();
					break;
				case 2:
					displayReviewHistory();
					break;
				case 0:
					return;
				default:
					break;
			}
			
		}while(true);
	}
	
	/**
	 * Display the user's past review history, including ratings and comments
	 */
	
	public static void displayReviewHistory() {
		System.out.print("\n========================================\n");
		System.out.print("            Your Past Review              \n");
		System.out.print("========================================\n");
		ArrayList<MovieReview> reviewList = ReviewMgr.getReveiwListByUserID(AppState.getUserID());
		System.out.println();
		if(reviewList.size() == 0) {
			System.out.println("No reviews recorded.");
			return;
		}
		for(int i=0;i<reviewList.size();i++) {
			MovieReview buffer = reviewList.get(i);
			Movie movie = MovieMgr.getMovieByID(buffer.getMovieID());
			System.out.println(i+1+")");
			System.out.println("Movie Title: "+movie.getTitle());
			if(buffer.getRating() == 0) {
				System.out.println("Rating: NA");
			}
			else {
				System.out.println("Rating: "+buffer.getRating());
			}
			System.out.println("Review: "+buffer.getComment());
			System.out.println();
		}
	}
	
	/**
	 * Display the user's past booking history, provided that they are logged in
	 */
	
	public static void displayBookingHistory() {
		ArrayList<Booking> bookingList = BookingMgr.getBookingListByUserID(AppState.getUserID());
		System.out.println();
		if(bookingList.size() == 0) {
			System.out.println("No Booking Record.");
			return;
		}
		for(int i=0;i<bookingList.size();i++) {
			Booking buffer = bookingList.get(i);
			ShowStatus show = ShowStatusMgr.getShowStatusByID(buffer.getShowStatusID());
			Movie movie = MovieMgr.getMovieByID(show.getMovieID());
			Cinema cinema = CinemaMgr.getCinemaByID(show.getCinemaID());
			Cineplex cineplex =  CineplexMgr.getCineplexByID(show.getCineplexID());
			UserAccount user = UserAccountMgr.getUserAccount(AppState.getUserID());
			
			System.out.println((i+1)+")");
			System.out.println("Movie Title: "+movie.getTitle());
			System.out.println("Movie Type: "+show.getMovieType());
			System.out.println("Cinema Code: "+cinema.getCinemaCode());
			System.out.println("Cinema Class: "+cinema.getCinemaType());
			System.out.println("Cineplex Name: "+cineplex.getName());
			
			System.out.print("Booking Date: ");
			DateUtils.print(buffer.getBookingDate());
			
			System.out.print("\nBooking Time: ");
			TimeUtils.print(buffer.getBookingTime());
			
			System.out.print("\nShow Date: ");
			DateUtils.print(show.getShowDate());
			
			System.out.print("\nShow Time: ");
			TimeUtils.print(show.getShowTime());
			
			System.out.println("\nTicket Price: "+buffer.getPrice()+" SGD");
			
			System.out.println("TID: "+buffer.getTID());
			System.out.println("Name: "+user.getUsername());
			System.out.println("Mobile Number: "+user.getMobileNumber());
			System.out.println("Email: "+user.getEmail());
			System.out.println();
		}
	}
}
