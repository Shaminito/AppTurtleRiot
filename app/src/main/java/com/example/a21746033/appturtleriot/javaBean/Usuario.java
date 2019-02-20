package com.example.a21746033.appturtleriot.javaBean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Usuario implements Parcelable {

    private String user;
    private String email;
    private String password;

    public Usuario() {}

    public Usuario(String user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }

    protected Usuario(Parcel in) {
        user = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String obtenerContrasenia() {
        return password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user);
        dest.writeString(email);
        dest.writeString(password);
    }
}
