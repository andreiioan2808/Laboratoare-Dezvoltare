package com.example.laborator4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butonAdaugare= (Button) findViewById(R.id.btnAdd);
        Button butonScadere= (Button) findViewById(R.id.btnSubstr);
        Button butonInmultire= (Button) findViewById(R.id.btnMult);
        Button butonImpartire= (Button) findViewById(R.id.btnDiv);

        EditText input1=(EditText)findViewById(R.id.editTextVal1);
        EditText input2=(EditText)findViewById(R.id.editTextVal2);
        TextView textView=(TextView)findViewById(R.id.textViewRezultat);
        butonAdaugare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double val1=Double.parseDouble(input1.getText().toString());
                double val2=Double.parseDouble(input2.getText().toString());
                textView.setText(" "+(val1+val2));
            }
        });
        butonScadere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double val1=Double.parseDouble(input1.getText().toString());
                double val2=Double.parseDouble(input2.getText().toString());
                textView.setText(" "+(val1-val2));
            }
        });
        butonInmultire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double val1=Double.parseDouble(input1.getText().toString());
                double val2=Double.parseDouble(input2.getText().toString());
                textView.setText(" "+(val1*val2));
            }
        });
        butonImpartire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double val1=Double.parseDouble(input1.getText().toString());
                double val2=Double.parseDouble(input2.getText().toString());
                if(val2==0){
                    Toast.makeText(getApplicationContext(),"Nu este posibila impartirea la 0",Toast.LENGTH_LONG).show();
                    textView.setText("Eroare!");
                } else {
                    textView.setText(" " + (val1 / val2));
                }
            }
        });
    }
    public void adaugare(){

    }
}