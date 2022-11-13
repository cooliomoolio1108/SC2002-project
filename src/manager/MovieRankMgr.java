package manager;

import java.util.HashMap;
import java.util.ArrayList;

import database.Data;
import database.FileType;
import model.MovieRank;
import model.MovieReview;
import model.UserAccount;
import utils.Helper;
import utils.SearchUtils;
import utils.Validator;

/**
 * Movie ranking Manager Class to manage movie ranking processes
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 *
 */
public class MovieRankMgr {
	/**
	 * Hash map of all movie rank with movierankID
	 */
	private static HashMap<Integer, MovieRank> movieRankList = Data.movieRankList;
	
	/**
	 * Method to return full list of existing movie rankings
	 * @return list
	 */
	public static ArrayList<MovieRank> getAllMovieRankList(){
		ArrayList<MovieRank> list = new ArrayList<>();
		for(MovieRank rank : movieRankList.values()) {
			list.add(MovieRank.copy(rank));
		}
		return list;
	}
	
	/**
	 * Method to get and return movie rank of existing movies by given movieID
	 * @param movieID
	 * @return MovieRank
	 */
	public static MovieRank getMovieRankByMovieID(int movieID){
		for(MovieRank rank : movieRankList.values()) {
			if(rank.getMovieID() == movieID) {
				return MovieRank.copy(rank);
			}
		}
		return null;
	}
	
	/**
	 * Method to create Movie Ranking for existing movies
	 * puts them into hash map of movieRankList
	 * @param movieID
	 * @param numRaters
	 * @param overallRating
	 * @param sales
	 * @return boolean
	 */
	public static boolean createMovieRank(int movieID, int numRaters, double overallRating, double sales) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		int movieRankID = Helper.getUniqueId(movieRankList);
		MovieRank newMovieRank = new MovieRank(movieRankID, movieID, numRaters, overallRating, sales);
		movieRankList.put(movieRankID, newMovieRank);
		Data.saveFile(FileType.MOVIE_RANK);
		return true;
	}
	
	/**
	 * Method to create Movie Ranking for existing movies
	 * Puts them into hash map of movieRankList
	 * @param movieID
	 * @param numRaters
	 * @param overallRating
	 * @return boolean
	 */
	public static boolean createMovieRank(int movieID, int numRaters, double overallRating) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		int movieRankID = Helper.getUniqueId(movieRankList);
		MovieRank newMovieRank = new MovieRank(movieRankID, movieID, numRaters, overallRating);
		movieRankList.put(movieRankID, newMovieRank);
		Data.saveFile(FileType.MOVIE_RANK);
		return true;
	}
	
	/**
	 * Method to create Movie Ranking for existing movies
	 * @param movieID
	 * @return
	 */
	public static boolean createMovieRank(int movieID) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		int movieRankID = Helper.getUniqueId(movieRankList);
		MovieRank newMovieRank = new MovieRank(movieRankID, movieID);
		movieRankList.put(movieRankID, newMovieRank);
		Data.saveFile(FileType.MOVIE_RANK);
		return true;
	}
	
	/**
	 * Method to add sales into movieRankList
	 * @param movieID
	 * @param price
	 * @return boolean
	 */

	public static boolean addSales(int movieID, double price) {
		if(Validator.validateMovie(movieID)== false) {
			return false;
		}
		MovieRank buffer2 = SearchUtils.searchMovieRankByMovieID(movieID);
		double preSales = buffer2.getSales();
		buffer2.setSales(preSales+price);
		movieRankList.put(buffer2.getMovieRankID(), buffer2);
		Data.saveFile(FileType.MOVIE_RANK);
		return true;
	}
	
	/**
	 * Method to add movie ratings for existing movies
	 * @param movieID
	 * @param userID
	 * @param rating
	 * @return boolean
	 */
	public static boolean addRating(int movieID,int userID,int rating) {
		if(Validator.validateMovie(movieID)== false || Validator.validateUser(userID) == false) {
			return false;
		}
		MovieRank buffer = SearchUtils.searchMovieRankByMovieID(movieID);
		double overall = buffer.getOverallRating();
		overall = (overall*buffer.getNumRaters() + rating) / (buffer.getNumRaters() +1);
		buffer.setOverallRating(overall);
		buffer.setNumRaters(buffer.getNumRaters()+1);
		movieRankList.put(buffer.getMovieRankID(), buffer);
		Data.saveFile(FileType.MOVIE_RANK);
		return true;
	}
	/**
	 * Method to update ratings for existing movies
	 * @param movieID
	 * @param userID
	 * @param rating
	 * @return boolean
	 */
	public static boolean changeRating(int movieID,int userID,int rating) {
		if(Validator.validateMovie(movieID)== false ||Validator.validateUser(userID) == false ) {
			return false;
		}
		if(Validator.validateReview(userID, movieID) == false) {
			return false;
		}
		MovieRank buffer = SearchUtils.searchMovieRankByMovieID(movieID);
		MovieReview review = SearchUtils.searchMovieReview(userID, movieID);
		double overall = buffer.getOverallRating();
		overall = overall*buffer.getNumRaters() - review.getRating() + rating;
		overall = overall/buffer.getNumRaters();
		buffer.setOverallRating(overall);
		movieRankList.put(buffer.getMovieRankID(), buffer);
		Data.saveFile(FileType.MOVIE_RANK);
		return true;
	}
}
