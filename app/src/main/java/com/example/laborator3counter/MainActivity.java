package com.example.laborator3counter;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAfisare=(Button) findViewById(R.id.btnToast);
        btnAfisare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Butonul Toast a fost apasat", Toast.LENGTH_LONG).show();
            }
        });
        Button btnCounter=(Button) findViewById(R.id.btnCounter);
        TextView textViewCounter=(TextView) findViewById(R.id.textView);
        btnCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String counterTxt=textViewCounter.getText().toString();
                int counter=Integer.parseInt(counterTxt);
                counter++;
                textViewCounter.setText(String.valueOf(counter));
            }
        });

    }
}