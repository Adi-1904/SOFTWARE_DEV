package com.example.software_dev.dataitem;

public class user {
    String Name,number,email;
    public user()
    {}

    public user(String name, String number,String email) {
        Name = name;
        this.number = number;
        this.email=email;

    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
