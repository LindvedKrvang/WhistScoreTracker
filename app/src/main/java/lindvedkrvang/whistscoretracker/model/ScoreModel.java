package lindvedkrvang.whistscoretracker.model;

import android.util.Log;

import lindvedkrvang.whistscoretracker.be.Sticks;
import lindvedkrvang.whistscoretracker.be.TrickTable;
import lindvedkrvang.whistscoretracker.bll.TrickTableCreationManager;

public class ScoreModel {

    private final TrickTableCreationManager mTrickTableCreationManager = new TrickTableCreationManager();

    private TrickTable mTableSeven;
    private TrickTable mTableEigth;
    private TrickTable mTableNine;
    private TrickTable mTableTen;
    private TrickTable mTableEleven;
    private TrickTable mTableTwelve;
    private TrickTable mTableThirteen;

    public ScoreModel(){
        TrickTable[] table = mTrickTableCreationManager.createTrickTables();
        mTableSeven = table[0];
        mTableEigth = table[1];
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
                return mTableEigth;
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
        }
        return null;
    }
}
