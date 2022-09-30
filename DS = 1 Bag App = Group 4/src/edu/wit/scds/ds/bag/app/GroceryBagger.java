
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;
import java.util.ArrayList ; 
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException;

/**
 * A class that reads a text list of grocery items and their respective attributes, then utilizes 
 * the functions provided in the ItemInterpreter and ResizableArrayBag class to place each item into 
 * a specific bag based upon each item's attributes.
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
	 *  Main method that runs application and prints results to console 
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
                String newGroceryItem = groceryListIndividualLine[ 0 ] ;
                String[] itemTraits = { groceryListIndividualLine[ 2 ], groceryListIndividualLine[ 3 ], groceryListIndividualLine[ 4 ] } ;
                Object[] enumItemTraits = ItemInterpreter.traitInterpreter( itemTraits ) ;	// {firmness, weight, flexibility}
                
                
                ResizableArrayBag< Object > bagEnumItemTraits = new ResizableArrayBag< Object >( enumItemTraits ) ;
                GroceryItemWeight tempTrait1 = ( GroceryItemWeight )enumItemTraits[ 1 ] ;
                int newWeightValue = tempTrait1.firmnessValue ;
                
                
                boolean compatible = false ;
                int counter1 = 0 ;
                int counter2 = 0 ;
                while ( compatible == false && counter1 < traits.size() )
                	{
                	for ( int j = 0 ; j < 3 - 1 ; j++ )
                		{
                		if ( bagEnumItemTraits.contains( traits.get( counter1 )[ j ] ) ) 
                			{
                			counter2 ++ ;
                			}
                		}

                	int bagTotalWeightValue = (int) traits.get( counter1 )[ 3 ] ;
                	if ( bagTotalWeightValue + newWeightValue <= 10 && counter2 == 3 ) 
                		{
                		ResizableArrayBag< Object > tempBagGroceryItems = new ResizableArrayBag< Object >( bags.get( counter1 ) ) ;
                		tempBagGroceryItems.add( newGroceryItem ) ;
                		bags.add( counter1, tempBagGroceryItems.toArray() ) ;
                		bags.remove( counter1 + 1 ) ;
                		traits.get( counter1 )[3] = (int) traits.get( counter1 )[3] + newWeightValue ;
                 		compatible = true ;
                 		
                		}
                	
                	counter1++ ;
                	
                	}	// end while#1
                
                if ( !compatible ) 
        			{
                	ResizableArrayBag< Object > tempBagGroceryItems = new ResizableArrayBag< Object >() ;
                	tempBagGroceryItems.add( newGroceryItem ) ;
        			bags.add( tempBagGroceryItems.toArray() ) ;
        			ResizableArrayBag< Object > tempBagItemTraits = new ResizableArrayBag< Object >( enumItemTraits ) ;
        			tempBagItemTraits.add( newWeightValue ) ;
        			traits.add( tempBagItemTraits.toArray() ) ;
        			 
        			}
               
            	}	// end while#2
            
            
            groceryListReader.close() ;
            
        	}	// end try{}
		
		catch ( FileNotFoundException a ) 
			{
			System.out.printf( "The file defined by the path \"./data/groceries.txt\" was not found.%n" ) ;
			}
		
		catch ( Exception b ) 
			{
			System.out.printf( "The file defined by the path \"./data/groceries.txt\" was not found, is corrupt, "
							 + "or there was an error in opening the file.%n" ) ;
			b.printStackTrace() ;
			
			}	// end catch{}
		
		}	// end main()
	
	}	// end class GroceryBagger
