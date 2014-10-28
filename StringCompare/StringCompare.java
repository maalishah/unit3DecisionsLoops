public class StringCompare
{
    public static void main(String[] args)
    {
        String word1 = "catalog";
        String word2 = "cat";
        int result = word1.compareTo(word2);
        if (result > 0)
        {
            System.out.println("word1 is lexicographically greater than aaa");
        }
        else
        {
            System.out.println("word1 is not");
        }
        if (result == 0)
        {
            System.out.println("They're equal.");
        }
        else
        {
            System.out.println("They're not equal.");
        }
        
        System.out.println(result);
    }
}