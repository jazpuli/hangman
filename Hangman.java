import java.util.*;
import java.io.*;

public class Hangman{
    
    private String word; 
    private String currentGuess;
    private int attemptsRemaining;
    
    //constructor
    public Hangman(String word){
        this.word = word;
        this.currentGuess = "_".repeat(word.length());
        this.attemptsRemaining = 6; //head, torso, leg, leg, arm, arm 
    }
    
    


//guess letter function 
public void guessLetter(char letter) {
    char[] currentGuessArray = currentGuess.toCharArray(); 
    char[] wordArray = word.toCharArray();
    
    boolean letterGuessed = false;
    
    for(int i =0; i< word.length(); i++){
        if (wordArray[i] == letter){
            currentGuessArray[i] = letter;
            letterGuessed = true;
        }
    }
    if (!letterGuessed) {
        attemptsRemaining--;
    }
    currentGuess = new String(currentGuessArray);
    }
        


public boolean gameWon(){
    return currentGuess.equals(word);
}

public boolean gameLost(){
    return attemptsRemaining == 0;
}

public boolean isAlpha(String input) {
    return input.matches("[a-zA-Z]+");
}

//start game function 
public void startGame(){
     Scanner scanner = new Scanner(System.in);
    while (!gameWon() && !gameLost()){
        System.out.println("Current Guess: " + currentGuess);
        System.out.println("Attempts Remaining: " + attemptsRemaining);
        System.out.print("Guess a letter: ");
        String input = scanner.nextLine();
        
        if(input.length() != 1){
            System.out.println("Invalid Input. Enter a single letter.");
        }else {
            char letter = input.charAt(0);
            guessLetter(letter);
        }
        
        if (gameWon()) {
            System.out.println("Congratulations, you've won! The word is " + word +"!");
        } 
        
        if (gameLost()) {
            System.out.println("Sorry, you've lost. The word was " + word +"!");
        }
        
       
    }
        
    }

}

