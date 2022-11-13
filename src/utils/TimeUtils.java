package utils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Helper functions to keep track of time in the application
 * @author Group 4 SS9 
 * @version 1.0
 * @since 2022-11-07
 */

public class TimeUtils implements Serializable{
	private int hour;
    private int minute;

    
    public TimeUtils(int hour, int minute) {
    	this.hour= hour;
    	this.minute = minute;
    }
    public static boolean equal(TimeUtils time1, TimeUtils time2) {
    	boolean eHour = time1.getHour() != time2.getHour();
    	boolean eMinute = time1.getMinute() != time2.getMinute();
    	if(eHour || eMinute) {
    		return false;
    	}
    	return true;
    }
    
    public static TimeUtils LocalTimeToTimeUtils(LocalTime timeNow) {
    	int hour = Integer.parseInt(timeNow.toString().substring(0, 2));
        int minute = Integer.parseInt(timeNow.toString().substring(3, 5));
        TimeUtils time = new TimeUtils(hour, minute);
        return time;
  
    }
   
    /**
     * Print out the time currently
     * @param time
     */
    
    public static void print(TimeUtils time) {
    	String hour = String.valueOf(time.getHour());
    	if(time.getHour()<10) {
    		hour = "0" + hour;
    	}
    	
    	String minute =String.valueOf(time.getMinute());
    	if(time.getMinute() <10) {
    		minute = "0" + minute;
    	}
    	System.out.print(hour+":"+minute);
    }
    /**
     * Getter for hours
     * @return
     */
    public int getHour(){
        return this.hour;
    }
    /**
     * Setter for hours
     * @param hour
     */
    public void setHour(int hour){
        this.hour = hour;
    }
    /**
     * Getter for minutes
     * @return
     */

    public int getMinute(){
        return this.minute;
    }

    /**
     * Setter for minutes
     * @param minute
     */
    public void setMinute(int minute){
        this.minute = minute;
    }
}
