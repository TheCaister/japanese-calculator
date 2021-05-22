package com.example.japanesecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    private TextView txtNumber, txtPrevNumber;
    private TextView txtOperator;
    private Button btnDivide, btnMultiply, btnSubtract, btnAdd, btnEquals;
    private Button btnClear;


    //Number to be printed to the screen
    String number = "";
    boolean cleared = true;

    public void setChosenOperator(char chosenOperator) {
        System.out.println("Selected operator: " + chosenOperator);
        this.chosenOperator = chosenOperator;
    }

    char chosenOperator = ' ';

    //Containers for the first and second operands
    int firstOperand, secondOperand;

    boolean firstOperandSelected = true;

    public void setFirstOperandSelected(boolean firstOperandSelected) {
        this.firstOperandSelected = firstOperandSelected;
        System.out.println("First operand selected: " + firstOperandSelected);
        System.out.println("First operand: " + firstOperand + "\t\tSecond operand: " + secondOperand);
    }

    MediaPlayer oneSoundMP, twoSoundMP, threeSoundMP, fourSoundMP, fiveSoundMP, sixSoundMP, sevenSoundMP, eightSoundMP, nineSoundMP, zeroSoundMP;
    MediaPlayer divideSoundMP, multiplySoundMP, subtractSoundMP, addSoundMP;
    MediaPlayer clearSoundMP;

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

        divideSoundMP = MediaPlayer.create(this, R.raw.divide);
        multiplySoundMP = MediaPlayer.create(this, R.raw.multiply);
        subtractSoundMP = MediaPlayer.create(this, R.raw.subtract);
        addSoundMP = MediaPlayer.create(this, R.raw.add);

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

        divideSoundMP.setNextMediaPlayer(subtractSoundMP);
    }

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
                divideSoundMP.start();
                setOperator('/');
                break;
            case R.id.btnMultiply:
                multiplySoundMP.start();
                setOperator('*');
                break;
            case R.id.btnSubtract:
                subtractSoundMP.start();
                setOperator('-');
                break;
            case R.id.btnAdd:
                addSoundMP.start();
                setOperator('+');
                break;
            case R.id.btnClear:
                clear();
                break;
            case R.id.btnEquals:
                calculate();
                break;
            default:
                break;
        }
    }

    public void insertNumber(String enteredNumber){
        //Do nothing if the number inputted is 0 and it's cleared already
        if(cleared && enteredNumber.equals("0") || number.length() > 8){
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

        //Cleared becomes false
        cleared = false;
    }

    //Method for clearing the calculator
    public void clear(){
        cleared = true;
        number = "";
        txtNumber.setText("0");
        firstOperand = 0;
        secondOperand = 0;
        setFirstOperandSelected(true);
    }

    public void calculate(){
            //Check what operator is chosen
            switch (chosenOperator){
                //For each case, carry out the operation and print out the result.
                //Reset number.
                case '/':
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
    }

    public void setOperator(char operator){
        if(firstOperandSelected){
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
}