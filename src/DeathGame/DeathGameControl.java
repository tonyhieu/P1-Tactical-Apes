package DeathGame;

import java.lang.reflect.Array;
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

    //finds sum of all death chance
    public float getTotalDeathChance (ArrayList<Participant> ps) {
        float sum = 0;
        for (Participant p : ps) {
            sum += p.deathChance;
        }
        return sum;
    }

    //finds sum of all kill chance
    public float getTotalKillChance (ArrayList<Participant> ps) {
        float sum = 0;
        for (Participant p : ps) {
            sum += p.deathChance;
        }
        return sum;
    }

    //sets chances for each participant
    public void setChances (ArrayList<Participant> ps) {
        float totalDeath = getTotalDeathChance(ps);
        float totalKill = getTotalKillChance(ps);

        for (Participant p : ps) {
            p.deathChance = getDeathChance(p)/totalDeath;
            p.killChance = getKillChance(p)/totalKill;
        }
    }

    //chooses killer
    public Participant chooseKiller (ArrayList<Participant> ps) {
        //finds eligible killers
        ArrayList<Participant> eligibles = new ArrayList<Participant>();
        for (Participant p : ps) {
            if (p.killChance > 0) {
                eligibles.add(p);
            }
        }

        //failsafe for if there are no eligible killers
        if (eligibles.size() == 0) {
            return ps.get( (int) Math.random() * ps.size());
        }

        //chooses killer using probability and random numbers
        double roll = Math.random() * (100);
        int index = 999;
        float sum = 0;
        int i = 0;
        //checks if roll is in a certain range to choose killer
        while (index == 999) {
            if (sum < roll && roll < eligibles.get(i).killChance + sum) {
                index = i;
            } else {
                i++;
                sum += eligibles.get(i).killChance;
            }
        }

        return eligibles.get(index);
    }

    //chooses victim
    public Participant chooseVictim (ArrayList<Participant> ps) {
        //finds eligible victims
        ArrayList<Participant> eligibles = new ArrayList<Participant>();
        for (Participant p : ps) {
            if (p.deathChance > 0) {
                eligibles.add(p);
            }
        }

        //failsafe for if there are no eligible victims
        if (eligibles.size() == 0) {
            return ps.get( (int) Math.random() * ps.size());
        }

        //finds victim via probability
        double roll = Math.random() * (100);
        int index = 999;
        float sum = 0;
        int i = 0;
        while (index == 999) {
            if (sum < roll && roll < eligibles.get(i).deathChance + sum) {
                index = i;
            } else {
                i++;
                sum += eligibles.get(i).deathChance;
            }
        }

        return eligibles.get(index);
    }

    //chance of getting away with the killing
    public boolean escape (Participant p) {
        double roll = Math.random() * (100);
        double escapeChance = p.intel * 2 + p.emp;

        return roll < escapeChance;
    }
}

