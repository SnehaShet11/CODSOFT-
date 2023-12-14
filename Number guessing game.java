import java.util.Scanner;
public class Main {
    public static void main (String args[])
    {
        int mynumber=(int)(Math.random() *100);
        Scanner sc= new Scanner(System.in);
        int attempts =0;
        System.out.println("Welcome to Guess the Number Game!!");
        do{
            System.out.println("Guess my number(1-100):");
            int userNumber=sc.nextInt();
            attempts++;

            if(userNumber==mynumber)
            {
                System.out.println("whhooo..!! u guessed the correct number in  " + attempts + " attempts.");
                break;
            }
            else if(userNumber<mynumber)
            {
                System.out.println("oh noo! your number is  too small");
                System.out.println("Try again");
            }
            else
            {
                System.out.println("oh noo! ur number is too large");
                System.out.println("Try again");
            }
        }while(true);
        System.out.println("my number was:");
        System.out.println(mynumber);
        System.out.println("Thank you for playing");
        System.out.println("press 1 to play again, 0 to exit");

        int userchoice=sc.nextInt();
        if(userchoice==1)
        {
            main(args); // Recursive call to play again...
        }
        else
        {
            return;
        }
    }
}
