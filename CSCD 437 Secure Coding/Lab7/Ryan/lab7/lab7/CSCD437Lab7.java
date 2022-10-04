/*
 * Ryan Cranston, Petal Michaud, Julian Welge 
 * Team 6
 */

package lab7;

import java.io.*;
import java.util.*;


public class CSCD437Lab7 
{
	public static void main(String [] args) throws IOException
   {
      Scanner kb = new Scanner(System.in);
      int choice =  10;
      
      do
      {
         choice = menu(kb);
         
         switch(choice)
         {
            case 1:  System.out.println("1) First name and last name");
            		Team6Member1.ReadName(kb);
                     break;
                     
            case 2:  System.out.println("2) Username");
            		Team6Member1.ReadUsername(kb);
                     break;
                     
            case 3:  System.out.println("3) Password");
    				Team6Member1.ReadPassword(kb);
                     break;
         
            case 4:  System.out.println("4) Email");
                     break;
                     
            case 5:  System.out.println("5) Two integers");
                     break;
                     
            case 6:  System.out.println("6) Input file name");
                     break;
                     
            case 7:  System.out.println("7) Output file name");
                     Team6Member3.ReadOutputFileName(kb);
                     break;
                     
            case 8:  System.out.println("8) Output file");
                     Team6Member3.OpenOutputFile();
                     break;
                     
            case 9:  System.out.println("9) Relogin");
            		 Team6Member1.ReLogin(kb);
                     break;
                     
            default: System.out.println("10) Quit");
         
         }// emd switch
       
      }while(choice != 10);   
   
   
   }// end main
   
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad Scanner menu");
       
      int choice; 
         
      do
      {
         System.out.println(" 1) Enter first name and last name");
         System.out.println(" 2) Enter username");
         System.out.println(" 3) Enter password");
         System.out.println(" 4) Enter email");
         System.out.println(" 5) Read two integers");
         System.out.println(" 6) Enter the input file name");
         System.out.println(" 7) Enter the output file name");
         System.out.println(" 8) Write to the output file");
         System.out.println(" 9) Please relogin");
         System.out.println("10) Quit");
         System.out.print("Choice --> ");
      
         choice = kb.nextInt();      
      
      }while(choice < 1 || choice > 10);
      
      return choice;
   
   }// end menu
   
}// end class