package com.example.fall_2022;

public class ModelUser {
        //use same name as in firebase database
        String name, email, search, phone, image, uid;

    public ModelUser(String name,String email,String search,String phone,String image,String uid){
        this.image=image;
        this.email=email;
        this.search=search;
        this.phone=phone;
    //    this.image=image;
        this.name=name;
        this.uid=uid;

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public String getSearch() {
        return search;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}

