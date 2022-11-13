package model;

import java.io.Serializable;

public class MovieReview implements Serializable{
	
	/**
	 * Java Serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Id number of review
	 */
	private int reviewID;
	/**
	 * ID number of user
	 */
	private int userID;
	/**
	 * Id number of movie
	 */
	private int movieID;
	/**
	 * Id number of rating
	 */
	private int rating;
	/**
	 * Comments in rating
	 */
	private String comment;
	
	/**
	 * Constructor
	 * @param reviewID
	 * @param userID
	 * @param movieID
	 * @param rating
	 * @param comment
	 */
	public MovieReview(int reviewID, int userID, int movieID, int rating, String comment) {
		this.reviewID = reviewID;
		this.userID = userID;
		this.movieID = movieID;
		this.rating = rating;
		this.comment = comment;
	}
	
	/**
	 * Constructor
	 * @param reviewID
	 * @param userID
	 * @param movieID
	 * @param comment
	 */
	public MovieReview(int reviewID, int userID, int movieID,String comment) {
		this.reviewID = reviewID;
		this.userID = userID;
		this.movieID = movieID;
		this.rating = 0;
		this.comment = comment;
	}
	
	/**
	 * Constructor
	 * @param reviewID
	 * @param userID
	 * @param movieID
	 * @param rating
	 */
	public MovieReview(int reviewID, int userID, int movieID, int rating) {
		this.reviewID = reviewID;
		this.userID = userID;
		this.movieID = movieID;
		this.rating = rating;
		this.comment = null;
	}
	
	/**
	 * Get and return a copy of movie review
	 * @param another
	 * @return
	 */
	public static MovieReview copy(MovieReview another) {
		MovieReview review = new MovieReview(
				another.getReviewID(),
				another.getUserID(),
				another.getMovieID(),
				another.getRating(),
				another.getComment()
		);
		return review;
	}
	
	/**
	 * Setter Id number of this review
	 * @param id
	 */
	public void setReviewID(int id) {
		this.reviewID = id;
	}
	
	/**
	 * Getter Id number of this review
	 * @return this.reviewID
	 */
	public int getReviewID() {
		return this.reviewID;
	}
	/**
	 * Getter Rating of this review
	 * @return this.rating
	 */
	public int getRating() {
		return this.rating;
	}
	
	/**
	 * Setter rating of this review
	 * @param rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	/**
	 * Getter comment of this review
	 * @return this.comment
	 */
	public String getComment() {
		return this.comment;
	}
	/**
	 * Setter comment of this review
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 *Getter User ID of this review
	 * @return this.userID
	 */
	public int getUserID() {
		return this.userID;
	}
	
	/**
	 * Setter User ID of this review
	 * @param id
	 */
	public void setUserID(int id) {
		this.userID =id;
	}
	
	/**
	 * Getter  movie id number of this review
	 * @return this.movieID
	 */
	public int getMovieID() {
		return this.movieID;
	}
	
	/**
	 * Setter movie id number of this review
	 * @param id
	 */
	public void setMovieID(int id) {
		this.movieID =id;
	}
}
