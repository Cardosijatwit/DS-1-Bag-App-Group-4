package edu.wit.scds.ds.bag.app;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;
import java.util.ArrayList ; 
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException;


/**
 * 
 * A class that is passed an array containing an individual grocery item and its respective attributes. 
 * The class then interprets the attributes of said item and places the item into a specific bag pertaining to 
 * the item's specific attributes, making a new bag to place the item into if necessary. 
 * 
 * @author Jonny Cardosi
 *
 */

public class ItemInterpreter 
	{	

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
        
        

