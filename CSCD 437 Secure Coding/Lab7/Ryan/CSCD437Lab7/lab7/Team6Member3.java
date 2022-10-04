package lab7;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/*
@author Julian Welge
 */

public class Team6Member3 {

    private static File outputFile = null;

    public static void ReadOutputFileName(Scanner kb) throws IOException {
        boolean Valid = false;
        while(!Valid)
        {
            String str= kb.nextLine();
            if(str != null && !str.isEmpty())
            {
                String regex = "^[\\w,\\s-]+\\.txt"; //file has to end in .txt
                Pattern pattern = Pattern.compile(regex);
                Matcher match = pattern.matcher(str);
                boolean result = match.find();//match.matches();
                match.reset();
                if(result)
                {
                    System.out.println("\""+str+"\" is Accepted\n");
                    Valid=true;
                    File temp = new File(str);
                    if(temp.exists() && temp.canRead() && temp.canWrite()) {
                        outputFile = temp;
                        //need to check project folder specifically w regex somehow
                    }
                    else {
                        System.out.println("File not found in project directory.");
                    }
                }
                else
                {
                    System.out.println("\""+str+"\" is NOT Valid");
                    FileWriter eL = new FileWriter("errors.txt",true);
                    eL.append("Error @ EnterOutputFileName(7): \""+str+"\" attempted\n");
                    eL.flush();eL.close();
                }
                System.out.println("Please Enter A Valid File Name");
            }
            else
                System.out.println("Please Enter A Valid File Name");
        }
    }

    public static void OpenOutputFile(Scanner kb) {

    }
}
