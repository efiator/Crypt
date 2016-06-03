package com.ll.crypt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

public class ShiftActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);
    }

    public void onEncrypt(View view)
    {
        EditText inputTxt = (EditText) findViewById(R.id.input);
        TextView outputTxt=(TextView) findViewById(R.id.output);
        EditText shiftKey = (EditText) findViewById(R.id.key);
        Shift shift= new Shift();
        String txt = inputTxt.getText().toString();
        String inputKey = shiftKey.getText().toString();
        int key=Integer.parseInt(inputKey);
        String result = shift.encrypt(txt,key);
        outputTxt.setText(result);

    }

    public void onDecrypt(View view)
    {
        EditText inputTxt = (EditText) findViewById(R.id.input);
        TextView outputTxt=(TextView) findViewById(R.id.output);
        EditText shiftKey = (EditText) findViewById(R.id.key);
        Shift shift= new Shift();
        String txt = inputTxt.getText().toString();
        int key=Integer.parseInt(shiftKey.getText().toString());
        String result = shift.decrypt(txt, key);
        outputTxt.setText(result);

    }


}
