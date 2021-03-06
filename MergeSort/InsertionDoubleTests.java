package Project2;
import junit.framework.TestCase;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionDoubleTests extends TestCase {
    
    private static final int LEN = 10000;
    private static final Double MAX = 10000.0;
    
    public void testRandom() {
      Double[] arr = new Double[LEN];
      
      for(int i = 0; i < LEN; ++i)
      {
          arr[i] = StdRandom.uniform(-MAX, MAX);
      }
      
      Insertion.sort(arr);
      
      if(!Insertion.isSorted(arr)) fail("FAILED RANDOM TEST!!");
    }
     
     public static void testDecreasingOrder() {
      Double[] testDecrease = new Double[LEN];
      
      for(int i = LEN - 1; i >= 0; i--)
      {
          testDecrease[i] = new Double(i);
      }
      
      Insertion.sort(testDecrease);
      
      if(!Insertion.isSorted(testDecrease)) fail("FAILED DECREASING ORDER ARRAY TEST!!");
  }
     public static void testInOrder()
     {
         Double[] testOrder= new Double[LEN];
         
         for(int i = 0; i < LEN; i++)
         {
             testOrder[i] = new Double(i);
         }
         
         Insertion.sort(testOrder);
         
         if(!Insertion.isSorted(testOrder)) fail("FAILED IN-ORDER ARRAY TEST!!");
     }
     
     public static void testAllDups()
     {
         Double[] testDups = new Double[LEN];
         
         for(int i = 0; i < LEN; i++)
         {
             testDups[i] =  new Double(10);
         }
         
         Insertion.sort(testDups);
         
         if(!Insertion.isSorted(testDups)) fail("FAILED DUPLICATE ARRAY TEST!!");
     }
     
     public static void testTwoNumber()
     {
         Double[] testTwo = new Double[LEN];
         
         for(int i = 0; i < LEN; i++)
         {
             testTwo[i] = new Double(i % 2); //Fills the array with 0's and 1's
         }
         
         Insertion.sort(testTwo);
         
         if(!Insertion.isSorted(testTwo)) fail("FAILED TWO NUMBER ARRAY TEST!!");
     }
     
     public static void testSingleNum()
     {
         Double[] testEmpty = new Double[1];
         
         testEmpty[0] = new Double(0);
         
         Insertion.sort(testEmpty);
         
         if(!Insertion.isSorted(testEmpty)) fail("FAILED SINGLE NUMBER TEST!!");
     }    
}
