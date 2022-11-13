package model;
import java.io.Serializable;

import utils.*;


public class ShowStatus implements Serializable{
	/**
	 * Java Serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Id number of show status
	 */
	private int showStatusID;
	/**
	 * Id number of cineplex
	 */
	private int cineplexID;
	/**
	 * Id number of cinema
	 */
	private int cinemaID;
	/**
	 * Id number of movie
	 */
	private int movieID;
	/**
	 * Date of movie
	 */
	private DateUtils showDate;
	/**
	 * Time of movie
	 */
	private TimeUtils showTime;
	/**
	 * Type of movie
	 */
	private MovieType movieType;
	/**
	 * Seat type
	 */
	private SeatType[][] seatStatus;
	/**
	 * Constructor
	 * @param showStatusID
	 * @param cineplexID
	 * @param cinemaID
	 * @param movieID
	 * @param showDate
	 * @param showTime
	 * @param movieType
	 * @param seatStatus
	 */
	public ShowStatus(int showStatusID,int cineplexID, int cinemaID, int movieID, DateUtils showDate, 
			TimeUtils showTime, MovieType movieType, SeatType[][] seatStatus) {
		this.showStatusID = showStatusID;
		this.cineplexID=cineplexID;
		this.cinemaID=cinemaID;
		this.movieID=movieID;
		this.showDate=showDate;
		this.showTime=showTime;
		this.movieType=movieType;
		this.seatStatus = seatStatus;
	}
	/**
	 * Get and return a copy of Showstatus
	 * @param another
	 * @return
	 */
	public static ShowStatus copy(ShowStatus another) {
		ShowStatus buffer = new ShowStatus(
				another.getShowStatusID(),
				another.getCineplexID(),
				another.getCinemaID(),
				another.getMovieID(),
				another.getShowDate(),
				another.getShowTime(),
				another.getMovieType(),
				another.getseatStatus()
		);
		return buffer;
	}
	
	/**
	 * Setter of this seat status
	 * @param seatStatus
	 */
	public void setseatStatus(SeatType[][] seatStatus) {
		this.seatStatus = seatStatus;
	}
	
	/**
	 * Getter if this seat status
	 * @return this.seatStatus
	 */
	public SeatType[][] getseatStatus() {
		return this.seatStatus;
	}
	
	/**
	 * Setter of movie type of this show status
	 * @param id
	 */
	
	public void setMovieType(MovieType id) {
		this.movieType = id;
	}
	
	/**
	 * Getter movie type of this show status
	 * @return this.movieType
	 */
	public MovieType getMovieType() {
		return this.movieType;
	}
	
	/**
	 * Setter Id number of movie
	 * @param id
	 */
	public void setMovieID(int id) {
		this.movieID = id;
	}
	
	/**
	 * Getter Movie Id of this showstatus
	 * @return this.movieID
	 */
	public int getMovieID() {
		return this.movieID;
	}
	
	/**
	 * Setter Cineplex Id 
	 * @param id
	 */
	public void setCineplexID(int id) {
		this.cineplexID = id;
	}
	
	/**
	 * Getter Cineplex Id
	 * @return
	 */
	public int getCineplexID() {
		return this.cineplexID;
	}
	
	/**
	 * Setter Cinema Id of this show status
	 * @param id
	 */
	public void setCinemaID(int id) {
		this.cinemaID = id;
	}
	
	/**
	 * Getter Cinema Id of this show status
	 * @return this.cinema
	 */
	public int getCinemaID() {
		return this.cinemaID;
	}
	
	/**
	 * Setter Id number of this show status
	 * @param id
	 */
	public void setShowStatusID(int id) {
		this.showStatusID = id;
	}
	
	/**
	 * Getter ID number of this show status
	 * @return this.showStat
	 */
	public int getShowStatusID() {
		return this.showStatusID;
	}
	
	/**
	 * get and return show date
	 * @return this.showDate
	 */
	public DateUtils getShowDate() {
		return this.showDate;
	}
	/**
	 * Setter show date
	 * @param date
	 */
	public void setShowDate(DateUtils date) {
		this.showDate = date;
	}
	/**
	 * get and return show time
	 * @return this.showTime
	 */
	public TimeUtils getShowTime() {
		return this.showTime;
	}
	/**
	 * Setter show time
	 * @param time
	 */
	public void setShowTime(TimeUtils time) {
		this.showTime =time;
	} 
}
