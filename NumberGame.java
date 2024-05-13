import java.util.Random;
import java.util.Scanner;
public class NUMBERGAME
{

    public static void main(String args[])
    {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int num = rand.nextInt(100);
        System.out.println("Welcome to the Number Guessing Game!\n\nYou have to guess a number between 1 to 100.\nYou are given a maximum of 5 tries to guess.\n\n");
        int i;
        for(i=0;i<5;i++)
        {
            int guess = sc.nextInt();
            if (guess == num)
            {
                System.out.println("OOhOO! Your guess is correct! You have won the game.");
                break;
            }
            else
            {
                if(guess>num)
                {
            System.out.println("Your number is greater than the generated value.");
            }
            else{
                System.out.println("Your number is lesser than the generated value.");
        }

}
    }
            System.out.println("The generated number was: "+num);
}
}
