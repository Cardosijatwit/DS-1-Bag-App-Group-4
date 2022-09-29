
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;
import java.util.ArrayList ; 
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException;

/**
 * A class that reads a text list of grocery items and their respective attributes, then utilizes the functions 
 * provided in the GroceryItem class to place each item into a specific bag based upon each item's attributes.
 * 
 * @author Jonny Cardosi
 *
 *@param <T> 
 *		class of items held within each bag
 *
 */
public class GroceryBagger<T>
	{
	public static void main( String[] args ) 
		{
		
		
        // reads groceries.txt line by line, turning each item and its attributes into individual arrays
		try 
        	{
        	Scanner grocerylistreader = new Scanner( new File( "./data/groceries.txt" ) ) ; 
            while (grocerylistreader.hasNextLine()) 
            	{
                String[] splitline = grocerylistreader.nextLine().split( "\t" ) ;
                
                
                }
		
        	}
		
		catch ( FileNotFoundException a ) 
			{
			System.out.printf( "The file defined by the path \"./data/groceries.txt\" was not found.%n" ) ;
			}
		
		catch ( Exception b ) 
			{
			System.out.printf( "The file defined by the path \"./data/groceries.txt\" was not found, is corrupt, "
							 + "or there was an error in opening the file.%n" ) ;
			b.printStackTrace() ;
			}
		
	
		}
	}
