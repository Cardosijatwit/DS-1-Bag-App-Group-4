
package edu.wit.scds.ds.bag.app;

/**
 * A class that allows for the creation of a "grocery item" object that holds all of the necessary
 * information about an individual grocery item
 * 
 * @author Jonny Cardosi
 *
 */
public class GroceryItem
	{
	
	public final String itemName ;
	public final GroceryItemFirmness itemFirmness ; 
	public final GroceryItemWeight itemWeight ;
	public final GroceryItemFlexibility itemFlexibility ;
	
	
	public GroceryItem ( String[] itemAndTraits )
		{
		this.itemName = itemAndTraits[0] ;
		this.itemFirmness = ItemInterpreter.firmnessInterpreter(itemAndTraits[1]) ;
		this.itemWeight = ItemInterpreter.weightInterpreter(itemAndTraits[2]) ;
		this.itemFlexibility = ItemInterpreter.flexibilityInterpreter(itemAndTraits[3]) ;
		
		}	// end 1-arg (current item) constructor
	
	
	}	// end class GroceryItem
