import java.util.Scanner;

public class CompareAdjacent
{
    /**
     * Detects duplicate adjacent numbers in the specific series of numbers.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a series of number (type 'q' to quit)");
        double prevValue = in.nextDouble();
        while(in.hasNextDouble())
        {
            double value = in.nextDouble();
            if (value == prevValue)
            {
                System.out.println("Duplicate number!");
            }
            prevValue = value;
            
        }
    }

}
