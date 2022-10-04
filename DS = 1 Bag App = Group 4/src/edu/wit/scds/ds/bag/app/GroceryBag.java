
package edu.wit.scds.ds.bag.app;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;

/**
 * A class that allows for the creation of a "grocery bag" object that holds all of the necessary
 * information about an individual grocery bag
 * 
 * @author Jonny Cardosi
 *
 */
public class GroceryBag
	{
	
	private static final int ITEMLIMIT = 4 ;
	private static final int WEIGHTLIMIT = 10 ;
	
	private BagInterface< GroceryItem > bag = new ResizableArrayBag<>() ;
	private int totalBagWeight = 0; 
	private int numberOfItems = 0;
	public final GroceryItemWeight bagContentWeight ;
	public final GroceryItemFirmness bagContentFirmness ;
	public final GroceryItemFlexibility bagContentFlexibility ;
	
	
	public GroceryBag( GroceryItem item ) 
		{
		this.bag.add( item ) ;
		this.numberOfItems += 1 ;
		this.totalBagWeight += item.itemWeight.weightValue ;
		this.bagContentWeight = item.itemWeight ;
		this.bagContentFirmness = item.itemFirmness ;
		this.bagContentFlexibility = item.itemFlexibility ;
		
		}	// end 1-arg (new bag) constructor()
	
	
	public void addNewGroceryItem ( GroceryItem newItem ) 
		{
		this.bag.add( newItem ) ;
		this.numberOfItems += 1 ;
		this.totalBagWeight += newItem.itemWeight.weightValue ;
	
		}	// end addNewGroceryItem()
	
	
	public Object[] returnBag() 
		{
		return this.bag.toArray();
		
		}	// end returnBag()
			
			
	public int returnTotalBagWeight() 
		{
		return this.totalBagWeight ;
		
		}	// end returnTotalBagWeight()
 	
	
	public boolean checkTotalBagWeight( int addedWeight ) 
		{
		return (this.totalBagWeight + addedWeight <= WEIGHTLIMIT ) ;
		
		}	// end checkTotalBagWeight()
	
	
	public void increaseTotalBagWeight( int addedWeight ) 
		{
		this.totalBagWeight += addedWeight ;
	
		}	// end increaseTotalBagWeight()
	
	
	public int returnNumberOfItems() 
		{
		return this.numberOfItems ;
		
		}	// end returnNumberOfItems()
	
	
	public boolean checkNumberOfItems() 
		{
		if (this.numberOfItems == ITEMLIMIT ) 
			{
			return false ;
			}
		
		return true ;
	
		}	// end checkNumberOfItems()
	
	
	public void increaseNumberOfItems() 
		{
		this.numberOfItems++ ;

		}	// end increaseNumberOfItems()
	
	
	}	// end class GroceryBag
