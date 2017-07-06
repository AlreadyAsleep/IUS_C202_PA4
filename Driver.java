package PA4;

/**
 *
 * @author BenHeil 
 * @since 06282017
 */
import java.util.*;
import java.io.*;
public class Driver
{
    MyLinkedList<String>[] lists;
    long wordsFound, wordsNotFound, compsFound, compsNotFound;
    Scanner stdin;
    File file;
    String temp;
    int[] i_temp;
    
    public Driver()
    {
        lists = new MyLinkedList[26];
        i_temp = new int[1];
        for(int i = 0; i < lists.length; i++)
        {
            lists[i] = new MyLinkedList<>();
        }
        file = new File("src/PA4/randic.txt");
        try
        {
            stdin = new Scanner(file);
            while(stdin.hasNext())
            {
                temp = stdin.next().toLowerCase().trim();
                lists[temp.charAt(0) - 97].add(temp);
            }
            stdin.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Dictionary file not found... Closing");
            System.exit(1);
        }
        wordsFound = wordsNotFound = compsFound = compsNotFound = 0;
    }
    
    public void run(String path)
    {
        file = new File(path);
        try
        {
            i_temp[0] = 0;
            stdin = new Scanner(file);
            while(stdin.hasNext())
            {
                temp = stdin.next().toLowerCase().trim();
                if(temp.charAt(0) < 97 || temp.charAt(0) > 123 )
                    continue;
                if(lists[temp.charAt(0) - 97].contains(temp, i_temp))
                {
                    wordsFound++;
                    compsFound+=i_temp[0];
                }
                else
                {
                    wordsNotFound++;
                    compsNotFound+=i_temp[0];
                }
                i_temp[0] = 0;
            }
            stdin.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Requested file not found... Closing");
            System.exit(1);
        }
        System.out.println("Words found: " + wordsFound);
        System.out.println("Words not found: " + wordsNotFound);
        System.out.println("Comparisons made that found a match: " + compsFound);
        System.out.println("Compsrisons made with no match: " + compsNotFound);
        System.out.println("Average comparisons per word found: " + ( compsFound / wordsFound));
        System.out.println("Average comparisons per word not found: " + ( compsNotFound / wordsNotFound));
    }
    
    
    public static void main(String[] args)
    {
        Driver d = new Driver();
        d.run("src/PA4/oliver.txt");
    }
}
