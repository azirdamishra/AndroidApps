package com.example.simplecalculator;
//androidx.constraintlayout.widget.ConstraintLayout

import androidx.appcompat.app.AppCompatActivity;
//import android.annotation.SuppressLint;
import android.content.Intent;
//import android.support.v4.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonDiv, buttonMul, button10, buttonAC, buttonEqual;
    EditText editingText;

    float mValueOne, mValueTwo;

    boolean Addition, Subtract, Multiplication, Division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        editingText = (EditText) findViewById(R.id.edt1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            //@SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editingText == null){
                    editingText.setText("");
                }else {
                    mValueOne = Float.parseFloat(editingText.getText() + "");
                    Addition = true;
                    editingText.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(editingText.getText() + "");
                Subtract = true;
                editingText.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(editingText.getText() + "");
                Multiplication = true;
                editingText.setText(null);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(editingText.getText() + "");
                Division = true;
                editingText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(editingText.getText() + "");

                if(Addition == true){
                    editingText.setText(mValueOne + mValueTwo + "");
                    Addition = false;
                }
                if(Subtract == true){
                    editingText.setText(mValueOne - mValueTwo + "");
                    Subtract = false;
                }

                if(Multiplication == true){
                    editingText.setText(mValueOne*mValueTwo + "");
                    Multiplication = false;
                }

                if(Division == true){
                    editingText.setText(mValueOne/mValueTwo + "");
                    Division = false;
                }
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editingText.setText(editingText.getText() + ".");
            }
        });

    }

}