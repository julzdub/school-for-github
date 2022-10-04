//Ryan Cranston, Petal Michaud, Julian Welge 
//Team 6

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSCD437RegExMethods
{
	public static void easySSNPatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      
      String regex = "\\d\\D?\\d\\D?\\d\\D?\\d\\D?\\d\\D?\\d\\D?\\d\\D?\\d\\D?\\d\\D?";
      Pattern pattern = Pattern.compile(regex);
      Matcher match = pattern.matcher(str);
      boolean result=match.find();//match.matches();
      match.reset();
      if(result)
    	  fout.println("\""+str+"\" is Valid");
      else
    	  fout.println("\""+str+"\" is NOT Valid");
      while(match.find())
    	  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
      fout.println("Regex Being Tested: "+regex+"\n\n");
      
	}// end easySSN
   
   
   public static void mediumEasySSNPatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
	
      String regex = "\\d\\d\\d[\\s,-]?\\d\\d[\\s,-]?\\d\\d\\d\\d";
      Pattern pattern = Pattern.compile(regex);
      Matcher match = pattern.matcher(str);
      boolean result=match.find();//match.matches();
      match.reset();
      if(result)
    	  fout.println("\""+str+"\" is Valid");
      else
    	  fout.println("\""+str+"\" is NOT Valid");
      while(match.find())
    	  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
      fout.println("Regex Being Tested: "+regex+"\n\n");
	}// end mediumEasySSN
   
   
   public static void newSSNPatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      String regex = "^([78]\\d\\d)[\\s-]?((?!00)\\d\\d)[\\s-]?((?!0000)\\d{4})|^([9]\\d\\d)[\\s-]?([9]\\d)[\\s-]?((?!0000)\\d{4})";
      Pattern pattern = Pattern.compile(regex);
      Matcher match = pattern.matcher(str);
      boolean result=match.find();//match.matches();
      match.reset();
      if(result)
    	  fout.println("\""+str+"\" is Valid");
      else
    	  fout.println("\""+str+"\" is NOT Valid");
      while(match.find())
    	  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
      fout.println("Regex Being Tested: "+regex+"\n\n");
	}// end newSSN


   public static void phonePatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      String regex =  "^(\\+\\d)?[- ]?(\\d{3}[- ]?\\d{3}[- ]?\\d{4}|\\(\\d{3}\\)[ -]?\\d{3}[ -]?\\d{4})";
      Pattern pattern = Pattern.compile(regex);
      Matcher match = pattern.matcher(str);
      boolean result=match.find();//match.matches();
      match.reset();
      if(result)
    	  fout.println("\""+str+"\" is Valid");
      else
    	  fout.println("\""+str+"\" is NOT Valid");
      while(match.find())
    	  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
      fout.println("Regex Being Tested: "+regex+"\n\n");
	}// end phoneNumber


	public static void emailPatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      String regex = "^(?!.*\\.\\.)((.*[^\\.\\n@])@([^@\\n].*[^\\.\\n])|@[^\\.@].*[^\\.\\n])";
      Pattern pattern = Pattern.compile(regex);
      Matcher match = pattern.matcher(str);
      boolean result=match.find();//match.matches();
      match.reset();
      if(result)
    	  fout.println("\""+str+"\" is Valid");
      else
    	  fout.println("\""+str+"\" is NOT Valid");
      while(match.find())
    	  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
      fout.println("Regex Being Tested: "+regex+"\n\n");
	}// end email
   
   
	public static void namePatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
   
      String regex = "([A-Za-z]+),\\\\s*([A-Za-z]+)\\\\s*([A-Za-z]+)";
 		Pattern pattern = Pattern.compile(regex);
 		Matcher match = pattern.matcher(str);
 		boolean result=match.find();//match.matches();
 		match.reset();

 		if(result) {
 		  fout.println("\""+str+"\" is Valid");
 		}

 		else {
 			fout.println("\""+str+"\" is NOT Valid");
 		}

 		while(match.find()) {

 		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
 		}

 		fout.println("Regex Being Tested: "+regex+"\n\n");
	}// end name
	
   
   public static void datePatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");

      String regex = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$|"
 			 + "^[0-9]{2}/[0-9]{2}/[0-9]{4}$|"
 			 + "^[0-9]{2} [0-9]{2} [0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		boolean result=match.find();//match.matches();
		match.reset();

		if(result) {
		  fout.println("\""+str+"\" is Valid");
		}

		else {
			fout.println("\""+str+"\" is NOT Valid");
		}

		while(match.find()) {

		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
		}

		fout.println("Regex Being Tested: "+regex+"\n\n");
	}// end date
	
   
   public static void addressPatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");

      //Regex for N/SE/W/Blvd etc found online
      
      String regex = "[0-9]{1,6} ((w|W|west|West|WEST|e|E|east|East|EAST|n|N|north|North|NORTH|s|S|south|South|SOUTH|"
 			 + "nw|NW|northwest|Northwest|NorthWest|NORTHWEST|ne|NE|northeast|Northeast|NorthEast|NORTHEAST|sw|"
 			 + "SW|southwest|Southwest|SouthWest|SOUTHWEST|se|SE|southeast|Southeast|SouthEast|SOUTHEAST)) "
 			 + "?[A-Za-z0-9]{1,30} (road|Road|ROAD|rd|Rd|RD|street|Street|STREET|st|St|ST|boulevard|Boulevard|"
 			 + "BOULEVARD|blvd|Blvd|BLVD|avenue|Avenue|AVENUE|ave|Ave|AVE)";;
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		boolean result=match.find();//match.matches();
		match.reset();

		if(result) {
		  fout.println("\""+str+"\" is Valid");
		}

		else {
			fout.println("\""+str+"\" is NOT Valid");
		}

		while(match.find()) {

		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
		}

		fout.println("Regex Being Tested: "+regex+"\n\n");

	}// end address
	
   
   public static void cityStateZipPatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      if(str == null || str.isEmpty() || str.length() % 2 != 0) 
 			throw new IllegalArgumentException("Bad str Parameter to the method");

		String regex = "^[A-Za-z]{1,20},? (AL|Al|AK|Ak|AZ|Az|AR|Ar|CA|Ca|CO|Co|CT|Ct|DE|De|FL|Fl|GA|Ga|HI|Hi|ID|Id|IL|Il|IN|In|IA|Ia|KS|Ks|KY|Ky|LA|La|ME|Me|MD|Md|MA|Ma|MI|Mi|MN|Mn|MS|Ms|MO|Mo|"
				+ "MT|Mt|NE|Ne|NV|Nv|NH|Nh|NJ|Nj|NM|Nm|NY|Ny|NC|Nc|ND|Nd|OH|Oh|OK|Ok|OR|Or|PA|Pa|RI|Ri|SC|Sc|SD|Sd|TN|Tn|TX|Tx|UT|Ut|VT|Vt|VA|Va|WA|Wa|WV|Wv|WI|Wi|WY|Wy)"
				+ "\s? [0-9]{5}";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		boolean result=match.find();//match.matches();
		match.reset();

		if(result) {
		  fout.println("\""+str+"\" is Valid");
		}

		else {
			fout.println("\""+str+"\" is NOT Valid");
		}

		while(match.find()) {

		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
		}

		fout.println("Regex Being Tested: "+regex+"\n\n");

      
	}//end cityStateZip
	
   
   public static void militaryTimePatternTester(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      	
      String regex = "^([01]\\d|2[0-3]):?([0-5]\\d):?([0-5]\\d)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		boolean result=match.find();//match.matches();
		match.reset();

		if(result) {
		  fout.println("\""+str+"\" is Valid");
		}

		else {
			fout.println("\""+str+"\" is NOT Valid");
		}

		while(match.find()) {

		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
		}

		fout.println("Regex Being Tested: "+regex+"\n\n");
    
	}// end militaryTime

   
   public static void moneyPatternTester(final String str, final PrintStream fout) 
   {
   	
   	if(str == null || str.isEmpty())
   		throw new IllegalArgumentException("Bad str Parameter to the method");
		 

	String regex = "\\$\\d+.\\d\\d";
	Pattern pattern = Pattern.compile(regex);
	Matcher match = pattern.matcher(str);
	boolean result=match.find();//match.matches();
	match.reset();

	  if(result)
		  fout.println("\""+str+"\" is Valid");

	  else
		  fout.println("\""+str+"\" is NOT Valid");

	  while(match.find())
		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());

	  fout.println("Regex Being Tested: "+regex+"\n\n");
  
   }// end money
	
   
   public static void urlPatternTester(final String str, final PrintStream fout)
   {
   		if(str == null || str.isEmpty()) 
   			throw new IllegalArgumentException("Bad str Parameter to the method");
		 

		String regex = "^(((HTTPS)|(https)|(HTTP)|(http)):\\/\\/)?[^hH].*|^[^hH].*";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		boolean result=match.find();//match.matches();
		match.reset();

		if(result) {
		  fout.println("\""+str+"\" is Valid");
  		}

		else {
			fout.println("\""+str+"\" is NOT Valid");
		}

		while(match.find()) {

		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
		}

		fout.println("Regex Being Tested: "+regex+"\n\n");

	}// end URL
	
   
   public static void passwordPatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty()) 
   			throw new IllegalArgumentException("Bad str Parameter to the method");
		 

		String regex = "^(?!.*?[a-z]{3,})(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[@$!%*?&])[\\d\\w@$!%*?&]{10,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		boolean result=match.find();//match.matches();
		match.reset();

		if(result) {
		  fout.println("\""+str+"\" is Valid");
  		}

		else {
			fout.println("\""+str+"\" is NOT Valid");
		}

		while(match.find()) {

		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
		}

		fout.println("Regex Being Tested: "+regex+"\n\n");
	}// end password
	
   
   public static void evenErPatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty()) 
   			throw new IllegalArgumentException("Bad str Parameter to the method");

		String regex = "^(\\w\\w)*er$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		boolean result=match.find();//match.matches();
		match.reset();

		if(result) {
		  fout.println("\""+str+"\" is Valid");
  		}

		else {
			fout.println("\""+str+"\" is NOT Valid");
		}

		while(match.find()) {

		  fout.printf("Valid: %s at [%d,%d]\n", match.group(),match.start(),match.end());
		}

		fout.println("Regex Being Tested: "+regex+"\n\n");

	}// end oddIon

}// end class

