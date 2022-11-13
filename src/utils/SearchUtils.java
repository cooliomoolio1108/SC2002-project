package utils;

import java.util.ArrayList;
import java.util.HashMap;

import database.Data;
import model.*;

/**
 * Helper functions to help with all types of searching in the application
 * @author Group 4 SS9 
 * @version 1.0
 * @since 2022-11-07
 */

public class SearchUtils {
	
	/**
	 * Search ciniplex by ID
	 * @param cineplexID
	 * @return 
	 */
	
	public static ArrayList<Integer> CinemaIDListByCineplexID(int cineplexID){
		HashMap<Integer, Cinema> cinemaList = Data.cinemaList;
		ArrayList<Integer> arr = new ArrayList<>();
		for (Cinema cinema : cinemaList.values()) {
			  if(cinema.getCineplexID() == cineplexID) {
				  arr.add(cinema.getCinemaID());
			  }
		}
		return arr;
	}
	
	/**
	 * Search ciniplex by name
	 * @param name
	 * @return
	 */
	
	public static Cineplex searchCineplexByName(String name) {
		HashMap<Integer, Cineplex> list = Data.cineplexList;
		for(Cineplex cineplex : list.values()) {
			if(cineplex.getName().equals(name)) {
				return cineplex;
			}
		}
		return null;
	}
	
	/**
	 * Search booking by ID
	 * @param id
	 * @param key
	 * @return
	 */
	//0 -- > by userID, 1 --> by movieID
	public static ArrayList<Integer> BookingIDListByID(int id,int key){
		HashMap<Integer, Booking> bookingList = Data.bookingList;
		ArrayList<Integer> arr = new ArrayList<>();
		for (Booking booking : bookingList.values()) {
			  switch(key) {
				case 0:
					if(booking.getUserID() == id) {
						arr.add(booking.getBookingID());
					}
					break;
				case 1:
					ShowStatus show = SearchUtils.searchShowStatus(booking.getShowStatusID());
					if(show == null) {
						continue;
					}
					if(show.getMovieID() == id) {
						arr.add(booking.getBookingID());
					}
					break;
			}
		}
		return arr;
	}
	
	/**
	 * Search review by ID
	 * @param id
	 * @param key
	 * @return
	 */
	//0 --> userID, 1-->movieID
	public static ArrayList<Integer> ReviewIDListByID(int id, int key){
		HashMap<Integer, MovieReview> reviewList = Data.movieReviewList;
		ArrayList<Integer> arr = new ArrayList<>();
		for (MovieReview review : reviewList.values()) {
			switch(key) {
				case 0:
					if(review.getUserID() == id) {
						arr.add(review.getReviewID());
					}
					break;
				case 1:
					if(review.getMovieID() == id) {
						arr.add(review.getReviewID());
					}
					break;
					
			}
		}
		return arr;
	}
	
	
	/**
	 * Get movieID by cinemaID
	 * @param id
	 * @param key
	 * @return
	 */
	//0 show by cinemaID, 1 --> movieID
	public static ArrayList<Integer> ShowStatusListByID(int id, int key){
		HashMap<Integer, ShowStatus> showStatusList = Data.showStatusList;
		ArrayList<Integer> arr = new ArrayList<>();
		for (ShowStatus buffer : showStatusList.values()) {
			switch(key) {
				case 0:
					if(buffer.getCinemaID() == id) {
						arr.add(buffer.getShowStatusID());
					}
					break;
				case 1:
					if(buffer.getMovieID() == id) {
						arr.add(buffer.getShowStatusID());
					}
					break;
					
			}
		}
		return arr;
	}
	
	/**
	 * Search by movie ranking
	 * @param id
	 * @return
	 */
	public static MovieRank searchMovieRank(int id) {
	 if (Data.movieRankList.containsKey(id)) {
		 MovieRank result = Data.movieRankList.get(id);
            return result;
        }
        return null;
	}
	
	/**
	 * Search movie ranking by movie ID
	 * @param movieid
	 * @return
	 */
	
	public static MovieRank searchMovieRankByMovieID(int movieid) {
		HashMap <Integer,MovieRank> list = Data.movieRankList;
		for(MovieRank buffer : list.values()) {
			if(buffer.getMovieID() == movieid) {
				return buffer;
			}
		}
		return null;
	}
	
