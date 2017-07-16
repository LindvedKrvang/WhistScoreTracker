package lindvedkrvang.whistscoretracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import lindvedkrvang.whistscoretracker.be.Player;
import lindvedkrvang.whistscoretracker.model.PlayerModel;

import static lindvedkrvang.whistscoretracker.be.PlayerType.FOUR;
import static lindvedkrvang.whistscoretracker.be.PlayerType.ONE;
import static lindvedkrvang.whistscoretracker.be.PlayerType.THREE;
import static lindvedkrvang.whistscoretracker.be.PlayerType.TWO;

public class OverviewActivity extends AppCompatActivity {


    private TextView txtNameOne;
    private TextView txtNameTwo;
    private TextView txtNameThree;
    private TextView txtNameFour;

    private TextView txtScoreOne;
    private TextView txtScoreTwo;
    private TextView txtScoreThree;
    private TextView txtScoreFour;

    private Button btnAddScore;
    private Button btnMenu;
    private ImageView imgInformationIcon;
    private ImageView imgPenIcon;

    private Switch swSortByScore;

    private PlayerModel mPlayerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        mPlayerModel = PlayerModel.getInstance();
        createPlayers();
        setListeners();
        setTextViews();
        setNames();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateInformation();
    }



    private void updateInformation() {
        List<Player> players = mPlayerModel.getPlayers();
        if(swSortByScore.isChecked()){
            Collections.sort(players);
        }
        setNames(players);
        setScore(players);
    }

    /**
     * Create the players of the game.
     */
    private void createPlayers(){
        Intent intent = getIntent();
        mPlayerModel.createPlayers(intent.getStringExtra("ONE"),
                intent.getStringExtra("TWO"),
                intent.getStringExtra("THREE"),
                intent.getStringExtra("FOUR"));
    }

    private void setListeners(){
        btnAddScore = (Button) findViewById(R.id.btnAddScore);
        btnAddScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddScoreActivity();
            }
        });

        btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDataLostWarning();
            }
        });

        swSortByScore = (Switch) findViewById(R.id.swSortByScore);
        swSortByScore.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateInformation();
            }
        });

        imgInformationIcon = (ImageView) findViewById(R.id.imgInformationIcon);
        imgInformationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToScoreSchema();
            }
        });

        imgPenIcon = (ImageView) findViewById(R.id.imgPenIcon);
        imgPenIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddPointsActivity();
            }
        });
    }

    /**
     * Goes to the ScoreSchema Activity.
     */
    private void goToScoreSchema(){
        Intent intent = new Intent(this, ScoreSchema.class);
        startActivity(intent);
    }

    /**
     * Goes to the AddPointsActivity.
     */
    private void goToAddPointsActivity(){
        Intent intent = new Intent(this, AddPointsActivity.class);
        startActivity(intent);
    }

    /**
     * Creates an alertDialog that tells the user the data will be lost if he continues.
     */
    private void displayDataLostWarning(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Do nothing. Just close the dialog.
            }
        });
        builder.setMessage("Are you sure you want to go the menu? All data will be lost.");

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Intercepts the backButton when pressed and shows a warning dialog.
     */
    @Override
    public void onBackPressed(){
        displayDataLostWarning();
    }

    /**
     * Sets all the textViews.
     */
    private void setTextViews(){
        txtNameOne = (TextView) findViewById(R.id.lblNamePlayerOne);
        txtNameTwo = (TextView) findViewById(R.id.lblNamePlayerTwo);
        txtNameThree = (TextView) findViewById(R.id.lblNamePlayerThree);
        txtNameFour = (TextView) findViewById(R.id.lblNamePlayerFour);

        txtScoreOne = (TextView) findViewById(R.id.lblScorePlayerOne);
        txtScoreTwo = (TextView) findViewById(R.id.lblScorePlayerTwo);
        txtScoreThree = (TextView) findViewById(R.id.lblScorePlayerThree);
        txtScoreFour = (TextView) findViewById(R.id.lblScorePlayerFour);
    }

    /**
     * Display the names of the players.
     */
    private void setNames(){
        txtNameOne.setText(mPlayerModel.getPlayer(ONE).getName());
        txtNameTwo.setText(mPlayerModel.getPlayer(TWO).getName());
        txtNameThree.setText(mPlayerModel.getPlayer(THREE).getName());
        txtNameFour.setText(mPlayerModel.getPlayer(FOUR).getName());
    }

    /**
     * Display the names of the players in the order of the List that is parsed.
     * @param players
     */
    private void setNames(List<Player> players){
        txtNameOne.setText(players.get(0).getName());
        txtNameTwo.setText(players.get(1).getName());
        txtNameThree.setText(players.get(2).getName());
        txtNameFour.setText(players.get(3).getName());
    }

    /**
     * Sets the score in the activity in order of how the players were entered.
     */
    private void setScore(){
        txtScoreOne.setText(String.valueOf(mPlayerModel.getPlayer(ONE).getScore()));
        txtScoreTwo.setText(String.valueOf(mPlayerModel.getPlayer(TWO).getScore()));
        txtScoreThree.setText(String.valueOf(mPlayerModel.getPlayer(THREE).getScore()));
        txtScoreFour.setText(String.valueOf(mPlayerModel.getPlayer(FOUR).getScore()));
    }

    /**
     * Sets the score in the activity in the order of the parsed list.
     * @param players
     */
    private void setScore(List<Player> players){
        txtScoreOne.setText(String.valueOf(players.get(0).getScore()));
        txtScoreTwo.setText(String.valueOf(players.get(1).getScore()));
        txtScoreThree.setText(String.valueOf(players.get(2).getScore()));
        txtScoreFour.setText(String.valueOf(players.get(3).getScore()));
    }

    /**
     * Goes to the addScoreActivity.
     */
    private void goToAddScoreActivity(){
        Intent intent = new Intent(this, AddScoreActivity.class);
        startActivity(intent);
    }
}
