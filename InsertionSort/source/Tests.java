package InsertionSort;

import edu.princeton.cs.algs4.StdOut;

public class tests
{
  //do not instantiate
  private tests() { }
  
  private static final int LEN = 10000;
  
  public static void trueRandom()
  {
      double[] testRandom = new double[LEN];
      
      generateDoubles.generateRandom(testRandom);
      
      Insertion.sort(testRandom);
      
      //Insertion.printArray(testRandom);
      
      if(Insertion.isSorted(testRandom)) StdOut.println("Passed Random Array Test");
      else StdOut.println("FAILED RANDOM TEST!!");
  }
  
  public static void decreasingOrder()
  {
      double[] testDecrease = new double[LEN];
      
      for(int i = LEN - 1; i >= 0; i--)
      {
          testDecrease[i] = i;
      }
      
      Insertion.sort(testDecrease);
      
      //Insertion.printArray(testRandom);
      
      if(Insertion.isSorted(testDecrease)) StdOut.println("Passed Decreasing Order Array Test");
      else StdOut.println("FAILED DECREASING ORDER ARRAY TEST!!");
  }
  
  public static void inOrder()
  {
      double[] testOrder= new double[LEN];
       
      for(int i = 0; i < LEN; i++)
      {
          testOrder[i] = i;
      }
      
      Insertion.sort(testOrder);
      
      //Insertion.printArray(testRandom);
      
      if(Insertion.isSorted(testOrder)) StdOut.println("Passed In-Order Array Test");
      else StdOut.println("FAILED IN-ORDER ARRAY TEST!!");
  }
  
  public static void allDups()
  {
      double[] testDups = new double[LEN];
       
      for(int i = 0; i < LEN; i++)
      {
          testDups[i] =  10;
      }
      
      Insertion.sort(testDups);
      
      //Insertion.printArray(testRandom);
      
      if(Insertion.isSorted(testDups)) StdOut.println("Passed Duplicate Array Test");
      else StdOut.println("FAILED DUPLICATE ARRAY TEST!!");
  }
  
  public static void twoNumber()
  {
      double[] testTwo = new double[LEN];
      
      for(int i = 0; i < LEN; i++)
      {
          testTwo[i] = i % 2; //Fills the array with 0's and 1's
      }
      
      Insertion.sort(testTwo);
      
    //  Insertion.printArray(testTwo);
      
      if(Insertion.isSorted(testTwo)) StdOut.println("Passed Two Number Array Test");
      else StdOut.println("FAILED TWO NUMBER ARRAY TEST!!");
  }
      
  public static void emptyTest()
  {
      double[] testEmpty = new double[1];
      
      testEmpty[0] = 0;
      
      Insertion.sort(testEmpty);
      
      //Insertion.printArray(testRandom);
      
      if(Insertion.isSorted(testEmpty)) StdOut.println("Passed Empty Array Test");
      else StdOut.println("FAILED EMPTY ARRAY TEST!!");
  }
  
  public static void main(String[] args)
  {
      emptyTest();
      twoNumber();
      allDups();
      inOrder();
      decreasingOrder();
      trueRandom();
  }
}