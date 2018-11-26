import java.util.Scanner;

public class BullCowGame{
    public static void main(String[] args){
        String[] words = {
            "ant",
            "planet",
            "dog"
        };
        boolean play = false;
        int tires = 5;

        Scanner scan = new Scanner(System.in);

        do{
            String gameWord = words[(int)(Math.random()*words.length)];
            System.out.println("Guess word with " + gameWord.length() + " letters, you have " + tires + " tires.");

            for(int i = 1; i <= tires; i++){
                int bull = 0;
                int cow = 0;
                System.out.print("Try: " + i + ": ");
                String guess = scan.nextLine();
                for(int j=0; j<gameWord.length(); j++){
                    for(int k=0; k<guess.length(); k++){
                        if(gameWord.charAt(j) == guess.charAt(k)){
                            if(j==k){
                                bull++;
                            }else{
                                cow++;
                            }
                        }
                    }
                }

                System.out.println("Bull: " + bull + ", Cow: " + cow);
                if(bull == gameWord.length() && guess.equals(gameWord)){
                    System.out.println("Congratulations! Guess word: " + gameWord);
                    break;
                }else if (i == tires){
                    System.out.println("Oh! So sorry, but my word was: " + gameWord);
                }
                
                bull = 0;
                cow = 0;
            }
            System.out.print("Do you want play again?[y/N]");
            String answer = scan.nextLine();
            play = answer.length() > 0 && (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') ? true : false;

        }while(play);
    }
}
