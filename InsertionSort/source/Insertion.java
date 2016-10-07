package InsertionSort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Insertion
{
    //do not instantiate
    private Insertion() {  }
    
    public static void sort(double[] insertArray)
    {
        if(insertArray.length > 0) 
        {
            for(int i = 1; i < insertArray.length; i++)
            {
                for(int j = i; j > 0 && (insertArray[j] < insertArray[j-1]); j--)
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
    public static boolean isSorted(double[] insertArray)
    {
        for (int i = 1; i < insertArray.length; i++)
        {
            if(insertArray[i] < insertArray[i-1])
            {
                return false;
            }
        }
        return true;
    }
    public static void exchange(double[] insertArray, int i, int j)
    {
        double a = insertArray[i];
        insertArray[i] = insertArray[j];
        insertArray[j] = a;
    }
    public static void printArray(double[] insertArray)
    {
        for(int i = 0; i < insertArray.length; i++)
        {
            StdOut.print(insertArray[i] + " ");
            StdOut.println();
        }
    }
    public static void main(String[] args)
    {
        In input = new In(args[0]);
        double[] insertArray = input.readAllDoubles();
        sort(insertArray);
        assert isSorted(insertArray);
        printArray(insertArray);
        input.close();
    }
}