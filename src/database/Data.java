package database;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import model.*;

public class Data {
	
	public static HashMap<Integer, Booking> bookingList = new HashMap<Integer, Booking>();
	public static HashMap<Integer, Movie> movieList = new HashMap<Integer, Movie>();
	public static HashMap<Integer, UserAccount> userAccountList = new HashMap<Integer, UserAccount>();
	public static HashMap<Integer, Holiday> holidayList = new HashMap<Integer, Holiday>();
	public static HashMap<Integer, Cineplex> cineplexList = new HashMap<Integer, Cineplex>();
	public static HashMap<Integer, ShowStatus> showStatusList = new HashMap<Integer, ShowStatus>();
	public static HashMap<Integer, Cinema> cinemaList = new HashMap<Integer, Cinema>();
	public static HashMap<Integer, MovieReview> movieReviewList = new HashMap<Integer, MovieReview>();
	public static HashMap<Integer, MovieRank> movieRankList = new HashMap<Integer, MovieRank>();
	public static TicketPrice ticketPrice = new TicketPrice();
	
	

	
	public static void InitializeData() {
		clearAllData();
		DataInitializer.initialize();
		saveAllFiles();
	}
	
	public static void readAllFiles() {
		if (!readSerializedObject(FileType.BOOKING)) {
            System.out.println("Read bookingList failed");
        }
        if (!readSerializedObject(FileType.CINEMA)) {
            System.out.println("Read cinemaList failed");
        }
        if (!readSerializedObject(FileType.CINEPLEX)) {
            System.out.println("Read cineplexList failed");
        }
        if (!readSerializedObject(FileType.HOLIDAY)) {
            System.out.println("Read holidayList failed");
        }
        if (!readSerializedObject(FileType.MOVIE)) {
            System.out.println("Read movieList failed");
        }
        if (!readSerializedObject(FileType.MOVIE_RANK)) {
            System.out.println("Read movieRankList failed");
        }
        if (!readSerializedObject(FileType.MOVIE_REVIEW)) {
            System.out.println("Read movieReviewList failed");
        }
        if (!readSerializedObject(FileType.SHOW_STATUS)) {
            System.out.println("Read into showStatusList failed");
        }
        if (!readSerializedObject(FileType.TICKET_PRICE)) {
            System.out.println("Read into ticketPriceList failed");
        }
        if (!readSerializedObject(FileType.USER)) {
            System.out.println("Read into userAccountList failed");
        }
        System.out.println("Read All File Done");
	}
	
	public static boolean clearAllData() {
        
	 	bookingList = new HashMap<Integer, Booking>();
        writeSerializedObject(FileType.BOOKING);
        
        cinemaList = new HashMap<Integer, Cinema>();
        writeSerializedObject(FileType.CINEMA);

        cineplexList = new HashMap<Integer, Cineplex>();
        writeSerializedObject(FileType.CINEPLEX);

        holidayList  = new HashMap<Integer, Holiday>();
        writeSerializedObject(FileType.HOLIDAY);
        
        movieList = new HashMap<Integer, Movie>();
        writeSerializedObject(FileType.MOVIE);

        movieRankList = new HashMap<Integer, MovieRank>();
        writeSerializedObject(FileType.MOVIE_RANK);

        movieReviewList = new HashMap<Integer, MovieReview>();
        writeSerializedObject(FileType.MOVIE_REVIEW);
        
        showStatusList = new HashMap<Integer, ShowStatus>();
        writeSerializedObject(FileType.SHOW_STATUS);
        
        ticketPrice = new TicketPrice();
        writeSerializedObject(FileType.TICKET_PRICE);
        
        return true;
    }
	
	public static void saveFile(FileType fileType) {
		writeSerializedObject(fileType);
	}
	
	public static void saveAllFiles() {
		saveFile(FileType.BOOKING);
		saveFile(FileType.CINEMA);
		saveFile(FileType.CINEPLEX);
		saveFile(FileType.HOLIDAY);
		saveFile(FileType.MOVIE);
		saveFile(FileType.MOVIE_RANK);
		saveFile(FileType.MOVIE_REVIEW);
		saveFile(FileType.SHOW_STATUS);
		saveFile(FileType.TICKET_PRICE);
		saveFile(FileType.USER);
	}
	
