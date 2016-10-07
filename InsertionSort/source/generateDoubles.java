package InsertionSort;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

public class generateDoubles
{
    //do not instantiate
    private generateDoubles() { }
    
    private static final double MAX = 10000.0;
    
    public static void generateRandom (double[] random)
    {
        for (int i = 0; i < random.length; i++)
        {
            random[i] = StdRandom.uniform(-MAX, MAX);
        }
    }
    
    public static void fileOutput(double[] random, Out outputFile)
    {
        for(int i = 0; i < random.length; i++)
        {
            outputFile.printf("%.2f", random[i]);
            outputFile.println();
        }
    }
    
    public static void main(String[] args)
    {
        Out outputFile = new Out(args[0]);
        
        double[] random = new double[Integer.parseInt(args[1])];
        
        generateRandom(random);
        
        fileOutput(random, outputFile);
        
        outputFile.close();
    }
}