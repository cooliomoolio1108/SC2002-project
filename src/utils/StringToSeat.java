package utils;
import model.*;

/**
 * Helper functions for the seats in the ciniplex
 * @author Group 4 SS9 
 * @version 1.0
 * @since 2022-11-07
 */

public class StringToSeat {
	/**
	 * Converts string to seat type
	 * @param arr
	 * @return Seat type
	 */
	public static SeatType[][] strToSeatType(String [] arr){
		int counter=0;
		for(int j=0;j<arr[0].length();j+=3) {
			counter++;
		}
		SeatType [][] type = new SeatType[arr.length][counter];
		counter=0;
		for(int i=0;i<arr.length;i++) {
			counter=0;
			for(int j=0;j<arr[i].length();j+=3) {
				String sub = arr[i].substring(j,j+3);
				if(sub.equals("   ")) {
					type[i][counter] = SeatType.NOT_EXIST;
				}
				
				if(sub.equals("[ ]")) {
					type[i][counter] = SeatType.SINGLE;
				}
				
				if(sub.equals("[X]")) {
					type[i][counter] = SeatType.SINGLE_T;
				}
				
				if(sub.equals("[  ")) {
					type[i][counter] = SeatType.COUPLE_1;
				}
				
				if(sub.equals("  ]")) {
					type[i][counter] = SeatType.COUPLE_2;
				}
				
				if(sub.equals("[X ")) {
					type[i][counter] = SeatType.COUPLE_1_T;
				}
				
				if(sub.equals(" X]")) {
					type[i][counter] = SeatType.COUPLE_2_T;
				}
				counter++;
			}
		}
		return type;
		
	}
	/**
	 * Prints of all the seats in the ciniplex for the user to choose seats
	 * @param type
	 */
	public static void printSeat(SeatType [][] type) {
//		for(int i =0;i<type[0].length;i++) {
//			System.out.print("===");
//		}
//		System.out.println();
//		int middle = type[0].length/2;
//		int start = middle-4;
//		int end = middle+5;
//		for(int i =0;i<type[0].length;i++) {
//			if(i==start) {
//				System.out.print("| SCREEN |");
//				i = end;
//				continue;
//			}
//			System.out.print("---");
//		}
		
		System.out.print("===================================\n");
		System.out.print("____|         SCREEN          |____\n");
		System.out.println();
		for(int i=0;i<type.length;i++) {
			System.out.print(i+"|  ");
			for(int j=0; j<type[i].length;j++) {
				SeatType buffer = type[i][j];
				if(buffer == SeatType.NOT_EXIST) {
					System.out.print("   ");
				}
				
				if(buffer == SeatType.SINGLE) {
					System.out.print("[ ]");
				}
				
				if(buffer == SeatType.SINGLE_T) {
					System.out.print("[X]");
				}
				
				if(buffer == SeatType.COUPLE_1) {
					System.out.print("[  ");
				}
				
				if(buffer == SeatType.COUPLE_2) {
					System.out.print("  ]");
				}
				
				if(buffer == SeatType.COUPLE_1_T) {
					System.out.print("[X ");
				}
				
				if(buffer == SeatType.COUPLE_2_T) {
					System.out.print(" X]");
				}
				
			}
			System.out.println("  |"+ i);
		}
		System.out.print("\n____________|ENTRANCE|_____________\n");
		System.out.print("===================================");
//		for(int i =0;i<type[0].length;i++) {
//			System.out.print("===");
//		}
		System.out.println();
		System.out.print(" |  ");
		String alpha = "ABCDEFGHIJKLMNOPQRST";
		for(int i=0;i<type[0].length;i++) {
			System.out.print(" "+alpha.charAt(i)+" ");
		}
		System.out.print("  |");
		System.out.println();
	}
}
