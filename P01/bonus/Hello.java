import java.util.Scanner;

public class Hello 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String fName, lName;

        System.out.println("What is your name? ");

        fName = in.next();
        lName = in.next();
        
        System.out.println("hello, " + fName + ' ' + lName);
    }
}