package lindvedkrvang.whistscoretracker.bll;

import java.util.ArrayList;

import lindvedkrvang.whistscoretracker.be.Player;

public class PlayerManager {

    /**
     * Returns an ArrayList with the caller first. If there is a partner, second. And then the
     * rest in random.
     * @param nameCaller
     * @param namePartner
     * @param players
     * @return
     */
    public ArrayList<Player> getSortedPlayers(String nameCaller, String namePartner, ArrayList<Player> players){
        ArrayList<Player> list = new ArrayList<>();
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getName().equals(nameCaller)){
                list.add(players.remove(i));
            }
        }
        if(!nameCaller.equals(namePartner)){
            for (int i = 0; i < players.size(); i++) {
                if(players.get(i).getName().equals(namePartner)){
                    list.add(players.remove(i));
                }
            }
        }
        for(Player player : players){
            list.add(player);
        }
        return list;
    }
}
