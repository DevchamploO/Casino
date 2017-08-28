package casino;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by tiffany on 7/7/17.
 */
public class Blackjack {

    Deck deck = new Deck();
    Scanner scan = new Scanner(System.in);
    Player p;
    int playerTotal;
    int dealerTotal;
    int bet;
    int turnCounter = 0;
    Card playerLastCard;
    Card playerCard;
    Card dealerLastCard;
    Card dealerCard;

    Blackjack(Player p) {
        this.p = p;
        System.out.println("----------------------");
        System.out.println("Welcome to Blackjack");
        System.out.println("----------------------");
    }

    public void placeBet() {
        boolean betBoolean = false;
        while (!betBoolean) {
            System.out.println("How much will you bet (10 or higher)?");
            try {
                bet = scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error. Try again.");
                scan.next();
            }
            if (bet >= 10) {
                betBoolean = true;
            }
        }
        p.setBet(bet);
    }

    public void playGame() {
        //draws first cards for the game
        if (turnCounter == 0) {
            playerTurn();
            playerTurn();
            getTotal("Player", playerTotal);
            dealerTurn();
            getTotal("Dealer", dealerTotal);
        }

        String a = "h";
        while (a.equals("h")) {
            boolean x = true;
            while (x) {
                System.out.println("(h)it or (s)tand?");
                a = scan.next();
                if (a.equals("h")) {
                    playerTurn();
                    getTotal("Player", playerTotal);
                    if (playerTotal > 21) {
                        System.out.println("-----------------------------");
                        System.out.println("You are over 21. You lose!");
                        p.subtractBalance();
                        System.out.println("Current balance: $" + p.getBalance());

                        a = "s";
                        x = false;
                    } else if (playerTotal == 21) {
                        System.out.println("----------------------------------------------");
                        System.out.println("Congratulations, you have blackjack! You win!");
                        p.addToBalance();
                        System.out.println("Current balance: $" + p.getBalance());
                        a = "s";
                        x = false;
                    }
                } else if (a.equals("s")) {
                    x = false;
                    dealerDrawsLoop();
                }
            }
        }

        p.setBet(0);
    }

    /*public String theInput() {
        System.out.println("(h)it or (s)tand?");
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        if (a.equals("h")) {
            playerTurn();
            getTotal("Player", playerTotal);
            return a;
        }
        else {
            return a;
        }
    }

    public void recursion() {
        if (!theInput().equalsIgnoreCase("s")) {
            theInput();

        }
    }*/

    public void playerTurn() {
        System.out.println("player draws...");
        playerLastCard = deck.drawCard();
        playerTotal += getRankNum(playerLastCard.getRank(), playerTotal);
        System.out.println(playerLastCard.getRank() + " of " + playerLastCard.getSuite());
    }

    public void dealerTurn() {
        System.out.println("dealer draws...");
        dealerLastCard = deck.drawCard();
        dealerTotal += getRankNum(dealerLastCard.getRank(), dealerTotal);
        System.out.println(dealerLastCard.getRank() + " of " + dealerLastCard.getSuite());
    }

    public void dealerDrawsLoop() {
        while (dealerTotal < 16) {
            dealerTurn();
            getTotal("Dealer", dealerTotal);
        }
        if (dealerTotal == 21) {
            System.out.println("Dealer has blackjack. You lose!");
        }
        else if (dealerTotal > 21) {
            System.out.println("-------------------------------");
            System.out.println("Dealer is over 21. You win!");
            p.addToBalance();
            System.out.println("Current balance: $" + p.getBalance());
        }
        else {
            if (playerTotal < dealerTotal) {
                System.out.println("-------------------------");
                System.out.println("Dealer Wins. You Lose!");
                p.subtractBalance();
                System.out.println("Current balance: $" + p.getBalance());
            }
            else if (playerTotal > dealerTotal) {
                System.out.println("-------------------------");
                System.out.println("Dealer loses. You win!");
                p.addToBalance();
                System.out.println("Current balance: $" + p.getBalance());
            }
            else if (playerTotal == dealerTotal) {
                System.out.println("-------------------------");
                System.out.println("You are tied with the dealer.");
                System.out.println("Current balance: $" + p.getBalance());
            }
        }
    }

    //gets number for each card
    public int getRankNum(String rank, int total) {
        if (rank.equals("JACK") || rank.equals("QUEEN") || rank.equals("KING")) {
            return 10;
        }
        //returns either 1 or 11 depending on size of total
        else if (rank.equals("ACE")) {
            if ((21 - total) > 11) {
                return 11;
            }
            else {
                return 1;
            }
        }
        else {
            return Integer.parseInt(rank);
        }
    }

    //displays total points
    public void getTotal(String name, int total) {
        System.out.println(name + "'s total is " + total);
    }

}
