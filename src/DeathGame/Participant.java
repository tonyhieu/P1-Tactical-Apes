package DeathGame;
import java.util.*;

public class Participant {

    //values for various relationships
    public final int STRANGER = 0;
    public final int FRIEND = 1;
    public final int CLOSEFRIENDS = 2;

    int intel;
    int str;
    int soc;
    int emp;
    Hashtable<Participant, Integer> relationships = new Hashtable<Participant, Integer>();
    String name;

    float deathChance = 0;
    float killChance = 0;

    public Participant (int intel, int str, int soc, int emp, Hashtable<Participant, Integer> relationships, String name) {
        this.intel = intel;
        this.str = str;
        this.soc = soc;
        this.emp = emp;
        this.relationships = relationships;
        this.name = name;
    }

}
