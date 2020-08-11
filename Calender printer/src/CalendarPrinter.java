//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           CalendarPrinter
// Files:           CalendarTester, CalendarPrinter
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
// Persons:   Rui Pan (ULC tutor) helped me with formating comment.
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;


/**
 * 
 * @author <Yucheng Qiu>
 *
 */
public class CalendarPrinter {
	// Define the names of days of week.
	private final static String[] DAYS_OF_WEEK = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

	// Define the names of months.
	private final static String[] MONTHS_OF_YEAR = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT",
			"NOV", "DEC" };

	/**
	* Calculates the number of centuries (rounded down) that is represented by
	* the specified year (ie. the integer part of year/100).
	* @param year to compute the century of (based on the Gregorian Calendar AD)
	* String must contain the digits of a single non-negative int for year.
	* @return number of centuries in the specified year
	*/
	public static int getCentury(String year) {
		//century is the number of centuries in the specified year.
		int century = (Integer.parseInt(year) / 100);
		
		return century;
	}
	
	/**
	 * Calculates the number of years between the specified year, and the first year
	 * in the specified year's century. This number is always between 0 - 99.
	 * 
	 * @param year
	 *          to compute the year within century of (Gregorian Calendar AD) String
	 *          must contain the digits of a single non-negative int for year.
	 * @return number of years since first year in the current century
	 */
	public static int getYearWithinCentury(String year) {
		// Calculate the number years between the specified year, and the first
		// * year in the specified year's century.
		int YearsInCentury = Integer.parseInt(year) % 100;

		return YearsInCentury;
	}

	/**
	 * This method computes whether the specified year is a leap year or not.
	 * 
	 * @param yearString
	 *          is the year that is being checked for leap-year-ness String must
	 *          contain the digits of a single non-negative int for year.
	 * @return true when the specified year is a leap year, and false otherwise
	 */
	public static boolean getIsLeapYear(String yearString) {
		// IsLeapYear = false means it's a common year, true means it's a leap year.
		boolean IsLeapYear;

		// Convert the String type to integer.
		int yearInt = Integer.parseInt(yearString) ;
		// Judge whether the year is a leap year.
		if (yearInt % 4 != 0) {
			IsLeapYear = false;
		} else if (yearInt % 100 != 0) {
			IsLeapYear = true;
		} else if (yearInt % 400 != 0) {
			IsLeapYear = false;
		} else {
			IsLeapYear = true;
		}

		return IsLeapYear;
	}

	/**
	 * Converts the name or abbreviation for any month into the index of that
	 * month's abbreviation within MONTHS_OF_YEAR. Matches the specified month based
	 * only on the first three characters, and is case in-sensitive.
	 * 
	 * @param month
	 *          which may or may not be abbreviated to 3 or more characters
	 * @return the index within MONTHS_OF_YEAR that a match is found at and returns
	 *         -1, when no match is found
	 */
	public static int getMonthIndex(String month) {
		// Get the first three characters as the judging condition.
		String MonthSubstr = month.substring(0, 3);

		// Make it all in Uppercase (Case in-sensitive).
		MonthSubstr = MonthSubstr.toUpperCase();

		// The value of month calculated in the formula is different from what we know.
		// ValueOfMonth[i-1] is the value for the ith month.
		int[] ValueOfMonth = { 13, 14, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		// Search for months.
		for (int i = 0; i <= 11; i++) {
			if (MonthSubstr.equals(MONTHS_OF_YEAR[i]))
				return ValueOfMonth[i];
		}

		// No Match.
		return -1;
	}

	/**
	 * Calculates the number of days in the specified month, while taking into
	 * consideration whether or not the specified year is a leap year.
	 * 
	 * @param month
	 *          which may or may not be abbreviated to 3 or more characters
	 * @param year
	 *          of month that days are being counted for (Gregorian Calendar AD)
	 *          String must contain the digits of a single non-negative int for
	 *          year.
	 * @return the number of days in the specified month (between 28-31)
	 */
	public static int getNumberOfDaysInMonth(String month, String year) {
		// Record the number of days for all months in an array.
		// NumberOfDays[i-1] is the days of the ith month except January and February.
		// Note that January is counted as the 13rd month, and February is the 14th.
		int[] NumberOfDays = { 31, 28 , 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31, 28 };
		int ValueOfMonth = getMonthIndex(month);
		if ( ValueOfMonth == 14 && getIsLeapYear(year)) {
			// February of a leap year has 29 days.
			return 29;
		} else
			return NumberOfDays[ValueOfMonth - 1];

	}

	/**
	 * Calculates the index of the first day of the week in a specified month. The
	 * index returned corresponds to position of this first day of the week within
	 * the DAYS_OF_WEEK class field.
	 * 
	 * @param month
	 *          which may or may not be abbreviated to 3 or more characters
	 * @param year
	 *          of month to determine the first day from (Gregorian Calendar AD)
	 *          String must contain the digits of a single non-negative int for
	 *          year.
	 * @return index within DAYS_OF_WEEK of specified month's first day
	 */
	public static int getFirstDayOfWeekInMonth(String month, String year) {
		// The first day of week in month.
		int FirstDayOfWeek;
		
		if( getMonthIndex(month) == 13 || getMonthIndex(month) == 14 ){
			year = "" + (Integer.parseInt(year) - 1);
		}

		/**
		 * Generate the Zeller's formula. More information for this formula in
		 * https://en.wikipedia.org/wiki/Zeller%27s_congruence#Implementation_in_software
		 */
		FirstDayOfWeek = 
			(1 
			+ (int) ((13 * (getMonthIndex(month) + 1)) / 5) 
			+ getYearWithinCentury(year)
			+ (int) (getYearWithinCentury(year) / 4) 
			+ (int) (getCentury(year) / 4)
			+ 5 * getCentury(year)	) % 7;

		// Connect the value of FirstDayOfWeek to the days in week.
		// 0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday.
		return (FirstDayOfWeek + 5) % 7;

	}

	/**
	 * Creates and initializes a 2D String array to reflect the specified month. The
	 * first row of this array [0] should contain labels representing the days of
	 * the week, starting with Monday, as abbreviated in DAYS_OF_WEEK. Every later
	 * row should contain dates under the corresponding days of week. Entries with
	 * no corresponding date in the current month should be filled with a single
	 * period. There should not be any extra rows that are either blank, unused, or
	 * completely filled with periods. For example, the contents for September of
	 * 2019 should look as follows, where each horizontal row is stored in different
	 * array within the 2d result:
	 *
	 * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	 * 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 . . . . . .
	 *
	 * @param month
	 *          which may or may not be abbreviated to 3 or more characters
	 * @param year
	 *          of month generate calendar for (Gregorian Calendar AD) String must
	 *          contain the digits of a single non-negative int for year.
	 * @return 2d array of strings depicting the contents of a calendar
	 */
	public static String[][] generateCalendar(String month, String year) {

		// Create a 2d array of strings to store the calendar.
		String[][] MyCalendar = new String[7][7];

		// Print the days of a week.
		for (int i = 0; i < 7; i++)
			MyCalendar[0][i] = DAYS_OF_WEEK[i];

		
		// Get the first day of the first week.
		int FirstDayInMonth = getFirstDayOfWeekInMonth(month, year);

		// A counter to count the dates.
		int CountDates = 0;

		// Generate the first row in MyCalendar.
		for (int i = 0; i < 7; i++) {
			if (i < FirstDayInMonth)
				MyCalendar[1][i] = "  .";
			else
				MyCalendar[1][i] = "  " + (++CountDates);
		}

		// Get the maximum date in month.
		int MaxDate = getNumberOfDaysInMonth(month, year);

		// Fill the dates into MyCalendar.
		for (int i = 2; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (CountDates < MaxDate && CountDates < 9)
					MyCalendar[i][j] = "  " + (++CountDates);
				else if (CountDates < MaxDate)
					MyCalendar[i][j] = " " + (++CountDates);
				else if (j == 0)
					continue; // If one row has no dates, fill nothing into it.
				else
					MyCalendar[i][j] = "  .";
			}
		}

		return MyCalendar;
	}

	/**
	 * Print a header to welcome the user and instruct to input.
	 */
	private static void printHeaders() {
		// Print the headers.
		System.out.println("Welcome to the Calendar Printer.");
		System.out.println("================================");
	}

	/**
	 * Instruct the user to input the month.
	 * 
	 * @return a String array that contains the month and the year.
	 * MyStringArr[0] contains the month
	 * MyStringArr[1] contains the year
	 */
	private static String[] getInput(){
		Scanner MyScanner = new Scanner(System.in);
		
		// Ask for the input of month.
		System.out.println("Enter the month to print:");
		String[] MyStringArr = new String[2];
		MyStringArr[0] = MyScanner.nextLine();

		// Ask for the input of year.
		System.out.println("Enter the year to print:");
		MyStringArr[1] = MyScanner.nextLine();
		
		MyScanner.close();
		
		return MyStringArr;
	}

	/**
	 * Print the Calendar of given month and year.
	 * 
	 * @param month
	 *          which may or may not be abbreviated to 3 or more characters
	 * @param year
	 *          of month generate calendar for (Gregorian Calendar AD) String must
	 *          contain the digits of a single non-negative int for year.
	 */
	private static void printCalendar(String month, String year) {
		// Get the calendar.
		String[][] MyCalendar = generateCalendar(month, year);

		// Print the Calendar.
		for (int i = 0; i < 7; i++) {
			if (MyCalendar[i][0] == null)
				continue;
			for (int j = 0; j < 7; j++) {
				if(j == 6) System.out.println(MyCalendar[i][j]);
				else System.out.print(MyCalendar[i][j] + " ");
			}
		}
	}

	/**
	 * Print a header to welcome the user and instruct to input.
	 */
	private static void printFooter() {
		// Print the footers.
		System.out.println("================================");
		System.out.println("Thanks, and have a nice day.");
	}

	public static void main(String[] args){
		printHeaders();
		String[] Input= getInput();
		String month = Input[0];
		String year = Input[1];
		printCalendar(month, year);
		printFooter();
		
	}
}
