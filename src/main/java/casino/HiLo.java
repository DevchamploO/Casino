package casino;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by tiffany on 7/6/17.
 */
public class HiLo {

    Player p;

    Deck d = new Deck();
    boolean isCorrect;
    String guess = "str";
    boolean isTrue = true;
    int bet;
    int loses = 0;

Scanner scan = new Scanner(System.in);
    private Card[] turns = new Card[4];

    HiLo(Player p) {
        this.p = p;
        //Generates each card in for the game
        turns[0] = d.drawCard();
        turns[1] = d.drawCard();
        turns[2] = d.drawCard();
        turns[3] = d.drawCard();
    }

    public void placeBet() {
        boolean betBoolean = false;
        while (!betBoolean) {
            System.out.println("How much will you bet (10 or higher)?");
            try {
                bet = scan.nextInt();
            }
            catch (InputMismatchException e) {
                System.err.println("Error. Try again.");
            }
            if (bet >= 10) {
                betBoolean = true;
            }
        }


        p.setBet(bet);
    }

    public void playgame() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
        System.out.println("This card is " + turns[i].getRank() + " of " + turns[i].getSuite());

        //First turn
        //loops if the input is wrong

            while (isTrue) {
                try {
                    System.out.println("Is the next card (h)igher or (l)ower?");
                    guess = scan.next();
                    if (guess.equals("h") || guess.equals("l")) {
                        isTrue = false;
                        counter++;
                    }
                } catch (Exception e) {
                    System.err.println("Error, try again.");
                }
            }
            scan.nextLine();
            System.out.println("Next card is " + turns[i+1].getRank() + " of " + turns[i+1].getSuite());
            checkGuess(i);
            if (loses > 1) {
                p.subtractBalance();
                System.out.println("----------------");
                System.out.println( "You lost the game.");
                System.out.println("Current balance: $" + p.getBalance());
                break;
            }
            isTrue = true;
        }
        if (loses < 2) {
            p.addToBalance();
            System.out.println("----------------");
            System.out.println( "Congratulations! You won the game.");
            System.out.println("Current balance: $" + p.getBalance());
        }
    }

    public int checkRank(String rank) {
        if (rank.equals("ACE")) {
            return 1;
        }
        else if (rank.equals("JACK")) {
            return 10;
        }
        else if (rank.equals("QUEEN")) {
            return 11;
        }
        else if (rank.equals("KING")) {
            return 12;
        }
        else {
            return Integer.parseInt(rank);
        }
    }

    public void checkGuess(int x) {
        if (guess.equals("h")) {
            isCorrect = true;
        }
        else {
            isCorrect = false;
        }
        //returns number
        if ((checkRank(turns[x].getRank()) < checkRank(turns[x+1].getRank())) == isCorrect) {
            System.out.println("You won!");
        }
        else if ((checkRank(turns[x].getRank()) == checkRank(turns[x+1].getRank())) == isCorrect) {
            System.out.println("Its a tie!");
        }
        else {
            System.out.println("You lost!");
            loses++;
        }
        System.out.println("**************************************");
    }
}
