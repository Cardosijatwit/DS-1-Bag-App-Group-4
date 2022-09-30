
package edu.wit.scds.ds.bag.app;

/**
 * Enumeration of grocery item firmness for the GroceryBagger application.
 * 
 * @author Andrew Thynne
 *
 */
public enum GroceryItemFirmness
    {
    //Firmness        Display Name        Numeric Value
    
    /**Soft item*/
    SOFT( "Soft", 1 ),
    
    /**Firm item*/
    FIRM( "Firm", 2 ),
    
    /**Hard item*/
    HARD( "Hard", 3 ) ;

    //Instance variables
    
    /**name for the display*/
    public final String displayName ;
    
    /**integer equivalent of the firmness*/
    public final int firmnessValue ;

    /**
     * 
     * @param itemFirmnessDisplayName becomes the name for the display
     * @param itemFirmnessValue becomes the integer equivalent of the firmness
     */
    private GroceryItemFirmness( final String itemFirmnessDisplayName, final int itemFirmnessValue )
        {
        this.displayName = itemFirmnessDisplayName ;
        this.firmnessValue = itemFirmnessValue ;
        
        }//end of the constructor

    /**
     * parses a text description of firmness
     * @param firmnessDescription
     * @return the corresponding enum constant or Firm if the text is unrecognizable
     */
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
                
            }//end of the switch()
        
        return correspondingFirmness ;
        
        }//end of the interpretDescription method
    
    /**
     * creates a string representation of displayName
     */
    public String toString() 
        {
        return this.displayName ; 
        
        }//end of the toString method
    
    /**
     * displays all constants of the enumeration
     * @param args
     */
    public static void main( final String[] args )
        {
        //displays the introductory message
        System.out.printf( "Members of the %s enumeration%n%n",
                            GroceryItemFirmness.class.getSimpleName()) ;
        
        //displays all column headers
        System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
                           "#",
                           "Item Firmness",
                           "Name",
                           "Display Name",
                           "Firmness Value",
                           "Interpreted Firmness" ) ;
        
        //displays each element of the enumeration
        for ( final GroceryItemFirmness anItemFirmness: GroceryItemFirmness.values() ) 
            {
            System.out.printf( "%-5s %-15s %-15s %-15s %-15s %-15s%n",
                                anItemFirmness.ordinal(),
                                anItemFirmness,
                                anItemFirmness.name(),
                                anItemFirmness.displayName,
                                anItemFirmness.firmnessValue,
                                interpretDescription( anItemFirmness.toString() ) ) ;
            
            }//end of the for loop
        
        }//end of the main method
    
    }//end of the GroceryItemFirmness class
