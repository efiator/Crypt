package com.ll.crypt;

/**
 * Created by Liz on 5/5/16.
 */
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class AffineActivity extends AppCompatActivity
{
    private Button btnEcnrypt;
    private Button btnDecrypt;
    private TextView outputTxt;
    private EditText inputTxt;
    private Spinner spinner1;
    private Spinner spinner2;
    private int a, b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afine);

        // Spinner element
        spinner1 = (Spinner) findViewById(R.id.a);
        spinner2 = (Spinner) findViewById(R.id.b);
        // Spinner click listener
       // spinner1.setOnItemSelectedListener(this);
               // On selecting a spinner item

       // spinner2.setOnItemSelectedListener(this);
        // On selecting a spinner item


        // Spinner Drop down elements
        List<Integer> aValues = new ArrayList<Integer>();
       for(int i=1; i<27;i++)
       {
           if(i%26 !=0)
           {
               aValues.add(i);
           }
       }
        // Spinner click listener

        // Spinner Drop down elements
        List<Integer> bValues = new ArrayList<Integer>();
        for(int i=1; i<27;i++)
        {
                bValues.add(i);
        }
        a= (int) spinner1.getSelectedItem();
        // Showing selected spinner item
        Toast.makeText(spinner1.getContext(), "Selected: " + a, Toast.LENGTH_LONG).show();
        b= (int) spinner2.getSelectedItem();
        // Showing selected spinner item
        Toast.makeText(spinner2.getContext(), "Selected: " + b, Toast.LENGTH_LONG).show();


        // Creating adapter for spinner
        ArrayAdapter<Integer> dataAdapter1 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, aValues);
        ArrayAdapter<Integer> dataAdapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, bValues);
        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter1);
        spinner2.setAdapter(dataAdapter2);


    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private void init()
    {
        inputTxt = (EditText) findViewById(R.id.input);
        outputTxt = (TextView) findViewById(R.id.output);

        btnDecrypt = (Button) findViewById(R.id.decrypt);
        btnEcnrypt = (Button) findViewById(R.id.encrypt);

        btnDecrypt.setOnClickListener((View.OnClickListener) this);
        btnEcnrypt.setOnClickListener((View.OnClickListener) this);
    }

    private void OnClick(View view)
    {
        String txt = inputTxt.getText().toString();
        AffineCipher affine = new AffineCipher();
        switch(view.getId())
        {
            case R.id.encrypt:
                String result1 = affine.encrypt(a,b,txt);
                outputTxt.setText(result1);

                break;
            case R.id.decrypt:
                String result2 = affine.decrypt(a,b,txt);
                outputTxt.setText(result2);
                break;
        }

    }

    private void encrypt(View view)
    {

    }
}


