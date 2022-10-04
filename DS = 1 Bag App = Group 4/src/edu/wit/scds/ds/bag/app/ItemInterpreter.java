
package edu.wit.scds.ds.bag.app;

/**
 * 
 * A class that is passed an individual grocery item's traits as strings and converts said traits 
 * into their corresponding enum equivalents.
 * 
 * @author Jonny Cardosi & Darrian Yang 
 *
 */

public class ItemInterpreter
	{	
	
	/**
	 * Takes in an item's weight trait as a string and converts it to the appropriate enum
	 * 
	 * @param itemTrait
	 * 
	 * @return 
	 * 		the enum the itemTrait string is referring to
	 */
	public static GroceryItemWeight weightInterpreter( String itemTrait )
		{
		GroceryItemWeight enumTrait = GroceryItemWeight.interpretDescription( itemTrait ) ;
		return enumTrait ;
		
		}
	
	
	/**
	 * Takes in an item's firmness trait as a string and converts it to the appropriate enum
	 * 
	 * @param itemTrait
	 * 
	 * @return 
	 * 		the enum the itemTrait string is referring to
	 */
	public static GroceryItemFirmness firmnessInterpreter( String itemTrait )
		{
		GroceryItemFirmness enumTrait = GroceryItemFirmness.interpretDescription( itemTrait ) ;
		return enumTrait ;
		
		}
	/**
	 * Takes in an item's flexibility trait as a string and converts it to the appropriate enum
	 * 
	 * @param itemTrait
	 * 
	 * @return 
	 * 		the enum the itemTrait string is referring to
	 */
	public static GroceryItemFlexibility flexibilityInterpreter( String itemTrait )
		{
		GroceryItemFlexibility enumTrait = GroceryItemFlexibility.interpretDescription( itemTrait ) ;
		return enumTrait ;
		
		}
	
	}
        
        

