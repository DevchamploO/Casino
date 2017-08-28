package casino;

/**
 * Created by tiffany on 7/6/17.
 */
public class Card {

    private String suite;

    private String rank;

    public Card(String suite, String rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
