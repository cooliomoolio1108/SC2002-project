package manager;

import java.util.ArrayList;
import java.util.HashMap;

import database.Data;
import database.FileType;
import model.Holiday;
import utils.DateUtils;
import utils.Helper;
import utils.SearchUtils;
import utils.Validator;
/**
 * Holiday Manager Class to manage holiday processes
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */
public class HolidayMgr {
	/**
	 * Hash map of existing holidays
	 */
	private static HashMap<Integer,Holiday> holidayList = Data.holidayList;
	
	/**
	 * Method to get list of existing holidays
	 * @return list
	 */
	
	public static ArrayList<Holiday> getAllHolidayList(){
		ArrayList<Holiday> list = new ArrayList<Holiday>();
		for(Holiday holiday : holidayList.values()) {
			list.add(Holiday.copy(holiday));
		}
		return list;
	}
	/**
	 * Method to create holiday and id with given parameters
	 * @param name
	 * @param date
	 * @return holidayId
	 */
	
	public static int createHoliday(String name, DateUtils date) {
		if(Validator.validateHoliday(name,date)  == true ) {
			return -1;
		}
		int holidayId = Helper.getUniqueId(holidayList);
		Holiday holiday = new Holiday(holidayId,name,date);
		holidayList.put(holidayId, holiday);
		Data.saveFile(FileType.HOLIDAY);
		return holidayId;
	}
	
	/**
	 * Method to remove existing holiday with given parameters
	 * @param holidayId
	 * @return boolean
	 */
	public static boolean removeHoliday(int holidayId) {
		if(Validator.validateHoliday(holidayId) == false) {
			return false;
		}
		holidayList.remove(holidayId);
		Data.saveFile(FileType.HOLIDAY);
		return true;
	}
	
	/**
	 * Method to remove existing holiday with given parameters
	 * @param name
	 * @param date
	 * @return boolean
	 */
	
	public static boolean removeHoliday(String name, DateUtils date) {
		if(Validator.validateHoliday(name,date) == false) {
			return false;
		}
		Holiday holiday = SearchUtils.searchHoliday(name, date);
		int holidayId = holiday.getHolidayID();
		holidayList.remove(holidayId);
		Data.saveFile(FileType.HOLIDAY);
		return true;
	}
	/**
	 * Method to update holiday name with given parameters
	 * @param name
	 * @param date
	 * @param newName
	 * @return boolean
	 */
	
	public static boolean updateHolidayName(String name, DateUtils date, String newName) {
		if(Validator.validateHoliday(name,date) == false) {
			return false;
		}
		if(Validator.validateHoliday(newName,date)  == true ) {
			return false;
		}
		Holiday holiday = SearchUtils.searchHoliday(name, date);
		holiday.setHolidayName(newName);
		holidayList.put(holiday.getHolidayID(), holiday);
		Data.saveFile(FileType.HOLIDAY);
		return true;
		
	}
	
	/**
	 * Method to update existing holiday name with given parameters
	 * @param holidayID
	 * @param newName
	 * @return boolean
	 */
	public static boolean updateHolidayName(int holidayID, String newName) {
		if(Validator.validateHoliday(holidayID) == false) {
			return false;
		}
		Holiday holiday = SearchUtils.searchHoliday(holidayID);
		DateUtils date = holiday.getHolidayDate();
		if(Validator.validateHoliday(newName,date)  == true ) {
			return false;
		}
		holiday.setHolidayName(newName);
		holidayList.put(holiday.getHolidayID(), holiday);
		Data.saveFile(FileType.HOLIDAY);
		return true;
	}
	
	/**
	 * Method to update existing holiday date with given parameters
	 * @param name
	 * @param date
	 * @param newDate
	 * @return
	 */
	public static boolean updateHolidayDate(String name, DateUtils date, DateUtils newDate) {
		if(Validator.validateHoliday(name,date) == false) {
			return false;
		}
		Holiday updateHoliday = SearchUtils.searchHoliday(name, date);
		if(Validator.validateHoliday(updateHoliday.getHolidayName(),newDate)  == true ) {
			return false;
		}
		updateHoliday.setHolidayDate(newDate);
		holidayList.put(updateHoliday.getHolidayID(), updateHoliday);
		Data.saveFile(FileType.HOLIDAY);
		return true;
		
	}
	
	/**
	 * Method to update existing holiday date with given parameters
	 * @param holidayID
	 * @param newDate
	 * @return
	 */
	public static boolean updateHolidayDate(int holidayID, DateUtils newDate) {
		if(Validator.validateHoliday(holidayID) == false) {
			return false;
		}
		Holiday holiday = SearchUtils.searchHoliday(holidayID);
		if(Validator.validateHoliday(holiday.getHolidayName(),newDate)  == true ) {
			return false;
		}
		holiday.setHolidayDate(newDate);
		holidayList.put(holiday.getHolidayID(), holiday);
		Data.saveFile(FileType.HOLIDAY);
		return true;
		
	}
	/**
	 * Method to get existing holiday with holidayID parameter
	 * @param holidayID
	 * @return
	 */
	public static Holiday getHoliday(int holidayID) {
		if(Validator.validateHoliday(holidayID) == false) {
			return null;
		}
		Holiday holiday = SearchUtils.searchHoliday(holidayID);
		return Holiday.copy(holiday);
	}
	
	/**
	 * Method to get existing holiday with name and date parameters
	 * @param name
	 * @param date
	 * @return
	 */
	public static Holiday getHoliday(String name, DateUtils date) {
		if(Validator.validateHoliday(name,date)== false) {
			return null;
		}
		Holiday holiday = SearchUtils.searchHoliday(name, date);
		return Holiday.copy(holiday);
	}

	
}
