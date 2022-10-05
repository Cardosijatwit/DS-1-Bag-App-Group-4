
package edu.wit.scds.ds.bag.app ;

import java.util.ArrayList ; 
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException;

/**
 * A class that reads a text list of grocery items, and their respective attributes, then utilizes 
 * the functions provided in the other classes within this project to place each item into a specific 
 * grocery bag based upon each item's attributes.
 * 
 * @author Jonny Cardosi
 * 
 */
public class GroceryBagger
	{
	
	/**
	 *  Main method that runs methods and prints results to console 
	 */
	public static void main( String[] args ) 
		{
		
		/*
		 * ArrayList to hold all created bags
		 */
		ArrayList< GroceryBag > bags = new ArrayList<>() ;
		
		
		/*
		 * Checks in given grocery items and places said items into existing bags based off of their
		 * traits, or creates new bags to place the items into if no matching bag for an item is found
		 */
		try 
        	{
        	Scanner groceryListReader = new Scanner( new File( "./data/groceries.txt" ) ) ; 
        	
            while ( groceryListReader.hasNextLine() ) 
            	{
            	// interprets line from .txt file and converts it into a single "grocery item"
                GroceryItem currentGroceryItem = new GroceryItem( groceryListReader.nextLine() ) ;
                
                boolean compatible = false ;
                int counter = 0 ;
                // checks existing bags for compatibility with current grocery item
                while ( !compatible && counter < bags.size() )	
                	{
                	if ( ( bags.get( counter ).checkNumberOfItems() ) &&
                		 ( bags.get( counter ).checkTotalBagWeight( currentGroceryItem.itemWeight.weightValue ) ) &&
                		 ( bags.get( counter ).bagContentWeight.weightValue == currentGroceryItem.itemWeight.weightValue ) &&
                		 ( bags.get( counter ).bagContentFirmness.firmnessValue == currentGroceryItem.itemFirmness.firmnessValue ) &&
                		 ( bags.get( counter ).bagContentFlexibility.flexibilityValue == currentGroceryItem.itemFlexibility.flexibilityValue ) )
                		{
                		bags.get( counter ).addNewGroceryItem( currentGroceryItem ) ;
                		compatible = true ;
                		}
                	                	
                	counter++ ;
                	
                	}	// end inner while{}
                
                
                // creates new bag if no compatible bags for current grocery item
                if ( !compatible ) 
                	{
                	GroceryBag newBag = new GroceryBag( currentGroceryItem ) ;
                	bags.add( newBag ) ;			 
                	}
                
            	}	// end outer while{}
             
            
            /*
             * Prints contents and traits of each bag
             */
            System.out.printf( "There are %d bags in total%n%n", bags.size() ) ;
            
            for ( int i = 0 ; i < bags.size() ; i++ ) 
            	{
            	System.out.printf( "Bag #%d%n", i + 1 ) ;
            	System.out.printf( "Traits: %s, %s, %s%n", bags.get( i ).bagContentWeight.displayName, bags.get( i ).bagContentFirmness.displayName, bags.get( i ).bagContentFlexibility.displayName ) ;
            	System.out.printf( "Contents: " ) ;
            	 
            	for ( int j = 0 ; j < bags.get( i ).returnBag().length ; j++ ) 
            	 	{
            		if ( j != bags.get( i ).returnBag().length - 1 ) 
            			{
            			System.out.printf( "%s, ", ( ( GroceryItem )( bags.get( i ).returnBag() )[ j ] ).itemName ) ;
            			}
            		else 
            			{
            			System.out.printf( "%s%n", ( ( GroceryItem )( bags.get( i ).returnBag() )[ j ] ).itemName ) ;
            			}
            		
            	 	}	// end inner for()
            	 
            	System.out.printf( "Total Weight: %d pounds%n%n", bags.get( i ).returnTotalBagWeight() ) ;
            	 
            	}	// end outer for()
           
            
            groceryListReader.close() ;
            
        	}	// end try{}
		
		
		catch ( FileNotFoundException a ) 
			{
			System.out.printf( "The file defined by the path \"./data/groceries.txt\" was not found.%n" ) ;
			}
		
		catch ( Exception b ) 
			{
			System.out.printf( "%n" ) ;
			b.printStackTrace() ;
			
			}	// end catch{}
		
		
		}	// end main()
	
	
	}	// end class GroceryBagger
