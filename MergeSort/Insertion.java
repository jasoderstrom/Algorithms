/*
   Author: Justin Soderstrom
   Date:   September 28, 2016
   Class:  CSC-482
   Description: An implementation of the Insertion sort algorithm
*/

package Project2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion
{
    //do not instantiate
    private Insertion() {  }
    
    private static boolean isLess(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0; //Compare two comparable types to determine if a < b
    }  
    public static void sort(Comparable[] insertArray)
    {
        if(insertArray.length > 0) 
        {
            for(int i = 1; i < insertArray.length; i++)
            {
                for(int j = i; j > 0 && isLess(insertArray[j],insertArray[j-1]); j--)
                {
                    exchange(insertArray, j, j-1);
                }
            }
        }
        else
        {
            StdOut.println("YOU SENT A NULL POINTER! I NEED AT LEAST AN ARRAY OF SIZE 1");
        }
    }
    public static boolean isSorted(Comparable[] insertArray)
    {
        for (int i = 1; i < insertArray.length; i++)
        {
            if(isLess(insertArray[i], insertArray[i-1]))
            {
                return false;
            }
        }
        return true;
    }
    public static void exchange(Comparable[] insertArray, int i, int j)
    {
        Comparable a = insertArray[i];
        insertArray[i] = insertArray[j];
        insertArray[j] = a;
    }
    public static void printArray(Comparable[] insertArray)
    {
        for(int i = 0; i < insertArray.length; i++)
        {
            StdOut.print(insertArray[i] + " ");
        }
        StdOut.println();
    }
    public static void main(String[] args)
    {
        //By default, the class will read in a file of strings
        //Sort the strings and print the output to the console
        String[] insertArray = StdIn.readAllStrings();
        sort(insertArray);
        assert isSorted(insertArray);
        printArray(insertArray);
    }
}