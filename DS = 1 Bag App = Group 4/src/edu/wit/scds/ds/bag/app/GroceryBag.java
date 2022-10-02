
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
	
	private BagInterface< GroceryItem > bag = new ResizableArrayBag<>() ;
	private int totalBagWeight ;
	public final GroceryItemFirmness bagContentFirmness ; 
	public final GroceryItemWeight bagContentWeight ;
	public final GroceryItemFlexibility bagContentFlexibility ;
	
	
	public GroceryBag ( GroceryItem item ) 
		{
		this.bag.add( item ) ;
		this.totalBagWeight = item.itemWeight.weightValue ;
		this.bagContentFirmness = item.itemFirmness ;
		this.bagContentWeight = item.itemWeight ;
		this.bagContentFlexibility = item.itemFlexibility ;
		
		}	// end 1-arg (new bag) constructor()
	
	
	public int returnTotalBagWeight() 
		{
		return this.totalBagWeight ;
		
		}	// end returnTotalBagWeight()
 	
	
	public boolean checkTotalBagWeight( int addedWeight ) 
		{
		return (this.totalBagWeight + addedWeight <= 10) ;
		
		}	// end checkTotalBagWeight()
	
	
	public void increaseTotalBagWeight( int addedWeight ) 
		{
		this.totalBagWeight += addedWeight ;
	
		}	// end increaseTotalBagWeight()
	
	
	public void addNewGroceryItem ( GroceryItem newItem ) 
		{
		this.bag.add( newItem ) ;
		
		}	// end addNewGroceryItem()
	
	
	public  BagInterface< GroceryItem > returnBag () 
		{
		return this.bag ;
		}
	
	
	}	// end class GroceryBag
