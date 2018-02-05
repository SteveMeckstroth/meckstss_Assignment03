/**
 * @author Stephen Meckstroth
 * Assignment 03
 * Course IT2045 Section 001
 * Due DAte: Jan 30, 2018
 * Description: Create an ecipse java project that determines if a number is prime or not
 * Citations: N/A
 */

package assignment03;

import java.math.BigInteger;
/**
 * 
 * @author Stephen Meckstroth
 * Main class determines if a number is prime, and also calls another class that deteremines if a number is prime.
 * The results from both independent calculations are then compared to see if they agree
 */
public class Main {
	//if true then program will output useful developer messages to the console
	private static Boolean showDebugMessages = false;
	
	public static void main(String[] args) {
		//Instantiate the Main class
		Main m = new Main();
		
		Boolean mainClassIsPrime = true;
		Boolean bigIntClassIsPrime = true;
		
		BigInteger bi = new BigInteger("999983"); //A known prime number
		
		BigIntMethod bIM = new BigIntMethod(bi);//Send the number to the BigIntMethod class to be evaluated
		
		if(showDebugMessages) System.out.println(bi.toString() + " is the number to be evaluted.");
		
		//Test the number using BigIntMethod
		if(showDebugMessages) System.out.println("bigIntMethod testing if number is prime");
		bigIntClassIsPrime = bIM.testIfPrime();
		if(showDebugMessages) System.out.println("bigIntMethod finished testing if number is prime");
		
		//Test the number using the Main class
		mainClassIsPrime = m.isPrime(bi);
		
		//Print result of BigIntMethod test
		if (bigIntClassIsPrime){
			System.out.println("BigIntMethod believes "+ bi.toString() +" is prime.");
		} else {
			System.out.println("BigIntMethod believes "+ bi.toString() +" is NOT prime.");
		}
		
		//Print result of main class test
		if (mainClassIsPrime){
			System.out.println("Main class believes "+ bi.toString() +" is prime.");
		} else {
			System.out.println("Main class believes "+ bi.toString() +" is NOT prime.");
		}
		
		//Print whether the two independent tests agree
		if (bigIntClassIsPrime == mainClassIsPrime){
			System.out.println("Main class and BigIntMethod class agree!");
		} else {
			System.out.println("Main class and BigIntMethod class do NOT agree!");
		}
	}
	/**
	 * Check to see if the number stored in a BigInteger object is prime
	 * @param number the object to examine
	 * @return True if number is prime, false otherwise
	 */
	public Boolean isPrime(BigInteger number){
		if(showDebugMessages) System.out.println("[isPrime] has been called");
		Boolean result = true;
		Boolean isOdd = false;
		BigInteger compareTo = new BigInteger("2"); //Start the division tests at the number 2
		
		//Zero is assumed to be even, because number will be validated to be > 2
		//number must end in an odd number
		int[] oddNumbers = {1,3,5,7,9};
		for(int i=0; i<= oddNumbers.length-1; i++){
			//Test if the last digit of the number is odd, all prime numbers must be odd
			if(showDebugMessages) System.out.println("Checking if "+ number.toString() + " ends in " + oddNumbers[i]);
			if(Integer.valueOf(number.toString().substring(number.toString().length()-1)) == oddNumbers[i]){
				//Number is odd
				isOdd = true;
				
				while(result == true && compareTo.compareTo(number) < 0){
					if(showDebugMessages) System.out.println("Dividing "+ number.toString() +" by "+ compareTo.toString());
					if (number.mod(compareTo).equals(new BigInteger("0"))) {
						//Number is not prime
						result = false;
						
						break; //exit while loop since we know it isn't prime
					}
					
					compareTo = compareTo.add(new BigInteger("1"));
				}
				
				//exit odd number test loop since it is confirmed odd
				break;
			}//Close if test for odd number last digit
		}//close for loop to test for odd last digit
		
		//Since number has to be odd, return false if number is even unless it's number 2
		if (isOdd == false && !number.equals(new BigInteger("2"))){
			result = false;
		}
		if(showDebugMessages) System.out.println("[isPrime] is returning a result of " + result.toString());
		return result;
	}

}
