package Project2;

import junit.framework.TestCase;
import java.util.Random;

public class InsertionStringTests extends TestCase {
    
    public void testAlphabet() {
        String[] arr = new String[26];
        
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        for(int i = 0; i < 26; ++i)
        {
            arr[i] = new String(Character.toString(alphabet[i]));
        }
        
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED LOWERCASE ALPHABET TEST!!");
    }
    
    public void testReverseAlphabet() {
        char[] reverseAlphabet = "zyxwvutsrqponmlkjihgfedcba".toCharArray();
        String[] arr = new String[26];
        
        for(int i = 0; i < 26; ++i)
        {
            arr[i] = new String(Character.toString(reverseAlphabet[i]));
        }
        
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED LOWERCASE REVERSE ALPHABET TEST!!");
    }
    
    public void testUpperAlphabet() {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String[] arr = new String[26];
        
        for(int i = 0; i < 26; ++i)
        {
            arr[i] = new String(Character.toString(alphabet[i]));
        }
        
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED UPPERCASE ALPHABET TEST!!");
    }
    
    public void testReverseUpperAlphabet() {
        char[] reverseAlphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBA".toCharArray();
        String[] arr = new String[26];
        
        for(int i = 0; i < 26; ++i)
        {
            arr[i] = new String(Character.toString(reverseAlphabet[i]));
        }
        
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED UPPERCASE REVERSE ALPHABET TEST!!");
    }
    
    public void testMixAlphabetCases(){
        char[] mixAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] arr = new String[52];
        
        for(int i = 0; i < 52; ++i)
        {
            arr[i] = new String(Character.toString(mixAlphabet[i]));
        }
        
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED MIXED ALPHABET TEST!!");
    }
    
    public void testNumbers() {
        char[] numbers = "0123456789".toCharArray();
        String[] arr = new String[10];
        
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = new String(Character.toString(numbers[i]));
        }
        
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED NUMBERS TEST!!");
    }
    
    public void testReverseNumbers() {
        char[] numbers = "9876543210".toCharArray();
        String[] arr = new String[10];
        
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = new String(Character.toString(numbers[i]));
        }
        
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED REVERSE NUMBERS TEST!!");
    }
    
    public void testRandomFixedStrings() {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String[] arr = new String[5];
        
        //generates a list of 5 randomly generated strings of length 3
        for(int i = 0; i < 5; ++i)
        {
            for(int j = 0; j < 3; ++j)
            {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            arr[i] = sb.toString();
            sb.setLength(0);
        }
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED RANDOM FIXED STRINGS TEST!!");
    }
    
    public void testRandomStrings() {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String[] arr = new String[1000];
        int randLen;
        
        //generates a list of randomly generated strings of variable length from sizes 1-10
        for(int i = 0; i < arr.length; ++i)
        {
            randLen = random.nextInt(10) + 1; // 1-10
            for(int j = 0; j < randLen; ++j)
            {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            arr[i] = sb.toString();
            sb.setLength(0);
        }
        Insertion.sort(arr);
        
        if(!Insertion.isSorted(arr)) fail("FAILED RANDOM STRINGS TEST!!");
    }
    
    public static void testSingleString() {
         String[] testEmpty = new String[1];
         
         testEmpty[0] = new String("A");
         
         Insertion.sort(testEmpty);
         
         if(!Insertion.isSorted(testEmpty)) fail("FAILED SINGLE CHARACTER TEST!!");
     }    
}
