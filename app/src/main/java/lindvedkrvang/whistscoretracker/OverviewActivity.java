package lindvedkrvang.whistscoretracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import lindvedkrvang.whistscoretracker.be.Player;
import lindvedkrvang.whistscoretracker.be.PlayerType.*;
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

    private PlayerModel mPlayerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        mPlayerModel = PlayerModel.getInstance();
        createPlayers();
        setOnClickListeners();
        setTextViews();
        setNames();
    }

    @Override
    protected void onResume() {
        super.onResume();
            setScore();
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

    private void setOnClickListeners(){
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
                finish();
            }
        });
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
     * Sets the score in the activity.
     */
    private void setScore(){
        txtScoreOne.setText(String.valueOf(mPlayerModel.getPlayer(ONE).getScore()));
        txtScoreTwo.setText(String.valueOf(mPlayerModel.getPlayer(TWO).getScore()));
        txtScoreThree.setText(String.valueOf(mPlayerModel.getPlayer(THREE).getScore()));
        txtScoreFour.setText(String.valueOf(mPlayerModel.getPlayer(FOUR).getScore()));
    }

    /**
     * Goes to the addScoreActivity.
     */
    private void goToAddScoreActivity(){
        Intent intent = new Intent(this, AddScoreActivity.class);
        startActivity(intent);
    }
}
