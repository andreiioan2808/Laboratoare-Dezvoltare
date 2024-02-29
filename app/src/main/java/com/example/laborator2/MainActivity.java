package com.example.laborator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnTrimite);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Butonul Trimite a fost apasat", Toast.LENGTH_LONG).show();
            }
        });
        EditText inputText=(EditText)findViewById(R.id.editTextVarsta);
        Button btnSchimbaText=(Button)findViewById(R.id.btnSchimbareText);
        btnSchimbaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView view =(TextView) findViewById(R.id.textViewVarsta);
                view.setText(""+inputText.getText());
            }
        });
    }

    public void sendMessage(View view) {
        //System.out.println("bla");
    }

    public void SchimbaText(View view) {

    }
}