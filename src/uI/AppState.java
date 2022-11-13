package uI;

/**
 * App state functions to get and set userID, and also to get and set movieID
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public class AppState {
	private static int userID =-1;
	private static int movieID = -1;
	
	public static void setUserID(int id) {
		userID =id;
	}
	public static int getUserID() {
		return userID;
	}
	
	public static void setMovieID(int id) {
		movieID =id;
	}
	public static int getMovieID() {
		return movieID;
	}
}
