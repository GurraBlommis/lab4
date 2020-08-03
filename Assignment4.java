 import java.util.Scanner;


     /** This is an english vocabulary test
      * @version 2020-08-02
      * @author Gustav Blomdahl
      */
     public class Assignment4 {

         /** This executes the program
          * @param args not used
          */
         public static void main(String[] args) {
             run();
         }



         /** Run will initiate the vocabulary exercise.
          * Run starts a scanner which reads user input and also creates an input string which the scanner reads.
          * Run also creates a Boolean which will be false until the player completes the game or chose to quit.
          */
         public static void run() {
             WordArray array = new WordArray();
             Scanner sc = new Scanner(System.in);
             String user_input = "";
             Boolean quit = false;

             try {
                 /* This makes the program continue running as long as the player doesn´t input Q
                  * It also sets up the necessary variables for the program
                  */
                 while (!quit) {
                     introduction();
                     int j = 0;
                     int index = 0;
                     int score = 0;
                     int eng_word_length = array.get_word(j).engelska.length();


                     //This will make the program to print out the next swedish word and take in the user input,
                     for (j = 0; j == index; j++) {
                         System.out.println(array.get_word(j).svenska + ":");
                         user_input = sc.next().trim();
                         // If the user presses Q the exercise will stop and an exit message will print out.
                         if (user_input.equalsIgnoreCase("Q")) {
                             System.out.println("Du svarade på totalt " + index + " glosor och hade " + score + " rätt. Välkommen åter!");
                             quit = true;
                         // If the user input matches the english word, the index placement and score will increase by one.
                         } else if (user_input.equalsIgnoreCase(array.get_word(j).engelska)) {
                             index++;
                             score++;
                             // If the user is on the last word of the array, this message will print out and the program will quit.
                             if (index == array.arrayLength) {
                                 System.out.println("Korrekt!" + score + " rätt av " + index + " ord." + "\nDu svarade på totalt " + index + " och hade " + score + " rätt. Välkommen åter!");
                                 quit = true;
                             // If the input is correct, this message will be printed out
                             } else {
                                 System.out.println("Korrekt!" + score + " rätt av " + index + " ord.");

                             }
                         }
                         // If the input word has a majority of the letters corresponding with the index word, this will run and index increase by one.
                         else if (compare(array.get_word(j).engelska,user_input)) {
                             index++;
                             //If the user is on the last word of the array, the program will print this out and then terminate the program.
                             if (index == array.arrayLength) {
                                 System.out.println("Nästan rätt. Korrekt svar är " + array.get_word(j).engelska);
                                 System.out.println("Du svarade på totalt " + index + " glosor och hade " + score + " rätt. Välkommen åter!");
                                 quit = true;
                             // If the input is close to correct, this message will be printed.
                             } else {
                                 System.out.println("Nästan rätt. Korrekt svar är " + array.get_word(j).engelska);

                             }

                         // If the input is none of the two above, this will run which means that the input was false.
                         } else {
                             index++;
                             //If the user is on the last word of the array, the program will print this out and then terminate the program.
                             if (index == array.arrayLength) {
                                 System.out.println("Fel svar!" + " Korrekt svar är " + array.get_word(j).engelska);
                                 System.out.println("Du svarade på totalt " + index + " och hade " + score + " rätt. Välkomen åter!");
                                 quit = true;
                             // If the input was false, this will be printed.
                             } else {
                                 System.out.println("Fel svar!. Rätt svar är " + array.get_word(j).engelska + ".");


                             }

                         }
                     }
                 }
             } catch (Exception e) {
                 return;
             }
         }

         /**
          * This method contains the introduction which explains how to use the program
          */
         public static void introduction() {
             System.out.println("** GLOSÖVNING - ENGELSKA **");
             System.out.println("Skriv det engelska ordet. Avsluta programmet genom att skriva Q");
         }

         /** This method checks if the input word contains more than half of the letters in the english word
          *
          * @param eng This is the english word
          * @param userInput This is the input given by the user
          * @return Returns false or true depending on if the input contains more/ less then half of the letters in the english word
          */
         static boolean compare(String eng, String userInput){
             int score = 0;
             for(int x=0; x< eng.length(); x++){
                 for(int y=0; y < userInput.length();y++){
                     if (eng.charAt(x)==userInput.charAt(y)){
                         score++;

                     }
                 }
             }
             if (score >= 0.5*eng.length()){
                 return true;
             } else {
                 return false;
             }
         }
     }


 /**
  * This method creates a Word object that contains the english and swedish word.
  */

 class Word {
     String svenska;
     String engelska;


     // Constructor for the word classes
     public Word(String svenska, String engelska)
     {
         this.svenska = svenska;
         this.engelska = engelska;
     }
 }

 /**
  * This class contains an array of word objects, enabling easy modification of the words in the array
  */
 class WordArray{
         // Contains the swedish words and also the english translation
         Word bil= new Word("bil", "car");
         Word hus = new Word("hus", "house");
         Word springa = new Word("springa", "run");
         Word blå = new Word("blå", "blue");
         Word baka = new Word("baka", "bake");
         Word hoppa = new Word("hoppa", "jump");
         Word simma = new Word("simma", "swim");
         Word måne = new Word("måne", "moon");
         Word väg = new Word("väg", "road");
         Word snäll = new Word("snäll", "kind");

         // An array containing the swedish words
         Word[] sweWords = {bil,hus,springa,blå,baka,hoppa,simma,måne,väg,snäll};

         int arrayLength = sweWords.length;
    // Gets the swedish word
    public Word get_word(int index) {
         return sweWords[index];
         }
    }





