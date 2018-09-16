

import java.util.Scanner;
import java.io.File;

public class Game {
    private static final int MAX_GUESSES = 5;
    private String randomMovie;
    private String currentGuess;
    private int guessesLeft;
    private boolean hasWon;
    private String wrongLetterList;

    Game() throws Exception{

        //open file containing list of movies
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        String [] movie = new String[100];
        int lineCount = 0;

        //read list of movies into movie array
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            movie[lineCount] = line;
            lineCount++;
        }

        //select a random movie from list and assign to
        //randomMovie variable
        int random = (int) (Math.random()*lineCount);
        this.randomMovie = movie[random];
        this.guessesLeft = MAX_GUESSES;
        this.hasWon = false;
        this.currentGuess = "";
        this.wrongLetterList = "";
        setUpUnderscores();

    }

    Game (String randomMovie){

        //allow user to input their own movie
        this.randomMovie = randomMovie;
        this.guessesLeft = MAX_GUESSES;
        this.hasWon = false;
        this.currentGuess = "";
        this.wrongLetterList = "";
        setUpUnderscores();

    }

    private void setUpUnderscores(){
        for(int i = 0; i< this.randomMovie.length(); i++) {
            if (this.randomMovie.charAt(i) != ' ') {
                this.currentGuess += "_";
            } else {
                this.currentGuess += " ";
            }
        }
    }

    private void updateCurrentGuess(char guess){
        boolean goodGuess = false;
        for(int i = 0; i< this.randomMovie.length(); i++) {
            if (this.randomMovie.charAt(i) == guess) {
                this.currentGuess = this.currentGuess.substring(0,i) + guess + this.currentGuess.substring(i+1,this.currentGuess.length());
                goodGuess = true;
            }
        }
        if(!goodGuess){
            this.guessesLeft--;
            this.wrongLetterList += guess;
        }
    }

    private void displayGuess(){
        for(int i = 0; i< this.currentGuess.length(); i++){
            System.out.print(this.currentGuess.charAt(i) + " ");
        }
    }

    private void checkIfWon(){
        for(int i = 0; i< this.currentGuess.length(); i++){
            if(this.currentGuess.charAt(i) != this.randomMovie.charAt(i)){
                return;
            }
        }
        this.hasWon = true;
    }

    private void turn(){
        System.out.println("\nYou are guessing: ");
        displayGuess();
        System.out.println("\nYou have guessed " + (MAX_GUESSES-guessesLeft) + " wrong letters  " + wrongLetterList);
        System.out.print("Guess a letter \n");
        Scanner scanUser = new Scanner(System.in);
        char guess = scanUser.next().charAt(0);
        updateCurrentGuess(guess);
        checkIfWon();
        //if(this.currentGuess == this.randomMovie){
        //   this.hasWon = true;
        //}
    }

    void playGame(){
        while(!this.hasWon && this.guessesLeft > 0){
            turn();
        }
        if(this.hasWon){
            System.out.println("You win!\nYou have guessed " + this.randomMovie + " correctly.");
        }
        else{
            System.out.println("You have lost. The correct movie was " + this.randomMovie + "\nTry another time.");
        }
    }


}
