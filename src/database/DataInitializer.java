package database;

import java.util.ArrayList;

import manager.*;
import model.*;
import utils.DateUtils;
import utils.StringToSeat;
import utils.TimeUtils;

public class DataInitializer {
	public static void initialize() {
		initializeCineplex();
		initializeCinema();
		initializeUser();
		initializeHoliday();
		initializeMovie();
		initializeShowStatus();
		initializeReview();
		
	}
	
	private static void initializeReview() {
		ReviewMgr.createMovieReview(0, 0, 2,"Hello");
		ReviewMgr.createMovieReview(0, 1, 3,"Hello");
		ReviewMgr.createMovieReview(0, 2, 4,"Hello");
		
		ReviewMgr.createMovieReview(1, 5, 1,"Hello");
		ReviewMgr.createMovieReview(1, 3, 2,"Hello");
		ReviewMgr.createMovieReview(1, 4, 3,"Hello");
	}
	
	private static void initializeShowStatus() {
		
		DateUtils date1 = new DateUtils(8,11,2022);
		TimeUtils time1 = new TimeUtils(15,24);
		MovieType type1 = MovieType.BLOCKBUSTER;
		//cineplexID, cinemaID, movieID, showDate, showTime, movieType
		ShowStatusMgr.createShowStatus(1, 3, 0, date1, time1,type1);
		
		DateUtils date2 = new DateUtils(12,11,2022);
		TimeUtils time2 = new TimeUtils(9,24);
		MovieType type2 = MovieType.TWOD;
		ShowStatusMgr.createShowStatus(0, 1, 1, date2, time2,type2);
		
		DateUtils date3 = new DateUtils(7,11,2022);
		TimeUtils time3 = new TimeUtils(11,24);
		MovieType type3 = MovieType.THREED;
		ShowStatusMgr.createShowStatus(1, 0, 2, date3, time3,type3);
	}
	
	private static void initializeCineplex() {
		CineplexMgr.createCineplex("Jem");
		CineplexMgr.createCineplex("WestMall");
		CineplexMgr.createCineplex("AMK Hub");
	}
	
	private static void initializeHoliday() {
		DateUtils date = new DateUtils(8,11,2022);
		HolidayMgr.createHoliday("CNY1", date);

		DateUtils date2 = new DateUtils(10,11,2022);
		HolidayMgr.createHoliday("CNY2", date2);
		
		DateUtils date3 = new DateUtils(10,11,2022);
		HolidayMgr.createHoliday("CNYS3", date3);
	}
	
	
	private static void initializeUser() {
		UserAccountMgr.createUserAccount("Kid","12","1234-10","test1@gmail.com",12,false);
		UserAccountMgr.createUserAccount("Elder","34","1234-10","test2@gmail.com",70,true);
		UserAccountMgr.createUserAccount("Man","56","1234-10","test3@gmail.com",35,true);
	}
	
	private static void initializeMovie() {
		
		ArrayList<String> casts = new ArrayList<String>();
		casts.add("The Rock");
		casts.add("Aldis Hodge");
		MovieMgr.createMovie(
				//title
				"Black Adam", 
				//director
				"Jaume Collet-Serra", 
				//casts
				casts, 
				//synopsis
				"Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods - and imprisoned just as quickly - "
				+ "Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.", 
				//duration
				125, 
				//state
				MovieStates.NOW_SHOWING,
				//number of Raters
				10,
				//Overall Rating
				3,
				//Sales
				100
		);
		
		
		
		casts = new ArrayList<String>();
		casts.add("Lupita Nyong'o");
		casts.add("Danai Gurira");
		MovieMgr.createMovie(
				//title
				"Black Panther: Wakanda Forever", 
				//director
				"Ryan Coogler", 
				//casts
				casts, 
				//synopsis
				"Queen Ramonda, Shuri, M'Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T'Challa's death. As the Wakandans strive to embrace their next chapter,"
				+"the heroes must band together with Nakia and Everett Ross to forge a new path for their beloved kingdom.",
				//duration
				161, 
				//state
				MovieStates.NOW_SHOWING,
				//number of Raters
				1,
				//Overall Rating
				5,
				//Sales
				10
		);
		
		casts = new ArrayList<String>();
		casts.add("Vin Diesel");
		casts.add("Kate Winslet");
		MovieMgr.createMovie(
				//title
				"Avatar: The Way of Water TBA", 
				//director
				"James Cameron", 
				//casts
				casts, 
				//synopsis
				"Set more than a decade after the events of the first film,'Avatar: The Way of Water'"+ 
				"begins to tell the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them,"+ 
				"the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
				//duration
				120, 
				//state
				MovieStates.COMING_SOON,
				//number of Raters
				13,
				//Overall Rating
				4.5,
				//Sales
				140
		);
		
		
		casts = new ArrayList<String>();
		casts.add("Allison Williams");
		casts.add("Violet McGraw");
		MovieMgr.createMovie(
				//title
				"MEGAN", 
				//director
				"Gerard Johnstone", 
				//casts
				casts, 
				//synopsis
				"M3GAN is a marvel of artificial intelligence, a lifelike doll that's programmed to be a child's greatest companion and a "
				+ "parent's greatest ally. Designed by Gemma, a brilliant roboticist, M3GAN can listen, watch and learn as it plays the role of friend and teacher, playmate and protector. When Gemma becomes the unexpected caretaker of her 8-year-old niece, "
				+ "she decides to give the girl an M3GAN prototype, a decision that leads to unimaginable consequences.",
				//duration
				120, 
				//state
				MovieStates.COMING_SOON,
				//number of Raters
				0,
				//Overall Rating
				0,
				//Sales
				0
		);
		
		
		casts = new ArrayList<String>();
		casts.add("Salma Hayek");
		casts.add("Olivia Colman");
		MovieMgr.createMovie(
				//title
				"Puss In Boots", 
				//director
				"Joel Crawford", 
				//casts
				casts, 
				//synopsis
				"For the first time in more than a decade, DreamWorks Animation presents a new adventure in the "
				+ "Shrek universe as daring outlaw Puss in Boots discovers that his passion for peril and disregard for safety have taken their toll. Puss has burned through eight of his nine lives, "
				+ "though he lost count along the way. Getting those lives back will send Puss in Boots on his grandest quest yet.",
				//duration
				102, 
				//state
				MovieStates.NO_LONGER_SHOWING,
				//number of Raters
				0,
				//Overall Rating
				0,
				//Sales
				0
		);
		
		casts = new ArrayList<String>();
		casts.add("Yoshitsugu Matsuoka");
		casts.add("Inori Minase");
		MovieMgr.createMovie(
				//title
				"The Quintessential Quintuplets", 
				//director
				"Masato Jinbo", 
				//casts
				casts, 
				//synopsis
				"Hired as a private tutor to the five identical quintuplets for the Nakano’s family, "
				+ "high school student Futaro Uesugi has led the quintuplets: Ichika, Nino, Miku, Yotsuba and Itsuki "
				+ "Nakano to a point where they can graduate and pursue their own dreams. At last, it is the final school festival and "
				+ "Futaro resolved to make this an occasion that they will not regret. He searched within himself for "
				+ "his feelings towards the quintuplets and invites them to meet him in the classroom for an important announcement…",
				//duration
				136, 
				//state
				MovieStates.NO_LONGER_SHOWING,
				//number of Raters
				0,
				//Overall Rating
				0,
				//Sales
				0
		);
	}
	
