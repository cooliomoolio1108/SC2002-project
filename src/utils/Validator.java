package utils;

import java.util.ArrayList;
import java.util.HashMap;
import database.Data;
import model.*;

/**
 * Helper functions to check database.
 * @author Group 4 SS9 
 * @version 1.0
 * @since 2022-11-07
 */

public class Validator {
	
	/**
	 * Check whether there is at least 1 movie in database
	 * @param userID
	 * @param movieID
	 * @return
	 */
	// 1 if review exist in the movie
	public static boolean validateReview(int userID, int movieID) {
		ArrayList<Integer> reviewIDs = SearchUtils.ReviewIDListByID(userID, 0);
		HashMap<Integer, MovieReview> reviewList = Data.movieReviewList;
		for(int i=0;i<reviewIDs.size();i++) {
			MovieReview buffer = reviewList.get(reviewIDs.get(i));
			if(buffer.getMovieID() == movieID) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Check if there is at least 1 booking in the database.
	 * @param id
	 * @return
	 */
	// 1 if exist
	public static boolean validateBooking(int id) {
		Booking buffer = SearchUtils.searchBooking(id);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there is at least 1 movie in the rankings
	 * @param Movieid
	 * @return
	 */
	// 1 if exist
	public static boolean validateMovieRank(int Movieid) {
		MovieRank buffer = SearchUtils.searchMovieRankByMovieID(Movieid);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there is at least 1 review in the database
	 * @param reviewID
	 * @return
	 */
	//1 if exist
	public static boolean validateMovieReview(int reviewID) {
		MovieReview buffer = SearchUtils.searchMovieReview(reviewID);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there are movies in the database by ID
	 * @param movieID
	 * @return
	 */
	//1 if exist
	public static boolean validateMovie(int movieID) {
		Movie buffer = SearchUtils.searchMovie(movieID);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there are movies in the database by name
	 * @param movieName
	 * @return
	 */
	public static boolean validateMovie(String movieName) {
		Movie buffer = SearchUtils.searchMovie(movieName);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there are holidays in the database by ID
	 * @param holidayID
	 * @return
	 */
	public static boolean validateHoliday(int holidayID) {
		Holiday buffer = SearchUtils.searchHoliday(holidayID);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there are holidays in the database with name and date
	 * @param name
	 * @param date
	 * @return
	 */
	public static boolean validateHoliday(String name, DateUtils date) {
		Holiday buffer = SearchUtils.searchHoliday(name,date);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there are cinemas in the database with ID
	 * @param cineplexID
	 * @param cinemaID
	 * @return
	 */
	public static boolean validateCinema(int cineplexID,int cinemaID) {
		Cinema buffer = SearchUtils.searchCinema(cinemaID);
		if(buffer == null) {
			return false;
		}
		if(buffer.getCineplexID() != cineplexID) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there are ciniplex in the database with ID
	 * @param cineplexID
	 * @return
	 */
	public static boolean validateCineplex(int cineplexID) {
		Cineplex buffer = SearchUtils.searchCineplex(cineplexID);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check if there are ciniplex in the database with name
	 * @param cineplexName
	 * @return
	 */
	public static boolean validateCineplex(String cineplexName) {
		Cineplex buffer = SearchUtils.searchCineplex(cineplexName);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	/**
	 * Check whether there are users in the database with username
	 * @param username
	 * @return
	 */
	public static boolean validateUser(String username) {
		UserAccount buffer = SearchUtils.searchUserAccount(username);
		if(buffer==null) {
			return false;
		}
		return true;
	}
	/**
	 * Check whether there are users in the database with ID
	 * @param userID
	 * @return
	 */
	public static boolean validateUser(int userID) {
		UserAccount buffer = SearchUtils.searchUserAccount(userID);
		if(buffer==null) {
			return false;
		}
		return true;
	}
	/**
	 * Check whether there are showstatus using ID
	 * @param showStatusID
	 * @return
	 */
	public static boolean validateShowStatus(int showStatusID) {
		ShowStatus buffer = SearchUtils.searchShowStatus(showStatusID);
		if(buffer == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateCinema(int cineplexID, String cinemaCode) {
		HashMap<Integer,Cinema> list = Data.cinemaList;
		for(Cinema buffer: list.values()) {
			if(buffer.getCineplexID() == cineplexID) {
				String name = buffer.getCinemaCode();
				if(name.equals(cinemaCode)) {
					return true;
				}
			}
		}
		return false;
	}
}
