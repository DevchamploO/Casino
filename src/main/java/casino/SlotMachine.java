package casino;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by tiffany on 7/8/17.
 */
public class SlotMachine {

    SlotMachine(Player p) {
        this.p = p;
        System.out.println("=======================");
        System.out.println("  PLAY SLOT MACHINE");
        System.out.println("=======================");
    }

    //Symbols for slot machine reels
    String[] symbols = {"CHERRY", "SEVEN", "DIAMOND", "HEARTS", "BELL", "BAR"};
    String[] chossenSymbols = new String[3];
    int bet;
    Scanner scan = new Scanner(System.in);
    Player p;

    public void playGame() {
        Random r = new Random();
        chossenSymbols[0] = symbols[r.nextInt(6)];
        chossenSymbols[1] = symbols[r.nextInt(6)];
        chossenSymbols[2] = symbols[r.nextInt(6)];

        System.out.println("===============================");
        System.out.println("|         |         |         |");
        System.out.println("| " + chossenSymbols[0] + " | " + chossenSymbols[1] + " | " + chossenSymbols[2] + " |");
        System.out.println("|         |         |         |");
        System.out.println("===============================");

        if (chossenSymbols[0].equals(chossenSymbols[1]) && chossenSymbols[1].equals(chossenSymbols[2])) {
            System.out.println("Congragulations! You Won!!!");
            p.addToBalance();
            System.out.println("Current balance: $" + p.getBalance());
        }
        else {
            System.out.println("You Lose!!");
            p.subtractBalance();
            System.out.println("Current balance: $" + p.getBalance());
        }
    }

    public void placeBet() {
        boolean betBoolean = false;
        while (!betBoolean) {
            System.out.println("How much will you bet (5 or higher)?");
            try {
                bet = scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error. Try again.");
                scan.next();
            }
            if (bet >= 5) {
                betBoolean = true;
            }
        }
        p.setBet(bet);
    }
}
