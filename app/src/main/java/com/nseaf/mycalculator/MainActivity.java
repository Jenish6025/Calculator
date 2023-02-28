package com.nseaf.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber;
    TextView tvDetails;
    Calculator calculator;
    private float num1, num2;
    String numberString="0";
    String detailsString="";
    long intNumber;
    double realNumber;
    boolean isIntNumber=true;
    boolean numHasRadixPoint=false;
    long memoryInt=0;
    double memoryDouble=0.0;
    boolean isIntMemory=true;
    private boolean addition, subtraction, multiplication, division,pi,percentage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        tvNumber = findViewById(R.id.tv_number);
        tvDetails = findViewById(R.id.tv_details);
    }

    public void numberClicked(View view) {
        switch (view.getId()){

            case R.id.b_addition:
                num1 = Float.parseFloat(tvNumber.getText().toString());
//                intNumber= (long) num1;
                detailsString+="+";
                addition = true;
                tvNumber.setText("");
                break;
            case R.id.b_subtract:
                num1 = Float.parseFloat(tvNumber.getText().toString());
//                intNumber= (long) num1;
                subtraction = true;
                detailsString+="-";
                tvNumber.setText("");
                break;

            case R.id.b_multiply:
                num1 = Float.parseFloat(tvNumber.getText().toString());
//                intNumber= (long) num1;
                multiplication = true;
                detailsString+="*";
                tvNumber.setText("");
                break;

            case R.id.b_div:
                num1 = Float.parseFloat(tvNumber.getText().toString());
//                intNumber= (long) num1;
                division = true;
                detailsString+="/";
                tvNumber.setText("");
                break;

            case R.id.b_pi:
                num1 = Float.parseFloat(tvNumber.getText().toString());
                pi=true;
                detailsString+="%";
                tvNumber.setText("");
                break;

            case R.id.b_e_to_x:
                num1 = Float.parseFloat(tvNumber.getText().toString());
                detailsString="Clicked: "+num1+"*"+num1;
                percentage=true;
                tvNumber.setText("");
                break;

            case R.id.b_equal:
                num2 = Float.parseFloat(tvNumber.getText().toString());

                if (addition) {
                    tvNumber.setText(String.valueOf(num1 + num2));
                    addition = false;
                }

                if (subtraction) {
                    tvNumber.setText(String.valueOf(num1 - num2));
                    subtraction = false;
                }

                if (multiplication) {
                    tvNumber.setText(String.valueOf(num1 * num2));
                    multiplication = false;
                }

                if (division) {
                    if(String.valueOf(num1/num2)=="Infinity"){
                        Toast toast=Toast. makeText(getApplicationContext(),"Cannot divide by zero",Toast. LENGTH_SHORT);
                        toast. show();
                    }
                    else{
                        tvNumber.setText(String.valueOf(num1 / num2));
                        division = false;
                    }
                }

                if(percentage){
                    tvNumber.setText(String.valueOf(Math.pow(num1,num2 )));
                    percentage = false;
                }

                if(pi){
                    tvNumber.setText(String.valueOf(num1%num2));
                    pi=false;
                }

                break;

            case R.id.b_clear:
                numberString="0";
                detailsString="";
                intNumber=0;
                realNumber=0.0;
                isIntNumber=true;
                numHasRadixPoint=false;
                tvNumber.setText("");
                tvDetails.setText("");
                break;

            case R.id.b_0: processNumber(0); break;
            case R.id.b_1: processNumber(1); break;
            case R.id.b_2: processNumber(2); break;
            case R.id.b_3: processNumber(3); break;
            case R.id.b_4: processNumber(4); break;
            case R.id.b_5: processNumber(5); break;
            case R.id.b_6: processNumber(6); break;
            case R.id.b_7: processNumber(7); break;
            case R.id.b_8: processNumber(8); break;
            case R.id.b_9: processNumber(9); break;

            default:
                break;

        }
    }

    public void processNumber(int i) {
        if(numberString.length()<12) {  // limit of 12 digits
            intNumber = intNumber + i;
            tvNumber.setText(tvNumber.getText().toString()+i);
            numberString += String.valueOf(i);

            if(detailsString=="")
                detailsString = "Clicked: "+i;
            else
                detailsString+=i;
            tvDetails.setText(detailsString);

        }
        else
            detailsString="The number is too long..";
    }



    private void updateCalcUI() {
        tvNumber.setText(numberString);
        tvDetails.setText(detailsString);
    }

    public void memPlusClicked(View view) {
        if(isIntMemory){
            if(isIntNumber) {
                memoryInt += intNumber;
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt + realNumber;
            }
        }
//        updateCalcUI();
        tvDetails.setText(detailsString);
    }

    public void memMinusClicked(View view) {
        if(isIntMemory){
            if(isIntNumber) {
                memoryInt -= intNumber;
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt + realNumber;
            }
        }
//        updateCalcUI();
        tvDetails.setText(detailsString);
    }

    public void memRecallClicked(View view) {
        if(isIntMemory){
            if(isIntNumber) {
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt + realNumber;
            }
        }
//        updateCalcUI();
        tvDetails.setText(detailsString);
    }

    public void memClearClicked(View view) {
        if(isIntMemory){
            if(isIntNumber) {
                memoryInt = 0;
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt + realNumber;
            }
        }
//        updateCalcUI();
        tvDetails.setText(detailsString);
    }
}