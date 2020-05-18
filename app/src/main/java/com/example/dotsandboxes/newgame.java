package com.example.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class newgame extends AppCompatActivity {
    public Game game;
    TextView p1, p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);

        p1 = (TextView) findViewById(R.id.player_1);
        p2 = (TextView) findViewById(R.id.player_2);
        p1.setText("Player 1: 0");
        p2.setText("Player 2: 0");

        game.setGameListener(new Game.GameListener() {
            @Override
            public void updateScores() {
                p1.setText("Player 1: {game.scores[0]}");
                p2.setText("Player 2: {game.scores[1]}");

            }

            @Override
            public void endGame() {
                if(game.scores[0] + game.scores[1] == (Game.size - 1)*(Game.size - 1))
                    setWinnerText();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        FrameLayout fl = findViewById(R.id.winnerContainer);
                        fl.setVisibility(View.GONE);
                        Intent i = new Intent(getApplicationContext(), Game.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        finish();
                        startActivity(i);
                    }
                }, 3000);

            }
        });
    }
    public void setWinnerText() {
        FrameLayout fl = findViewById(R.id.winnerContainer);
        fl.setVisibility(View.VISIBLE);
        TextView temp = findViewById(R.id.winner_text);
            if (game.scores[0] > game.scores[1]) temp.setText(R.string.win1);
            if (game.scores[0] < game.scores[1]) temp.setText(R.string.win2);
            if (game.scores[0] == game.scores[1]) temp.setText(R.string.draw);
        }
}
