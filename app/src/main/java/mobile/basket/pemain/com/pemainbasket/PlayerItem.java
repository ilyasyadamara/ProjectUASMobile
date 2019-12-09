package mobile.basket.pemain.com.pemainbasket;

import java.io.Serializable;

public class PlayerItem  {
    public String name;
    public String team;
    public String position;
    public String poster;
    public String deskripsi;

    public PlayerItem() {

    }

    public PlayerItem(String name, String team, String position, String poster, String deskripsi) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.poster = poster;
        this.deskripsi = deskripsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {  this.deskripsi = deskripsi; }
}
