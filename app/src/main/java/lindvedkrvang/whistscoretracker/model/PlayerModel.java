package lindvedkrvang.whistscoretracker.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import lindvedkrvang.whistscoretracker.be.Player;
import lindvedkrvang.whistscoretracker.be.PlayerType;
import lindvedkrvang.whistscoretracker.bll.PlayerManager;

public class PlayerModel {

    private static PlayerModel instance;

    private PlayerManager mPlayerManager;

    private Player mPlayerOne;
    private Player mPlayerTwo;
    private Player mPlayerThree;
    private Player mPlayerFour;

//    private HashMap<PlayerType, Integer> mScoreFromRoundBefore;
    private Stack<HashMap<PlayerType, Integer>> mSavedScoresForUndo;

    public static PlayerModel getInstance(){
        if (instance == null){
            instance = new PlayerModel();
        }
        return instance;
    }

    public PlayerModel(){
        mPlayerManager = new PlayerManager();
//        mScoreFromRoundBefore = new HashMap<>();
        mSavedScoresForUndo = new Stack<>();
    }

    /**
     * Create four new players with the parsed names.
     * @param name
     */
    public void createPlayers(String... name){
        mPlayerOne = new Player(name[0], 1);
        mPlayerTwo = new Player(name[1], 2);
        mPlayerThree = new Player(name[2], 3);
        mPlayerFour = new Player(name[3], 4);
    }

    /**
     * Returns a player on their id.
     * @param type
     * @return
     */
    public Player getPlayer(PlayerType type){
        switch (type){
            case ONE:
                return mPlayerOne;
            case TWO:
                return mPlayerTwo;
            case THREE:
                return mPlayerThree;
            case FOUR:
                return mPlayerFour;
            default:
                return null;
        }
    }

    /**
     * Returns a List with all the Players.
     * @return
     */
    public List<Player> getPlayers(){
        List<Player> list = new ArrayList<>();
        list.add(mPlayerOne);
        list.add(mPlayerTwo);
        list.add(mPlayerThree);
        list.add(mPlayerFour);
        return list;
    }

    /**
     * Returns an arrayList of players with the caller first. The partner second, if there is a
     * partner. Then the rest.
     * @param nameCaller
     * @param namePartner
     * @return
     */
    public ArrayList<Player> getSortedPlayers(String nameCaller, String namePartner){
        ArrayList<Player> list = new ArrayList<>();
        list.add(mPlayerOne);
        list.add(mPlayerTwo);
        list.add(mPlayerThree);
        list.add(mPlayerFour);
        return mPlayerManager.getSortedPlayers(nameCaller, namePartner, list);
    }

    /**
     * Returns an array of Strings containing the names of the players.
     * @return
     */
    public String[] getPlayerNames(){
        return new String[]{mPlayerOne.getName(), mPlayerTwo.getName(), mPlayerThree.getName(), mPlayerFour.getName()};
    }

    /**
     * Saves the current score of the players, so it can be retrieved later.
     */
    public void saveFormerRoundScore(){
        HashMap<PlayerType, Integer> lastRoundScores = new HashMap<>();
        lastRoundScores.put(PlayerType.ONE, mPlayerOne.getScore());
        lastRoundScores.put(PlayerType.TWO, mPlayerTwo.getScore());
        lastRoundScores.put(PlayerType.THREE, mPlayerThree.getScore());
        lastRoundScores.put(PlayerType.FOUR, mPlayerFour.getScore());
        mSavedScoresForUndo.push(lastRoundScores);
    }

    /**
     * Returns a HashMap containing the at the last round from each player.
     * Throws a nullPointerException if there is no data to retrieve.
     * @return
     */
    public HashMap<PlayerType, Integer> getUndoScore(){
        if(mSavedScoresForUndo.isEmpty())
            throw new NullPointerException("Not possible to undo. The stack is empty!");
        return mSavedScoresForUndo.pop();
    }

    /**
     * Sets the score of the players to match that of the given HashMap.
     * Throws a nullPointerException if the parsed HashMap is null.
     * @param scoreMap
     */
    public void setScore(HashMap<PlayerType, Integer> scoreMap){
        if(scoreMap == null)
            throw new NullPointerException("Not possible to undo. Need to pass a valid HashMap containing scores!");

        for (Map.Entry<PlayerType, Integer> entry: scoreMap.entrySet()) {
            switch (entry.getKey()){
                case ONE:
                    mPlayerOne.setScore(entry.getValue());
                    break;
                case TWO:
                    mPlayerTwo.setScore(entry.getValue());
                    break;
                case THREE:
                    mPlayerThree.setScore(entry.getValue());
                    break;
                case FOUR:
                    mPlayerFour.setScore(entry.getValue());
                    break;
            }
        }
    }

}
