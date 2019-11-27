package com.example.calculatorexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected double num1=0;
    protected double num2=0;
    protected double result=0;
    protected double memory=0;
    protected EditText text1;
    protected EditText text2;
    protected TextView resText;
    protected RadioButton radEven;
    protected RadioButton radOdd;
    protected Calculadora calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.calc= new Calculadora();
        this.num1=0;
        this.num2=0;
        this.result=0;
        this.memory=0;
        this.text1= (EditText) findViewById(R.id.editText);
        this.text2= (EditText) findViewById(R.id.editText2);
        this.resText=(TextView)findViewById(R.id.textView);
        this.radEven=(RadioButton) findViewById(R.id.radio1);
        this.radOdd=(RadioButton) findViewById(R.id.radio2);
    }

    public void setText1(){
        text1.setText(Double.toString(num1));
    }

    public void setText2(){
        text2.setText(Double.toString(num2));
    }

    public double getText1(){
        num1=Double.parseDouble(String.valueOf(text1.getText()));
        return num1;
    }

    public double getText2(){
        num2=Double.parseDouble(String.valueOf(text2.getText()));
        return num2;
    }

    public double getResult(){
        this.result=Double.parseDouble(String.valueOf(resText.getText()));
        return result;
    }

    public void setResult(){
        resText.setText(Double.toString(result));
    }

    public void setResultNan(){
        resText.setText("NaN");
    }

    public void setEvenOrOdd(){
        if(result%2==0){
            radEven.setChecked(true);
            radOdd.setChecked(false);
        }else{
            radOdd.setChecked(true);
            radEven.setChecked(false);
        }
    }


    public void onClickSum(View view){
        try {
            result = calc.sum(getText1(), getText2());
            setResult();
            setEvenOrOdd();
        }catch (Exception e){
            Log.d("patata", e.getMessage());
            setResultNan();
        }
        //Log.d("patata", "Fa sa suma, es: "+result);

    }
    public void onClickSub(View view){
        try {
            result = calc.sub(getText1(), getText2());
            setResult();
            setEvenOrOdd();
        }catch (Exception e){
            Log.d("patata", e.getMessage());
            setResultNan();
        }

    }
    public void onClickMul(View view){
        try {
            result = calc.mult(getText1(), getText2());
            setResult();
            setEvenOrOdd();
        }catch (Exception e){
            Log.d("patata", e.getMessage());
            setResultNan();
        }

    }
    public void onClickDiv(View view){
        try {
            result = calc.div(getText1(), getText2());
            setResult();
            setEvenOrOdd();
        }catch (Exception e){
            Log.d("patata", e.getMessage());
            setResultNan();
        }
    }

    public void onClickMemSum(View view){
        memory = calc.memorySum(getText1());
    }
    public void onClickMemSub(View view){
        memory=calc.memorySub(getText1());
    }
    public void onClickMemClear(View view){
        memory=calc.setMemory(0);
    }
    public void onClickMemGet(View view){
        memory=calc.getMemory();
        result=memory;
        setResult();
        setEvenOrOdd();
    }

}
