package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int turn;

    private ArrayList<Button> buttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        turn = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.button3));
        buttons.add(findViewById(R.id.button4));
        buttons.add(findViewById(R.id.button5));
        buttons.add(findViewById(R.id.button6));
        buttons.add(findViewById(R.id.button7));
        buttons.add(findViewById(R.id.button8));
        buttons.add(findViewById(R.id.button9));
        buttons.add(findViewById(R.id.button10));
        buttons.add(findViewById(R.id.button11));

        for (Button but : buttons) {
            but.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                setText(0);
                break;
            case R.id.button4:
                setText(1);
                break;
            case R.id.button5:
                setText(2);
                break;
            case R.id.button6:
                setText(3);
                break;
            case R.id.button7:
                setText(4);
                break;
            case R.id.button8:
                setText(5);
                break;
            case R.id.button9:
                setText(6);
                break;
            case R.id.button10:
                setText(7);
                break;
            case R.id.button11:
                setText(8);
                break;
        }
        checkWinner();
    }

    private void setText(int x) {
        if (buttons.get(x).getText().equals("")) {
            switch (turn) {
                case 0:
                    buttons.get(x).setText("X");
                    turn = 1;
                    break;
                case 1:
                    buttons.get(x).setText("O");
                    turn = 0;
                    break;
            }
        }
    }


    private void checkWinner() {
        if (!buttons.get(0).getText().equals("") && buttons.get(0).getText().equals(buttons.get(1).getText()) && buttons.get(1).getText().equals(buttons.get(2).getText()))
            checkPlayer(0);

        if (!buttons.get(3).getText().equals("") && buttons.get(3).getText().equals(buttons.get(4).getText()) && buttons.get(4).getText().equals(buttons.get(5).getText()))
            checkPlayer(3);

        if (!buttons.get(6).getText().equals("") && buttons.get(6).getText().equals(buttons.get(7).getText()) && buttons.get(7).getText().equals(buttons.get(8).getText()))
            checkPlayer(6);

        if (!buttons.get(0).getText().equals("") && buttons.get(0).getText().equals(buttons.get(3).getText()) && buttons.get(3).getText().equals(buttons.get(6).getText()))
            checkPlayer(0);

        if (!buttons.get(1).getText().equals("") && buttons.get(1).getText().equals(buttons.get(4).getText()) && buttons.get(4).getText().equals(buttons.get(7).getText()))
            checkPlayer(1);

        if (!buttons.get(2).getText().equals("") && buttons.get(2).getText().equals(buttons.get(5).getText()) && buttons.get(5).getText().equals(buttons.get(8).getText()))
            checkPlayer(2);

        if (!buttons.get(0).getText().equals("") && buttons.get(0).getText().equals(buttons.get(4).getText()) && buttons.get(4).getText().equals(buttons.get(8).getText()))
            checkPlayer(0);

        if (!buttons.get(2).getText().equals("") && buttons.get(2).getText().equals(buttons.get(4).getText()) && buttons.get(4).getText().equals(buttons.get(6).getText()))
            checkPlayer(2);
    }


    private void checkPlayer(int x) {
        TextView tt = findViewById(R.id.textView);
        if (buttons.get(x).getText().equals("X")) {
            tt.setText("Player 1 Wins!");
            disableButtons();
        }

        if (buttons.get(x).getText().equals("O")) {
            tt.setText("Player 2 Wins!");
            disableButtons();
        }
    }

    private void disableButtons() {
        for (Button but : buttons) {
            but.setClickable(false);
        }
    }


}