//1 easySSNPattern Tested Patterns
/* "123456789" is Valid
 * "abc56789" is NOT Valid
 * "12 34 56 78 9" is Valid
 * "123-456789" is Valid
 * "1234" is NOT Valid
 */
//2 MediumSSNPattern Tested Patterns
/* "12-345-6789" is NOT Valid
*  "123-45 6789" is Valid
*  "12 34 56 78 9" is NOT Valid
*  "123-456789" is Valid
*  "123.45.6789" is NOT Valid
*/
//3 NewSSNPattern Tested Patterns
/* "723456789" is Valid
*  "912456789" is NOT Valid
*  "845002345" is NOT Valid
*  "912935678" is Valid
*  "735450000" is NOT Valid
*/
//4 PhonePattern Tested Patterns
/* "(509)5543456" is Valid
 * "1(509)345 6789" is NOT Valid
 * "+1(509)345 6789" is Valid
 * "+1(456)123-1234" is Valid
 * "(555-555-5555" is NOT Valid
 * "1234567890" is Valid
*/
//5 EmailPattern Tested Patterns
/* "Ryan.cranston@ewu.edu" is Valid
 * "r@ss" is Valid
 * "Help@@me" is NOT Valid
 * "ryan.@ewu.edu" is NOT Valid
 * "Ryan@ewu..edu" is NOT Valid
 */
//6 ClassRosterPattern Tested Patterns
/*
*/
//7 DatePattern Tested Patterns
/*
*/
//8 HousePattern Tested Patterns
/*
*/
//9 CityStateZipPattern Tested Patterns
/*
*/
//10 MilitaryTimePattern Tested Patterns
/*
*/
//11 US CurrencyPattern Tested Patterns
/*
*/
//12 urlPattern Tested Patterns
/* "htp://google.com" is NOT Valid
* "https://google.com" is Valid
* "https: ewu.edu" is NOT Valid
* "ewu.edu" is Valid
* "192.168.2.1" is Valid
*/
//13 PasswordPattern Tested Patterns
/* "12ccRT!@23" is Valid
 * "12abcRT!23" is Valid
 * "12abcdeRT!" is NOT Valid
 * "12356rtRT" is NOT Valid
 * "Password1!" is NOT Valid
*/
//14 EvenER Tested Patterns
/* "ever" is Valid
 * "evver" is NOT Valid
 * "er" is Valid
 * "``er" is NOT Valid
 * "even" is NOT Valid
*/


