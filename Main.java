import java.util.*;
import java.io.*;

public class Main{
    
private static boolean authenticateUser(){
    try{
        File inputFile = new File("secret");
        Scanner scanner = new Scanner(inputFile);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        
        if(line1.equals("username: admin") && line2.equals("password: !ha2n4gm0an!")) {
            return true;
        } else {
            System.out.println("Username or password are incorrect");
            System.exit(0);
            return false;
        }
        
    } catch(FileNotFoundException e){
        System.out.println("File \" secret\" not found");
        e.printStackTrace();
        return false;
    }
}
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to guess: ");
        String word = scanner.nextLine();
	while (word.length() < 5 || word.length() > 10){
		System.out.println("Please enter a word with 5-10 characters: ");
		scanner = new Scanner(System.in);
		word = scanner.nextLine();
	} 
        
        Hangman hangman = new Hangman(word);
        if (authenticateUser()){
            hangman.startGame();
        }
        
    }
    
}
