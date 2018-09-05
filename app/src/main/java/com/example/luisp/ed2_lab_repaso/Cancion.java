package com.example.luisp.ed2_lab_repaso;

public class Cancion {
    public String Name;

    public String getName() {
        return Name;
    }

    public String Artist;

    public String getArtist() {
        return Artist;
    }

    public String Duration;

    public String getDuration() {
        return Duration;
    }

    public Cancion(String aName, String aArtist, String aDuration){
        Name = aName;
        Artist = aArtist;
        Duration = aDuration;
    }
}
