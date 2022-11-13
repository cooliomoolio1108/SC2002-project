package manager;

import database.Data;
import database.FileType;
import model.TicketPrice;
/**
 * Ticket Price Manager Class to manage ticket price processes
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 *
 */
public class TicketPriceMgr {
	/**
	 * Ticket price object
	 */
	private static TicketPrice ticketPrice = Data.ticketPrice;

	/**
	 * Method to get and return ticket price
	 * @return ticketPrice
	 */
    public static TicketPrice getTicketPrice() {
    	return ticketPrice;
    }
    
    /**
     * Method to update ticketPrice
     * method code determines which pricing to take
     * @param methodCode
     * @param num
     * @return
     */
	public static boolean updateTicketPrice(int methodCode, double num) {
		switch(methodCode) {
			case 0:
				ticketPrice.setMonWed(num);
				break;
			case 1:
				ticketPrice.setMonWed3d(num);
				break;
			case 2:
				ticketPrice.setThu(num);
				break;
			case 3:
				ticketPrice.setThu3d(num);
				break;
			case 4:
				ticketPrice.setFri(num);
				break;
			case 5:
				ticketPrice.setFri3d(num);
				break;
			case 6:
				ticketPrice.setFriEve(num);
				break;
			case 7:
				ticketPrice.setFri3d(num);
				break;
			case 8:
				ticketPrice.setWeekEnd(num);
				break;
			case 10:
				ticketPrice.setWeekEnd3d(num);
				break;
			case 11:
				ticketPrice.setElderlyWeekDay(num);
				break;
			case 12:
				ticketPrice.setStudentWeekDay(num);
				break;
			case 13:
				ticketPrice.setStudentWeekDay3d(num);
				break;
			case 14:
				ticketPrice.setBlockBusterAdd(num);
				break;
			case 15:
				ticketPrice.setPlatPriceAdd(num);
				break;
			case 16:
				ticketPrice.setGoldPriceAdd(num);
				break;
			case 17:
				ticketPrice.setHolidayAdd(num);
				break;
			case 18:
				ticketPrice.setCard(num);
				break;
			default:
				return false;
		}

		Data.saveFile(FileType.TICKET_PRICE);
		return true;
	}
}
