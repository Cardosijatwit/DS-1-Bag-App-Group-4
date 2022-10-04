
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
	public final GroceryItemWeight itemWeight ;
	public final GroceryItemFirmness itemFirmness ; 
	public final GroceryItemFlexibility itemFlexibility ;
	
	
	public GroceryItem( String groceryListIndividualLine )
		{
		String[] groceryListSplitLine = groceryListIndividualLine.split( "\t" ) ;
		String[] splitLineRelevantElements = { groceryListSplitLine[ 0 ], groceryListSplitLine[ 2 ], groceryListSplitLine[ 3 ], groceryListSplitLine[ 4 ] } ;
		this.itemName = splitLineRelevantElements[0] ;
		this.itemWeight = ItemInterpreter.weightInterpreter(splitLineRelevantElements[1]) ;
		this.itemFirmness = ItemInterpreter.firmnessInterpreter(splitLineRelevantElements[2]) ;
		this.itemFlexibility = ItemInterpreter.flexibilityInterpreter(splitLineRelevantElements[3]) ;
		
		}	// end 1-arg (current line) constructor
	
	
	}	// end class GroceryItem
