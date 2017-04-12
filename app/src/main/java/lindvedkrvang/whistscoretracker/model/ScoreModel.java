package lindvedkrvang.whistscoretracker.model;

import lindvedkrvang.whistscoretracker.be.Sticks;
import lindvedkrvang.whistscoretracker.be.TrickTable;
import lindvedkrvang.whistscoretracker.bll.TrickTableCreationManager;

public class ScoreModel {

    private final TrickTableCreationManager mTrickTableCreationManager = new TrickTableCreationManager();

    private TrickTable mTableSeven;
    private TrickTable mTableEight;
    private TrickTable mTableNine;
    private TrickTable mTableTen;
    private TrickTable mTableEleven;
    private TrickTable mTableTwelve;
    private TrickTable mTableThirteen;
    private TrickTable mTableNormal;
    private TrickTable mTableFull;
    private TrickTable mTableHalfOpen;
    private TrickTable mFullOpen;

    public ScoreModel(){
        TrickTable[] table = mTrickTableCreationManager.createTrickTables();
        mTableSeven = table[0];
        mTableEight = table[1];
        mTableNine = table[2];
        mTableTen = table[3];
        mTableEleven = table[4];
        mTableTwelve = table[5];
        mTableThirteen = table[6];
    }

    public TrickTable getTrickTable(Sticks sticksToGet){
        switch (sticksToGet){
            case SEVEN:
                return mTableSeven;
            case EIGHT:
                return mTableEight;
            case NINE:
                return mTableNine;
            case TEN:
                return mTableTen;
            case ELEVEN:
                return mTableEleven;
            case TWELVE:
                return mTableTwelve;
            case THIRTEEN:
                return mTableThirteen;
            case NORMAL:
                break;
            case FULL:
                break;
            case HALF_OPEN:
                break;
            case FULL_OPEN:
                break;
        }
        return null;
    }

    /**
     * Returns the amount of points for the selected SUN.
     * TODO: Fix codesmell.
     * @param sticksToGet
     * @return
     */
    public int getSunPoints(Sticks sticksToGet) {
        switch (sticksToGet){
            case NORMAL:
                return 3;
            case FULL:
                return 6;
            case HALF_OPEN:
                return 12;
            case FULL_OPEN:
                return 24;
            default:
                return 0;
        }
    }
}