	private static boolean readSerializedObject(FileType fileType) {
        String fileExtension = ".dat";
        String filePath = "src/database/dataFolder/"+ fileType.fileName + fileExtension;
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            if (!(object instanceof HashMap) && !(object instanceof TicketPrice)) {
                System.out.println(fileType.fileName);
                objectInputStream.close();
                return false;
            }
            // Read into database
            if (fileType == FileType.BOOKING) {
                bookingList = (HashMap<Integer, Booking>) object;
            } else if (fileType == FileType.CINEMA) {
                cinemaList = (HashMap<Integer, Cinema>) object;
            } else if (fileType == FileType.CINEPLEX) {
                cineplexList = (HashMap<Integer, Cineplex>) object;
            } else if (fileType == FileType.HOLIDAY) {
               holidayList  = (HashMap<Integer, Holiday>) object;
            } else if (fileType == FileType.MOVIE) {
                movieList = (HashMap<Integer, Movie>) object;
            } else if (fileType == FileType.MOVIE_RANK) {
            	movieRankList = (HashMap<Integer, MovieRank>) object;
            } else if (fileType == FileType.MOVIE_REVIEW) {
            	movieReviewList = (HashMap<Integer, MovieReview>) object;
            } else if (fileType == FileType.SHOW_STATUS) {
            	showStatusList = (HashMap<Integer, ShowStatus>) object;
            } else if(fileType == FileType.TICKET_PRICE) {
            	ticketPrice = (TicketPrice) object;
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (EOFException err) {
            System.out.println("Warning: " + err.getMessage());
            if (fileType == FileType.BOOKING) {
                bookingList = new HashMap<Integer, Booking>();
            } else if (fileType == FileType.CINEMA) {
                cinemaList = new HashMap<Integer, Cinema>();
            } else if (fileType == FileType.CINEPLEX) {
                cineplexList = new HashMap<Integer, Cineplex>();
            } else if (fileType == FileType.HOLIDAY) {
               holidayList  = new HashMap<Integer, Holiday>();
            } else if (fileType == FileType.MOVIE) {
                movieList = new HashMap<Integer, Movie>();
            } else if (fileType == FileType.MOVIE_RANK) {
            	movieRankList = new HashMap<Integer, MovieRank>();
            } else if (fileType == FileType.MOVIE_REVIEW) {
            	movieReviewList = new HashMap<Integer, MovieReview>();
            } else if (fileType == FileType.SHOW_STATUS) {
            	showStatusList = new HashMap<Integer, ShowStatus>();
            } else if(fileType == FileType.TICKET_PRICE) {
            	ticketPrice = new TicketPrice();
            }
        } catch (IOException err) {
            err.printStackTrace();
            return false;
        } catch (ClassNotFoundException err) {
            err.printStackTrace();
            return false;
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
            return false;
        }
        return true;
    }
	
	
	 private static boolean writeSerializedObject(FileType fileType) {
	        String fileExtension = ".dat";
	        String filePath = "src/database/dataFolder/" + fileType.fileName + fileExtension;
	        try {
	            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	            if (fileType == FileType.BOOKING) {
	                objectOutputStream.writeObject(bookingList);
	            }else if (fileType == FileType.CINEMA) {
	                objectOutputStream.writeObject(cinemaList);
	            } else if (fileType == FileType.CINEPLEX) {
	                objectOutputStream.writeObject(cineplexList);
	            } else if (fileType == FileType.HOLIDAY) {
	                objectOutputStream.writeObject(holidayList);
	            } else if (fileType == FileType.MOVIE) {
	                objectOutputStream.writeObject(movieList);
	            } else if (fileType == FileType.MOVIE_RANK) {
	                objectOutputStream.writeObject(movieRankList);
	            } else if (fileType == FileType.MOVIE_REVIEW) {
	                objectOutputStream.writeObject(movieReviewList);
	            }else if (fileType == FileType.SHOW_STATUS) {
	                objectOutputStream.writeObject(showStatusList);
	            } else if (fileType == FileType.TICKET_PRICE) {
	                objectOutputStream.writeObject(ticketPrice);
	            } else if (fileType == FileType.USER) {
	                objectOutputStream.writeObject(userAccountList);
	            }
	            objectOutputStream.close();
	            fileOutputStream.close();
	            return true;
	        } catch (Exception err) {
	            System.out.println("Error: " + err.getMessage());
	            return false;
	        }
	 }

}
