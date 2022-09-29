
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
	private static ArrayList<Object[]> bags = new ArrayList<Object[]>() ; 
	
	/**
	 *  ArrayList that holds the traits of the items in each corresponding bag
	 */
	private static ArrayList<Object[]> traits = new ArrayList<Object[]>() ; 
	
	
	/**
	 *  Main method
	 */
	public static void main( String[] args ) 
		{
		
        // reads groceries.txt line by line, turning each item and its attributes into separate arrays.
		// places item and enumerated traits into separate but corresponding ArrayLists, seen above.
		try 
        	{
        	Scanner groceryListReader = new Scanner( new File( "./data/groceries.txt" ) ) ; 
        	
            while ( groceryListReader.hasNextLine() ) 
            	{
                String[] groceryListIndividualLine = groceryListReader.nextLine().split( "\t" ) ;
                String groceryItem = groceryListIndividualLine[ 0 ] ;
                String[] itemTraits = { groceryListIndividualLine[ 2 ], groceryListIndividualLine[ 3 ], groceryListIndividualLine[ 4 ] } ;
                Object[] enumItemTraits = ItemInterpreter.traitInterpreter( itemTraits ) ;	// {firmness, weight, flexibility}
                
                GroceryItemFirmness tempTrait1 = (GroceryItemFirmness)enumItemTraits[0] ;
                int firmnessValue = tempTrait1.firmnessValue ;
                GroceryItemWeight tempTrait2 = (GroceryItemWeight)enumItemTraits[1] ;
                int weightValue = tempTrait2.firmnessValue ;
                GroceryItemFlexibility tempTrait3 = (GroceryItemFlexibility)enumItemTraits[2] ;
                int flexibilityValue = tempTrait3.flexibilityValue ;
                
                ResizableArrayBag< Object > bagEnumItemTraits = new ResizableArrayBag< Object >( enumItemTraits ) ;
                bagEnumItemTraits.add( weightValue ) ;
                ResizableArrayBag< Object > bagGroceryItem = new ResizableArrayBag< Object >() ;
                bagGroceryItem.add( groceryItem ) ;
                
                boolean compatible = false ;
                int counter = 0 ;
                while ( compatible == false && counter < traits.size() )
                	{
                	for ( int j = 0 ; j < traits.get( counter ).length ; j++ )
                		{
                		if ( bagEnumItemTraits.contains(traits.get( counter )[0]) ) 
                			{
                			
                			}
                		}
                	}
               
                
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
