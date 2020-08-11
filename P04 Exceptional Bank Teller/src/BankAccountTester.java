//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P04 Exceptional Bank Teller
// Files:           BankAccount.java, BankTeller.java, BankTellerTester.java,
//									BankAccountTester.java
// Course:          COMP SCI 300 FALL 2019
//
// Author:          Yucheng Qiu
// Email:           yqiu56@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NONE
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:   
// Online Sources:  
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.zip.DataFormatException;

/**
 * This class represents a tester for the BankAccount class's public behaviors.
 * 
 * @author Yucheng Qiu
 * @version 1.0
 * @since 2019-10-2
 */
public class BankAccountTester {

	/**
	 * Calls the different test methods
	 * @param args input arguments
	 */
	public static void main(String[] args){
		
		if(!testBankAccountConstructorNotValidInitialBalance())
			System.out.println
			("testBankAccountConstructorNotValidInitialBalance Not Pass");
		
		if(!testBankAccountConstructorValidInitialBalance())
			System.out.println("testBankAccountConstructorValidInitialBalance Not"
			+ " Pass");
		
		if(!testBankAccountEquals())
			System.out.println("testBankAccountEquals Not Pass");
		
		if(!testBankAccountDepositNegativeAmount())
			System.out.println("testBankAccountDepositNegativeAmount Not Pass");
		
		if(!testBankAccountWithdrawInvalidAmount())
			System.out.println("testBankAccountWithdrawInvalidAmount Not Pass");
		
		if(!testBankAccountWithdrawLargerOfBalanceAmount())
			System.out.println("testBankAccountWithdrawLargerOfBalanceAmount Not "
			+ "Pass");
		
		if(!testBankAccountWithdrawValidAmount())
			System.out.println("testBankAccountWithdrawValidAmount Not Pass");
		
	}
	
	/**
	 * Calls the constructor of BankAccount class to create a new BankAccount
	 * object with a given id and a valid initial balance (greater of equal to
	 * 10). Checks whether the new account is created with the provided account
	 * id and balance. It checks also that the list of transactions of the
	 * created account contains only one transaction /"1 " + the initial balance/
	 * @return true when this test verifies a correct functionality, and false
	 * otherwise.
	 */
	public static boolean testBankAccountConstructorValidInitialBalance() {
		
		BankAccount[] newAccount = new BankAccount[2];
		
		newAccount[0] = new BankAccount("Wilson",400);
		
		newAccount[1] = new BankAccount("Alice", 50000);
		
		//test the initial balance and id
		if(newAccount[0].getBalance() != 400 || newAccount[0].getID() != "Wilson")
			return false;
		if(newAccount[1].getBalance() != 50000 || newAccount[1].getID() != "Alice")
			return false;
		
		//test the transaction
		if(!newAccount[0].getMostRecentTransactions()[0].equals("1 400"))
			return false;
		if(!newAccount[1].getMostRecentTransactions()[0].equals("1 50000"))
			return false;
		
		//test more recent transactions
		for(int i = 1; i < 5; i++) {
			
			if(newAccount[0].getMostRecentTransactions()[i] != null) return false;
			
			if(newAccount[1].getMostRecentTransactions()[i] != null) return false;
			
		}
		
		return true;
	}
	
