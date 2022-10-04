/**
 * 
 */
package lab7;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;
import java.util.regex.*;

/**
 * @author Ryan Cranston
 *
 */
public class Team6Member1 
{
//=======================================================================
	//Global Variables
	static int CurrentUser=-1;
	static List<String[]> db= new ArrayList <>();
//=======================================================================
	//Lab 7 Methods
	public static void ReadName(Scanner kb) throws IOException
	{
		Opendb();
		boolean Valid = false;
		while(!Valid)
		{
			String str= kb.nextLine();
			if(str != null && !str.isEmpty())
			{
			  String regex = "^(?=.{2,50}$)(?!.*?[Hh][Ii][Tt][Ll][Ee][Rr])([a-zA-Z-]*)[ ]*([a-zA-Z -]*)";
			  Pattern pattern = Pattern.compile(regex);
			  Matcher match = pattern.matcher(str);
			  boolean result=match.find();//match.matches();
			  match.reset();
			  if(result)
			  {
				System.out.println("\""+str+"\" is Accepted\n");
				Valid=true;
				Enterdb(str,0);
			  }
			  else
			  {
				  System.out.println("\""+str+"\" is NOT Valid");
				  FileWriter eL = new FileWriter("errors.txt",true);
				  eL.append("Error @ EnterName(1): \""+str+"\" attempted\n");
				  eL.flush();eL.close();
			  }
			  System.out.println("Please Enter A Valid Name");
			}
			else
			   System.out.println("Please Enter your Valid Full Name(FirstName LastName /Max size 50, no Hitler's Allowed)");
		}
	      //kb.close();
	      Closedb();
	}
	public static void ReadPassword(Scanner kb) throws IOException
	{
		 boolean Valid = false;
		 Opendb();
	     while(!Valid)
	     {
	      String str= kb.nextLine();
		  if(str != null && !str.isEmpty())
		  {
		      String regex = "(?!.*(\\d).*\\1)(?!.*?[\\d]{2,})(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\d\\s*@$!.])[^*@$!.\\n]*$";
		      Pattern pattern = Pattern.compile(regex);
		      Matcher match = pattern.matcher(str);
		      boolean result=match.find();//match.matches();
		      match.reset();
		      if(result)
		      {
		    	System.out.println("\""+str+"\" is Accepted");
		    	System.out.println("Please ReEnter your Pasword to Validate");
		    	String Rstr= kb.nextLine();
		    	if(Rstr.equals(str))
		    	{
		    		System.out.println("Password has been Stored!\n");
			    	Valid=true;
					try {
				    	SecureRandom random = new SecureRandom();
				    	byte[] salt = new byte[16];
				    	random.nextBytes(salt);
				    	MessageDigest md;
						md = MessageDigest.getInstance("MD5");
				    	md.update(salt);
				    	byte[] hashedPass = md.digest(str.getBytes(StandardCharsets.UTF_8));
				    	
				    	Enterdb(Base64.getEncoder().encodeToString(salt),2);
				    	Enterdb(Base64.getEncoder().encodeToString(hashedPass),3);
					} 
					catch (NoSuchAlgorithmException e) 
					{
						 FileWriter eL = new FileWriter("errors.txt",true);
				    	  eL.append("Error @ EnterPassword(3): Issue with hash:"+e+"\n");
				    	  eL.flush();eL.close();
					}
		    	}
		    	else
		    	{
			    	  FileWriter eL = new FileWriter("errors.txt",true);
			    	  eL.append("Error @ EnterPassword(3): Password"+str+"/"+Rstr+"\n");
			    	  eL.flush();eL.close();
			    	  System.out.println("Passwords did NOT Match, to try again");
		    	}
		      }
		      else
		      {
		    	  System.out.println("\""+str+"\" is NOT Valid");
		    	  FileWriter eL = new FileWriter("errors.txt",true);
		    	  eL.append("Error @ EnterPassword(3): \""+str+"\" attempted");
		    	  eL.flush();eL.close();
		       }
		      System.out.println("Please Enter A Valid Password(REQ: Atleast 1 Uppercase Letter/ 1 Lowercase Letter/ 1 Number(Non Consecutive or Repeated)/ 1 Special Char(Not *,@,$,!))");
		  }
		  else
		       System.out.println("Please Enter A Valid Password (REQ: Atleast 1 Uppercase Letter/ 1 Lowercase Letter/ 1 Number(Non Consecutive or Repeated)/ 1 Special Char(Not *,@,$,!))");
	      }	
	     Closedb();
	}
	public static void ReadUsername(Scanner kb) throws IOException 
	{
		 boolean Valid = false;
		 Opendb();
	     while(!Valid)
	     {
	      String str= kb.nextLine();
		  if(str != null && !str.isEmpty())
		  {
		      String regex = "^(?=.{1,25}$)([a-zA-Z][a-zA-Z0-9_]*)";
		      Pattern pattern = Pattern.compile(regex);
		      Matcher match = pattern.matcher(str);
		      boolean result=match.find();//match.matches();
		      match.reset();
		      if(result)
		      {
		    	System.out.println("\""+str+"\" is Accepted\n");
		    	Valid=true;
		    	Enterdb(str,1);
		      }
		      else
		      {
		    	  System.out.println("\""+str+"\" is NOT Valid");
		    	  FileWriter eL = new FileWriter("errors.txt",true);
		    	  eL.append("Error @ EnterUsername(2): Invalid username\""+str+"\"\n");
		    	  eL.flush();eL.close();
		      }
		      	  System.out.println("Please Enter A Valid Username");
		  }
		  else
		       System.out.println("Please Enter A Valid Username (Max size: 25))");
	      }	
	     Closedb();
	}
	public static void ReLogin(Scanner kb) throws IOException
	{
		Opendb();
		CurrentUser=-1;
		 boolean Valid = false;
	     while(!Valid)
	     {
	      String str= kb.nextLine();
		  if(str != null && !str.isEmpty())
		  {
		      String regex = "^(?=.{1,25}$)([a-zA-Z][a-zA-Z0-9_]*)";
		      Pattern pattern = Pattern.compile(regex);
		      Matcher match = pattern.matcher(str);
		      boolean result=match.find();//match.matches();
		      match.reset();
		      int UsrID=IsUser(str);
		      if(result&&UsrID>-1)
		      {

		    	String[] Temp = Getdb(UsrID);
		    	  if(Temp[3].equals("null"))
		    	  {
		    		  System.out.println("Login Failed");
		    		  System.out.println("No Password is Set, Please Visit option 2 to Resetup a Username then Option 3 to setup a Password\n\n ");
		    		  FileWriter eL = new FileWriter("errors.txt",true);
			    	  eL.append("Error @ reLogin(9): Password Fail: No Password is Set for "+str+"\n");
			    	  eL.flush();eL.close();
			    	  break;
		    	  }
		    	System.out.println("Please Enter Password");
		    	String str2= kb.nextLine();
				  if(str != null && !str.isEmpty())
				  {
				      String regex2 = "(?!.*(\\d).*\\1)(?!.*?[\\d]{2,})(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\d\\s*@$!.])[^*@$!.\\n]*$";
				      Pattern pattern2 = Pattern.compile(regex2);
				      Matcher match2 = pattern2.matcher(str2);
				      boolean result2=match2.find();//match.matches();
				      match.reset();
				      if(result2)
				      {
				    	  try 
				    	  {
						    	  MessageDigest md;
						    	  md = MessageDigest.getInstance("MD5");
						    	  md.update(Base64.getDecoder().decode(Temp[2]));
						    	  byte[] hashedPass = md.digest(str2.getBytes(StandardCharsets.UTF_8));
						    	  
						    	  if(str.equals(Temp[1])&&Base64.getEncoder().encodeToString(hashedPass).equals(Temp[3]))
						    	  { 
						    		  System.out.println("Login Successful\nWelcome "+Temp[0]+"!\n");
						    		  Valid=true;
						    		  CurrentUser=UsrID;
						    	  }
						    	  else
						    	  {
						    		  System.out.println("Login Failed Try again");
						    		  System.out.println("Please Enter A Registered Username");
						    		  FileWriter eL = new FileWriter("errors.txt",true);
							    	  eL.append("Error @ reLogin(9): Password Fail: "+str+" / "+str2 +"\n");
							    	  eL.flush();eL.close();
						    	  }
				    	  } 
				    	  catch (NoSuchAlgorithmException e) 
				    	  {
				    		  	  System.out.println("Please Enter A Registered Username");
						    	  FileWriter eL = new FileWriter("errors.txt",true);
						    	  eL.append("Error @ reLogin(9): Hash Fail: "+e+"\n");
						    	  eL.flush();eL.close();
				    	  }
				      }
				      else
				      {
				    	  System.out.println("\""+str2+"\" is NOT Valid");
				    	  System.out.println("Please Enter A Registered Username");
				    	  FileWriter eL = new FileWriter("errors.txt",true);
				    	  eL.append("Error @ reLogin(9): invalid password: "+str2+"\n");
				    	  eL.flush();eL.close();
				      }
				  }
		      }
		      else 
		      {
		    	  System.out.println("\""+str+"\" is NOT Valid");
		      	  System.out.println("Please Enter A Valid Username");
		      	  System.out.println("If this is your first Time Logging in, Please Visit option 2 to setup a Username then Option 3 to setup a Password\n\n");
		    	  FileWriter eL = new FileWriter("errors.txt",true);
		    	  eL.append("Error @ reLogin(9): invalid Username: "+str+"\n");
		    	  eL.flush();eL.close();
		    	  break;
		      }
		  }
		  else
		       System.out.println("Please Enter A Registered Username");
	      }	
	     Closedb();
	}
	
//=======================================================================
	//Database operations
	protected static int IsUser(String str)
	{
		int Present=-1;
		String[] x;
		for(int i=0;i<db.size();i++)
		{
			x=db.get(i);
			if(str.equals(x[1]))
				Present=i;
		}
		return Present;
	}
 	protected static void Opendb() throws IOException
	{
 		CurrentUser=Team6Member1.GetUserID();
 		System.out.println("Current User:"+CurrentUser+"\n");
		String line;
		File dbFile = new File("db.txt");
		if(!dbFile.exists())
			dbFile.createNewFile();
		
		BufferedReader br = Files.newBufferedReader(Paths.get("db.txt"));
		while ((line = br.readLine()) != null) 
		{
		    setDb(line.split(","));
		}
	}
	protected static void setDb(String data[])
	{
		db.add(data);
	}
 	protected static void Enterdb(String in,int y)
	{
		if(CurrentUser<0)
		{
			String[]Nrow =new String[8];
			Nrow[y]=in;
			CurrentUser=db.size();
			db.add(Nrow);
		}
		String[] Nc=db.get(CurrentUser);
		Nc[y]=in;
		db.set(CurrentUser,Nc);
	}
 	protected static void Enterdb(String[] row)
	{
		if(CurrentUser<0)
		{
			CurrentUser=db.size();
			db.add(row);
		}
		db.set(CurrentUser,row);
	}
 	protected static String[] Getdb(int i)
 	{
 		return db.get(i);
 	}
 	protected static void Closedb() throws IOException
	{
		FileWriter csvW = new FileWriter("db.txt");
		for (String[] strings : db) {
		    for (String string : strings) {
				csvW.append(string+",");
		    }
		    csvW.append("\n");
		}
  	  csvW.flush();csvW.close();
  	  db=new ArrayList <>();
  	  Team6Member1.SetUserID(CurrentUser);
	}
 	static int GetUserID()
	{return CurrentUser;}
 	static void SetUserID(int id)
 	{CurrentUser=id;}
}
