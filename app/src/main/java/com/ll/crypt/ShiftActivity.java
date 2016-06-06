package com.ll.crypt;

import android.app.AlertDialog;
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
        EditText shiftKey = (EditText) findViewById(R.id.key);
        Shift shift= new Shift();
        String txt = inputTxt.getText().toString();
        String inputKey = shiftKey.getText().toString();
        int key=Integer.parseInt(inputKey);
        String result = shift.encrypt(txt,key);
        AlertDialog alert = new AlertDialog.Builder(ShiftActivity.this).create();
        alert.setTitle("The encrypted text is: ");
        alert.setMessage(result);
        alert.show();
    }

    public void onDecrypt(View view)
    {
        EditText inputTxt = (EditText) findViewById(R.id.input);
        EditText shiftKey = (EditText) findViewById(R.id.key);
        Shift shift= new Shift();
        String txt = inputTxt.getText().toString();
        int key=Integer.parseInt(shiftKey.getText().toString());
        String result = shift.decrypt(txt, key);
        AlertDialog alert = new AlertDialog.Builder(ShiftActivity.this).create();
        alert.setTitle("The decrypted text is: ");
        alert.setMessage(result);
        alert.show();

    }


}
