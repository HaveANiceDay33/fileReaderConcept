package com.samuel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
public class ReaderFile {
	
		  String distance;
		  String angle;
		  String type;
		  String action;
		  static int wayCount = 0;

		  public ReaderFile(String distance, String angle, String type, String action){
		       this.distance = distance;
		       this.angle = angle;
		       this.type = type;
		       this.action = action;
		  }

		  public static void main(String args[]){
			  float startX = 0;
			  float startY = 0;
		   try{
		    FileInputStream fstream = new FileInputStream("Right Corner.txt");
		          DataInputStream in = new DataInputStream(fstream);
		          BufferedReader br = new BufferedReader(new InputStreamReader(in));
		          String strLine;
		          if(wayCount == 0) {
		        	  strLine= br.readLine();
		        	  String[] initItems = strLine.split(" ");
		        	  ReaderFile start = new ReaderFile(initItems[0],initItems[1],initItems[2],initItems[3]);
		        	  startX = Float.parseFloat(start.distance);
		        	  startY = Float.parseFloat(start.angle);
		        	  wayCount++;
		          }
		          if(wayCount > 0) {
			          while ((strLine = br.readLine()) != null)   {
			        	  String[] tokens = strLine.split(" ");
			        	  ReaderFile waypoint = new ReaderFile(tokens[0],tokens[1],tokens[2], tokens[3]);//process record , etc
			          }
			          in.close();
		          }
		          System.out.println(startX);
		          
		   }catch (Exception e){
		     System.err.println("Error: " + e.getMessage());
		   }

	}
}
