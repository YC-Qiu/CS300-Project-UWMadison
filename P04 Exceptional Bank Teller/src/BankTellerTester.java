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
import java.io.File;

/**
 * This class is a tester for the BankTeller class's public behaviors
 * 
 * @author Yucheng Qiu
 * @version 1.0
 * @since 2019-10-2
 */
public class BankTellerTester {

	/**
	 * Calls the test methods defined in this BankTellerTester class
	 * @param args input arguments
	 */
	public static void main(String[] args) {
		
		if(!testBankTellerAddBankAccountUsedIdentifier())
			System.out.println("testBankTellerAddBankAccountUsedIdentifier Not "
			+ "Pass");
		
		if(!testBankTellerConstructor())
			System.out.println("testBankTellerConstructor Not Pass");
		
		if(!testBankTellerLoadTransactionsFileNotFound())
			System.out.println("testBankTellerLoadTransactionsFileNotFound");

	}
	
	/**
	 * Checks whether the constructor of BankTeller class creates a
	 * new BankTeller object with an empty ArrayList of bank accounts.
	 * @return true when this test verifies a correct functionality,
	 * and false otherwise.
	 */
	public static boolean testBankTellerConstructor() {
		
		BankTeller newTeller = new BankTeller();
		
		if(newTeller.getAccountsCount() != 0 ) return false;
		
		return true;
	}
	
	/**
	 * Checks whether the BankTeller.addBankAccount() method throws an
	 * IllegalStateException when it is passed a bank account with an identifier
	 * already used.
	 * @return true when this test verifies a correct functionality, and false
	 * otherwise.
	 */
	public static boolean testBankTellerAddBankAccountUsedIdentifier() {
		
		BankTeller newTeller = new BankTeller();
		
		BankAccount account1 = new BankAccount("ShitKane", 4000);
		
		newTeller.addBankAccount(account1);
		
		BankAccount account2 = new BankAccount("ShitKane", 90000);
		
		try {
			
			newTeller.addBankAccount(account2);
			
		} catch (java.lang.IllegalStateException e) {
			// TODO: handle exception
			if(e.getMessage() != "the accountID of newAccount is used by another"
				+ " account") return false;
			
			return true;
		}
		// if no exception is detected, return false
		return false;
	}
	
	/**
	 * This method checks whether the BankTeller.loadTransactions() method that
	 * takes a File parameter throws a FileNotFoundException, when it is passed
	 * a File object that does not correspond to an actual file within the file
	 * system, and a non null reference of type BankAccount.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankTellerLoadTransactionsFileNotFound() {
		
		BankTeller newTeller = new BankTeller();
		
		BankAccount newaccount = new BankAccount("NicolaPepe", 8000);
		
		// A file that doesn't exists
		File file = new File("D:/ArsenalIsChampion.txt");
		
		try {
			
			newTeller.loadTransactions(file, newaccount);
			
		} catch (java.io.FileNotFoundException e) {
			// TODO: handle exception
			if(e.getMessage() != "File Not Found")
				return false;
			
			return true;
		}
		// if no exception is detected, return false
		return false;
		
	}

}
