import java.util.Scanner;
public class Spectrum
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Input Wave Length: ");
        double number = s.nextDouble();
        if (number > Math.pow(10,-1))
        {
            System.out.println("Radio Waves");
        }
        if (Math.pow(10,-3) <= number &&  Math.pow(10,-1)>= number)
        {
            System.out.println("Microwaves");
        }
        if (Math.pow(10,-7)*7 >= number &&  Math.pow(10,-3)<= number)
        {
            System.out.println("Infrared");
        }
    }
}