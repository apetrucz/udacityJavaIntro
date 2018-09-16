
import java.util.Scanner;

public class NumberGame {

    public static void main(String [] args){
        int randomNumber = (int) (Math.random()*100 +1 );
        System.out.println("try to guess number between 1-100");

        Scanner scanner = new Scanner(System.in);

        for(int i=10; i>0; i--){
            System.out.println("you have" + i + "guesses left");
            int guess = scanner.nextInt();
            if(guess == randomNumber){
                System.out.println("you won");
                break;
            }
            else if(guess < randomNumber){
                System.out.println("random number is larger");
            }
            else{
                System.out.println("random number is smaller");
            }
        }
    }

}
