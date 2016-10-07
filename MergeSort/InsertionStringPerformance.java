package Project2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Random;

public class InsertionStringPerformance
{
    //do not instantiate
    private InsertionStringPerformance() {  };
    
    private static final int MAX = 10000;
    
    public static double timeTrial(int N)
    {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String[] a = new String[N];
        int randLen;
        
        //generates a list of randomly generated strings of variable length from sizes 1-10
        for(int i = 0; i < a.length; ++i)
        {
            randLen = random.nextInt(10) + 1; // 1-10
            for(int j = 0; j < randLen; ++j)
            {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            a[i] = sb.toString();
            sb.setLength(0);
        }
        
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