
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;

/**
 * A class that allows for the creation of a "grocery bag" that holds a collection of 
 * "grocery items", as well as all of the necessary information about the grocery bag itself
 * 
 * @author Jonny Cardosi
 *
 */
public class GroceryBag
	{
	
	/*
	 * Limiters for how much a bag can take
	 */
	private static final int ITEMLIMIT = 4 ;
	private static final int WEIGHTLIMIT = 10 ;
	
	/*
	 * Attributes of each bag
	 */
	private BagInterface< GroceryItem > bag = new ResizableArrayBag<>() ;  
	private int totalBagWeight = 0 ;	// private variables can't be final here due to possible future additions to any bag
	private int numberOfItems = 0 ;   
	public final GroceryItemWeight bagContentWeight ;
	public final GroceryItemFirmness bagContentFirmness ;
	public final GroceryItemFlexibility bagContentFlexibility ;
	
	
	/**
	 * Creates a new grocery bag with the given grocery item and corresponding bag attributes
	 * 
	 * @param item
	 * 		the grocery item to be added to the bag
	 */
	public GroceryBag( GroceryItem item ) 
		{
		this.bag.add( item ) ;
		this.numberOfItems += 1 ;
		this.totalBagWeight += item.itemWeight.weightValue ;
		this.bagContentWeight = item.itemWeight ;
		this.bagContentFirmness = item.itemFirmness ;
		this.bagContentFlexibility = item.itemFlexibility ;
		
		}	// end 1-arg (new bag) constructor()
	
	
	/**
	 * Adds a new grocery item to an existing grocery bag and updates applicable bag attributes
	 * 
	 * @param newItem
	 * 		the grocery item to be added to the bag
	 */
	public void addNewGroceryItem ( GroceryItem newItem ) 
		{
		this.bag.add( newItem ) ;
		this.numberOfItems += 1 ;
		this.totalBagWeight += newItem.itemWeight.weightValue ;
	
		}	// end addNewGroceryItem()
	
	
	/**
	 * Returns the current grocery bag in a form that can be looked through index by index
	 * 
	 * @return the current bag converted to an Object[]
	 */
	public Object[] returnBag() 
		{
		return this.bag.toArray() ;
		
		}	// end returnBag()
	
	
	/**
	 * Returns the name of an item within a bag at a specific index
	 * 
	 * @return the String name of the item
	 */
	public String returnCurrentItemName( int bagIndex )
		{
		GroceryItem currentItem = ( GroceryItem ) ( this.returnBag()[ bagIndex ] ) ;
		return currentItem.itemName ;
		
		}
			
	
	/**
	 * Returns the total weight of the current bag
	 * 
	 * @return total weight of bag
	 */
	public int returnTotalBagWeight() 
		{
		return this.totalBagWeight ;
		
		}	// end returnTotalBagWeight()
 	
	
	/**
	 * Checks if adding the weight of the current item to the current bag is possible 
	 * 
	 * @param addedWeight
	 * 		weight to be added
	 * 
	 * @return true if add is possible, false if add is not possible
	 */
	public boolean checkTotalBagWeight( int addedWeight ) 
		{
		return ( this.totalBagWeight + addedWeight <= WEIGHTLIMIT ) ;
		
		}	// end checkTotalBagWeight()
	
	
	/**
	 * Adds the weight of the current item to the total weight of the current bag
	 * 
	 * @param addedWeight
	 * 		weight amount to be added
	 */
	public void increaseTotalBagWeight( int addedWeight ) 
		{
		this.totalBagWeight += addedWeight ;
	
		}	// end increaseTotalBagWeight()
	
	
	/**
	 * Retrieves the number of items in the current bag
	 * 
	 * @return the numberOfItems in the current bag
	 * 		
	 */
	public int returnNumberOfItems() 
		{
		return this.numberOfItems ;
		
		}	// end returnNumberOfItems()
	
	
	/**
	 * Checks if the current bag has reached the limit of items it can hold
	 * 
	 * @return true if the number of items in the bag is less than the limit, false if equal to the limit
	 */
	public boolean checkNumberOfItems() 
		{
		if (this.numberOfItems == ITEMLIMIT ) 
			{
			return false ;
			}
		
		return true ;
	
		}	// end checkNumberOfItems()
	
	
	/**
	 * Adds 1 to the number-of-items variable in the current bag
	 */
	public void increaseNumberOfItems() 
		{
		this.numberOfItems++ ;

		}	// end increaseNumberOfItems()
	
	
	}	// end class GroceryBag
