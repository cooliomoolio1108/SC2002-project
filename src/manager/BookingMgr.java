package manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;
import java.util.HashMap;
import model.*;

import database.Data;
import database.FileType;
import utils.DateUtils;
import utils.Helper;
import utils.SearchUtils;
import utils.TimeUtils;
import utils.Validator;

/**
 * Booking Manager class to process bookings of movie
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */
public class BookingMgr {
	/**
	 * Hash map that contains bookings that are indexed by an integer (bookingID)
	 */
	
	private static HashMap<Integer, Booking> bookingList = Data.bookingList;
	
	/**
	 * Creating a booking entry with the given parameters and returns the bookingID
	 * @param userID
	 * @param showStatusID
	 * @param price
	 * @param bookingDate
	 * @param bookingTime
	 * @return bookingID
	 */
	
	public static int createBooking(int userID, int showStatusID, double price,
    		DateUtils bookingDate,TimeUtils bookingTime) {
		if(!(Validator.validateUser(userID) && Validator.validateShowStatus(showStatusID))) {
			return -1;
		}

		ShowStatus buffer = SearchUtils.searchShowStatus(showStatusID);
		
		int bookingID = Helper.getUniqueId(bookingList);
		
		Booking newBooking = new Booking(bookingID, userID, showStatusID, price, bookingDate, bookingTime);
		bookingList.put(bookingID, newBooking);
		MovieRankMgr.addSales(buffer.getMovieID(),price);
		Data.saveFile(FileType.BOOKING);
		return bookingID;
		
	}
	
	/**
	 * Creating a booking entry with the given parameters and returns the bookingID
	 * @param userID
	 * @param showStatusID
	 * @param price
	 * @param date
	 * @param time
	 * @return
	 */
	public static int createBooking(int userID, int showStatusID, double price,
    		LocalDate date,LocalTime time) {
		if(!(Validator.validateUser(userID) && Validator.validateShowStatus(showStatusID))) {
			return -1;
		}

		DateUtils bookingDate = DateUtils.LocalDateToDateUtils(date);
		TimeUtils bookingTime = TimeUtils.LocalTimeToTimeUtils(time);
		ShowStatus buffer = SearchUtils.searchShowStatus(showStatusID);
		
		int bookingID = Helper.getUniqueId(bookingList);
		
		Booking newBooking = new Booking(bookingID, userID, showStatusID, price, bookingDate, bookingTime);
		
		bookingList.put(bookingID, newBooking);
		MovieRankMgr.addSales(buffer.getMovieID(),price);
		Data.saveFile(FileType.BOOKING);
		return bookingID;
		
	}
	
	/**
	 * Returns a copy of the requested bookingID, if valid
	 * @param bookingID
	 * @return Booking.copy(buffer)
	 */
	public static Booking getBookingCopy(int bookingID) {
		if(!(Validator.validateBooking(bookingID))) {
			return null;
		}
		Booking buffer = SearchUtils.searchBooking(bookingID);
		return Booking.copy(buffer);
	}
	
	/**
	 * Returns the list of bookings of requested user after validation
	 * @param userID
	 * @return list
	 */
	public static ArrayList<Booking> getBookingListByUserID(int userID){
		if(!Validator.validateUser(userID) ) {
			return null;
		}
		ArrayList<Booking> list = new ArrayList<Booking>();
		for(Booking buffer: bookingList.values()) {
			if(buffer.getUserID() == userID) {
				list.add(buffer);
			}
		}
		return list;
	}
	
	/**
	 * Returns all booking entries
	 * @return list
	 */
	public static ArrayList<Booking> getAllBookingList(){
		ArrayList<Booking> list = new ArrayList<Booking>();
		for(Booking buffer: bookingList.values()) {
			Booking copy = Booking.copy(buffer);
			list.add(copy);
		}
		return list;
	}
}
