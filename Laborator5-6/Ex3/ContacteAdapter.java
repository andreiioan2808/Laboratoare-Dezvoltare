package com.example.laborator5ex3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContacteAdapter extends RecyclerView.Adapter<ContacteAdapter.ViewHolder> {
    Context context;
    private List<ContactDetaliat> contacts;

    private LayoutInflater inflater;

    public ContacteAdapter(Context context, List<ContactDetaliat> contacte) {
        this.context = context;
        this.contacts = contacte;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactDetaliat contact = contacts.get(position);
        holder.nume.setText(contact.getNume());
        holder.prenume.setText(contact.getPrenume());
        holder.telefon.setText(contact.getTelefon());
        holder.email.setText(contact.getEmail());
        holder.adresa.setText(contact.getAdresa());
        holder.imgBtnApelare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    String nrTelefon = contacts.get(adapterPosition).getTelefon();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + nrTelefon));
                    v.getContext().startActivity(intent);
                }
            }
        });
        holder.imgBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = contacts.get(holder.getAdapterPosition()).getEmail();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + email));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                context.startActivity(intent);
            }
        });
        holder.imgBtnModificare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                    ContactDetaliat selectedContact = contacts.get(adapterPosition);
                    Intent intent = new Intent(context, ModificareDetalii.class);
                    intent.putExtra("contact", selectedContact);
                    context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public int getItemViewType(int position) {
        return contacts.size();
    }

    public void addContact(ContactDetaliat contact) {
        contacts.add(contact);
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton imgBtnApelare, imgBtnEmail, imgBtnModificare;
        TextView nume, prenume, telefon, email, adresa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nume=itemView.findViewById(R.id.numeContactItem);
            prenume=itemView.findViewById(R.id.prenumeContactItem);
            telefon=itemView.findViewById(R.id.telefonContactItem);
            email=itemView.findViewById(R.id.emailContactItem);
            adresa=itemView.findViewById(R.id.adresaContactItem);
            imgBtnApelare = itemView.findViewById(R.id.imBtnApelare);
            imgBtnEmail=itemView.findViewById(R.id.imgBtnEmail);
            imgBtnModificare= itemView.findViewById(R.id.imgBtnModificare);
        }
    }
}

