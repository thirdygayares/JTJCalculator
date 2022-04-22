package com.example.jcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView solutionView;
    TextView resultsView;

    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews(){
        solutionView = (TextView)findViewById(R.id.solution);
        resultsView = (TextView)findViewById(R.id.result);
    }

    private void setWorkings(String givenValue){
        workings = workings + givenValue;
        solutionView.setText(workings);
    }

    public void equal(View view) {
       Double myResult = null;


        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            myResult = (double) engine.eval(workings);
        } catch(ScriptException e){
            Toast.makeText(this,"Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(myResult != null)
            resultsView.setText(String.valueOf(myResult.doubleValue()));





    }

    public void powerOff(View view) {
        resultsView.setText("");
        workings = "";
        solutionView.setText("");
    }

    public void clearOne(View view) {
        resultsView.setText("");

    }

    public void clearAll(View view) {
        resultsView.setText("");
        workings = "";
        solutionView.setText("");
    }

    public void erase(View view) {
        String str = solutionView.getText().toString().trim();


        if(str.length()!=0){
            str  = str.substring( 0, str.length() - 1 );

            solutionView.setText ( str );
        }


        String str2 = workings;

        if(str2.length()!=0){
            str2  = str2.substring( 0, str2.length() - 1 );

            workings =str2 ;
        }

    }

    public void decimal(View view) {
        setWorkings(".");
    }

    public void zero(View view) {
        setWorkings("0");
    }

    public void negative(View view) {
        double temp = Double.parseDouble(workings);
        temp *=-1;
        workings = String.valueOf(temp);
        solutionView.setText ( workings );
    }

    public void sum(View view) {
        setWorkings("+");
    }

    public void three(View view) {
        setWorkings("3");
    }

    public void two(View view) {
        setWorkings("2");
    }

    public void one(View view) {
        setWorkings("1");
    }

    public void minus(View view) {
        setWorkings("-");
    }

    public void six(View view) {
        setWorkings("6");
    }

    public void five(View view) {
        setWorkings("5");
    }

    public void four(View view) {
        setWorkings("4");
    }

    public void product(View view) {
        setWorkings("*");
    }

    public void nine(View view) {
        setWorkings("9");
    }

    public void eight(View view) {
        setWorkings("8");
    }

    public void seven(View view) {
        setWorkings("7");
    }

    public void divide(View view) {
        setWorkings("/");
    }

    public void sqrRoot(View view) {
        double x = Double.parseDouble(workings);
       double y = (float)Math.sqrt(x);
        resultsView.setText(String.valueOf(y));

    }

    public void sqrNumber(View view) {

        double x = Double.parseDouble(workings);
        double compute = x*x*x;
        resultsView.setText(String.valueOf(compute));
    }

    public void sqr(View view) {
        double x = Double.parseDouble(workings);
        double compute = x*x;
        resultsView.setText(String.valueOf(compute));
    }
}