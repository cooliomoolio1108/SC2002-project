
package manager;


import java.util.HashMap;

import database.Data;
import database.FileType;
import model.UserAccount;
import utils.Helper;
import utils.SearchUtils;
import utils.Validator;

/**
 * User Account Manager Class to manage user account processes
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */
public class UserAccountMgr {
	/**
	 * Hash map of existing user accounts
	 */
	private static HashMap<Integer,UserAccount> userAccountList=  Data.userAccountList;
	/**
	 * MEthod to get and return a copy of user account
	 * @param userID
	 * @return UserAccount.copy(user)
	 */
	public static UserAccount getUserAccount(int userID) {
		if(Validator.validateUser(userID) ==false) {
			return null;
		}
		UserAccount user = SearchUtils.searchUserAccount(userID);
		return UserAccount.copy(user);
		
	}
	/**
	 * Method to create user account
	 * returns 1 if successful, 0 if unsuccessful
	 * @param username
	 * @param password
	 * @param mobileNumber
	 * @param email
	 * @param age
	 * @param isMember
	 * @return
	 */
	public static boolean createUserAccount(String username,String password,String mobileNumber,String email,int age, boolean isMember) {
		if(Validator.validateUser(username) == true) {
			return false;
		}
		int userID = Helper.getUniqueId(userAccountList);
		UserAccount newUser = new UserAccount(userID,username,password,mobileNumber,email,age,isMember);
		userAccountList.put(userID, newUser);
		Data.saveFile(FileType.USER);
		return true;
	}
	
	/**
	 * Method to update user id into a member and add into user account list
	 * @param userID
	 * @param isMember
	 * @return
	 */
	public static boolean updateMember(int userID, boolean isMember) {
		if(Validator.validateUser(userID) == false) {
			return false;
		}
		UserAccount updateUser = SearchUtils.searchUserAccount(userID);
		updateUser.setIsMember(isMember);
		userAccountList.put(userID, updateUser);
		Data.saveFile(FileType.USER);
		return true;
	}
	
	/**
	 * Method to update email of existing user account
	 * @param userID
	 * @param text
	 * @return
	 */
	
	public static boolean updateEmail(int userID, String text) {
		if(Validator.validateUser(userID) == false) {
			return false;
		}
		UserAccount updateUser = SearchUtils.searchUserAccount(userID);
		updateUser.setEmail(text);
		userAccountList.put(userID, updateUser);
		Data.saveFile(FileType.USER);
		return true;
	}
	
	/**
	 * Method to update mobile number of existing user account
	 * @param userID
	 * @param text
	 * @return
	 */
	public static boolean updateMobileNumber(int userID, String text) {
		if(Validator.validateUser(userID) == false) {
			return false;
		}
		UserAccount updateUser = SearchUtils.searchUserAccount(userID);
		updateUser.setMobileNumber(text);
		userAccountList.put(userID, updateUser);
		Data.saveFile(FileType.USER);
		return true;
	}
	
	/**
	 * MEthod to update password of existing user account
	 * @param userID
	 * @param text
	 * @return
	 */
	public static boolean updatePassword(int userID, String text) {
		if(Validator.validateUser(userID) == false) {
			return false;
		}
		UserAccount updateUser = SearchUtils.searchUserAccount(userID);
		updateUser.setPassword(text);
		userAccountList.put(userID, updateUser);
		Data.saveFile(FileType.USER);
		return true;
	}
	
	/**
	 * Method to update username of existing user account
	 * @param userID
	 * @param text
	 * @return
	 */
	public static boolean updateUsername(int userID, String text) {
		if(Validator.validateUser(userID) == false) {
			return false;
		}
		UserAccount updateUser = SearchUtils.searchUserAccount(userID);
		if(Validator.validateUser(text) == true) {
			return false;
		}
		updateUser.setUsername(text);
		userAccountList.put(userID, updateUser);
		Data.saveFile(FileType.USER);
		return true;
	}
	
	/**
	 * Method to update user's age in existing user account
	 * @param userID
	 * @param num
	 * @return
	 */
	public static boolean updateUserAge(int userID, int num) {
		if(Validator.validateUser(userID)== false) {
			return false;
		}
		UserAccount updateUser = SearchUtils.searchUserAccount(userID);

		updateUser.setAge(num);
		userAccountList.put(userID, updateUser);
		Data.saveFile(FileType.USER);
		return true;
	}
	
	/**
	 * Method to verify user login details with username and password
	 * @param username
	 * @param password
	 * @return
	 */
	public static int validateUserLogin(String username, String password) {
		if(Validator.validateUser(username) == false) {
			return -2;
		}
		
		UserAccount user = SearchUtils.searchUserAccount(username);
		if(!password.equals(user.getPassword())) {
			return -1;
		}
		return user.getUserID();
	}
	
}
