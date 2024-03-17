package com.example.laborator5ex3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ContactDetaliat implements Parcelable {
    private String nume;
    private String prenume;
    private String telefon;
    private String email;
    private String adresa;

    public ContactDetaliat(String nume, String prenume, String telefon, String email, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
    }

    protected ContactDetaliat(Parcel in) {
        nume = in.readString();
        prenume = in.readString();
        telefon = in.readString();
        email = in.readString();
        adresa = in.readString();
    }

    public static final Creator<ContactDetaliat> CREATOR = new Creator<ContactDetaliat>() {
        @Override
        public ContactDetaliat createFromParcel(Parcel in) {
            return new ContactDetaliat(in);
        }

        @Override
        public ContactDetaliat[] newArray(int size) {
            return new ContactDetaliat[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(prenume);
        dest.writeString(telefon);
        dest.writeString(email);
        dest.writeString(adresa);
    }
}
