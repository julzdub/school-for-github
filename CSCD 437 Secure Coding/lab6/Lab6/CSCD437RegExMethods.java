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
						
	}// end easySSN
   
   
   public static void mediumEasySSNPatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");
				
	}// end mediumEasySSN
   
   
   public static void newSSNPatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");
				
	}// end newSSN


   public static void phonePatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");
  
	}// end phoneNumber


	public static void emailPatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");

	}// end email
   
   
	public static void namePatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");
   
	}// end name
	
   
   public static void datePatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");

	}// end date
	
   
   public static void addressPatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");

	}// end address
	
   
   public static void cityStateZipPatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");

	}//end cityStateZip
	
   
   public static void militaryTimePatternTester(final String str, final PrintStream fout)
	{
	  if(str == null || str.isEmpty())
		 throw new IllegalArgumentException("Bad str Parameter to the method");

	}// end militaryTime
	
   
   public static void moneyPatternTester(final String str, final PrintStream fout) 
   {
   	
   	if(str == null || str.isEmpty())
   		throw new IllegalArgumentException("Bad str Parameter to the method");
		 

	String regex = "\$\d+.\d\d";
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
		 

		String regex = "^(http|https|HTTP|HTTPS):\\/\\/(?!-)(?!.*\\.\\.)[A-Za-z0-9_.-~]{1,30}\\.[A-Za-z0-9]{2,6}$";
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
		 

		String regex = "^(?=.*[a-z]){1,3}(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{10,}$";
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
	  if(str == null || str.isEmpty() || str.length() % 2 != 0) 
   			throw new IllegalArgumentException("Bad str Parameter to the method");

		String regex = "^(?=.*[a-z])(?=.*[A-Z])er$";
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
