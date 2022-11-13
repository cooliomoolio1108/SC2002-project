package model;

import java.io.Serializable;

import utils.DateUtils;
import utils.TimeUtils;

public class Booking implements Serializable {
	/**
	 *   For Java Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Booking ID for this booking
	 */
	private int bookingID;
	
	/**
	 *  UserID for this booking
	 */
    private int userID;
    
    /**
     * Seat ID for this booking
     */
    private String seatID;
    
    /**
     *  ticket price 
     */
    private double price;
    
    /**
     * Show Status ID for this booking
     */
    private int showStatusID;
    
    /**
     *  booking Date of this ticket
     */
	private DateUtils bookingDate;
	
	/**
	 * booking time of this ticket
	 */
    private TimeUtils bookingTime;
    
    /**
     *  TID for this booking
     */
    private String TID;
    
   
    /**
     * Constructor for this Booking 
     * @param bookingID booking ID of this ticket
     * @param userID user id that book this ticket
     * @param showStatusID show status id for this ticket to obtain show time and date
     * @param price ticket price 
     * @param bookingDate booking Date of this ticket
     * @param bookingTime booking time of this ticket
     */
    
    public Booking(int bookingID, int userID, int showStatusID,double price,
    		DateUtils bookingDate,TimeUtils bookingTime) {
    	this.bookingID = bookingID;
    	this.userID = userID;
    	this.price = price;
    	this.bookingDate = bookingDate;
    	this.bookingTime = bookingTime;
    	this.showStatusID = showStatusID;
    	
    	String day = String.valueOf(bookingDate.getDay());
    	String year = String.valueOf(bookingDate.getYear());
    	String month = String.valueOf(bookingDate.getMonth());
    	
    	if(bookingDate.getMonth() <10) {
    		month = "0" + String.valueOf(bookingDate.getMonth());
    	}
    	
    	if(bookingDate.getDay() <10) {
    		day = "0" + String.valueOf(bookingDate.getDay());
    	}
    	
    	String hour = String.valueOf(bookingTime.getHour());
    	if(bookingTime.getHour()<10) {
    		hour = "0" + String.valueOf(bookingTime.getHour());
    	}
    	
    	String minute =String.valueOf(bookingTime.getMinute());
    	if(bookingTime.getMinute() <10) {
    		minute = "0" + String.valueOf(bookingTime.getMinute());
    	}
    	String strBookID = String.valueOf(bookingID);
    	String strUserID = String.valueOf(userID);
    	String str = strBookID+strUserID+year+month+day+hour+minute+"";
    	this.TID = new String(str);

    }
    
    /**
     * for copying Booking instance
     * @param another refer to another Booking
     * @return copy of the Booking instance
     */
    
    public static Booking copy(Booking another) {
    	Booking booking  = new Booking(
    		another.getBookingID(),
    		another.getUserID(),
    		another.getShowStatusID(),
    		another.getPrice(),
    		another.getBookingDate(),
    		another.getBookingTime()
    	);
    	return booking;
    }
    
    /**
     * Setter for TID
     * @param tid
     */
    public void setTID(String tid) {
    	this.TID = tid;
    }
    
    /**
     *  Getter for TID
     * @return tid of this booking
     */
    public String getTID() {
    	return this.TID;
    }
    
    /**
     * Getter for ShowStatusID
     * @return
     */
    public int getShowStatusID() {
    	return this.showStatusID;
    }
    
    /**
     * Setter for ShowStatusID
     * @param id
     */
    public void setShowStatusID(int id) {
    	this.showStatusID = id;
    }
    
    /**
     * Setter for SeatID
     * @param id
     */
    public void setSeatID(String id) {
    	this.seatID = id;
    }
    
    /**
     * Getter for SeatID
     * @return
     */
    public String getSeatID() {
    	return this.seatID;
    }
    /**
     * Setter for UserID
     * @param id
     */
    public void setUserID(int id) {
    	this.userID = id;
    }
    
    /**
     * Getter of UserID
     * @return
     */
    public int getUserID() {
    	return this.userID;
    }
    
    /**
     * Getter of Ticket Price
     * @return
     */
    public double getPrice() {
    	return this.price;
    }
    
    /**
     * Setter for Tickter Price
     * @param price
     */
    public void setPrice(double price) {
    	this.price = price;
    }
    
    /**
     *  Getter of Booking Date
     * @return
     */
    public DateUtils getBookingDate(){
        return this.bookingDate;
    }

    /**
     * Setter of Booking Date
     * @param date
     */
    public void setBookingDate(DateUtils date){
        this.bookingDate = date;
    }

    /**
     * Getter of Booking Time
     * @return
     */
    public TimeUtils getBookingTime(){
        return this.bookingTime;
    }
    
    /**
     * Setter of Booking Time
     * @param time
     */
    public void setBookingTime(TimeUtils time){
        this.bookingTime  = time;
    }

    /**
     *  Getter of Booking ID
     * @return
     */
    public int getBookingID(){
        return this.bookingID;
    }
    
    /**
     * Setter of booking ID
     * @param id
     */
    public void setBookingID(int id){
        this.bookingID = id;
    }
}
