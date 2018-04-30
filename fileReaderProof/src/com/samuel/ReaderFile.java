package com.samuel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;
public class ReaderFile {
	
		  String distance;
		  String angle;
		  String type;
		  String action;
		  static float startX = 0;
		  static float startY = 0;
		  static int wayCount = 0;
		  static ArrayList data = new ArrayList<ReaderFile>();

		  public ReaderFile(String distance, String angle, String type, String action){
		       this.distance = distance;
		       this.angle = angle;
		       this.type = type;
		       this.action = action;
		  }

		  public static void printVals() {
	          System.out.println(startX);
	          System.out.println(startY);
	          System.out.println("");
	          for(int i = 0; i < data.size(); i++) {
		          System.out.println(((ReaderFile) data.get(i)).distance);
		          System.out.println(((ReaderFile) data.get(i)).angle);
		          System.out.println(((ReaderFile) data.get(i)).type);
		          System.out.println(((ReaderFile) data.get(i)).action);
		          System.out.println("");
	          }
		  }
		  public static void main(String args[]){

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
			        	  String[] info = strLine.split(" ");
			        	  
			        	  ReaderFile waypoint = new ReaderFile(info[0],info[1],info[2], info[3]);//process record , etc
			     
			        	  data.add(waypoint);
			          }
			          in.close();
		          }
		          printVals();
		          
		   }catch (Exception e){
		     System.err.println("Error: " + e.getMessage());
		   }

	}
}
