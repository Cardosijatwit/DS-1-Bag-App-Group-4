package edu.wit.scds.ds.bag.app;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;


/**
 * 
 * class that will take the arrays that are separated from the groceries.txt file
 * and put them into the actual item names 
 * 
 * @author yangd2
 *
 *
 *
 */

public class GroceryItems 
{

    public static void main(String[] args)
    {
        File file = new File ("./data/groceries.txt");
        
        // try and catch block to read the groceries.txt file into the class 
        try (Scanner sc = new Scanner(file))
                {
                  while (sc.hasNextLine()) {
                      System.out.println(sc.nextLine()); 
                  }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
        
     }
}
        
        

