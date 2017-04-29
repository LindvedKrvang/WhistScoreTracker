package lindvedkrvang.whistscoretracker.model;

import java.util.ArrayList;
import java.util.List;

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

    public static PlayerModel getInstance(){
        if (instance == null){
            instance = new PlayerModel();
        }
        return instance;
    }

    public PlayerModel(){
        mPlayerManager = new PlayerManager();
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
}
