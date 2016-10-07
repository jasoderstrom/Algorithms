/*
   Author: Justin Soderstrom
   Date:   September 28, 2016
   Class:  CSC-482
   Description: An implementation of the Mergesort algorithm using topdown approach
*/

package Project2;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class MergeTD //Mergesort using topdown implementation
{
    //Do not instantiate
    private MergeTD() { }

    private static Comparable[] copy;

    private static void merge(Comparable[] arr, int low, int middle, int high)
    {
        //Merging values from a[low..midddle] with a[middle+1...high]
        int i = low;
        int j = middle + 1;
        
        for(int k = low; k <= high; ++k) //Copy over arr[low..high] to copy[low..high]
        {
            copy[k] = arr[k];
        }
        
        for(int k = low; k <= high; ++k)
        {
            // i == low
            // j == middle + 1
            if(i > middle)
            {
                arr[k] = copy[j++]; //Left half exhausted (take from right)
            }
            else if(j > high)
            {
                arr[k] = copy[i++]; //Right half exhausted (take from left)
            }
            else if(isLess(copy[j], copy[i]))
            {
                arr[k] = copy[j++]; //Current key on right < current key on left
            }
            else
            {
                arr[k] = copy[i++]; //Current key on right >= current key on left
            }
        }
      }
        
    private static void sort(Comparable[] arr, int low, int high)
    {
        if (high <= low) //avoid out of bound indicies
        {
            return;
        }
        else
        {
            int middle = low + (high - low)/2;
            sort(arr, low, middle); // Sort the left half of the list
            sort(arr, middle+1, high); // Sort the right half of the list
            merge(arr, low, middle, high); // Merge the lists
        }
    }
    
    private static boolean isLess(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0; //Compare two comparable types to determine if a < b
    }
    
    public static void sort(Comparable[] arr) //Client sort interface
    {
        copy = new Comparable[arr.length]; //allocate space for the copy arrary
        sort(arr, 0, arr.length - 1); //sort from 0 - (N-1)
    }
    
    public static boolean isSorted(Comparable[] arr)
    {
        for(int i = 1; i < arr.length; ++i)
        {
            if(isLess(arr[i], arr[i-1])) //if not sorted in ascending order
            {
                return false;
            }
        }
        return true;
    }
    
    public static void printArray(Comparable[] arr)
    {
        for(int i = 0; i < arr.length; ++i)
        {
            StdOut.print(arr[i] + " ");
        }
        StdOut.println();
    }
    
    public static void main(String[] args)
    {
        //By default, the class will read in a file of strings
        //Sort the strings and print the output to the console
        String[] arr = StdIn.readAllStrings();
        sort(arr);
        assert isSorted(arr);
        printArray(arr);
    }
        
}