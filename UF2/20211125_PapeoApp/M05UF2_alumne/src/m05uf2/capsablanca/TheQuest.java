package m05uf2.capsablanca;

import java.util.Hashtable;

/**
 *
 * @author Usuari
 */
public class TheQuest {

    private static final String theChallenge = "only the bests survive!";

    public int startTheQuest(String yourChallenge, String yourCommands) {

        System.out.println("- - - - - - - - - - - - \nWelcome to the quest!");
        if (yourChallenge == null || yourChallenge.isEmpty()) {
            return -1;
        }

        if (yourChallenge.trim().length() != yourChallenge.length()) {
            return -2;
        }
        if (yourChallenge.replace(" ", "").length() != yourChallenge.length()) {
            return -2;
        }
        if (yourCommands == null || yourCommands.length() == 0) {
            return -3;
        }

        System.out.println("You passed the first trial.");

        boolean questFailure = false;
        boolean questAccomplished = false;

        String previousChallenge = null;
        int c = 0;
        boolean Y_already_used = false;
        while (c < yourCommands.length() && !questFailure && !questAccomplished ) {

            previousChallenge = yourChallenge;
            
            char command = yourCommands.charAt(c);
        
            switch (command) {
                case 'X':
                    if(!yourChallenge.contains("k")){
                        questFailure = true;
                    } else {
                        yourChallenge = yourChallenge.replaceFirst("k", " ");
                    }
                    break;
                case 'Y':
                    if (Y_already_used) {
                        questFailure = true;
                    } else {
                        Y_already_used = true;
                        yourChallenge = yourChallenge.toLowerCase();
                    }
                    break;
                case '-':
                    if (c!=0) {
                        yourChallenge = previousChallenge;
                    } else {
                        questFailure = true;
                    }
                    break;
                case '7':
                    if ( !yourChallenge.contains("3")) {
                        questFailure = true;
                    } else {
                        yourChallenge = yourChallenge.replace("3", "E");
                        yourChallenge = yourChallenge.replace("4", "A");
                        yourChallenge = yourChallenge.replace("1", "I");
                        yourChallenge = yourChallenge.replace("0", "O");
                        yourChallenge = yourChallenge.replace("|_|", "U");
                    }
                    break;
                default: {

                    questFailure = true;
                    break;
                }

            }
            
            questAccomplished = yourChallenge.equals(theChallenge);
            c++;
        }
        if (questAccomplished) {
            switch (yourCommands.length()) {
                case 3:
                    System.out.println("(0) Not bad for a beginner");
                    break;
                case 4:
                    System.out.println("(1) Improving your skills?");
                    break;
                case 5:
                    System.out.println("(2) You are mastering the game...");
                    break;
                case 7:
                    System.out.println("(3) You are really close to the end!");
                    break;
                case 9:    
                    System.out.println("(4) Awesome challenger, you did it ! We admire your wisdom !");
                    break;
            }
        } else {
            System.out.println("Do not dispair, give it another try !");
        }

        return 0;
    }
}
