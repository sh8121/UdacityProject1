package com.example.sboo.basketballscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Global Variable For the Score of TeamA
     */
    int scoreForTeamA = 0;

    /**
     * Global Variable For the Score of TeamB
     */
    int scoreForTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeForTeamA(View v){
        scoreForTeamA = scoreForTeamA + 3;
        displayForTeamA(scoreForTeamA);
    }

    public void addTwoForTeamA(View v){
        scoreForTeamA = scoreForTeamA + 2;
        displayForTeamA(scoreForTeamA);
    }

    public void addFreeThrowForTeamA(View v){
        scoreForTeamA = scoreForTeamA + 1;
        displayForTeamA(scoreForTeamA);
    }

    public void addThreeForTeamB(View v){
        scoreForTeamB = scoreForTeamB + 3;
        displayForTeamB(scoreForTeamB);
    }

    public void addTwoForTeamB(View v){
        scoreForTeamB = scoreForTeamB + 2;
        displayForTeamB(scoreForTeamB);
    }

    public void addFreeThrowForTeamB(View v){
        scoreForTeamB = scoreForTeamB + 1;
        displayForTeamB(scoreForTeamB);
    }

    public void resetScore(View v){
        scoreForTeamA = 0;
        scoreForTeamB = 0;
        displayForTeamA(scoreForTeamA);
        displayForTeamB(scoreForTeamB);
    }

    private void displayForTeamA(int score){
        TextView teamAScore = (TextView)findViewById(R.id.team_a_score);
        teamAScore.setText(String.valueOf(score));
    }

    private void displayForTeamB(int score){
        TextView teamBScore = (TextView)findViewById(R.id.team_b_score);
        teamBScore.setText(String.valueOf(score));
    }
}
