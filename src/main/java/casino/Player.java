package casino;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiffany on 7/6/17.
 */
public class Player {

    private int balance;
    private int bet;

    public Player() {
        balance = 1000;
    }

    public int getBalance() {
        return balance;
    }

    public int addToBalance() {
        return balance += bet;
    }

    public int subtractBalance() {
        return balance -= bet;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
