package casino;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by tiffany on 7/6/17.
 */
public class Menu {

    public Menu() {
        System.out.println("|o|o|o|o|o|o|o|o|o|");
        System.out.println("|                 |");
        System.out.println("|   CASINO GAMES  |");
        System.out.println("|                 |");
        System.out.println("|o|o|o|o|o|o|o|o|o|");

        mainMenu();
    }

    Player player = new Player();
    GameManager gm = new GameManager();
    Scanner sc = new Scanner(System.in);
    boolean isTrue = true;

    //Choose games from this menu
    public void mainMenu() {
        System.out.println("Currennt balance: $" + player.getBalance());

        while(isTrue) {
            int choice = 0;

            System.out.println("----------------------");
            System.out.println("Choose your game");
            System.out.println("----------------------");
            System.out.println("[1] Hi-Lo");
            System.out.println("[2] Black Jack");
            System.out.println("[3] Slot Machine");

            try {
                System.out.println("========================================");
                System.out.println("Pick which game you want to play below.");
                choice = sc.nextInt();
            }
            catch (InputMismatchException e){
                System.err.println("Error, not an option.");
                sc.next();
            }

            switch (choice) {
                case 1:
                    gm.playHiLo();
                    break;
                case 2:
                    gm.playBlackjack();
                    break;
                case 3:
                    gm.playSlotMachine();
                    break;
                default:
                    System.out.println("Choose a correct option.");
            }
        }

    }

}
