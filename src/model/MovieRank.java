package model;

import java.io.Serializable;

public class MovieRank implements Serializable{
	/**
	 * Java Serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Ranking ID of the movie
	 */
	private int movieRankID;
	/**
	 * Id number of the movie
	 */
	private int movieID;
	/**
	 * Number of raters
	 */
	private int numRaters;
	/**
	 * Overall Rating of the movie
	 */
	private double overallRating;
	/**
	 * Overall Sales of the movie
	 */
	private double sales;
	
	/**
	 * Constructor
	 * @param movieRankID
	 * @param movieID
	 * @param numRaters
	 * @param overallRating
	 * @param sales
	 */
	public MovieRank(int movieRankID, int movieID, int numRaters, double overallRating, double sales) {
		this.movieRankID = movieRankID;
		this.movieID = movieID;
		this.numRaters = numRaters;
		this.overallRating = overallRating;
		this.sales = sales;
	}
	
	/**
	 * Constructor
	 * @param movieRankID
	 * @param movieID
	 * @param numRaters
	 * @param overallRating
	 */
	public MovieRank(int movieRankID, int movieID, int numRaters, double overallRating) {
		this.movieRankID = movieRankID;
		this.movieID = movieID;
		this.numRaters = numRaters;
		this.overallRating = overallRating;
		this.sales = 0;
	}
	
	/**
	 * Constructor
	 * @param movieRankID
	 * @param movieID
	 * @param sales
	 */
	
	public MovieRank(int movieRankID, int movieID, double sales) {
		this.movieRankID = movieRankID;
		this.movieID = movieID;
		this.numRaters = 0;
		this.overallRating = 0;
		this.sales = sales;
	}
	
	/**
	 * Constructor
	 * @param movieRankID
	 * @param movieID
	 */
	public MovieRank(int movieRankID,int movieID) {
		this.movieRankID = movieRankID;
		this.movieID = movieID;
		this.numRaters = 0;
		this.overallRating = 0;
		this.sales = 0;
	}
	
	/**
	 * Get and return a copy of the movie rank
	 * @param another
	 * @return
	 */
	public static MovieRank copy(MovieRank another) {
		MovieRank rank = new MovieRank(
				another.movieRankID,
				another.getMovieID(),
				another.getNumRaters(),
				another.getOverallRating(),
				another.getSales()
		);
		return rank;
	}
	/**
	 * Getter Movie rank Id of this movie
	 * @return this.movieRankID
	 */
	public int getMovieRankID() {
		return this.movieRankID;
	}
	/**
	 * Setter MovieRank ID of this movie
	 * @param id
	 */
	public void setMovieRankID(int id) {
		this.movieRankID =id;
	}
	
	/**
	 * Getter Id number of this movie
	 * @return this.movieID
	 */
	public int getMovieID() {
		return this.movieID;
	}
	
	/**
	 * Setter ID number of this movie
	 * @param id
	 */
	public void setMovieID(int id) {
		this.movieID = id;
	}
	
	/**
	 * Getter NumRaters of this movie rank
	 * @return
	 */
	public int getNumRaters() {
		return this.numRaters;
	}
	
	/**
	 * Setter NumRaters of this movie rank
	 * @param num
	 */
	public void setNumRaters(int num) {
		this.numRaters = num;
	}
	
	/**
	 * Getter overall rating of this movie rank
	 * @return this.overallRating
	 */
	public double getOverallRating() {
		return this.overallRating;
	}
	
	/**
	 * Setter Overall Rating of this movie rank
	 * @param rating
	 */
	public void setOverallRating(double rating) {
		this.overallRating = rating;
	}
	
	/**
	 * Getter Sales of this movie
	 * @return this.sales
	 */
	public double getSales() {
		return this.sales;
	}
	/**
	 * Setter sales of this movie
	 * @param sales
	 */
	public void setSales(double sales) {
		this.sales = sales;
	}
}
