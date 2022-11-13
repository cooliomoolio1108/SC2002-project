package manager;

import java.util.ArrayList;
import java.util.HashMap;

import database.Data;
import database.FileType;
import model.Cineplex;
import utils.Helper;
import utils.SearchUtils;
import utils.Validator;
/**
 * Manager class to process cineplex methods
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */
public class CineplexMgr {
	/**
	 * Hash map of exisiting cineplexes sorted with cineplex id
	 */
	private static HashMap<Integer,Cineplex> cineplexList =  Data.cineplexList;
	
	/**
	 * Method to create cineplex with given name parameter
	 * @param name
	 * @return boolean
	 */
	public static boolean createCineplex(String name) {
		if(Validator.validateCineplex(name)  == true) {
			return false;
		}
		int cineplexID = Helper.getUniqueId(cineplexList);
		Cineplex newCineplex = new Cineplex(cineplexID, name);
		cineplexList.put(cineplexID, newCineplex);
		Data.saveFile(FileType.CINEPLEX);
		return true;
	}
	/**
	 * Gets cineplex with given parameter cineplexID
	 * @param cineplexID
	 * @return cineplex 
	 */
	public static Cineplex getCineplexByID(int cineplexID) {
		if(Validator.validateCineplex(cineplexID) == false) {
			return null;
		}
		Cineplex buffer = SearchUtils.searchCineplex(cineplexID);
		return Cineplex.copy(buffer);
	}
	/**
	 * Gets cineplex with given parameter of name
	 * @param name
	 * @return cineplex
	 */
	public static Cineplex getCineplexByName(String name) {
		if(Validator.validateCineplex(name) ==false ) {
			return null;
		}
		for(Cineplex buffer : cineplexList.values()) {
			if(buffer.getName().equals(name)) {
				return Cineplex.copy(buffer);
			}
		}
		return null;
	}
	/**
	 * Gets full list of existing cineplexes
	 * @return list
	 */
	public static ArrayList<Cineplex> getCineplexList(){
		ArrayList<Cineplex> list = new ArrayList<Cineplex>();
		for(Cineplex buffer : cineplexList.values()) {
			list.add(Cineplex.copy(buffer));
		}
		return list;
	}
}
