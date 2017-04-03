package lindvedkrvang.whistscoretracker.be;

import android.util.Log;

public class TrickTable {

    private ScoreTable mScoreRegular;
    private ScoreTable mScoreVip;
    private ScoreTable mScoreStrong;
    private ScoreTable mScoreHalf;

    public TrickTable(){
    }


    /**
     * Fills the scoreTable of the parsed type with the parsed arrays.
     * @param type
     * @param positiveArr
     * @param negativeArr
     */
    public void fillScoreTable(GameType type, int[] positiveArr, int[] negativeArr){
        switch (type){
            case REGULAR:{
                mScoreRegular = new ScoreTable(positiveArr, negativeArr);
                break;
            }
            case VIP:{
                mScoreVip = new ScoreTable(positiveArr, negativeArr);
                break;
            }
            case STRONG:{
                mScoreStrong = new ScoreTable(positiveArr, negativeArr);
                break;
            }
            case HALF:{
                mScoreHalf = new ScoreTable(positiveArr, negativeArr);
                break;
            }
        }
    }

    public ScoreTable getScoreTable(GameType type){
        switch (type){
            case REGULAR:{
                return mScoreRegular;
            }
            case VIP:{
                return mScoreVip;
            }
            case STRONG:{
                return mScoreStrong;
            }
            case HALF:{
                return mScoreHalf;
            }
            default:{
                return null;
            }
        }
    }
}
