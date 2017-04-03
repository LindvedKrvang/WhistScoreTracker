package lindvedkrvang.whistscoretracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import lindvedkrvang.whistscoretracker.model.ScoreModel;

public class MainActivity extends AppCompatActivity {

    private Button mBtnBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListeners();
    }

    /**
     * Sets onClickListeners on the buttons.
     */
    private void setOnClickListeners(){
        mBtnBegin = (Button) findViewById(R.id.btnBegin);
        mBtnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPrepActivity();
            }
        });
    }

    /**
     * Goes to the PreperationActivity.
     */
    private void goToPrepActivity(){
        Intent intent = new Intent(this, PreperationActivity.class);
        startActivity(intent);
    }
}
