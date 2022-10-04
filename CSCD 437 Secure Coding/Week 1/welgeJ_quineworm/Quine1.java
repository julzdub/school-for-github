import java.io.*;
import java.util.Scanner;
import java.nio.file.*;


public class Quine1 {
    public static void main(String args[]){
        String fileName = "Quine1";

        if(fileName.equals("Quine3")){
            System.exit(0);
        }

        String s ="";
        String newFileName ="";
        File f = new File("Quine1.java");
        File newFile = new File("Quine2.java");


        try {

            String line;
            int counter = 0;
            Scanner sc = new Scanner(f);
            FileWriter fileWriter = new FileWriter(newFile);

            while (sc.hasNextLine()) {

                line = sc.nextLine();

                if(line.contains(fileName))
                {
                    int i =line.indexOf(fileName) + 5;
                    String charS = "";
                    charS += line.charAt(i);
                    char newNumber = Integer.toString(Integer.parseInt(charS)+1).charAt(0);
                    
                    StringBuilder newString = new StringBuilder (line);
                    newString.setCharAt(i, newNumber);

                    line = newString.toString();
                    newFileName = "Quine"+ newNumber;
                    counter++;
                }

                else if(counter == 3)
                {
                    int i =line.indexOf("Quine") + 5;
                    String charS = "";
                    charS += line.charAt(i);
                    char newNumber = Integer.toString(Integer.parseInt(charS)+1).charAt(0);

                    StringBuilder newString = new StringBuilder (line);
                    newString.setCharAt(i, newNumber);

                    line = newString.toString();
                    counter = 0;
                }

                s += line;
                s += '\n';
                fileWriter.write(line);
                fileWriter.write('\n');
            }

            fileWriter.flush();
            fileWriter.close();


            System.out.print(s);
            sc.close();

            Process pro1 = Runtime.getRuntime().exec("javac "+ newFileName + ".java");
            pro1.waitFor();
            Process pro2 = Runtime.getRuntime().exec("java "+ newFileName);

        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
