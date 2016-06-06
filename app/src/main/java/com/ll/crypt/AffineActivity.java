package com.ll.crypt;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

import java.util.Arrays;

public class AffineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affine);
    }

    public void onEncrypt(View view)
    {
        AffineCipher affine = new AffineCipher();
        EditText inputText =(EditText) findViewById(R.id.input);
        EditText aVal =(EditText) findViewById(R.id.a);
        EditText bVal = (EditText) findViewById(R.id.b);
        int a = Integer.parseInt(aVal.getText().toString());
        int b = Integer.parseInt(bVal.getText().toString());
        String text = inputText.getText().toString();
        String result = affine.encrypt(a, b, text);
        AlertDialog alert = new AlertDialog.Builder(AffineActivity.this).create();
        alert.setTitle("The encrypted text is: ");
        alert.setMessage(result);
        alert.show();
    }

    public void onDecrypt(View view)
    {
        AffineCipher affine = new AffineCipher();
        EditText inputText =(EditText) findViewById(R.id.input);
        EditText aVal =(EditText) findViewById(R.id.a);
        EditText bVal = (EditText) findViewById(R.id.b);
        int a = Integer.parseInt(aVal.getText().toString());
        int b = Integer.parseInt(bVal.getText().toString());
        String text = inputText.getText().toString();
        String result = affine.decrypt(a,b,text);
        AlertDialog alert = new AlertDialog.Builder(AffineActivity.this).create();
        alert.setTitle("The decrypted text is: ");
        alert.setMessage(result);
        alert.show();
    }
}
