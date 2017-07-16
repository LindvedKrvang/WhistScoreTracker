package lindvedkrvang.whistscoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import lindvedkrvang.whistscoretracker.be.Player;
import lindvedkrvang.whistscoretracker.model.PlayerModel;

public class AddPointsActivity extends AppCompatActivity {

    private TextView txtNameOne;
    private TextView txtNameTwo;
    private TextView txtNameThree;
    private TextView txtNameFour;

    private EditText etxtNameOne;
    private EditText etxtNameTwo;
    private EditText etxtNameThree;
    private EditText etxtNameFour;

    private Button btnAssign;
    private Button btnBack;

    private PlayerModel mPlayerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_points);
        setTextViews();
        setEditTexts();
        setListeners();
        mPlayerModel = PlayerModel.getInstance();
        setNames();
    }

    private void assignPoints(){
        List<Player> players = mPlayerModel.getPlayers();
        int pointsPlayerOne, pointsPlayerTwo, pointsPlayerThree, pointsPlayerFour;
            pointsPlayerOne = getPointsFromTextField(etxtNameOne);
            pointsPlayerTwo = getPointsFromTextField(etxtNameTwo);
            pointsPlayerThree = getPointsFromTextField(etxtNameThree);
            pointsPlayerFour = getPointsFromTextField(etxtNameFour);

            players.get(0).setScore(pointsPlayerOne);
            players.get(1).setScore(pointsPlayerTwo);
            players.get(2).setScore(pointsPlayerThree);
            players.get(3).setScore(pointsPlayerFour);

            finish();
    }


    private int getPointsFromTextField(EditText etxt){
        try{
            return Integer.parseInt(etxt.getText() + "");
        }catch (NumberFormatException nfe){
            return 0;
        }
    }

    private void setNames(){
        String[] playerNames = mPlayerModel.getPlayerNames();
        txtNameOne.setText(playerNames[0]);
        txtNameTwo.setText(playerNames[1]);
        txtNameThree.setText(playerNames[2]);
        txtNameFour.setText(playerNames[3]);
    }

    private void setListeners(){
        btnAssign = (Button) findViewById(R.id.btnAddPointsAssign);
        btnAssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignPoints();
            }
        });

        btnBack = (Button) findViewById(R.id.btnAddPointsBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setTextViews(){
        txtNameOne = (TextView) findViewById(R.id.txtAddPointsName1);
        txtNameTwo = (TextView) findViewById(R.id.txtAddPointsName2);
        txtNameThree = (TextView) findViewById(R.id.txtAddPointsName3);
        txtNameFour = (TextView) findViewById(R.id.txtAddPointsName4);
    }

    private void setEditTexts(){
        etxtNameOne = (EditText) findViewById(R.id.nbAddPointsName1);
        etxtNameTwo = (EditText) findViewById(R.id.nbAddPointsName2);
        etxtNameThree = (EditText) findViewById(R.id.nbAddPointsName3);
        etxtNameFour = (EditText) findViewById(R.id.nbAddPointsName4);
    }
}
