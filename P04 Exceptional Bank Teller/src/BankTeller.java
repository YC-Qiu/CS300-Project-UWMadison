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
import java.util.Scanner;

/**
 * This class models the BankTeller data type
 * 
 * @author Yucheng Qiu
 * @version 1.0
 * @since 2019-10-2
 */
public class BankTeller {

	// All the accounts in the bank
	private ArrayList<BankAccount> BankAccountList;
	
	/**
	 * Creates a new BankTeller object with an empty list of accounts
	 */
	public BankTeller() {
		
		BankAccountList = new ArrayList<BankAccount>();
		
	}

	/**
	 * Adds newAccount to the list of accounts of this BankTeller
	 * @param newAccount a new account to add
	 * @throws java.lang.IllegalStateException with a descriptive error message
	 * if the accountID of newAccount is used by another account already added
	 * to the list of accounts
	 * @throws java.lang.IllegalArgumentException with a descriptive error
	 * message if newAccount is null
	 */
	public void addBankAccount(BankAccount newAccount){
		
		// Check if null
		if(newAccount == null)
			throw new java.lang.IllegalArgumentException("The new account is null.");
		
		// Check if the id already exists
		for(int i = 0; i < BankAccountList.size(); i++) {
			
			if(BankAccountList.get(i).equals(newAccount))
				throw new java.lang.IllegalStateException
				("the accountID of newAccount is used by another account");
			
		}
		
		// if valid, create a new account
		BankAccountList.add(newAccount);
		
	}
	
	/**
	 * Returns the bank account that has exactly the provided identifier. Case
	 * sensitive comparison must be considered.
	 * @param id a string that represents an identifier of a bank account
	 * @return a reference to the bank account whose account identifier has an
	 * exact match with the provided string
	 * @throws java.util.NoSuchElementException with a descriptive error message
	 * if no account in this bankTeller's accounts list has the provided id
	 */
	public BankAccount findAccount(String id)
    throws java.util.NoSuchElementException{
		
		for(int i = 0; i < BankAccountList.size(); i++) {
			
			if(BankAccountList.get(i).getID().equals(id)) {
				
				return BankAccountList.get(i);
				
			}
			
		}
		
		// if no such an account, throws NoSuchElementException
		throw new java.util.NoSuchElementException
		("no account in this bankTeller's accounts list has the provided id");
		
	}
	
	/**
	 * Adds a new transaction to the account's list of transactions.
	 * When added, a withdrawal or deposit transaction should change the
	 * account's balance
	 * @param transaction transaction to add
	 * @param account the bank account
	 * @throws java.util.zip.DataFormatException if the format of the transaction
	 * is not correct
	 * @throws java.lang.NullPointerException if account is null
	 */
	public void addTransaction(String transaction,
	  BankAccount account) throws java.util.zip.DataFormatException{
		
		// check if null
		if(account == null)
			throw new java.lang.NullPointerException("The account is null");
		
		// Check it's deposit or withdraw
		String InOrOut = transaction.substring(0,1);
		
		// Retract the amount from the transaction
		String Amount = transaction.substring(1).trim();
		
		// if the transaction is invalid
		boolean FirstCharValid = InOrOut.equals("0") || InOrOut.equals("1");
		
		if(FirstCharValid) {
			
			int IntAmount = Integer.valueOf(Amount);
			
			if(InOrOut.equals("0")) account.withdraw(IntAmount);
			else if(InOrOut.equals("1")) account.deposit(IntAmount);
			
		}
		else throw new java.util.zip.DataFormatException("the format of the"
				+ " transaction is not correct");
		
	}
	
	/**
	 * Loads a set of transactions from a provided file object. Each transaction
	 * is in a separate line. Each transaction line should contain two items: the
	 * transaction code "0" or "1" followed by the transaction amount, separated
	 * by spaces. Extra spaces at the beginning and at the end of a transaction
	 * line should be ignored. Not correctly formatted lines must be skipped.
	 * Valid transactions must change the balance of the bank account. If
	 * java.util.Scanner object is used to read from the file object, make sure
	 * to close the scanner object whenever a FileNotFoundException was thrown
	 * or not.
	 * @param file a java.io.File object referring to a file that contains a set
	 * of transactions, each in one line
	 * @param account a reference to a BankAccount object
	 * @throws java.io.FileNotFoundException if the file object does not
	 * correspond to an actual file within the file system
	 * @throws java.lang.NullPointerException if account is null
	 */
	public void loadTransactions(java.io.File file,
    BankAccount account) throws java.io.FileNotFoundException{
		
		// Check if null
		if(account == null)
			throw new java.lang.NullPointerException("The account is null.");
		
		// Check if file exists
		if(!file.exists())
			throw new java.io.FileNotFoundException("File Not Found");
		
		Scanner s = new Scanner(file);
		
		// Scan the transactions
		while(s.hasNextLine()) {
			String data = s.nextLine().trim();
			try {
				
				addTransaction(data, account);
				
			} catch (java.util.zip.DataFormatException e) {
				//Skip the lines that don't have correct format
			}
		}
		
		s.close();
		
	}
	
	/**
	 * Returns the total number of accounts created so far (i.e., the size of the
	 * Arraylist of accounts
	 * @return the total number of accounts added to this BankTeller
	 */
	public int getAccountsCount() {
		
		return BankAccountList.size();
		
	}
}
