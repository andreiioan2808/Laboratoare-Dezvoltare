package com.example.laborator5ex3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactNou extends AppCompatActivity {

    String nume, prenume, telefon, email, adresa;
    private FloatingActionButton butonAdd;
    private EditText numeEditText, prenumeEditText, telefonEditText, emailEditText, adresaEditText;
    private ImageView profilImView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact_nou);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        profilImView=findViewById(R.id.profilImagineView);
        numeEditText=findViewById(R.id.textNume);
        prenumeEditText=findViewById(R.id.textPrenume);
        telefonEditText=findViewById(R.id.textTelefon);
        emailEditText=findViewById(R.id.textEmail);
        adresaEditText=findViewById(R.id.textAdresa);
        butonAdd=findViewById(R.id.addContactFloatingBtn);
        butonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creareContact();
            }
        });
        profilImView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //selectareImagine();
            }
        });

    }
    private void creareContact(){
        nume=numeEditText.getText().toString();
        prenume=prenumeEditText.getText().toString();
        telefon=telefonEditText.getText().toString();
        email=emailEditText.getText().toString();
        adresa=adresaEditText.getText().toString();
        if(!nume.isEmpty() && !prenume.isEmpty() && !telefon.isEmpty() && !email.isEmpty() && !adresa.isEmpty()){
            Intent intent = new Intent();
            intent.putExtra("nume", nume);
            intent.putExtra("prenume", prenume);
            intent.putExtra("telefon", telefon);
            intent.putExtra("email", email);
            intent.putExtra("adresa", adresa);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}