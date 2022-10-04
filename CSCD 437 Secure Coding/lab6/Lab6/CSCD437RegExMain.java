import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSCD437RegExMain 
{
	public static void main(String [] args)
	{
      int choice;
      String str= "";
      Scanner kb = new Scanner(System.in);
      
      do
      {
         choice = menu(kb);
     		
         switch(choice)
   		{
   		   case 1:
               str = readString("easy SSN pattern", kb);
   				CSCD437RegExMethods.easySSNPatternTester(str, System.out);
   				break;
            case 2:
               str = readString("medium easy SSN pattern", kb);
   				CSCD437RegExMethods.mediumEasySSNPatternTester(str, System.out);
   				break;
            case 3:
               str = readString("new SSN pattern", kb);
   				CSCD437RegExMethods.newSSNPatternTester(str, System.out);
   				break;
   			case 4:
               str = readString("phone number pattern", kb);
   				CSCD437RegExMethods.phonePatternTester(str, System.out);
   				break;
   			case 5:
   			   str = readString("email pattern", kb);
            	CSCD437RegExMethods.emailPatternTester(str, System.out);
   				break;
   			case 6:
   			   str = readString("name pattern", kb);
            	CSCD437RegExMethods.namePatternTester(str, System.out);
   				break;
   			case 7:
   			   str = readString("date pattern", kb);
            	CSCD437RegExMethods.datePatternTester(str, System.out);
   				break;
   			case 8:
   			   str = readString("address pattern", kb);
            	CSCD437RegExMethods.addressPatternTester(str, System.out);
   				break;
   			case 9:
   			   str = readString("city state zip pattern", kb);
            	CSCD437RegExMethods.cityStateZipPatternTester(str, System.out);
   				break;
   			case 10:
   			   str = readString("military time pattern", kb);
            	CSCD437RegExMethods.militaryTimePatternTester(str, System.out);
   				break;
   			case 11:
   			   str = readString("money pattern", kb);
            	CSCD437RegExMethods.moneyPatternTester(str, System.out);
   				break;
   			case 12:
   			   str = readString("URL pattern", kb);
            	CSCD437RegExMethods.urlPatternTester(str, System.out);
   				break;
   			case 13:
   			   str = readString("password pattern", kb);
               CSCD437RegExMethods.passwordPatternTester(str, System.out);
   				break;
   			case 14:
   				str = readString("even er pattern", kb);
               CSCD437RegExMethods.evenErPatternTester(str, System.out);
   				break;
   			}
   			
   		}while(choice != 15);
		
		kb.close();
      		
	}//end main
   
   private static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad kb Parameter to the method");

      int choice;
      
      do
      {
         System.out.println("Please choose from the following");
         System.out.println(" 1) Easy SSN");
			System.out.println(" 2) Medium Easy SSN");
         System.out.println(" 3) New SSN");
         System.out.println(" 4) US Phone Number");
			System.out.println(" 5) E-mail Address");
			System.out.println(" 6) Name on Class Roster");
			System.out.println(" 7) Date MM-DD-YYYY");
			System.out.println(" 8) House Address");
			System.out.println(" 9) City, State Zip");
			System.out.println("10) Military Time");
			System.out.println("11) US Currency");
			System.out.println("12) URL");
			System.out.println("13) Password");
			System.out.println("14) Even er");
			System.out.println("15) Quit");
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());  
      }while(choice < 1 || choice > 15);
      
      return choice;
   
   }// end menu
   
   private static String readString(final String prompt, final Scanner kb)
   {
      if(prompt == null || prompt.isEmpty() || kb == null)
         throw new IllegalArgumentException("Bad Parameter to the method");
         
      String str = "";
      System.out.print("Please enter a(n) " + prompt + " ");
      return kb.nextLine();
      
   }// end readString
	
}// end class
