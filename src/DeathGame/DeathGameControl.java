package DeathGame;

import java.util.*;

public class DeathGameControl {
    public float getKillChance (Participant p) {

        //chance of being able to overpower
        float overpower = p.str * 5;

        //chance of being able to get away with it
        float deceive = p.intel * 5 + p.emp * 3 + p.soc * 4;

        //relationships
        Set<Participant> rels = p.relationships.keySet();
        float relScore = 0;
        for (Participant pa : rels) {
            relScore += p.relationships.get(pa);
        }
        relScore *= 10;

        //checking if score is less than 0
        float score = overpower + deceive - relScore;
        if (score < 0)
            score = 0;

        return score;
    }

    public float getDeathChance (Participant p) {

        //ease of killing
        float ease = 5 * (10 - p.soc) + 5 * (10 - p.str);

        //threat level
        float threat = p.intel * 3 + p.soc * 5;

        //will to live
        Set<Participant> rels = p.relationships.keySet();
        float relScore = 0;
        for (Participant pa : rels) {
            relScore += p.relationships.get(pa);
        }
        relScore *= 3;
        float will = p.soc * 2 + p.intel * 2 + relScore;

        //check for score < 0
        float score = ease + threat - will;

        if (score < 0)
            score = 0;

        return score;
    }

    public float getTotalDeathChance (Participant[] ps) {
        float sum = 0;
        for (Participant p : ps) {
            sum += p.deathChance;
        }
        return sum;
    }

    public float getTotalKillChance (Participant[] ps) {
        float sum = 0;
        for (Participant p : ps) {
            sum += p.deathChance;
        }
        return sum;
    }

    public void setChances (Participant[] ps) {
        for (Participant p : ps) {
            p.deathChance = getDeathChance(p);
            p.killChance = getKillChance(p);
        }
    }
}
