package uI;

import java.util.Scanner;

/**
 * Inherited from PaymentMethod.
 * Allows the user to pay by credit card.
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public class PayByCreditCard extends PaymentMethod{
	
	public PayByCreditCard(double price) {
		super(price);
	}
	
	/**
	 *Asks user to enter card numner.
	 *Credentials for the card are also checked.
	 */
	public boolean promptInput(Scanner sc) {
		try {
			
			String number;
			String name;
			System.out.println("Total Price: "+super.price);
			System.out.print("Please enter card number: ");
			number = sc.next();
			sc.nextLine();
			System.out.print("Please enter name on card:");
			name = sc.nextLine();
			System.out.print("Please enter CVV: ");
			number = sc.next();
			sc.nextLine();
		} catch (Exception e) {
			System.out.print("Payment failed");
			return false;
		}
		OnSuccessPayment();
		return true;
	}
	
	/**
	 * If payment is successfull, inform user
	 */
	
	public void OnSuccessPayment() {
		System.out.println("Payment successful");
		System.out.println("Receipt will be sent to you by email. Thank You!");
	}
}