	private static void initializeCinema() {
		String [] plan1 = new String[5];
		plan1[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan1[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan1[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan1[3] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";	
		plan1[4] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		SeatType [][] seatPlan1 = StringToSeat.strToSeatType(plan1);
		CinemaType type1 = CinemaType.NORMAL;
		CinemaMgr.createCinema(0,type1, seatPlan1, "001");
		
		
		String [] plan2 = new String[5];
		plan2[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan2[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan2[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan2[3] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";	
		plan2[4] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		SeatType [][] seatPlan2 = StringToSeat.strToSeatType(plan2);
		CinemaType type2 = CinemaType.NORMAL;
		CinemaMgr.createCinema(0,type2, seatPlan2, "002");
		
		
		String [] plan3 = new String[5];
		plan3[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan3[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan3[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan3[3] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";	
		plan3[4] = "[    ][    ]   [    ][    ]";
		SeatType [][] seatPlan3 = StringToSeat.strToSeatType(plan3);
		CinemaType type3 = CinemaType.PLATINIUM;
		CinemaMgr.createCinema(0,type3, seatPlan3, "003");
		
		
		String [] plan4 = new String[5];
		plan4[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan4[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan4[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan4[3] = "[    ][    ]   [    ][    ]";	
		plan4[4] = "[    ][    ]   [    ][    ]";
		SeatType [][] seatPlan4 = StringToSeat.strToSeatType(plan4);
		CinemaType type4 = CinemaType.NORMAL;
		CinemaMgr.createCinema(1,type4, seatPlan4, "004");
		
		
		String [] plan5 = new String[5];
		plan5[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan5[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan5[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan5[3] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";	
		plan5[4] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan5[4] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan5[4] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		SeatType [][] seatPlan5 = StringToSeat.strToSeatType(plan5);
		CinemaType type5 = CinemaType.NORMAL;
		CinemaMgr.createCinema(1,type5, seatPlan5, "005");
		
		
		String [] plan6 = new String[5];
		plan6[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan6[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan6[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan6[3] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";	
		plan6[4] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		SeatType [][] seatPlan6 = StringToSeat.strToSeatType(plan6);
		CinemaType type6 = CinemaType.PLATINIUM;
		CinemaMgr.createCinema(1,type6, seatPlan6, "006");
		
		
		String [] plan7 = new String[5];
		plan7[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan7[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan7[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan7[3] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";	
		plan7[4] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		SeatType [][] seatPlan7 = StringToSeat.strToSeatType(plan7);
		CinemaType type7 = CinemaType.NORMAL;
		CinemaMgr.createCinema(2,type7, seatPlan7, "007");
		
		String [] plan8 = new String[5];
		plan8[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan8[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan8[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan8[3] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";	
		plan8[4] = "[ ][ ][    ]   [    ][ ][ ]";
		SeatType [][] seatPlan8 = StringToSeat.strToSeatType(plan8);
		CinemaType type8 = CinemaType.NORMAL;
		CinemaMgr.createCinema(2,type8, seatPlan8, "008");
		
		
		String [] plan9 = new String[5];
		plan9[0] = "      [ ][ ]   [ ][ ][ ][ ]";
		plan9[1] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan9[2] = "[ ][ ][ ][ ]   [ ][ ][ ][ ]";
		plan9[3] = "[    ][    ]   [    ][    ]";	
		plan9[4] = "[    ][    ]   [    ][    ]";
		SeatType [][] seatPlan9 = StringToSeat.strToSeatType(plan9);
		CinemaType type9 = CinemaType.PLATINIUM;
		CinemaMgr.createCinema(2,type9, seatPlan9, "009");
		
	}
}
