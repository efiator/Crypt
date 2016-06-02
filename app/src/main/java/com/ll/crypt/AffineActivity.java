package com.ll.crypt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

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
        Button encryptText =(Button) findViewById(R.id.encrypt);
        EditText inputText =(EditText) findViewById(R.id.input);
        TextView outputText = (TextView) findViewById(R.id.output);
        EditText aVal =(EditText) findViewById(R.id.a);
        EditText bVal = (EditText) findViewById(R.id.b);
        int a = Integer.parseInt(aVal.getText().toString());
        int b = Integer.parseInt(bVal.getText().toString());
        String text = inputText.getText().toString();
        String result = affine.encrypt(a,b,text);
        outputText.setText(result);
    }

    public void onDecrypt(View view)
    {
        AffineCipher affine = new AffineCipher();
        Button encryptText =(Button) findViewById(R.id.encrypt);
        EditText inputText =(EditText) findViewById(R.id.input);
        TextView outputText = (TextView) findViewById(R.id.output);
        EditText aVal =(EditText) findViewById(R.id.a);
        EditText bVal = (EditText) findViewById(R.id.b);
        int a = Integer.parseInt(aVal.getText().toString());
        int b = Integer.parseInt(bVal.getText().toString());
        String text = inputText.getText().toString();
        String result = affine.decrypt(a,b,text);
        outputText.setText(result);
    }
}
