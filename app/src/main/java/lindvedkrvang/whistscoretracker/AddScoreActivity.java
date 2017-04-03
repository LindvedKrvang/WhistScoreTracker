package lindvedkrvang.whistscoretracker;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import lindvedkrvang.whistscoretracker.be.GameType;
import lindvedkrvang.whistscoretracker.be.Player;
import lindvedkrvang.whistscoretracker.be.Sticks;
import lindvedkrvang.whistscoretracker.bll.MathManager;
import lindvedkrvang.whistscoretracker.model.PlayerModel;
import lindvedkrvang.whistscoretracker.model.ScoreModel;

import static lindvedkrvang.whistscoretracker.be.GameType.*;
import static lindvedkrvang.whistscoretracker.be.Sticks.*;


public class AddScoreActivity extends AppCompatActivity {

    private Button btnCalculate;
    private Button btnBack;

    private Spinner spnCall;
    private Spinner spnSticks;
    private Spinner spnCaller;
    private Spinner spnPartner;

    private EditText txtSticksAchieved;

    private PlayerModel mPlayerModel;
    private ScoreModel mScoreModel;
    private MathManager mMathManager;

    private int[] mBoundForSticksAchievable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_score);
        mPlayerModel = PlayerModel.getInstance();
        mScoreModel = new ScoreModel();
        mMathManager = new MathManager();
        instantiateSpinners();
        addAdaptersToSpinners();
        setOnClickListeners();
    }

    /**
     * Set onClickListeners on the buttons.
     */
    private void setOnClickListeners(){
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCalculateButton();
            }
        });

        btnBack = (Button) findViewById(R.id.btnScoreBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void handleCalculateButton(){
        Sticks stickToGet = (Sticks) spnSticks.getSelectedItem();
        String sticksGotten = txtSticksAchieved.getText().toString();
        String nameCaller = (String) spnCaller.getSelectedItem();
        String namePartner = (String) spnPartner.getSelectedItem();
        boolean callerIsPartner = (nameCaller.equals(namePartner));

        mBoundForSticksAchievable = mMathManager.getBoundForSticksAchievable(stickToGet);

        if(mMathManager.isValidNumber(sticksGotten, mBoundForSticksAchievable)){
            int pointsToBeGiven = mMathManager.getPointsToBeGiven(stickToGet,
                    (GameType) spnCall.getSelectedItem(), Integer.parseInt(sticksGotten));
            ArrayList<Player> list = mPlayerModel.getSortedPlayers(nameCaller, namePartner);
            if(Integer.parseInt(sticksGotten) >= 0){
                assignPointsToPlayersWhereCallerWon(list, pointsToBeGiven, callerIsPartner);
            }else{
                assignPointsToPlayersWhereCallerLost(list, pointsToBeGiven, callerIsPartner);
            }
            finish();
        }else{
            createWrongNumberDialog();
        }
    }

    /**
     * Assign points according to the rules as the caller won.
     * @param list
     * @param points
     * @param callerIsPartner
     */
    private void assignPointsToPlayersWhereCallerWon(ArrayList<Player> list, int points, boolean callerIsPartner){
        if(callerIsPartner){
            list.get(0).addPoints(points);
            int pointsForLosers = points/3;
            list.get(1).substractPoints(pointsForLosers);
            list.get(2).substractPoints(pointsForLosers);
            list.get(3).substractPoints(pointsForLosers);
        }else{
            list.get(0).addPoints(points);
            list.get(1).addPoints(points);
            list.get(2).substractPoints(points);
            list.get(3).substractPoints(points);
        }
    }

    /**
     * Assign points according to the rules as the caller lost.
     * @param list
     * @param points
     * @param callerIsPartner
     */
    private void assignPointsToPlayersWhereCallerLost(ArrayList<Player> list, int points, boolean callerIsPartner){
        if(callerIsPartner){
            list.get(0).substractPoints(points);
            int pointsForWinners = points/3;
            list.get(1).addPoints(pointsForWinners);
            list.get(2).addPoints(pointsForWinners);
            list.get(3).addPoints(pointsForWinners);
        }else{
            list.get(0).substractPoints(points);
            list.get(1).substractPoints(points);
            list.get(2).addPoints(points);
            list.get(3).addPoints(points);
        }
    }

    /**
     * Instantiate all the spinners.
     */
    private void instantiateSpinners(){
        spnCall = (Spinner) findViewById(R.id.spnSelectCall);
        spnSticks = (Spinner) findViewById(R.id.spnSelectSticks);
        spnCaller = (Spinner) findViewById(R.id.spnSelectCaller);
        spnPartner = (Spinner) findViewById(R.id.spnSelectPartner);
        txtSticksAchieved = (EditText) findViewById(R.id.txtSticksAchieved);
    }

    /**
     * Adds adapters to the spinners.
     */
    private void addAdaptersToSpinners(){
        ArrayAdapter<GameType> callAdapter = new ArrayAdapter<GameType>(this,
                android.R.layout.simple_list_item_1, new GameType[]{REGULAR, VIP, STRONG, HALF});
        callAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCall.setAdapter(callAdapter);

        ArrayAdapter<Sticks> sticksAdapter = new ArrayAdapter<Sticks>(this,
                android.R.layout.simple_list_item_1, new Sticks[]{SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN});
        spnSticks.setAdapter(sticksAdapter);

        ArrayAdapter<String> callerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mPlayerModel.getPlayerNames());
        callerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCaller.setAdapter(callerAdapter);

        ArrayAdapter<String> partnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mPlayerModel.getPlayerNames());
        partnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPartner.setAdapter(partnerAdapter);
    }

    /**
     * Creates a dialog warning about an invalid number.
     */
    private void createWrongNumberDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_wrong_number);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }
}
