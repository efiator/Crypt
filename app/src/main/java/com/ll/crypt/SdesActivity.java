package com.ll.crypt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.Context;
import java.util.Arrays;

/*
*Author: Elizabeth Fiator
* Version: June 5, 2016
* Description: This is the activity class that calls the proper
* methods when a user clicks on a button.
 */

public class SdesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdes);
    }

    //This method calls the encryption method from the S-des class
    //for encryption. The method is called when a user clicks on the
    //encrypt method.The output is displayed using an alert box.
    public void onEncrypt(View view)
    {
        EditText inputTxt = (EditText) findViewById(R.id.input);
        TextView outputTxt=(TextView) findViewById(R.id.output);
        EditText skey = (EditText) findViewById(R.id.key);
        Sdes sdes= new Sdes();
        String txt = inputTxt.getText().toString();
        String key=skey.getText().toString();
        int [] result = sdes.encrypt(txt, key);
        String output= Arrays.toString(result);
        AlertDialog alert = new AlertDialog.Builder(SdesActivity.this).create();
        alert.setTitle("The encrypted text is: ");
        alert.setMessage(output);
        alert.show();

    }

    //This method calls the decryption method from the S-des class
    //for decryption. The method is called when a user clicks on the
    //decrypt method. The output is displayed using an alert box.
    public void onDecrypt(View view)
    {
        EditText inputTxt = (EditText) findViewById(R.id.input);
        TextView outputTxt=(TextView) findViewById(R.id.output);
        EditText skey = (EditText) findViewById(R.id.key);
        Sdes sdes= new Sdes();
        String txt = inputTxt.getText().toString();
        String key=skey.getText().toString();
        int [] result = sdes.decrypt(txt, key);
        String output = Arrays.toString(result);
        AlertDialog alert = new AlertDialog.Builder(SdesActivity.this).create();
        alert.setTitle("The decrypted text is: ");
        alert.setMessage(output);
        alert.show();
    }

}
