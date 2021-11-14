package tn.esprit.recapappall.entity;

public class Country {

    private int id ;
    private String name;
    private int urlPicture;

    public Country() {}

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, int urlPicture) {
        this.name = name;
        this.urlPicture = urlPicture;
    }

    public Country(int id, String name, int urlPicture) {
        this.id = id;
        this.name = name;
        this.urlPicture = urlPicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(int urlPicture) {
        this.urlPicture = urlPicture;
    }
}
