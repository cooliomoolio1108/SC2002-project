package database;

/**
 * List of file types
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */
public enum FileType {

	MOVIE("Movie"),
	USER("User"),
	HOLIDAY("Holiday"),
	CINEPLEX("Cineplex"),
	CINEMA("Cinema"),
	BOOKING("Booking"),
	SHOW_STATUS("ShowStatus"),
	MOVIE_REVIEW("MovieReview"),
	MOVIE_RANK("MovieRank"),
	TICKET_PRICE("TicketPrice"),;
	
	public final String fileName;
	
	private FileType(String string) {
		// TODO Auto-generated constructor stub
		this.fileName = string;
	}
	
}
