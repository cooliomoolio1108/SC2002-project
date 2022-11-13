package uI;

import java.util.*;

import manager.CinemaMgr;
import manager.CineplexMgr;
import manager.MovieMgr;
import manager.ShowStatusMgr;
import model.*;
import utils.DateUtils;
import utils.SearchUtils;
import utils.TimeUtils;

/**
 * Controller for the entity labelled Showtime.
 * Contains the logic to link showtime to other classes.
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public class ShowTimeConfig {

	/**
	 * Staff can choose from the following options.
	 * Update movies, showtimes, movietype.
	 */
	
	public static void EditShowTime(Scanner sc) {
		
		ArrayList<ShowStatus> list= Printer.displayAllMovieShowTime();
		System.out.print("Please Enter Show Time ID"+ "(or Enter 0 to return): ");
		int index = sc.nextInt() -1;
		sc.nextLine();
		if(index>=list.size()|| index < 0) {
			return;
		}
		int showStatusID = list.get(index).getShowStatusID();
		ShowStatus showStatus = ShowStatusMgr.getShowStatusByID(showStatusID);
		if(showStatus ==null) {
			System.out.print("Not found, Please try again\n");
			return;
		}
		Movie movie1 = MovieMgr.getMovieByID(showStatus.getMovieID());

		while(true) {
			System.out.print("\n========================================\n");
			System.out.print("             Edit Show Time               \n");
			System.out.print("========================================\n");
			System.out.println("Movie Title: "+movie1.getTitle()+"\n");
			System.out.print("1) Update Movie\n");
			System.out.print("2) Update Show Date\n");
			System.out.print("3) Update Show Time\n");
			System.out.print("4) Update Movie Type\n");
			System.out.print("0) Go Back\n");
			System.out.print("Please Choose Your Action: ");
			
			int day,month,year,hour,minute;
			int choice = sc.nextInt();
			switch(choice) {
				case 0:
					return;
				case 1:
					String name;
					sc.nextLine();
					System.out.print("Enter Movie Name: ");
					name = sc.nextLine();
					Movie movie = MovieMgr.getMovieByName(name);
					if(movie == null) {
						System.out.print("Movie not found\n");
						break;
					}
					ShowStatusMgr.updateMovie(showStatusID, name);
					System.out.print("Movie Updated\n");
					break;
				case 2:
					System.out.print("Enter ShowDate:\n");
					System.out.print("Enter day: ");
					day = sc.nextInt();
					System.out.print("Enter month:");
					month = sc.nextInt();
					System.out.print("Enter year:");
					year = sc.nextInt();
					DateUtils date = new DateUtils(day,month,year);
					ShowStatusMgr.updateShowDate(showStatusID, date);
					System.out.print("Date Updated\n");
					break;
				case 3:
					System.out.print("Enter ShowTime:\n");
					System.out.print("Enter hour: ");
					hour = sc.nextInt(); 
					System.out.print("Enter minute:");
					minute = sc.nextInt();
					TimeUtils time = new TimeUtils(hour,minute);
					ShowStatusMgr.updateShowTime(showStatusID, time);
					System.out.print("ShowTime Updated\n");
					break;
				case 4:
					MovieType type = promptMovieTypeInput(sc);
					ShowStatusMgr.updateMovieType(showStatusID, type);
					System.out.print("Movie Type Updated\n");
					break;
				default:
					break;
			}
		}
	}
	/**
	 * Allows staff to choose the movietype for a particular movie
	 */
	
	public static MovieType promptMovieTypeInput(Scanner sc) {
		int typeID;
		MovieType movieType = MovieType.TWOD;
		while(true) {	
			System.out.print("\nEnter MovieType:\n");
			System.out.println("1) 2D");
			System.out.println("2) 3D");
			System.out.println("3) BLOCKBUSTER");
			System.out.print("Enter Movie Type ID: ");
			typeID = sc.nextInt();
			switch(typeID) {
				case 1:
					movieType = MovieType.TWOD;
					break;
				case 2:
					movieType = MovieType.THREED;
					break;
				case 3:
					movieType = MovieType.BLOCKBUSTER;
					break;
				default:
					System.out.println("Please Enter a valid type");
			}
			
			if(typeID>=1 && typeID<=3) {
				break;
			}
		}
		return movieType;
	}
	
	/**
	 * Update showtime in a particular ciniplex with ID.
	 */
	
	public static Cineplex promptCineplexInput(Scanner sc) {
		ArrayList<Cineplex> list = CineplexMgr.getCineplexList();
		while(true) {	
			System.out.print("Cineplex Name:\n");
			
			for(int i =0;i<list.size();i++) {
				System.out.println((i+1)+") "+ list.get(i).getName());
			}
			System.out.print("Enter Cineplex ID: ");
			int index = sc.nextInt() -1;
			if(index>=list.size() || index <0) {
				System.out.println("Please Enter a Valid ID");
				break;
			}
			else {
				return list.get(index);
			}
		}
		return null;
	}
	
	/**
	 * Update the showtime at a particular cinema which contains the particular ciniplex.
	 * Uses cinema ID.
	 * @param cineplexID
	 */
	
	public static Cinema promptCinemaInput(Scanner sc, int cineplexID) {
		ArrayList<Cinema> list = CinemaMgr.getCinemaListByCineplexID(cineplexID);
		while(true) {	
			System.out.print("Cinema Code:\n");
			
			for(int i =0;i<list.size();i++) {
				System.out.println((i+1)+") "+ list.get(i).getCinemaCode());
			}
			System.out.print("Enter Cinema ID: ");
			int index = sc.nextInt() -1;
			sc.nextLine();
			if(index>=list.size() || index <0) {
				System.out.println("Please Enter a Valid ID");
				break;
			}
			else {
				return list.get(index);
			}
		}
		return null;
	}
	
	/**
	 * Add showtime for a particular movie ID
	 */
	
	public static void AddShowTime(Scanner sc) {
		int cinemaID, day, month, year, hour, minute;
		Cineplex cineplex;
		Movie movie;
		MovieType movieType = MovieType.TWOD;
		sc.nextLine();
		
		ArrayList<Movie> movieList = Printer.displayAllMovieTitle();
		System.out.print("Please Enter Movie ID"+ "(or Enter 0 to return): ");
		int index = sc.nextInt() -1;
		sc.nextLine();
		if(index>=movieList.size()|| index < 0) {
			return;
		}
		
		movie = movieList.get(index);
		cineplex = promptCineplexInput(sc);
		Cinema cinema = promptCinemaInput(sc, cineplex.getCineplexID());
		cinemaID = cinema.getCinemaID();
		
		System.out.print("Enter ShowDate:\n");
		System.out.print("Enter day: ");
		day = sc.nextInt();
		System.out.print("Enter month:");
		month = sc.nextInt();
		System.out.print("Enter year:");
		year = sc.nextInt();
		DateUtils date = new DateUtils(day,month,year);
		
		System.out.print("Enter ShowTime:\n");
		System.out.print("Enter hour: ");
		hour = sc.nextInt(); 
		System.out.print("Enter minute:");
		minute = sc.nextInt();
		TimeUtils time = new TimeUtils(hour,minute);
		movieType = promptMovieTypeInput(sc);

		boolean pass = ShowStatusMgr.createShowStatus(cineplex.getCineplexID(), cinemaID, movie.getMovieID(), date, time, movieType);
		
		if(!pass) {
			System.out.println("Fail to create show time");
		}
		else {
			System.out.println("Successfully created");
		}
		return;
	}
	
	/**
	 * Remove showtime for a particular movie with movieID
	 */
	
	public static void RemoveShowTime(Scanner sc) {
		ArrayList<ShowStatus> list= Printer.displayAllMovieShowTime();
		System.out.print("Please Enter Show Time ID"+ "(or Enter 0 to return): ");
		int index = sc.nextInt() -1;
		sc.nextLine();
		if(index>=list.size()|| index < 0) {
			return;
		}
		int statusID = list.get(index).getShowStatusID();
		ShowStatus showStatus = ShowStatusMgr.getShowStatusByID(statusID);
		if(showStatus ==null) {
			System.out.print("Not found, Please try again\n");
			return;
		}
		ShowStatusMgr.removeShowStatus(statusID);
		System.out.println("Succesfully Removed");
		
	}
	public static void AppMain(Scanner sc) {
		while(true) {
			int num =-1;
			System.out.print("\n========================================\n");
			System.out.print("            Show Time Config              \n");
			System.out.print("========================================\n");
			System.out.print("1) View All Show Time List\n");
			System.out.print("2) View A Movie Show Time\n");
			System.out.print("3) Create Show Time\n");
			System.out.print("4) Remove Show Time\n");
			System.out.print("5) Update Show Time\n");
			System.out.println("0: Go Back\n");
			System.out.print("Enter Your Choice: ");
			num = sc.nextInt();
			
			switch(num) {
			case 0: 
				return;
				case 1: 
					Printer.displayAllMovieShowTime();
					break;
				case 2:
					ArrayList<Movie> movieList = Printer.displayAllMovieTitle();
					System.out.print("Please Enter Movie ID"+ "(or Enter 0 to return): ");
					int index = sc.nextInt() -1;
					sc.nextLine();
					if(index>=movieList.size()|| index < 0) {
						break;
					}
					Printer.displaytMovieShowTime(index);
					break;
				case 3:
					AddShowTime(sc);
					break;
				case 4:
					RemoveShowTime(sc);
					break;
				case 5:
					EditShowTime(sc);
					break;
				default:
					break;
					
			}
		}
	}
}
