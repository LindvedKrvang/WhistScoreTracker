package lindvedkrvang.whistscoretracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PreperationActivity extends AppCompatActivity {

    private Button btnBegin;
    private Button btnBack;
    private EditText etxtPlayerOne;
    private EditText etxtPlayerTwo;
    private EditText etxtPlayerThree;
    private EditText etxtPlayerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preperation);
        setTextViews();
        setOnClickListeners();
    }

    /**
     * Sets all the textViews.
     */
    private void setTextViews(){
        etxtPlayerOne = (EditText) findViewById(R.id.txtPlayerOne);
        etxtPlayerTwo = (EditText) findViewById(R.id.txtPlayerTwo);
        etxtPlayerThree = (EditText) findViewById(R.id.txtPlayerThree);
        etxtPlayerFour = (EditText) findViewById(R.id.txtPlayerFour);
    }

    /**
     * Sets onClickListeners on the buttons.
     */
    private void setOnClickListeners(){
        btnBack = (Button) findViewById(R.id.btnPrepBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnBegin = (Button) findViewById(R.id.btnPrebBegin);
        btnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToOverViewActivity();
                finish();
            }
        });
    }

    /**
     * Goes to the OverviewActivity while parsing along the names of the players.
     */
    private void goToOverViewActivity(){
        Intent intent = new Intent(this, OverviewActivity.class);
        intent.putExtra("ONE", etxtPlayerOne.getText().toString());
        intent.putExtra("TWO", etxtPlayerTwo.getText().toString());
        intent.putExtra("THREE", etxtPlayerThree.getText().toString());
        intent.putExtra("FOUR", etxtPlayerFour.getText().toString());
        startActivity(intent);
    }
}
