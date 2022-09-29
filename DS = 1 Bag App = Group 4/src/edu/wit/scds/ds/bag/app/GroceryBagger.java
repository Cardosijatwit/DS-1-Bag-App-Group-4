
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
public class GroceryBagger<U>
	{
	
	/**
	 *  ArrayList that stores all of the bags for the grocery items
	 */
	private ArrayList<U> bags = new ArrayList<U>() ; 
	
	/**
	 *  ArrayList that holds the traits of the items in each corresponding bag
	 */
	private ArrayList<U> traits = new ArrayList<U>() ; 
	
	
	/**
	 *  Main method
	 */
	public static void main( String[] args ) 
		{
		
        // reads groceries.txt line by line, turning each item and its attributes into separate arrays.
		// places item and enumerated traits into separate but corresponding ArrayLists as seen above.
		try 
        	{
        	Scanner groceryListReader = new Scanner( new File( "./data/groceries.txt" ) ) ; 
        	
            while ( groceryListReader.hasNextLine() ) 
            	{
                String[] groceryListIndividualLine = groceryListReader.nextLine().split( "\t" ) ;
                String groceryItem = groceryListIndividualLine[ 0 ] ;
                String[] itemTraits = { groceryListIndividualLine[ 2 ], groceryListIndividualLine[ 3 ], groceryListIndividualLine[ 4 ] } ;
                GroceryItemFirmness firmness = ItemInterpreter.firmnessInterpreter( itemTraits[ 0 ] ) ;
                GroceryItemWeight weight = ItemInterpreter.weightInterpreter( itemTraits[ 1 ] ) ;
                GroceryItemFlexibility flexibility = ItemInterpreter.flexibilityInterpreter( itemTraits[ 2 ] ) ;
                Object[] enumItemTraits = {firmness, weight, flexibility} ; 
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
