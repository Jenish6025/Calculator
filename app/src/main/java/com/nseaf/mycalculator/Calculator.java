package com.nseaf.mycalculator;

import android.content.Context;
import android.widget.Toast;

public class Calculator {
    String numberString="0";
    String detailsString="";
    long intNumber;
    double realNumber;
    boolean isIntNumber=true;
    boolean numHasRadixPoint=false;
    long memoryInt=0;
    double memoryDouble=0.0;
    boolean isIntMemory=true;
    long ans;

    public Calculator() {
    }

    public void processNumber(int i) {
        if(numberString.length()<12) {  // limit of 12 digits
//            intNumber = intNumber * 10 + i;
            numberString = String.valueOf(i);
            detailsString = "Clicked: "+i;



        }
        else
            detailsString="The number is too long..";
    }

    public void clearClicked() {
        numberString="0";
        detailsString="";
        intNumber=0;
        realNumber=0.0;
        isIntNumber=true;
        numHasRadixPoint=false;
    }


    public long btnEqual(long op1,long op2, String operation) {
        switch (operation) {
            case "+":
                return ans=op1+op2;
            case "-":
                return ans=op1-op2;
            case "*":
                return ans=op1*op2;
            case "/":
                return ans=op1/op2;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
    }

    public void memPlusClicked() {
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
    }

    public void memMinusClicked() {
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
    }

    public void memRecallClicked() {
        if(isIntMemory){
            if(isIntNumber) {
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt + realNumber;
            }
        }
    }

    public void memClearClicked() {
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
    }


}
