package lindvedkrvang.whistscoretracker.be;

import android.util.Log;

public class ScoreTable {

    private int[] mPositiveScore;
    private int[] mNegativeScore;

    public ScoreTable(int[] positiveArr, int[] negativeArr) {
        mPositiveScore = positiveArr;
        mNegativeScore = negativeArr;
    }

    /**
     * Returns an array containing the positive scores.
     * @return
     */
    public int[] getPositiveScore(){
        return mPositiveScore;
    }

    /**
     * Returns an array containing the negative scores.
     * @return
     */
    public int[] getNegativeScore(){
        return mNegativeScore;
    }
}
