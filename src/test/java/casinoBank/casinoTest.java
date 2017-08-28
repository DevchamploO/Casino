package casinoBank;

import casino.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tiffany on 7/6/17.
 */
public class casinoTest {

    //Testing the player class
    @Test
    public void shouldShowBalance() {
        Player p = new Player();
        assertEquals(1000, p.getBalance());
    }





}
