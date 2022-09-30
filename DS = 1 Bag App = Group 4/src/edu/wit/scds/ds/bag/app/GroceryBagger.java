
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;
import java.util.ArrayList ; 
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException;

/**
 * A class that reads a text list of grocery items and their respective attributes, then utilizes 
 * the functions provided in the ItemInterpreter and ResizableArrayBag class to place each item into 
 * a specific bag based upon each item's attributes.
 * 
 * @author Jonny Cardosi
 *
 *@param <T> 
 *		class of items held within each bag
 *
 */
public class GroceryBagger
	{
	
	/**
	 *  ArrayList that stores all of the bags for the grocery items
	 */
	private static ArrayList<Object[]> bags = new ArrayList<Object[]>() ; 
	
	/**
	 *  ArrayList that holds the traits of the items in each corresponding bag
	 */
	private static ArrayList<Object[]> traits = new ArrayList<Object[]>() ; 
	
	
	
	/**
	 *  Main method that runs application and prints results to console 
	 */
	public static void main( String[] args ) 
		{
		
        // reads groceries.txt line by line, turning each item and its attributes into separate arrays.
		// places item and enumerated traits into separate but corresponding ArrayLists, seen above.
		try 
        	{
        	Scanner groceryListReader = new Scanner( new File( "./data/groceries.txt" ) ) ; 
        	
            while ( groceryListReader.hasNextLine() ) 
            	{
                String[] groceryListIndividualLine = groceryListReader.nextLine().split( "\t" ) ;
                String newGroceryItem = groceryListIndividualLine[ 0 ] ;
                String[] itemTraits = { groceryListIndividualLine[ 2 ], groceryListIndividualLine[ 3 ], groceryListIndividualLine[ 4 ] } ;
                Object[] enumItemTraits = ItemInterpreter.traitInterpreter( itemTraits ) ;	// {firmness, weight, flexibility}
                
                // variables used in upcoming while loop
                GroceryItemWeight tempTrait1 = ( GroceryItemWeight )enumItemTraits[ 1 ] ;
                int newWeightValue = tempTrait1.weightValue ;
                boolean compatible = false ;
                int counter1 = 0 ;
                int counter2 = 0 ;
                
                while ( compatible == false && counter1 < traits.size() )
                	{
                	for ( int j = 0 ; j < 3 ; j++ )
                		{
                		
                		if ( j == 0 ) 
                			{
                			GroceryItemFirmness tempFirmnessTrait1 = ( GroceryItemFirmness ) enumItemTraits[ 0 ] ;
                			GroceryItemFirmness tempFirmnessTrait2 = ( GroceryItemFirmness ) traits.get( counter1 )[ j ] ;
                			if ( tempFirmnessTrait1.firmnessValue == tempFirmnessTrait2.firmnessValue ) 
                				{
                				counter2 ++ ;
                				}
                			
                			}	
                			
                		else if ( j == 1 ) 
                			{
                			GroceryItemWeight tempWeightTrait1 = ( GroceryItemWeight ) enumItemTraits[ 1 ] ;
                			GroceryItemWeight tempWeightTrait2 = ( GroceryItemWeight ) traits.get( counter1 )[ j ] ;
                			if ( tempWeightTrait1.weightValue == tempWeightTrait2.weightValue ) 
                				{
                				counter2 ++ ;
                				}
                			
                			}	
                			
                		else if ( j == 2 ) 
            				{
                			GroceryItemFlexibility tempFlexibilityTrait1 = ( GroceryItemFlexibility ) enumItemTraits[ 2 ] ;
            				GroceryItemFlexibility tempFlexibilityTrait2 = ( GroceryItemFlexibility ) traits.get( counter1 )[ j ] ;
            				if ( tempFlexibilityTrait1.flexibilityValue == tempFlexibilityTrait2.flexibilityValue ) 
            					{
            					counter2 ++ ;
            					}
            				
            				}	
                		
                		}	// end for()
 
                	int bagTotalWeightValue = ( int )( traits.get( counter1 )[ 3 ] );
                	
                	if ( bagTotalWeightValue + newWeightValue <= 10 && counter2 == 3 ) 
                		{
                		ResizableArrayBag< Object > tempBagGroceryItems = new ResizableArrayBag< Object >( bags.get( counter1 ) ) ;
                		tempBagGroceryItems.add( newGroceryItem ) ;
                		bags.add( counter1, tempBagGroceryItems.toArray() ) ;
                		bags.remove( counter1 + 1 ) ;
                		
                		traits.get( counter1 )[ 3 ] = ( int )( traits.get( counter1 )[ 3 ] ) + newWeightValue ;
                 		compatible = true ;
                 		
                		}
                	
                	counter1++ ;
                	counter2 = 0 ;
                	
                	}	// end inner while{}
                
                
                if ( !compatible ) 
                	{
                	ResizableArrayBag< Object > tempBagGroceryItems = new ResizableArrayBag< Object >() ;
                	tempBagGroceryItems.add( newGroceryItem ) ;
                	bags.add( tempBagGroceryItems.toArray() ) ;
        		
                	ResizableArrayBag< Object > tempBagItemTraits = new ResizableArrayBag< Object >( enumItemTraits ) ;
                	tempBagItemTraits.add( newWeightValue ) ;
                	traits.add( tempBagItemTraits.toArray() ) ;
			 
                	}
               
                
            	}	// end outer while{}
            
            
            System.out.printf("there are %d bags in total%n",  bags.size() ) ;
            System.out.printf("first item from bag #1: %s%n",  bags.get(0)[0]) ;
            System.out.printf("first item from bag #2: %s%n",  bags.get(1)[0]) ;
            System.out.printf("first item from bag #3: %s%n",  bags.get(2)[0]) ;
            System.out.printf("first item from bag #4: %s%n",  bags.get(3)[0]) ;
            System.out.printf("first item from bag #5: %s%n",  bags.get(4)[0]) ;
            System.out.printf("first item from bag #6: %s%n",  bags.get(5)[0]) ;
            System.out.printf("first item from bag #7: %s%n",  bags.get(6)[0]) ;
            System.out.printf("first item from bag #8: %s%n",  bags.get(7)[0]) ;
            System.out.printf("first item from bag #9: %s%n",  bags.get(8)[0]) ;
            System.out.printf("first item from bag #10: %s%n", bags.get(9)[0]) ;
            System.out.printf("first item from bag #11: %s%n", bags.get(10)[0]) ;
            System.out.printf("the total weight of bag #1 is %d pounds%n",  traits.get(0)[3]) ;
            System.out.printf("the total weight of bag #2 is %d pounds%n",  traits.get(1)[3]) ;
            System.out.printf("the total weight of bag #3 is %d pounds%n",  traits.get(2)[3]) ;
            System.out.printf("the total weight of bag #4 is %d pounds%n",  traits.get(3)[3]) ;
            System.out.printf("the total weight of bag #5 is %d pounds%n",  traits.get(4)[3]) ;
            System.out.printf("the total weight of bag #6 is %d pounds%n",  traits.get(5)[3]) ;
            System.out.printf("the total weight of bag #7 is %d pounds%n",  traits.get(6)[3]) ;
            System.out.printf("the total weight of bag #8 is %d pounds%n",  traits.get(7)[3]) ;
            System.out.printf("the total weight of bag #9 is %d pounds%n",  traits.get(8)[3]) ;
            System.out.printf("the total weight of bag #10 is %d pounds%n", traits.get(9)[3]) ;
            System.out.printf("the total weight of bag #11 is %d pounds%n", traits.get(10)[3]) ;
            
            
            groceryListReader.close() ;
            
        	}	// end try{}
		
		catch ( FileNotFoundException a ) 
			{
			System.out.printf( "The file defined by the path \"./data/groceries.txt\" was not found.%n" ) ;
			}
		
		catch ( Exception b ) 
			{
			System.out.printf( "The file defined by the path \"./data/groceries.txt\" was not found, is corrupt, "
							 + "or there was an error in opening the file.%n" ) ;
			b.printStackTrace() ;
			
			}	// end catch{}
		
		}	// end main()
	
	}	// end class GroceryBagger
