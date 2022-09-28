
package edu.wit.scds.ds.bag.app ;

import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException;



public class Testing_stuff 
	{

	public static void main(String[] args) 
		{
		
		try 
			{
			Scanner grocerylistreader = new Scanner( new File( "./data/groceries.txt" ) ) ;
			String line = grocerylistreader.nextLine() ;
			String[] splits = line.split("\t") ;
			for (int i = 0; i < splits.length; i++ ) {
				System.out.println(splits[i]) ;
			}
			
			// while (grocerylistreader.hasNextLine()) 
				{
				
				}
			}
		
		catch (FileNotFoundException e) 
			{
			System.out.printf( "The file defined by the path \"./data/groceries.txt\" was not found" ) ;
			}
		
		}

	}
