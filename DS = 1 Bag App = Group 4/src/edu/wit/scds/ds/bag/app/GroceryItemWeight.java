
package edu.wit.scds.ds.bag.app;


/**
 * Enumeration of grocery item weight for the GroceryBagger application.
 * 
 * @author Andrew Thynne
 *
 */
public enum GroceryItemWeight 
	{
	
	LIGHT( "Light", 1 ),
	MEDIUM( "Medium", 2 ),
	HEAVY( "Heavy", 3 ) ;

	
	public final String displayName ;
	public final int weightValue ;

	
	private GroceryItemWeight( final String itemWeightDisplayName, final int itemWeightValue ) 
		{
		this.displayName = itemWeightDisplayName ;
		this.weightValue = itemWeightValue ;
		 
		}

	
	public static GroceryItemWeight interpretDescription( final String weightDescription ) 
		{
		GroceryItemWeight correspondingWeight ;
		
		switch( weightDescription.toLowerCase().charAt( 0 ) )
			{
			case 'l' :
				correspondingWeight = LIGHT ;
				break ;
			case 'm' :
				correspondingWeight = MEDIUM ;
				break ;
			case 'h' :
				correspondingWeight = HEAVY ;
				break ;
			default :
				correspondingWeight = MEDIUM ;
				break ;
				
			}
		
		return correspondingWeight ;
		
		}
	
	
	public String toString()
		{
		return this.displayName ; 
		
		}
	
	
	public static void main(final String[] args)
		{
		System.out.printf( "Members of the %s enumeration%n%n",
						    GroceryItemWeight.class.getSimpleName() ) ;
		
		System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
						  "#",
						  "Item Weight",
						  "Name",
						  "Display Name",
						  "Weight Value",
						  "Interpreted Weight" ) ;
		
		for ( final GroceryItemWeight anItemWeight: GroceryItemWeight.values() ) 
			{
			System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
							    anItemWeight.ordinal(),
							    anItemWeight,
							    anItemWeight.name(),
							    anItemWeight.displayName,
							    anItemWeight.weightValue,
							    interpretDescription( anItemWeight.toString() ) ) ;
			
			}
		
		}
	
	}

