package InsertionSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Performance
{
    //do not instantiate
    private Performance() {  };
    
    public static double timeTrial(int N)
    {
        double[] a = new double[N];
        
        generateDoubles.generateRandom(a);
        
        Stopwatch timer = new Stopwatch();
        Insertion.sort(a);
        return timer.elapsedTime();
    }
    
    public static void main(String[] args)
    {
       double previous = timeTrial(125);
       double time = 0.0;
       
       for(int i = 250; i <= 256000; i += i)
       {
           time = timeTrial(i);
           StdOut.printf("%6d %7.1f ", i, time);
           if(previous == 0.0) //prevent division by 0
           {
               StdOut.printf("  1.0\n");
           }
           else
           {
               StdOut.printf("%5.1f\n", time/previous);
           }
           previous = time;
       }
    }
}