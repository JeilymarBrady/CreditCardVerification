/*
Name:  Jeilymar Brady
Assignment:   4
Title: Credit Card Validation
Course: CSCE144 
Section: 1 - Hauser
Lab Section: 2 - Hauser
Semester: Spring 2014 
Instructor: Hauser
Date: 3 April 2014
Sources consulted:   
Known Bugs: none
Program Description: 
Creativity: 
Instructions: javac CCV.java then java CCV then follow onscreen instructions
*/

import java.util.Scanner;

public class CCV
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); 
		
		long number = 1 ;
		while ( number != 0 ) {
		
			System.out.print( "Enter a credit card number: " ) ;
			number = keyboard.nextLong() ;
			
			if(number != 0 ) 
				if( isValid(number)) {
					System.out.println( "The " + cardType(number) + " credit card number " + number + " is valid." ) ;
				} else { 
					System.out.println( "You have entered an invalid credit card number, please try again. " ) ;
				}
			
		}
		
	}
		/** 
		* Return true if credit card number is valid 
		*/ 
		public static boolean isValid(long num) {
			
			boolean result = true ;
			
			 if ( num <= 0 ) {
			 	 System.out.println("Goodbye!") ;
			 	 result = false ;
			 }
			 
			long total ;
			total = sumOfDoubleEvenPlaces(num) + sumOfOddPlaces(num);
		
			if (total % 10 != 0) 
				result = false;
			
			if (getSize(num)<13 || getSize(num)>19 )
				result = false ;
			
			if ( !prefixMatched( num, 4 )  &&
				!prefixMatched(num, 5) &&
				!prefixMatched(num, 6) &&
				!prefixMatched(num, 37) &&
				!prefixMatched(num, 34) )
				result = false ;
				
			return result ;
				
		}
	
		
		/** 
		* Perform the computation in STEP 2 and return the result 
		*/ 
		public static int sumOfDoubleEvenPlaces( long number ) {
			
			int sum = 0;
			number = number / 10;
			while (number > 0) {
			    sum = sum + getDigit((int)((number % 10) * 2));
			    number = number / 100;
			}
			return sum ;
		}
		
		/** 
		* Return the number if it is 0-9, otherwise return the sum of the digits 
		*/ 
		public static int getDigit( long number ) {
			
			return (int)((number % 10 ) + ( number / 10) );
	
		}
		
		
		/** 
		* Return the sum of the odd-place digits 
		*/ 
		public static int sumOfOddPlaces( long number ) {
			int sum = 0;
			while (number > 0) {
			    sum = sum + (int)(number % 10);
			    number = number / 100;
			}
			return sum;
		}
		
		/** 
		* Return true if the credit card number contains the prefix d 
		*/ 
		public static boolean prefixMatched( long number, int d) {
			if ( d == getPrefix(number, getSize(d) ) )
				return true ;
			
			return false ;
		}
			
		/** 
		* Return the number of digits in number 
		*/ 
		public static int getSize( long number ) {
			int length = 0;
			while (number > 0) {
				number = number / 10;
				length++;
			}
			return length;
		}
		
		/** 
		* Return the first k digits from number. If the number of 
		* digits in number is less than k, return the number 
		*/ 
		
		public static long getPrefix( long number, int k ) {
			long result = number;
			for (int i = 0; i < getSize(number) - (k); i++)
			    result = result / 10;
			return result;
		}
		
		static String cardType( long num ) {
			String result ;
			if ( prefixMatched(num, 4) )
				result = "Visa" ;
			else if ( prefixMatched(num, 5) )
				result = "MasterCard" ;
			else if ( prefixMatched(num, 6) )
				result = "Discover" ;
			else if ( prefixMatched(num, 34) )
				result = "American Express" ;
			else if ( prefixMatched(num, 37) )
				result = "American Express" ;
			else 
				result = "none" ;
		return result ;
			
		}

}
