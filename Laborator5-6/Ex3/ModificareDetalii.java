package com.example.laborator5ex3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ModificareDetalii extends AppCompatActivity {
    private EditText numeEditText, prenumeEditText, telefonEditText, emailEditText, adresaEditText;
    private ContactDetaliat contactDetaliat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificare_detalii);

        numeEditText = findViewById(R.id.textNume);
        prenumeEditText = findViewById(R.id.textPrenume);
        telefonEditText = findViewById(R.id.textTelefon);
        emailEditText = findViewById(R.id.textEmail);
        adresaEditText = findViewById(R.id.textAdresa);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("contact")) {
            contactDetaliat = intent.getParcelableExtra("contact");
            numeEditText.setText(contactDetaliat.getNume());
            prenumeEditText.setText(contactDetaliat.getPrenume());
            telefonEditText.setText(contactDetaliat.getTelefon());
            emailEditText.setText(contactDetaliat.getEmail());
            adresaEditText.setText(contactDetaliat.getAdresa());
        }
        FloatingActionButton btnModify = findViewById(R.id.modificareFloatingBtn);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificareInfo(v);
            }
        });
    }
    public void modificareInfo(View view) {
        String nume = numeEditText.getText().toString();
        String prenume = prenumeEditText.getText().toString();
        String telefon = telefonEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String adresa = adresaEditText.getText().toString();
        contactDetaliat.setNume(nume);
        contactDetaliat.setPrenume(prenume);
        contactDetaliat.setTelefon(telefon);
        contactDetaliat.setEmail(email);
        contactDetaliat.setAdresa(adresa);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("modificare", contactDetaliat);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
