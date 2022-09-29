package edu.wit.scds.ds.bag.app;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;
import java.util.ArrayList ; 
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException;


/**
 * 
 * A class that is individually passed a grocery item's respective traits as strings, and then
 * then interprets the traits of said item and places the item into a specific bag pertaining to 
 * the item's specific traits, making a new bag to place the item into if necessary. 
 * 
 * @author Jonny Cardosi
 *
 */

public class ItemInterpreter 
	{	

	
	/**
	 * Takes in an item's traits as a String[] and converts them to their appropriate enums
	 * 
	 * @param itemTraits
	 * 
	 * @return
	 * 		an array of the enumerated itemTraits
	 */
	public static Object[] traitInterpreter( String[] itemTraits ) 
		{
		GroceryItemFirmness firmness = firmnessInterpreter( itemTraits[ 0 ] ) ;
        GroceryItemWeight weight = weightInterpreter( itemTraits[ 1 ] ) ;
        GroceryItemFlexibility flexibility = flexibilityInterpreter( itemTraits[ 2 ] ) ;
        Object[] enumeratedItemTraits = {firmness, weight, flexibility} ;
        
		return  enumeratedItemTraits ;
				
		}
	
	
	/**
	 * Takes in an item's firmness trait as a string and converts it to the appropriate enum
	 * 
	 * @param itemTrait
	 * 
	 * @return 
	 * 		the enum the itemTrait string is referring to
	 */
	private static GroceryItemFirmness firmnessInterpreter( String itemTrait )
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
	private static GroceryItemWeight weightInterpreter( String itemTrait )
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
	private static GroceryItemFlexibility flexibilityInterpreter( String itemTrait )
		{
		GroceryItemFlexibility enumTrait = GroceryItemFlexibility.interpretDescription( itemTrait ) ;
		return enumTrait ;
		
		}
	
	
	
	
	
	
	
	}
        
        

