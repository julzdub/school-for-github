Names:
==============================
 Ryan Cranston, Petal Michaud, Julian Welge   
 Team 6

Considerations & Complications
=============================
-db.txt and error.txt are made on start up if not found in project.
-Does not keep from same usernames being used for multiple accounts.
-Can enter input before entering username and password which will go into db.txt before solidifying username and password.
-Accepts error.txt and db.txt as input files which can be written to output files.
-Will create output file on entering output file name if file is not found.
-Does not create input file if input file not found.
-Logic around safe integer addition & multiplication is finicky. 
-Database was written to separate class.
-After enter a valid entry, logic currently presents prompt to enter a valid entry again before prompting menu.
-Accepts extensions for email beyond .net/.com for example .jpeg
-Reader to read input file to output might not be starting in correct position..

How to Compile
==============================
Javac lab7/CSCD437Lab7.java
Javac lab7/Team6Member1.java
Javac lab7/Team6Member2.java
Javac lab7/Team6Member3.java

How to Run
==============================
Java lab7.CSCD437Lab7