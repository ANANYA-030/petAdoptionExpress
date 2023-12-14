package com.example.myapplication;

public class Information {
    String age, breed,image,info,path;

    Information(){

    }
    public Information(String age,String breed,String image,String info,String path){
        this.age=age;
        this.breed=breed;
        this.image=image;
        this.info=info;
        this.path=path;
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


    public String getPath(){
        return path;
    }
    public void setPath(String image){
        this.path = path;
    }






}