	/**
	 * Search booking by ID
	 * @param id
	 * @return
	 */
	
	public static Booking searchBooking(int id) {
        if (Data.bookingList.containsKey(id)) {
        	Booking result = Data.bookingList.get(id);
            return result;
        }
        return null;
    }
	/**
	 * Search cinema by ID
	 * @param id
	 * @return
	 */
	public static Cinema searchCinema(int id) {
        if (Data.cinemaList.containsKey(id)) {
        	Cinema result = Data.cinemaList.get(id);
            return result;
        }
        return null;
    }
	
	/**
	 * Search ciniplex by ID
	 * @param cineplexID
	 * @return
	 */
	
	public static Cineplex searchCineplex(int cineplexID) {
        if (Data.cineplexList.containsKey(cineplexID)) {
        	Cineplex result = Data.cineplexList.get(cineplexID);
            return result;
        }
        return null;
    }
	
	/**
	 * Search ciniplex by name
	 * @param name
	 * @return
	 */
	public static Cineplex searchCineplex(String name) {
		 for(Cineplex cineplex: Data.cineplexList.values()) {
				if(name.equals(cineplex.getName())) {
					return cineplex;
				}
			}
			return null;
	 }
	 
	/**
	 * Search holidays by ID
	 * @param holidayId
	 * @return
	 */
	
	public static Holiday searchHoliday(int holidayId) {
			for(Integer id: Data.holidayList.keySet()) {
				if(id == holidayId) {
					return Data.holidayList.get(id);
				}
			}
			return null;
		}
	
	/**
	 * Search holiday with name and date
	 * @param name
	 * @param date
	 * @return
	 */
	public static Holiday searchHoliday(String name, DateUtils date) {
		for(Holiday holiday: Data.holidayList.values()) {
			if(name.equals(holiday.getHolidayName()) && DateUtils.equal(date, holiday.getHolidayDate())) {
				return holiday;
			}
		}
		return null;
	}
	
	/**
	 * Search movie by ID
	 * @param movieID
	 * @return
	 */
	
	public static Movie searchMovie(int movieID) {
        if (Data.movieList.containsKey(movieID)) {
        	Movie result = Data.movieList.get(movieID);
            return result;
        }
        return null;
    }
	 
	/**
	 * Search movie with name 
	 * @param name
	 * @return
	 */
	
	public static Movie searchMovie(String name) {
		 for(Movie movie: Data.movieList.values()) {
				if(name.equals(movie.getTitle())) {
					return movie;
				}
			}
			return null;
	 }
	 
	/**
	  * Search movie review by ID
	  * @param id
	  * @return
	  */
	
	public static MovieReview searchMovieReview(int id) {
	        if (Data.movieReviewList.containsKey(id)) {
	        	MovieReview result = Data.movieReviewList.get(id);
	            return result;
	        }
	        return null;
	    }
	
	/**
	  * Search review with userID and movieID
	  * @param userID
	  * @param movieID
	  * @return
	  */
	
	public static MovieReview searchMovieReview(int userID, int movieID) {
		HashMap<Integer,MovieReview> list = Data.movieReviewList;
		for(MovieReview review: list.values()) {
			if(review.getUserID() == userID && review.getMovieID() == movieID) {
				return review;
			}
		}
		return null;
    }
	
	/**
	 * Get show status by ID
	 * @param id
	 * @return
	 */
	
	public static ShowStatus searchShowStatus(int id) {
			if (Data.showStatusList.containsKey(id)) {
				ShowStatus result = Data.showStatusList.get(id);
	            return result;
	        }
	        return null;
		}
	 /**
	  * Search for user with userID
	  * @param userID
	  * @return
	  */
	
	public static UserAccount searchUserAccount(int userID) {
		 if (Data.userAccountList.containsKey(userID)) {
	        	UserAccount user = Data.userAccountList.get(userID);
	            return user;
	        }
	        return null;
	}
	
	/**
	 * Search for user with username
	 * @param username
	 * @return
	 */
	
	public static UserAccount searchUserAccount(String username) {
		System.out.println("Size: "+Data.userAccountList.size());
		 for(UserAccount user: Data.userAccountList.values()) {
				if(username.equals(user.getUsername())) {
					return user;
				}
			}
			return null;
	}
}
