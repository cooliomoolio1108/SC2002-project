package uI;

import java.util.Scanner;

/**
 * PaymentMethod abstract class to be used in PaymentApp.
 * @author Group 4 SS9
 * @version 1.0
 * @since 2022-11-07
 */

public abstract class PaymentMethod {
	public double price;
	
	public PaymentMethod(double price) {
		this.price = price;
	}
	public abstract boolean promptInput(Scanner sc);
	public abstract void OnSuccessPayment();
}
