import java.util.Scanner;
public class FindFirstMatch
{
    /**
     * Computes the index of the first space (' ') in the specified string.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.nextLine();
        boolean found = false;
        int index = 0;
        while( !found && index < str.length())
        {
            char ch = str.charAt(index);
            if (ch == ' ' )
            {
                found = true;
            }
            else
            {
                index++;
            }
        }
        if (found)
        {
            System.out.println("Index of first space: " + index);
        }
        else
        {
            System.out.println("No spaces.");
        }
    }
}