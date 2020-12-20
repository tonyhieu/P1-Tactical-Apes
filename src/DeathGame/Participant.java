package DeathGame;
import java.util.*;

public class Participant {

    //values for various relationships
    public final int STRANGER = 0;
    public final int FRIEND = 1;
    public final int CLOSEFRIENDS = 2;

    public int intel;
    public int str;
    public int soc;
    public int emp;
    public Hashtable<String, Integer> relationships = new Hashtable<String, Integer>();

    public Participant (int intel, int str, int soc, int emp, Hashtable<String, Integer> relationships) {
        this.intel = intel;
        this.str = str;
        this.soc = soc;
        this.emp = emp;
        this.relationships = relationships;
    }

}