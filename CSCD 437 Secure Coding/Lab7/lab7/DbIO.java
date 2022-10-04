/**
 * 
 */
package lab7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryanc
 *
 */
public class DbIO 
{
//=======================================================================
		//Global Variables
		static int CurrentUser=-1;
		static List<String[]> db= new ArrayList <>();
//=======================================================================
	static int IsUser(String str)
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
 	static void Opendb() throws IOException
	{
 		CurrentUser=GetUserID();
 		db= new ArrayList<>();
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
	static void setDb(String data[])
	{
		db.add(data);
	}
 	static void Enterdb(String in,int y)
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
 	static void Enterdb(String[] row)
	{
		if(CurrentUser<0)
		{
			CurrentUser=db.size();
			db.add(row);
		}
		db.set(CurrentUser,row);
	}
 	static String[] Getdb(int i)
 	{
 		return db.get(i);
 	}
 	static void Closedb() throws IOException
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
  	  SetUserID(CurrentUser);
	}
 	static int GetUserID()
	{return CurrentUser;}
 	static void SetUserID(int id)
 	{CurrentUser=id;}

}
