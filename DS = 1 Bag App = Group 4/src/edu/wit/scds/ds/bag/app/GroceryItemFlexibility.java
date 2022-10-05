
package edu.wit.scds.ds.bag.app ;

/**
 * Enumeration of grocery item flexibility for the GroceryBagger application.
 * 
 * @author Andrew Thynne
 *
 */
public enum GroceryItemFlexibility
    {
	
    // Flexibility     Display Name     Numeric Value
    /**Flexible item*/
    	FLEXIBLE( 		"Flexible", 		  1 ),
    
    /**Rigid item*/
    	RIGID( 			 "Rigid", 			  2 ) ;

	
    //Instance variables
    /**name for the display*/
    public final String displayName ;
    
    /**integer equivalent of the flexibility*/
    public final int flexibilityValue ;

    
    /**
     * Creates a new flexibility enum based off of the supplied input
     * 
     * @param itemFlexibilityDisplayName becomes the name for the display
     * @param itemFlexibilityValue becomes the integer equivalent of the flexibility
     */
    private GroceryItemFlexibility( final String itemFlexibilityDisplayName, final int itemFlexibilityValue )
        {
        this.displayName = itemFlexibilityDisplayName ;
        this.flexibilityValue = itemFlexibilityValue ;

        }	// end 2-arg (name and value) constructor

    
    /**
     * Parses a text description of the flexibility
     * 
     * @param flexibilityDescription
     * 
     * @return corresponding enum constant or FLEXIBLE if unable to recognize inputed text description
     */
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
                
            }	// end switch()
        
        return correspondingFlexibility;
        
        }	// end interpretDescription()
    
    
    /**
     * Creates a string representation of displayName
     */
    public String toString()
        {
        return this.displayName;
        
        }	// end toString()
    
    
    /**
     * Displays all constants of the enumeration
     * 
     * @param args
     */
    public static void main(final String[] args)
        {
        // displays the introductory message
        System.out.printf( "Members of the %s enumeration%n%n",
        GroceryItemFlexibility.class.getSimpleName() ) ;
        
        // displays the column headers
        System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
                           "#",
                           "Item Flexibility",
                           "Name",
                           "Display Name",
                           "Flexibility Value",
                           "Interpreted Flexibility" ) ;
        
        // displays each element in the enumeration
        for ( final GroceryItemFlexibility anItemFlexibility: GroceryItemFlexibility.values() )
            {
            System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
                                anItemFlexibility.ordinal(),
                                anItemFlexibility,
                                anItemFlexibility.name(),
                                anItemFlexibility.displayName,
                                anItemFlexibility.flexibilityValue,
                                interpretDescription(anItemFlexibility.toString() ) );
            
            }	// end for{}
        
        
        }	// end main{}
    
    
    }	// end class GroceryItemFlexibility

