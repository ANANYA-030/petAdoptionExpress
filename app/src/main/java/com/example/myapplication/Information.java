package com.example.myapplication;

public class Information {
    String age, breed,image,info;

    Information(){

    }
    public Information(String age,String breed,String image,String info){
        this.age=age;
        this.breed=breed;
        this.image=image;
        this.info=info;

    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age = age;
    }
    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }

    public String getInfo(){
        return info;
    }
    public void setInfo(String info){
        this.info = info;
    }








}
