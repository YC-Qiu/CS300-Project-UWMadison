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
import java.util.ArrayList;

/**
 * This class models a very simple account at a bank.
 * 
 * @author Yucheng Qiu
 * @version 1.0
 * @since 2019-10-2
 */
public class BankAccount {
	
	// Unique ID for each account
	private String AccountIdentifier;
	
	// Amount of money in the account
	private int balance;
	
	// Transaction record
	private ArrayList<String> Transactions;
	
	/**
	 * Creates a new bank account with a given account identifier
	 * and an initial balance.
	 * @param accountID this account's unique identifier
	 * @param initialBalance this account's initial balance
	 * @throws java.lang.IllegalArgumentException with a descriptive
	 * error message if initBalance is less than 10
	 */
	public BankAccount(String accountID, int initialBalance){
		
		// Initial Balance should be larger than 10
		if(initialBalance < 10) 
			throw new java.lang.IllegalArgumentException
			("initBalance is less than 10");
		
		Transactions = new ArrayList<String>();
		
		AccountIdentifier = accountID;
		
		deposit(initialBalance);
	}
	
	/**
	 * Gets the unique identifier of this account
	 * @return the unique identifier of this account
	 */
	public String getID(){
		
		return AccountIdentifier;
		
	}

	/**
	 * Gets the current balance of this bank account
	 * @return the current balance of this bank account
	 */
	public int getBalance() {
		
		return balance;
		
	}
	
	/**
	 * Checks if an other bank account is equal to this one
	 * @param other another BankAccount object
	 * @return true if this bankAccount's identifier equals the other
	 * bankAccount's identifier. The comparison is case sensitive
	 */
	public boolean equals(BankAccount other) {
		
		// Check if the IDs are the same
		return other.getID().equals(AccountIdentifier);
		
	}
	
	/**
	 * This method deposits an amount to this bank account. 
	 * It also adds the transaction /"1 " + depositAmount/ to this account list
	 * of transactions and updates this bank account's balance.
	 * @param depositAmount the amount of money to deposit to this bank account
	 * @throws java.lang.IllegalArgumentException with a descriptive error
	 * message if depositAmount is negative
	 */
	public void deposit(int depositAmount){
		
		// Deposit amount should be positive
		if(depositAmount < 0)
			throw new java.lang.IllegalArgumentException
			("deposit amount is negative");
		
		// Transaction Record Form
		String NewTransaction = "1 " + depositAmount;
		
		Transactions.add(NewTransaction);
		
		// Update the balance
		balance += depositAmount;
		
	}
	
	/**
	 * This method withdraws a specific amount of money. It also adds the
	 * transaction /"0 " + withdrawalAmount/ to this accunt's list of
	 * transactions and updates this bank account's balance.
	 * @param withdrawAmount the amount of money to withdraw from this bank
	 * account
	 * @throws java.util.zip.DataFormatException with a descriptive error message
	 * if withdrawalAmount is negative or is not a multiple of 10
	 * @throws java.lang.IllegalStateException if the withdrawalAmount is
	 * larger than this bank account's balance
	 */
	public void withdraw(int withdrawAmount) 
		throws java.util.zip.DataFormatException{
		
		// Withdraw Amount should be positive
		if(withdrawAmount < 0) {
			
			throw new java.util.zip.DataFormatException
			("The Withdraw Amount is negative");
			
		}
		
		// Withdraw Amount should be a multiple of 10
		if(withdrawAmount % 10 != 0) {
			
			throw new java.util.zip.DataFormatException
			("The Withdraw Amount is not a multiple of 10");
			
		}
		
		// Check whether there is enough balance to withdraw
		if(withdrawAmount > balance) {
			
			throw new java.lang.IllegalStateException
			("No Enough Balance in the Account");
			
		}
		
		balance -= withdrawAmount;
		
		// Add transactions
		Transactions.add("0 " + withdrawAmount);
		
	}

	/**
	 * Gets the most recent FIVE transactions in an array of length 5. This array
	 * may contain null references if the total number of transactions is less
	 * than 5. If getTransactionsCount() is less than 5, these transactions
	 * should be stored at the range of indices 0 .. getTransactionsCount()-1.
	 * For instance, if the total number of transactions is 0, this array will
	 * contain five null references. If the total number of transactions is 1, it
	 * will contain the transaction at index 0, followed by 4 null references,
	 * and so on.
	 * @return the most recent transactions in an array that may contain up to 5
	 * string references
	 */
	public String[] getMostRecentTransactions(){
		
		// Array for five most recent transactions
		String[] FiveRecentTrans = new String[5];
		
		// Number of total transactions
		int NumOfTrans = Transactions.size();
		
		for(int i = 0; i < 5 && i < NumOfTrans; i++) {
			
			// Get the transactions in reverse order
			FiveRecentTrans[i] = Transactions.get(NumOfTrans - 1 - i);
			
		}
		
		return FiveRecentTrans;
	}
	
	/**
	 * Gets the total number of transactions performed on this bank account,
	 * meaning the size of the ArrayList of transactions of this bank account
	 * @return the total number of transactions performed on this account
	 */
	public int getTransactionsCount() {
		
		return Transactions.size();
		
	}
}
