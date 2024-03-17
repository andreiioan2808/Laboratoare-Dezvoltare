package com.example.laborator5ex3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ContacteAdapter contactAdapter;

    List<ContactDetaliat>listaContacte;
    ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String nume = data.getStringExtra("nume");
                            String prenume = data.getStringExtra("prenume");
                            String telefon = data.getStringExtra("telefon");
                            String email = data.getStringExtra("email");
                            String adresa = data.getStringExtra("adresa");
                            ContactDetaliat newContact = new ContactDetaliat(nume, prenume, telefon, email, adresa);
                            contactAdapter.addContact(newContact);
                        }
                    }
                });

        ImageView imagineContactNou = findViewById(R.id.AdaugaContacte);
        imagineContactNou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.laborator5ex3.MainActivity.this, ContactNou.class);
                activityResultLauncher.launch(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);

        listaContacte = new ArrayList<>();
        listaContacte.add(new ContactDetaliat("Hanci","Valentin","0753527707","nume1prenume1@gmail.com","Bucuresti,..."));
        listaContacte.add(new ContactDetaliat("Matei","Daniel","0745639291","mateidaniel@yahoo.com","Hunedoara,..."));
        listaContacte.add(new ContactDetaliat("George","Valentin","0744841392","georgevalentin@yahoo.com","Iasi,...."));
        listaContacte.add(new ContactDetaliat("Moldovan","Anca","0753992102","moldovananca@yahoo.com","Suceava,..."));
        listaContacte.add(new ContactDetaliat("Vasile","Andreea","0751029344","vasileandreea@yahoo.com","Mures,..."));

        contactAdapter = new ContacteAdapter(this,listaContacte);
        recyclerView.setAdapter(contactAdapter);



    }
}