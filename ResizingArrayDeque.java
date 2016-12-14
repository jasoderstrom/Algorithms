/* Author: Justin Soderstrom
 * Date: 11/2/2016
 * Description: A circular resizing array implementation of a deque
 */

public class ResizingArrayDeque<Item>
{
    private Item[] a; //Array of items
    private int N;    //Number of items in queue
    private int head; //Keeps track of the front of queue
    private int tail; //Keeps track of the end of queue
    
    public ResizingArrayDeque()
    {
        a = (Item[]) new Object[1];
        N = 0;
        head = 0;
        tail = 0;
    }
   
    private void resize(int max)
    {
        //Move queue to a new array of size max
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
        {
            temp[i] = a[(head + i) % a.length];
        }
        a = temp;
        head = 0;
        tail = N-1;
    }
    
    public Item get(int i)
    {
        return a[(head + i) % a.length];
    }
    
    public void addFirst(Item item)
    {
        if(N == a.length) resize(2 * a.length);
        if(N == 0) a[head] = item;  
        head = (((head - 1) % a.length) + a.length) % a.length; //Accounts for negative modulo in Java
        a[head] = item;
        N++;
    }
    
    public void addLast(Item item)
    {
        if(N == a.length) resize(2 * a.length);
        if(N == 0) a[tail] = item;
        tail = (((tail + 1) % a.length) + a.length) % a.length; //Accounts for negative modulo in Java
        a[tail] = item;
        N++;
    }
    
    public Item remove(int i)
    {
        if (i < 0 || i > N - 1) throw new IndexOutOfBoundsException("Your index was out of bounds. Please use indices > 0 and < ArraySize - 1");
        int index = (head + i) % a.length;
        Item item = a[index];
        a[index] = null;   
        
        if( i < (N/2) ) //shift a[head]..a[index-1] right one position
        {
            for(int k = i; k > 0; k--)
            {
                a[(head + k) % a.length] = a[(head + k - 1) % a.length];
            }
            head = (head + 1) % a.length;
        }
        else //shift a[index+1]..a[tail] left one position
        {
            for(int k = i; k < N-1; k++)
            {
                a[(head + k) % a.length] = a[(head + k + 1) % a.length];
            }
            tail = (tail - 1) % a.length;
        }
        
        --N;
        if(N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    
    public void printQueue()
    {
        System.out.print("\nArray Deque: ");
        for(int i = 0; i < N; i++)
        {
            System.out.print(a[(head + i) % a.length] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        //Copy of the sample client provided in the test
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<String>();
        deque.addFirst("A");    
        deque.addFirst("B");
        deque.addLast("C");
        deque.addLast("D");
        deque.addFirst("E");
        deque.addFirst("F");
        deque.addLast("G");
        
        deque.printQueue();
        
        String s1 = deque.get(2);
        System.out.println(s1);
        
        deque.remove(2);
        
        String s2 = deque.get(2);
        System.out.println(s2);
        
        deque.printQueue();
    }
} 

