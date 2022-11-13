package manager;

import java.util.ArrayList;
import java.util.HashMap;
import database.Data;
import database.FileType;
import model.MovieRank;
import model.MovieReview;
import utils.Helper;
import utils.SearchUtils;
import utils.Validator;
/**
 * Reviews Manager Class to manage review processes
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 *
 */
public class ReviewMgr {
	/**
	 * Hash map of movie reviews with corresponding review ids
	 */
	private static HashMap<Integer, MovieReview> movieReviewList = Data.movieReviewList;
	
	/**
	 * Method to get and return review list by given existing userID
	 * @param userID
	 * @return list
	 */
	public static ArrayList<MovieReview> getReveiwListByUserID(int userID){
		ArrayList<MovieReview> list = new ArrayList<MovieReview>();
		if(Validator.validateUser(userID)== false ) {
			return null;
		}
		for(MovieReview review : movieReviewList.values()) {
			if(review.getUserID() == userID) {
				list.add(MovieReview.copy(review));
			}
		}
		return list;
	}
	/**
	 * Method to get and return full review list of existing movie
	 * @param movieID
	 * @return list
	 */
	public static ArrayList<MovieReview> getReveiwListByMovieID(int movieID){
		ArrayList<MovieReview> list = new ArrayList<MovieReview>();
		if(Validator.validateMovie(movieID) == false) {
			return null;
		}
		for(MovieReview review : movieReviewList.values()) {
			if(review.getMovieID() == movieID) {
				list.add(MovieReview.copy(review));
			}
		}
		return list;
	}
	/**
	 * Method to create movie reviews for existing movies
	 * @param userID
	 * @param movieID
	 * @param rating
	 * @param comment
	 * @return boolean
	 */
	public static boolean createMovieReview(int userID, int movieID, int rating, String comment) {
		if(Validator.validateUser(userID)== false || Validator.validateMovie(movieID) == false) {
			return false;
		}
		if(Validator.validateReview(userID, movieID) == true) {
			return false;
		}
		int reviewID = Helper.getUniqueId(movieReviewList);
		MovieReview newReview = new MovieReview(reviewID,userID,movieID,rating,comment);
		movieReviewList.put(reviewID, newReview);
		MovieRankMgr.addRating(movieID, userID, rating);
		Data.saveFile(FileType.MOVIE_REVIEW);
		return true;
	}
	
	/**
	 * Method to create movie reviews for existing movie
	 * @param userID
	 * @param movieID
	 * @param comment
	 * @return
	 */
	public static boolean createMovieReview(int userID, int movieID,String comment) {
		if(Validator.validateUser(userID) == false || Validator.validateMovie(movieID) == false) {
			return false;
		}
		if(Validator.validateReview(userID, movieID) == true) {
			return false;
		}
		int reviewID = Helper.getUniqueId(movieReviewList);
		MovieReview newReview = new MovieReview(reviewID,userID,movieID,comment);
		movieReviewList.put(reviewID, newReview);
		Data.saveFile(FileType.MOVIE_REVIEW);
		return true;
	}
	
	/**
	 * Method to create movie reviews for existing movie
	 * @param userID
	 * @param movieID
	 * @param rating
	 * @return
	 */
	public static boolean createMovieReview(int userID, int movieID, int rating) {
		if(Validator.validateUser(userID) == false || Validator.validateMovie(movieID) == false) {
			return false;
		}
		if(Validator.validateReview(userID, movieID) == true) {
			return false;
		}
		int reviewID = Helper.getUniqueId(movieReviewList);
		MovieReview newReview = new MovieReview(reviewID,userID,movieID,rating);
		movieReviewList.put(reviewID, newReview);
		MovieRankMgr.addRating(movieID, userID, rating);
		Data.saveFile(FileType.MOVIE_REVIEW);
		return true;
	}
	
	/**
	 * Method to update review ratings for existing movies
	 * @param userID
	 * @param movieID
	 * @param num
	 * @return boolean 
	 */
	public static boolean updateReviewRating(int userID, int movieID, int num ) {
		if(Validator.validateUser(userID) == false || Validator.validateMovie(movieID) == false) {
			return false;
		}
		if(Validator.validateReview(userID, movieID) == false) {
			return false;
		}
		MovieReview buffer = SearchUtils.searchMovieReview(userID, movieID);
		MovieRankMgr.changeRating(movieID, userID, num);
		buffer.setRating(num);
		movieReviewList.put(buffer.getReviewID(), buffer);
		Data.saveFile(FileType.MOVIE_REVIEW);
		return true;
	}
	
	/**
	 * Method to update review comment of existing movie
	 * @param userID
	 * @param movieID
	 * @param comment
	 * @return boolean
	 */
	public static boolean updateReviewComment(int userID, int movieID, String comment) {
		if(Validator.validateUser(userID) == false || Validator.validateMovie(movieID) == false) {
			return false;
		}
		if(Validator.validateReview(userID, movieID) == false) {
			return false;
		}
		MovieReview buffer = SearchUtils.searchMovieReview(userID, movieID);
		buffer.setComment(comment);
		movieReviewList.put(buffer.getReviewID(), buffer);
		Data.saveFile(FileType.MOVIE_REVIEW);
		return true;
	}
	
	
	
}