	/**
	 * This method checks whether the BankAccount constructor throws an
	 * IllegalArgumentException when it is passed a balance smaller than 10.
	 * @return true when this test verifies a correct functionality, and false
	 * otherwise.
	 */
	public static boolean testBankAccountConstructorNotValidInitialBalance() {
		
		try {
			
			BankAccount newAccount;
			
			newAccount = new BankAccount("Isaac",3);
			
			
		} catch (java.lang.IllegalArgumentException e) {
			
			//check whether  IllegalArgumentException is thrown
			if(!e.getMessage().equals("initBalance is less than 10"))
				return false;
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Checks whether BankAccount.equals() method returns true when it compares
	 * a bank account to another one having the same account identifier (case
	 * sensitive comparison); and it returns false otherwise.
	 * @return true when this test verifies a correct functionality, and
	 * false otherwise.
	 */
	public static boolean testBankAccountEquals() {
		
		BankAccount newAccount1 = new BankAccount("Chambers", 900000);
		
		BankAccount newAccount2 = new BankAccount("Aubameyang", 1000000);
		
		//Test equals() for different account
		if(newAccount1.equals(newAccount2)) return false;
		
		//Test equals() for the same account
		if(!newAccount1.equals(newAccount1)) return false;
		
		return true;
		
	}
	
	/**
	 * Checks whether BankAccount.withdraw() method throws a DataFormatException
	 * when it is passed a negative number or a number not multiple of 10. The
	 * account balance should not change after the withdraw() method returns.
	 * @return true when this test verifies a correct functionality, and false
	 * otherwise.
	 */
	public static boolean testBankAccountWithdrawInvalidAmount() {
		
		BankAccount newaccount = new BankAccount("Lacazette", 8900);
		
		// Whether the DataFormatException is detected
		boolean DetectNegativeIInput = false;
		
		boolean DetectNotMultipleOfTenInput = false;
		
		try {
			
			newaccount.withdraw(-930);
			
		} catch (java.util.zip.DataFormatException e) {
			
			if(!e.getMessage().equals("The Withdraw Amount is negative"))
				return false;
			
			if(newaccount.getBalance() != 8900) return false;
			
			DetectNegativeIInput = true;
			
		}
		
		try {
			
			newaccount.withdraw(1212);
			
		} catch (java.util.zip.DataFormatException e) {
			
			if(!e.getMessage().equals("The Withdraw Amount is not a multiple of 10"))
				return false;
			
			if(newaccount.getBalance() != 8900) return false;
			
			DetectNotMultipleOfTenInput = true;
			
		}
		
		if(DetectNegativeIInput && DetectNotMultipleOfTenInput) return true;
		
		return false;
	}
	
	/**
	 * Checks whether BankAccount.withdraw() method throws an
	 * IllegalStateException when it is passed a number larger than the account's
	 * balance. The account balance should not change after that withdraw()
	 * method call returns.
	 * @return true when this test verifies a correct functionality, and false
	 * otherwise.
	 */
	public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {
		
		BankAccount newaccount = new BankAccount("Ramsey", 3600);
		
		// whether IllegalExcepetion exists
		boolean IllegalExcepetionExists = false;
		
		try {
			
			newaccount.withdraw(7000);
			
		} catch (java.lang.IllegalStateException e) {
			
			if(!e.getMessage().equals("No Enough Balance in the Account"))
				return false;
			
			if(newaccount.getBalance() != 3600) return false;
			
			IllegalExcepetionExists = true;
			
		} catch (java.util.zip.DataFormatException e) {
			
			return false;
			
		}
		
		if(IllegalExcepetionExists) return true;
		
		return false;
		
	}
	
	/**
	 * Checks whether BankAccount.withdraw() method returns without any exception
	 * when it is passed a positive number smaller than the account's balance.
	 * The withdrawal amount should be subtracted from the balance after the
	 * withdraw() method call returns.
	 * @return true when this test verifies a correct functionality, and
	 * false otherwise.
	 */
	public static boolean testBankAccountWithdrawValidAmount() {
		
		BankAccount newaccount = new BankAccount("Ramsey", 3600);
		
		// if exception exists, return false
		try {
			
			newaccount.withdraw(700);
			
		} catch (java.lang.IllegalStateException e) {
			
			return false;
			
		} catch (java.util.zip.DataFormatException e) {
			
			return false;
			
		}
		
		// check the remaining balance
		if(newaccount.getBalance() != 3600 - 700) return false;

		return true;
		
	}
	
	/**
	 * Checks whether BankAccount.deposit() method throws an
	 * IllegalArgumentException when it is passed a negative number. The balance
	 * of the bank account should not change after the method call returns.
	 * @return true when this test verifies a correct functionality, and false
	 * otherwise.
	 */
	public static boolean testBankAccountDepositNegativeAmount() {
		
		BankAccount newAccount = new BankAccount("Sokratic",9000);
		
		try {
			
			newAccount.deposit(-40);
			
		} catch (java.lang.IllegalArgumentException e) {
			
			if(!e.getMessage().equals("deposit amount is negative"))
				return false;
			
			if(newAccount.getBalance() != 9000) return false;
			
			return true;
			
		}
		
		//if no exception exists, return false
		return false;
	}
	
}
