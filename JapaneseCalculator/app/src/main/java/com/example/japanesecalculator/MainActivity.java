package com.example.japanesecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;

    MediaPlayer oneSoundMP, twoSoundMP, threeSoundMP, fourSoundMP, fiveSoundMP, sixSoundMP, sevenSoundMP, eightSoundMP, nineSoundMP, zeroSoundMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneSoundMP = MediaPlayer.create(this, R.raw.one);
        twoSoundMP = MediaPlayer.create(this, R.raw.two);
        threeSoundMP = MediaPlayer.create(this, R.raw.three);
        fourSoundMP = MediaPlayer.create(this, R.raw.four);
        fiveSoundMP = MediaPlayer.create(this, R.raw.five);
        sixSoundMP = MediaPlayer.create(this, R.raw.six);
        sevenSoundMP = MediaPlayer.create(this, R.raw.seven);
        eightSoundMP = MediaPlayer.create(this, R.raw.eight);
        nineSoundMP = MediaPlayer.create(this, R.raw.nine);
        zeroSoundMP = MediaPlayer.create(this, R.raw.zero);

        initialiseButtons();

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
    }
    public void initialiseButtons(){
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOne:
                oneSoundMP.start();
                break;
            case R.id.btnTwo:
                twoSoundMP.start();
                break;
            case R.id.btnThree:
                threeSoundMP.start();
                break;
            case R.id.btnFour:
                fourSoundMP.start();
                break;
            case R.id.btnFive:
                fiveSoundMP.start();
                break;
            case R.id.btnSix:
                sixSoundMP.start();
                break;
            case R.id.btnSeven:
                sevenSoundMP.start();
                break;
            case R.id.btnEight:
                eightSoundMP.start();
                break;
            case R.id.btnNine:
                nineSoundMP.start();
                break;
            case R.id.btnZero:
                zeroSoundMP.start();
                break;
            default:
                break;
        }
    }
}