
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
	 *  Main method that runs application and prints results to console 
	 */
	public static void main( String[] args ) 
		{
		
		// ArrayList to hold all created bags
		ArrayList< GroceryBag > bags = new ArrayList<>() ;
		
		try 
        	{
        	Scanner groceryListReader = new Scanner( new File( "./data/groceries.txt" ) ) ; 
        	
            while ( groceryListReader.hasNextLine() ) 
            	{
                GroceryItem currentGroceryItem = new GroceryItem( groceryListReader.nextLine() ) ;
                
                boolean compatible = false ;
                int counter = 0 ;
                while ( !compatible && counter < bags.size() )
                	{
                	if ( ( bags.get( counter ).checkTotalBagWeight( currentGroceryItem.itemWeight.weightValue ) ) &&
                		 ( bags.get( counter ).bagContentWeight.weightValue == currentGroceryItem.itemWeight.weightValue ) &&
                		 ( bags.get( counter ).bagContentFirmness.firmnessValue == currentGroceryItem.itemFirmness.firmnessValue ) &&
                		 ( bags.get( counter ).bagContentFlexibility.flexibilityValue == currentGroceryItem.itemFlexibility.flexibilityValue ) )
                		{
                		bags.get( counter ).addNewGroceryItem( currentGroceryItem ) ;
                		bags.get( counter ).increaseTotalBagWeight( currentGroceryItem.itemWeight.weightValue ) ;
                		compatible = true ;
                		}
                	                	
                	counter++ ;
                	
                	}	// end inner while{}
                
                if ( !compatible ) 
                	{
                	GroceryBag newBag = new GroceryBag( currentGroceryItem ) ;
                	bags.add( newBag ) ;			 
                	}
                
            	}	// end outer while{}
             
            
            System.out.printf( "There are %d bags in total%n%n", bags.size() ) ;
            for (int i = 0 ; i < bags.size(); i++ ) 
            	{
            	System.out.printf( "Bag #%d Traits: %s, %s, %s%n", i + 1, bags.get( i ).bagContentFirmness.displayName, bags.get( i ).bagContentWeight.displayName, bags.get( i ).bagContentFlexibility.displayName ) ;
            	System.out.printf("Total Weight: %d pounds%n%n", bags.get( i ).returnTotalBagWeight() ) ;
            	}
           
            
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