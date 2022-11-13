package manager;

import java.util.ArrayList;
import java.util.HashMap;
import database.Data;
import database.FileType;
import model.Movie;
import model.MovieStates;
import model.ShowStatus;
import utils.Helper;
import utils.SearchUtils;
import utils.Validator;
/**
 * Movie Manager Class to manage movie processes
 * @author Group SS4
 * @version 1.0
 * @since 2022-11-07
 */
public class MovieMgr {
	/**
	 * Hash map of existing movies
	 */
	private static HashMap<Integer,Movie> movieList =  Data.movieList;
	
	/**
	 * Method to creating movie and id entry with given parameters
	 * @param title
	 * @param director
	 * @param casts
	 * @param movieContent
	 * @param duration
	 * @param state
	 * @param numRaters
	 * @param overallRating
	 * @param sales
	 * @return movieID
	 */
	public static int createMovie(String title, String director, 
			ArrayList<String> casts, String movieContent, double duration, MovieStates state, 
			int numRaters, double overallRating, double sales) {
		
		if(Validator.validateMovie(title)  == true) {
			return -1;
		}
		int movieID = Helper.getUniqueId(movieList);
		Movie buffer = new Movie(movieID,title,director,casts,movieContent,duration,state);
		movieList.put(movieID, buffer);
		MovieRankMgr.createMovieRank(movieID, numRaters, overallRating, sales);
		Data.saveFile(FileType.MOVIE);
		return movieID;
		
	}
	
