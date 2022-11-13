package uI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import database.Data;
import manager.BookingMgr;
import manager.CinemaMgr;
import manager.CineplexMgr;
import manager.MovieMgr;
import manager.ShowStatusMgr;
import manager.UserAccountMgr;
import utils.DateUtils;
import utils.PriceCalculator;
import utils.SearchUtils;
import utils.StringToSeat;
import utils.TimeUtils;
import model.*;

/**
 * Driver functions for the booking of movie tickets. 
 * (1) Lists all movies recorded in the database.
 * (2) Allows user to search for a specific movie.
 * (2) Takes in user choice of movie, cineplex and showtime.
 * (3) Takes in  user's seat selection.
 * (4) Calculates the total price for a single booking transaction.
 * (5) Prints out all the details of the movie booking for the user's reference.
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public class BookingApp {
	public static void AppMain(Scanner sc) {
		ArrayList<ShowStatus> showStatusList = Printer.displaytMovieShowTime(AppState.getMovieID());
		if(showStatusList.size() == 0) {
			return;
		}
		
		int index;
		while(true) {
			System.out.print("Enter Booking ID (or enter -1 to exit): ");
			index = sc.nextInt() -1;
			sc.nextLine();
			if(index<0) {
				return;
			}
			if(index >= showStatusList.size()) {
				System.out.println("Invalid ID, Please Try Again");
			}else {
				break;
			}
		}
		
		ShowStatus buffer = showStatusList.get(index);
		Cinema cinema = CinemaMgr.getCinemaByID(buffer.getCinemaID());
		UserAccount user = UserAccountMgr.getUserAccount(AppState.getUserID());
		Cineplex cineplex = CineplexMgr.getCineplexByID(buffer.getCineplexID());
		Movie movie = MovieMgr.getMovieByID(AppState.getMovieID());
		SeatType[][] tmp = ShowStatusMgr.getCopySeatPlan(buffer.getseatStatus());
		double totalPrice =0;
		ArrayList<String> seatIDs = new ArrayList<>();
		System.out.print("Please enter the number of tickets that you want to buy: ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		for(int s=0;s<choice;s++) {
			StringToSeat.printSeat(tmp);
			int i=0,j=0;
			String seatID ="";
			while(true) {
				System.out.print("Enter SeatID (A0): ");
				seatID = sc.nextLine();
				String alpha=  "ABCDEFGHIJKLMNOP";
				for(int y=0;y<alpha.length();y++) {
					if(seatID.charAt(0) == alpha.charAt(y)) {
						j=y;
						break;
					}
				}
				i = Character.getNumericValue(seatID.charAt(1));
				if(i>= buffer.getseatStatus().length || j>=buffer.getseatStatus()[0].length) {
					System.out.print("Invalid Seat, Please try again\n");
					continue;
				}
				tmp = ShowStatusMgr.updateCacheSeat(tmp, i, j);
				if(tmp != null) {
					seatIDs.add(seatID);
					break;
				}else {
					System.out.print("Invalid Seat, Please try again\n");
				}
			}
			
			double price = PriceCalculator.calculate(cinema.getCinemaType(), tmp[i][j], user.getAge(), 
					buffer.getShowDate(), buffer.getShowTime(),buffer.getMovieType(), user.getIsMember());
			
			totalPrice += price;
		}
		
		
		boolean pay = PaymentApp.AppMain(sc,totalPrice);
		
		if(pay) {
			System.out.print("\n========================================\n");
			System.out.print("               Ticket Details             \n");
			System.out.print("========================================\n");
			ShowStatusMgr.updateSeat(buffer.getShowStatusID(), tmp);
			for(int i=0;i<seatIDs.size();i++) {
				LocalDate bookDate = LocalDate.now();
				LocalTime bookTime = LocalTime.now();
				int newID = BookingMgr.createBooking(AppState.getUserID(), buffer.getShowStatusID(), totalPrice, bookDate, bookTime);
				Booking booking = BookingMgr.getBookingCopy(newID);
				System.out.println("\nTicket details:\n");
				System.out.println("Name: "+user.getUsername());
				System.out.println("Mobile Number: "+user.getMobileNumber());
				System.out.println("Email: "+user.getEmail());
				System.out.println("TID: "+booking.getTID());
				System.out.println("Ticket Price: "+booking.getPrice()+" SGD");
				System.out.println("Movie title: "+movie.getTitle());
				System.out.println("MovieType: "+buffer.getMovieType());
				System.out.println("SeatID: "+seatIDs.get(i));
				System.out.println("Cinema Code: "+cinema.getCinemaCode());
				System.out.println("Cinema Class: "+cinema.getCinemaType());
				System.out.println("Cineplex Name: "+cineplex.getName());
			}
		}
		else {
			System.out.println("Fail Payment");
		}
		
	}

	
	
}
