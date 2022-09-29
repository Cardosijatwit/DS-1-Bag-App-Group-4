
package edu.wit.scds.ds.bag.app;


/**
 * Enumeration of grocery item flexibility for the GroceryBagger application.
 * 
 * @author Andrew Thynne
 *
 */
public enum GroceryItemFlexibility
	{
	
	FLEXIBLE( "Flexible", 1 ),
	RIGID( "Rigid", 2 ) ;

	
	public final String displayName ;
	public final int flexibilityValue ;

	
	private GroceryItemFlexibility( final String itemFlexibilityDisplayName, final int itemFlexibilityValue )
		{
		this.displayName = itemFlexibilityDisplayName ;
		this.flexibilityValue = itemFlexibilityValue ;

		}

	
	public static GroceryItemFlexibility interpretDescription( final String flexibilityDescription )
		{
		GroceryItemFlexibility correspondingFlexibility;
		switch( flexibilityDescription.toLowerCase().charAt( 0 ) )
			{
			case 'f':
				correspondingFlexibility = FLEXIBLE ;
				break ;
			case 'r':
				correspondingFlexibility = RIGID ;
				break ;
			default:
				correspondingFlexibility = FLEXIBLE ;
				break ;
			}
		
		return correspondingFlexibility;
		
		}
	
	
	public String toString()
		{
		return this.displayName;
		
		}
	
	
	public static void main(final String[] args)
		{
		System.out.printf("Members of the %s enumeration%n%n",
		GroceryItemFlexibility.class.getSimpleName()) ;
		
		System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s%n",
						  "#",
						  "Item Flexibility",
						  "Name",
						  "Display Name",
						  "Flexibility Value",
						  "Interpreted Flexibility") ;
		
		for (final GroceryItemFlexibility anItemFlexibility: GroceryItemFlexibility.values())
			{
			System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s%n",
							  anItemFlexibility.ordinal(),
							  anItemFlexibility,
							  anItemFlexibility.name(),
							  anItemFlexibility.displayName,
							  anItemFlexibility.flexibilityValue,
							  interpretDescription(anItemFlexibility.toString()));
			
			}
		
		}
	
	}
