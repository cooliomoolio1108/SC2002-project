package manager;


import java.util.HashMap;
import java.util.ArrayList;
import database.Data;
import database.FileType;
import utils.Helper;
import utils.SearchUtils;
import utils.Validator;
import model.*;

/**
 * Cinema Manager class for cinema processes
 * @author Group 4 SS9
 * @version 1/0
 * @since 2022-11-07
 */

public class CinemaMgr {
	/**
	 * Hash map of cinemas sorted by their cinemaID
	 */
	private static HashMap<Integer,Cinema> cinemaList =  Data.cinemaList;
	
	/**
	 * Method to create cinema object with provided parameters which are validated
	 * @param cineplexID
	 * @param type
	 * @param seatPlan
	 * @param cinemaCode
	 * @return
	 */
	public static int createCinema(int cineplexID, CinemaType type,SeatType[][] seatPlan, String cinemaCode) {
		if(Validator.validateCinema(cineplexID, cinemaCode) == true) {
			return -1;
		}
		int cinemaID = Helper.getUniqueId(cinemaList);
		Cinema newCinema = new Cinema(cinemaID,cineplexID,type,seatPlan,cinemaCode);
		cinemaList.put(cinemaID, newCinema);
		Data.saveFile(FileType.CINEMA);
		return cinemaID;
	}
	/**
	 * 
	 * @param cinemaID
	 * @return
	 */
	public static Cinema getCinemaByID(int cinemaID) {
		for(Cinema cinema: cinemaList.values()) {
			if(cinema.getCinemaID() == cinemaID) {
				return Cinema.copy(cinema);
			}
		}
		return null;
	}
	/**
	 * Gets list of cinema and returns it
	 * @return list
	 */
	
	public static ArrayList<Cinema> getAllCinemaList(){
		ArrayList<Cinema> list = new ArrayList<Cinema>();
		for(Cinema cinema: cinemaList.values()) {
			Cinema buffer = Cinema.copy(cinema);
			list.add(buffer);
		}
		return list;
	}
	/**
	 * Gets list of cinema through given cineplexID parameter and returns corresponding list
	 * @param cineplexID
	 * @return list
	 */
	public static ArrayList<Cinema> getCinemaListByCineplexID(int cineplexID){
		if(Validator.validateCineplex(cineplexID) == false) {
			return null;
		}
		ArrayList<Cinema> list = new ArrayList<Cinema>();
		for(Cinema cinema: cinemaList.values()) {
			if(cinema.getCineplexID() == cineplexID) {
				Cinema buffer = Cinema.copy(cinema);
				list.add(buffer);
			}
		}
		return list;
	}
}
