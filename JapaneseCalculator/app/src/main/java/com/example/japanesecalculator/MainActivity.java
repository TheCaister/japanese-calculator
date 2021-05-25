package com.example.japanesecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {

    //Initialising various views.
    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    private TextView txtNumber, txtPrevNumber;
    private TextView txtOperator;
    private Button btnDivide, btnMultiply, btnSubtract, btnAdd, btnEquals;
    private Button btnClear;
    private Button btnListen;

    //Number to be printed to the screen
    String number = "";
    boolean cleared = true;

    char chosenOperator = ' ';

    //Containers for the first and second operands
    int firstOperand, secondOperand;

    boolean firstOperandSelected = true;

    MediaPlayer nextSoundToBePlayed = null;
    ArrayList<MediaPlayer> soundListToBePlayed = new ArrayList<>();
    int soundListIndex = 0;

    //Method for selecting between the first and second operands.
    public void setFirstOperandSelected(boolean firstOperandSelected) {
        this.firstOperandSelected = firstOperandSelected;
        System.out.println("First operand selected: " + firstOperandSelected);
        System.out.println("First operand: " + firstOperand + "\t\tSecond operand: " + secondOperand);
    }

    //Method for selecting operators.
    public void setChosenOperator(char chosenOperator) {
        System.out.println("Selected operator: " + chosenOperator);
        this.chosenOperator = chosenOperator;
    }

    //Initialising the sound handles.
    MediaPlayer oneSoundMP, twoSoundMP, threeSoundMP, fourSoundMP, fiveSoundMP, sixSoundMP, sevenSoundMP, eightSoundMP, nineSoundMP, zeroSoundMP;
    MediaPlayer tenSoundMP, hundredSoundMP, thousandSoundMP, tenThousandSoundMP;
    MediaPlayer eightHundredSoundMP, eightThousandSoundMP, sixHundredSoundMP, threeHundredSoundMP, threeThousandSoundMP;
    MediaPlayer divideSoundMP, multiplySoundMP, subtractSoundMP, addSoundMP;
    MediaPlayer clearSoundMP;
    MediaPlayer haSoundMP, equalsSoundMP;
    MediaPlayer minusSoundMP;

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

        tenSoundMP = MediaPlayer.create(this, R.raw.ten);
        hundredSoundMP = MediaPlayer.create(this, R.raw.hyaku);
        thousandSoundMP = MediaPlayer.create(this, R.raw.thousand);
        tenThousandSoundMP = MediaPlayer.create(this, R.raw.ten_thousand);

        eightHundredSoundMP = MediaPlayer.create(this, R.raw.eight_hundred);
        eightThousandSoundMP = MediaPlayer.create(this, R.raw.eight_thoousand);
        sixHundredSoundMP = MediaPlayer.create(this, R.raw.six_hundred);
        threeHundredSoundMP = MediaPlayer.create(this, R.raw.three_hundred);
        threeThousandSoundMP = MediaPlayer.create(this, R.raw.three_thousand);

        divideSoundMP = MediaPlayer.create(this, R.raw.divide);
        multiplySoundMP = MediaPlayer.create(this, R.raw.multiply);
        subtractSoundMP = MediaPlayer.create(this, R.raw.subtract);
        addSoundMP = MediaPlayer.create(this, R.raw.add);

        clearSoundMP = MediaPlayer.create(this, R.raw.clear);

        haSoundMP = MediaPlayer.create(this, R.raw.equals);
        equalsSoundMP = MediaPlayer.create(this, R.raw.equals_formal);

        minusSoundMP = MediaPlayer.create(this, R.raw.minus);

        oneSoundMP.setOnCompletionListener(this);
        twoSoundMP.setOnCompletionListener(this);
        threeSoundMP.setOnCompletionListener(this);
        fourSoundMP.setOnCompletionListener(this);
        fiveSoundMP.setOnCompletionListener(this);
        sixSoundMP.setOnCompletionListener(this);
        sevenSoundMP.setOnCompletionListener(this);
        eightSoundMP.setOnCompletionListener(this);
        nineSoundMP.setOnCompletionListener(this);
        zeroSoundMP.setOnCompletionListener(this);

        tenSoundMP.setOnCompletionListener(this);
        hundredSoundMP.setOnCompletionListener(this);
        thousandSoundMP.setOnCompletionListener(this);
        tenThousandSoundMP.setOnCompletionListener(this);

        eightHundredSoundMP.setOnCompletionListener(this);
        eightThousandSoundMP.setOnCompletionListener(this);
        sixHundredSoundMP.setOnCompletionListener(this);
        threeHundredSoundMP.setOnCompletionListener(this);
        threeThousandSoundMP.setOnCompletionListener(this);

        haSoundMP.setOnCompletionListener(this);
        equalsSoundMP.setOnCompletionListener(this);

        minusSoundMP.setOnCompletionListener(this);

        initialiseViews();

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

        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        btnClear.setOnClickListener(this);

        btnEquals.setOnClickListener(this);

        btnListen.setOnClickListener(this);
    }

    public void initialiseViews(){
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

        txtNumber = findViewById(R.id.txtNumber);
        txtPrevNumber = findViewById(R.id.txtPrevNumber);

        txtOperator = findViewById(R.id.txtOperator);

        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnAdd = findViewById(R.id.btnAdd);

        btnClear = findViewById(R.id.btnClear);

        btnEquals = findViewById(R.id.btnEquals);

        btnListen = findViewById(R.id.btnListen);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        //Once an audio file finishes playing, if there is a "next sound" to be played, play it.
        if(nextSoundToBePlayed != null){
            System.out.println(nextSoundToBePlayed);
            //If there is stuff in the soundList to be played and the soundIndex is not at the end of the list, get the nextSound and play it.
            if(soundListToBePlayed.size() != 0 && soundListIndex != soundListToBePlayed.size()){
                nextSoundToBePlayed = soundListToBePlayed.get(soundListIndex);
                soundListIndex++;
                nextSoundToBePlayed.start();
            }
            //Otherwise, if the soundList is empty and/or the soundList is at the end of the list, clear the soundList, set the soundIndex back to 0 and set the nextSound to null.
            else{
                resetSoundList();
                nextSoundToBePlayed = null;
            }
        }
    }

    //Determines what to do when the various buttons are pressed.
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOne:
                oneSoundMP.start();
                insertNumber("1");
                break;
            case R.id.btnTwo:
                twoSoundMP.start();
                insertNumber("2");
                break;
            case R.id.btnThree:
                threeSoundMP.start();
                insertNumber("3");
                break;
            case R.id.btnFour:
                fourSoundMP.start();
                insertNumber("4");
                break;
            case R.id.btnFive:
                fiveSoundMP.start();
                insertNumber("5");
                break;
            case R.id.btnSix:
                sixSoundMP.start();
                insertNumber("6");
                break;
            case R.id.btnSeven:
                sevenSoundMP.start();
                insertNumber("7");
                break;
            case R.id.btnEight:
                eightSoundMP.start();
                insertNumber("8");
                break;
            case R.id.btnNine:
                nineSoundMP.start();
                insertNumber("9");
                break;
            case R.id.btnZero:
                zeroSoundMP.start();
                insertNumber("0");
                break;
            case R.id.btnDivide:
                System.out.println("Pressing divide button");
                divideSoundMP.start();
                setOperator('/');
                break;
            case R.id.btnMultiply:
                multiplySoundMP.start();
                setOperator('*');
                break;
            case R.id.btnSubtract:
                System.out.println("Pressing subtract button");
                subtractSoundMP.start();
                setOperator('-');
                break;
            case R.id.btnAdd:
                addSoundMP.start();
                setOperator('+');
                break;
            case R.id.btnClear:
                clearSoundMP.start();
                clear();
                break;
            case R.id.btnEquals:
                calculate();
                break;
            case R.id.btnListen:
                resetSoundList();
                readNumberOneByOne(txtNumber.getText().toString());
                break;
            default:
                break;
        }
    }

    //Method for inserting numbers into the display.
    public void insertNumber(String enteredNumber){
        //Do nothing if the number inputted is 0 and it's cleared already.
        if(cleared && enteredNumber.equals("0") || number.length() >= 8){
            return;
        }

        //Keep appending the numbers to number and then print it.
        number += enteredNumber;
        txtNumber.setText(number);

        //If the first operand is selected, convert the "number" string to an int and assign it to the first operand.
        if(firstOperandSelected){
            firstOperand = Integer.parseInt(number);
        }
        else {
            secondOperand = Integer.parseInt(number);
        }

        resetSoundList();

        //Cleared becomes false
        cleared = false;
    }

    //Method for clearing the calculator
    public void clear(){
        cleared = true;
        number = "";
        txtNumber.setText("0");
        txtPrevNumber.setText("0");
        firstOperand = 0;
        secondOperand = 0;
        setFirstOperandSelected(true);
        resetSoundList();
    }

    //Method for resetting the soundList and setting the soundIndex to 0.
    public void resetSoundList(){
        soundListToBePlayed.clear();
        soundListIndex = 0;
    }

    public void calculate(){
        //Check what operator is chosen
        switch (chosenOperator){
            //For each case, carry out the operation and print out the result.
            //Reset number.
            case '/':
                //Handling the divide by 0 case.
                if(secondOperand == 0){
                    firstOperand = 0;
                    break;
                }
                firstOperand = firstOperand / secondOperand;
                break;
            case '*':
                firstOperand = firstOperand * secondOperand;
                break;
            case '-':
                firstOperand = firstOperand - secondOperand;
                break;
            case '+':
                firstOperand = firstOperand + secondOperand;
                break;
            default:
                break;
        }
        number = Integer.toString(firstOperand);
        txtPrevNumber.setText(number);
        txtNumber.setText(number);
        number = "";
        setFirstOperandSelected(true);

        resetSoundList();
        soundListToBePlayed.add(haSoundMP);
        speakNumber(firstOperand);
        soundListToBePlayed.add(equalsSoundMP);
        playSoundList();
    }

    @SuppressLint("SetTextI18n")
    public void setOperator(char operator){
        resetSoundList();
        if(firstOperandSelected){
            txtPrevNumber.setText(Integer.toString(firstOperand));
            setFirstOperandSelected(false);
            switchOperator(operator);
        }
        else if(secondOperand == 0) {
            switchOperator(operator);
        }
        else {
            calculate();
            switchOperator(operator);
            setFirstOperandSelected(false);
        }
    }

    public void switchOperator(char operator){
        switch (operator){
            case '/':
                setChosenOperator('/');
                break;
            case '*':
                setChosenOperator('*');
                break;
            case '-':
                setChosenOperator('-');
                break;
            case '+':
                setChosenOperator('+');
                break;
            default:
                setChosenOperator(' ');
                break;
        }
        txtOperator.setText(Character.toString(operator));
        secondOperand = 0;
        number = "";
    }

    public void speakNumber(int number){
        if(number == 0){
            resetSoundList();
            soundListToBePlayed.add(zeroSoundMP);
            playSoundList();
            return;
        }
        if(number < 0){
            soundListToBePlayed.add(minusSoundMP);
        }

        int upperHalf = number / 10000;
        int lowerHalf = number % 10000;

        if(upperHalf != 0){
            speakNumberThousands(upperHalf);
            soundListToBePlayed.add(tenThousandSoundMP);
            //Say "man"
        }

        speakNumberThousands(lowerHalf);
    }

    public void speakNumberThousands(int number){
        number = Math.abs(number);
        int thousands = number / 1000;
        int hundreds = (number % 1000) / 100;
        int tens = (number % 100) / 10;
        int units = number % 10;

        System.out.println("Thousands: " + (char)thousands + "\t\tHundreds: " + hundreds + "\t\tTens: " + tens + "\t\tUnits: " + units);

        //Check if it's one thousand or three thousand
        if(thousands == 1){
            soundListToBePlayed.add(thousandSoundMP);
        }
        else if(thousands == 3){
            soundListToBePlayed.add(threeThousandSoundMP);
        }
        else if (thousands == 0){
        }
        else{
            readSingleNumber((char)(thousands + '0'));
            soundListToBePlayed.add(thousandSoundMP);
        }

        //Check if it's 100, 300, 600, 800
        if(hundreds == 1){
            soundListToBePlayed.add(hundredSoundMP);
        }
        else if (hundreds == 3){
            soundListToBePlayed.add(threeHundredSoundMP);
        }
        else if(hundreds == 6){
            soundListToBePlayed.add(sixHundredSoundMP);
        }
        else if (hundreds == 8){
            soundListToBePlayed.add(eightHundredSoundMP);
        }
        else if (hundreds == 0){}
        else{
            readSingleNumber((char)(hundreds + '0'));
            soundListToBePlayed.add(hundredSoundMP);
        }

        //Check if it's 10
        if(tens == 1){
            soundListToBePlayed.add(tenSoundMP);
        }
        else if(tens == 0){}
        else{
            readSingleNumber((char)(tens + '0'));
            soundListToBePlayed.add(tenSoundMP);
        }

        if(units == 0){}
        else{
            readSingleNumber((char)(units + '0'));
        }
    }

    public void readNumberOneByOne(String numbers){
        if(numbers.length() <= 0){
            return;
        }

        for(char number : numbers.toCharArray()){
            readSingleNumber(number);
        }

        playSoundList();
    }

    //Method for reading a single number char and then adding the appropriate MP to the soundList.
    public void readSingleNumber(char number){
        switch (number){
            case '1':
                soundListToBePlayed.add(oneSoundMP);
                break;
            case '2':
                soundListToBePlayed.add(twoSoundMP);
                break;
            case '3':
                soundListToBePlayed.add(threeSoundMP);
                break;
            case '4':
                soundListToBePlayed.add(fourSoundMP);
                break;
            case '5':
                soundListToBePlayed.add(fiveSoundMP);
                break;
            case '6':
                soundListToBePlayed.add(sixSoundMP);
                break;
            case '7':
                soundListToBePlayed.add(sevenSoundMP);
                break;
            case '8':
                soundListToBePlayed.add(eightSoundMP);
                break;
            case '9':
                soundListToBePlayed.add(nineSoundMP);
                break;
            case '0':
                soundListToBePlayed.add(zeroSoundMP);
                break;
        }
    }

    //Method for playing the sound list
    public void playSoundList(){
        if(soundListToBePlayed.size() == 0){
            return;
        }
        //If the size of the list is 1, play the first MP then clear the list.
        if(soundListToBePlayed.size() == 1){
            soundListToBePlayed.get(0).start();
            soundListToBePlayed.clear();
            return;
        }
        soundListIndex = 1;
        nextSoundToBePlayed = soundListToBePlayed.get(soundListIndex);
        soundListToBePlayed.get(0).start();
    }
}