	/**
	 * Method to create movie and id entry with given parameters
	 * @param title
	 * @param director
	 * @param casts
	 * @param movieContent
	 * @param duration
	 * @param state
	 * @return movieID
	 */
	public static int createMovie(String title, String director, 
			ArrayList<String> casts, String movieContent, double duration, MovieStates state) {
		
		if(Validator.validateMovie(title) == true) {
			return -1;
		}
		int movieID = Helper.getUniqueId(movieList);
		Movie buffer = new Movie(movieID,title,director,casts,movieContent,duration,state);
		movieList.put(movieID, buffer);
		MovieRankMgr.createMovieRank(movieID);
		
		Data.saveFile(FileType.MOVIE);
		return movieID;
		
	}
	/**
	 * Method to remove existing movie with given movieID
	 * Returns true if successful, false if unsuccessful
	 * @param movieID
	 * @return boolean
	 */
	public static boolean removeMovie(int movieID) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		Movie movie = SearchUtils.searchMovie(movieID);
		movie.setMovieState(MovieStates.NO_LONGER_SHOWING);
		ArrayList<ShowStatus> list = ShowStatusMgr.getAllStatusListByMovieID(movieID);
		for(int i=0;i<list.size();i++) {
			ShowStatusMgr.removeShowStatus(list.get(i).getShowStatusID());
		}
		Data.saveFile(FileType.MOVIE);
		return true;
	}
	
	/**
	 * Method to update contents of existing movie with given movieID
	 * Updates content with given text input
	 * Returns true if successful, false if unsuccessful
	 * @param movieID
	 * @param text
	 * @return boolean
	 */
	public static boolean updateMovieContent(int movieID, String text) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		Movie updateMovie = SearchUtils.searchMovie(movieID);
		updateMovie.setMovieContent(text);
		movieList.put(movieID, updateMovie);
		Data.saveFile(FileType.MOVIE);
		return true;
	}
	
	/**
	 * Method to update existing movie director with given movieID
	 * Returns true if successful, false if unsuccessful
	 * @param movieID
	 * @param text
	 * @return boolean
	 */
	public static boolean updateMovieDirector(int movieID, String text) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		Movie updateMovie = SearchUtils.searchMovie(movieID);
		updateMovie.setDirector(text);
		movieList.put(movieID, updateMovie);
		Data.saveFile(FileType.MOVIE);
		return true;
	}
	
	/**
	 * Method to update existing movie title with given movieID
	 * Returns true if successful, false if unsuccessful
	 * @param movieID
	 * @param title
	 * @return boolean
	 */
	public static boolean updateMovieTitle(int movieID, String title) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		if(Validator.validateMovie(title) == true) {
			return false;
		}
		Movie updateMovie = SearchUtils.searchMovie(movieID);
		updateMovie.setTitle(title);
		movieList.put(movieID, updateMovie);
		Data.saveFile(FileType.MOVIE);
		return true;
	}
	
	/**
	 * Method to update state of existing movie with given movieID
	 * Returns true if successful, false if unsuccessful
	 * @param movieID
	 * @param state
	 * @return boolean
	 */
	public static boolean updateMovieState(int movieID,MovieStates state) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		if(state == MovieStates.NO_LONGER_SHOWING) {
			return removeMovie(movieID);
		}
		Movie updateMovie = SearchUtils.searchMovie(movieID);
		updateMovie.setMovieState(state);
		movieList.put(movieID, updateMovie);
		Data.saveFile(FileType.MOVIE);
		return true;
		
	}
	
	/**
	 * Method to add existing movie casts with given movieID
	 * Returns true if successful, false if unsuccessful
	 * @param movieID
	 * @param cast
	 * @return boolean
	 */
	public static boolean addCasts(int movieID, String cast) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		Movie updateMovie = SearchUtils.searchMovie(movieID);
		ArrayList<String> casts = updateMovie.getCasts();
		for(int i=0;i<casts.size();i++) {
			if(casts.get(i).equals(cast)) {
				return false;
			}
		}
		casts.add(cast);
		movieList.put(movieID, updateMovie);
		Data.saveFile(FileType.MOVIE);
		return true;
	}
	
	/**
	 * Method to remove existing movie cast with given movieID
	 * Returns true if successful, false if unsuccessful
	 * @param movieID
	 * @param cast
	 * @return
	 */
	public static boolean removeCasts(int movieID, String cast) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		Movie updateMovie = SearchUtils.searchMovie(movieID);
		ArrayList<String> casts = updateMovie.getCasts();
		int index= -1;
		for(int i=0;i<casts.size();i++) {
			if(casts.get(i).equals(cast)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			return false;
		}
		casts.remove(index);
		movieList.put(movieID, updateMovie);
		Data.saveFile(FileType.MOVIE);
		return true;
	}
	/**
	 * Method to update existing movie duration with given movieID
	 * Returns true if successful, false if unsuccessful
	 * @param movieID
	 * @param duration
	 * @return
	 */
	public static boolean updateMovieDuration(int movieID, double duration) {
		if(Validator.validateMovie(movieID) == false) {
			return false;
		}
		Movie updateMovie = SearchUtils.searchMovie(movieID);
		updateMovie.setDuration(duration);
		movieList.put(movieID, updateMovie);
		Data.saveFile(FileType.MOVIE);
		return true;
	}
	
	/**
	 * Method to get and return existing movie with given movie ID
	 * @param movieID
	 * @return Movie
	 */
	public static Movie getMovieByID(int movieID) {
		if(Validator.validateMovie(movieID) == false) {
			return null;
		}
		Movie updateMovie = SearchUtils.searchMovie(movieID);
		return Movie.copy(updateMovie);
	}
	
	/**
	 * Method to get and return existing movie with given name
	 * @param name
	 * @return
	 */
	public static Movie getMovieByName(String name) {
		Movie updateMovie = SearchUtils.searchMovie(name);
		if(updateMovie == null) {
			return null;
		}
		return Movie.copy(updateMovie);
	}
	
	/**
	 * Method to get and return full list of existing movies
	 * @return list
	 */
	public static ArrayList<Movie> getAllMovieList() {
		ArrayList<Movie> list = new ArrayList<Movie>();
		for(Movie movie: movieList.values()) {
			Movie buffer = Movie.copy(movie);
			list.add(buffer);
		}
		return list;
	}
	
	/**
	 * Method to return casts of existing movies with given movieID
	 * @param movieID
	 * @return list
	 */
	public static ArrayList<String> getCastsByMovieID(int movieID){
		if(Validator.validateMovie(movieID) == false) {
			return null;
		}
		Movie movie = SearchUtils.searchMovie(movieID);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> casts = movie.getCasts();
		for(int i=0;i<casts.size();i++) {
			list.add(casts.get(i));
		}
		return list;
	}
}
