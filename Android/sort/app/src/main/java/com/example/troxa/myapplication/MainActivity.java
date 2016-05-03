package com.example.troxa.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int nComputer;
    private int nPlayer;
    private ImageView dicePlayer = null;
    private ImageView diceComputer = null;
    private int[] imageViews = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViews = new int[]{
            R.drawable.dado1,
            R.drawable.dado2,
            R.drawable.dado3,
            R.drawable.dado4,
            R.drawable.dado5
        };
    }

    public void play(View view) {
        Random r = new Random();
        nComputer = r.nextInt(5);
        nPlayer = r.nextInt(5);
        dicePlayer = (ImageView) findViewById(R.id.dadoJogador);
        diceComputer = (ImageView) findViewById(R.id.dadoComputador);

        diceComputer.setImageResource(imageViews[nComputer]);
        dicePlayer.setImageResource(imageViews[nPlayer]);

        showResult();
    }

    private void showResult() {
        String message;
        TextView result = (TextView) findViewById(R.id.result);

        if(nPlayer > nComputer) {
            message = getString(R.string.player_win);
        } else if(nComputer > nPlayer) {
            message = getString(R.string.computer_win);
        } else {
            message = getString(R.string.duece);
        }

        result.setText(message);
    }
}
