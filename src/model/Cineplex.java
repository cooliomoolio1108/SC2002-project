package model;

import java.io.Serializable;

public class Cineplex implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Id number of cineplex
	 */
	private int cineplexID;
	/**
	 * Name of the cineplex
	 */
    private String name;
    
    /**
     * Constructor
     * @param cineplexID
     * @param name
     */
    public Cineplex(int cineplexID, String name) {
    	this.cineplexID = cineplexID;
    	this.name = name;
    }
    
    /**
     * Get copy of cineplex instance
     * @param another
     * @return cineplex
     */
    public static Cineplex copy(Cineplex another) {
    	Cineplex cineplex  = new Cineplex(
    			another.getCineplexID(),
    			another.getName()
    	);
    	return cineplex;
    }

    /**
     * Getter of Cineplex ID
     * @return this.cineplexID
     */
	
    public int getCineplexID(){
        return this.cineplexID;
    }
    /**
     * Setter Cineplex ID
     * @param id
     */
    public void setCineplexID(int id){
        this.cineplexID = id;
    }
    /**
     * Getter name of cineplex
     * @return
     */
    public String getName(){
        return this.name;
    }
    /**
     * setter name of cineplex
     * @param name
     */
    public void setName(String name){
        this.name= name;
    }


}
