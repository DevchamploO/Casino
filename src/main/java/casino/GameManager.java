package casino;

/**
 * Created by tiffany on 7/7/17.
 */
public class GameManager {



    Player player = new Player();



    public void playHiLo() {
        HiLo h = new HiLo(player);
        h.placeBet();
        h.playgame();
    }

    public void playBlackjack() {
        Blackjack bj = new Blackjack(player);
        bj.placeBet();
        bj.playGame();
    }

    public void playSlotMachine() {
        SlotMachine sm = new SlotMachine(player);
        sm.placeBet();
        sm.playGame();
    }





}
