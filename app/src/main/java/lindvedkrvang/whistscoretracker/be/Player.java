package lindvedkrvang.whistscoretracker.be;

import android.support.annotation.NonNull;

import java.util.Iterator;

public class Player implements Comparable<Player>{

    private String mName;
    private int mScore;
    private int mID;

    public Player(String name, int ID) {
        mName = name;
        mID = ID;
        mScore = 0;
    }

    /**
     * Adds points to the score.
     * @param points
     */
    public void addPoints(int points){
        mScore += points;
    }

    /**
     * Substracs points from the score.
     * @param points
     */
    public void substractPoints(int points){
        mScore -= points;
    }

    /**
     * Returns the score.
     * @return
     */
    public int getScore(){
        return mScore;
    }

    /**
     * Resets the score of the player.
     */
    public void resetScore(){
        mScore = 0;
    }

    /**
     * Returns the id of the player.
     * @return
     */
    public int getID(){
        return mID;
    }

    /**
     * Returns the name of the player.
     * @return
     */
    public String getName(){
        return mName;
    }

    /**
     * Sets the score for the player to the parsed value;
     * @param score
     */
    public void setScore(int score){
        mScore = score;
    }

    @Override
    public int compareTo(@NonNull Player o) {
        return o.getScore() - mScore;
    }
}
