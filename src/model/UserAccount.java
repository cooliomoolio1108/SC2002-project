package model;

import java.io.Serializable;

public class UserAccount implements Serializable{
	/**
	 * Java Serializable
	 */
	private static final long serialVersionUID = 2L;
	/**
	 * Id number of user
	 */
	private int userID;
	/**
	 * User name of user account
	 */
	private String username;
	/**
	 * password of user account
	 */
    private String password;
    /**
     * mobile number of user in useraccount
     */
    private String mobileNumber;
    /**
     * email of user in user account
     */
    private String email;
    /**
     * age of user in user account
     */
    private int age;
    /**
     * member status
     * 1 is yes, 0 is no 
     */
    private boolean isMember;
    
    /**
     * Constructor
     * @param userID
     * @param username
     * @param password
     * @param mobileNumber
     * @param email
     * @param age
     * @param member
     */
    public UserAccount(int userID,String username,String password,String mobileNumber,String email,int age, boolean member) {
    		
    	this.userID = userID;
    	this.username=username;
    	this.password=password;
    	this.mobileNumber=mobileNumber;
    	this.email=email;
    	this.age=age;
    	this.isMember = member;
    }
    
    /**
     * Get and return a copy of the User Account
     * @param another
     * @return user
     */
    public static UserAccount copy(UserAccount another) {
    	UserAccount user = new UserAccount(
    			another.getUserID(),
    			another.getUsername() ,
    			another.getPassword(),
    			another.getMobileNumber(),
    			another.getEmail(),
    			another.getAge(),
    			another.getIsMember()
    	);
    	return user;
    }
    
    /**
     * Set mobile number of user in this user account
     * @param number
     */
    public void setMobileNumber(String number){
        this.mobileNumber =  number;
    }
    
    /**
     * Get and return mobile number of user in this user account
     * @return this.mobileNumber
     */
    public String getMobileNumber(){
        return this.mobileNumber;
    }

    /**
     * Get and return username of this user account
     * @return this.username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Set username of this user account
     * @param name
     */
    public void setUsername(String name ){
        this.username = name;
    }

    /**
     * get and return password of this user account
     * @return this.password
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Set password of this user account
     * @param password
     */
    public void setPassword(String password ){
        this.password = password;
    }

    /**
     * get and return email of user in this user account
     * @return this.email
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * set email of usser in this user account
     * @param email
     */
    public void setEmail(String email ){
        this.email = email;
    }

    /**
     * get and return age of user in this user account
     * @return
     */
    public int getAge(){
        return this.age;
    }

    /**
     * set age of user in this user account
     * @param age
     */
    public void setAge(int age ){
        this.age = age;
    }

    /**
     * get user id of user in this user account
     * @return this.userID
     */
    public int getUserID(){
        return this.userID;
    }

    /**
     * set user id of user in this user account
     * @param id
     */
    public void setUserID(int id ){
        this.userID = id;
    }

    /**
     * get and return member status of user in this user account
     * @return isMember
     */
	public boolean getIsMember(){
		return isMember;
	}

	/**
	 * set member status in this user account
	 * @param member
	 */
	public void setIsMember(boolean member) {
		this.isMember = member;
	}
}
