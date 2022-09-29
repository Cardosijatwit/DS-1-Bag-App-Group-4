
package edu.wit.scds.ds.bag.app;

/**
 * Enumeration of grocery item firmness for the GroceryBagger application.
 * 
 * @author Andrew Thynne
 *
 */
public enum GroceryItemFirmness
	{

	SOFT( "Soft", 1 ),
	FIRM( "Firm", 2 ),
	HARD( "Hard", 3 ) ;

	
	public final String displayName ;
	public final int firmnessValue ;

	
	private GroceryItemFirmness( final String itemFirmnessDisplayName, final int itemFirmnessValue )
		{
		this.displayName = itemFirmnessDisplayName ;
		this.firmnessValue = itemFirmnessValue ;
		
		}

	
	public static GroceryItemFirmness interpretDescription( final String firmnessDescription )
		{
		GroceryItemFirmness correspondingFirmness ;
		switch( firmnessDescription.toLowerCase().charAt( 0 ) ) 
			{
			case 'l' :
				correspondingFirmness = SOFT ;
				break ;
				
			case 'm' :
				correspondingFirmness = FIRM ;
				break ;
				
			case 'h' :
				correspondingFirmness = HARD ;
				break ;
				
			default :
				correspondingFirmness = FIRM ;
				break ;
				
			}
		
		return correspondingFirmness ;
		
		}
	
	
	public String toString() 
		{
		return this.displayName ; 
		
		}
	
	
	public static void main( final String[] args )
		{
		System.out.printf( "Members of the %s enumeration%n%n",
							GroceryItemFirmness.class.getSimpleName()) ;
		
		System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
						   "#",
						   "Item Firmness",
						   "Name",
						   "Display Name",
						   "Firmness Value",
						   "Interpreted Firmness" ) ;
		
		for ( final GroceryItemFirmness anItemFirmness: GroceryItemFirmness.values() ) 
			{
			System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
								anItemFirmness.ordinal(),
								anItemFirmness,
								anItemFirmness.name(),
								anItemFirmness.displayName,
								anItemFirmness.firmnessValue,
								interpretDescription( anItemFirmness.toString() ) ) ;
			
			}
		
		}
	
	}

