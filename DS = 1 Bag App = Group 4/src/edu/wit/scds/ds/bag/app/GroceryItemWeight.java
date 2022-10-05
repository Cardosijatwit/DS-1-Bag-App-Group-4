
package edu.wit.scds.ds.bag.app ;

/**
 * Enumeration of grocery item weight for the GroceryBagger application.
 * 
 * @author Andrew Thynne
 *
 */
public enum GroceryItemWeight 
    {
	
    // Weight     Display Name    Numeric Value
    /**Light item*/
       LIGHT( 	    "Light",	   	    1 ),
    
    /**Medium item*/
       MEDIUM( 		"Medium", 			2 ),
    
    /**Heavy item*/
       HEAVY( 		"Heavy", 			3 ) ;

	
    //Instance variables    
    /**name for the display*/
    public final String displayName ;
    
    /**integer equivalent of the weight*/
    public final int weightValue ;

    
    /**
     * Creates a new weight enum based off of the supplied input
     * 
     * @param itemWeightDisplayName becomes the name for the display
     * @param itemWeightValue becomes the integer equivalent of the weight
     */
    private GroceryItemWeight( final String itemWeightDisplayName, final int itemWeightValue ) 
        {
        this.displayName = itemWeightDisplayName ;
        this.weightValue = itemWeightValue ;
         
        }	// end 2-arg (name and value) constructor

    
    /**
     * Parses text description of weight
     * 
     * @param weightDescription
     * 
     * @return corresponding enum constant or Medium if unable to recognize the text
     */
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
                
            }	// end switch()
        
        return correspondingWeight ;
        
        }	// end interpretDescription()
    
    
    /**
     * Creates a string representation of displayName
     */
    public String toString()
        {
        return this.displayName ; 
        
        }	// end toString()
    
    
    /**
     * Displays all constants of the enumeration
     * 
     * @param args
     */
    public static void main(final String[] args)
        {
        // displays an introductory message
        System.out.printf( "Members of the %s enumeration%n%n",
                            GroceryItemWeight.class.getSimpleName() ) ;
        
        // displays all column headers
        System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
                           "#",
                           "Item Weight",
                           "Name",
                           "Display Name",
                           "Weight Value",
                           "Interpreted Weight" ) ;
        
        // displays each element of the enumeration
        for ( final GroceryItemWeight anItemWeight: GroceryItemWeight.values() ) 
            {
            System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
                                anItemWeight.ordinal(),
                                anItemWeight,
                                anItemWeight.name(),
                                anItemWeight.displayName,
                                anItemWeight.weightValue,
                                interpretDescription( anItemWeight.toString() ) ) ;
            
            }	// end for{}
        
        
        }	// end main{}
    
    
    }	// end class GroceryItemWeight
