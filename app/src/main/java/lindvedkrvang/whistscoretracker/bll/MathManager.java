package lindvedkrvang.whistscoretracker.bll;

import lindvedkrvang.whistscoretracker.be.GameType;
import lindvedkrvang.whistscoretracker.be.Sticks;
import lindvedkrvang.whistscoretracker.model.ScoreModel;

import static lindvedkrvang.whistscoretracker.be.Sticks.*;

public class MathManager {

    private ScoreModel mScoreModel;

    public MathManager(){
        mScoreModel = new ScoreModel();
    }

    /**
     * Returns the bounds for which sticks is achievable given the enum Stick chosen.
     * @param sticksToGet
     * @return
     */
    public int[] getBoundForSticksAchievable(Sticks sticksToGet){
        switch (sticksToGet){
            case SEVEN:
                return new int[]{6,-7};
            case EIGHT:
                return new int[]{5,-8};
            case NINE:
                return new int[]{4,-9};
            case TEN:
                return new int[]{3,-10};
            case ELEVEN:
                return new int[]{2,-11};
            case TWELVE:
                return new int[]{1,-12};
            case THIRTEEN:
                return new int[]{0,-13};
            default:
                return new int[]{10,-10};
        }
    }

    /**
     * Checks if the parsed string is a valid number and within the bound.
     * @param numberAsString
     * @param bound
     * @return
     */
    public boolean isValidNumber(String numberAsString, int[] bound){
        try{
            int number = Integer.parseInt(numberAsString);
            if(number <= bound[0] && number >= bound[1]){
                return true;
            }
        }catch (NumberFormatException nfe){

        }
        return false;
    }

    /**
     * Returns the points to be given.
     * @param sticksToGet
     * @param type
     * @param sticksGotten
     * @return
     */
    public int getPointsToBeGiven(Sticks sticksToGet, GameType type, int sticksGotten){
        if(type == GameType.SUN){
            return mScoreModel.getSunPoints(sticksToGet);
        }
        else if(sticksGotten >= 0){
            return mScoreModel.getTrickTable(sticksToGet).getScoreTable(type).getPositiveScore()[sticksGotten];
        }else{
            return mScoreModel.getTrickTable(sticksToGet).getScoreTable(type).getNegativeScore()[Math.abs(sticksGotten)];
        }
    }
}
