package lab7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                if(result && str.compareTo("db.txt") != 0 && str.compareTo("error.txt") != 0)
                {
                    System.out.println("\""+str+"\" is Accepted\n");
                    Valid=true;

                    System.out.println("Looking for file in directory...");
                    //Path projectDir = Paths.get(System.getProperty("user.dir"));

                    File temp = new File(str);

                    if(temp.exists()) {

                        System.out.println("File found.");

                        if(temp.canWrite() && temp.canRead()) {
                            outputFile = temp;
                            System.out.println("output file saved.");
                        }
                        else {
                            System.out.println("\""+str+"\" exists but does not have read & write privileges.\n");
                            FileWriter eL = new FileWriter("errors.txt",true);
                            eL.append("Error @ EnterOutputFileName(7): \""+str+"\" does not have read & write privileges\n");
                            eL.flush();eL.close();
                            Valid = false;
                        }

                    }

                    else {
                        System.out.println("Creating output file...");
                        FileWriter eL = new FileWriter(str,true);
                        eL.flush();eL.close();
                        System.out.println(str + " output file created.");
                        outputFile = temp;
                        System.out.println("output file saved.");
                    }

                }

                else
                {
                    System.out.println("\""+str+"\" is NOT Valid");
                    FileWriter eL = new FileWriter("errors.txt",true);
                    eL.append("Error @ EnterOutputFileName(7): \""+str+"\" attempted\n");
                    eL.flush();eL.close();
                }

                System.out.println("Please Enter A Valid File Name ending in .txt (db.txt and error.txt are not allowed).");
            }

            else  {
                System.out.println("Please Enter A Valid File Name ending in .txt (db.txt and error.txt are not allowed).");
            }
        }
    }

    public static void OpenOutputFile() throws IOException {
        if(outputFile == null) {
            throw new IOException("output file null.");
        }

        BufferedWriter br = Files.newBufferedWriter(outputFile.toPath());
        DbIO.Opendb();
        int currentUserID = DbIO.GetUserID();
        String [] userDbContent = DbIO.Getdb(currentUserID);
        String [] userFullName = userDbContent[0].split(" ");

        br.append(userFullName[1] + ", " + userFullName[1]);

        br.flush();br.close();
        DbIO.Closedb();

        System.out.println(outputFile.getName() + " has been written to.\n");
    }
}
