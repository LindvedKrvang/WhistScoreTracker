package lindvedkrvang.whistscoretracker.bll;

import lindvedkrvang.whistscoretracker.be.GameType;
import lindvedkrvang.whistscoretracker.be.TrickTable;

public class TrickTableCreationManager {

    private final int AMOUNT_OF_TRICK_TABLES = 7;

    public TrickTable[] createTrickTables(){
        TrickTable[] trickTables = new TrickTable[AMOUNT_OF_TRICK_TABLES];
        trickTables[0] = createTrickTableSeven();
        trickTables[1] = createTrickTableEigth();
        trickTables[2] = createTrickTableNine();
        trickTables[3] = createTrickTableTen();
        trickTables[4] = createTrickTableEleven();
        trickTables[5] = createTrickTableTwelve();
        trickTables[6] = createTrickTableThirteen();
        return trickTables;
    }

    /**
     * Creates the trickTable with data for seven tricks.
     * @return
     */
    private TrickTable createTrickTableSeven(){
        TrickTable trickTable = new TrickTable();
        trickTable.fillScoreTable(GameType.REGULAR,
                new int[]{1,1,2,2,3,3,4},
                new int[]{1,1,2,2,3,3,4,4});
        trickTable.fillScoreTable(GameType.VIP,
                new int[]{1,1,2,3,3,4,4},
                new int[]{1,1,2,3,3,4,5,5});
        trickTable.fillScoreTable(GameType.STRONG,
                new int[]{1,2,2,3,4,5,5},
                new int[]{1,2,2,3,4,5,5,6});
        trickTable.fillScoreTable(GameType.HALF,
                new int[]{1,2,3,4,5,6,7},
                new int[]{1,2,3,4,5,6,7,8});

        return trickTable;
    }

    /**
     * Creates the trickTable with data for eight tricks.
     * @return
     */
    private TrickTable createTrickTableEigth(){
        TrickTable trickTable = new TrickTable();
        trickTable.fillScoreTable(GameType.REGULAR,
                new int[]{1,2,3,4,5,6},
                new int[]{1,2,3,4,5,6,7,8,9});
        trickTable.fillScoreTable(GameType.VIP,
                new int[]{1,3,4,5,6,8},
                new int[]{1,3,4,5,6,8,9,10,11});
        trickTable.fillScoreTable(GameType.STRONG,
                new int[]{2,3,5,6,8,9},
                new int[]{2,3,5,6,8,9,11,12,14});
        trickTable.fillScoreTable(GameType.HALF,
                new int[]{2,4,5,7,9,11},
                new int[]{2,4,5,7,9,11,12,14,16});

        return trickTable;
    }

    /**
     * Creates the trickTable with data for nine tricks.
     * @return
     */
    private TrickTable createTrickTableNine(){
        TrickTable trickTable = new TrickTable();
        trickTable.fillScoreTable(GameType.REGULAR,
                new int[]{2,4,6,8,10},
                new int[]{2,4,6,8,10,12,14,16,18,20});
        trickTable.fillScoreTable(GameType.VIP,
                new int[]{3,5,8,10,13},
                new int[]{3,5,8,10,13,15,18,20,23,25});
        trickTable.fillScoreTable(GameType.STRONG,
                new int[]{3,6,9,12,15},
                new int[]{3,6,9,12,15,18,21,24,27,30});
        trickTable.fillScoreTable(GameType.HALF,
                new int[]{4,7,11,14,18},
                new int[]{4,7,11,14,18,21,25,28,32,35});

        return trickTable;
    }

    /**
     * Creates the trickTable with data for ten tricks
     * @return
     */
    private TrickTable createTrickTableTen(){
        TrickTable trickTable = new TrickTable();
        trickTable.fillScoreTable(GameType.REGULAR,
                new int[]{4,8,12,16},
                new int[]{4,8,12,16,20,24,28,32,36,40,44});
        trickTable.fillScoreTable(GameType.VIP,
                new int[]{5,10,15,20},
                new int[]{5,10,15,20,25,30,35,40,45,50,55});
        trickTable.fillScoreTable(GameType.STRONG,
                new int[]{6,12,18,24},
                new int[]{6,12,18,24,30,36,42,48,54,60,66});
        trickTable.fillScoreTable(GameType.HALF,
                new int[]{7,14,21,28},
                new int[]{7,14,21,28,35,42,49,56,63,70,77});

        return trickTable;
    }

    /**
     * Creates the trickTable with data for eleven tricks.
     * @return
     */
    private TrickTable createTrickTableEleven(){
        TrickTable trickTable = new TrickTable();
        trickTable.fillScoreTable(GameType.REGULAR,
                new int[]{8,16,24},
                new int[]{8,16,24,32,40,48,56,64,72,80,88,96});
        trickTable.fillScoreTable(GameType.VIP,
                new int[]{10,20,30},
                new int[]{10,20,30,40,50,60,70,80,90,100,110,120});
        trickTable.fillScoreTable(GameType.STRONG,
                new int[]{12,24,36},
                new int[]{12,24,36,48,60,72,84,96,108,120,132,144});
        trickTable.fillScoreTable(GameType.HALF,
                new int[]{14,28,42},
                new int[]{14,28,42,56,70,84,98,112,126,140,154,168});

        return trickTable;
    }

    /**
     * Creates the trickTable with data for twelve tricks.
     * @return
     */
    private TrickTable createTrickTableTwelve(){
        TrickTable trickTable = new TrickTable();
        trickTable.fillScoreTable(GameType.REGULAR,
                new int[]{16,32},
                new int[]{16,32,48,64,80,96,112,128,144,160,176,192,208});
        trickTable.fillScoreTable(GameType.VIP,
                new int[]{20,40},
                new int[]{20,40,60,80,100,120,140,160,1190,200,220,240,260});
        trickTable.fillScoreTable(GameType.STRONG,
                new int[]{24,48},
                new int[]{24,48,72,96,120,144,168,192,216,240,264,288,312});
        trickTable.fillScoreTable(GameType.HALF,
                new int[]{28,56},
                new int[]{28,56,84,112,140,168,196,224,252,280,308,336,364});

        return trickTable;
    }

    /**
     * Creates the trickTable with data for thirteen tricks.
     * @return
     */
    private TrickTable createTrickTableThirteen(){
        TrickTable trickTable = new TrickTable();
        trickTable.fillScoreTable(GameType.REGULAR,
                new int[]{32},
                new int[]{32,64,96,28,160,192,224,256,288,320,352,384,416,448});
        trickTable.fillScoreTable(GameType.VIP,
                new int[]{40},
                new int[]{40,80,120,160,200,240,280,320,360,400,440,480,520,560});
        trickTable.fillScoreTable(GameType.STRONG,
                new int[]{48},
                new int[]{48,96,144,192,240,288,336,384,432,480,228,576,624,672});
        trickTable.fillScoreTable(GameType.HALF,
                new int[]{56},
                new int[]{56,112,168,224,280,336,392,448,504,560,616,672,728,784});

        return trickTable;
    }
}
