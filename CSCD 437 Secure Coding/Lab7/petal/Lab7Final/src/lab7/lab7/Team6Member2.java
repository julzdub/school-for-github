package lab7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.*;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Team6Member2 {
	
	public static void ReadEmail(Scanner kb) throws IOException
	{
		DbIO.Opendb();
		  boolean Valid = false;
	      while(!Valid)
	      {
	      String str= kb.nextLine();
		  if(str != null && !str.isEmpty())
		  {
		      String regex = "^(?!.*\\\\.\\\\.)((.*[^\\\\.\\\\n@])@([^@\\\\n].*[^\\\\.\\\\n])|@[^\\\\.@].*[^\\\\.\\\\n])";//EMAIL REGEX
		      Pattern pattern = Pattern.compile(regex);
		      Matcher match = pattern.matcher(str);
		      boolean result=match.find();//match.matches();
		      match.reset();
		      if(result)
		      {
		    	System.out.println("\""+str+"\" is Accepted\n");
		    	Valid=true;
		    	DbIO.Enterdb(str,4);
		      }
		      else 
		      {
		    	  System.out.println("\""+str+"\" is NOT Valid");
		    	  FileWriter eL = new FileWriter("errors.txt",true);
			    	eL.append("Error @ EnterEmail(1): \""+str+"\" attempted\n");
			    	eL.flush();eL.close();
		      }
		      	  System.out.println("Please Enter A Valid Email");
		  }
		  else
		       System.out.println("Please Enter a valid email");
	      }
	      //kb.close();
	      DbIO.Closedb();
	}
	
	public static void ReadInt(Scanner kb) throws IOException
	{
		DbIO.Opendb();
		  boolean Valid = false;
		  int count =0;
		  
		  while (count <2) {
			  
	      while(!Valid)
	      {
	      String str= kb.nextLine();
		  if(str != null && !str.isEmpty())
		  {
		      String regex = "[0-9 \\-]";//INTEGER REGEX
		      Pattern pattern = Pattern.compile(regex);
		      Matcher match = pattern.matcher(str);
		      boolean result=match.find();//match.matches();
		      match.reset();
		      if(result)
		      {
		    	System.out.println("\""+str+"\" is Accepted\n");
		    	if(count == 0) {
					DbIO.Enterdb(str,5);
				}
		    	if(count == 1) {
					DbIO.Enterdb(str,6);
					Valid = true;
				}
		    	count++;
		      }
		      else 
		      {
		    	  System.out.println("\""+str+"\" is NOT Valid");
		    	  FileWriter eL = new FileWriter("errors.txt",true);
			    	eL.append("Error @ EnterInteger(1): \""+str+"\" attempted\n");
			    	eL.flush();eL.close();
		      }
		      	  System.out.println("Please Enter A Valid int");
		  }
		  else
		       System.out.println("Please Enter a valid int");
	      }
		  }
	      DbIO.Closedb();
	}
	
	public static void ReadInputFile(Scanner kb) throws IOException
	{
		DbIO.Opendb();
		  boolean Valid = false;
	      while(!Valid)
	      {
	      String str= kb.nextLine();
		  if(str != null && !str.isEmpty())
		  {
		      String regex = "^[a-zA-Z0-9.]+\\.(txt)$";//FILE REGEX
		      Pattern pattern = Pattern.compile(regex);
		      Matcher match = pattern.matcher(str);
		      boolean result=match.find();//match.matches();
		      match.reset();
		      if(result)
		      {
		    	System.out.println("\""+str+"\" is Accepted\n");
		    	Valid=true;
		    	DbIO.Enterdb(str,7);
		      }
		      else 
		      {
		    	  System.out.println("\""+str+"\" is NOT Valid");
		    	  FileWriter eL = new FileWriter("errors.txt",true);
			    	eL.append("Error @ EnterFileName(1): \""+str+"\" attempted\n");
			    	eL.flush();eL.close();
		      }
		      	  System.out.println("Please Enter A Valid FileName with letters and numbers only");
		  }
		  else
		       System.out.println("Please Enter a valid file name");
	      }
	      //kb.close();
	      DbIO.Closedb();
		
	      //CONFIRM THE FILE EXISTS?
	      //MAKE SURE FILE IS IN THE SAME DIRECTORY AS JAVA FILES????
	      
	}
}
