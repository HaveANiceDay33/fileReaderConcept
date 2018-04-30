package com.samuel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
public class ReaderFile {
	
		  String distance;
		  String angle;
		  String type;
		  String action;

		  public ReaderFile(String distance, String angle, String type, String action){
		       this.distance = distance;
		       this.angle = angle;
		       this.type = type;
		       this.action = action;
		  }

		  public static void main(String args[]){
		   try{
		    FileInputStream fstream = new FileInputStream("Right Corner.txt");
		          DataInputStream in = new DataInputStream(fstream);
		          BufferedReader br = new BufferedReader(new InputStreamReader(in));
		          String strLine;
		          while ((strLine = br.readLine()) != null)   {
		        	  String[] tokens = strLine.split(" ");
		        	  ReaderFile record = new ReaderFile(tokens[0],tokens[1],tokens[2], tokens[3]);//process record , etc
		          }
		          in.close();
		   }catch (Exception e){
		     System.err.println("Error: " + e.getMessage());
		   }

	}
}
