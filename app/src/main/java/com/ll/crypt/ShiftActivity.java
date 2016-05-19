package com.ll.crypt;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
/**
 * Created by Liz on 5/9/16.
 */
public class ShiftActivity extends AppCompatActivity
{
    private Button encryptText;
    private Button decryptText;
    private EditText input;
    private EditText shiftKey;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shift);
        init();
    }

    private void init()
    {
        encryptText=(Button) findViewById(R.id.encrypt);
        decryptText=(Button) findViewById(R.id.decrypt);
        input = (EditText) findViewById(R.id.input);
        shiftKey = (EditText) findViewById(R.id.key);
        output = (TextView) findViewById(R.id.output);
    }

    private void OnClick(View view)
    {
        String txt = input.getText().toString();
        String inputkey = shiftKey.getText().toString();
        int key = Integer.parseInt(inputkey);
        Shift shift = new Shift();
        switch(view.getId())
        {
            case R.id.encrypt:
                String result1 = shift.encrypt(txt, key);
                output.setText(result1);

                break;
            case R.id.decrypt:
                String result2 = shift.decrypt(txt, key);
                output.setText(result2);
                break;
        }
    }

    private void encrypt(View view)
    {
        String txt = input.getText().toString();
        String inputkey = shiftKey.getText().toString();
        int key = Integer.parseInt(inputkey);
        Shift shift = new Shift();
        String result = shift.encrypt(txt, key);
        output.setText(result);
    }

    private void decrypt(View view)
    {
        String txt = input.getText().toString();
        String inputkey = shiftKey.getText().toString();
        int key = Integer.parseInt(inputkey);
        Shift shift = new Shift();
        String result = shift.decrypt(txt, key);
        output.setText(result);
    }

    private void attack(View view)
    {
        String txt = input.getText().toString();
        String inputkey = shiftKey.getText().toString();
        int key = Integer.parseInt(inputkey);
        Shift shift = new Shift();
        String result = shift.attack(txt, key);
        output.setText(result);
    }
}
