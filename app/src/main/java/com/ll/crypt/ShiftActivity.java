package com.ll.crypt;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

/*
*Author: Elizabeth Fiator
* Version: June 5, 2016
* Description: This is the activity class that calls the proper
* methods when a user clicks on a button.
 */
public class ShiftActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);
    }

    //This method calls the encryption method from the Shift class
    //for encryption. The method is called when a user clicks on the
    //encrypt method. The output is displayed using an alert box.
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
    //This method calls the decryption method from the Shift class
    //for decryption. The method is called when a user clicks on the
    //decrypt method. The output is displayed using an alert box.
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
