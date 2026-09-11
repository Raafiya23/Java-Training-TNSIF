package exceptionhandling.daysix;

import java.util.Scanner;

@SuppressWarnings("serial")
class InsufficientBalanceException extends Exception {
	
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

public class ATM {

	static void withdraw(double balance, double amount) throws Exception {
		
		if(amount <= 0) {
			throw new IllegalArgumentException("Invalid withdrawl amount");
		}
		
		if(amount > balance) {
			throw new IllegalArgumentException("Insufficient balance!");
		}
		
		System.out.println("Withdrawl Successful!");
		System.out.println("Remaining Balance: ₹" + (balance - amount));
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double balance = 5000;
		
		try {
			System.out.print("Enter withdrawl amount: ");
			double amount = sc.nextDouble();
			
			withdraw(balance, amount);
		} catch (InsufficientBalanceException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid input!");
		} finally {
			System.out.println("Thank you for using the ATM.");
			sc.close();
		}
		
	}

}
