 import java.util.Scanner;


     /**
      *
      */
     public class Assignment4 {

         /**
          * @param args not used
          */
         public static void main(String[] args) {
             run();
         }

         /**
          *
          */
         public static void run() {

             Scanner sc = new Scanner(System.in);
             String user_input = "";
             Boolean quit = false;

             VocabularyArray vocabularyArray = new VocabularyArray();
             String[] swe_words = vocabularyArray.getSwe_words();
             String[] eng_words = vocabularyArray.getEng_words();

             try {
                 while (!quit) {
                     introduction();
                     int j = 0;
                     int index = 0;
                     int score = 0;
                     int eng_word_length = eng_words[j].length();


                     //ahfhfhf
                     for (j = 0; j == index; j++) {
                         System.out.println(swe_words[j] + ":");
                         user_input = sc.next().trim();

                         if (user_input.equalsIgnoreCase("Q")) {
                             System.out.println("Du svarade på totalt " + index + " glosor och hade " + score + " rätt. Välkommen åter!");
                             quit = true;
                         } else if (user_input.equalsIgnoreCase(eng_words[j])) {
                             index++;
                             score++;

                             if (index == eng_words.length) {
                                 System.out.println("Korrekt!" + score + " rätt av " + index + " ord." + "\nDu svarade på totalt " + index + " och hade " + score + " rätt. Välkommen åter!");
                                 quit = true;
                             } else {
                                 System.out.println("Korrekt!" + score + " rätt av " + index + " ord.");

                             }
                         }
                         //blbl
                         else if (user_input.compareToIgnoreCase(eng_words[j].substring(0,eng_word_length)) >= 0.5*eng_word_length) {
                             index++;
                             if (index == eng_words.length) {
                                 System.out.println("Nästan rätt. Korrekt svar är " + eng_words[j]);
                                 System.out.println("Du svarade på totalt " + index + " glosor och hade " + score + " rätt. Välkommen åter!");
                                 quit = true;
                             } else {
                                 System.out.println("Nästan rätt. Korrekt svar är " + eng_words[j]);
                             }


                         } else {
                             index++;
                             if (index == eng_words.length) {
                                 System.out.println("Fel svar!" + " Korrekt svar är " + eng_words[j]);
                                 System.out.println("Du svarade på totalt " + index + " och hade " + score + " rätt. Välkomen åter!");
                                 quit = true;
                             } else {
                                 System.out.println("Fel svar!. Rätt svar är " + eng_words[j] + ".");


                             }

                         }
                     }
                 }
             } catch (Exception e) {
                 return;
             }
         }
         public static void introduction() {
             System.out.println("** GLOSÖVNING - ENGELSKA **");
             System.out.println("Skriv det engelska ordet. Avsluta programmet genom att skriva Q");
         }


     }




     class VocabularyArray {

         private String[] swe_words = {"bil", "hus","springa","blå","baka","hoppa","simma","måne","väg","snäll"};
         private String[] eng_words = {"car", "house","run","blue","bake","jump","swim","moon","road","kind"};

         public String[] getSwe_words() {
             return swe_words.clone();
         }

         public String[] getEng_words() {
             return eng_words.clone();
         }
     }
