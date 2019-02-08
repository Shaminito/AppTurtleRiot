package com.example.a21746033.appturtleriot.javaBean;

import android.os.Parcel;
import android.os.Parcelable;

public class UsuarioPojo implements Parcelable {

    private String user;
    private String email;
    private String password;

    public UsuarioPojo() {}

    public UsuarioPojo(String user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public UsuarioPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    protected UsuarioPojo(Parcel in) {
        user = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<UsuarioPojo> CREATOR = new Creator<UsuarioPojo>() {
        @Override
        public UsuarioPojo createFromParcel(Parcel in) {
            return new UsuarioPojo(in);
        }

        @Override
        public UsuarioPojo[] newArray(int size) {
            return new UsuarioPojo[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public String getPassword() {
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
