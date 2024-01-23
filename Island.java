package tgl;


import java.io.Serializable;

public class Island implements Serializable{
    private String name;
    private String villainName;
    private int position;

    public Island(String name, String vilainName, int position) {
        this.name = name;
        this.villainName = vilainName;
        this.position = position;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getName() {
        return this.name;
    }

    public void setVillainName(String antagonistName) {
        this.villainName = antagonistName;
    }

    public String getVillainName() {
        return this.villainName;
    }

    public void setPosition(int placement) {
        this.position = placement;
    }

    public int getPosition() {
        return this.position;
    }
}
