package model;

import java.io.Serializable;

public class TicketPrice implements Serializable{
    /**
	 * Java Serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Price of ticket from monday to wednesday
	 */
	private double monWed = 8.5;
	/**
	 * Price of ticket from monday to wednesday in 3D
	 */
	private double monWed3d = 11;
	/**
	 * Price of ticket on thursday
	 */
	private double thu = 9.5;
	/**
	 * Price of ticket on thursday in 3D
	 */
	private double thu3d = 11;
	/**
	 * Price of ticket on Friday
	 */
	private double fri  =9.5;
	/**
	 * Price of ticket on Friday eve
	 */
	private double friEve = 9.5;
	/**
	 * Price of ticket on Friday in 3D
	 */
	private double fri3d =9.5;
	/**
	 * Price of ticket on Friday eve in 3D
	 */
	private double friEve3d = 15;
	/**
	 * Price of ticket on weekends
	 */
	private double weekEnd = 11;
	/**
	 * Price of ticket on weekends in 3d
	 */
	private double weekEnd3d = 15;
	/**
	 * Price of ticket for elderly in weekdays
	 */
    private double elderlyWeekDay = 4;
    /**
     * Price of ticket for students in weekday
     */
    private double studentWeekDay = 7;
    /**
     * Price of ticket for student in weekdays in 3d
     */
    private double studentWeekDay3d = 9;
    /**
     * Price of addition charge for blockbuster
     */
    private double blockBusterAdd = 1;
    /**
     * Price of addition charge for platinum cinema type
     */
    private double platPriceAdd = 2;
    /**
     * Price of addition charge for Gold cinema type
     */
    private double goldPriceAdd = 1;
    /**
     * Price of addition charge for holidays
     */
    private double holidayAdd = 2;
    /**
     * Price for card payment
     */
    private double Card = 9.5;
   /**
    * Constructor
    */
    public TicketPrice() {}
    
    /**
     * Getter and return MonWed price
     * @return monWed
     */
	public double getMonWed() {
		return monWed;
	}

	/**
	 * Setter MonWed price
	 * @param monWed
	 */
	public void setMonWed(double monWed) {
		this.monWed = monWed;
	}

	/**
	 * Getter and return MonWed in 3D price
	 * @return monWed 3d
	 */
	public double getMonWed3d() {
		return monWed3d;
	}

	/**
	 * Setter MonWed in 3D price
	 * @param monWed3d
	 */
	public void setMonWed3d(double monWed3d) {
		this.monWed3d = monWed3d;
	}

	/**
	 * Get and return thursday price
	 * @return thu
	 */
	public double getThu() {
		return thu;
	}

	/**
	 * Set thursday price
	 * @param thu
	 */
	public void setThu(double thu) {
		this.thu = thu;
	}

	/**
	 * get and return thursday in 3d price
	 * @return
	 */
	public double getThu3d() {
		return thu3d;
	}

	/**
	 * Set thursday 3d price
	 * @param thu3d
	 */
	public void setThu3d(double thu3d) {
		this.thu3d = thu3d;
	}

	/**
	 * get and return friday price 
	 * @return fri
	 */
	public double getFri() {
		return fri;
	}

	/**
	 * Set friday price
	 * @param fri
	 */
	public void setFri(double fri) {
		this.fri = fri;
	}

	/**
	 * Get friday eve price
	 * @return friEve
	 */
	public double getFriEve() {
		return friEve;
	}

	/**
	 * Set Friday eve price
	 * @param friEve
	 */
	public void setFriEve(double friEve) {
		this.friEve = friEve;
	}

	/**
	 * get and return friday in 3d price
	 * @return
	 */
	public double getFri3d() {
		return fri3d;
	}

	/**
	 * set friday in 3d price
	 * @param fri3d
	 */
	public void setFri3d(double fri3d) {
		this.fri3d = fri3d;
	}

	/**
	 * get and return friday eve in 3d price
	 * @return
	 */
	public double getFriEve3d() {
		return friEve3d;
	}

	/**
	 * Set friday eve in 3d price
	 * @param friEve3d
	 */
	public void setFriEve3d(double friEve3d) {
		this.friEve3d = friEve3d;
	}

	/**
	 * get weekend price
	 * @return weekEnd
	 */
	public double getWeekEnd() {
		return weekEnd;
	}

	/**
	 * set weekend price 
	 * @param weekEnd
	 */
	public void setWeekEnd(double weekEnd) {
		this.weekEnd = weekEnd;
	}

	/**
	 * get and return weekend in 3d price
	 * @return
	 */
	public double getWeekEnd3d() {
		return weekEnd3d;
	}

	/**
	 * set weekend in 3d price
	 * @param weekEnd3d
	 */
	public void setWeekEnd3d(double weekEnd3d) {
		this.weekEnd3d = weekEnd3d;
	}

	/**
	 * get and return elderly in weekday price
	 * @return elderlyWeekDay
	 */
	public double getElderlyWeekDay() {
		return elderlyWeekDay;
	}

	/**
	 * set Elderly weekday price
	 * @param elderlyWeekDay
	 */
	public void setElderlyWeekDay(double elderlyWeekDay) {
		this.elderlyWeekDay = elderlyWeekDay;
	}

	/**
	 * get and return student weekday price
	 * @return studentWeekDay
	 */
	public double getStudentWeekDay() {
		return studentWeekDay;
	}

	/**
	 * set student weekday price
	 * @param studentWeekDay
	 */
	public void setStudentWeekDay(double studentWeekDay) {
		this.studentWeekDay = studentWeekDay;
	}

	/**
	 * get student weekday in 3d price
	 * @return studentWeekDay3d
	 */
	public double getStudentWeekDay3d() {
		return studentWeekDay3d;
	}

	/**
	 * set student weekday in 3d price
	 * @param studentWeekDay3d
	 */
	public void setStudentWeekDay3d(double studentWeekDay3d) {
		this.studentWeekDay3d = studentWeekDay3d;
	}

	/**
	 * get blockbuster price addition
	 * @return blocBusterAdd
	 */
	public double getBlockBusterAdd() {
		return blockBusterAdd;
	}

	/**
	 * set blockbuster price addtition
	 * @param blockBusterAdd
	 */
	public void setBlockBusterAdd(double blockBusterAdd) {
		this.blockBusterAdd = blockBusterAdd;
	}

	/**
	 * get and return platinum cinema type price addition
	 * @return
	 */
	public double getPlatPriceAdd() {
		return platPriceAdd;
	}

	/**
	 * set platimun price addtion 
	 * @param platPriceAdd
	 */
	public void setPlatPriceAdd(double platPriceAdd) {
		this.platPriceAdd = platPriceAdd;
	}

	/**
	 * get and return gold cinema type addition
	 * @return goldPriceAdd
	 */
	public double getGoldPriceAdd() {
		return goldPriceAdd;
	}
	
	/**
	 * set gold price addition
	 * @param goldPriceAdd
	 */
	public void setGoldPriceAdd(double goldPriceAdd) {
		this.goldPriceAdd = goldPriceAdd;
	}

	/**
	 * get and return holiday price addition
	 * @return holidayAdd
	 */
	public double getHolidayAdd() {
		return holidayAdd;
	}

	/**
	 * set holiday price addition
	 * @param holidayAdd
	 */
	public void setHolidayAdd(double holidayAdd) {
		this.holidayAdd = holidayAdd;
	}

	/**
	 * get card payment price
	 * @return Card
	 */
	public double getCard() {
		return Card;
	}

	/**
	 * set card price
	 * @param card
	 */
	public void setCard(double card) {
		Card = card;
	}

	


    
    
}
