package com.ll.crypt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.Context;

import java.util.Arrays;

public class SdesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdes);
    }

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

    public void onDecrypt(View view)
    {
        EditText inputTxt = (EditText) findViewById(R.id.input);
        TextView outputTxt=(TextView) findViewById(R.id.output);
        EditText skey = (EditText) findViewById(R.id.key);
        Sdes sdes= new Sdes();
        String txt = inputTxt.getText().toString();
        String key=skey.getText().toString();
        int [] result = sdes.decrypt(txt, key);
        String output= Arrays.toString(result);
        AlertDialog alert = new AlertDialog.Builder(SdesActivity.this).create();
        alert.setTitle("The decrypted text is: ");
        alert.setMessage(output);
        alert.show();
    }

}
