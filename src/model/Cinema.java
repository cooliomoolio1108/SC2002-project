package model;

import java.io.Serializable;

public class Cinema implements Serializable{
 
    /**
	 * Java Serialize
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Cinema ID for this cinema
	 */
	private int cinemaID;
	
	/**
	 * CineplexID
	 */
    private int cineplexID;
    
    /**
     * CinemaCode
     */
    private String cinemaCode;
    
    /**
     * CinemaType
     */
    private CinemaType cinemaType;
    
    /**
     * SeatPlan
     */
    private SeatType[][] seatPlan;
    
    
    /**
     * Constructor 
     * @param cinemaID
     * @param cineplexID
     * @param type
     * @param seatPlan
     * @param cinemaCode
     */
    public Cinema(int cinemaID, int cineplexID, CinemaType type, SeatType[][] seatPlan, String cinemaCode) {
    	this.cinemaID = cinemaID;
    	this.cineplexID = cineplexID;
    	this.cinemaType = type;
    	this.seatPlan = seatPlan;
    	this.cinemaCode = cinemaCode;
    }
    
    /**
     * Get copy of Cinema instance
     * @param another
     * @return
     */
    public static Cinema copy(Cinema another) {
    	Cinema cinema = new Cinema(
    			another.getCinemaID(),
    			another.getCineplexID(),
    			another.getCinemaType(),
    			another.getSeatPlan(),
    			another.getCinemaCode()
    	);
    	return cinema;
    }
    
    /**
     * Getter CinemaCode of this Cinema
     * @return 
     */
    public String getCinemaCode() {
    	return this.cinemaCode;
    }
    
    /**
     * Setter CinemaCode of this Cinema
     * @param id
     */
    public void setCinemaCode(String code) {
    	this.cinemaCode = code;
    }
    
    /**
     * Setter CinemaType of this Cinema
     * @param id
     */
    public void setCinemaType(CinemaType type) {
    	this.cinemaType = type;
    }
    
    /**
     * Getter CinemaType of this Cinema
     * @return
     */
    public CinemaType getCinemaType() {
    	return this.cinemaType;
    }
    
    /**
     * Getter SeatPlan of this cinema
     * @return
     */
    public SeatType[][] getSeatPlan(){
    	return this.seatPlan;
    }
    
    /**
     * Setter SeatPlan of this cinema
     * @param id
     */
    public void setSeatPlan(SeatType[][] seatPlan) {
    	this.seatPlan = seatPlan;
    }
    
    /**
     * Setter CineplexID of this Cinema
     * @param id
     */
    public void setCineplexID(int id) {
    	this.cineplexID =id;
    }
    
    /**
     * Getter  CineplexID of this Cinema
     * @return
     */
    public int getCineplexID() {
    	return this.cineplexID;
    }
    
    
    /**
     * Getter CinemaID of this Cinema
     * @return
     */
    public int getCinemaID() {
    	return this.cinemaID;
    }
    
    /**
     * Setter CinemaID of this Cinema
     * @param id
     */
    public void setCinemaID(int id) {
    	this.cinemaID = id;
    }

}
