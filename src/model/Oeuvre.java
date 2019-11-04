package model;

public class Oeuvre {

    private Integer id;
    private String nom;
    private String type;
    private String auteur;
    private String musee;

    public Oeuvre(Integer id, String nom, String type, String auteur, String musee) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.auteur = auteur;
        this.musee = musee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getMusee() {
        return musee;
    }

    public void setMusee(String musee) {
        this.musee = musee;
    }
}
