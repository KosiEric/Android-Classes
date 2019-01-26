package com.snoott.android6;

public class Profile  {

    private String name , description;
    private  Integer image;


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getImage() {
        return image;
    }


    public Profile (){}

    public Profile (String name , String description , Integer image)
    {
        this.name = name;
        this.description = description;
        this.image = image;

    }
}
