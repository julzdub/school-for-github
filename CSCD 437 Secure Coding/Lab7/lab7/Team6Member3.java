package lab7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.*;

/**
 * @author Julian Welge
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
                            eL.flush();
                            eL.close();
                            Valid = false;
                        }

                    }

                    else {
                        System.out.println("Creating output file...");
                        FileWriter eL = new FileWriter(str,true);
                        eL.flush();
                        eL.close();
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
                    eL.flush();
                    eL.close();
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
            System.out.println("output file null. Complete step 7 by entering a name of an output file.\n");
            return;
        }

        BufferedWriter br = Files.newBufferedWriter(outputFile.toPath());
        DbIO.Opendb();

        int currentUserID = DbIO.GetUserID();
        String [] userDbContent = DbIO.Getdb(currentUserID);

        if(userDbContent[0] != null) {
            br.append(userDbContent[0] + ", ");
        }

        if(userDbContent[3] != null) {
            br.append(userDbContent[4] + "\n");
        }

        // ----------- integer math & handling ---------------

        if(userDbContent[5] != null && userDbContent[6] != null) {
            Long addition = Long.valueOf(userDbContent[5]) + Long.valueOf(userDbContent[6]);
            Long multiplication = Long.valueOf(userDbContent[5]) * Long.valueOf(userDbContent[6]);

            boolean signFlag = false;//true for positive
            if(Long.valueOf(userDbContent[5]) > 0 && Long.valueOf(userDbContent[6]) > 0) {
                signFlag = true;
            }

            if(Long.valueOf(userDbContent[5]) < 0 && Long.valueOf(userDbContent[6]) < 0) {
                signFlag = true;
            }

            if(addition >= Long.MAX_VALUE || addition <= Long.MIN_VALUE) {
                System.out.println("Integers are to long to add.\n");
                FileWriter eL = new FileWriter("errors.txt",true);
                eL.append("Error @ EnterOutputFile(8): Integers are too long to add.");
                eL.flush();
                eL.close();
            }
            else {
                br.append("Two integers added: " + addition.toString() + ", ");
            }

            if((multiplication >= Long.MAX_VALUE || multiplication <= Long.MIN_VALUE) && (multiplication > 0 && signFlag == false)) {
                System.out.println("Integers are to long to multiply.\n");
                FileWriter eL = new FileWriter("errors.txt",true);
                eL.append("Error @ EnterOutputFile(8): Integers are too long to multiply.");
                eL.flush();
                eL.close();
            }
            else {
                br.append("Two integers multiplied: " + multiplication.toString() + ", ");
            }
        }

        //------------- reading input file ------------------------

        File inputFile = new File(userDbContent[7]);

        if(inputFile.exists()) {
            BufferedReader brinput = Files.newBufferedReader(Paths.get(userDbContent[7]));
            while(brinput.readLine() != null) {
                br.append(brinput.readLine());
            }
            brinput.close();
        }

        // ---------------------------------------------------------

        br.flush();
        br.close();
        DbIO.Closedb();

        System.out.println(outputFile.getName() + " has been written to.\n");
    }
}
