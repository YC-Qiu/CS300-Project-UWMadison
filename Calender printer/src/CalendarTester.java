//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           CalendarTester
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
/**
 * @author <Yucheng Qiu>
 *
 */
public class CalendarTester {
	
	/**
	 * Test for the getCentury() method.
	 * @return True for passing the test, and False for failing the test. 
	 */
	public static boolean testGetCentury() {
		if(CalendarPrinter.getCentury("2") != 0) return false;
		if(CalendarPrinter.getCentury("2019") != 20) return false;
		if(CalendarPrinter.getCentury("44444") != 444) return false;
		return true;
	}
	
	/**
	 * Test for the getYearWithinCentury() method.
	 * @return True for passing the test, and False for failing the test. 
	 */
	public static boolean testGetYearWithinCentury() {
		if(CalendarPrinter.getYearWithinCentury("1987") != 87) return false;
		if(CalendarPrinter.getYearWithinCentury("2019") != 19) return false;
		if(CalendarPrinter.getYearWithinCentury("44444") != 44) return false;
		return true;
	}
	
	/**
	 * Test for the getIsLeapYear() method.
	 * @return True for passing the test, and False for failing the test. 
	 */
	public static boolean testGetIsLeapYear() {
		if(CalendarPrinter.getIsLeapYear("1987") != false) return false;
		if(CalendarPrinter.getIsLeapYear("2000") != true) return false;
		if(CalendarPrinter.getIsLeapYear("2100") != false) return false;
		return true;
	}
	
	/**
	 * Test for the getMonthIndex() method.
	 * @return True for passing the test, and False for failing the test. 
	 */
	public static boolean testGetMonthIndex() {
		if(CalendarPrinter.getMonthIndex("febbbbbbsdouhqwhdiuoq") != 14) 
			return false;
		if(CalendarPrinter.getMonthIndex("janwqdps") != 13) return false;
		if(CalendarPrinter.getMonthIndex("novvv212132") != 11) return false;
		return true;
	}
	
	/**
	 * Test for the getNumberOfDaysInMonth() method.
	 * @return True for passing the test, and False for failing the test. 
	 */
	public static boolean testGetNumberOfDaysInMonth() {
		if(CalendarPrinter.getNumberOfDaysInMonth("fEB","1979") != 28) return false;
		if(CalendarPrinter.getNumberOfDaysInMonth("jan","2080") != 31) return false;
		if(CalendarPrinter.getNumberOfDaysInMonth("dec","1409") != 31) return false;
		return true;
	}
	
	/**
	 * Test for the getFirstDayOfWeekInMonth() method.
	 * @return True for passing the test, and False for failing the test. 
	 */
	public static boolean testGetFirstDayOfWeekInMonth() {
		if(CalendarPrinter.getFirstDayOfWeekInMonth("fEB","2020") != 5) System.out.println("sep"+"2019");
		if(CalendarPrinter.getFirstDayOfWeekInMonth("sep","2019") != 6) System.out.println("sep"+"2019");
		return true;
	}

	//if any method fails, print it out.
	public static void main(String[] args) {
		
		if(testGetCentury() == false) 
			System.out.println("Method getCentury() Failed");
		
		if(testGetFirstDayOfWeekInMonth() == false) 
			System.out.println("Method getFirstDayOfWeekInMonth() Failed");
		
		if(testGetIsLeapYear() == false) 
			System.out.println("Method getIsLeapYear() Failed");
		
		if(testGetMonthIndex() == false) 
			System.out.println("Method getMonthIndex() Failed");
		
		if(testGetNumberOfDaysInMonth() == false) 
			System.out.println("Method getNumberOfDaysInMonth() Failed");
		
		if(testGetYearWithinCentury() == false) 
			System.out.println("Method getYearWithinCentury() Failed");
		
	}

}
